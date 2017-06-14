package com.yoyiyi.soleil.bean.dynamic;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.yoyiyi.soleil.utils.EmptyUtils;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/13 18:40
 * 描述:
 */

public class MulDynamic extends AbstractExpandableItem<MulDynamic> implements MultiItemEntity {


    public static final int TYPE_LV0 = 0;
    public static final int TYPE_LV1 = 1;

    public int itemType;
    public Dynamic.ItemBean group;
    public boolean flag;
    public Dynamic.ItemBean.RecentBean recent;
    public List<MulDynamic> child;//
    public int level;

    public MulDynamic setLevel(int level) {
        this.level = level;
        return this;
    }


    public MulDynamic setFlag(boolean flag) {
        this.flag = flag;
        return this;
    }

    public MulDynamic setRecent(Dynamic.ItemBean.RecentBean recent) {
        this.recent = recent;
        return this;
    }

    public MulDynamic setItemType(int itemType) {
        this.itemType = itemType;
        return this;
    }

    public MulDynamic setGroup(Dynamic.ItemBean group) {
        this.group = group;
        return this;
    }

    public MulDynamic setChild(List<MulDynamic> child) {
        this.child = child;
        addSubItem();
        return this;
    }

    public MulDynamic addSubItem() {
        if (EmptyUtils.isNotEmpty(child)) {
            for (MulDynamic mulDynamic : child)
                addSubItem(mulDynamic);
        }
        return this;
    }

    public MulDynamic addSubItem(List<MulDynamic> child) {
        this.child = child;
        if (EmptyUtils.isNotEmpty(child)) {
            for (MulDynamic mulDynamic : child)
                addSubItem(mulDynamic);
        }
        return this;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    @Override
    public int getLevel() {
        return level;
    }
}
