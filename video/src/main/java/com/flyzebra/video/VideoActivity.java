package com.flyzebra.video;

import android.os.Bundle;
import android.text.TextUtils;

import com.flyzebra.flyui.Flyui;
import com.flyzebra.flyui.event.FlyEvent;
import com.flyzebra.flyui.event.FlyEventKey;
import com.flyzebra.flyui.event.IFlyEvent;
import com.flyzebra.flyui.utils.ByteUtil;
import com.flyzebra.flyui.utils.FlyLog;
import com.jancar.media.base.BaseActivity;
import com.jancar.media.data.StorageInfo;
import com.jancar.media.data.Video;
import com.jancar.media.utils.StringTools;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import tcking.github.com.giraffeplayer.IjkVideoView;

public class VideoActivity extends BaseActivity implements IFlyEvent {
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
    }

    @Override
    protected void onDestroy() {
        ijkVideoView.stopPlayback();
        flyui.onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean recvEvent(byte[] key) {
        Object obj;
        switch (ByteUtil.bytes2HexString(key)) {
            case "200301":
                break;
            case "200303":
                break;
            case "200302":
                break;
            case "300102":
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


    @Override
    public void notifyPathChange(String path) {
        FlyLog.d("notifyPathChange path=%s", path);
        FlyEvent.sendEvent("100402", path);
        if (isStop) return;
        videoList.clear();
        FlyEvent.sendEvent("100601", new ArrayList<>());
        super.notifyPathChange(path);
    }

    @Override
    public void storageList(List<StorageInfo> storageList) {
        super.storageList(storageList);
        if (storageList != null) {
            FlyEvent.sendEvent("40030200", "存储器\n(" + storageList.size() + ")");
        }
        List<Map<String, Object>> list = new ArrayList<>();
        assert storageList != null;
        for (StorageInfo storageInfo : storageList) {
            if (TextUtils.isEmpty(storageInfo.mPath)) break;
            Map<String, Object> map = new HashMap<>();
            map.put("100403", TextUtils.isEmpty(storageInfo.mDescription) ? storageInfo.mPath : storageInfo.mDescription);
            map.put("100402", storageInfo.mPath);
            list.add(map);
        }
        FlyEvent.sendEvent("100401", list);
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
            notifyVideoList();
        }catch (Exception e){
            FlyLog.e(e.toString());
        }
        super.videoUrlList(videoUrlList);
    }


    private void notifyVideoList() {
        long time = System.currentTimeMillis();
        com.flyzebra.flyui.utils.FlyLog.d("notifyVideoList start");
        //单曲列表
        List<Map<String, Object>> listSingle = new ArrayList<>();
        for (Video video : videoList) {
            Map<String, Object> map = new Hashtable<>();
            map.put("100603", StringTools.getNameByPath(video.url));
            map.put("100602", video.url);
            map.put("F00602", video.url);
            listSingle.add(map);
        }
        FlyEvent.sendEvent("40030201", "视频\n(" + listSingle.size() + ")");
        FlyEvent.sendEvent("100601", listSingle);


        //列表分类
        Map<String, List<Video>> mFolderHashMap = new HashMap<>();
        for (Video video : videoList) {
            String path = StringTools.getPathByPath(video.url);
            if (mFolderHashMap.get(path) == null) {
                mFolderHashMap.put(path, new ArrayList<Video>());
            }
            mFolderHashMap.get(path).add(video);
        }

        FlyEvent.sendEvent("40030202", "文件夹\n(" + mFolderHashMap.size() + ")");

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
            List<Video> list = mFolderHashMap.get(key);
            if (list != null && !list.isEmpty()) {
                {
                    String url = list.get(0).url;
                    int last = list.get(0).url.lastIndexOf(File.separator);
                    String path = url.substring(0, last);
                    last = path.lastIndexOf(File.separator);
                    String pathName = last > 0 ? path.substring(last + 1, path.length()) : path;
                    String pathPath = last > 0 ? path.substring(0, last) : path;
                    Map<String, Object> map1 = new Hashtable<>();
                    map1.put("100602", list.get(0).url);
                    map1.put("100603", StringTools.getNameByPath(url));
                    map1.put("10FF03", pathName);
                    map1.put("10FF04", pathPath);
                    map1.put("10FFF1", "(" + list.size() + "集)");
                    map1.put("10FF02", 0);
                    listFolder.add(map1);
                }
                for (Video video : list) {
                    Map<String, Object> map2 = new Hashtable<>();
                    map2.put("100602", video.url);
                    map2.put("F00602", video.url);
                    map2.put("100603", StringTools.getNameByPath(video.url));
                    map2.put("10FF02", 1);
                    listFolder.add(map2);
                }
            }
        }
        FlyEvent.sendEvent("100232", listFolder);
        FlyLog.d("notifyVideoList end use time =" + (System.currentTimeMillis() - time) + "ms");
    }

}
