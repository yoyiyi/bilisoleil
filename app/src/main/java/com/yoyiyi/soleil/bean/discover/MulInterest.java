package com.yoyiyi.soleil.bean.discover;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/10 22:35
 * 描述:
 */
public class MulInterest implements MultiItemEntity {
    public static final int TYPR_HEADER = 1;//
    public static final int TYPE_BANNER = 2;
    public static final int TYPE_CATEGRORY = 3;
    public static final int TYPR_ITEM = 4;

    public int mItemType;
    public List<InterestCategrory.ResultBean> mInterestCategroryList;
    public Community.ResultBean mCommunity;
    public InterestAd mInterestAdList;


    @Override
    public int getItemType() {
        return mItemType;
    }


    public MulInterest(int itemType,InterestAd interestAdList) {
        this.mItemType = itemType;
        mInterestAdList = interestAdList;
    }

    public MulInterest(int itemType, List<InterestCategrory.ResultBean> interestCategroryList) {
        this.mItemType = itemType;
        mInterestCategroryList = interestCategroryList;
    }

    public MulInterest(int itemType, Community.ResultBean community) {
        this.mItemType = itemType;
        mCommunity = community;
    }

    public MulInterest(int itemType) {
        this.mItemType = itemType;
    }
}
