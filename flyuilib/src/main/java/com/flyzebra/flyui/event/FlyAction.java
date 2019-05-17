package com.flyzebra.flyui.event;

import com.flyzebra.flyui.utils.ByteTools;
import com.flyzebra.flyui.utils.FlyLog;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Author FlyZebra
 * 2019/3/25 14:36
 * Describ:
 **/
public class FlyAction {
    private static final List<IAction> flyuiEvents = new ArrayList<>();
    private static final Map<String, Object> saveKey = new Hashtable<>();

    public static FlyAction getInstance() {
        return FlyAction.FlyActionHolder.sInstance;
    }

    public static Object saveValue(byte[] key, Object obj) {
        return saveKey.put(ByteTools.bytes2HexString(key), obj);
    }

    public static Object getValue(byte[] key) {
        return saveKey.get(ByteTools.bytes2HexString(key));
    }

    public static Object saveValue(String key, Object obj) {
        return saveKey.put(key, obj);
    }

    public static Object getValue(String key) {
        return saveKey.get(key);
    }


    public static void register(IAction flyuiAction) {
        getInstance().registerMe(flyuiAction);
    }

    public static void register(IAction flyuiAction, byte[] key) {
        getInstance().registerMe(flyuiAction);
    }

    private void registerMe(IAction flyuiAction) {
        if (flyuiAction != null) {
            synchronized (flyuiEvents) {
                flyuiEvents.add(flyuiAction);
            }
            FlyLog.v("size=%d, add action=" + flyuiAction, flyuiEvents.size());
        }
    }

    public static void unregister(IAction flyuiAction) {
        getInstance().unregisterMe(flyuiAction);
    }

    private void unregisterMe(IAction flyuiAction) {
        if (flyuiAction != null) {
            synchronized (flyuiEvents) {
                flyuiEvents.remove(flyuiAction);
            }
            FlyLog.v("size=%d, remove action=" + flyuiAction, flyuiEvents.size());
        }
    }

    private static class FlyActionHolder {
        static final FlyAction sInstance = new FlyAction();
    }

    public static void handleAction(String key) {
        getInstance().handleAll(ByteTools.hexString2Bytes(key));
    }

    public static void handleAction(byte[] key) {
        getInstance().handleAll(key);
    }


    private void handleAll(byte[] key) {
        synchronized (flyuiEvents) {
            for (IAction flyuiAction : flyuiEvents) {
                flyuiAction.handleAction(key);
            }
        }
    }

    public static void clear() {
        getInstance().clearMap();
    }

    private void clearMap() {
        flyuiEvents.clear();
        saveKey.clear();
    }

}
