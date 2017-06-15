package com.yoyiyi.soleil.mvp.presenter.bangumi;


import com.annimon.stream.Stream;
import com.yoyiyi.soleil.base.BaseSubscriber;
import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.bean.bangumi.BangumiDetail;
import com.yoyiyi.soleil.bean.bangumi.MulBangumiDetail;
import com.yoyiyi.soleil.mvp.contract.bangumi.BangumiDetailContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.rx.RxUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        List<MulBangumiDetail> mulBangumiDetails = new ArrayList<>();
        StringBuilder title = new StringBuilder();
        BaseSubscriber<List<MulBangumiDetail>> subscriber = mRetrofitHelper.getBangumiDetail()
                .compose(RxUtils.handleResult())
                .flatMap(bangumiDetail -> {
                    title.append(bangumiDetail.title);
                    List<BangumiDetail.EpisodesBean> episodes = bangumiDetail.episodes;
                    Collections.reverse(episodes);//反转
                    mulBangumiDetails.addAll(Arrays.asList(
                            new MulBangumiDetail()
                                    .setItemType(MulBangumiDetail.TYPE_HEAD)//头部
                                    .setPlayCount(bangumiDetail.play_count)
                                    .setCover(bangumiDetail.cover)
                                    .setFavorites(bangumiDetail.favorites)
                                    .setIsFinish(bangumiDetail.is_finish),
                            new MulBangumiDetail()
                                    .setItemType(MulBangumiDetail.TYPE_SEASON)//分季节
                                    .setSeasonsTitle(bangumiDetail.season_title)
                                    .setSeasonsBeanList(bangumiDetail.seasons),
                            new MulBangumiDetail()
                                    .setItemType(MulBangumiDetail.TYPE_EPISODE_HEAD)
                                    .setTotalCount(bangumiDetail.total_count)
                                    .setIsFinish(bangumiDetail.is_finish),//分集头部
                            new MulBangumiDetail()
                                    .setItemType(MulBangumiDetail.TYPE_EPISODE_ITEM)//分集
                                    .setEpisodesBeans(episodes),
                            new MulBangumiDetail()
                                    .setItemType(MulBangumiDetail.TYPE_CONTRACTED)
                                    .setlistBeanList(bangumiDetail.rank.list)
                                    .setTotalBpCount(bangumiDetail.rank.total_bp_count)
                                    .setWeekBpCount(bangumiDetail.rank.week_bp_count),//承包
                            new MulBangumiDetail()
                                    .setItemType(MulBangumiDetail.TYPE_DES)
                                    .setEvaluate(bangumiDetail.evaluate)
                                    .setTagsBeanList(bangumiDetail.tags)//简介
                    ));
                    return mRetrofitHelper.getBangumiDetailRecommend();
                })
                .compose(RxUtils.handleResult())
                .flatMap(bangumiDetailRecommend -> {
                    mulBangumiDetails.addAll(Arrays.asList(new MulBangumiDetail()
                                    .setItemType(MulBangumiDetail.TYPE_RECOMMEND_HEAD),//推荐头部
                            new MulBangumiDetail()
                                    .setItemType(MulBangumiDetail.TYPE_RECOMMEND_ITEM)
                                    .setBangumiRecommendList(bangumiDetailRecommend.list)//推荐
                    ));
                    return mRetrofitHelper.getBangumiDetailComment();
                })
                .map(bangumiDetailComment -> {
                    mulBangumiDetails.add(new MulBangumiDetail()
                            .setItemType(MulBangumiDetail.TYPE_COMMENT_HEAD)
                            .setNum(bangumiDetailComment.data.page.num)
                            .setAccount(bangumiDetailComment.data.page.acount));
                    Stream.of(bangumiDetailComment.data.hots).forEach(hotsBean -> mulBangumiDetails.add(new MulBangumiDetail()//热门评论
                            .setItemType(MulBangumiDetail.TYPE_COMMENT_HOT_ITEM)
                            .setHotsBean(hotsBean)));
                    mulBangumiDetails.add(new MulBangumiDetail().setItemType(MulBangumiDetail.TYPE_COMMENT_MORE));

                    Stream.of(bangumiDetailComment.data.replies).forEach(repliesBean -> mulBangumiDetails.add(new MulBangumiDetail()//普通评论
                            .setItemType(MulBangumiDetail.TYPE_COMMENT_NOMAL_ITEM)
                            .setRepliesBean(repliesBean)));
                    return mulBangumiDetails;
                })
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<List<MulBangumiDetail>>(mView) {
                    @Override
                    public void onSuccess(List<MulBangumiDetail> mulBangumiDetails) {
                        mView.showMulBangumiDetail(mulBangumiDetails, title.toString());
                    }
                });
        addSubscribe(subscriber);
    }
}
