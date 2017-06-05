package com.yoyiyi.soleil.adapter.discover;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.discover.TopicCenter;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/5 23:15
 * 描述:
 */
public class TopicCenterAdapter extends BaseQuickAdapter<TopicCenter.ListBean,BaseViewHolder> {
    public TopicCenterAdapter(@Nullable List<TopicCenter.ListBean> data) {
        super(R.layout.item_topic_center, data);
    }


    @Override
    protected void convert(BaseViewHolder baseViewHolder, TopicCenter.ListBean listBean) {

    }
}
