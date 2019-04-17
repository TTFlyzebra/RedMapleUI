package com.flyzebra.music;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.flyzebra.flyui.Flyui;
import com.flyzebra.flyui.IAction;
import com.flyzebra.flyui.config.ActionKey;
import com.flyzebra.flyui.module.FlyAction;
import com.jancar.media.base.BaseActivity;
import com.jancar.media.data.Music;
import com.jancar.media.data.StorageInfo;
import com.jancar.media.model.listener.IMusicPlayerListener;
import com.jancar.media.model.listener.IStorageListener;
import com.jancar.media.model.musicplayer.IMusicPlayer;
import com.jancar.media.model.musicplayer.MusicPlayer;
import com.jancar.media.utils.FlyLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author FlyZebra
 * 2019/3/20 10:55
 * Describ:
 **/
public class MusicActivity extends BaseActivity implements IAction, IMusicPlayerListener, IStorageListener {
    public Flyui flyui;
    protected IMusicPlayer musicPlayer = MusicPlayer.getInstance();
    public List<Music> musicList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flyui = new Flyui(this);
        flyui.onCreate();
        musicPlayer.addListener(this);
    }

    @Override
    protected void onDestroy() {
        flyui.onDestroy();
        musicPlayer.removeListener(this);
        musicPlayer.stop();
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
                obj = FlyAction.getValue(ActionKey.STATUS_MENU);
                if (obj instanceof Integer) {
                    flag = ((int) obj) == 0 ? 1 : 0;
                }
                FlyAction.notifyAction(ActionKey.STATUS_MENU, flag);
                break;
            case ActionKey.KEY_LOOP:
                musicPlayer.switchLoopStatus();
                break;
        }
        return false;
    }

    @Override
    public void notifyPathChange(String path) {
        FlyLog.d("notifyPathChange path=%s", path);
        if (isStop) return;
        if (!musicPlayer.getPlayUrl().startsWith(path)) {
            musicPlayer.stop();
        }
        musicPlayer.playSaveUrlByPath(path);
        musicList.clear();
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
        super.musicUrlList(musicUrlList);
    }

    @Override
    public void scanFinish(String path) {
        FlyLog.d("scanFinish path=%s", path);
        if (isStop) return;
        super.scanFinish(path);
        try {
            final int i = musicPlayer.getPlayPos();
            if (i >= 0 && i < musicList.size()) {
                Music music = musicList.get(i);
                FlyAction.notifyAction(ActionKey.MEDIA_NAME, music.name);
                FlyAction.notifyAction(ActionKey.MEDIA_ALBUM, music.album);
                FlyAction.notifyAction(ActionKey.MEDIA_ARTIST, music.artist);
                FlyAction.notifyAction(ActionKey.MEDIA_URL, music.url);
            }
        } catch (Exception e) {
            FlyLog.e(e.toString());
        }
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
        List<Map<Integer, Object>> list = new ArrayList<>();
        for (Music music : musicList) {
            Map<Integer, Object> map = new HashMap<>();
            map.put(ActionKey.MEDIA_URL, music.url);
            map.put(ActionKey.MEDIA_NAME, music.name);
            map.put(ActionKey.MEDIA_ARTIST, music.artist);
            list.add(map);
        }
        FlyAction.notifyAction(ActionKey.MEDIA_LIST, list);
        super.musicID3UrlList(musicUrlList);
    }

    @Override
    public void playStatusChange(int statu) {
        FlyLog.d("statu=%d", statu);
        switch (statu) {
            case MusicPlayer.STATUS_COMPLETED:
            case MusicPlayer.STATUS_STARTPLAY:
                break;
            case MusicPlayer.STATUS_PLAYING:
                break;
            case MusicPlayer.STATUS_ERROR:
                break;
            case MusicPlayer.STATUS_IDLE:
                break;
        }
        try {
            int playStauts = (musicPlayer.getPlayStatus() == MusicPlayer.STATUS_STARTPLAY || musicPlayer.getPlayStatus() == MusicPlayer.STATUS_PLAYING) ? 1 : 0;
            FlyAction.notifyAction(ActionKey.STATUS_PLAY, playStauts);
            final int i = musicPlayer.getPlayPos();
            if (i >= 0 && i < musicList.size()) {
                Music music = musicList.get(i);
                FlyAction.notifyAction(ActionKey.MEDIA_NAME, music.name);
                FlyAction.notifyAction(ActionKey.MEDIA_ALBUM, music.album);
                FlyAction.notifyAction(ActionKey.MEDIA_ARTIST, music.artist);
                FlyAction.notifyAction(ActionKey.MEDIA_URL, music.url);
            }
        } catch (Exception e) {
            FlyLog.e(e.toString());
        }
    }

    @Override
    public void loopStatusChange(int staut) {
        FlyAction.notifyAction(ActionKey.STATUS_LOOP, staut);
    }

    @Override
    public void playtime(long current, long total) {
        FlyAction.notifyAction(ActionKey.MEDIA_TIME, new long[]{current, total});
    }

    @Override
    public void storageList(List<StorageInfo> storageList) {
        super.storageList(storageList);
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
            map.put(ActionKey.STORE_IMAGE, imageKey);
            list.add(map);
        }
        FlyAction.notifyAction(ActionKey.STORE_LIST, list);
    }
}
