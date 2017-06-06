package com.yoyiyi.soleil.mvp.presenter.discover;


import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.discover.ActivityCenter;
import com.yoyiyi.soleil.mvp.contract.discover.ActivityCenterContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:活动中心resenter
 */

public class ActivityCenterPresenter extends RxPresenter<ActivityCenterContract.View> implements ActivityCenterContract.Presenter<ActivityCenterContract.View> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public ActivityCenterPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;

    }

    @Override
    public void getActivityCenterData(int page, int pageSize) {
        BaseSubscriber<ActivityCenter> subscriber = mRetrofitHelper.getActivityCenter(page, pageSize)
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<ActivityCenter>(mView) {
                    @Override
                    public void onSuccess(ActivityCenter activityCenter) {
                        if (activityCenter.list != null) {
                            mView.showActivityCenter(activityCenter.list, activityCenter.total);
                        }
                    }
                });
        addSubscribe(subscriber);
    }
}
