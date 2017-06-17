package com.yoyiyi.soleil.mvp.presenter.app.up;

import com.annimon.stream.Stream;
import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.user.MulUpDetail;
import com.yoyiyi.soleil.bean.user.UpDetail;
import com.yoyiyi.soleil.event.Event;
import com.yoyiyi.soleil.mvp.contract.app.up.SubmitedVideoContract;
import com.yoyiyi.soleil.rx.RxBus;
import com.yoyiyi.soleil.rx.RxUtils;
import com.yoyiyi.soleil.utils.LogUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/17 12:37
 * 描述:
 */

public class SubmitedVideoPresenter extends RxPresenter<SubmitedVideoContract.View> implements SubmitedVideoContract.Presenter<SubmitedVideoContract.View> {

    @Inject
    public SubmitedVideoPresenter() {
    }

    @Override
    public void getSubmitedVideoData() {
        BaseSubscriber<List<MulUpDetail>> subscriber = RxBus.INSTANCE.toFlowable(Event.UpDetailSubmitedVideoEvent.class)
                .map(upDetailSubmitedVideoEvent -> {
                    List<UpDetail.DataBean.ArchiveBean.ItemBean> archivList = upDetailSubmitedVideoEvent.archivList;
                    List<MulUpDetail> mulUpDetailList = new ArrayList<>();
                    LogUtils.d("ceshi22");
                    mulUpDetailList.addAll(Arrays.asList(
                            new MulUpDetail().setItemType(MulUpDetail.TYPE_SUBMITED_VIDEO_ELEC)
                    ));
                    Stream.of(archivList)
                            .forEach(
                                    archiveBean ->
                                            mulUpDetailList.add(new MulUpDetail()
                                                    .setItemType(MulUpDetail.TYPE_SUBMITED_VIDEO_ITEM)
                                                    .setArchiveBean(archiveBean)));
                    return mulUpDetailList;
                })
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<List<MulUpDetail>>(mView) {
                    @Override
                    public void onSuccess(List<MulUpDetail> mulUpDetailList) {
                        mView.showSubmitedVideo(mulUpDetailList);
                    }
                });
        addSubscribe(subscriber);
    }
}
