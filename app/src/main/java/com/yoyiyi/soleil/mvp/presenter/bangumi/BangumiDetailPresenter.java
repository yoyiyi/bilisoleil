package com.yoyiyi.soleil.mvp.presenter.bangumi;


import com.yoyiyi.soleil.base.BaseObjectSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.bangumi.BangumiDetailRecommend;
import com.yoyiyi.soleil.mvp.contract.bangumi.BangumiDetailContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:番剧详情presenter
 */

public class BangumiDetailPresenter extends RxPresenter<BangumiDetailContract.View> implements BangumiDetailContract.Presenter<BangumiDetailContract.View> {
    private RetrofitHelper mRetrofitHelper;


    @Inject
    public BangumiDetailPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;

    }

    @Override
    public void getBangumiDetailData() {
        BaseObjectSubscriber<BangumiDetailRecommend> subscriber = mRetrofitHelper.getBangumiDetail()
                .compose(RxUtils.handleResult())
                .flatMap(bangumiDetail -> {
                            mView.showBangumiDetail(bangumiDetail);
                            return mRetrofitHelper.getBangumiDetailRecommend();
                        }
                )
                .compose(RxUtils.handleResult())
                .flatMap(bangumiDetailRecommend -> {
                            mView.showBangumiDetailRecommend(bangumiDetailRecommend);
                            return mRetrofitHelper.getBangumiDetailRecommend();
                        }
                )
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseObjectSubscriber<BangumiDetailRecommend>(mView) {
                    @Override
                    public void onSuccess(BangumiDetailRecommend bangumiDetailRecommend) {
                        mView.showBangumiDetailRecommend(bangumiDetailRecommend);
                    }
                });
        addSubscribe(subscriber);
    }
}
