package com.yoyiyi.soleil.mvp.presenter.bangumi;


import com.yoyiyi.soleil.base.BaseObjectSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.bangumi.BangumiIndex;
import com.yoyiyi.soleil.mvp.contract.bangumi.BangumiIndexContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:番剧索引presenter
 */

public class BangumiIndexPresenter extends RxPresenter<BangumiIndexContract.View> implements BangumiIndexContract.Presenter<BangumiIndexContract.View> {
    private RetrofitHelper mRetrofitHelper;


    @Inject
    public BangumiIndexPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;

    }

    @Override
    public void getBangumiIndex() {
        BaseObjectSubscriber<BangumiIndex> subscriber = mRetrofitHelper.getBangumiIndex()
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseObjectSubscriber<BangumiIndex>(mView) {
                    @Override
                    public void onSuccess(BangumiIndex bangumiIndex) {
                        mView.showBangumiIndex(bangumiIndex);
                    }
                });
        addSubscribe(subscriber);

    }

}
