package com.yoyiyi.soleil.network.helper;


import com.yoyiyi.soleil.bean.app.Splash;
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

/*  public RetrofitHelper(AccountApi accountApi, AppApi appApi, BangumiApi bangumiApi, BiliApi biliApi, Im9Api im9Api, LiveApi liveApi,
                          RankApi rankApi, SearchApi searchApi, UserApi userApi, VipApi vipApi, ApiApi apiApi) {
        mAccountApi = accountApi;
        mAppApi = appApi;
        mBangumiApi = bangumiApi;
        mIm9Api = im9Api;
        mLiveApi = liveApi;
        mRankApi = rankApi;
        mSearchApi = searchApi;
        mUserApi = userApi;
        mVipApi = vipApi;
        mBiliApi = biliApi;
        mApiApi = apiApi;
    }*/

    /*******************************AppApi****************************************/
    public Flowable<Splash> getSplash() {
        return mAppService.getSplash();
    }

}
