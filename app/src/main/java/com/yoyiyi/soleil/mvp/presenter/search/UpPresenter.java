package com.yoyiyi.soleil.mvp.presenter.search;


import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.search.Up;
import com.yoyiyi.soleil.mvp.contract.search.UpContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:综合界面主页presenter
 */

public class UpPresenter extends RxPresenter<UpContract.View> implements UpContract.Presenter<UpContract.View> {

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public UpPresenter(RetrofitHelper retrofitHelper) {

        mRetrofitHelper = retrofitHelper;
    }


    @Override
    public void getSearchUpData() {
        BaseSubscriber<Up> subscriber = mRetrofitHelper.getUp()
                .compose(RxUtils.rxSchedulerHelper())
                .doOnSubscribe(subscription -> mView.showLoading())
              //  .delay(5, TimeUnit.SECONDS)
                .subscribeWith(new BaseSubscriber<Up>(mView) {
                    @Override
                    public void onSuccess(Up up) {
                        mView.showSearchUp(up);
                    }
                });
        addSubscribe(subscriber);
    }
}
