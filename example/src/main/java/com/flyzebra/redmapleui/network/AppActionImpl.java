package com.flyzebra.redmapleui.network;

import com.naodui.models.CostRank;
import com.naodui.models.Goddess;
import com.naodui.models.GoddessRank;
import com.naodui.models.HttpResult;
import com.naodui.models.ListBean;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * action 实现类
 * Created by Tan on 2018/7/27.
 */
public class AppActionImpl implements AppAction{
    private ServiceGenerator mServiceGenerator;
    private NetService mNetService;
    private AppActionImpl application;
    public AppActionImpl() {
        mServiceGenerator = new ServiceGenerator();
        mNetService = mServiceGenerator.getInspectionService();
    }

    @Override
    public void doHotList(String uid, String token, int latitude, int longitude, int limit, int offset, String search, Subscriber<HttpResult<ListBean<Goddess>>> subscriber) {
        mNetService.doHotList(uid, token, latitude, longitude, limit, offset, search)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void doRecommandList(String uid, String token, int latitude, int longitude, int limit, int offset, String search, Subscriber<HttpResult<ListBean<Goddess>>> subscriber) {
        mNetService.doHotList(uid, token, latitude, longitude, limit, offset, search)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void doCostRanking(Subscriber<HttpResult<ListBean<CostRank>>> subscriber) {
        mNetService.doCostRanking().subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void doGoddessRanking(Subscriber<HttpResult<ListBean<GoddessRank>>> subscriber) {
        mNetService.doGoddessRanking().subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
