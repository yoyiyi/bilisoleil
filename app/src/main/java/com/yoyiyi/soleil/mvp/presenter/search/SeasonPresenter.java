package com.yoyiyi.soleil.mvp.presenter.search;


import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.search.Season;
import com.yoyiyi.soleil.mvp.contract.search.SeasonContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:综合界面主页presenter
 */

public class SeasonPresenter extends RxPresenter<SeasonContract.View> implements SeasonContract.Presenter<SeasonContract.View> {

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public SeasonPresenter(RetrofitHelper retrofitHelper) {

        mRetrofitHelper = retrofitHelper;
    }


    @Override
    public void getSearchSeasonData() {
        BaseSubscriber<Season> subscriber = mRetrofitHelper.getSeason()
                .compose(RxUtils.rxSchedulerHelper())
                .doOnSubscribe(subscription -> mView.showLoading())
               // .delay(5, TimeUnit.SECONDS)
                .subscribeWith(new BaseSubscriber<Season>(mView) {
                    @Override
                    public void onSuccess(Season season) {
                        mView.showSearchSeason(season);
                    }
                });
        addSubscribe(subscriber);
    }
}
