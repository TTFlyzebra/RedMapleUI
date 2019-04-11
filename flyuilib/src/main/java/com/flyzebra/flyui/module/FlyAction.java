package com.flyzebra.flyui.module;

import com.flyzebra.flyui.IAction;
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
    private static Map<Integer, Object> saveKey = new Hashtable<>();

    public static FlyAction getInstance() {
        return FlyAction.FlyActionHolder.sInstance;
    }

    public static void register(IAction flyuiAction) {
        getInstance().add(flyuiAction);
    }

    public static void register(IAction flyuiAction, int key) {
        getInstance().add(flyuiAction);
        Object obj = saveKey.get(key);
        if (obj != null) {
            flyuiAction.onAction(key, saveKey.get(key));
        }
    }

    private void add(IAction flyuiAction) {
        FlyLog.d("add action=" + flyuiAction);
        flyuiEvents.add(flyuiAction);
        FlyLog.d("flyuiEvents size=%d", flyuiEvents.size());
    }

    public static void unregister(IAction flyuiAction) {
        getInstance().remove(flyuiAction);
    }

    private void remove(IAction flyuiAction) {
        FlyLog.d("remove action=" + flyuiAction);
        flyuiEvents.remove(flyuiAction);
        FlyLog.d("flyuiEvents size=%d", flyuiEvents.size());
    }

    private static class FlyActionHolder {
        public static final FlyAction sInstance = new FlyAction();
    }


    public static void clear() {
        getInstance().clearMap();
    }

    private void clearMap() {
        flyuiEvents.clear();
        saveKey.clear();
    }

    public static void notifyAction(int key) {
        getInstance().notifyAll(key, null);
    }

    public static void notifyAction(int key, Object obj) {
        getInstance().notifyAll(key, obj);
    }

    private void notifyAll(int key, Object obj) {
        FlyLog.d("flyuiEvents size=%d", flyuiEvents.size());
        FlyLog.d("notify key=%d,obj=%s,flyuiEvents size=%d", key, "" + obj, flyuiEvents.size());
        if (obj != null) {
            saveKey.put(key, obj);
        }
        for (IAction flyuiAction : flyuiEvents) {
            FlyLog.d("flyuiEvents flyuiAction=" + flyuiAction);
            flyuiAction.onAction(key, obj);
        }
    }

}
