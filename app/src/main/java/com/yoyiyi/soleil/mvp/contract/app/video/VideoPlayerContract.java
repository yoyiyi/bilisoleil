package com.yoyiyi.soleil.mvp.contract.app.video;

import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.app.video.VideoPlayer;

import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/14 14:30
 * 描述:
 */

public interface VideoPlayerContract {
    interface View extends BaseContract.BaseView {

        void showVideoPlayer(VideoPlayer videoPlayer);

        void showAnimLoading();

        void showDanmaku(BaseDanmakuParser baseDanmakuParser);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getVideoPlayerData();

    }
}
