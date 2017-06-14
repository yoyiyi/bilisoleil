package com.yoyiyi.soleil.mvp.presenter.app.live;


import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.event.Event;
import com.yoyiyi.soleil.mvp.contract.app.live.SummaryContract;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 9:44
 * 描述:启动界面Presenter
 */

public class SummaryPresenter extends RxPresenter<SummaryContract.View> implements SummaryContract.Presenter<SummaryContract.View> {

    @Inject
    public SummaryPresenter() {

    }


    @Override
    public void getSummaryData() {
        addRxBusSubscribe(Event.VideoDetailEvent.class, videoDetailEvent ->
                mView.showSummary(videoDetailEvent.videoDetail));
    }
}
