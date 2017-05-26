package com.yoyiyi.soleil.network.helper;


import com.yoyiyi.soleil.bean.app.Splash;
import com.yoyiyi.soleil.bean.live.LivePartition;
import com.yoyiyi.soleil.bean.live.LiveRecommend;
import com.yoyiyi.soleil.bean.recommend.Recommend;
import com.yoyiyi.soleil.bean.region.Region;
import com.yoyiyi.soleil.network.api.AppService;
import com.yoyiyi.soleil.network.api.LiveService;
import com.yoyiyi.soleil.network.response.HttpResponse;

import java.util.List;

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

    public Flowable<HttpResponse<List<Recommend>>> getRecommend() {
        return mAppService.getRecommend();
    }

    public Flowable<HttpResponse<List<Region>>> getRegion() {
        return mAppService.getRegion();
    }
    /*******************************LiveApi****************************************/

    public Flowable<HttpResponse<LiveRecommend>> getLiveRecommend() {
        return mLiveService.getLiveRecommend();
    }

    public Flowable<HttpResponse<LivePartition>> getLivePartition() {
        return mLiveService.getLivePartition();
    }

}
