package com.yoyiyi.soleil.network.api;

import com.yoyiyi.soleil.bean.discover.Community;
import com.yoyiyi.soleil.bean.discover.InterestAd;
import com.yoyiyi.soleil.bean.discover.InterestCategrory;
import com.yoyiyi.soleil.network.response.HttpResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/10 21:40
 * 描述:
 */
public interface Im9Service {
    /**
     * 兴趣圈入口
     */
    @GET("api/query.community.category.list.do?access_key=69c28b2a6f25d397c973519254d8aedd&actionKey=appkey&appkey=1d8b6e7d45233436&build=506000&mobi_app=" +
            "android&platform=android&ts=1497101501&sign=febb5804ca612ad94d50f626229dc499")
    Flowable<HttpResponse<InterestCategrory>> getInterestCategrory();

    /**
     * 交流
     *
     * @return
     */
    @GET("api/query.chosen.post.list.do?actionKey=appkey&appkey=1d8b6e7d45233436&build=506000&mobi_app=" +
            "android&page_no=1&page_size=30&platform=android&ts=1497101501&sign=ad59f23437204bab802fcb7a25b527f0")
    Flowable<HttpResponse<Community>> getCommunity();

    /**
     * 交流
     *
     * @return
     */
    @GET("api/query.ads.list.do?actionKey=appkey&appkey=1d8b6e7d45233436&build=506000&mobi_app=android&page_no=1&page_size=20" +
            "&platform=android&ts=1497102805&sign=2e45265253f4dd81b74350ba3fb38849")
    Flowable<HttpResponse<InterestAd>> getInterestAd();
}
