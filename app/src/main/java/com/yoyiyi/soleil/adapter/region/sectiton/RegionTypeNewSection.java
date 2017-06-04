package com.yoyiyi.soleil.adapter.region.sectiton;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.region.RegionType;
import com.yoyiyi.soleil.utils.image.GlideRoundTransform;
import com.yoyiyi.soleil.widget.section.StatelessSection;
import com.yoyiyi.soleil.widget.section.ViewHolder;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/4 17:07
 * 描述:最热视频
 */
public class RegionTypeNewSection extends StatelessSection<RegionType.NewBean> {

    public RegionTypeNewSection(List<RegionType.NewBean> newBeanList) {
        super(R.layout.layout_item_region_type_head, R.layout.layout_item_region_type_body, newBeanList);
    }

    @Override
    public void convert(ViewHolder holder, RegionType.NewBean newBean, int position) {
        Glide.with(mContext)
                .load(newBean.cover)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transform(new GlideRoundTransform(mContext, 5))
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_video_preview));
        holder.setText(R.id.tv_video_title, newBean.title)
                .setText(R.id.tv_video_up, newBean.name)
                .setText(R.id.tv_video_play, newBean.play + "")
                .setText(R.id.tv_video_danmaku, newBean.danmaku + "");
    }

    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        holder.setText(R.id.tv_title, "最新视频");
    }
}
