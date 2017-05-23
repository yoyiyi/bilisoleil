package com.yoyiyi.soleil.network.api;

import com.yoyiyi.soleil.bean.app.Splash;
import com.yoyiyi.soleil.bean.recommend.HomeRecommend;

import io.reactivex.Flowable;
import retrofit2.http.GET;

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
     * 主页推荐
     * @return
     */
    @GET("/x/feed/index?access_key=5c2ea06a566f3dd8850f5750b8d0a650&appkey=1d8b6e7d45233436&build=505000&idx=0&login_event=2&mobi_app=android&network=wifi&open_event=cold&platform=android&pull=true&style=2&ts=1495519813&sign=510278867e908ab3de31a7bd3701a55c")
    Flowable<HomeRecommend> getRecommend();
}
