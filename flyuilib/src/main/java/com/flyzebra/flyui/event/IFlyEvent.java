package com.flyzebra.flyui.event;

/**
 * Author FlyZebra
 * 2019/3/26 16:55
 * Describ:
 **/
public interface IFlyEvent {
    String EVENT_NAV = "400301";
    boolean recvEvent(byte[] key);
}
