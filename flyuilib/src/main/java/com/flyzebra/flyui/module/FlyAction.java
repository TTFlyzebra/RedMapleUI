package com.flyzebra.flyui.module;

import com.flyzebra.flyui.FlyuiAction;
import com.flyzebra.flyui.bean.Action;
import com.flyzebra.flyui.utils.FlyLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Author FlyZebra
 * 2019/3/25 14:36
 * Describ:
 **/
public class FlyAction {
    private static final List<FlyuiAction> flyuiEvents = new ArrayList<>();


    public static FlyAction getInstance() {
        return FlyAction.FlyActionHolder.sInstance;
    }

    public static void register(FlyuiAction flyuiAction) {
        getInstance().add(flyuiAction);
    }

    private void add(FlyuiAction flyuiAction) {
        FlyLog.d("add action="+flyuiAction);
        flyuiEvents.add(flyuiAction);
        FlyLog.d("flyuiEvents size=%d",flyuiEvents.size());
    }

    public static void unregister(FlyuiAction flyuiAction) {
        getInstance().remove(flyuiAction);
    }

    private void remove(FlyuiAction flyuiAction) {
        FlyLog.d("remove action="+flyuiAction);
        flyuiEvents.remove(flyuiAction);
        FlyLog.d("flyuiEvents size=%d",flyuiEvents.size());
    }

    private static class FlyActionHolder {
        public static final FlyAction sInstance = new FlyAction();
    }


    public static void clear() {
        getInstance().clearMap();
    }

    private void clearMap() {
        flyuiEvents.clear();
    }

    public static void notifyAction(int key,Object obj) {
        getInstance().notifyAll(key,obj);
    }

    private void notifyAll(int key,Object obj) {
        FlyLog.d("flyuiEvents size=%d",flyuiEvents.size());
        for (FlyuiAction flyuiAction : flyuiEvents) {
            flyuiAction.onAction(key,null);
        }
    }

}
