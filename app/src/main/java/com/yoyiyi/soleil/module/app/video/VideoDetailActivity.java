package com.yoyiyi.soleil.module.app.video;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.app.VideoDetail;
import com.yoyiyi.soleil.bean.app.VideoDetailComment;
import com.yoyiyi.soleil.module.region.BaseRegionActivity;
import com.yoyiyi.soleil.mvp.contract.app.VideoDetailContract;
import com.yoyiyi.soleil.mvp.presenter.app.VideoDetailPresenter;

import io.reactivex.annotations.Nullable;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/14 14:28
 * 描述:视频播放界面
 */

public class VideoDetailActivity extends BaseRegionActivity<VideoDetailPresenter, Nullable> implements VideoDetailContract.View {
    private VideoDetail mVideoDetail;
    private VideoDetailComment mVideoDetailComment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_detail;
    }

    @Override
    public void showVideoDetail(VideoDetail videoDetail) {
        mVideoDetail = videoDetail;
    }

    @Override
    public void showVideoDetailComment(VideoDetailComment videoDetailComment) {
        mVideoDetailComment = videoDetailComment;
        finishTask();
    }

    @Override
    protected void finishTask() {

    }

    @Override
    protected void initSlidingTabLayout() {
        super.initSlidingTabLayout();
    }
}
