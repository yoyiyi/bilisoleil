package com.yoyiyi.soleil.adapter.home;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.dynamic.Dynamic;
import com.yoyiyi.soleil.bean.dynamic.MulDynamic;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.NumberUtils;
import com.yoyiyi.soleil.utils.SpanUtils;
import com.yoyiyi.soleil.utils.time.FormatUtils;
import com.yoyiyi.soleil.widget.CircleImageView;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/13 16:09
 * 描述:动态Adapter
 */

public class DynamicAdapter extends BaseMultiItemQuickAdapter<MulDynamic, BaseViewHolder> {
    public DynamicAdapter(@Nullable List<MulDynamic> data) {
        super(data);
        addItemType(MulDynamic.TYPE_LV0, R.layout.item_home_dynamic);
    }

    @Override
    protected void convert(BaseViewHolder holder, MulDynamic mulDynamic) {
            switch (holder.getItemViewType()){
                case MulDynamic.TYPE_LV0:
                    Dynamic.ItemBean itemBean = mulDynamic.group;
                    holder.setVisible(R.id.fl_recent, itemBean.isRecent == 1 ? true : false);
                    holder.setText(R.id.tv_recent, "还有" + itemBean.recent_count + "个视频被隐藏");
                    holder.getView(R.id.tv_recent).setOnClickListener(view -> {

                    });
                    holder.itemView.setVisibility(View.GONE);
                    switch (itemBean.type) {
                        case 0://关注up
                            holder.setVisible(R.id.iv_avatar, true)
                                    .setVisible(R.id.tv_tag, false)
                                    .setText(R.id.tv_title, new SpanUtils()
                                            .append(itemBean.name)
                                            .setFontSize(14)
                                            .setForegroundColor(AppUtils.getColor(R.color.black_alpha_30))
                                            .appendSpace(5)
                                            .append(FormatUtils.getDescriptionTimeFromDateString(itemBean.ctime + ""))
                                            .setFontSize(12)
                                            .setForegroundColor(AppUtils.getColor(R.color.font_gray))
                                            .create())
                                    .setText(R.id.tv_video_title, itemBean.title)
                                    .setVisible(R.id.iv_video_play_num, true)
                                    .setVisible(R.id.tv_video_play_num, true)
                                    .setVisible(R.id.tv_video_favourite, true)
                                    .setVisible(R.id.iv_video_online_region, true)
                                    .setText(R.id.tv_video_play_num, NumberUtils.format(itemBean.play + ""))
                                    .setText(R.id.tv_video_favourite, NumberUtils.format(itemBean.favorite + ""))
                                    .setVisible(R.id.iv_tag_video_play_num, false)
                                    .setVisible(R.id.tv_tag_video_favourite, false)
                                    .setVisible(R.id.tv_tag_video_favourite, false)
                                    .setText(R.id.tv_tag_video_play_num, itemBean.tname
                                            + itemBean.tag == null ? "" : " · " + itemBean.tag.tag_name);
                            Glide.with(mContext)
                                    .load(itemBean.face)
                                    .centerCrop()
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .placeholder(R.drawable.bili_default_avatar)
                                    .dontAnimate()
                                    .into((CircleImageView) holder.getView(R.id.iv_avatar));
                            Glide.with(mContext)
                                    .load(itemBean.cover)
                                    .centerCrop()
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .placeholder(R.drawable.bili_default_image_tv)
                                    .dontAnimate()
                                    .into((ImageView) holder.getView(R.id.iv_preview));
                            break;
                        case 2://国产动画
                            holder.setVisible(R.id.iv_avatar, false)
                                    .setVisible(R.id.tv_tag, true)
                                    .setText(R.id.tv_tag, new SpanUtils()
                                            .setBackgroundColor(AppUtils.getColor(R.color.yellow_30))
                                            .append("国产动画").create())
                                    .setText(R.id.tv_title, new SpanUtils()
                                            .append(FormatUtils.getDescriptionTimeFromDateString(itemBean.ctime + ""))
                                            .setFontSize(12)
                                            .setForegroundColor(AppUtils.getColor(R.color.font_gray))
                                            .create())
                                    .setText(R.id.tv_video_title, itemBean.title)
                                    .setVisible(R.id.iv_video_play_num, false)
                                    .setVisible(R.id.tv_video_play_num, true)
                                    .setVisible(R.id.tv_video_favourite, false)
                                    .setVisible(R.id.iv_video_online_region, false)
                                    .setText(R.id.tv_video_play_num, NumberUtils.format(itemBean.play + ""))
                                    .setVisible(R.id.iv_tag_video_play_num, true)
                                    .setVisible(R.id.tv_tag_video_favourite, true)
                                    .setVisible(R.id.tv_tag_video_favourite, true)
                                    .setText(R.id.tv_tag_video_play_num, NumberUtils.format(itemBean.danmaku + ""));
                            Glide.with(mContext)
                                    .load(itemBean.cover)
                                    .centerCrop()
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .placeholder(R.drawable.bili_default_image_tv)
                                    .dontAnimate()
                                    .into((ImageView) holder.getView(R.id.iv_preview));
                            break;

                        case 1://可能是番剧 不知道参数意思
                            holder.setVisible(R.id.iv_avatar, false)
                                    .setVisible(R.id.tv_tag, true)
                                    .setText(R.id.tv_tag, new SpanUtils()
                                            .setBackgroundColor(AppUtils.getColor(R.color.pink_text_color))
                                            .append("番剧").create())
                                    .setText(R.id.tv_title, new SpanUtils()
                                            .append(FormatUtils.getDescriptionTimeFromDateString(itemBean.ctime + ""))
                                            .setFontSize(12)
                                            .setForegroundColor(AppUtils.getColor(R.color.font_gray))
                                            .create())
                                    .setText(R.id.tv_video_title, "第" + itemBean.index + "话" + " " + itemBean.index_title)
                                    .setVisible(R.id.iv_video_play_num, false)
                                    .setVisible(R.id.tv_video_play_num, true)
                                    .setVisible(R.id.tv_video_favourite, false)
                                    .setVisible(R.id.iv_video_online_region, false)
                                    .setText(R.id.tv_video_play_num, NumberUtils.format(itemBean.play + ""))
                                    .setVisible(R.id.iv_tag_video_play_num, true)
                                    .setVisible(R.id.tv_tag_video_favourite, true)
                                    .setVisible(R.id.tv_tag_video_favourite, true)
                                    .setText(R.id.tv_tag_video_play_num, NumberUtils.format(itemBean.danmaku + ""));
                            Glide.with(mContext)
                                    .load(itemBean.cover)
                                    .centerCrop()
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .placeholder(R.drawable.bili_default_image_tv)
                                    .dontAnimate()
                                    .into((ImageView) holder.getView(R.id.iv_preview));
                            break;

                    }



                    break;

            }
    }

   /* @Override
    protected void convert(BaseViewHolder holder, Dynamic.ItemBean itemBean) {
        holder.setVisible(R.id.fl_recent, itemBean.isRecent == 1 ? true : false);
        holder.setText(R.id.tv_recent, "还有" + itemBean.recent_count + "个视频被隐藏");
        if (itemBean.isRecent == 1) {
            for (int i = 0; i < itemBean.position; i++) {

            }

        }

        holder.getView(R.id.tv_recent).setOnClickListener(view -> {

        });
        holder.itemView.setVisibility(View.GONE);
        switch (itemBean.type) {
            case 0://关注up
                holder.setVisible(R.id.iv_avatar, true)
                        .setVisible(R.id.tv_tag, false)
                        .setText(R.id.tv_title, new SpanUtils()
                                .append(itemBean.name)
                                .setFontSize(14)
                                .setForegroundColor(AppUtils.getColor(R.color.black_alpha_30))
                                .appendSpace(5)
                                .append(FormatUtils.getDescriptionTimeFromDateString(itemBean.ctime + ""))
                                .setFontSize(12)
                                .setForegroundColor(AppUtils.getColor(R.color.font_gray))
                                .create())
                        .setText(R.id.tv_video_title, itemBean.title)
                        .setVisible(R.id.iv_video_play_num, true)
                        .setVisible(R.id.tv_video_play_num, true)
                        .setVisible(R.id.tv_video_favourite, true)
                        .setVisible(R.id.iv_video_online_region, true)
                        .setText(R.id.tv_video_play_num, NumberUtils.format(itemBean.play + ""))
                        .setText(R.id.tv_video_favourite, NumberUtils.format(itemBean.favorite + ""))
                        .setVisible(R.id.iv_tag_video_play_num, false)
                        .setVisible(R.id.tv_tag_video_favourite, false)
                        .setVisible(R.id.tv_tag_video_favourite, false)
                        .setText(R.id.tv_tag_video_play_num, itemBean.tname
                                + itemBean.tag == null ? "" : " · " + itemBean.tag.tag_name);
                Glide.with(mContext)
                        .load(itemBean.face)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.bili_default_avatar)
                        .dontAnimate()
                        .into((CircleImageView) holder.getView(R.id.iv_avatar));
                Glide.with(mContext)
                        .load(itemBean.cover)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.bili_default_image_tv)
                        .dontAnimate()
                        .into((ImageView) holder.getView(R.id.iv_preview));
                break;
            case 2://国产动画
                holder.setVisible(R.id.iv_avatar, false)
                        .setVisible(R.id.tv_tag, true)
                        .setText(R.id.tv_tag, new SpanUtils()
                                .setBackgroundColor(AppUtils.getColor(R.color.yellow_30))
                                .append("国产动画").create())
                        .setText(R.id.tv_title, new SpanUtils()
                                .append(FormatUtils.getDescriptionTimeFromDateString(itemBean.ctime + ""))
                                .setFontSize(12)
                                .setForegroundColor(AppUtils.getColor(R.color.font_gray))
                                .create())
                        .setText(R.id.tv_video_title, itemBean.title)
                        .setVisible(R.id.iv_video_play_num, false)
                        .setVisible(R.id.tv_video_play_num, true)
                        .setVisible(R.id.tv_video_favourite, false)
                        .setVisible(R.id.iv_video_online_region, false)
                        .setText(R.id.tv_video_play_num, NumberUtils.format(itemBean.play + ""))
                        .setVisible(R.id.iv_tag_video_play_num, true)
                        .setVisible(R.id.tv_tag_video_favourite, true)
                        .setVisible(R.id.tv_tag_video_favourite, true)
                        .setText(R.id.tv_tag_video_play_num, NumberUtils.format(itemBean.danmaku + ""));
                Glide.with(mContext)
                        .load(itemBean.cover)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.bili_default_image_tv)
                        .dontAnimate()
                        .into((ImageView) holder.getView(R.id.iv_preview));
                break;

            case 1://可能是番剧 不知道参数意思
                holder.setVisible(R.id.iv_avatar, false)
                        .setVisible(R.id.tv_tag, true)
                        .setText(R.id.tv_tag, new SpanUtils()
                                .setBackgroundColor(AppUtils.getColor(R.color.pink_text_color))
                                .append("番剧").create())
                        .setText(R.id.tv_title, new SpanUtils()
                                .append(FormatUtils.getDescriptionTimeFromDateString(itemBean.ctime + ""))
                                .setFontSize(12)
                                .setForegroundColor(AppUtils.getColor(R.color.font_gray))
                                .create())
                        .setText(R.id.tv_video_title, "第" + itemBean.index + "话" + " " + itemBean.index_title)
                        .setVisible(R.id.iv_video_play_num, false)
                        .setVisible(R.id.tv_video_play_num, true)
                        .setVisible(R.id.tv_video_favourite, false)
                        .setVisible(R.id.iv_video_online_region, false)
                        .setText(R.id.tv_video_play_num, NumberUtils.format(itemBean.play + ""))
                        .setVisible(R.id.iv_tag_video_play_num, true)
                        .setVisible(R.id.tv_tag_video_favourite, true)
                        .setVisible(R.id.tv_tag_video_favourite, true)
                        .setText(R.id.tv_tag_video_play_num, NumberUtils.format(itemBean.danmaku + ""));
                Glide.with(mContext)
                        .load(itemBean.cover)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.bili_default_image_tv)
                        .dontAnimate()
                        .into((ImageView) holder.getView(R.id.iv_preview));
                break;

        }

    }*/
}
