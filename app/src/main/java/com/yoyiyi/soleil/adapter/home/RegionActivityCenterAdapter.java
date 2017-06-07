package com.yoyiyi.soleil.adapter.home;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.region.Region;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/27 16:06
 * 描述: 分区界面活动中心
 */

public class RegionActivityCenterAdapter extends BaseQuickAdapter<Region.BodyBean, BaseViewHolder> {
    public RegionActivityCenterAdapter(@Nullable List<Region.BodyBean> data) {
        super(R.layout.item_home_region_activity_center, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, Region.BodyBean bodyBean) {
        Glide.with(mContext)
                .load(bodyBean.cover)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_video_preview));
        holder.setText(R.id.tv_video_title, bodyBean.title);
        int position = holder.getAdapterPosition();
        if (position == getItemCount() - 1) {
            holder.setVisible(R.id.space, true);
        } else {
            holder.setVisible(R.id.space, false);
        }

        /*int position = holder.getAdapterPosition();
        if (position == getItemCount() - 1) {
            CardView view = holder.getView(R.id.card_view);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins((int) AppUtils.getDimension(R.dimen.dp10),
                    (int) AppUtils.getDimension(R.dimen.dp5),
                    (int) AppUtils.getDimension(R.dimen.dp10),
                    (int) AppUtils.getDimension(R.dimen.dp5));
            holder.itemView.setLayoutParams(params);
        }*/
    }
}
