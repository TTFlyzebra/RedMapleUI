package com.flyzebra.flyui;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.ViewGroup;

import com.flyzebra.flyui.bean.ThemeBean;
import com.flyzebra.flyui.chache.DiskCache;
import com.flyzebra.flyui.chache.IDiskCache;
import com.flyzebra.flyui.chache.IUpdataVersion;
import com.flyzebra.flyui.chache.UpdataVersion;
import com.flyzebra.flyui.config.ActionKey;
import com.flyzebra.flyui.module.FlyAction;
import com.flyzebra.flyui.module.FlyClass;
import com.flyzebra.flyui.utils.FlyLog;
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
        activity.addContentView(mThemeView,new ViewGroup.LayoutParams(-1,-1));
        mThemeView.onCreate(activity);
        if(activity instanceof IAction){
            FlyAction.register((IAction) activity);
        }
        iDiskCache = new DiskCache().init(activity);
        iUpDataVersion = new UpdataVersion(activity.getApplicationContext(), iDiskCache) {
            @Override
            public void initApi() {
                token = "1234567890";
                ApiUrl = "http://192.168.1.119:801/uiweb";
                ApiVersion = "/api/version?areaCode=0&type="+getApplicationName(activity)+"&version=v1.0";
                ApiTheme = "/api/app?areaCode=0&type="+getApplicationName(activity)+"&version=v1.0";
            }
        };
        iUpDataVersion.forceUpVersion(this);
    }

    public void onDestroy() {
        FlyLog.d("onDestroy");
        if(activity instanceof IAction){
            FlyAction.unregister((IAction) activity);
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
        iUpDataVersion.getCacheData(this);
    }

    @Override
    public void getCacheDataOK(ThemeBean themeBean) {
        upView(themeBean);
    }

    @Override
    public void getCacheDataFaile(String error) {
        iUpDataVersion.forceUpVersion(this);
    }

    private void upView(ThemeBean themeBean) {
        mThemeView.upData(themeBean);
        FlyAction.notifyAction(ActionKey.REFRESH);
    }

    public String getApplicationName(Activity activity) {
        PackageManager packageManager = null;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = activity.getApplicationContext().getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(activity.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            FlyLog.e(e.toString());
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

}
