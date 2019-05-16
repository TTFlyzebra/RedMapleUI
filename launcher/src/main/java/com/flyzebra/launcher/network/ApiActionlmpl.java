package com.flyzebra.launcher.network;


import com.flyzebra.flyui.bean.ThemeBean;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ApiActionlmpl implements ApiAction {
    private HttpService mHttpService;
    private Api mNetService;

    public ApiActionlmpl() {
        mHttpService = new HttpService();
        mNetService = mHttpService.getInspectionService();
    }

    @Override
    public void doTheme(String appname, Subscriber<ThemeBean> subscriber) {
        mNetService.doTheme(appname)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
