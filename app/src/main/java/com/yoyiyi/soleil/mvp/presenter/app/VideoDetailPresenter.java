package com.yoyiyi.soleil.mvp.presenter.app;


import com.yoyiyi.soleil.base.BaseObjectSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.app.VideoDetailComment;
import com.yoyiyi.soleil.mvp.contract.app.VideoDetailContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 9:44
 * 描述:视频详情Presenter
 */

public class VideoDetailPresenter extends RxPresenter<VideoDetailContract.View> implements VideoDetailContract.Presenter<VideoDetailContract.View> {
    private RetrofitHelper mRetrofitHelper;


    @Inject
    public VideoDetailPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;
    }

    @Override
    public void getVideoDetailData() {
        BaseObjectSubscriber<VideoDetailComment> subscriber = mRetrofitHelper.getVideoDetail()
                .compose(RxUtils.handleResult())
                .flatMap(videoDetail -> {
                    mView.showVideoDetail(videoDetail);
                    return mRetrofitHelper.getVideoDetailComment();
                })
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseObjectSubscriber<VideoDetailComment>(mView) {
                    @Override
                    public void onSuccess(VideoDetailComment videoDetailComment) {
                        mView.showVideoDetailComment(videoDetailComment);
                    }
                });
        addSubscribe(subscriber);
    }
}
