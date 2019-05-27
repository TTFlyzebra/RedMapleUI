package com.flyzebra.launcher.network;


import com.flyzebra.flyui.bean.ThemeBean;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface Api {

    @GET("api/theme")
    Observable<List<ThemeBean>> doTheme();

}