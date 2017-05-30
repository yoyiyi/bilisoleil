package com.yoyiyi.soleil.mvp.presenter.search;


import com.yoyiyi.soleil.base.BaseObjectSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.search.SearchArchive;
import com.yoyiyi.soleil.mvp.contract.search.ArchiveContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:综合界面搜索presenter
 */

public class ArchivePresenter extends RxPresenter<ArchiveContract.View> implements ArchiveContract.Presenter<ArchiveContract.View> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public ArchivePresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;

    }

    @Override
    public void getSearchArchiveData(String keyword, int page, int pagesize) {
        BaseObjectSubscriber<SearchArchive> subscriber = mRetrofitHelper.getSearchArchive(keyword, page, pagesize)
                .doOnSubscribe(subscription -> mView.showLoading())
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseObjectSubscriber<SearchArchive>(mView) {
                    @Override
                    public void onSuccess(SearchArchive searchArchive) {
                        mView.showSearchArchive(searchArchive);
                    }
                });

        addSubscribe(subscriber);
    }
}
