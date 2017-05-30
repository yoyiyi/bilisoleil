package com.yoyiyi.soleil.adapter.home.section.region;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.region.Region;
import com.yoyiyi.soleil.widget.section.StatelessSection;
import com.yoyiyi.soleil.widget.section.ViewHolder;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/21 11:57
 * 描述:首页分区话题section
 */
public class RegionTopicSection extends StatelessSection<Region.BodyBean> {
    private Region.BodyBean mBodyBean;

    public RegionTopicSection(Region.BodyBean data) {
        super(R.layout.layout_item_home_region_topic, R.layout.layout_empty);
        this.mBodyBean = data;
    }


    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        //设置标题图片
        holder.setText(R.id.tv_title, "话题")
                .setImageResource(R.id.iv_icon, R.drawable.ic_header_topic);
        Glide.with(mContext)
                .load(mBodyBean.cover)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_video_preview));
    }

}
