package com.yoyiyi.soleil.mvp.presenter.region;


import com.yoyiyi.soleil.base.BaseListSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.region.AllRegionRank;
import com.yoyiyi.soleil.mvp.contract.region.AllRegionRankContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import java.util.List;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:全区排行presenter
 */
public class AllRegionRankPresenter extends RxPresenter<AllRegionRankContract.View> implements AllRegionRankContract.Presenter<AllRegionRankContract.View> {

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public AllRegionRankPresenter(RetrofitHelper retrofitHelper) {
        this.mRetrofitHelper = retrofitHelper;
    }


    @Override
    public void getAllRegionRankData(String type) {
        BaseListSubscriber<AllRegionRank> subscriber = mRetrofitHelper.getAllRegionRank(type)
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseListSubscriber<AllRegionRank>(mView) {
                    @Override
                    public void onSuccess(List<AllRegionRank> allRegionRank) {
                        mView.showAllRegionRank(allRegionRank);
                    }
                });
        addSubscribe(subscriber);
    }
}
