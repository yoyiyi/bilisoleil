package com.yoyiyi.soleil.bean.user;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/17 11:40
 * 描述:up详情
 */

public class MulUpDetail implements MultiItemEntity {
    public int itemType;


    @Override
    public int getItemType() {
        return itemType;
    }
}
