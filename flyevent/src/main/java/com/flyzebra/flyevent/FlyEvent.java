package com.flyzebra.flyevent;

/**
 * Author FlyZebra
 * 2019/5/6 9:58
 * Describ:
 **/
public class FlyEvent {

    static volatile FlyEvent defaultInstance;
    public static FlyEvent getDefault() {
        FlyEvent instance = defaultInstance;
        if (instance == null) {
            synchronized (FlyEvent.class) {
                instance = FlyEvent.defaultInstance;
                if (instance == null) {
                    instance = FlyEvent.defaultInstance = new FlyEvent();
                }
            }
        }
        return instance;
    }

    private FlyEvent(){

    }
}
