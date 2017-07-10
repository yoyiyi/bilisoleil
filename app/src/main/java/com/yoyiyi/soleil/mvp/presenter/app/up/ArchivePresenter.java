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
        BaseSubscriber<List<MulUpDetail>> subscriber = RxBus.INSTANCE.toFlowable(Event.UpDetailArchiveEvent.class)
                .map(event -> {
                    List<UpDetail.DataBean.ArchiveBean.ItemBean> archivList = event.archive.item;

                    List<MulUpDetail> mulUpDetailList = new ArrayList<>();

                    mulUpDetailList.add(new MulUpDetail()    //正在直播
                            .setItemType(MulUpDetail.TYPE_ARCHIVE_LIVE)
                            .setLive(event.live)
                            .setSpanSize(MulUpDetail.TWO_SPAN_SIZE));

                    mulUpDetailList.add(new MulUpDetail()//全部投稿
                            .setSpanSize(MulUpDetail.TWO_SPAN_SIZE)
                            .setState(1)
                            .setTitle("全部投稿")
                            .setCount(event.archive.count)
                            .setItemType(MulUpDetail.TYPE_ARCHIVE_HEAD));
                    int[] position = {0};
                    Stream.of(archivList) //全部投稿内容
                            .limit(2)
                            .forEach(
                                    itemBean -> {
                                        mulUpDetailList.add(new MulUpDetail()
                                                .setPosition(position[0])
                                                .setItemType(MulUpDetail.TYPE_ARCHIVE_ALL_SUBMIT_VIDEO)
                                                .setSpanSize(MulUpDetail.ONE_SPAN_SIZE)
                                                .setArchiveBean(itemBean));
                                        position[0]++;
                                    });

                    mulUpDetailList.add(new MulUpDetail()//最近硬币
                            .setTitle("最近投硬币的视频")
                            .setSpanSize(MulUpDetail.TWO_SPAN_SIZE)
                            .setItemType(MulUpDetail.TYPE_ARCHIVE_HEAD)
                            .setState(event.setting.coins_video));
                    mulUpDetailList.add(new MulUpDetail()//收藏夹
                            .setSpanSize(MulUpDetail.TWO_SPAN_SIZE)
                            .setTitle("TA的收藏夹")
                            .setCount(event.favourite.count)
                            .setItemType(MulUpDetail.TYPE_ARCHIVE_HEAD)
                            .setState(event.setting.fav_video));
                    mulUpDetailList.add(new MulUpDetail()
                            .setSpanSize(MulUpDetail.TWO_SPAN_SIZE)
                            .setItemType(MulUpDetail.TYPE_ARCHIVE_FAVOURITE)
                            .setFavourite(event.favourite));

                    mulUpDetailList.add(new MulUpDetail()//追番
                            .setTitle("TA的追番")
                            .setSpanSize(MulUpDetail.TWO_SPAN_SIZE)
                            .setItemType(MulUpDetail.TYPE_ARCHIVE_HEAD)
                            .setState(event.setting.bangumi));

                    mulUpDetailList.add(new MulUpDetail()//圈子
                            .setTitle("TA的圈子")
                            .setSpanSize(MulUpDetail.TWO_SPAN_SIZE)
                            .setItemType(MulUpDetail.TYPE_ARCHIVE_HEAD)
                            .setState(event.setting.groups));

                    mulUpDetailList.add(new MulUpDetail()//游戏
                            .setTitle("TA玩的游戏")
                            .setSpanSize(MulUpDetail.TWO_SPAN_SIZE)
                            .setItemType(MulUpDetail.TYPE_ARCHIVE_HEAD)
                            .setState(event.setting.played_game));

                    return mulUpDetailList;
                })
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<List<MulUpDetail>>(mView) {
                    @Override
                    public void onSuccess(List<MulUpDetail> mulUpDetailList) {
                        mView.showArchive(mulUpDetailList);
                    }
                });
        addSubscribe(subscriber);
    }
}
