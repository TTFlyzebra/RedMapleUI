package com.flyzebra.video;

import android.os.Bundle;
import android.text.TextUtils;

import com.flyzebra.flyui.Flyui;
import com.flyzebra.flyui.event.FlyEvent;
import com.flyzebra.flyui.event.FlyEventKey;
import com.flyzebra.flyui.utils.FlyLog;
import com.jancar.media.base.BaseActivity;
import com.jancar.media.data.StorageInfo;
import com.jancar.media.data.Video;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import tcking.github.com.giraffeplayer.IjkVideoView;

public class VideoActivity extends BaseActivity  {
    public Flyui flyui;
    public IjkVideoView ijkVideoView;
    private ArrayList<Video> videoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flyui = new Flyui(this);
        flyui.onCreate();
        ijkVideoView = findViewById(R.id.video_play);
        FlyEvent.sendEvent(FlyEventKey.CHANGE_PAGER_WITH_RESID,"music_fm01");
    }

    @Override
    protected void onDestroy() {
        ijkVideoView.stopPlayback();
        flyui.onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onAction(int key) {
        Object obj;
        switch (key) {
            case FlyEventKey.KEY_PLAY:
                break;
            case FlyEventKey.KEY_NEXT:
                break;
            case FlyEventKey.KEY_PREV:
                break;
            case FlyEventKey.KEY_SEEK:
                obj = FlyEvent.getValue(FlyEventKey.KEY_SEEK);
                if (obj instanceof Integer) {
                }
                break;
            case FlyEventKey.KEY_URL:
                obj = FlyEvent.getValue(FlyEventKey.KEY_URL);
                if(obj instanceof String){
                    ijkVideoView.setVideoPath((String) obj);
                    ijkVideoView.start();
                    FlyEvent.sendEvent(FlyEventKey.VIDEO_URL, obj);
                }
                break;
            case FlyEventKey.KEY_MENU:
                int flag = 0;
                obj = FlyEvent.getValue(FlyEventKey.MSG_MENU_STATUS);
                if (obj instanceof Integer) {
                    flag = ((int) obj) == 0 ? 1 : 0;
                }
                FlyEvent.sendEvent(FlyEventKey.MSG_MENU_STATUS, flag);
                break;
            case FlyEventKey.KEY_LOOP:
                break;
            case FlyEventKey.KEY_STORE:
                obj = FlyEvent.getValue(FlyEventKey.KEY_STORE);
                if(obj instanceof String){
                    usbMediaScan.openStorager(new StorageInfo((String) obj));
                }
                break;
        }
        return false;
    }

    @Override
    public void notifyPathChange(String path) {
        FlyLog.d("notifyPathChange path=%s", path);
        FlyEvent.sendEvent(FlyEventKey.STORE_URL,path);
        if (isStop) return;
        videoList.clear();
        FlyEvent.sendEvent(FlyEventKey.VIDEO_LIST, new ArrayList<>());
        super.notifyPathChange(path);
    }

    @Override
    public void storageList(List<StorageInfo> storageList) {
        super.storageList(storageList);
        List<Map<Integer, Object>> list = new ArrayList<>();
        for (StorageInfo storageInfo : storageList) {
            if (TextUtils.isEmpty(storageInfo.mPath)) break;
            Map<Integer, Object> map = new Hashtable<>();
            map.put(FlyEventKey.STORE_NAME, storageInfo.mDescription);
            map.put(FlyEventKey.STORE_URL, storageInfo.mPath);
            String imageKey;
            if (storageInfo.mPath.equals("/storage")) {
                imageKey = "DISK_ALL";
            } else if (storageInfo.mPath.startsWith("/storage/emulated")) {
                imageKey = "DISK_HD";
            } else {
                imageKey = "DISK_USB";
            }
            map.put(FlyEventKey.RES_URL, imageKey);
            list.add(map);
        }
        FlyEvent.sendEvent(FlyEventKey.STORE_LIST, list);
    }

    @Override
    public void videoUrlList(List<Video> videoUrlList) {
        try {
            String url = videoUrlList.get(0).url;
            FlyLog.d("start ijk play url=%s", url);
            ijkVideoView.setVideoPath(url);
            ijkVideoView.start();

            if (isStop) return;
            if (!videoUrlList.isEmpty()) {
                videoList.addAll(videoUrlList);
            }
            List<Map<Integer, Object>> list = new ArrayList<>();
            for (Video video : videoList) {
                Map<Integer, Object> map = new Hashtable<>();
                map.put(FlyEventKey.VIDEO_URL, video.url);
                list.add(map);
            }
            FlyEvent.sendEvent(FlyEventKey.VIDEO_LIST, list);
        }catch (Exception e){
            FlyLog.e(e.toString());
        }
        super.videoUrlList(videoUrlList);
    }

}
