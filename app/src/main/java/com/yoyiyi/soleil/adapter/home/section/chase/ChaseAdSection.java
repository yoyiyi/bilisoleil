package com.yoyiyi.soleil.adapter.home.section.chase;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.chase.RecommendBangumi;
import com.yoyiyi.soleil.widget.section.StatelessSection;
import com.yoyiyi.soleil.widget.section.ViewHolder;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/26 21:59
 * 描述:
 */
public class ChaseAdSection extends StatelessSection {

    private RecommendBangumi.AdBean mAdBean;

    public ChaseAdSection(RecommendBangumi.AdBean adBean) {
        super(R.layout.layout_item_home_cahse_footer, R.layout.layout_empty);
        this.mAdBean = adBean;
    }


    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        Glide.with(mContext)
                .load(mAdBean.img)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_video_preview));
        holder.setVisible(R.id.tv_title, false)
                .setVisible(R.id.tv_new_tag, false)
                .setVisible(R.id.tv_des, false);

    }
}
