package com.yoyiyi.soleil.bean.user;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/17 11:40
 * 描述:up详情
 */

public class MulUpDetail implements MultiItemEntity {
    public static final int ONE_SPAN_SIZE = 1;// 占2
    public static final int TWO_SPAN_SIZE = 2;// 占1

    public static final int TYPE_SUBMITED_VIDEO_ELEC = 1;
    public static final int TYPE_SUBMITED_VIDEO_ITEM = 2;
    public static final int TYPE_FAVOURITE_ITEM = 3;

    public static final int TYPE_ARCHIVE_LIVE = 4;//直播
    public static final int TYPE_ARCHIVE_HEAD = 5;//头部
    public static final int TYPE_ARCHIVE_ALL_SUBMIT_VIDEO = 6;//全部投稿
    public static final int TYPE_ARCHIVE_FAVOURITE = 7;//收藏夹


    public String title;


    public int itemType;
    public int position;


    public int count;

    public int spanSize;
    public UpDetail.DataBean.ArchiveBean.ItemBean archiveBean;


    public UpDetail.DataBean.FavouriteBean.ItemBeanX favouriteBean;


    public UpDetail.DataBean.FavouriteBean favourite;
    public UpDetail.DataBean.ArchiveBean archive;
    public UpDetail.DataBean.SettingBean setting;
    public UpDetail.DataBean.LiveBean live;


    public int state;


    public MulUpDetail setFavouriteBean(UpDetail.DataBean.FavouriteBean.ItemBeanX favouriteBean) {
        this.favouriteBean = favouriteBean;
        return this;
    }

    public MulUpDetail setCount(int count) {
        this.count = count;
        return this;
    }

    public MulUpDetail setPosition(int position) {
        this.position = position;
        return this;
    }

    public MulUpDetail setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public MulUpDetail setItemType(int itemType) {
        this.itemType = itemType;
        return this;
    }

    public MulUpDetail setLive(UpDetail.DataBean.LiveBean live) {
        this.live = live;
        return this;
    }

    public MulUpDetail setArchiveBean(UpDetail.DataBean.ArchiveBean.ItemBean archiveBean) {
        this.archiveBean = archiveBean;
        return this;
    }

    public MulUpDetail setSpanSize(int spanSize) {
        this.spanSize = spanSize;
        return this;
    }


    public MulUpDetail setState(int state) {
        this.state = state;
        return this;
    }

    public MulUpDetail setFavourite(UpDetail.DataBean.FavouriteBean favourite) {
        this.favourite = favourite;
        return this;
    }

    public MulUpDetail setArchive(UpDetail.DataBean.ArchiveBean archive) {
        this.archive = archive;
        return this;
    }

    public MulUpDetail setSetting(UpDetail.DataBean.SettingBean setting) {
        this.setting = setting;
        return this;
    }
}
