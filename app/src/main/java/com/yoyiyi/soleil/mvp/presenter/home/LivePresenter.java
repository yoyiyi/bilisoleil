package com.yoyiyi.soleil.mvp.presenter.home;

import com.yoyiyi.soleil.base.BaseObjectSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.live.LiveRecommend;
import com.yoyiyi.soleil.mvp.contract.home.LiveContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 22:04
 * 描述:首页直播Presenter
 */
public class LivePresenter extends RxPresenter<LiveContract.View> implements LiveContract.Presenter<LiveContract.View> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public LivePresenter(RetrofitHelper retrofitHelper) {
        this.mRetrofitHelper = retrofitHelper;
    }

  /*  @Inject
    public LivePresenter() {
        this.mRetrofitHelper = BiliSoleilApplication.getInstance().getRetrofitHelper();
    }*/

    @Override
    public void getLiveData() {
        /*addSubscribe(mRetrofitHelper.getLivePartition()
                .compose(RxUtils.handleResult())
                .flatMap(new Function<LivePartition, Publisher<HttpResponse<LiveRecommend>>>() {
                    @Override
                    public Publisher<HttpResponse<LiveRecommend>> apply(LivePartition livePartition) throws Exception {
                        mView.showLivePartition(livePartition);
                        return mRetrofitHelper.getLiveRecommend();
                    }
                })
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseObjectSubscriber<LiveRecommend>(mView) {
                    @Override
                    public void onSuccess(LiveRecommend liveRecommend) {
                        mView.showLiveRecommend(liveRecommend);
                    }
                }));

        addSubscribe(mRetrofitHelper.getLivePartition()
                .compose(RxUtils.handleResult())
                .flatMap(new Function<LivePartition, Publisher<HttpResponse<LiveRecommend>>>() {
                    @Override
                    public Publisher<HttpResponse<LiveRecommend>> apply(LivePartition livePartition) throws Exception {
                        mView.showLivePartition(livePartition);
                        return mRetrofitHelper.getLiveRecommend();
                    }
                })
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseObjectSubscriber<LiveRecommend>(mView) {
                    @Override
                    public void onSuccess(LiveRecommend liveRecommend) {
                        mView.showLiveRecommend(liveRecommend);
                    }
                }));*/

        addSubscribe(mRetrofitHelper.getLivePartition()
                .compose(RxUtils.handleResult())
                .flatMap(livePartition -> {
                    mView.showLivePartition(livePartition);
                    return mRetrofitHelper.getLiveRecommend();
                })
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseObjectSubscriber<LiveRecommend>(mView) {
                    @Override
                    public void onSuccess(LiveRecommend liveRecommend) {
                        mView.showLiveRecommend(liveRecommend);
                    }
                }));
    }

}
