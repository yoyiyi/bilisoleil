package com.yoyiyi.soleil.bean.live;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/7 11:03
 * 描述:直播多布局
 */

public class MulLive implements MultiItemEntity {

    public static final int TYPR_HEADER = 1;//
    public static final int TYPE_RECOMMEND_ITEM = 2;
    public static final int TYPE_PARTY_ITEM = 3;
    public static final int TYPE_FOOTER = 4;//
    public static final int TYPE_RECOMMEND_BANNER = 9;

    public static final int TYPE_BANNER = 5;//
    public static final int TYPE_ENTRANCE = 6;//

    public static final int TWO_SPAN_SIZE = 7;// 占2
    public static final int ONE_SPAN_SIZE = 8;// 占1

    public LivePartition.PartitionsBean.LivesBean mPartityLivesBean;
    public String mTitle;
    public String mUrl;
    public String mCount;
    public int mItemType;
    public int mSpanSize;
    public boolean mHasMore; //底部
    public LiveRecommend.RecommendDataBean.BannerDataBean mBannerDataBean;
    public LiveRecommend.RecommendDataBean.LivesBean mRecommendLivesBean;
    public List<LivePartition.BannerBean> mBannerBeanList;


    @Override
    public int getItemType() {
        return mItemType;
    }

    /**
     * 轮播条
     *
     * @param itemType
     * @param spanSize
     * @param bannerBeanList
     */
    public MulLive(int itemType, int spanSize, List<LivePartition.BannerBean> bannerBeanList) {
        this.mItemType = itemType;
        this.mSpanSize = spanSize;
        mBannerBeanList = bannerBeanList;
    }

    /**
     * 入口
     *
     * @param itemType
     * @param spanSize
     */
    public MulLive(int itemType, int spanSize) {
        this.mItemType = itemType;
        this.mSpanSize = spanSize;

    }

    /**
     * 底部
     *
     * @param itemType
     * @param spanSize
     */
    public MulLive(int itemType, int spanSize, boolean hasMore) {
        this.mItemType = itemType;
        this.mSpanSize = spanSize;
        mHasMore = hasMore;
    }

    /**
     * 头部
     *
     * @param itemType
     * @param spanSize
     */
    public MulLive(int itemType, int spanSize, String title, String url, String count) {
        this.mItemType = itemType;
        this.mSpanSize = spanSize;
        this.mTitle = title;
        mUrl = url;
        mCount = count;
    }

    /**
     * 推荐主播
     *
     * @param itemType
     * @param spanSize
     * @param livesBean
     */
    public MulLive(int itemType, int spanSize, LiveRecommend.RecommendDataBean.LivesBean livesBean) {
        this.mItemType = itemType;
        this.mSpanSize = spanSize;
        mRecommendLivesBean = livesBean;
    }


    /**
     * 推荐banner
     *
     * @param itemType
     * @param spanSize
     * @param bannerDataBean
     */
    public MulLive(int itemType, int spanSize, LiveRecommend.RecommendDataBean.BannerDataBean bannerDataBean) {
        this.mItemType = itemType;
        this.mSpanSize = spanSize;
        mBannerDataBean = bannerDataBean;
    }


    /**
     * 分区
     *
     * @param itemType
     * @param spanSize
     * @param livesBean
     */
    public MulLive(int itemType, int spanSize, LivePartition.PartitionsBean.LivesBean livesBean) {
        this.mItemType = itemType;
        this.mSpanSize = spanSize;
        mPartityLivesBean = livesBean;
    }
}
