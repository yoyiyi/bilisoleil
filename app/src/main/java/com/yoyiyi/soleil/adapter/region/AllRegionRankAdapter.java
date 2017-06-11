package com.yoyiyi.soleil.adapter.region;

import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.region.AllRegionRank;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.SpannableStringUtils;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/5 14:09
 * 描述: 全区排行
 */

public class AllRegionRankAdapter extends BaseQuickAdapter<AllRegionRank.RankBean.ListBean, BaseViewHolder> {

    public AllRegionRankAdapter(@Nullable List<AllRegionRank.RankBean.ListBean> data) {
        super(R.layout.item_all_region, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, AllRegionRank.RankBean.ListBean allRegionRank) {
        Glide.with(mContext)
                .load(allRegionRank.pic)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .bitmapTransform(new RoundedCornersTransformation(mContext, 5, 0))
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_video_preview));

        int position = holder.getAdapterPosition();
        if (position < 3) {
            SpannableStringBuilder builder = new SpannableStringUtils.Builder()
                    .append((position + 1) + "").setForegroundColor(AppUtils.getColor(R.color.pink_text_color))
                    .create();
            holder.setText(R.id.tv_rank, builder);
        } else {
            holder.setText(R.id.tv_rank, (position + 1) + "");
        }

        holder.setText(R.id.tv_video_title, allRegionRank.title)
                .setText(R.id.tv_video_up, allRegionRank.author)
                .setText(R.id.tv_video_play, allRegionRank.play + "")
                .setText(R.id.tv_video_danmaku, allRegionRank.favorites + "");

    }
}
