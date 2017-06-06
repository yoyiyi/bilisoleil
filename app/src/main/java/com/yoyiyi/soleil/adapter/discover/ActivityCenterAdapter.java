package com.yoyiyi.soleil.adapter.discover;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.discover.ActivityCenter;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/5 23:15
 * 描述:活动中心
 */
public class ActivityCenterAdapter extends BaseQuickAdapter<ActivityCenter.ListBean, BaseViewHolder> {
    public ActivityCenterAdapter(@Nullable List<ActivityCenter.ListBean> data) {
        super(R.layout.item_activity_center, data);
    }


    @Override
    protected void convert(BaseViewHolder holder, ActivityCenter.ListBean listBean) {
        Glide.with(mContext)
                .load(listBean.cover)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_preview));
        holder.setText(R.id.tv_title, listBean.title).
                setImageResource(R.id.iv_state, listBean.state == 1 ? R.drawable.ic_badge_end : R.drawable.ic_badge_going);

    }
}
