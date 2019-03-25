package com.flyzebra.flyui.module;

import android.util.ArrayMap;

/**
 * Author FlyZebra
 * 2019/3/25 14:36
 * Describ:
 **/
public class FlyFindClass {
    public static final String TOP_NAV = "THEME_TOP_NAV";
    public static final String PAGES = "THEME_PAGES";
    private final ArrayMap<Object, Object> clsMap = new ArrayMap<>();


    public static FlyFindClass getInstance() {
        return FlyFindClass.FindThemeClassHolder.sInstance;
    }

    private static class FindThemeClassHolder {
        public static final FlyFindClass sInstance = new FlyFindClass();
    }


    public static void relese() {
        getInstance().freeMap();
    }

    private void freeMap() {
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
        clsMap.put(key, cls);
    }


    private void removeClass(Class<?> key) {
        clsMap.remove(key);
    }

    private <T> T getClass(Class<T> key) {
        return (T) clsMap.get(key);
    }

}
