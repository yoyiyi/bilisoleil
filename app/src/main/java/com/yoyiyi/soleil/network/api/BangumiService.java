package com.yoyiyi.soleil.network.api;

import com.yoyiyi.soleil.bean.bangumi.BangumiDetail;
import com.yoyiyi.soleil.bean.bangumi.BangumiDetailRecommend;
import com.yoyiyi.soleil.bean.bangumi.BangumiIndex;
import com.yoyiyi.soleil.bean.bangumi.BangumiSchedule;
import com.yoyiyi.soleil.bean.chase.ChaseBangumi;
import com.yoyiyi.soleil.bean.chase.RecommendBangumi;
import com.yoyiyi.soleil.network.response.HttpResponse;

import java.util.List;

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

    /**
     * 番剧时间表
     */
    @GET(
            "api/timeline_v4?access_key=19946e1ef3b5cad1a756c475a67185bb&actionKey=appkey&appkey=27eb53fc9058f8c3&area_id=2&build=3940&device=phone&mobi_app=iphone&platform=ios&see_mine=0&sign=d8cbbacab2e5fd0196b4883201e2103e&ts=1477981526")
    Flowable<HttpResponse<List<BangumiSchedule>>> getBangumiSchedule();

    /**
     * 番剧索引
     */
    @GET(
            "api/bangumi_index_cond?access_key=19946e1ef3b5cad1a756c475a67185bb&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3940&device=phone&mobi_app=iphone&platform=ios&sign=cfc6903a13ba89e81c904b4c589e5369&ts=1477974966&type=0")
    Flowable<HttpResponse<BangumiIndex>> getBangumiIndex();

   /* *//**
     * 首页番剧
     *//*
    @GET("api/app_index_page_v4?build=3940&device=phone&mobi_app=iphone&platform=ios")
    Observable<BangumiAppIndexInfo> getBangumiAppIndex();*/

    /**
     * 番剧详情番剧推荐
     */
    @GET("api/season/recommend/5070.json?access_key=19946e1ef3b5cad1a756c475a67185bb&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3940&device=phone&mobi_app=iphone&platform=ios&season_id=5070&sign=744e3a3f52829e4344c33908f7a0c1ef&ts=1477898527")
    Flowable<HttpResponse<BangumiDetailRecommend>> getBangumiDetailRecommend();

    /**
     * 番剧详情
     */
    @GET(
            "api/season_v4?access_key=19946e1ef3b5cad1a756c475a67185bb&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3940&device=phone&mobi_app=iphone&platform=ios&season_id=5070&sign=3e5d4d7460961d9bab5da2341fd98dc1&ts=1477898526&type=bangumi")
    Flowable<HttpResponse<BangumiDetail>> getBangumiDetail();
}
