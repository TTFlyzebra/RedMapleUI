package com.flyzebra.photo;

import android.os.Bundle;
import android.text.TextUtils;

import com.flyzebra.flyui.Flyui;
import com.flyzebra.flyui.IAction;
import com.flyzebra.flyui.config.ActionKey;
import com.flyzebra.flyui.module.FlyAction;
import com.jancar.media.base.BaseActivity;
import com.jancar.media.data.FloderImage;
import com.jancar.media.data.Image;
import com.jancar.media.data.StorageInfo;
import com.jancar.media.utils.FlyLog;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PhotoActivity extends BaseActivity implements IAction {
    public Flyui flyui;
    private ArrayList<Image> imageList = new ArrayList<>();
    private List<FloderImage> mAllList = new ArrayList<>();
    private List<FloderImage> mAdapterList = new ArrayList<>();
    private Set<String> mHashSet = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flyui = new Flyui(this);
        flyui.onCreate();
        FlyAction.notifyAction(ActionKey.CHANGE_PAGER_WITH_RESID,"music_fm01");
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
            case ActionKey.KEY_PLAY:
                break;
            case ActionKey.KEY_NEXT:
                break;
            case ActionKey.KEY_PREV:
                break;
            case ActionKey.KEY_URL:
                obj = FlyAction.getValue(ActionKey.KEY_URL);
                break;
            case ActionKey.KEY_MENU:
                int flag = 0;
                obj = FlyAction.getValue(ActionKey.MSG_MENU_STATUS);
                if (obj instanceof Integer) {
                    flag = ((int) obj) == 0 ? 1 : 0;
                }
                FlyAction.notifyAction(ActionKey.MSG_MENU_STATUS, flag);
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
        FlyAction.notifyAction(ActionKey.STORE_URL,path);
        if (isStop) return;
        mAllList.clear();
        mHashSet.clear();
        mAdapterList.clear();
        imageList.clear();
        FlyAction.notifyAction(ActionKey.IMAGE_LIST, new ArrayList<>());
        super.notifyPathChange(path);
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
            map.put(ActionKey.RES_URL, imageKey);
            list.add(map);
        }
        FlyAction.notifyAction(ActionKey.STORE_LIST, list);
    }

    private FloderImage floderParant;
    @Override
    public void imageUrlList(List<Image> imageUrlList) {
        try {
            if (isStop) return;
            if (!imageUrlList.isEmpty()) {
                imageList.addAll(imageUrlList);
            }

            for (int i = 0; i < imageList.size(); i++) {
                String url = imageList.get(i).url;
                int last = url.lastIndexOf(File.separator);
                String path = url.substring(0, last).intern();
                if (!mHashSet.contains(path)) {
                    mHashSet.add(path);
                    floderParant = new FloderImage(imageList.get(i));
                    floderParant.group = floderParant.sort;
                    floderParant.url = path;
                    floderParant.sum = 1;
                    floderParant.type = 1;
                    mAllList.add(floderParant);
                } else {
                    floderParant.sum++;
                }
                FloderImage floder = new FloderImage(imageList.get(i));
                floder.group = floderParant.sort;
                floder.type = 2;
                mAllList.add(floder);
            }

            List<Map<Integer, Object>> list1 = new ArrayList<>();
            for (FloderImage image : mAllList) {
                Map<Integer, Object> map = new HashMap<>();
                map.put(ActionKey.IMAGE_URL, image.url);
                list1.add(map);
            }
            FlyAction.notifyAction(ActionKey.IMAGE_LIST_FOLDER, list1);

            List<Map<Integer, Object>> list2 = new ArrayList<>();
            for (Image image : imageList) {
                Map<Integer, Object> map = new HashMap<>();
                map.put(ActionKey.IMAGE_URL, image.url);
                list2.add(map);
            }
            FlyAction.notifyAction(ActionKey.IMAGE_LIST, list2);
        }catch (Exception e){
            com.flyzebra.flyui.utils.FlyLog.e(e.toString());
        }
        super.imageUrlList(imageUrlList);
    }
}
