package com.flyzebra.music;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;

import com.flyzebra.flyui.Flyui;
import com.flyzebra.flyui.event.FlyEvent;
import com.flyzebra.flyui.event.IFlyEvent;
import com.flyzebra.flyui.utils.ByteUtil;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.utils.SPUtil;
import com.jancar.media.base.BaseActivity;
import com.jancar.media.data.Music;
import com.jancar.media.data.StorageInfo;
import com.jancar.media.model.listener.IMusicPlayerListener;
import com.jancar.media.model.musicplayer.IMusicPlayer;
import com.jancar.media.model.musicplayer.MusicPlayer;
import com.jancar.media.utils.StringTools;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Author FlyZebra
 * 2019/3/20 10:55
 * Describ:
 **/
public class MusicActivity extends BaseActivity implements IFlyEvent, IMusicPlayerListener {
    private static final HandlerThread sWorkerThread = new HandlerThread("flyui-music");
    static {
        sWorkerThread.start();
    }
    private static final Handler tHandler = new Handler(sWorkerThread.getLooper());
    public Flyui flyui;
    protected IMusicPlayer musicPlayer = MusicPlayer.getInstance();
    public List<Music> musicList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SPUtil.set(this, "SAVA_PATH", "/storage");
        flyui = new Flyui(this);
        flyui.onCreate();
        musicPlayer.addListener(this);
    }

    @Override
    protected void onDestroy() {
        flyui.onDestroy();
        musicPlayer.removeListener(this);
        musicPlayer.destory();
        tHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    @Override
    public void notifyPathChange(String path) {
        FlyLog.d("notifyPathChange path=%s", path);
        FlyEvent.sendEvent("100402", path);
        if (isStop) return;
        if (!musicPlayer.getPlayUrl().startsWith(path)) {
            musicPlayer.destory();
        }
        musicPlayer.playSaveUrlByPath(path);
        musicList.clear();
        notifyMusicList();
        super.notifyPathChange(path);
    }

    @Override
    public void musicUrlList(List<Music> musicUrlList) {
        FlyLog.d("get player.music size=%d", musicUrlList == null ? 0 : musicUrlList.size());
        if (isStop) return;
        if (musicUrlList != null && !musicUrlList.isEmpty()) {
            musicList.addAll(musicUrlList);
            musicPlayer.setPlayUrls(musicList);
        }
        notifyMusicList();
        super.musicUrlList(musicUrlList);
    }

    @Override
    public void scanFinish(String path) {
        FlyLog.d("scanFinish path=%s", path);
        if (isStop) return;
        super.scanFinish(path);
        notifyCurrentMusic();
    }

    @Override
    public void scanServiceConneted() {
        if (isStop) return;
        String path = null;
        try {
            Intent intent = getIntent();
            path = intent.getStringExtra("device");
        } catch (Exception e) {
            FlyLog.e(e.toString());
        }
        if (!TextUtils.isEmpty(path)) {
            currenPath = path;
        }
        super.scanServiceConneted();
    }

    @Override
    public void musicID3UrlList(List<Music> musicUrlList) {
        if (isStop) return;
        if (musicUrlList == null || musicUrlList.isEmpty()) {
            return;
        }
        try {
            for (int i = 0; i < musicUrlList.size(); i++) {
                int sort = musicUrlList.get(i).sort;
                musicList.get(sort).artist = musicUrlList.get(i).artist;
                musicList.get(sort).album = musicUrlList.get(i).album;
                musicList.get(sort).name = musicUrlList.get(i).name;
            }
        } catch (Exception e) {
            FlyLog.e(e.toString());
        }
        notifyMusicList();
        notifyCurrentMusic();
        super.musicID3UrlList(musicUrlList);
    }

    @Override
    public void playStatusChange(int statu) {
        FlyLog.d("statu=%d", statu);
        switch (statu) {
            case MusicPlayer.STATUS_COMPLETED:
                break;
            case MusicPlayer.STATUS_STARTPLAY:
                notifyCurrentMusic();
                break;
            case MusicPlayer.STATUS_PLAYING:
            case MusicPlayer.STATUS_PAUSE:
                break;
        }
        byte playStauts = (musicPlayer.getPlayStatus() == MusicPlayer.STATUS_STARTPLAY
                || musicPlayer.getPlayStatus() == MusicPlayer.STATUS_PLAYING) ? (byte) 1 : (byte) 0;
        FlyEvent.sendEvent("100225", new byte[]{playStauts});
    }

    @Override
    public void loopStatusChange(int staut) {
        FlyEvent.sendEvent("100228", new byte[]{(byte) staut});
    }

    @Override
    public void playtime(long current, long total) {
        byte[] bt1 = ByteUtil.intToBytes((int) (current / 1000));
        byte[] bt2 = ByteUtil.intToBytes((int) (total / 1000));
        byte[] bt3 = new byte[bt1.length + bt2.length];
        System.arraycopy(bt1, 0, bt3, 0, bt1.length);
        System.arraycopy(bt2, 0, bt3, bt1.length, bt2.length);
        FlyEvent.sendEvent("100226", bt3);
    }

    @Override
    public void storageList(List<StorageInfo> storageList) {
        super.storageList(storageList);
        if (storageList != null) {
            FlyEvent.sendEvent("40030200", "存储器\n(" + storageList.size() + ")");
        }
        List<Map<String, Object>> list = new ArrayList<>();
        for (StorageInfo storageInfo : storageList) {
            if (TextUtils.isEmpty(storageInfo.mPath)) break;
            Map<String, Object> map = new HashMap<>();
            map.put("100403", TextUtils.isEmpty(storageInfo.mDescription) ? storageInfo.mPath : storageInfo.mDescription);
            map.put("100402", storageInfo.mPath);
            String imageKey;
            list.add(map);
        }
        FlyEvent.sendEvent("100401", list);
    }

    private void notifyCurrentMusic() {
        FlyLog.d("notifyCurrentMusic");
        try {
            final int i = musicPlayer.getPlayPos();
            if (i >= 0 && i < musicList.size()) {
                Music music = musicList.get(i);
                FlyEvent.sendEvent("100222", music.name);
                FlyEvent.sendEvent("100224", music.album);
                FlyEvent.sendEvent("100223", music.artist);
                FlyEvent.sendEvent("100221", music.url);
                notifyMp3Bitmap(music.url);
            } else {
                FlyEvent.sendEvent("100222", "");
                FlyEvent.sendEvent("100224", "");
                FlyEvent.sendEvent("100223", "");
                FlyEvent.sendEvent("100221", "");
                FlyEvent.sendEvent("100227", null);
            }
        } catch (Exception e) {
            FlyLog.e(e.toString());
        }
    }

    private void notifyMusicList() {
        long time = System.currentTimeMillis();
        FlyLog.d("notifyMusicList start");
        //单曲列表
        List<Map<String, Object>> listSingle = new ArrayList<>();
        for (Music music : musicList) {
            music.artist = TextUtils.isEmpty(music.artist) ? getString(R.string.no_artist) : music.artist;
            music.album = TextUtils.isEmpty(music.album) ? getString(R.string.no_album) : music.album;
            music.name = TextUtils.isEmpty(music.name) ? StringTools.getNameByPath(music.url) : music.name;
            Map<String, Object> map = new Hashtable<>();
            map.put("100221", music.url);
            map.put("100222", music.name);
            map.put("100223", music.artist);
            listSingle.add(map);
        }
        FlyEvent.sendEvent("40030201", "单曲\n(" + listSingle.size() + ")");
        FlyEvent.sendEvent("100229", listSingle);


        //列表分类
        Map<String, List<Music>> mArtistHashMap = new HashMap<>();
        Map<String, List<Music>> mAlbumHashMap = new HashMap<>();
        Map<String, List<Music>> mFolderHashMap = new HashMap<>();
        for (Music music : musicList) {
            if (mArtistHashMap.get(music.artist) == null) {
                mArtistHashMap.put(music.artist, new ArrayList<Music>());
            }
            mArtistHashMap.get(music.artist).add(music);
            if (mAlbumHashMap.get(music.album) == null) {
                mAlbumHashMap.put(music.album, new ArrayList<Music>());
            }
            mAlbumHashMap.get(music.album).add(music);

            String path = StringTools.getPathByPath(music.url);
            if (mFolderHashMap.get(path) == null) {
                mFolderHashMap.put(path, new ArrayList<Music>());
            }
            mFolderHashMap.get(path).add(music);
        }
        FlyEvent.sendEvent("40030202", "歌手\n(" + mArtistHashMap.size() + ")");
        FlyEvent.sendEvent("40030203", "专辑\n(" + mAlbumHashMap.size() + ")");
        FlyEvent.sendEvent("40030204", "文件夹\n(" + mFolderHashMap.size() + ")");

        //歌手列表
        List<String> artistGroupList = new ArrayList<>(mArtistHashMap.keySet());
        Collections.sort(artistGroupList, new Comparator<String>() {
            public int compare(String p1, String p2) {
                if (TextUtils.isEmpty(p1) || p1.startsWith(getString(R.string.no_album_start))) {
                    return 1;
                } else if (TextUtils.isEmpty(p2) || p2.startsWith(getString(R.string.no_album_start))) {
                    return -1;
                } else {
                    return p1.compareToIgnoreCase(p2);
                }
            }
        });
        List<Map<String, Object>> listArtist = new ArrayList<>();
        for (String key : artistGroupList) {
            List<Music> list = mArtistHashMap.get(key);
            if (list != null && !list.isEmpty()) {
                Map<String, Object> map1 = new Hashtable<>();
                map1.put("100221", list.get(0).url);
                map1.put("100222", list.get(0).name);
                map1.put("100223", list.get(0).artist);
                map1.put("10FFF1", "(" + list.size() + "首)");
                map1.put("10FF02", 0);
                listArtist.add(map1);
                for (Music music : list) {
                    Map<String, Object> map2 = new Hashtable<>();
                    map2.put("100221", music.url);
                    map2.put("100222", music.name);
                    map2.put("100223", music.artist);
                    map2.put("10FF02", 1);
                    listArtist.add(map2);
                }
            }
        }
        FlyEvent.sendEvent("100230", listArtist);

        //专辑列表
        List<String> albumGroupList = new ArrayList<>(mAlbumHashMap.keySet());
        Collections.sort(albumGroupList, new Comparator<String>() {
            public int compare(String p1, String p2) {
                if (TextUtils.isEmpty(p1) || p1.startsWith(getString(R.string.no_album_start))) {
                    return 1;
                } else if (TextUtils.isEmpty(p2) || p2.startsWith(getString(R.string.no_album_start))) {
                    return -1;
                } else {
                    return p1.compareToIgnoreCase(p2);
                }
            }
        });
        List<Map<String, Object>> listAlbum = new ArrayList<>();
        for (String key : albumGroupList) {
            List<Music> list = mAlbumHashMap.get(key);
            if (list != null && !list.isEmpty()) {
                Map<String, Object> map1 = new Hashtable<>();
                map1.put("100221", list.get(0).url);
                map1.put("100222", list.get(0).name);
                map1.put("100224", list.get(0).album);
                map1.put("10FFF1", "(" + list.size() + "首)");
                map1.put("10FF02", 0);
                listAlbum.add(map1);
                for (Music music : list) {
                    Map<String, Object> map2 = new Hashtable<>();
                    map2.put("100221", music.url);
                    map2.put("100222", music.name);
                    map2.put("100224", music.album);
                    map2.put("10FF02", 1);
                    listAlbum.add(map2);
                }
            }
        }
        FlyEvent.sendEvent("100231", listAlbum);

        //文件夹列表
        List<String> folderGroupList = new ArrayList<>(mFolderHashMap.keySet());
        Collections.sort(folderGroupList, new Comparator<String>() {
            public int compare(String p1, String p2) {
                if (TextUtils.isEmpty(p1)) {
                    return 1;
                } else if (TextUtils.isEmpty(p2)) {
                    return -1;
                } else {
                    return p1.compareToIgnoreCase(p2);
                }
            }
        });
        List<Map<String, Object>> listFolder = new ArrayList<>();
        for (String key : folderGroupList) {
            List<Music> list = mFolderHashMap.get(key);
            if (list != null && !list.isEmpty()) {
                {
                    String url = list.get(0).url;
                    int last = list.get(0).url.lastIndexOf(File.separator);
                    String path = url.substring(0, last);
                    last = path.lastIndexOf(File.separator);
                    String pathName = last > 0 ? path.substring(last + 1, path.length()) : path;
                    String pathPath = last > 0 ? path.substring(0, last) : path;
                    Map<String, Object> map1 = new Hashtable<>();
                    map1.put("100221", list.get(0).url);
                    map1.put("100222", list.get(0).name);
                    map1.put("10FF03", pathName);
                    map1.put("10FF04", pathPath);
                    map1.put("10FFF1", "(" + list.size() + "首)");
                    map1.put("10FF02", 0);
                    listFolder.add(map1);
                }
                for (Music music : list) {
                    Map<String, Object> map2 = new Hashtable<>();
                    map2.put("100221", music.url);
                    map2.put("100222", music.name);
                    map2.put("100223", music.artist);
                    map2.put("10FF02", 1);
                    listFolder.add(map2);
                }
            }
        }
        FlyEvent.sendEvent("100232", listFolder);
        FlyLog.d("notifyMusicList end use time =" + (System.currentTimeMillis() - time) + "ms");
    }

    @Override
    public boolean recvEvent(byte[] key) {
        Object obj;
        switch (ByteUtil.bytes2HexString(key)) {
            case "200301":
                musicPlayer.playPause();
                break;
            case "200303":
                musicPlayer.playNext();
                break;
            case "200302":
                musicPlayer.playPrev();
                break;
            case "200306":
                obj = FlyEvent.getValue(key);
                if (obj instanceof Integer) {
                    musicPlayer.seekTo((int) obj*1000);
                }
                break;
            case "300101":
                obj = FlyEvent.getValue(key);
                if (!musicPlayer.getPlayUrl().equals(obj)) {
                    musicPlayer.play((String) obj);
                }
                break;
            case "200305":
                musicPlayer.switchLoopStatus();
                break;
            case "300104":
                obj = FlyEvent.getValue(key);
                if (obj instanceof String) {
                    usbMediaScan.openStorager(new StorageInfo((String) obj));
                }
                break;
        }
        return false;
    }

    private void notifyMp3Bitmap(final String url) {
        tHandler.post(new Runnable() {
            @Override
            public void run() {
                byte[] imageBytes = null;
                String lyrics = "";
                try {
                    if (url.toLowerCase().endsWith(".mp3")) {
                        FlyLog.d("start get id3 info url=%s", url);
                        Mp3File mp3file = new Mp3File(url);
                        /**
                         * 音乐文件大于30M不解析
                         */
                        if (mp3file.getLength() < 30 * 1024 * 1024) {
                            if (mp3file.hasId3v2Tag()) {
                                ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                                imageBytes = id3v2Tag.getAlbumImage();
                                lyrics = TextUtils.isEmpty(id3v2Tag.getLyrics()) ? "" : id3v2Tag.getLyrics();
                            }
                        }
                    }
                } catch (Exception e) {
                    FlyLog.e(e.toString());
                }
                final byte[] finalImageBytes = imageBytes;
                if (TextUtils.isEmpty(lyrics)) {
                    lyrics = StringTools.getlrcByPath(url);
                }
                final String finalLyrics = lyrics;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        FlyEvent.sendEvent("100233", finalLyrics);
                        FlyEvent.sendEvent("100227", finalImageBytes);
                    }
                });
            }
        });
    }
}
