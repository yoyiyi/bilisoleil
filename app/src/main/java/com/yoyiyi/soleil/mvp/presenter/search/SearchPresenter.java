package com.yoyiyi.soleil.mvp.presenter.search;

import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.search.Search;
import com.yoyiyi.soleil.mvp.contract.search.SearchContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/18 14:00
 * 描述:
 */

public class SearchPresenter extends RxPresenter<SearchContract.View> implements SearchContract.Presenter<SearchContract.View> {

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public SearchPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;
    }

    @Override
    public void getSearchData() {
        BaseSubscriber<Search> subscriber = mRetrofitHelper.getSearch()
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<Search>(mView) {
                    @Override
                    public void onSuccess(Search search) {
                        mView.showSearch(search);
                    }
                });
        addSubscribe(subscriber);
    }
}
