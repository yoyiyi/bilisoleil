package com.yoyiyi.soleil.adapter.home.section.region;

import android.content.Intent;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.region.Region;
import com.yoyiyi.soleil.module.bangumi.BangumiDetailActivity;
import com.yoyiyi.soleil.module.discover.GameCenterActivity;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.NumberUtils;
import com.yoyiyi.soleil.widget.section.StatelessSection;
import com.yoyiyi.soleil.widget.section.ViewHolder;

import java.util.List;
import java.util.Random;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/21 11:57
 * 描述:首页直播推荐主播section
 */
public class RegionSection extends StatelessSection<Region.BodyBean> {
    private String mTitle;
    private Random mRandom;

    public RegionSection(String title, List<Region.BodyBean> data) {
        super(R.layout.layout_item_home_region_head, R.layout.layout_item_home_region_footer, R.layout.layout_item_home_region_body, data);
        this.mTitle = title;
        this.mRandom = new Random();
    }


    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        //设置标题图片
        setTypeIcon(holder, mTitle);
        holder.setText(R.id.tv_title, mTitle);
    }


    @Override
    public void convert(ViewHolder holder, Region.BodyBean bodyBean, int position) {
        Glide.with(mContext)
                .load(bodyBean.cover)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_video_preview));
        holder.setText(R.id.tv_video_title, bodyBean.title);
        holder.setText(R.id.tv_video_play_num, NumberUtils.format(bodyBean.play + ""));
        if (TextUtils.equals("番剧区", mTitle)) {
            holder.setVisible(R.id.iv_video_online_region, false)
                    .setVisible(R.id.iv_video_online, true)
                    .setText(R.id.tv_video_favourite, NumberUtils.format(bodyBean.favourite + ""));
        } else {
            holder.setVisible(R.id.iv_video_online_region, true)
                    .setVisible(R.id.iv_video_online, false)
                    .setText(R.id.tv_video_favourite, NumberUtils.format(bodyBean.danmaku + ""));
        }
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
        holder.itemView.setOnClickListener(view -> mContext.startActivity(new Intent(mContext, BangumiDetailActivity.class)));
    }

    @Override
    public void onBindFooterViewHolder(ViewHolder holder) {
        setButtonMore(holder, mTitle);
        if (TextUtils.equals("游戏区", mTitle)) {
            holder.setVisible(R.id.bt_more, false)
                    .setVisible(R.id.bt_more_game, true)
                    .setVisible(R.id.bt_game_center, true);
            //跳转到游戏中心
            holder.getView(R.id.bt_game_center)
                    .setOnClickListener(view -> mContext.startActivity(new Intent(mContext, GameCenterActivity.class)));
        } else {
            holder.setVisible(R.id.bt_more, true)
                    .setVisible(R.id.bt_more_game, false)
                    .setVisible(R.id.bt_game_center, false);
        }
        holder.setText(R.id.tv_dynamic, String.valueOf(mRandom.nextInt(200) + "条新动态，点击这里刷新"));
        holder.getView(R.id.iv_refresh).setOnClickListener(view ->
                view.animate()
                        .rotation(360)
                        .setInterpolator(new LinearInterpolator())
                        .setDuration(1000).start());
        holder.getView(R.id.iv_refresh).setOnClickListener(view ->
                view.animate()
                        .rotation(360)
                        .setInterpolator(new LinearInterpolator())
                        .setDuration(1000).start());
    }

    private void setTypeIcon(ViewHolder holder, String title) {
        switch (title) {
            case "番剧区":
                holder.setImageResource(R.id.iv_icon, R.mipmap.ic_category_t13);
                break;
            case "动画区":
                holder.setImageResource(R.id.iv_icon, R.mipmap.ic_category_t1);
                break;
            case "国创区":
                holder.setImageResource(R.id.iv_icon, R.mipmap.ic_category_t167);
                break;
            case "音乐区":
                holder.setImageResource(R.id.iv_icon, R.mipmap.ic_category_t3);
                break;
            case "舞蹈区":
                holder.setImageResource(R.id.iv_icon, R.mipmap.ic_category_t129);
                break;
            case "游戏区":
                holder.setImageResource(R.id.iv_icon, R.mipmap.ic_category_t4);
                break;
            case "科技区":
                holder.setImageResource(R.id.iv_icon, R.mipmap.ic_category_t36);
                break;
            case "生活区":
                holder.setImageResource(R.id.iv_icon, R.mipmap.ic_category_t160);
                break;
            case "鬼畜区":
                holder.setImageResource(R.id.iv_icon, R.mipmap.ic_category_t13);
                break;
            case "时尚区":
                holder.setImageResource(R.id.iv_icon, R.mipmap.ic_category_t155);
                break;
            case "广告区":
                holder.setImageResource(R.id.iv_icon, R.mipmap.ic_category_t165);
                break;
            case "娱乐区":
                holder.setImageResource(R.id.iv_icon, R.mipmap.ic_category_t5);
                break;
            case "电影区":
                holder.setImageResource(R.id.iv_icon, R.mipmap.ic_category_t23);
                break;
            case "电视剧区":
                holder.setImageResource(R.id.iv_icon, R.mipmap.ic_category_t11);
                break;
        }
    }

    private void setButtonMore(ViewHolder holder, String title) {
        switch (title) {
            case "番剧区":
                holder.setText(R.id.bt_more, "更多番剧");
                break;
            case "动画区":
                holder.setText(R.id.bt_more, "更多动画");
                break;
            case "国创区":
                holder.setText(R.id.bt_more, "更多国创");
                break;
            case "音乐区":
                holder.setText(R.id.bt_more, "更多音乐");
                break;
            case "舞蹈区":
                holder.setText(R.id.bt_more, "更多舞蹈");
                break;
            case "游戏区":
                holder.setText(R.id.bt_more_game, "更多游戏");
                break;
            case "科技区":
                holder.setText(R.id.bt_more, "更多科技");
                break;
            case "生活区":
                holder.setText(R.id.bt_more, "更多生活");
                break;
            case "鬼畜区":
                holder.setText(R.id.bt_more, "更多鬼畜");
                break;
            case "时尚区":
                holder.setText(R.id.bt_more, "更多时尚");
                break;
            case "广告区":
                holder.setText(R.id.bt_more, "更多广告");
                break;
            case "娱乐区":
                holder.setText(R.id.bt_more, "更多娱乐");
                break;
            case "电影区":
                holder.setText(R.id.bt_more, "更多电影");
                break;
            case "电视剧区":
                holder.setText(R.id.bt_more, "更多电视剧");
                break;
        }
    }
}
