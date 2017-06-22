package com.yoyiyi.soleil.adapter.app.up;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.search.Up;
import com.yoyiyi.soleil.utils.NumberUtils;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/21 9:20
 * 描述:up主
 */

public class UpAdapter extends BaseQuickAdapter<Up.DataBean.ItemsBean, BaseViewHolder> {
    public UpAdapter(@Nullable List<Up.DataBean.ItemsBean> data) {
        super(R.layout.item_search_up, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, Up.DataBean.ItemsBean item) {
        holder.setText(R.id.tv_uname, item.title)
                .setText(R.id.tv_des, !TextUtils.isEmpty(item.sign) ? item.sign : "")
                .setText(R.id.tv_fans, "粉丝数: " + NumberUtils.format(item.fans + ""))
                .setText(R.id.tv_videos, "视频数: " + NumberUtils.format(item.archives + ""));
        Glide.with(mContext)
                .load(item.cover)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_avatar)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_avatar));
    }
}
