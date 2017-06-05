package com.yoyiyi.soleil.mvp.presenter.recommend;


import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.recommend.AllStationRank;
import com.yoyiyi.soleil.mvp.contract.recommend.AllStationRankContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:全区排行presenter
 */
public class AllStationRankPresenter extends RxPresenter<AllStationRankContract.View> implements AllStationRankContract.Presenter<AllStationRankContract.View> {

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public AllStationRankPresenter(RetrofitHelper retrofitHelper) {
        this.mRetrofitHelper = retrofitHelper;
    }


   /* @Override
    public void getAllRegionRankData(String type) {
        BaseSubscriber<AllRegionRank> subscriber = mRetrofitHelper.getAllRegionRank(type)
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<AllRegionRank>(mView) {
                    @Override
                    public void onSuccess(AllRegionRank allRegionRank) {
                        mView.showAllRegionRank(allRegionRank.rank.list);
                    }
                });
        addSubscribe(subscriber);

    }*/

    @Override
    public void getAllStationRankData(String type) {
        BaseSubscriber<AllStationRank> subscriber = mRetrofitHelper.getAllStationRank(type)
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<AllStationRank>(mView) {
                    @Override
                    public void onSuccess(AllStationRank allStationRank) {
                        mView.showAllStationRank(allStationRank.rank.list);
                    }
                });
        addSubscribe(subscriber);
    }
}
