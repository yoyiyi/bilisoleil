package com.yoyiyi.soleil.bean.bangumi;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/11 21:52
 * 描述:番剧详情
 */
public class MulBangumiDetail implements MultiItemEntity {

    public int itemType;
    public BangumiDetailComment.DataBean.HotsBean hotsBean;
    public BangumiDetailComment.DataBean.RepliesBean repliesBean;


    public boolean isPrepare = false;//准备

    public List<BangumiDetailRecommend.ListBean> bangumiRecommendList;
    public String evaluate;
    public List<BangumiDetail.TagsBean> tagsBeanList;
    public String totalCount;
    public String playCount;
    public String favorites;
    public String isFinish;
    public String cover;
    public List<BangumiDetail.EpisodesBean> episodesBeans;
    public List<BangumiDetail.SeasonsBean> seasonsBeanList;
    public String seasonsTitle;
    public List<BangumiDetail.RankBean.ListBean> listBeanList;
    public int num;
    public int account;


    public int totalBpCount;
    public int weekBpCount;
    public static final int TYPE_HEAD = 1;

    public static final int TYPE_SEASON = 2;

    public static final int TYPE_EPISODE_ITEM = 3;

    public static final int TYPE_EPISODE_HEAD = 4;

    public static final int TYPE_CONTRACTED = 5;

    public static final int TYPE_DES = 6;

    public static final int TYPE_RECOMMEND_HEAD = 7;

    public static final int TYPE_RECOMMEND_ITEM = 8;

    public static final int TYPE_COMMENT_HEAD = 9;

    public static final int TYPE_COMMENT_HOT_ITEM = 10;

    public static final int TYPE_COMMENT_MORE = 11;

    public static final int TYPE_COMMENT_NOMAL_ITEM = 12;

    public MulBangumiDetail setItemType(int itemType) {
        this.itemType = itemType;
        return this;
    }

    public MulBangumiDetail setPrepare(boolean prepare) {
        isPrepare = prepare;
        return this;
    }

    public MulBangumiDetail setRepliesBean(BangumiDetailComment.DataBean.RepliesBean repliesBean) {
        this.repliesBean = repliesBean;
        return this;
    }

    public MulBangumiDetail setHotsBean(BangumiDetailComment.DataBean.HotsBean hotsBean) {
        this.hotsBean = hotsBean;
        return this;
    }

    public MulBangumiDetail setBangumiRecommendList(List<BangumiDetailRecommend.ListBean> bangumiRecommendList) {
        this.bangumiRecommendList = bangumiRecommendList;
        return this;
    }

    public MulBangumiDetail setTotalBpCount(int totalBpCount) {
        this.totalBpCount = totalBpCount;
        return this;
    }

    public MulBangumiDetail setWeekBpCount(int weekBpCount) {
        this.weekBpCount = weekBpCount;
        return this;
    }

    public MulBangumiDetail setEvaluate(String evaluate) {
        this.evaluate = evaluate;
        return this;
    }

    public MulBangumiDetail setTagsBeanList(List<BangumiDetail.TagsBean> tagsBeanList) {
        this.tagsBeanList = tagsBeanList;
        return this;
    }

    public MulBangumiDetail setTotalCount(String totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public MulBangumiDetail setlistBeanList(List<BangumiDetail.RankBean.ListBean> listBeanList) {
        this.listBeanList = listBeanList;
        return this;
    }

    public MulBangumiDetail setPlayCount(String playCount) {
        this.playCount = playCount;
        return this;

    }

    public MulBangumiDetail setFavorites(String favorites) {
        this.favorites = favorites;
        return this;
    }

    public MulBangumiDetail setIsFinish(String isFinish) {
        this.isFinish = isFinish;
        return this;
    }

    public MulBangumiDetail setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public MulBangumiDetail setEpisodesBeans(List<BangumiDetail.EpisodesBean> episodesBeans) {
        this.episodesBeans = episodesBeans;
        return this;
    }

    public MulBangumiDetail setSeasonsBeanList(List<BangumiDetail.SeasonsBean> seasonsBeanList) {
        this.seasonsBeanList = seasonsBeanList;
        return this;
    }

    public MulBangumiDetail setSeasonsTitle(String seasonsTitle) {
        this.seasonsTitle = seasonsTitle;
        return this;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public MulBangumiDetail setNum(int num) {
        this.num = num;
        return this;
    }

    public MulBangumiDetail setAccount(int account) {
        this.account = account;
        return this;
    }

}
