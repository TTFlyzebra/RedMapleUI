package com.flyzebra.music;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.flyzebra.flyui.Flyui;
import com.flyzebra.flyui.event.ActionKey;
import com.flyzebra.flyui.event.FlyAction;
import com.flyzebra.flyui.event.IAction;
import com.flyzebra.flyui.utils.FlyLog;
import com.jancar.media.base.BaseActivity;
import com.jancar.media.data.Music;
import com.jancar.media.data.StorageInfo;
import com.jancar.media.model.listener.IMusicPlayerListener;
import com.jancar.media.model.musicplayer.IMusicPlayer;
import com.jancar.media.model.musicplayer.MusicPlayer;
import com.jancar.media.utils.StringTools;

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
public class MusicActivity extends BaseActivity implements IAction, IMusicPlayerListener {
    public Flyui flyui;
    protected IMusicPlayer musicPlayer = MusicPlayer.getInstance();
    public List<Music> musicList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flyui = new Flyui(this);
        flyui.onCreate();
        musicPlayer.addListener(this);
        FlyAction.handleAction(ActionKey.CHANGE_PAGER_WITH_RESID, "music_fm01");
    }

    @Override
    protected void onDestroy() {
        flyui.onDestroy();
        musicPlayer.removeListener(this);
        musicPlayer.destory();
        super.onDestroy();
    }

    @Override
    public boolean onAction(int key) {
        Object obj;
        switch (key) {
            case ActionKey.KEY_PLAY:
                musicPlayer.playPause();
                break;
            case ActionKey.KEY_NEXT:
                musicPlayer.playNext();
                break;
            case ActionKey.KEY_PREV:
                musicPlayer.playPrev();
                break;
            case ActionKey.KEY_SEEK:
                obj = FlyAction.getValue(ActionKey.KEY_SEEK);
                if (obj instanceof Integer) {
                    musicPlayer.seekTo((int) obj);
                }
                break;
            case ActionKey.KEY_URL:
                obj = FlyAction.getValue(ActionKey.KEY_URL);
                if (!musicPlayer.getPlayUrl().equals(obj)) {
                    musicPlayer.play((String) obj);
                }
                break;
            case ActionKey.KEY_MENU:
                int flag = 0;
                obj = FlyAction.getValue(ActionKey.MSG_MENU_STATUS);
                if (obj instanceof Integer) {
                    flag = ((int) obj) == 0 ? 1 : 0;
                }
                FlyAction.handleAction(ActionKey.MSG_MENU_STATUS, flag);
                break;
            case ActionKey.KEY_LOOP:
                musicPlayer.switchLoopStatus();
                break;
            case ActionKey.KEY_STORE:
                obj = FlyAction.getValue(ActionKey.KEY_STORE);
                if (obj instanceof String) {
                    usbMediaScan.openStorager(new StorageInfo((String) obj));
                }
                break;
        }
        return false;
    }

    @Override
    public void notifyPathChange(String path) {
        FlyLog.d("notifyPathChange path=%s", path);
        FlyAction.handleAction(ActionKey.STORE_URL, path);
        if (isStop) return;
        if (!musicPlayer.getPlayUrl().startsWith(path)) {
            musicPlayer.destory();
        }
        musicPlayer.playSaveUrlByPath(path);
        musicList.clear();
        FlyAction.handleAction(ActionKey.MUSIC_LIST, new ArrayList<>());
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
            case MusicPlayer.STATUS_STARTPLAY:
                notifyCurrentMusic();
                break;
            case MusicPlayer.STATUS_PLAYING:
            case MusicPlayer.STATUS_PAUSE:
                break;
        }
        int playStauts = (musicPlayer.getPlayStatus() == MusicPlayer.STATUS_STARTPLAY
                || musicPlayer.getPlayStatus() == MusicPlayer.STATUS_PLAYING) ? 1 : 0;
        FlyAction.handleAction(ActionKey.MSG_PLAY_STATUS, playStauts);
    }

    @Override
    public void loopStatusChange(int staut) {
        FlyAction.handleAction(ActionKey.MSG_LOOP_STATUS, staut);
    }

    @Override
    public void playtime(long current, long total) {
        FlyAction.handleAction(ActionKey.MUSIC_TIME, new long[]{current, total});
    }

    @Override
    public void storageList(List<StorageInfo> storageList) {
        super.storageList(storageList);
        if (storageList != null) {
            FlyAction.handleAction(ActionKey.SUM_STORE, "存储器\n(" + storageList.size() + ")");
        }
        List<Map<Integer, Object>> list = new ArrayList<>();
        for (StorageInfo storageInfo : storageList) {
            if (TextUtils.isEmpty(storageInfo.mPath)) break;
            Map<Integer, Object> map = new HashMap<>();
            map.put(ActionKey.STORE_NAME, storageInfo.mDescription);
            map.put(ActionKey.STORE_URL, storageInfo.mPath);
            String imageKey;
            if (storageInfo.mPath.equals("/storage")) {
                imageKey = "DISK_ALL";
            } else if (storageInfo.mPath.startsWith("/storage/emulated")) {
                imageKey = "DISK_HD";
            } else {
                imageKey = "DISK_USB";
            }
            map.put(ActionKey.RES_URL, imageKey);
            list.add(map);
        }
        FlyAction.handleAction(ActionKey.STORE_LIST, list);
    }

    private void notifyCurrentMusic() {
        FlyLog.d("notifyCurrentMusic");
        try {
            final int i = musicPlayer.getPlayPos();
            if (i >= 0 && i < musicList.size()) {
                Music music = musicList.get(i);
                FlyAction.handleAction(ActionKey.MUSIC_NAME, music.name);
                FlyAction.handleAction(ActionKey.MUSIC_ALBUM, music.album);
                FlyAction.handleAction(ActionKey.MUSIC_ARTIST, music.artist);
                FlyAction.handleAction(ActionKey.MUSIC_URL, music.url);
            } else {
                FlyAction.handleAction(ActionKey.MUSIC_NAME, "");
                FlyAction.handleAction(ActionKey.MUSIC_ALBUM, "");
                FlyAction.handleAction(ActionKey.MUSIC_ARTIST, "");
                FlyAction.handleAction(ActionKey.MUSIC_URL, "");
            }
        } catch (Exception e) {
            FlyLog.e(e.toString());
        }
    }

    private void notifyMusicList() {
        long time = System.currentTimeMillis();
        FlyLog.d("notifyMusicList start");
        //单曲列表
        List<Map<Integer, Object>> listSingle = new ArrayList<>();
        for (Music music : musicList) {
            music.artist = TextUtils.isEmpty(music.artist) ? getString(R.string.no_artist) : music.artist;
            music.album = TextUtils.isEmpty(music.album) ? getString(R.string.no_album) : music.album;
            music.name = TextUtils.isEmpty(music.name) ? StringTools.getNameByPath(music.url) : music.name;
            Map<Integer, Object> map = new Hashtable<>();
            map.put(ActionKey.MUSIC_URL, music.url);
            map.put(ActionKey.MUSIC_NAME, music.name);
            map.put(ActionKey.MUSIC_ARTIST, music.artist);
            listSingle.add(map);
        }
        FlyAction.handleAction(ActionKey.MUSIC_SUM, "单曲\n(" + listSingle.size() + ")");
        FlyAction.handleAction(ActionKey.MUSIC_LIST, listSingle);


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
        FlyAction.handleAction(ActionKey.MUSIC_SUM_ARTIST, "歌手\n(" + mArtistHashMap.size() + ")");
        FlyAction.handleAction(ActionKey.MUSIC_SUM_ALBUM, "专辑\n(" + mAlbumHashMap.size() + ")");
        FlyAction.handleAction(ActionKey.MUSIC_SUM_FOLDER, "文件夹\n(" + mFolderHashMap.size() + ")");

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
        List<Map<Integer, Object>> listArtist = new ArrayList<>();
        for (String key : artistGroupList) {
            List<Music> list = mArtistHashMap.get(key);
            if (list != null && !list.isEmpty()) {
                Map<Integer, Object> map1 = new Hashtable<>();
                map1.put(ActionKey.MUSIC_URL, list.get(0).url);
                map1.put(ActionKey.MUSIC_NAME, list.get(0).name);
                map1.put(ActionKey.MUSIC_ARTIST, list.get(0).artist);
                map1.put(ActionKey.FOLODER_NUM, "(" + list.size() + "首)");
                map1.put(ActionKey.GROUP_TYPE, 0);
                listArtist.add(map1);
                for (Music music : list) {
                    Map<Integer, Object> map2 = new Hashtable<>();
                    map2.put(ActionKey.MUSIC_URL, music.url);
                    map2.put(ActionKey.MUSIC_NAME, music.name);
                    map2.put(ActionKey.MUSIC_ARTIST, music.artist);
                    map2.put(ActionKey.GROUP_TYPE, 1);
                    listArtist.add(map2);
                }
            }
        }
        FlyAction.handleAction(ActionKey.MUSIC_LIST_ARTIST, listArtist);

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
        List<Map<Integer, Object>> listAlbum = new ArrayList<>();
        for (String key : albumGroupList) {
            List<Music> list = mAlbumHashMap.get(key);
            if (list != null && !list.isEmpty()) {
                Map<Integer, Object> map1 = new Hashtable<>();
                map1.put(ActionKey.MUSIC_URL, list.get(0).url);
                map1.put(ActionKey.MUSIC_NAME, list.get(0).name);
                map1.put(ActionKey.MUSIC_ALBUM, list.get(0).album);
                map1.put(ActionKey.FOLODER_NUM, "(" + list.size() + "首)");
                map1.put(ActionKey.GROUP_TYPE, 0);
                listAlbum.add(map1);
                for (Music music : list) {
                    Map<Integer, Object> map2 = new Hashtable<>();
                    map2.put(ActionKey.MUSIC_URL, music.url);
                    map2.put(ActionKey.MUSIC_NAME, music.name);
                    map2.put(ActionKey.MUSIC_ALBUM, music.album);
                    map2.put(ActionKey.GROUP_TYPE, 1);
                    listAlbum.add(map2);
                }
            }
        }
        FlyAction.handleAction(ActionKey.MUSIC_LIST_ALBUM, listAlbum);

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
        List<Map<Integer, Object>> listFolder = new ArrayList<>();
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
                    Map<Integer, Object> map1 = new Hashtable<>();
                    map1.put(ActionKey.MUSIC_URL, list.get(0).url);
                    map1.put(ActionKey.MUSIC_NAME, list.get(0).name);
                    map1.put(ActionKey.FOLODER_NAME, pathName);
                    map1.put(ActionKey.FOLODER_PATH, pathPath);
                    map1.put(ActionKey.FOLODER_NUM, "(" + list.size() + "首)");
                    map1.put(ActionKey.GROUP_TYPE, 0);
                    listFolder.add(map1);
                }
                for (Music music : list) {
                    Map<Integer, Object> map2 = new Hashtable<>();
                    map2.put(ActionKey.MUSIC_URL, music.url);
                    map2.put(ActionKey.MUSIC_NAME, music.name);
                    map2.put(ActionKey.GROUP_TYPE, 1);
                    listFolder.add(map2);
                }
            }
        }
        FlyAction.handleAction(ActionKey.MUSIC_LIST_FOLDER, listFolder);
        FlyLog.d("notifyMusicList end use time =" + (System.currentTimeMillis() - time) + "ms");
    }

}
