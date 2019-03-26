package com.flyzebra.flyui.module;

import android.util.ArrayMap;

import com.flyzebra.flyui.utils.FlyLog;

/**
 * Author FlyZebra
 * 2019/3/25 14:36
 * Describ:
 **/
public class FlyClass {
    private static final ArrayMap<Object, Object> clsMap = new ArrayMap<>();


    public static FlyClass getInstance() {
        return FlyClass.FlyClassHolder.sInstance;
    }

    private static class FlyClassHolder {
        public static final FlyClass sInstance = new FlyClass();
    }


    public static void clear() {
        getInstance().clearMap();
    }

    private void clearMap() {
        clsMap.clear();
    }

    public static <T> T get(Class<T> key) {
        return getInstance().getClass(key);
    }

    public static void register(Class<?> key, Object obj) {
        getInstance().putClass(key, obj);
    }

    public static void unregister(Class<?> key) {
        getInstance().removeClass(key);
    }

    private void putClass(Class<?> key, Object cls) {
        FlyLog.d("add class="+key);
        clsMap.put(key, cls);
    }


    private void removeClass(Class<?> key) {
        FlyLog.d("remove class="+key);
        clsMap.remove(key);
    }

    private <T> T getClass(Class<T> key) {
        return (T) clsMap.get(key);
    }

}
