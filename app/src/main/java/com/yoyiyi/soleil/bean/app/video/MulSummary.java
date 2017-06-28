package com.yoyiyi.soleil.bean.app.video;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/15 10:08
 * 描述:
 */

public class MulSummary implements MultiItemEntity {

    public static final int TYPE_DES = 34;
    public static final int TYPE_OWNER = 35;
    public static final int TYPE_RELATE = 36;
    public static final int TYPE_RELATE_HEAD = 37;

    public int itemType;

    public String desc;

    public String title;

    public List<VideoDetail.DataBean.TagBean> tags;//标签

    public VideoDetail.DataBean.StatBean state;//硬币 播放相关

    public VideoDetail.DataBean.RelatesBean relates;//视频推荐
    public long ctime;

    public VideoDetail.DataBean.OwnerBean owner;


    public MulSummary setRelates(VideoDetail.DataBean.RelatesBean relates) {
        this.relates = relates;
        return this;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public MulSummary setItemType(int itemType) {
        this.itemType = itemType;
        return this;
    }

    public MulSummary setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public MulSummary setTitle(String title) {
        this.title = title;
        return this;
    }

    public MulSummary setTags(List<VideoDetail.DataBean.TagBean> tags) {
        this.tags = tags;
        return this;
    }

    public MulSummary setState(VideoDetail.DataBean.StatBean state) {
        this.state = state;
        return this;
    }

    public MulSummary setCtime(long ctime) {
        this.ctime = ctime;
        return this;
    }

    public MulSummary setOwner(VideoDetail.DataBean.OwnerBean owner) {
        this.owner = owner;
        return this;
    }
}
