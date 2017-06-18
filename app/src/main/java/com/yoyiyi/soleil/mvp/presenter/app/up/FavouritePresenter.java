package com.yoyiyi.soleil.mvp.presenter.app.up;

import com.annimon.stream.Stream;
import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.user.MulUpDetail;
import com.yoyiyi.soleil.bean.user.UpDetail;
import com.yoyiyi.soleil.event.Event;
import com.yoyiyi.soleil.mvp.contract.app.up.FavouriteContract;
import com.yoyiyi.soleil.rx.RxBus;
import com.yoyiyi.soleil.rx.RxUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/17 12:37
 * 描述:
 */

public class FavouritePresenter extends RxPresenter<FavouriteContract.View> implements FavouriteContract.Presenter<FavouriteContract.View> {

    @Inject
    public FavouritePresenter() {
    }

    @Override
    public void getFavouriteData() {
        BaseSubscriber<List<MulUpDetail>> subscriber = RxBus.INSTANCE.toFlowable(Event.UpDetailFavourteEvent.class)
                .map(event -> {
                    List<UpDetail.DataBean.FavouriteBean.ItemBeanX> favouriteList = event.favouriteList;
                    List<MulUpDetail> mulUpDetailList = new ArrayList<>();
                    Stream.of(favouriteList).forEach(itemBeanX ->
                            mulUpDetailList.add(new MulUpDetail()
                                    .setItemType(MulUpDetail.TYPE_FAVOURITE_ITEM)
                                    .setFavouriteBean(itemBeanX)));
                    return mulUpDetailList;
                })
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<List<MulUpDetail>>(mView) {
                    @Override
                    public void onSuccess(List<MulUpDetail> mulUpDetailList) {
                        mView.showFavourite(mulUpDetailList);
                    }
                });
        addSubscribe(subscriber);
    }

}
