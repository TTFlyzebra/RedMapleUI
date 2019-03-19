package com.flyzebra.redmapleui.network;

import com.naodui.models.CostRank;
import com.naodui.models.Goddess;
import com.naodui.models.GoddessRank;
import com.naodui.models.HttpResult;
import com.naodui.models.ListBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Retrofit 请求接口
 * Created by Tan on 2018/7/27.
 */
public interface NetService {
    /**
     *首页请求热门列表
     * @param uid
     * @param token
     * @param latitude
     * @param longitude
     * @param limit
     * @param offset
     * @param search
     * @return
     */
    @FormUrlEncoded
    @POST("home/hot")
    Observable<HttpResult<ListBean<Goddess>>> doHotList(@Field("u") String uid, @Field("s") String token,
                                                        @Field("latitude") int latitude, @Field("longitude") int longitude,
                                                        @Field("limit") int limit, @Field("offset") int offset,
                                                        @Field("search") String search);
    @FormUrlEncoded
    @POST("home/recommand")
    Observable<HttpResult<ListBean<Goddess>>> doRecommandList(@Field("u") String uid, @Field("s") String token,
                                                              @Field("latitude") int latitude, @Field("longitude") int longitude,
                                                              @Field("limit") int limit, @Field("offset") int offset,
                                                              @Field("search") String search);

    @POST("/cost/ranking")
    Observable<HttpResult<ListBean<CostRank>>> doCostRanking();

    @POST("/goddess/ranking")
    Observable<HttpResult<ListBean<GoddessRank>>> doGoddessRanking();

}
