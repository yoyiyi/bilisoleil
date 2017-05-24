package com.yoyiyi.soleil.network.helper;


import com.yoyiyi.soleil.bean.app.Splash;
import com.yoyiyi.soleil.bean.live.LivePartition;
import com.yoyiyi.soleil.bean.live.LiveRecommend;
import com.yoyiyi.soleil.bean.recommend.HomeRecommend;
import com.yoyiyi.soleil.network.api.AppService;
import com.yoyiyi.soleil.network.api.LiveService;

import io.reactivex.Flowable;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/10 17:57
 * 描述:RetrofitHelper 帮助类
 */

public class RetrofitHelper {
    private final LiveService mLiveService;
    private final AppService mAppService;

    public RetrofitHelper(AppService appService, LiveService liveService) {
        this.mAppService = appService;
        this.mLiveService = liveService;

    }


    /*******************************AppApi****************************************/
    public Flowable<Splash> getSplash() {
        return mAppService.getSplash();
    }

    public Flowable<HomeRecommend> getRecommend() {
        return mAppService.getRecommend();
    }

    /*******************************LiveApi****************************************/

    public Flowable<LiveRecommend> getRecommendLive() {
        return mLiveService.getRecommendLive();
    }
    public Flowable<LivePartition> getCommonLive() {
        return mLiveService.getCommonLive();
    }

}
