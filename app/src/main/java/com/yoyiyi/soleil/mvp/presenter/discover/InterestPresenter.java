package com.yoyiyi.soleil.mvp.presenter.discover;


import com.yoyiyi.soleil.base.BaseObjectSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.discover.Community;
import com.yoyiyi.soleil.mvp.contract.discover.InterestContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:活动中心resenter
 */

public class InterestPresenter extends RxPresenter<InterestContract.View> implements InterestContract.Presenter<InterestContract.View> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public InterestPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;

    }


    @Override
    public void getInterestData() {
        BaseObjectSubscriber<Community> subscriber = mRetrofitHelper.getInterestAd()
                .compose(RxUtils.handleResult())
                .flatMap(interestAd -> {
                            mView.showInterestAd(interestAd);
                            return mRetrofitHelper.getInterestCategrory();
                        }
                )
                .compose(RxUtils.handleResult())
                .flatMap(interestCategrory -> {
                            mView.showInterestCategrory(interestCategrory.result);
                            return mRetrofitHelper.getCommunity();
                        }
                )
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseObjectSubscriber<Community>(mView) {
                    @Override
                    public void onSuccess(Community community) {
                        mView.onComplete();
                        mView.showCommunity(community);
                    }
                });
        addSubscribe(subscriber);

    }
}
