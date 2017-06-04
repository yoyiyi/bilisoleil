package com.yoyiyi.soleil.mvp.presenter.region;


import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.event.Event;
import com.yoyiyi.soleil.mvp.contract.region.BaseRegionContract;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:综合界面搜索presenter
 */
public class RegionTypePresenter extends RxPresenter<BaseRegionContract.View> implements BaseRegionContract.Presenter<BaseRegionContract.View> {


    @Inject
    public RegionTypePresenter() {

    }

    @Override
    public void getEventPostion() {
        addRxBusSubscribe(Event.RegionEntrancePositionEvent.class, act -> mView.showEventPostion(act.position));
    }

}
/*public class RegionTypePresenter extends RxPresenter<LiveContract.View> implements LiveContract.Presenter<LiveContract.View> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public RegionTypePresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;

    }

    @Override
    public void getLiveEntranceData() {
        BaseListSubscriber<LiveEntrance> subscriber = mRetrofitHelper.getLiveEntrance()
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseListSubscriber<LiveEntrance>(mView) {
                    @Override
                    public void onSuccess(List<LiveEntrance> liveEntrances) {
                        mView.showLiveEntrance(liveEntrances);
                    }
                });
        addSubscribe(subscriber);

    }
}*/
