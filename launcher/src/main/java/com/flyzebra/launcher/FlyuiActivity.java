package com.flyzebra.launcher;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.flyzebra.flyui.GlideApp;
import com.flyzebra.flyui.IAction;
import com.flyzebra.flyui.bean.ThemeBean;
import com.flyzebra.flyui.chache.DiskCache;
import com.flyzebra.flyui.chache.IDiskCache;
import com.flyzebra.flyui.chache.IUpdataVersion;
import com.flyzebra.flyui.chache.UpdataVersion;
import com.flyzebra.flyui.module.FlyAction;
import com.flyzebra.flyui.utils.AppUtil;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.utils.SysproUtils;
import com.flyzebra.flyui.view.themeview.ThemeView;

/**
 * Author FlyZebra
 * 2019/3/20 10:55
 * Describ:
 **/
public class FlyuiActivity extends Activity implements IAction, IUpdataVersion.CheckCacheResult, IUpdataVersion.UpResult {

    private ThemeView mThemeView;
    public IUpdataVersion iUpDataVersion;
    public IDiskCache iDiskCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FlyLog.d();
        super.onCreate(savedInstanceState);
        mThemeView = new ThemeView(this);
        setContentView(mThemeView);
        mThemeView.onCreate(this);
        iDiskCache = new DiskCache().init(this);
        iUpDataVersion = new UpdataVersion(getApplicationContext(), iDiskCache) {
            @Override
            public void initApi() {
                String url = SysproUtils.get(FlyuiActivity.this, SysproUtils.Property.URL_BASE, "http://192.168.1.119:801/uiweb");
                String areaCode = SysproUtils.get(FlyuiActivity.this, SysproUtils.Property.AREA_CODE, "0");
                String version = AppUtil.getVersionName(FlyuiActivity.this);
                token = "12345678";
                ApiUrl = url;
                ApiVersion = "/api/version?areaCode=" + areaCode + "&type=launcher&version=" + version;
                ApiTheme = "/api/app?appname=Launcher-AP1&areaCode=" + areaCode + "&type=launcher&version=" + version;
            }
        };
        iUpDataVersion.forceUpVersion(this);
    }

    @Override
    protected void onStart() {
        FlyAction.notifyAction(1, null);
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        FlyLog.d();
        mThemeView.onDestory();
        iUpDataVersion.cancelAllTasks();
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

    private Drawable drawable;

    private void upView(ThemeBean themeBean) {
        mThemeView.upData(themeBean);
        if (TextUtils.isEmpty(themeBean.imageurl)) {
            getWindow().getDecorView().setBackground(null);
        } else {
            GlideApp.with(this)
                    .load(themeBean.imageurl)
                    .override(1024,600)
                    .into(new CustomTarget<Drawable>() {
                        @Override
                        public synchronized void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                            getWindow().getDecorView().setBackground(resource);
                            FlyLog.d("resource="+resource.getBounds());
                        }

                        @Override
                        public void onLoadCleared(@Nullable Drawable placeholder) {
                            FlyLog.d("placeholder="+placeholder);
                        }
                    });
        }
    }

    @Override
    public boolean onAction(int key) {
        return false;
    }
}
