package com.flyzebra.flyui.bean;

import android.content.Context;

/**
 * Author FlyZebra
 * 2019/3/26 9:55
 * Describ:
 **/
public class Event {
    public static final String ACTIVITY = "activity";
    public static final String SERVICE = "service";
    public static final String CUSTOM = "custom";
    public String eventType;
    public String intent;
    public String className;

    public void handleString(String str) {

    }

    public boolean doEvent(Context context) {
        switch (eventType) {
            case ACTIVITY:
                break;
            case SERVICE:
                break;
            case CUSTOM:
                break;
        }
        return false;
    }
}
