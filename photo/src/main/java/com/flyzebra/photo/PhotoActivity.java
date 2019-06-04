package com.flyzebra.photo;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.flyzebra.flyui.Flyui;
import com.flyzebra.flyui.event.FlyEvent;
import com.flyzebra.flyui.event.IFlyEvent;
import com.flyzebra.flyui.utils.ByteUtil;
import com.flyzebra.flyui.utils.FlyLog;
import com.github.chrisbanes.photoview.PhotoView;
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
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PhotoActivity extends BaseActivity implements IFlyEvent {
    public Flyui flyui;
    private ArrayList<Image> imageList = new ArrayList<>();
    private Hashtable<Integer, Integer> imageResIDs = new Hashtable<>();
    private MyPageAdapter pageAdapter;
    private ViewPager viewPager;
    public int currentItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flyui = new Flyui(this);
        flyui.onCreate();
        pageAdapter = new MyPageAdapter();
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(pageAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                FlyLog.d("current item ="+position);
                currentItem = position;
                FlyEvent.sendEvent("100502",imageList.get(currentItem).url);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected void onDestroy() {
        flyui.onDestroy();
        super.onDestroy();
    }

    private void onPlayFore(boolean isLoop) {
        if (imageList == null || imageList.isEmpty()) {
            return;
        }
        viewPager.setCurrentItem(isLoop ? (currentItem + imageList.size() - 1) % imageList.size() : Math.max(0, currentItem - 1));
    }

    private void onPlayNext(boolean isLoop) {
        if (imageList == null || imageList.isEmpty()) {
            return;
        }
        viewPager.setCurrentItem(isLoop ? (currentItem + 1) % imageList.size() : Math.min(imageList.size() - 1, currentItem + 1));
    }

    @Override
    public void notifyPathChange(String path) {
        FlyLog.d("notifyPathChange path=%s", path);
        FlyEvent.sendEvent("100402", path);
        if (isStop) return;
        imageList.clear();
        pageAdapter.notifyDataSetChanged();
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
    public void imageUrlList(List<Image> imageUrlList) {
        try {
            if (isStop) return;
            if (!imageUrlList.isEmpty()) {
                imageList.addAll(imageUrlList);
                pageAdapter.notifyDataSetChanged();

            }
            notifyImageList();

        } catch (Exception e) {
            FlyLog.e(e.toString());
        }
        super.imageUrlList(imageUrlList);
    }

    @Override
    public void musicID3UrlList(List<Music> musicUrlList) {
        super.musicID3UrlList(musicUrlList);
        if (!imageList.isEmpty()) {
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
        FlyEvent.sendEvent("40030201", "图片\n(" + listSingle.size() + ")");
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
                onPlayNext(false);
                break;
            case "200302":
                onPlayFore(false);
                break;
            case "300103":
                obj = FlyEvent.getValue(key);
                if (obj instanceof String) {
                    for(int i=0;i<imageList.size();i++){
                        if(obj.equals(imageList.get(i).url)){
                            viewPager.setCurrentItem(i);
                            break;
                        }
                    }
                }
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

    private class MyPageAdapter extends PagerAdapter {
        private HashSet<PhotoView> viewSet = new HashSet<>();

        private View.OnClickListener photoOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                } catch (Exception e) {
                    FlyLog.e(e.toString());
                }
            }
        };

        @Override
        public int getCount() {
            return imageList == null ? 0 : imageList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            PhotoView photoView = (PhotoView) object;
            photoView.recycle();
            viewSet.add(photoView);
            container.removeView(photoView);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            com.jancar.media.utils.FlyLog.d("set size=%d", viewSet.size());
            PhotoView photoView = null;
            Iterator it = viewSet.iterator();
            if (it.hasNext()) {
                photoView = (PhotoView) it.next();
                viewSet.remove(photoView);
            } else {
                photoView = new PhotoView(PhotoActivity.this);
            }
            photoView.setOnClickListener(photoOnClickListener);
            imageResIDs.put(position, View.generateViewId());
            photoView.setId(imageResIDs.get(position));
            photoView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            photoView.setZoomable(true);
            Glide.with(PhotoActivity.this)
                    .load(imageList.get(position).url)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .error(R.drawable.media_image_error)
                    .into(photoView);
            try {
                container.addView(photoView);
            } catch (Exception e) {
                com.jancar.media.utils.FlyLog.e(e.toString());
            }
            return photoView;
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

    }

}
