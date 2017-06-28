package com.yoyiyi.soleil.mvp.presenter.app.video;


import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.media.danmuku.BiliDanmukuDownloadUtil;
import com.yoyiyi.soleil.mvp.contract.app.video.VideoPlayerContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.utils.AppUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 9:44
 * 描述:启动界面Presenter
 */

public class VideoPlayerPresenter extends RxPresenter<VideoPlayerContract.View> implements VideoPlayerContract.Presenter<VideoPlayerContract.View> {

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public VideoPlayerPresenter(RetrofitHelper retrofitHelper) {

        mRetrofitHelper = retrofitHelper;
    }


    @Override
    public void getVideoPlayerData() {
        mRetrofitHelper.getVideoPlayer()
                .doOnSubscribe(subscription -> mView.showAnimLoading())
                //.subscribeOn(Schedulers.io())
                .flatMap(videoPlayer -> {
                    AppUtils.runOnUI(()-> mView.showVideoPlayer(videoPlayer));
                    String url = "http://comment.bilibili.com/2143345.xml";
                    return BiliDanmukuDownloadUtil.downloadXML(url);//下载弹幕
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new BaseSubscriber<BaseDanmakuParser>(mView) {
                    @Override
                    public void onSuccess(BaseDanmakuParser baseDanmakuParser) {
                        mView.showDanmaku(baseDanmakuParser);
                    }

                    @Override
                    public void onFailure(int code, String message) {
                        mView.showError(message);
                    }
                });
    }
}
