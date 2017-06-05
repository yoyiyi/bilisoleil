package com.yoyiyi.soleil.network.api;

import com.yoyiyi.soleil.bean.recommend.AllStationRank;
import com.yoyiyi.soleil.bean.region.AllRegionRank;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 16:25
 * 描述:排行
 */

public interface RankService {

    /**
     * 全站排行
     * @param type
     * @return
     */
    @GET("index/rank/{type}")
    Flowable<AllStationRank> getAllStationRank(@Path("type") String type);

    /**
     * 全区排行
     *
     * @param type
     * @return
     */
    @GET("index/rank/{type}")
    Flowable<AllRegionRank> getAllRegionRank(@Path("type") String type);
}
