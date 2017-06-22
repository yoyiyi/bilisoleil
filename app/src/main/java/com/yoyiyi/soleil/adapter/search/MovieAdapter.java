package com.yoyiyi.soleil.adapter.search;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.search.Movie;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.SpanUtils;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/19 20:49
 * 描述:
 */
public class MovieAdapter extends BaseQuickAdapter<Movie.DataBean.ItemsBean, BaseViewHolder> {


    public MovieAdapter(@Nullable List<Movie.DataBean.ItemsBean> data) {
        super(R.layout.item_search_movie, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, Movie.DataBean.ItemsBean itemsBean) {
        if (!TextUtils.isEmpty(itemsBean.screen_date)) {
            String[] split = itemsBean.screen_date.split(" ");
            SpanUtils spanUtils = new SpanUtils().append(itemsBean.title)
                    .appendSpace(10)
                    .append(split[0].substring(0, 4))
                    .setFontSize((int) mContext.getResources().getDimension(R.dimen.text_size_12))
                    .setForegroundColor(AppUtils.getColor(R.color.font_gray));
            holder.setText(R.id.tv_video_title, spanUtils.create());
        } else {
            holder.setText(R.id.tv_video_title, itemsBean.title);
        }
        holder.setText(R.id.tv_video_area, TextUtils.isEmpty(itemsBean.area) ? "" : "地区:" + itemsBean.area)
                .setText(R.id.tv_video_staff, itemsBean.staff)
                .setText(R.id.tv_video_actors, itemsBean.actors);
        Glide.with(mContext)
                .load(itemsBean.cover)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_video_preview));
    }
}
