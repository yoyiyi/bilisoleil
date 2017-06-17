package com.yoyiyi.soleil.adapter.app.up;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.user.MulUpDetail;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/17 16:06
 * 描述:
 */

public class FavouriteAdapter extends BaseMultiItemQuickAdapter<MulUpDetail, BaseViewHolder> {

    public FavouriteAdapter(List<MulUpDetail> data) {
        super(data);
        addItemType(MulUpDetail.TYPE_FAVOURITE_ITEM, R.layout.item_up_detail_favourite);
    }


    @Override
    protected void convert(BaseViewHolder holder, MulUpDetail mulUpDetail) {
        Glide.with(mContext)
                .load(mulUpDetail.favouriteBean.cover)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .bitmapTransform(new RoundedCornersTransformation(mContext, 5, 0))
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_video_preview));

        holder.setText(R.id.tv_video_title, mulUpDetail.favouriteBean.name)
                .setText(R.id.tv_video_state, mulUpDetail.favouriteBean.state == 2 ? "公开 · " + mulUpDetail.favouriteBean.cur_count + "个内容" : "私密");
    }
}
