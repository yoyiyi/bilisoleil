package com.yoyiyi.soleil.mvp.presenter.bangumi;


import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.bangumi.BangumiDetailComment;
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
        BaseSubscriber<BangumiDetailComment> subscriber = mRetrofitHelper.getBangumiDetail()
                .compose(RxUtils.handleResult())
                .flatMap(bangumiDetail -> {
                            mView.showBangumiDetail(bangumiDetail);
                            return mRetrofitHelper.getBangumiDetailRecommend();
                        }
                )
                .compose(RxUtils.handleResult())
                .flatMap(bangumiDetailRecommend -> {
                    mView.showBangumiDetailRecommend(bangumiDetailRecommend);
                    return mRetrofitHelper.getBangumiDetailComment();
                })
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<BangumiDetailComment>(mView) {
                    @Override
                    public void onSuccess(BangumiDetailComment bangumiDetailComment) {
                        mView.showBangumiDetailComment(bangumiDetailComment);
                    }
                });
        addSubscribe(subscriber);
    }
}
