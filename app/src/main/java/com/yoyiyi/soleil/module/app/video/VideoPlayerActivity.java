package com.yoyiyi.soleil.module.app.video;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseActivity;
import com.yoyiyi.soleil.bean.app.video.VideoPlayer;
import com.yoyiyi.soleil.media.MediaController;
import com.yoyiyi.soleil.media.VideoPlayerView;
import com.yoyiyi.soleil.media.callback.DanmukuSwitchListener;
import com.yoyiyi.soleil.media.callback.VideoBackListener;
import com.yoyiyi.soleil.mvp.contract.app.video.VideoPlayerContract;
import com.yoyiyi.soleil.mvp.presenter.app.video.VideoPlayerPresenter;
import com.yoyiyi.soleil.widget.ProgressWheel;

import java.util.HashMap;

import butterknife.BindView;
import master.flame.danmaku.controller.DrawHandler;
import master.flame.danmaku.controller.IDanmakuView;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDisplayer;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/28 14:36
 * 描述:视频播放界面
 */

public class VideoPlayerActivity extends BaseActivity<VideoPlayerPresenter> implements DanmukuSwitchListener, VideoBackListener,
        VideoPlayerContract.View {
    @BindView(R.id.palyer_view)
    VideoPlayerView mPlayerView;
    @BindView(R.id.danmaku)
    IDanmakuView mDanmaku;
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
    private String mStartText = "初始化播放器...";
    private AnimationDrawable mLoadingAnim;
    private int mLastPosition = 0;
    private HashMap<Integer, Integer> mMaxLinesPair;// 弹幕最大行数
    private HashMap<Integer, Boolean> mOverlappingEnablePair;// 设置是否重叠

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_player;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        initDanmaku();//初始化弹幕库
        initMediaPlayer();//初始化播放器
    }

    private void initDanmaku() {
        mDanmakuContext = DanmakuContext.create();
        // 设置最大行数,从右向左滚动(有其它方向可选)
        mMaxLinesPair = new HashMap<>();
        mMaxLinesPair.put(BaseDanmaku.TYPE_SCROLL_RL, 3);
        //配置弹幕库
        mDanmaku.enableDanmakuDrawingCache(true);
        // 设置是否禁止重叠
        mOverlappingEnablePair = new HashMap<>();
        mOverlappingEnablePair.put(BaseDanmaku.TYPE_SCROLL_LR, true);
        mOverlappingEnablePair.put(BaseDanmaku.TYPE_FIX_BOTTOM, true);
        mDanmakuContext.setDanmakuStyle(IDisplayer.DANMAKU_STYLE_STROKEN, 3) //设置描边样式
                .setDuplicateMergingEnabled(false)
                .setScrollSpeedFactor(1.2f) //是否启用合并重复弹幕
                .setScaleTextSize(1.2f) //设置弹幕滚动速度系数,只对滚动弹幕有效
                // 默认使用{@link SimpleTextCacheStuffer}只支持纯文字显示,
                // 如果需要图文混排请设置{@link SpannedCacheStuffer}
                // 如果需要定制其他样式请扩展{@link SimpleTextCacheStuffer}|{@link SpannedCacheStuffer}
                .setMaximumLines(mMaxLinesPair) //设置最大显示行数
                .preventOverlapping(mOverlappingEnablePair); //设置防弹幕重叠，null为允许重叠

    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
    }

    @SuppressLint("UseSparseArrays")
    private void initMediaPlayer() {
        //配置播放器
        MediaController mMediaController = new MediaController(this);
        mMediaController.setTitle("测试视频");
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


    }

    /**
     * 初始化加载动画
     */
    private void initAnimation() {
        mVideoStart.setVisibility(View.VISIBLE);
        mStartText = mStartText + "【完成】\n解析视频地址...【完成】\n全舰弹幕填装...";
        mTvStart.setText(mStartText);
        mLoadingAnim = (AnimationDrawable) mIvBiliLoading.getBackground();
        mLoadingAnim.start();
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
            mDanmaku.release();//释放弹幕库
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
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void loadData() {
        mPresenter.getVideoPlayerData();
    }

    @Override
    public void showVideoPlayer(VideoPlayer videoPlayer) {
        //String uri1 = videoPlayer.durl.get(0).url;
       /* uri1 = "http://122.228.103.130/vg5/2/c0/6191437-1.mp4?expires=1498716900&platform=android&ssig=hKQiMO6c9Bj_OJfhu3K3vA&oi=3080483261" +
                "&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2070368267";*/
        // http://115.231.179.113/6572787CE774C845BDFF103E5C/03000804005948C7BE58C6011BA6A93F75FF26-AA49-0A30-9D4B-7871503F37CE.mp4?ccode=0501&duration=395&expire=18000&psid=862909d3e3467a9b0efff6cf8f704e5f&ups_client_netip=183.156.113.189&ups_ts=1498705420&ups_userid=&utid=c1rbEdI5mFcCAbeccb16JLgD&vid=XMjgzNzQ2MDIyMA%3D%3D&vkey=A4e5ad15f9e348b316246f54a6ecf4552

       String uri = "http://112.25.47.111/6571EA9C4C13D776444793BD0/0300080400594FCDDF4780011BA6A94356A652-5121-05EF-7A49-F7F133184645.mp4?ccode=0501&duration=390&expire=18000&psid=0c186136db0b550753f4e15897a344b7&ups_client_netip=112.10.94.233&ups_ts=1498743715&ups_userid=&utid=3erbEXmBygUCAXAKXulsTPfb&vid=XMjg0OTI4ODEyOA%3D%3D&vkey=A55ec5ed693a02bd1aa246fb9c7700277";
       // String uri = "http://115.231.179.113/6572787CE774C845BDFF103E5C/03000804005948C7BE58C6011BA6A93F75FF26-AA49-0A30-9D4B-7871503F37CE.mp4?ccode=0501&duration=395" +
          //      "&expire=18000&psid=862909d3e3467a9b0efff6cf8f704e5f&ups_client_netip=183.156.113.189&";
       String uri1="http://liveal.quanmin.tv/live/1578745132.flv";
        mPlayerView.setVideoURI(Uri.parse(uri1));
        mPlayerView.setOnPreparedListener(mp -> {
            mLoadingAnim.stop();
            mStartText = mStartText + "【完成】\n视频缓冲中...";
            mTvStart.setText(mStartText);
            mRlLoading.setVisibility(View.GONE);
        });
    }

    @Override
    public void showAnimLoading() {
        initAnimation();
    }

    @Override
    public void showDanmaku(BaseDanmakuParser baseDanmakuParser) {
        gone(mRlLoading, mVideoStart);
        mDanmaku.prepare(baseDanmakuParser, mDanmakuContext);
        mDanmaku.showFPS(false);//是否显示FPS
        mDanmaku.enableDanmakuDrawingCache(true);
        mDanmaku.setCallback(new DrawHandler.Callback() {
            @Override
            public void prepared() {
                mDanmaku.start();
            }

            @Override
            public void updateTimer(DanmakuTimer danmakuTimer) {

            }

            @Override
            public void danmakuShown(BaseDanmaku danmaku) {

            }

            @Override
            public void drawingFinished() {

            }
        });
        mPlayerView.start();
    }

    @Override
    public void showError(String msg) {
        mStartText = mStartText + "【失败】\n视频缓冲中...";
        mTvStart.setText(mStartText);
        mStartText = mStartText + "【失败】\n" + msg;
        mTvStart.setText(mStartText);
    }

}
