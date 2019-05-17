package com.flyzebra.video;

import android.os.Bundle;
import android.text.TextUtils;

import com.flyzebra.flyui.Flyui;
import com.flyzebra.flyui.event.ActionKey;
import com.flyzebra.flyui.event.FlyAction;
import com.flyzebra.flyui.event.IAction;
import com.flyzebra.flyui.utils.FlyLog;
import com.jancar.media.base.BaseActivity;
import com.jancar.media.data.StorageInfo;
import com.jancar.media.data.Video;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import tcking.github.com.giraffeplayer.IjkVideoView;

public class VideoActivity extends BaseActivity implements IAction {
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
        FlyAction.handleAction(ActionKey.CHANGE_PAGER_WITH_RESID,"music_fm01");
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
            case ActionKey.KEY_PLAY:
                break;
            case ActionKey.KEY_NEXT:
                break;
            case ActionKey.KEY_PREV:
                break;
            case ActionKey.KEY_SEEK:
                obj = FlyAction.getValue(ActionKey.KEY_SEEK);
                if (obj instanceof Integer) {
                }
                break;
            case ActionKey.KEY_URL:
                obj = FlyAction.getValue(ActionKey.KEY_URL);
                if(obj instanceof String){
                    ijkVideoView.setVideoPath((String) obj);
                    ijkVideoView.start();
                    FlyAction.handleAction(ActionKey.VIDEO_URL, obj);
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
                break;
            case ActionKey.KEY_STORE:
                obj = FlyAction.getValue(ActionKey.KEY_STORE);
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
        FlyAction.handleAction(ActionKey.STORE_URL,path);
        if (isStop) return;
        videoList.clear();
        FlyAction.handleAction(ActionKey.VIDEO_LIST, new ArrayList<>());
        super.notifyPathChange(path);
    }

    @Override
    public void storageList(List<StorageInfo> storageList) {
        super.storageList(storageList);
        List<Map<Integer, Object>> list = new ArrayList<>();
        for (StorageInfo storageInfo : storageList) {
            if (TextUtils.isEmpty(storageInfo.mPath)) break;
            Map<Integer, Object> map = new Hashtable<>();
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
                map.put(ActionKey.VIDEO_URL, video.url);
                list.add(map);
            }
            FlyAction.handleAction(ActionKey.VIDEO_LIST, list);
        }catch (Exception e){
            FlyLog.e(e.toString());
        }
        super.videoUrlList(videoUrlList);
    }

}
