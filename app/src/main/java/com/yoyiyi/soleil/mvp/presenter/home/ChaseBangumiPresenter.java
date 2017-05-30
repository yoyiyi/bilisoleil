package com.yoyiyi.soleil.mvp.presenter.home;

import com.yoyiyi.soleil.base.BaseObjectSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.chase.RecommendBangumi;
import com.yoyiyi.soleil.mvp.contract.home.ChaseBangumiContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 22:04
 * 描述:首页直播Presenter
 */
public class ChaseBangumiPresenter extends RxPresenter<ChaseBangumiContract.View> implements ChaseBangumiContract.Presenter<ChaseBangumiContract.View> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public ChaseBangumiPresenter(RetrofitHelper retrofitHelper) {
        this.mRetrofitHelper = retrofitHelper;
    }

    @Override
    public void getChaseBangumiData() {
        BaseObjectSubscriber<RecommendBangumi> subscriber = mRetrofitHelper.getChaseBangumi()
                .compose(RxUtils.handleResult())
                .flatMap(chaseBangumi -> {
                    mView.showChaseBangumi(chaseBangumi);
                    return mRetrofitHelper.getRecommendBangumi();
                })
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseObjectSubscriber<RecommendBangumi>(mView) {
                    @Override
                    public void onSuccess(RecommendBangumi recommendBangumi) {
                        mView.showRecommendBangumi(recommendBangumi);
                    }
                });
        addSubscribe(subscriber);

        // mRetrofitHelper.getChaseBangumi().compose(RxUtils.rxSchedulerHelper());

       /* addSubscribe(mRetrofitHelper.getRecommendBangumi()
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseObjectSubscriber<RecommendBangumi>(mView) {
            @Override
            public void onSuccess(RecommendBangumi recommendBangumi) {
                mView.showRecommendBangumi(recommendBangumi);
            }
        }));*/
    }

}
