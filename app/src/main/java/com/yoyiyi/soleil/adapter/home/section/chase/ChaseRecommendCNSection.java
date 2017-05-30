package com.yoyiyi.soleil.adapter.home.section.chase;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.chase.RecommendBangumi;
import com.yoyiyi.soleil.widget.section.StatelessSection;
import com.yoyiyi.soleil.widget.section.ViewHolder;
import com.yoyiyi.soleil.utils.NumberUtils;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/26 21:59
 * 描述:
 */
public class ChaseRecommendCNSection extends StatelessSection<RecommendBangumi.RecommendCnBean.RecommendBean> {

    private RecommendBangumi.RecommendCnBean.FootBean mFootBean;

    public ChaseRecommendCNSection(List<RecommendBangumi.RecommendCnBean.RecommendBean> data, RecommendBangumi.RecommendCnBean.FootBean footBean) {
        super(R.layout.layout_item_home_cahse_head, R.layout.layout_item_home_cahse_footer, R.layout.layout_item_home_chase_body, data);
        this.mFootBean = footBean;
    }


    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        holder.setText(R.id.tv_title, "国产动画推荐")
                .setImageResource(R.id.iv_icon, R.drawable.bangumi_follow_home_ic_domestic);

    }

    @Override
    public void onBindItemViewHolder(ViewHolder holder, RecommendBangumi.RecommendCnBean.RecommendBean recommendBean) {
        Glide.with(mContext)
                .load(recommendBean.cover)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_video_preview));
        holder.setText(R.id.tv_video_follow, NumberUtils.format(recommendBean.favourites) + "人追番")
                .setText(R.id.tv_video_title, recommendBean.title)
                .setText(R.id.tv_video_update, "更新至第" + recommendBean.newest_ep_index + "话")
                .setVisible(R.id.tv_video_state,false);
    }

    @Override
    public void onBindFooterViewHolder(ViewHolder holder) {
        Glide.with(mContext)
                .load(mFootBean.cover)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_video_preview));
        holder.setText(R.id.tv_title, mFootBean.title)
                .setText(R.id.tv_des, mFootBean.desc);
        if (mFootBean.is_new == 1) {
            holder.setVisible(R.id.tv_new_tag, true);
        } else {
            holder.setVisible(R.id.tv_new_tag, false);
        }
    }
}
