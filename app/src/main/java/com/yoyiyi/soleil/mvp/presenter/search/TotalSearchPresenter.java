package com.yoyiyi.soleil.mvp.presenter.search;


import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.search.SearchArchive;
import com.yoyiyi.soleil.mvp.contract.search.TotalSearchContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:直播Presenter
 */

public class TotalSearchPresenter extends RxPresenter<TotalSearchContract.View> implements TotalSearchContract.Presenter<TotalSearchContract.View> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public TotalSearchPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;

    }

    @Override
    public void getSearchNavData(String keyword, int page, int pagesize) {
        BaseSubscriber<List<SearchArchive.NavBean>> subscriber = mRetrofitHelper.getSearchArchive(keyword, page, pagesize)
                .doOnSubscribe(subscription -> mView.showLoading())
                .delay(1, TimeUnit.SECONDS)
                .compose(RxUtils.handleResult())
                .map(searchArchive -> searchArchive.nav)
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<List<SearchArchive.NavBean>>(mView) {
                    @Override
                    public void onSuccess(List<SearchArchive.NavBean> navBeans) {
                        mView.showSearchNav(navBeans);
                    }
                });
        addSubscribe(subscriber);
    }
}
