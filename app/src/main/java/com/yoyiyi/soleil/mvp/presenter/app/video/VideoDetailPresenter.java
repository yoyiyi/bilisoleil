package com.yoyiyi.soleil.mvp.presenter.app.video;


import com.google.gson.Gson;
import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.app.video.VideoDetail;
import com.yoyiyi.soleil.bean.app.video.VideoDetailComment;
import com.yoyiyi.soleil.mvp.contract.app.video.VideoDetailContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;
import com.yoyiyi.soleil.utils.JsonUtils;

import javax.inject.Inject;

import io.reactivex.Flowable;

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
       /* BaseObjectSubscriber<VideoDetailComment> subscriber = mRetrofitHelper.getVideoDetail()
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
                });*/

        //本地json
        /*BaseSubscriber<RecommendBangumi> subscriber = Flowable.just(JsonUtils.readJson("user_chase.json"))
                .flatMap(string -> {
                    Gson gson = new Gson();
                    JsonObject object = new JsonParser().parse(string).getAsJsonObject();
                    JsonObject result = object.getAsJsonObject("result");
                    ChaseBangumi chaseBangumi = gson.fromJson(result, ChaseBangumi.class);
                    mView.showChaseBangumi(chaseBangumi);
                    return Flowable.just(JsonUtils.readJson("recommend_chase.json"));
                })
                .map(string -> {
                    Gson gson = new Gson();
                    JsonObject object = new JsonParser().parse(string).getAsJsonObject();
                    JsonObject result = object.getAsJsonObject("result");
                    RecommendBangumi recommendBangumi = gson.fromJson(result, RecommendBangumi.class);
                    return recommendBangumi;
                })
                .subscribeWith(new BaseSubscriber<RecommendBangumi>(mView) {
                    @Override
                    public void onSuccess(RecommendBangumi recommendBangumi) {
                        mView.showRecommendBangumi(recommendBangumi);
                    }
                });
        addSubscribe(subscriber);*/

        BaseSubscriber<VideoDetailComment> subscriber  = Flowable.just(JsonUtils.readJson("video_detail.json"))
                .flatMap(string -> {
                    Gson gson = new Gson();
                   // Log.d("test111",string);
                    VideoDetail videoDetail = gson.fromJson(string, VideoDetail.class);
                    mView.showVideoDetail(videoDetail.data);
                    return Flowable.just(JsonUtils.readJson("video_detail_comment.json"));
                })
                .map(string->{
                    //Log.d("test111",string);

                    Gson gson = new Gson();
                    return gson.fromJson(string, VideoDetailComment.class);
                })
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<VideoDetailComment>(mView) {
                    @Override
                    public void onSuccess(VideoDetailComment videoDetailComment) {
                        mView.showVideoDetailComment(videoDetailComment.data);
                    }
                });

       /* BaseSubscriber<VideoDetailComment> subscriber = Flowable.just(JsonUtils.readJson("recommend.json"))
                .flatMap(videoDetail -> {
                    mView.showVideoDetail(videoDetail.data);
                    return mRetrofitHelper.getVideoDetailComment();
                }).compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<VideoDetailComment>(mView) {
                    @Override
                    public void onSuccess(VideoDetailComment videoDetailComment) {
                        mView.showVideoDetailComment(videoDetailComment.data);
                    }
                });*/

        addSubscribe(subscriber);
    }
}
