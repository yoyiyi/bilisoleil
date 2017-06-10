package com.yoyiyi.soleil.network.api;

import com.yoyiyi.soleil.bean.live.LiveEntrance;
import com.yoyiyi.soleil.bean.live.LivePartition;
import com.yoyiyi.soleil.bean.live.LiveRecommend;
import com.yoyiyi.soleil.network.response.HttpResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 16:25
 * 描述:直播
 */

public interface LiveService {
    /**
     * 首页推荐直播
     *
     * @return
     */
    @GET("/AppNewIndex/recommend?_device=android&access_key=5b0032c681c2233870c8edcee410b6c6&appkey=1d8b6e7d45233436&build=505000&mobi_app=android&platform=android&scale=xxhdpi&ts=1495639021&sign=9d024a5b09edddd51636d17d860622d2")
    Flowable<HttpResponse<LiveRecommend>> getLiveRecommend();

    /**
     * 直播分区
     *
     * @return
     */
    @GET("/AppNewIndex/common?_device=android&access_key=5b0032c681c2233870c8edcee410b6c6&appkey=1d8b6e7d45233436&build=505000&mobi_app=android&platform=android&scale=xxhdpi&ts=1495639884&sign=74b510ce56ef302742aafad2e20f9899")
    Flowable<HttpResponse<LivePartition>> getLivePartition();

    /**
     * 获取直播分区的tag标题
     *
     * @return
     */
    @GET("/AppIndex/areas?_device=android&access_key=21073183486ba556121c1160f107f0c5&appkey=1d8b6e7d45233436&build=506000&mobi_app=android&platform=android&scale=xxhdpi&ts=1496116760&sign=e2231dc84bc33bc1a7c6d8eddf13da9d")
    Flowable<HttpResponse<List<LiveEntrance>>> getLiveEntrance();
}
