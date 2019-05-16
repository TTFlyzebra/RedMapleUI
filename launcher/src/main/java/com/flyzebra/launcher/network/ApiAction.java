package com.flyzebra.launcher.network;


import com.flyzebra.flyui.bean.ThemeBean;

import rx.Subscriber;

public interface ApiAction {
    void doTheme(String appname,Subscriber<ThemeBean> subscriber);
}