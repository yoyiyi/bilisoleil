package com.yoyiyi.soleil.network.api;

import com.yoyiyi.soleil.bean.app.Splash;
import com.yoyiyi.soleil.bean.app.VideoDetail;
import com.yoyiyi.soleil.bean.chase.ChaseBangumi;
import com.yoyiyi.soleil.bean.chase.RecommendBangumi;
import com.yoyiyi.soleil.bean.discover.HotSearchTag;
import com.yoyiyi.soleil.bean.recommend.Recommend;
import com.yoyiyi.soleil.bean.region.Region;
import com.yoyiyi.soleil.bean.region.RegionRecommend;
import com.yoyiyi.soleil.bean.region.RegionType;
import com.yoyiyi.soleil.bean.search.SearchArchive;
import com.yoyiyi.soleil.network.response.HttpResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 12:01
 * 描述:
 */

public interface AppService {
    /**
     * splash界面
     *
     * @return
     */
    @GET("/x/v2/splash?mobi_app=android&build=505000&channel=360&width=1080&height=1920&ver=4344558841496142006")
    Flowable<Splash> getSplash();


    /**
     * 首页推荐
     *
     * @return
     */
    @GET("/x/feed/index?access_key=5c2ea06a566f3dd8850f5750b8d0a650&appkey=1d8b6e7d45233436&build=505000&idx=0&login_event=2&mobi_app=android&network=wifi&open_event=cold&platform=android&pull=true&style=2&ts=1495519813&sign=510278867e908ab3de31a7bd3701a55c")
    Flowable<HttpResponse<List<Recommend>>> getRecommend();

    /**
     * 首页分区
     *
     * @return
     */
    @GET("/x/v2/show/index?access_key=fcbe0b2d947971fd3cc2b9e759d63097&appkey=1d8b6e7d45233436&build=505000&mobi_app=android&platform=android&ts=1495780436&sign=93ebfdf6018d866239977af373d45dba")
    Flowable<HttpResponse<List<Region>>> getRegion();

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
     * 综合搜索
     */
    @GET(
            "x/v2/search?actionKey=appkey&appkey=27eb53fc9058f8c3&build=3710&device=phone&duration=0&mobi_app=iphone&order=default&platform=ios&rid=0")
    Flowable<HttpResponse<SearchArchive>> getSearchArchive(
            @Query("keyword") String keyword, @Query("pn") int page, @Query("ps") int pagesize);

    /**
     * 分区推荐
     */
    @GET("x/v2/region/show?access_key=67cbf6a1e9ad7d7f11bfbd918e50c837&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3600&device=phone&mobi_app=iphone&plat=1&platform=ios&sign=959d7b8c09c65e7a66f7e58b1a2bdab9&ts=1472310694")
    Flowable<HttpResponse<RegionRecommend>> getRegionRecommend(@Query("rid") int rid);

    /**
     * 分区类型详情
     */
    @GET("x/v2/region/show/child?build=3600")
    Flowable<HttpResponse<RegionType>> getRegionType(@Query("rid") int rid);

    /**
     * 视频详情
     */
    @GET("/x/v2/view?access_key=0e6adb874025dfabaa3ced3a7b22049d&aid=9938411&appkey=1d8b6e7d45233436&build=505000&from=3&mobi_app=android&plat=0&platform=android&trackid=6475482883510618178&ts=1497422373&sign=75f3393be59e612325d75d7134e612a8")
    Flowable<VideoDetail> getVideoDetail();



    /**
     * 番剧搜索
     *//*
    @GET(
            "x/v2/search/type?actionKey=appkey&appkey=27eb53fc9058f8c3&build=3710&device=phone&mobi_app=iphone&platform=ios&type=1")
    Observable<SearchBangumiInfo> searchBangumi(
            @Query("keyword") String content, @Query("pn") int page, @Query("ps") int pagesize);

    *//**
     * up主搜索
     *//*
    @GET(
            "x/v2/search/type?actionKey=appkey&appkey=27eb53fc9058f8c3&build=3710&device=phone&mobi_app=iphone&platform=ios&type=2")
    Observable<SearchUpperInfo> searchUpper(
            @Query("keyword") String content, @Query("pn") int page, @Query("ps") int pagesize);

    *//**
     * 影视搜索
     *//*
    @GET(
            "x/v2/search/type?actionKey=appkey&appkey=27eb53fc9058f8c3&build=3710&device=phone&mobi_app=iphone&platform=ios&type=3")
    Observable<SearchMovieInfo> searchMovie(
            @Query("keyword") String content, @Query("pn") int page, @Query("ps") int pagesize);*/


    /**
     * 首页发现 热门搜索标签
     *
     * @return
     */
    @GET("/x/v2/search/hot?appkey=1d8b6e7d45233436&build=506000&limit=50&mobi_app=android&platform=android&ts=1495949781&sign=9bc4cea15aa9de8a0b142db86634f11f\n")
    Flowable<HttpResponse<HotSearchTag>> getHotSearchTag();

    ///x/v2/search?access_key=172e9926859fbbf72b8aef67e67e3669&appkey=1d8b6e7d45233436&build=506000&
    /// duration=1&keyword=%E8%87%AA%E7%94%B1%E4%B9%8B%E7%BF%BC&mobi_app=android&order=default&platform=android&
    /// pn=1&ps=20&ts=1495985486&sign=2b81299a7620da51d286c2dae2112a54 HTTP/1.1
    @GET("/x/v2/search?access_key=172e9926859fbbf72b8aef67e67e3669&appkey=1d8b6e7d45233436&build=506000&" +
            "order={order}&" +//默认排序 没有；播放多 view；新发布 pubdate 弹幕多 danmaku
            "duration={duration}&" + // 1 2 3 4
            "keyword={keyword}&mobi_app=android&platform=android&" + //搜索key
            "pn={pn}&" + //页数 1 2 3 4 5
            "rid={rid}&" +//不知道
            "ps=20&ts=1495985837&sign=af7bf921a8b0bc1b02443f39995b6abf")
    Flowable<HttpResponse<HotSearchTag>> getHotSearchT222ag();

}
