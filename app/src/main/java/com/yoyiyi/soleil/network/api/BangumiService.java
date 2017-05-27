package com.yoyiyi.soleil.network.api;

import com.yoyiyi.soleil.bean.chase.ChaseBangumi;
import com.yoyiyi.soleil.bean.chase.RecommendBangumi;
import com.yoyiyi.soleil.network.response.HttpResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 12:01
 * 描述:
 */

public interface BangumiService {

    /**
     * 首页追番
     *
     * @return
     */
    @GET("/appindex/follow_index_mine?access_key=640efdbe3a382e5522491d7f913118fa&appkey=1d8b6e7d45233436&build=505000&mid=117143614&mobi_app=android&platform=android&ts=1495878887&sign=26909b825ee9aa3136c82f192688829d")
    Flowable<HttpResponse<ChaseBangumi>> getChaseBangumi();
    /**
     * 首页追番推荐
     *
     * @return
     */
    @GET("/appindex/follow_index_page?appkey=1d8b6e7d45233436&build=505000&mobi_app=android&platform=android&ts=1495878887&sign=1b069620b35b65619bd18566dacc6342")
    Flowable<HttpResponse<RecommendBangumi>> getRecommendBangumi();
}
