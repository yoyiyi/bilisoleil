package com.yoyiyi.soleil.mvp.presenter.app;


import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.user.UpDetail;
import com.yoyiyi.soleil.mvp.contract.app.up.UpDetailContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 9:44
 * 描述:up详情Presenter
 */

public class UpDetailPresenter extends RxPresenter<UpDetailContract.View> implements UpDetailContract.Presenter<UpDetailContract.View> {
    private RetrofitHelper mRetrofitHelper;


    @Inject
    public UpDetailPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;
    }

    @Override
    public void getUpDetailData() {
        BaseSubscriber<UpDetail> subscriber = mRetrofitHelper.getUpDetail()
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<UpDetail>(mView) {
                    @Override
                    public void onSuccess(UpDetail upDetail) {
                        mView.showUpDetail(upDetail);
                    }
                });
        addSubscribe(subscriber);

    }
}
