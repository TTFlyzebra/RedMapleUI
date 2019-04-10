package com.flyzebra.flyui;

import android.app.Activity;
import android.text.TextUtils;

import com.flyzebra.flyui.bean.ThemeBean;
import com.flyzebra.flyui.chache.DiskCache;
import com.flyzebra.flyui.chache.IDiskCache;
import com.flyzebra.flyui.chache.IUpdataVersion;
import com.flyzebra.flyui.chache.UpdataVersion;
import com.flyzebra.flyui.module.FlyAction;
import com.flyzebra.flyui.module.FlyClass;
import com.flyzebra.flyui.utils.AppUtil;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.utils.SysproUtils;
import com.flyzebra.flyui.view.themeview.ThemeView;

/**
 * Author FlyZebra
 * 2019/4/4 11:31
 * Describ:
 **/
public class Flyui implements IUpdataVersion.CheckCacheResult, IUpdataVersion.UpResult {
    private Activity activity;
    private ThemeView mThemeView;
    private IUpdataVersion iUpDataVersion;
    private IDiskCache iDiskCache;

    public Flyui(Activity activity){
        this.activity = activity;
    }

    public void onCreate() {
        FlyLog.d("onCreate");
        mThemeView = new ThemeView(activity);
        activity.setContentView(mThemeView);
        mThemeView.onCreate(activity);
        if(activity instanceof FlyuiAction){
            FlyAction.register((FlyuiAction) activity);
        }
        iDiskCache = new DiskCache().init(activity);
        iUpDataVersion = new UpdataVersion(activity.getApplicationContext(), iDiskCache) {
            @Override
            public void initApi() {
                String url = SysproUtils.get(activity, SysproUtils.Property.URL_BASE, "http://192.168.1.119:801/uiweb");
                String areaCode = SysproUtils.get(activity, SysproUtils.Property.AREA_CODE, "0");
                String version = AppUtil.getVersionName(activity);
                token = "1234567890";
                ApiUrl = TextUtils.isEmpty(url) ? "http://192.168.1.119:801/uiweb" : url;
                ApiVersion = "/api/version?areaCode=" + areaCode + "&type=launcher&version=" + version;
                ApiTheme = "/api/app?areaCode=" + areaCode + "&type=launcher&version=" + version;
            }
        };
        iUpDataVersion.getCacheData(this);
    }

    public void onDestroy() {
        FlyLog.d("onDestroy");
        if(activity instanceof FlyuiAction){
            FlyAction.unregister((FlyuiAction) activity);
        }
        mThemeView.onDestory();
        iUpDataVersion.cancelAllTasks();
        FlyClass.clear();
        FlyAction.clear();
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
        FlyAction.notifyAction(ActionKey.REFRESH);
    }
}
