package com.yoyiyi.soleil.mvp.presenter.discover;


import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.discover.TopicCenter;
import com.yoyiyi.soleil.mvp.contract.discover.TopicCenterContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:直播Presenter
 */

public class TopicCenterPresenter extends RxPresenter<TopicCenterContract.View> implements TopicCenterContract.Presenter<TopicCenterContract.View> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public TopicCenterPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;

    }

    @Override
    public void getTopicCenterData() {
        BaseSubscriber<TopicCenter> subscriber = mRetrofitHelper.getTopicCenter()
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<TopicCenter>(mView) {
                    @Override
                    public void onSuccess(TopicCenter topicCenter) {
                        if (topicCenter.list != null)
                            mView.showTopicCenter(topicCenter.list);
                    }
                });
        addSubscribe(subscriber);
    }

}
