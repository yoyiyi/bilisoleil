package com.yoyiyi.soleil.bean.app.video;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/15 10:08
 * 描述:
 */

public class MulComment implements MultiItemEntity {


    public static final int TYPE_COMMENT_HOT_ITEM = 2;

    public static final int TYPE_COMMENT_MORE = 3;

    public static final int TYPE_COMMENT_NOMAL_ITEM = 4;

    public VideoDetailComment.DataBean.HotsBean hotsBean;
    public VideoDetailComment.DataBean.RepliesBean repliesBean;

    public MulComment setHot(VideoDetailComment.DataBean.HotsBean hot) {
        this.hotsBean = hot;
        return this;
    }

    public MulComment setReplies(VideoDetailComment.DataBean.RepliesBean replies) {
        this.repliesBean = replies;
        return this;
    }

    public MulComment setItemType(int itemType) {
        this.itemType = itemType;
        return this;
    }

    public int itemType;

    @Override
    public int getItemType() {
        return itemType;
    }
}
