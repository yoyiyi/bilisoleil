package com.yoyiyi.soleil.mvp.presenter.bangumi;


import com.yoyiyi.soleil.base.BaseListSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.bangumi.BangumiSchedule;
import com.yoyiyi.soleil.mvp.contract.bangumi.BangumiScheduleContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import java.util.List;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:番剧时间表presenter
 */

public class BangumiSchedulePresenter extends RxPresenter<BangumiScheduleContract.View> implements BangumiScheduleContract.Presenter<BangumiScheduleContract.View> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public BangumiSchedulePresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;

    }

    @Override
    public void getBangumiSchedule() {
        BaseListSubscriber<BangumiSchedule> subscriber = mRetrofitHelper.getBangumiSchedule()
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseListSubscriber<BangumiSchedule>(mView) {
                    @Override
                    public void onSuccess(List<BangumiSchedule> bangumiScheduleList) {
                        mView.showBangumiSchedule(bangumiScheduleList);
                    }
                });
        addSubscribe(subscriber);
    }
}
