package com.yoyiyi.soleil.bean.dynamic;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/13 18:40
 * 描述:
 */

public class MulDynamic implements MultiItemEntity {


    public static final int TYPE_LV0 = 1;
    public static final int TYPE_LV1 = 2;

    public int itemType;
    public Dynamic.ItemBean group;
    public List<Dynamic.ItemBean.RecentBean> child;//

    public MulDynamic setItemType(int itemType) {
        this.itemType = itemType;
        return this;
    }

    public MulDynamic setGroup(Dynamic.ItemBean group) {
        this.group = group;
        return this;
    }

    public MulDynamic setChild(List<Dynamic.ItemBean.RecentBean> child) {
        this.child = child;
        return this;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

}
