package com.yoyiyi.soleil.bean.app.video;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.yoyiyi.soleil.bean.app.VideoDetail;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/15 10:08
 * 描述:
 */

public class MulSummary implements MultiItemEntity {

    public int itemType;

    public String desc;

    public String title;

    public List<VideoDetail.DataBean.TagBean> tags;



    @Override
    public int getItemType() {
        return itemType;
    }


}
