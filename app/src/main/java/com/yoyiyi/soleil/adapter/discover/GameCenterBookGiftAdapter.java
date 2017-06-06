package com.yoyiyi.soleil.adapter.discover;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.discover.GameCenter;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/6 12:57
 * 描述:
 */

public class GameCenterBookGiftAdapter extends BaseQuickAdapter<GameCenter.BookGiftBean, BaseViewHolder> {
    public GameCenterBookGiftAdapter(@Nullable List<GameCenter.BookGiftBean> data) {
        super(R.layout.item_game_center_book_gift, data);
    }


    @Override
    protected void convert(BaseViewHolder holder, GameCenter.BookGiftBean bookGiftBean) {
        holder.setText(R.id.tv_title, bookGiftBean.name);
        Glide.with(mContext)
                .load(bookGiftBean.image)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_preview));

    }
}
