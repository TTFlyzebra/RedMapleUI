package com.flyzebra.launcher.network;


import com.flyzebra.flyui.bean.ThemeBean;

import java.util.List;

import rx.Subscriber;

public interface ApiAction {
    void doTheme(Subscriber<List<ThemeBean>> subscriber);
}