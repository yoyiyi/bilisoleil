package com.yoyiyi.soleil.adapter.discover;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.discover.TopicCenter;
import com.yoyiyi.soleil.module.app.BrowerActivity;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/5 23:15
 * 描述:话题中心
 */
public class TopicCenterAdapter extends BaseQuickAdapter<TopicCenter.ListBean, BaseViewHolder> {
    public TopicCenterAdapter(@Nullable List<TopicCenter.ListBean> data) {
        super(R.layout.item_topic_center, data);
    }


    @Override
    protected void convert(BaseViewHolder holder, TopicCenter.ListBean listBean) {
        Glide.with(mContext)
                .load(listBean.cover)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_preview));
        holder.setText(R.id.tv_title, listBean.title);
        holder.itemView.setOnClickListener(view -> BrowerActivity.startActivity(mContext, listBean.link, listBean.title));
    }
}
