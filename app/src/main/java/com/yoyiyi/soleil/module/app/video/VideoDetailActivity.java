package com.yoyiyi.soleil.module.app.video;

import android.support.design.widget.FloatingActionButton;
import android.view.Menu;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.app.VideoDetail;
import com.yoyiyi.soleil.bean.app.VideoDetailComment;
import com.yoyiyi.soleil.event.Event;
import com.yoyiyi.soleil.module.region.BaseRegionActivity;
import com.yoyiyi.soleil.mvp.contract.app.VideoDetailContract;
import com.yoyiyi.soleil.mvp.presenter.app.VideoDetailPresenter;
import com.yoyiyi.soleil.rx.RxBus;
import com.yoyiyi.soleil.widget.statusbar.StatusBarUtil;

import butterknife.BindView;
import io.reactivex.annotations.Nullable;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/14 14:28
 * 描述:视频播放界面
 */

public class VideoDetailActivity extends BaseRegionActivity<VideoDetailPresenter, Nullable> implements VideoDetailContract.View {

    @BindView(R.id.fab)
    FloatingActionButton mFab;
    private VideoDetail.DataBean mVideoDetail;
    private VideoDetailComment.DataBean mVideoDetailComment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_detail;
    }

    @Override
    public void showVideoDetail(VideoDetail.DataBean videoDetail) {
        mVideoDetail = videoDetail;

    }


    @Override
    public void showVideoDetailComment(VideoDetailComment.DataBean videoDetailComment) {
        mVideoDetailComment = videoDetailComment;
        finishTask();
    }

    @Override
    protected void loadData() {
        mPresenter.getVideoDetailData();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void finishTask() {
        mTitles.add("简介");
        mTitles.add("评论(" + mVideoDetailComment.page.acount + ")");
        /// RxBus.INSTANCE.post(new Event.VideoDetailCommentEvent().videoDetailComment = mVideoDetailComment);
        mFragments.add(SummaryFragment.newInstance());
        mFragments.add(CommentFragment.newInstance());
        mViewPager.setOffscreenPageLimit(mTitles.size());
        mViewPager.setAdapter(new BaseRegionTypeAdapte(getSupportFragmentManager(), mTitles, mFragments));
        mSlidingTabLayout.setViewPager(mViewPager);


        Event.VideoDetailEvent videoDetailEvent = new Event.VideoDetailEvent();
        videoDetailEvent.videoDetail = mVideoDetail;

       // RxBus.INSTANCE.post(new Event.VideoDetailCommentEvent().videoDetailComment = mVideoDetailComment);
        Event.VideoDetailCommentEvent videoDetailCommentEvent = new Event.VideoDetailCommentEvent();
        videoDetailCommentEvent.videoDetailComment = mVideoDetailComment;

        RxBus.INSTANCE.post(videoDetailEvent);
        RxBus.INSTANCE.post(videoDetailCommentEvent);

       /* Event.VideoDetailEvent videoDetailEvent = new Event.VideoDetailEvent();
        videoDetailEvent.videoDetail = mVideoDetail;
        RxBus.INSTANCE.post(videoDetailEvent);*/
    }

    @Override
    protected void initStatusBar() {
        StatusBarUtil.setTranslucentForCoordinatorLayout(this, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    protected void initWidget() {
        super.initWidget();


    }


}


