package com.yoyiyi.soleil.adapter.home.section.chase;

import android.text.SpannableStringBuilder;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.chase.ChaseBangumi;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.SpannableStringUtils;
import com.yoyiyi.soleil.widget.section.StatelessSection;
import com.yoyiyi.soleil.widget.section.ViewHolder;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/21 11:57
 * 描述:首页直播推荐主播section
 */
public class ChaseFollowSection extends StatelessSection<ChaseBangumi.FollowsBean> {
    private String mCount;

    public ChaseFollowSection(String count, List<ChaseBangumi.FollowsBean> data) {
        super(R.layout.layout_item_home_cahse_head, R.layout.layout_item_home_chase_body, data);
        this.mCount = count;
    }


    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        //设置标题图片
        holder.setText(R.id.tv_title, "我的追番")
                .setImageResource(R.id.iv_icon, R.drawable.bangumi_follow_home_ic_mine);
        if ("0".equals(mCount)) {
            holder.setText(R.id.tv_more, "查看更多");
        } else {
            SpannableStringBuilder builder = new SpannableStringUtils.Builder()
                    .append("最近更新 ")
                    .append(mCount)
                    .setForegroundColor(AppUtils.getColor(R.color.pink_text_color)).create();
            holder.setText(R.id.tv_more, builder);
        }
    }


    @Override
    public void convert(ViewHolder holder, ChaseBangumi.FollowsBean followsBean, int position) {
        Glide.with(mContext)
                .load(followsBean.cover)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_video_preview));
        holder.setText(R.id.tv_video_title, followsBean.title);//
        SpannableStringBuilder builder = new SpannableStringUtils.Builder()
                .append("更新至第 " + followsBean.new_ep.index + " 话")
                .setForegroundColor(AppUtils.getColor(R.color.pink_text_color)).create();
        holder.setText(R.id.tv_video_update, builder);
        holder.setText(R.id.tv_video_state, "尚未观看");
        if (position == 0) {
            holder.setVisible(R.id.space, true);
        } else {
            holder.setVisible(R.id.space, true);
        }
    }


}
