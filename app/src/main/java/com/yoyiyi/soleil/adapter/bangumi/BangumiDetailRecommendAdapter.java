package com.yoyiyi.soleil.adapter.bangumi;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.bangumi.BangumiDetailRecommend;
import com.yoyiyi.soleil.utils.NumberUtils;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/12 19:05
 * 描述:
 */

class BangumiDetailRecommendAdapter extends BaseQuickAdapter<BangumiDetailRecommend.ListBean, BaseViewHolder> {
    public BangumiDetailRecommendAdapter(@Nullable List<BangumiDetailRecommend.ListBean> data) {
        super(R.layout.item_bangumi_detail_recommend, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, BangumiDetailRecommend.ListBean listBean) {
        Glide.with(mContext)
                .load(listBean.cover)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_video_preview));
        holder.setText(R.id.tv_video_play, NumberUtils.format(listBean.follow + ""));
    }
}
