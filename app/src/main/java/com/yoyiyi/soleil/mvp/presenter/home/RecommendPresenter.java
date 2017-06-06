package com.yoyiyi.soleil.mvp.presenter.home;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.recommend.Recommend;
import com.yoyiyi.soleil.mvp.contract.home.RecommendContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;
import com.yoyiyi.soleil.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 22:04
 * 描述:首页直播Presenter
 */
public class RecommendPresenter extends RxPresenter<RecommendContract.View> implements RecommendContract.Presenter<RecommendContract.View> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public RecommendPresenter(RetrofitHelper retrofitHelper) {
        this.mRetrofitHelper = retrofitHelper;
    }

    @Override
    public void getRecommendData() {
        //需登录
        /*BaseListSubscriber<Recommend> subscriber = mRetrofitHelper.getRecommend()
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseListSubscriber<Recommend>(mView) {
                    @Override
                    public void onSuccess(List<Recommend> recommends) {
                        mView.showRecommend(recommends);
                    }
                });
        addSubscribe(subscriber);*/

        BaseSubscriber<List<Recommend>> subscriber = Flowable.just(JsonUtils.readJson("recommend.json"))
                .map(string -> {
                    Gson gson = new Gson();
                    JsonObject object = new JsonParser().parse(string).getAsJsonObject();
                    JsonArray array = object.getAsJsonArray("data");
                    List<Recommend> recommends = new ArrayList<>();
                    for (JsonElement jsonElement : array) {
                        recommends.add(gson.fromJson(jsonElement, Recommend.class));
                    }
                    return recommends;
                })
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<List<Recommend>>(mView) {
                    @Override
                    public void onSuccess(List<Recommend> recommends) {
                        mView.showRecommend(recommends);
                    }
                });
        addSubscribe(subscriber);
    }
}
