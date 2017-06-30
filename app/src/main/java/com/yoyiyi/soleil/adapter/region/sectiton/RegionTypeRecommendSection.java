package com.yoyiyi.soleil.adapter.region.sectiton;

import android.content.Intent;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.region.RegionType;
import com.yoyiyi.soleil.module.app.video.VideoPlayerActivity;
import com.yoyiyi.soleil.widget.section.StatelessSection;
import com.yoyiyi.soleil.widget.section.ViewHolder;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/4 17:07
 * 描述:最热视频
 */
public class RegionTypeRecommendSection extends StatelessSection<RegionType.RecommendBean> {

    public RegionTypeRecommendSection(List<RegionType.RecommendBean> recommendBeanList) {
        super(R.layout.layout_item_region_type_head, R.layout.layout_item_region_type_body, recommendBeanList);
    }

    @Override
    public void convert(ViewHolder holder, RegionType.RecommendBean recommendBean, int position) {
        Glide.with(mContext)
                .load(recommendBean.cover)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .bitmapTransform(new RoundedCornersTransformation(mContext, 5, 0))
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_video_preview));
        holder.setText(R.id.tv_video_title, recommendBean.title)
                .setText(R.id.tv_video_up, recommendBean.name)
                .setText(R.id.tv_video_play, recommendBean.play + "")
                .setText(R.id.tv_video_danmaku, recommendBean.danmaku + "");
        holder.itemView.setOnClickListener(view -> mContext.startActivity(new Intent(mContext, VideoPlayerActivity.class)));


    }

    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        holder.setText(R.id.tv_title, "最热视频");
    }
}
