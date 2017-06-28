package com.yoyiyi.soleil.module.app.video;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseActivity;
import com.yoyiyi.soleil.media.MediaController;
import com.yoyiyi.soleil.media.VideoPlayerView;
import com.yoyiyi.soleil.media.callback.DanmukuSwitchListener;
import com.yoyiyi.soleil.media.callback.VideoBackListener;
import com.yoyiyi.soleil.widget.ProgressWheel;

import java.util.HashMap;

import butterknife.BindView;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.IDisplayer;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.ui.widget.DanmakuView;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/28 14:36
 * 描述:视频播放界面
 */

public class VideoPlayerActivity extends BaseActivity implements DanmukuSwitchListener, VideoBackListener {
    @BindView(R.id.palyer_view)
    VideoPlayerView mPlayerView;
    @BindView(R.id.danmaku)
    DanmakuView mDanmaku;
    @BindView(R.id.pw_loading)
    ProgressWheel mPwLoading;
    @BindView(R.id.tv_loading)
    TextView mTvLoading;
    @BindView(R.id.rl_loading)
    RelativeLayout mRlLoading;
    @BindView(R.id.iv_bili_loading)
    ImageView mIvBiliLoading;
    @BindView(R.id.tv_start)
    TextView mTvStart;
    @BindView(R.id.rl_start)
    RelativeLayout mVideoStart;

    private DanmakuContext mDanmakuContext;
    private String startText = "初始化播放器...";
    private AnimationDrawable mLoadingAnim;
    private int mLastPosition = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_player;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        initAnimation();//初始化动画
        initMediaPlayer();//初始化播放器
    }

    @SuppressLint("UseSparseArrays")
    private void initMediaPlayer() {
        //配置播放器
        MediaController mMediaController = new MediaController(this);
        mMediaController.setTitle("");
        mPlayerView.setMediaController(mMediaController);
        mPlayerView.setMediaBufferingIndicator(mRlLoading);
        mPlayerView.requestFocus();
        mPlayerView.setOnInfoListener(onInfoListener);
        mPlayerView.setOnSeekCompleteListener(onSeekCompleteListener);
        mPlayerView.setOnCompletionListener(onCompletionListener);
        mPlayerView.setOnControllerEventsListener(onControllerEventsListener);
        //设置弹幕开关监听
        mMediaController.setDanmakuSwitchListener(this);
        //设置返回键监听
        mMediaController.setVideoBackEvent(this);
        //配置弹幕库
        mDanmaku.enableDanmakuDrawingCache(true);
        //设置最大显示行数
        HashMap<Integer, Integer> maxLinesPair = new HashMap<>();
        //滚动弹幕最大显示5行
        maxLinesPair.put(BaseDanmaku.TYPE_SCROLL_RL, 5);
        //设置是否禁止重叠
        HashMap<Integer, Boolean> overlappingEnablePair = new HashMap<>();
        overlappingEnablePair.put(BaseDanmaku.TYPE_SCROLL_RL, true);
        overlappingEnablePair.put(BaseDanmaku.TYPE_FIX_TOP, true);
        //设置弹幕样式
        mDanmakuContext = DanmakuContext.create();
        mDanmakuContext.setDanmakuStyle(IDisplayer.DANMAKU_STYLE_STROKEN, 3)
                .setDuplicateMergingEnabled(false)
                .setScrollSpeedFactor(1.2f)
                .setScaleTextSize(0.8f)
                .setMaximumLines(maxLinesPair)
                .preventOverlapping(overlappingEnablePair);

    }


    /**
     * 初始化加载动画
     */
    private void initAnimation() {
        mVideoStart.setVisibility(View.VISIBLE);
        startText = startText + "【完成】\n解析视频地址...【完成】\n全舰弹幕填装...";
        mTvStart.setText(startText);
        mLoadingAnim = (AnimationDrawable) mIvBiliLoading.getBackground();
        mLoadingAnim.start();
    }

    /**
     * 全屏显示
     */
    @Override
    public void initToolbar() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setBackgroundDrawable(null);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    /**
     * 视频缓冲事件回调
     */
    private IMediaPlayer.OnInfoListener onInfoListener = new IMediaPlayer.OnInfoListener() {

        @Override
        public boolean onInfo(IMediaPlayer mp, int what, int extra) {

            if (what == IMediaPlayer.MEDIA_INFO_BUFFERING_START) {
                if (mDanmaku != null && mDanmaku.isPrepared()) {
                    mDanmaku.pause();
                    if (mRlLoading != null)
                        mRlLoading.setVisibility(View.VISIBLE);
                }
            } else if (what == IMediaPlayer.MEDIA_INFO_BUFFERING_END) {
                if (mDanmaku != null && mDanmaku.isPaused()) {
                    mDanmaku.resume();
                }
                if (mRlLoading != null)
                    mRlLoading.setVisibility(View.GONE);
            }
            return true;
        }
    };
    /**
     * 视频跳转事件回调
     */
    private IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = new IMediaPlayer.OnSeekCompleteListener() {
        @Override
        public void onSeekComplete(IMediaPlayer mp) {
            if (mDanmaku != null && mDanmaku.isPrepared()) {
                mDanmaku.seekTo(mp.getCurrentPosition());
            }
        }
    };

    /**
     * 视频播放完成事件回调
     */
    private IMediaPlayer.OnCompletionListener onCompletionListener = new IMediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(IMediaPlayer mp) {
            if (mDanmaku != null && mDanmaku.isPrepared()) {
                mDanmaku.seekTo((long) 0);
                mDanmaku.pause();
            }
            mPlayerView.pause();
        }
    };

    /**
     * 控制条控制状态事件回调
     */
    private VideoPlayerView.OnControllerEventsListener onControllerEventsListener = new VideoPlayerView.OnControllerEventsListener() {
        @Override
        public void onVideoPause() {
            if (mDanmaku != null && mDanmaku.isPrepared()) {
                mDanmaku.pause();
            }
        }

        @Override
        public void OnVideoResume() {
            if (mDanmaku != null && mDanmaku.isPaused()) {
                mDanmaku.resume();
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        if (mDanmaku != null && mDanmaku.isPrepared() && mDanmaku.isPaused()) {
            mDanmaku.seekTo((long) mLastPosition);
        }
        if (mPlayerView != null && !mPlayerView.isPlaying()) {
            mPlayerView.seekTo(mLastPosition);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPlayerView != null) {
            mLastPosition = mPlayerView.getCurrentPosition();
            mPlayerView.pause();
        }
        if (mDanmaku != null && mDanmaku.isPrepared()) {
            mDanmaku.pause();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mDanmaku != null) {
            mDanmaku.release();
            mDanmaku = null;
        }
        if (mLoadingAnim != null) {
            mLoadingAnim.stop();
            mLoadingAnim = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayerView != null && mPlayerView.isDrawingCacheEnabled()) {
            mPlayerView.destroyDrawingCache();
        }
        if (mDanmaku != null && mDanmaku.isPaused()) {
            mDanmaku.release();
            mDanmaku = null;
        }
        if (mLoadingAnim != null) {
            mLoadingAnim.stop();
            mLoadingAnim = null;
        }
    }

    /**
     * 弹幕开关回调
     *
     * @param isShow
     */
    @Override
    public void setDanmakushow(boolean isShow) {
        if (mDanmaku != null) {
            if (isShow) {
                mDanmaku.show();
            } else {
                mDanmaku.hide();
            }
        }
    }


    /**
     * 退出界面回调
     */
    @Override
    public void back() {
        onBackPressed();
    }

    @Override
    protected void loadData() {


    }
}
