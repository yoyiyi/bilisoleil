package com.yoyiyi.soleil.mvp.presenter.search;


import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.search.Movie;
import com.yoyiyi.soleil.mvp.contract.search.MovieContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:综合界面主页presenter
 */

public class MoviePresenter extends RxPresenter<MovieContract.View> implements MovieContract.Presenter<MovieContract.View> {

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public MoviePresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;
    }

    @Override
    public void getSearchMovieData() {
        BaseSubscriber<Movie> subscriber = mRetrofitHelper.getMovie()
                .compose(RxUtils.rxSchedulerHelper())
                .doOnSubscribe(subscription -> mView.showLoading())
             //   .delay(5, TimeUnit.SECONDS)
                .subscribeWith(new BaseSubscriber<Movie>(mView) {
                    @Override
                    public void onSuccess(Movie movie) {
                        mView.showSearchMovie(movie);
                    }
                });
        addSubscribe(subscriber);
    }

}
