package com.flyzebra.redmapleui.network;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit管理类
 * Created by Tan on 2018/7/26.
 */
public class ServiceGenerator {
    public static String API_BASE_URL = "http://192.168.10.154/";
    private static final int DEFAULT_TIMEOUT = 10;
    private NetService mNetService;
    private static boolean isWork = false;
    public ServiceGenerator() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(httpClientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(API_BASE_URL)
                    .build();
            mNetService = retrofit.create(NetService.class);
            isWork = true;
        }catch (Exception e){
            e.printStackTrace();
            isWork = false;
        }
    }
    public NetService getInspectionService() {
        return mNetService;
    }
    public static boolean getConfigStatus(){
        return isWork;
    }
}
