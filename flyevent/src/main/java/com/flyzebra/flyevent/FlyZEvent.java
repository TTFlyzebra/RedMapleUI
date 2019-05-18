package com.flyzebra.flyevent;

/**
 * Author FlyZebra
 * 2019/5/6 9:58
 * Describ:
 **/
public class FlyZEvent {

    static volatile FlyZEvent defaultInstance;
    public static FlyZEvent getDefault() {
        FlyZEvent instance = defaultInstance;
        if (instance == null) {
            synchronized (FlyZEvent.class) {
                instance = FlyZEvent.defaultInstance;
                if (instance == null) {
                    instance = FlyZEvent.defaultInstance = new FlyZEvent();
                }
            }
        }
        return instance;
    }

    private FlyZEvent(){

    }
}
