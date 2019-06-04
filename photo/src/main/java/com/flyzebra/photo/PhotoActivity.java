package com.flyzebra.photo;

import android.os.Bundle;
import android.text.TextUtils;

import com.flyzebra.flyui.Flyui;
import com.flyzebra.flyui.event.FlyEvent;
import com.flyzebra.flyui.event.IFlyEvent;
import com.flyzebra.flyui.utils.ByteUtil;
import com.flyzebra.flyui.utils.FlyLog;
import com.jancar.media.base.BaseActivity;
import com.jancar.media.data.Image;
import com.jancar.media.data.Music;
import com.jancar.media.data.StorageInfo;
import com.jancar.media.utils.StringTools;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class PhotoActivity extends BaseActivity implements IFlyEvent {
    public Flyui flyui;
    private ArrayList<Image> imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flyui = new Flyui(this);
        flyui.onCreate();
    }

    @Override
    protected void onDestroy() {
        flyui.onDestroy();
        super.onDestroy();
    }

    @Override
    public void notifyPathChange(String path) {
        FlyLog.d("notifyPathChange path=%s", path);
        FlyEvent.sendEvent("100402", path);
        if (isStop) return;
        imageList.clear();
        FlyEvent.sendEvent("100501", new ArrayList<>());
        super.notifyPathChange(path);
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

    @Override
    public void imageUrlList(List<Image> imageUrlList) {
        try {
            if (isStop) return;
            if (!imageUrlList.isEmpty()) {
                imageList.addAll(imageUrlList);
            }
            notifyImageList();

        }catch (Exception e){
            FlyLog.e(e.toString());
        }
        super.imageUrlList(imageUrlList);
    }

    @Override
    public void musicID3UrlList(List<Music> musicUrlList) {
        super.musicID3UrlList(musicUrlList);
        if(!imageList.isEmpty()){
            FlyEvent.sendEvent("100502", imageList.get(0).url);
        }
    }

    private void notifyImageList() {
        long time = System.currentTimeMillis();
        com.flyzebra.flyui.utils.FlyLog.d("notifyImageList start");
        //单曲列表
        List<Map<String, Object>> listSingle = new ArrayList<>();
        for (Image image : imageList) {
            Map<String, Object> map = new Hashtable<>();
            map.put("100503", StringTools.getNameByPath(image.url));
            map.put("100502", image.url);
            map.put("F00502", image.url);
            listSingle.add(map);
        }
//        FlyAction.sendEvent(ActionKey.MUSIC_SUM, "单曲\n(" + listSingle.size() + ")");
        FlyEvent.sendEvent("100501", listSingle);


        //列表分类
        Map<String, List<Image>> mFolderHashMap = new HashMap<>();
        for (Image image : imageList) {
            String path = StringTools.getPathByPath(image.url);
            if (mFolderHashMap.get(path) == null) {
                mFolderHashMap.put(path, new ArrayList<Image>());
            }
            mFolderHashMap.get(path).add(image);
        }
//        FlyAction.sendEvent(ActionKey.MUSIC_SUM_FOLDER, "文件夹\n(" + mFolderHashMap.size() + ")");

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
            List<Image> list = mFolderHashMap.get(key);
            if (list != null && !list.isEmpty()) {
                {
                    String url = list.get(0).url;
                    int last = list.get(0).url.lastIndexOf(File.separator);
                    String path = url.substring(0, last);
                    last = path.lastIndexOf(File.separator);
                    String pathName = last > 0 ? path.substring(last + 1, path.length()) : path;
                    String pathPath = last > 0 ? path.substring(0, last) : path;
                    Map<String, Object> map1 = new Hashtable<>();
                    map1.put("100502", list.get(0).url);
                    map1.put("100503", StringTools.getNameByPath(url));
                    map1.put("10FF03", pathName);
                    map1.put("10FF04", pathPath);
                    map1.put("10FFF1", "(" + list.size() + "首)");
                    map1.put("10FF02", 0);
                    listFolder.add(map1);
                }
                for (Image image : list) {
                    Map<String, Object> map2 = new Hashtable<>();
                    map2.put("100502", image.url);
                    map2.put("F00502", image.url);
                    map2.put("100503", StringTools.getNameByPath(image.url));
                    map2.put("10FF02", 1);
                    listFolder.add(map2);
                }
            }
        }
        FlyEvent.sendEvent("100232", listFolder);
        FlyLog.d("notifyImageList end use time =" + (System.currentTimeMillis() - time) + "ms");
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
            case "300103":
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

}
