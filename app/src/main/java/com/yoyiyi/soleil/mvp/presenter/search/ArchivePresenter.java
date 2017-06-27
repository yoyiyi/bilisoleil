package com.yoyiyi.soleil.mvp.presenter.search;


import com.annimon.stream.Stream;
import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.search.MulSearchArchive;
import com.yoyiyi.soleil.bean.search.Search;
import com.yoyiyi.soleil.event.Event;
import com.yoyiyi.soleil.mvp.contract.search.ArchiveContract;
import com.yoyiyi.soleil.rx.RxBus;
import com.yoyiyi.soleil.rx.RxUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:综合界面主页presenter
 */

public class ArchivePresenter extends RxPresenter<ArchiveContract.View> implements ArchiveContract.Presenter<ArchiveContract.View> {

    @Inject
    public ArchivePresenter() {

    }

    @Override
    public void getSearchArchiveData() {
        BaseSubscriber<List<MulSearchArchive>> subscriber = RxBus.INSTANCE.toFlowable(Event.SearchArchiveEvent.class)
                .doOnSubscribe(subscription -> mView.showLoading())//设置加载动画
                .map(event -> {
                    int seasonCount = event.seasonCount;
                    int movieCount = event.movieCount;
                    Search.DataBean.ItemsBean itemBean = event.itemBean;
                    List<Search.DataBean.ItemsBean.ArchiveBean> archive = itemBean.archive;//首页推荐
                    List<Search.DataBean.ItemsBean.MovieBean> movie = itemBean.movie;//电影
                    List<Search.DataBean.ItemsBean.SeasonBean> season = itemBean.season;//番剧
                    List<MulSearchArchive> mulSearchArchiveList = new ArrayList<>();
                    Stream.of(season).forEach(
                            seasonBean -> mulSearchArchiveList.add(//番剧
                                    new MulSearchArchive()
                                            .setItemType(MulSearchArchive.TYPE_SEASON)
                                            .setSeason(seasonBean)));

                    mulSearchArchiveList.add(
                            new MulSearchArchive()
                                    .setItemType(MulSearchArchive.TYPE_SEASON_MORE)
                                    .setSeasonCount(seasonCount));//更多番剧

                    Stream.of(movie).forEach(//影视
                            movieBean -> mulSearchArchiveList.add(
                                    new MulSearchArchive()
                                            .setItemType(MulSearchArchive.TYPE_MOVIE)
                                            .setMovie(movieBean)));

                    mulSearchArchiveList.add(
                            new MulSearchArchive()
                                    .setItemType(MulSearchArchive.TYPE_MOVIE_MORE)
                                    .setMovieCount(movieCount));//更多影视

                    Stream.of(archive).forEach(
                            archiveBean -> mulSearchArchiveList.add(
                                    new MulSearchArchive()
                                            .setItemType(MulSearchArchive.TYPE_ARCHIVE)
                                            .setArchive(archiveBean)));//主页推荐
                    return mulSearchArchiveList;
                })
              //  .delay(5, TimeUnit.SECONDS)
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<List<MulSearchArchive>>(mView) {
                    @Override
                    public void onSuccess(List<MulSearchArchive> mulSearchArchives) {
                        mView.showSearchArchive(mulSearchArchives);
                    }
                });
        addSubscribe(subscriber);
    }
}
