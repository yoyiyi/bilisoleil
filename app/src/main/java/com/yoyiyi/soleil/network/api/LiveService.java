package com.yoyiyi.soleil.network.api;

import com.yoyiyi.soleil.bean.live.HomeLive;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 16:25
 * 描述:
 */

public interface LiveService {
    /**
     * 首页直播
     *
     * @return
     */
    @GET("/AppNewIndex/common?_device=android&access_key=5c2ea06a566f3dd8850f5750b8d0a650&appkey=1d8b6e7d45233436&build=505000&mobi_app=android&platform=android&scale=xhdpi&ts=1495525189&sign=646c80fcda0380545e3cdc2cb2fa7ff9")
    Flowable<HomeLive> getHomeLive();
}
