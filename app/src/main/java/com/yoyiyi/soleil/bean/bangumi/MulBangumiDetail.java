package com.yoyiyi.soleil.bean.bangumi;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/11 21:52
 * 描述:
 */
public class MulBangumiDetail implements MultiItemEntity {

    public int mItemType;
    public BangumiDetail mBangumiDetail;

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

    public static final int TYPE_COMMENT_MORE_ = 11;

    public static final int TYPE_COMMENT_NOMAL_ITEM = 12;

    @Override
    public int getItemType() {
        return mItemType;
    }

    public MulBangumiDetail(int itemType, BangumiDetail bangumiDetail) {
        this.mItemType = itemType;
        mBangumiDetail = bangumiDetail;
    }
}
