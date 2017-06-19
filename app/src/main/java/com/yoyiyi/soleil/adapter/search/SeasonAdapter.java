package com.yoyiyi.soleil.adapter.search;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.search.Season;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/19 20:40
 * 描述:
 */
public class SeasonAdapter extends BaseQuickAdapter<Season.DataBean.ItemsBean, BaseViewHolder> {
    public SeasonAdapter(@Nullable List<Season.DataBean.ItemsBean> data) {
        super(R.layout.item_search_season, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, Season.DataBean.ItemsBean itemsBean) {
        holder.setText(R.id.tv_video_title, itemsBean.title);
        String des;
        if (itemsBean.finish == 1) {
            des = itemsBean.newest_season + " · " + itemsBean.total_count + "话全";
        } else {
            des = itemsBean.newest_season + " · " + "更新至第" + itemsBean.index + "话";
        }
        holder.setText(R.id.tv_video_des, des)
                .setText(R.id.tv_video_newest_season, itemsBean.cat_desc);
        Glide.with(mContext)
                .load(itemsBean.cover)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_video_preview));
    }
}

