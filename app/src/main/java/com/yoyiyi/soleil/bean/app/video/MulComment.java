package com.yoyiyi.soleil.bean.app.video;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/15 10:08
 * 描述:
 */

public class MulComment implements MultiItemEntity{
    public int itemType;

    @Override
    public int getItemType() {
        return itemType;
    }
}
