package com.yoyiyi.soleil.mvp.presenter.app.live;


import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.app.VideoDetailComment;
import com.yoyiyi.soleil.bean.app.video.MulComment;
import com.yoyiyi.soleil.event.Event;
import com.yoyiyi.soleil.mvp.contract.app.live.CommentContract;
import com.yoyiyi.soleil.rx.RxBus;
import com.yoyiyi.soleil.rx.RxUtils;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 9:44
 * 描述:启动界面Presenter
 */

public class CommentPresenter extends RxPresenter<CommentContract.View> implements CommentContract.Presenter<CommentContract.View> {

    @Inject
    public CommentPresenter() {

    }


    @Override
    public void getCommentData() {
        BaseSubscriber<List<MulComment>> subscriber = RxBus.INSTANCE.toFlowable(Event.VideoDetailCommentEvent.class)
                .map(videoDetailCommentEvent -> {
                    VideoDetailComment.DataBean videoDetailComment = videoDetailCommentEvent.videoDetailComment;
                    List<MulComment> mulComments = Arrays.asList(



                    );


                    return mulComments;
                })
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<List<MulComment>>(mView) {
                    @Override
                    public void onSuccess(List<MulComment> mulComments) {

                    }
                });
        addSubscribe(subscriber);

    }
}
