package com.yoyiyi.soleil.mvp.presenter.home;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.chase.ChaseBangumi;
import com.yoyiyi.soleil.bean.chase.RecommendBangumi;
import com.yoyiyi.soleil.mvp.contract.home.ChaseBangumiContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.utils.JsonUtils;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 22:04
 * 描述:首页直播Presenter
 */
public class ChaseBangumiPresenter extends RxPresenter<ChaseBangumiContract.View> implements ChaseBangumiContract.Presenter<ChaseBangumiContract.View> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public ChaseBangumiPresenter(RetrofitHelper retrofitHelper) {
        this.mRetrofitHelper = retrofitHelper;
    }

    @Override
    public void getChaseBangumiData() {
        //需要测试账号登录
        /*BaseObjectSubscriber<RecommendBangumi> subscriber = mRetrofitHelper.getChaseBangumi()
                .compose(RxUtils.handleResult())
                .flatMap(chaseBangumi -> {
                    mView.showChaseBangumi(chaseBangumi);
                    return mRetrofitHelper.getRecommendBangumi();
                })
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseObjectSubscriber<RecommendBangumi>(mView) {
                    @Override
                    public void onSuccess(RecommendBangumi recommendBangumi) {
                        mView.showRecommendBangumi(recommendBangumi);
                    }
                });
        addSubscribe(subscriber);*/
        //本地json
        BaseSubscriber<RecommendBangumi> subscriber = Flowable.just(JsonUtils.readJson("user_chase.json"))
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
        addSubscribe(subscriber);

    }

}
