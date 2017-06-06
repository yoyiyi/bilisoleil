package com.yoyiyi.soleil.mvp.presenter.discover;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.discover.GameCenter;
import com.yoyiyi.soleil.mvp.contract.discover.GameCenterContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;
import com.yoyiyi.soleil.utils.JsonUtils;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:活动中心resenter
 */

public class GameCenterPresenter extends RxPresenter<GameCenterContract.View> implements GameCenterContract.Presenter<GameCenterContract.View> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public GameCenterPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;

    }

    @Override
    public void getGameCenterData() {
        //接口需要登录账号

        BaseSubscriber<GameCenter> subscriber = Flowable.just(JsonUtils.readJson("game_center.json"))
                .map(string -> {
                    Gson gson = new Gson();
                    JsonObject object = new JsonParser().parse(string).getAsJsonObject();
                    JsonObject jsonObject = object.getAsJsonObject("data");
                    GameCenter gameCenter = gson.fromJson(jsonObject, GameCenter.class);
                    return gameCenter;
                })
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<GameCenter>(mView) {
                    @Override
                    public void onSuccess(GameCenter gameCenter) {
                        mView.showGameCenter(gameCenter);
                    }
                });
        addSubscribe(subscriber);

    }
}
