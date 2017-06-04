package com.yoyiyi.soleil.adapter.region;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.event.Event;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.region.RegionEnter;
import com.yoyiyi.soleil.rx.RxBus;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 23:30
 * 描述:分区入口
 */
public class RegionRecommendEntranceAdapter extends BaseQuickAdapter<RegionEnter, BaseViewHolder> {
    public RegionRecommendEntranceAdapter(@Nullable List<RegionEnter> data) {
        super(R.layout.item_live_entrance, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, RegionEnter item) {
        Glide.with(mContext)
                .load(item.img)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_icon));
        holder.setText(R.id.tv_title, item.title);
        holder.itemView.setOnClickListener(view -> {
            //发送点击事件
            Event.RegionEntrancePositionEvent positionEvent = new Event.RegionEntrancePositionEvent();
            positionEvent.position = holder.getAdapterPosition();
            RxBus.INSTANCE.post(positionEvent);
        });
    }

}