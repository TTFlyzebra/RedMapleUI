package com.flyzebra.photo;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.flyzebra.flyui.Flyui;
import com.flyzebra.flyui.event.FlyEvent;
import com.flyzebra.flyui.event.FlyEventKey;
import com.flyzebra.flyui.utils.FlyLog;
import com.jancar.media.base.BaseActivity;
import com.jancar.media.data.FloderImage;
import com.jancar.media.data.Image;
import com.jancar.media.data.StorageInfo;
import com.jancar.media.utils.StringTools;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PhotoActivity extends BaseActivity {
    public Flyui flyui;
    private ArrayList<Image> imageList = new ArrayList<>();
    private List<FloderImage> mAllList = new ArrayList<>();
    private List<FloderImage> mAdapterList = new ArrayList<>();
    private Set<String> mHashSet = new HashSet<>();
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageview);
        flyui = new Flyui(this);
        flyui.onCreate();
        FlyEvent.sendEvent(FlyEventKey.CHANGE_PAGER_WITH_RESID,"music_fm01");
    }

    @Override
    protected void onDestroy() {
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
            case FlyEventKey.KEY_URL:
                obj = FlyEvent.getValue(FlyEventKey.KEY_URL);
                if(obj instanceof String){
                    FlyEvent.sendEvent(FlyEventKey.IMAGE_URL, obj);
                }
                break;
            case FlyEventKey.IMAGE_URL:
                obj = FlyEvent.getValue(FlyEventKey.IMAGE_URL);
                if(obj instanceof String) {
                    Glide.with(this)
                            .load(obj)
                            .centerInside()
                            .into(imageView);
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
        mAllList.clear();
        mHashSet.clear();
        mAdapterList.clear();
        imageList.clear();
        FlyEvent.sendEvent(FlyEventKey.IMAGE_LIST, new ArrayList<>());
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
    public void imageUrlList(List<Image> imageUrlList) {
        try {
            if (isStop) return;
            if (!imageUrlList.isEmpty()) {
                imageList.addAll(imageUrlList);
            }
            notifyMusicList();

        }catch (Exception e){
            FlyLog.e(e.toString());
        }
        super.imageUrlList(imageUrlList);
    }

    private void notifyMusicList() {
        long time = System.currentTimeMillis();
        com.flyzebra.flyui.utils.FlyLog.d("notifyMusicList start");
        //单曲列表
        List<Map<Integer, Object>> listSingle = new ArrayList<>();
        for (Image image : imageList) {
            Map<Integer, Object> map = new Hashtable<>();
            map.put(FlyEventKey.IMAGE_NAME, StringTools.getNameByPath(image.url));
            map.put(FlyEventKey.IMAGE_URL, image.url);
            listSingle.add(map);
        }
//        FlyAction.sendEvent(ActionKey.MUSIC_SUM, "单曲\n(" + listSingle.size() + ")");
        FlyEvent.sendEvent(FlyEventKey.IMAGE_LIST, listSingle);


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
        List<Map<Integer, Object>> listFolder = new ArrayList<>();
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
                    Map<Integer, Object> map1 = new Hashtable<>();
                    map1.put(FlyEventKey.IMAGE_URL, path);
                    map1.put(FlyEventKey.FOLODER_NAME, pathName);
                    map1.put(FlyEventKey.FOLODER_PATH, pathPath);
                    map1.put(FlyEventKey.FOLODER_NUM, "(" + list.size() + ")");
                    map1.put(FlyEventKey.GROUP_TYPE, 0);
                    listFolder.add(map1);
                }
                for (Image image : list) {
                    Map<Integer, Object> map2 = new Hashtable<>();
                    map2.put(FlyEventKey.IMAGE_NAME, StringTools.getNameByPath(image.url));
                    map2.put(FlyEventKey.IMAGE_URL, image.url);
                    map2.put(FlyEventKey.GROUP_TYPE, 1);
                    listFolder.add(map2);
                }
            }
        }
        FlyEvent.sendEvent(FlyEventKey.IMAGE_LIST_FOLDER, listFolder);
        FlyLog.d("notifyMusicList end use time =" + (System.currentTimeMillis() - time) + "ms");
    }

}
