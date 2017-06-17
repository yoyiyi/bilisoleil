package com.yoyiyi.soleil.bean.user;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/17 11:40
 * 描述:up详情
 */

public class MulUpDetail implements MultiItemEntity {
    public static final int TYPE_SUBMITED_VIDEO_ELEC = 1;
    public static final int TYPE_SUBMITED_VIDEO_ITEM = 2;


    public int itemType;
    public UpDetail.DataBean.ArchiveBean.ItemBean archiveBean;



    @Override
    public int getItemType() {
        return itemType;
    }

    public MulUpDetail setItemType(int itemType) {
        this.itemType = itemType;
        return this;
    }

    public MulUpDetail setArchiveBean(UpDetail.DataBean.ArchiveBean.ItemBean archiveBean) {
        this.archiveBean = archiveBean;
        return this;
    }
}
