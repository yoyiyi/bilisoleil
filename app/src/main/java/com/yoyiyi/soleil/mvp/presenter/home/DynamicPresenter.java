package com.yoyiyi.soleil.mvp.presenter.home;


import com.annimon.stream.Stream;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.dynamic.Dynamic;
import com.yoyiyi.soleil.bean.dynamic.MulDynamic;
import com.yoyiyi.soleil.mvp.contract.home.DynamicContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;
import com.yoyiyi.soleil.utils.EmptyUtils;
import com.yoyiyi.soleil.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:直播Presenter
 */

public class DynamicPresenter extends RxPresenter<DynamicContract.View> implements DynamicContract.Presenter<DynamicContract.View> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public DynamicPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;

    }

    @Override
    public void getMulDynamicData() {
        BaseSubscriber<List<MulDynamic>> subscriber = Flowable.just(JsonUtils.readJson("dynamic.json"))
                .map(string -> {
                    Gson gson = new Gson();
                    JsonObject object = new JsonParser().parse(string).getAsJsonObject();
                    JsonArray item = object.getAsJsonObject("data").getAsJsonArray("item");
                    // JsonArray item = object.getAsJsonArray("item");
                    List<Dynamic.ItemBean> itemBeans = new ArrayList<>();
                    for (JsonElement jsonElement : item) {
                        itemBeans.add(gson.fromJson(jsonElement, Dynamic.ItemBean.class));
                    }
                    return itemBeans;
                })
                .map(itemBeans -> {
                    List<MulDynamic> mulDynamics = new ArrayList<>();
                    Stream.of(itemBeans)
                            .forEach(itemBean ->
                                    mulDynamics.add(
                                            new MulDynamic()
                                                    .setGroup(itemBean)
                                                    .setItemType(MulDynamic.TYPE_LV0)
                                                    .setLevel(MulDynamic.TYPE_LV0)
                                                    // .setChild(getRecent(itemBean))
                                                    .addSubItem(getRecent(itemBean))
                                                    .setFlag(getRecent(itemBean).isEmpty() ? false : true)));
                    return mulDynamics;
                })
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<List<MulDynamic>>(mView) {
                    @Override
                    public void onSuccess(List<MulDynamic> mulDynamics) {
                        mView.showMulDynamic(mulDynamics);
                    }
                });
        addSubscribe(subscriber);

    }

    private List<MulDynamic> getRecent(Dynamic.ItemBean itemBean) {
        List<Dynamic.ItemBean.RecentBean> recent = itemBean.recent;
        List<MulDynamic> list = new ArrayList<>();
        if (EmptyUtils.isNotEmpty(recent)) {
            Stream.of(recent)
                    .forEach(recentBean ->
                            list.add(new MulDynamic()
                                    //.setGroup(itemBean)
                                    .setItemType(MulDynamic.TYPE_LV1)
                                    .setRecent(recentBean)
                                    .setLevel(MulDynamic.TYPE_LV1)));
        }
        return list;
    }
}
