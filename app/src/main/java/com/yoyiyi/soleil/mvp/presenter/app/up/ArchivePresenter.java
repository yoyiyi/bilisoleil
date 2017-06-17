package com.yoyiyi.soleil.mvp.presenter.app.up;

import com.annimon.stream.Stream;
import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.user.MulUpDetail;
import com.yoyiyi.soleil.bean.user.UpDetail;
import com.yoyiyi.soleil.event.Event;
import com.yoyiyi.soleil.mvp.contract.app.up.ArchiveContract;
import com.yoyiyi.soleil.rx.RxBus;
import com.yoyiyi.soleil.rx.RxUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/17 12:37
 * 描述:
 */

public class ArchivePresenter extends RxPresenter<ArchiveContract.View> implements ArchiveContract.Presenter<ArchiveContract.View> {

    @Inject
    public ArchivePresenter() {
    }

    @Override
    public void getArchiveData() {
        RxBus.INSTANCE.toFlowable(Event.UpDetailArchiveEvent.class)
                .map(upDetailArchiveEvent -> {
                    List<UpDetail.DataBean.ArchiveBean.ItemBean> archivList = upDetailArchiveEvent.archivList;
                    List<MulUpDetail> mulUpDetailList = new ArrayList<>();
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
                        mView.showArchive(mulUpDetailList);
                    }
                });
    }
}
