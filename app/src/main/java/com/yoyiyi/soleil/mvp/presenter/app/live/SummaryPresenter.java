package com.yoyiyi.soleil.mvp.presenter.app.live;


import com.annimon.stream.Stream;
import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.app.VideoDetail;
import com.yoyiyi.soleil.bean.app.video.MulSummary;
import com.yoyiyi.soleil.event.Event;
import com.yoyiyi.soleil.mvp.contract.app.live.SummaryContract;
import com.yoyiyi.soleil.rx.RxBus;
import com.yoyiyi.soleil.rx.RxUtils;
import com.yoyiyi.soleil.utils.LogUtils;

import java.util.Arrays;
import java.util.List;

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
        Class<Event.VideoDetailEvent> eventClass = Event.VideoDetailEvent.class;
        BaseSubscriber<List<MulSummary>> subscriber =
                RxBus.INSTANCE.toFlowable(Event.VideoDetailEvent.class)
                        .map(videoDetailEvent -> {
                            LogUtils.d("ceshi",videoDetailEvent.videoDetail);
                            VideoDetail.DataBean videoDetail = videoDetailEvent.videoDetail;
                            List<MulSummary> mulSummaries = Arrays.asList(new MulSummary()
                                            .setItemType(MulSummary.TYPE_DES)
                                            .setTitle(videoDetail.title)
                                            .setDesc(videoDetail.desc)
                                            .setState(videoDetail.stat),
                                    new MulSummary()
                                            .setItemType(MulSummary.TYPE_OWNER)
                                            .setOwner(videoDetail.owner)
                                            .setCtime(videoDetail.ctime)
                                            .setTags(videoDetail.tags),
                                    new MulSummary()
                                            .setItemType(MulSummary.TYPE_RELATE_HEAD));
                            Stream.of(videoDetail.relates).forEach(
                                    relatesBean -> mulSummaries.add(new MulSummary()
                                            .setItemType(MulSummary.TYPE_RELATE)
                                            .setRelates(relatesBean)));
                            return mulSummaries;
                        })
                        .compose(RxUtils.rxSchedulerHelper())
                        .subscribeWith(new BaseSubscriber<List<MulSummary>>(mView) {
                            @Override
                            public void onSuccess(List<MulSummary> mulSummaries) {
                                mView.showSummary(mulSummaries);
                            }
                        });
        addSubscribe(subscriber);
    }
}
