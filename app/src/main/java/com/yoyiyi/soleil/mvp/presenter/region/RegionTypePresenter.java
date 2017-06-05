package com.yoyiyi.soleil.mvp.presenter.region;

import com.yoyiyi.soleil.base.BaseObjectSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.region.RegionType;
import com.yoyiyi.soleil.mvp.contract.region.RegionTypeContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 22:04
 * 描述:分区Type Presenter
 */
public class RegionTypePresenter extends RxPresenter<RegionTypeContract.View> implements RegionTypeContract.Presenter<RegionTypeContract.View> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public RegionTypePresenter(RetrofitHelper retrofitHelper) {
        this.mRetrofitHelper = retrofitHelper;
    }

    @Override
    public void getRegionTypeData(int rid) {
        BaseObjectSubscriber<RegionType> subscriber = mRetrofitHelper.getRegionType(rid)
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseObjectSubscriber<RegionType>(mView) {
                    @Override
                    public void onSuccess(RegionType regionType) {
                        mView.showRegionType(regionType);
                    }
                });
        addSubscribe(subscriber);
    }
}
