package com.flyzebra.music;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.flyzebra.flyui.ActionKey;
import com.flyzebra.flyui.Flyui;
import com.flyzebra.flyui.IAction;
import com.flyzebra.flyui.module.FlyAction;
import com.jancar.media.base.BaseActivity;
import com.jancar.media.data.Music;
import com.jancar.media.model.listener.IMusicPlayerListener;
import com.jancar.media.model.musicplayer.IMusicPlayer;
import com.jancar.media.model.musicplayer.MusicPlayer;
import com.jancar.media.utils.FlyLog;

import java.util.ArrayList;
import java.util.List;

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
        getWindow().getDecorView().setBackgroundColor(0xFF000000);
    }

    @Override
    protected void onDestroy() {
        flyui.onDestroy();
        musicPlayer.removeListener(this);
        musicPlayer.stop();
        super.onDestroy();
    }

    @Override
    public void onAction(int key, Object obj) {
        FlyLog.d("onAction key=%d", key);
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
            case ActionKey.REFRESH:
                try {
                    final int i = musicPlayer.getPlayPos();
                    if (i >= 0 && i < musicList.size()) {
                        Music music = musicList.get(i);
                        FlyAction.notifyAction(ActionKey.MEDIA_NAME, music.name);
                        FlyAction.notifyAction(ActionKey.MEDIA_ALBUM, music.album);
                        FlyAction.notifyAction(ActionKey.MEDIA_ARTIST, music.artist);
                    }
                    FlyAction.notifyAction(ActionKey.STATUS_PLAY, musicPlayer.getPlayStatus());
                } catch (Exception e) {
                    FlyLog.e(e.toString());
                }
                break;
        }
    }

    @Override
    public void notifyPathChange(String path) {
        FlyLog.d("notifyPathChange path=%s", path);
        if (isStop) return;
        if (musicPlayer.isPlaying()) {
            musicPlayer.savePathUrl(currenPath);
        }
        musicList.clear();
        if (!musicPlayer.getPlayUrl().startsWith(path)) {
            musicPlayer.stop();
        }
        musicPlayer.playSaveUrlByPath(path);
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
            FlyAction.notifyAction(ActionKey.STATUS_PLAY, musicPlayer.getPlayStatus());
            final int i = musicPlayer.getPlayPos();
            if (i >= 0 && i < musicList.size()) {
                Music music = musicList.get(i);
                FlyAction.notifyAction(ActionKey.MEDIA_NAME, music.name);
                FlyAction.notifyAction(ActionKey.MEDIA_ALBUM, music.album);
                FlyAction.notifyAction(ActionKey.MEDIA_ARTIST, music.artist);
            }
        } catch (Exception e) {
            FlyLog.e(e.toString());
        }
    }

    @Override
    public void loopStatusChange(int staut) {

    }

    @Override
    public void playtime(long current, long total) {
        FlyAction.notifyAction(ActionKey.MEDIA_TIME,new long[]{current,total});
    }

}
