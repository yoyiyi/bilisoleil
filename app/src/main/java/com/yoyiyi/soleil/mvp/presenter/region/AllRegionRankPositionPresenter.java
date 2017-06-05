package com.yoyiyi.soleil.mvp.presenter.region;


import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.event.Event;
import com.yoyiyi.soleil.mvp.contract.region.AllRegionRankPositionContract;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:综合界面搜索presenter
 */
public class AllRegionRankPositionPresenter extends RxPresenter<AllRegionRankPositionContract.View> implements AllRegionRankPositionContract.Presenter<AllRegionRankPositionContract.View> {


    @Inject
    public AllRegionRankPositionPresenter() {

    }

    @Override
    public void getEventPostion() {
        addRxBusSubscribe(Event.RegionEntrancePositionEvent.class, act -> mView.showEventPostion(act.position));
    }

}

