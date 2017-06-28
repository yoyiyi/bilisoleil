package com.yoyiyi.soleil.mvp.presenter.app.video;


import com.annimon.stream.Stream;
import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.app.video.VideoDetailComment;
import com.yoyiyi.soleil.bean.app.video.MulComment;
import com.yoyiyi.soleil.event.Event;
import com.yoyiyi.soleil.mvp.contract.app.video.CommentContract;
import com.yoyiyi.soleil.rx.RxBus;
import com.yoyiyi.soleil.rx.RxUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 9:44
 * 描述:视频详情Presenter
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
                    List<MulComment> mulComments = new ArrayList<>();
                    Stream.of(videoDetailComment.hots)
                            .forEach(hotsBean -> mulComments.add(new MulComment()
                                    .setItemType(MulComment.TYPE_COMMENT_HOT_ITEM)
                                    .setHot(hotsBean)));
                    mulComments.add(new MulComment()
                            .setItemType(MulComment.TYPE_COMMENT_MORE));
                    Stream.of(videoDetailComment.replies).forEach(repliesBean ->
                            mulComments.add(new MulComment()
                                    .setItemType(MulComment.TYPE_COMMENT_NOMAL_ITEM)
                                    .setReplies(repliesBean))
                    );
                    return mulComments;
                })
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<List<MulComment>>(mView) {
                    @Override
                    public void onSuccess(List<MulComment> mulComments) {
                        mView.showComment(mulComments);
                    }
                });
        addSubscribe(subscriber);

    }
}
