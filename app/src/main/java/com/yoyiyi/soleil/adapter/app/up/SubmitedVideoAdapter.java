package com.yoyiyi.soleil.adapter.app.up;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.user.MulUpDetail;
import com.yoyiyi.soleil.utils.NumberUtils;
import com.yoyiyi.soleil.utils.time.FormatUtils;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/17 13:23
 * 描述:
 */

public class SubmitedVideoAdapter extends BaseMultiItemQuickAdapter<MulUpDetail, BaseViewHolder> {

    public SubmitedVideoAdapter(List<MulUpDetail> data) {
        super(data);
        addItemType(MulUpDetail.TYPE_SUBMITED_VIDEO_ELEC, R.layout.layout_item_up_submited_video_electricize);
        addItemType(MulUpDetail.TYPE_SUBMITED_VIDEO_ITEM, R.layout.layout_item_up_submited_video_item);

    }

    @Override
    protected void convert(BaseViewHolder holder, MulUpDetail mulUpDetail) {
        switch (mulUpDetail.getItemType()) {
            case MulUpDetail.TYPE_SUBMITED_VIDEO_ELEC:

                break;

            case MulUpDetail.TYPE_SUBMITED_VIDEO_ITEM:
                Glide.with(mContext)
                        .load(mulUpDetail.archiveBean.cover)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.bili_default_image_tv)
                        .bitmapTransform(new RoundedCornersTransformation(mContext, 5, 0))
                        .dontAnimate()
                        .into((ImageView) holder.getView(R.id.iv_video_preview));

                holder.setText(R.id.tv_video_title, mulUpDetail.archiveBean.title)
                        .setText(R.id.tv_video_play, NumberUtils.format(mulUpDetail.archiveBean.play + ""))
                        .setText(R.id.tv_video_danmaku, NumberUtils.format(mulUpDetail.archiveBean.danmaku + ""))
                        .setText(R.id.tv_duration, FormatUtils.formatDuration(mulUpDetail.archiveBean.duration + ""));
                break;

        }
    }
}
