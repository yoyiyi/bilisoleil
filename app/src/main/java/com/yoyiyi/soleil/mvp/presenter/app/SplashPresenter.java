package com.yoyiyi.soleil.mvp.presenter.app;


import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.app.Splash;
import com.yoyiyi.soleil.mvp.contract.app.SplashContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 9:44
 * 描述:启动界面Presenter
 */

public class SplashPresenter extends RxPresenter<SplashContract.View> implements SplashContract.Presenter<SplashContract.View> {
    private RetrofitHelper mRetrofitHelper;


    @Inject
    public SplashPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;
    }

    @Override
    public void getSplashData() {
        BaseSubscriber<Splash> subscriber = mRetrofitHelper.getSplash()
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<Splash>(mView) {
                    @Override
                    public void onSuccess(Splash splash) {
                        if (splash.code == 0)
                            mView.showSplash(splash);
                    }

                    @Override
                    public void onFailure(int code, String message) {
                            mView.showError(message);
                    }
                });
        addSubscribe(subscriber);


    }

    /**
     * 5s 倒计时
     */
    @Override
    public void setCountDown() {
        final Long count = 5L;
        Disposable subscribe = Flowable.interval(0, 1, TimeUnit.SECONDS)
                .map(aLong -> count - aLong)
                .take(count + 1)
                .compose(RxUtils.rxSchedulerHelper())
                .subscribe(aLong -> mView.showCountDown(aLong.intValue()));
        addSubscribe(subscribe);
    }

}
