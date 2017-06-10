package com.yoyiyi.soleil.network.api;

import com.yoyiyi.soleil.bean.bangumi.BangumiDetailComment;
import com.yoyiyi.soleil.bean.discover.ActivityCenter;
import com.yoyiyi.soleil.bean.discover.TopicCenter;
import com.yoyiyi.soleil.network.response.HttpResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 16:25
 * 描述:番剧
 */

public interface ApiService {
    /**
     * 话题中心
     */
    @GET("topic/getlist?device=phone&mobi_app=iphone&page=1&pagesize=137")
    Flowable<TopicCenter> getTopicCenter();

    /**
     * 活动中心
     */
    @GET("event/getlist?device=phone&mobi_app=iphone")
    Flowable<ActivityCenter> getActivityCenter(@Query("page") int page, @Query("pagesize") int pageSize);

    /**
     * 番剧详情评论
     */
    @GET(
            "x/v2/reply?_device=iphone&_hwid=c84c067f8d99f9d3&_ulv=10000&access_key=19946e1ef3b5cad1a756c475a67185bb&appkey=27eb53fc9058f8c3&appver=3940&build=3940&nohot=0&oid=5189987&platform=ios&pn=1&ps=20&sign=c3b059e907f5c1d3416daa9fcc6396bf&sort=0&type=1")
    Flowable<HttpResponse<BangumiDetailComment>> getBangumiDetailComment();
}
