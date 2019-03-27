package com.flyzebra.flyui.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.List;

/**
 */

public class AppUtil {

    public static String[] mFliter = {
            "com.ppfuns.launcher",
            "com.ppfuns."
//            "com.alliance.homeshell"
    };
    private static int MAX_RECENT_TASKS = 10;

    /**
     * 检测APP是否安装
     *
     * @param context     上下文
     * @param packagename 包名
     * @return true:已安装该应用
     * false:未安装该应用
     */
    public static boolean isAppInstalled(Context context, String packagename) {
        if (packagename != null) {
            packagename = packagename.trim();
        }
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packagename, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
//            e.printStackTrace();
        }
        if (packageInfo == null) {
            FlyLog.d(packagename + "app not installed....");
            return false;
        } else {
            FlyLog.d(packagename + "app  installed....");
            return true;
        }
    }

    /**
     * 判断是否为系统应用
     *
     * @param context
     * @param packageName 应用包名
     * @return true：系统应用   false：非系统应用
     */
    public static boolean isSystemApp(Context context, String packageName) {
        boolean isSystemApp = false;
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                isSystemApp = true;
            }
        } catch (PackageManager.NameNotFoundException e) {
            FlyLog.e(e.toString());
            e.printStackTrace();
        }
        return isSystemApp;
    }


    /**
     * 获取versionCode
     *
     * @param context
     * @return
     */
    public static String getVersionCode(Context context) {
        try {
            String pkName = context.getPackageName();
            return context.getPackageManager()
                    .getPackageInfo(pkName, 0).versionCode + "";
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 获取versionName
     *
     * @param context
     * @return
     */
    public static String getVersionName(Context context) {
        try {
            String pkName = context.getPackageName();
            return context.getPackageManager().getPackageInfo(
                    pkName, 0).versionName;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * @param context 上下文
     * @param intent  intent携带activity
     * @return boolean true为在最顶层，false为否
     * @Description: 判断activity是否在应用的最顶层
     */
    public static boolean isTop(Context context, Intent intent) {
        ActivityManager am = (ActivityManager) context.getSystemService(context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> appTask = am.getRunningTasks(1);
        FlyLog.d(appTask.get(0).topActivity.toString() + " intent:" + intent.getComponent());
        if (appTask.size() > 0 && appTask.get(0).topActivity.equals(intent.getComponent())) {
            FlyLog.d(" is in top");
            return true;
        } else {
            FlyLog.d(" not in top");
            return false;
        }
    }

    /**
     * 判断主应用是否在顶层
     *
     * @param context
     * @return
     */
    public static boolean isAppTop(Context context) {
        try {
            String className = "com.ppfuns.launcher.ui.LauncherActivity";
            ActivityManager am = (ActivityManager) context.getSystemService(context.ACTIVITY_SERVICE);
            ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
            return cn.getClassName().contains(className);
        } catch (Exception e) {
            e.printStackTrace();
            FlyLog.e(e.toString());
        }
        return true;
    }

    /**
     * 判断主应用首界面是否在顶层
     *
     * @param context
     * @return
     */
    public static boolean isActivityTop(Context context) {
        try {
            String className = "com.ppfuns.launcher.ui.LauncherActivity";
            ActivityManager am = (ActivityManager) context.getSystemService(context.ACTIVITY_SERVICE);
            ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
            return cn.getClassName().equals(className);
        } catch (Exception e) {
            e.printStackTrace();
            FlyLog.e(e.toString());
        }
        return true;
    }
}
