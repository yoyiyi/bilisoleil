package com.yoyiyi.soleil.adapter.region.sectiton;

import android.content.Intent;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.region.RegionRecommend;
import com.yoyiyi.soleil.module.app.video.VideoPlayerActivity;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.NumberUtils;
import com.yoyiyi.soleil.widget.section.StatelessSection;
import com.yoyiyi.soleil.widget.section.ViewHolder;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/4 17:07
 * 描述:
 */
public class RegionRecommendDynamicSection extends StatelessSection<RegionRecommend.DynamicBean> {

    public  RegionRecommendDynamicSection(List<RegionRecommend.DynamicBean> dynamicBeanList) {
        super(R.layout.layout_item_region_head, R.layout.layout_item_region_footer, R.layout.layout_item_region_body, dynamicBeanList);
    }

    @Override
    public void convert(ViewHolder holder, RegionRecommend.DynamicBean dynamicBean, int position) {
        Glide.with(mContext)
                .load(dynamicBean.cover)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_video_preview));
        holder.setText(R.id.tv_video_title, dynamicBean.title)
                .setText(R.id.tv_video_play_num, NumberUtils.format(dynamicBean.play + ""))
                .setText(R.id.tv_video_favourite, NumberUtils.format(dynamicBean.danmaku + ""));
        if (position % 2 == 0) {
            setMargins(holder.itemView, (int) AppUtils.getDimension(R.dimen.dp10),
                    (int) AppUtils.getDimension(R.dimen.dp5),
                    (int) AppUtils.getDimension(R.dimen.dp5),
                    (int) AppUtils.getDimension(R.dimen.dp5));
        } else {
            setMargins(holder.itemView, (int) AppUtils.getDimension(R.dimen.dp5),
                    (int) AppUtils.getDimension(R.dimen.dp5),
                    (int) AppUtils.getDimension(R.dimen.dp10),
                    (int) AppUtils.getDimension(R.dimen.dp5));
        }
        holder.itemView.setOnClickListener(view -> mContext.startActivity(new Intent(mContext, VideoPlayerActivity.class)));


    }

    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        holder.setText(R.id.tv_title, "全区动态")
                .setImageResource(R.id.iv_icon, R.drawable.ic_header_ding)
                .setVisible(R.id.tv_rank, false)
                .setVisible(R.id.tv_look_up, false);
    }
}
