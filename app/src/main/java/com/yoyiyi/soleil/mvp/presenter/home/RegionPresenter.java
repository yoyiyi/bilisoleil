package com.yoyiyi.soleil.mvp.presenter.home;

import com.yoyiyi.soleil.base.BaseListSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.region.Region;
import com.yoyiyi.soleil.mvp.contract.home.RegionContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import java.util.List;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 22:04
 * 描述:首页直播Presenter
 */
public class RegionPresenter extends RxPresenter<RegionContract.View> implements RegionContract.Presenter<RegionContract.View> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public RegionPresenter(RetrofitHelper retrofitHelper) {
        this.mRetrofitHelper = retrofitHelper;
    }

    @Override
    public void getRegionData() {
        BaseListSubscriber<Region> subscriber = mRetrofitHelper.getRegion()
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseListSubscriber<Region>(mView) {
                    @Override
                    public void onSuccess(List<Region> regions) {
                        mView.showRegion(regions);
                    }
                });
        addSubscribe(subscriber);
    }
}
