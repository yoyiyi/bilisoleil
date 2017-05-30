package com.yoyiyi.soleil.mvp.presenter.region;


import com.yoyiyi.soleil.base.BaseListSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.live.LiveEntrance;
import com.yoyiyi.soleil.mvp.contract.region.live.LiveContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import java.util.List;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:综合界面搜索presenter
 */

public class LivePresenter extends RxPresenter<LiveContract.View> implements LiveContract.Presenter<LiveContract.View> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public LivePresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;

    }

    @Override
    public void getLiveEntranceData() {
        BaseListSubscriber<LiveEntrance> subscriber = mRetrofitHelper.getLiveEntrance()
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseListSubscriber<LiveEntrance>(mView) {
                    @Override
                    public void onSuccess(List<LiveEntrance> liveEntrances) {
                        mView.showLiveEntrance(liveEntrances);
                    }
                });
        addSubscribe(subscriber);

    }

}
