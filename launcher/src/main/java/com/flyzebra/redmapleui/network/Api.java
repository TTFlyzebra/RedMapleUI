package com.flyzebra.redmapleui.network;


import com.flyzebra.flyui.bean.ThemeBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface Api {

    @GET("api/app")
    Observable<ThemeBean> doTheme(@Query("appname") String appname);

}
