package com.yoyiyi.soleil.bean.recommend;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/31 10:57
 * 描述:推荐多布局
 */

public class MulRecommend implements MultiItemEntity {
    public static final int TYPR_HEADER = 1;
    public static final int TYPE_ITEM = 2;
    public static final int HEADER_SPAN_SIZE = 2;// 占2
    public static final int ITEM_SPAN_SIZE = 1;// 占1
    public int itemType;
    public int spanSize;
    public Recommend mRecommend;
    public List<Recommend.BannerItemBean> mBannerItemBean;

    public MulRecommend(int itemType, int spanSize, Recommend recommend) {
        this.itemType = itemType;
        this.spanSize = spanSize;
        this.mRecommend = recommend;
    }

    public MulRecommend(int itemType, int spanSize, List<Recommend.BannerItemBean> bannerItemBeans) {
        this.itemType = itemType;
        this.spanSize = spanSize;
        this.mBannerItemBean = bannerItemBeans;

    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
