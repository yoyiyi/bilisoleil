package com.yoyiyi.soleil.network.helper;


import com.yoyiyi.soleil.bean.app.Splash;
import com.yoyiyi.soleil.bean.recommend.Recommend;
import com.yoyiyi.soleil.network.api.AppService;

import io.reactivex.Flowable;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/10 17:57
 * 描述:RetrofitHelper 帮助类
 */

public class RetrofitHelper {
    private AppService mAppService;

    public RetrofitHelper(AppService appService) {
        this.mAppService = appService;

    }


    /*******************************AppApi****************************************/
    public Flowable<Splash> getSplash() {
        return mAppService.getSplash();
    }

    public Flowable<Recommend> getReCommend() {
        return mAppService.getRecommend();
    }

}
