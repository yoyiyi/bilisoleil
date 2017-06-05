package com.yoyiyi.soleil.network.api;

import com.yoyiyi.soleil.bean.discover.ActivityCenter;
import com.yoyiyi.soleil.bean.discover.TopicCenter;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 16:25
 * 描述:
 */

public interface ApiService {
    /**
     * 话题中心
     */
    @GET("topic/getlist?device=phone&mobi_app=iphone&page=1&pagesize=137")
    Flowable<TopicCenter> getTopicCenter();

    /**
     * 话题中心
     */
    @GET("event/getlist?device=phone&mobi_app=iphone")
    Flowable<ActivityCenter> getActivityCenter(@Query("page") int page, @Query("pagesize") int pageSize);
}
