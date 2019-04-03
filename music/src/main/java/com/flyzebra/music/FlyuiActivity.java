package com.flyzebra.music;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.flyzebra.flyui.FlyuiAction;
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
public class FlyuiActivity extends Activity implements FlyuiAction, IUpdataVersion.CheckCacheResult, IUpdataVersion.UpResult {

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
                ApiUrl = TextUtils.isEmpty(url) ? "http://192.168.1.119:801/uiweb" : url;
                ApiVersion = "/api/version?areaCode=" + areaCode + "&type=launcher&version=" + version;
                ApiTheme = "/api/app?areaCode=" + areaCode + "&type=launcher&version=" + version;
            }
        };
        iUpDataVersion.getCacheData(this);
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
    public void onAction(int key, Object object) {
        switch (key) {
            default:
                break;
        }
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

    }

    @Override
    public void getCacheDataOK(ThemeBean themeBean) {
        upView(themeBean);
        iUpDataVersion.forceUpVersion(this);
    }

    @Override
    public void getCacheDataFaile(String error) {
        iUpDataVersion.forceUpVersion(this);
    }

    private void upView(ThemeBean themeBean) {
        mThemeView.upData(themeBean);
        if (TextUtils.isEmpty(themeBean.imageurl)) {
            getWindow().getDecorView().setBackground(null);
        } else {
//            Glide.with(this)
//                    .load(themeBean.imageurl)
//                    .override(1024, 600)
//                    .into(new SimpleTarget<GlideDrawable>() {
//                        @Override
//                        public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
//                            getWindow().getDecorView().setBackground(glideDrawable);
//                        }
//                    });
        }
    }
}
