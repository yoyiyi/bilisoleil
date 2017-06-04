package com.yoyiyi.soleil.mvp.presenter.region;


import com.yoyiyi.soleil.base.BaseObjectSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.region.RegionRecommend;
import com.yoyiyi.soleil.mvp.contract.region.RegionTypeRecommendContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;
import com.yoyiyi.soleil.utils.JsonUtils;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:分区推荐presenter
 */

public class RegionTypeRecommendPresenter extends RxPresenter<RegionTypeRecommendContract.View> implements RegionTypeRecommendContract.Presenter<RegionTypeRecommendContract.View> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public RegionTypeRecommendPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;

    }

    @Override
    public void getRegionRecommendData(int tid) {
        BaseObjectSubscriber<RegionRecommend> subscriber = mRetrofitHelper.getRegionRecommend(tid)
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseObjectSubscriber<RegionRecommend>(mView) {
                    @Override
                    public void onSuccess(RegionRecommend regionRecommend) {
                        mView.showRegionRecommend(regionRecommend);
                    }
                });
        addSubscribe(subscriber);
    }

}
