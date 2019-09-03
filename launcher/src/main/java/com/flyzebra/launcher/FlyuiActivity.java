package com.flyzebra.launcher;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.flyzebra.flyui.GlideApp;
import com.flyzebra.flyui.bean.ThemeBean;
import com.flyzebra.flyui.chache.DiskCache;
import com.flyzebra.flyui.chache.IDiskCache;
import com.flyzebra.flyui.chache.IUpdataVersion;
import com.flyzebra.flyui.chache.UpdataVersion;
import com.flyzebra.flyui.event.FlyEvent;
import com.flyzebra.flyui.event.IFlyEvent;
import com.flyzebra.flyui.utils.AppUtil;
import com.flyzebra.flyui.utils.ByteUtil;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.utils.SPUtil;
import com.flyzebra.flyui.utils.SysproUtil;
import com.flyzebra.flyui.view.themeview.ThemeView;
import com.flyzebra.launcher.mediainfo.MediaInfo;

/**
 * Author FlyZebra
 * 2019/3/20 10:55
 * Describ:
 **/
public class FlyuiActivity extends Activity implements IFlyEvent, IUpdataVersion.CheckCacheResult,IUpdataVersion.UpResult {

    private ThemeView mThemeView;
    public IUpdataVersion iUpDataVersion;
    public IDiskCache iDiskCache;
    private MediaInfo mediaInfo;
    private String themeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FlyLog.d();
        super.onCreate(savedInstanceState);
        mThemeView = new ThemeView(this);
        setContentView(mThemeView);
        mThemeView.onCreate(this);
        iDiskCache = new DiskCache().init(this);
        iUpDataVersion = new UpdataVersion(getApplicationContext(), iDiskCache);
        mediaInfo = new MediaInfo(this);
        mediaInfo.onCreate();

        openByIntent(getIntent());
    }

    private void openByIntent(Intent intent) {
        String themeName = (String) SPUtil.get(this, "themeName", "Launcher-AP1");
        String url = SysproUtil.get(FlyuiActivity.this, SysproUtil.Property.URL_BASE, "http://192.168.1.88/uiweb");
        String token = "1234567890";
        String ApiTheme = "/api/app?type=%s&themeName=%s&version=%s";
        String type = AppUtil.getApplicationName(this);
        String version = AppUtil.getVersionName(this);
        if (intent != null) {
            String str = intent.getStringExtra("THEME_NAME");
            if (!TextUtils.isEmpty(str)) {
                themeName = new String(str);
            }
        }
        if (!TextUtils.isEmpty(themeName) && !themeName.equals(this.themeName)) {
            iUpDataVersion.initApi(url, ApiTheme, type, themeName, version, token);
            iUpDataVersion.forceUpVersion(this);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        openByIntent(getIntent());
    }

    @Override
    protected void onDestroy() {
        FlyLog.d();
        mediaInfo.onDestory();
        mThemeView.onDestory();
        iUpDataVersion.cancelAllTasks();
        FlyEvent.unregister(this);
        FlyEvent.clear();
        super.onDestroy();
    }


    @Override
    public void upVersionOK(ThemeBean themeBean) {
        upView(themeBean);
    }

    @Override
    public void upVesionProgress(String msg, int sum, int progress) {

    }

    @Override
    public void upVersionFaile(String error) {
        iUpDataVersion.getCacheData(this);
    }

    @Override
    public void getCacheDataOK(ThemeBean themeBean) {
        upView(themeBean);
    }

    @Override
    public void getCacheDataFaile(String error) {
        FlyLog.d("getCacheDataFaile");
        iUpDataVersion.forceUpVersion(this);
    }

    private void upView(ThemeBean themeBean) {
        Glide.get(this).clearMemory();
        this.themeName = themeBean.themeName;
        SPUtil.set(this, "themeName", themeName);
        FlyEvent.unregisterAll();
        FlyEvent.register(this);
        mThemeView.upData(themeBean);
        if (TextUtils.isEmpty(themeBean.imageurl)) {
            getWindow().getDecorView().setBackground(null);
        } else {
            GlideApp.with(this)
                    .load(themeBean.imageurl)
                    .override(1024, 600)
                    .into(new CustomTarget<Drawable>() {
                        @Override
                        public synchronized void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                            getWindow().getDecorView().setBackground(resource);
                            FlyLog.d("resource=" + resource.getBounds());
                        }

                        @Override
                        public void onLoadCleared(@Nullable Drawable placeholder) {
                            FlyLog.d("placeholder=" + placeholder);
                        }
                    });
        }
    }

    @Override
    public boolean recvEvent(byte[] key) {
        String id = ByteUtil.bytes2HexString(key);
        switch (id) {
            case "200301":
                mediaInfo.playPasue();
                break;
            case "200302":
                mediaInfo.playPrev();
                break;
            case "200303":
                mediaInfo.playNext();
                break;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
