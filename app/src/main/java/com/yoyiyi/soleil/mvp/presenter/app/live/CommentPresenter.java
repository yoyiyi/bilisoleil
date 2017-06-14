package com.yoyiyi.soleil.mvp.presenter.app.live;


import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.event.Event;
import com.yoyiyi.soleil.mvp.contract.app.live.CommentContract;

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
        addRxBusSubscribe(Event.VideoDetailCommentEvent.class, videoDetailCommentEvent ->
                mView.showComment(videoDetailCommentEvent.videoDetailComment));
    }
}
