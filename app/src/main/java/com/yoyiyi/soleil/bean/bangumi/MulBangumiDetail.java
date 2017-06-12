package com.yoyiyi.soleil.bean.bangumi;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/11 21:52
 * 描述:
 */
public class MulBangumiDetail implements MultiItemEntity {

    public int mItemType;
    public List<BangumiDetailComment.DataBean.HotsBean> mHotsBeanList;
    public List<BangumiDetailRecommend.ListBean> mBangumiRecommendList;
    public int mFlag;
    public String mEvaluate;
    public List<BangumiDetail.TagsBean> mTagsBeanList;
    public int mTotalCount;
    public String mPlayCount;
    public int mFavorites;
    public String mIsFinish;
    public String mCover;
    public List<BangumiDetail.EpisodesBean> mEpisodesBeans;
    public List<BangumiDetail.SeasonsBean> mSeasonsBeanList;
    public String mSeasonsTitle;

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
        mItemType = itemType;
        return this;
    }

    public MulBangumiDetail setHotsBeanList(List<BangumiDetailComment.DataBean.HotsBean> hotsBeanList) {
        mHotsBeanList = hotsBeanList;
        return this;
    }

    public MulBangumiDetail setBangumiRecommendList(List<BangumiDetailRecommend.ListBean> bangumiRecommendList) {
        mBangumiRecommendList = bangumiRecommendList;
        return this;
    }

    public MulBangumiDetail setFlag(int flag) {
        mFlag = flag;
        return this;
    }

    public MulBangumiDetail setEvaluate(String evaluate) {
        mEvaluate = evaluate;
        return this;
    }

    public MulBangumiDetail setTagsBeanList(List<BangumiDetail.TagsBean> tagsBeanList) {
        mTagsBeanList = tagsBeanList;
        return this;
    }

    public MulBangumiDetail setTotalCount(int totalCount) {
        mTotalCount = totalCount;
        return this;
    }

    public MulBangumiDetail setPlayCount(String playCount) {
        mPlayCount = playCount;
        return this;

    }

    public MulBangumiDetail setFavorites(int favorites) {
        mFavorites = favorites;
        return this;
    }

    public MulBangumiDetail setIsFinish(String isFinish) {
        mIsFinish = isFinish;
        return this;
    }

    public MulBangumiDetail setCover(String cover) {
        mCover = cover;
        return this;
    }

    public MulBangumiDetail setEpisodesBeans(List<BangumiDetail.EpisodesBean> episodesBeans) {
        mEpisodesBeans = episodesBeans;
        return this;
    }

    public MulBangumiDetail setSeasonsBeanList(List<BangumiDetail.SeasonsBean> seasonsBeanList) {
        mSeasonsBeanList = seasonsBeanList;
        return this;
    }

    public MulBangumiDetail setSeasonsTitle(String seasonsTitle) {
        mSeasonsTitle = seasonsTitle;
        return this;
    }

    @Override
    public int getItemType() {
        return mItemType;
    }

}
