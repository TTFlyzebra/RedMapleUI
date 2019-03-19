package com.flyzebra.redmapleui.network;

import com.naodui.models.CostRank;
import com.naodui.models.Goddess;
import com.naodui.models.GoddessRank;
import com.naodui.models.HttpResult;
import com.naodui.models.ListBean;

import rx.Subscriber;


/**
 * 接收action
 * Created by Tan on 2018/7/27.
 */
public interface AppAction {
    void doHotList(String uid, String token, int latitude, int longitude, int limit, int offset,
                   String search, Subscriber<HttpResult<ListBean<Goddess>>> subscriber);

    void doRecommandList(String uid, String token, int latitude, int longitude, int limit, int offset,
                         String search, Subscriber<HttpResult<ListBean<Goddess>>> subscriber);

    void doCostRanking(Subscriber<HttpResult<ListBean<CostRank>>> subscriber);

    void doGoddessRanking(Subscriber<HttpResult<ListBean<GoddessRank>>> subscriber);
}
