package com.yoyiyi.soleil.adapter.app.up;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.user.UpDetail;
import com.yoyiyi.soleil.utils.EmptyUtils;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/17 19:24
 * 描述:
 */

public class ArchiveFavouriteAdapter extends BaseQuickAdapter<UpDetail.DataBean.FavouriteBean.ItemBeanX, BaseViewHolder> {
    public ArchiveFavouriteAdapter(@Nullable List<UpDetail.DataBean.FavouriteBean.ItemBeanX> data) {
        super(R.layout.item_up_detail_archive_favourite, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, UpDetail.DataBean.FavouriteBean.ItemBeanX item) {
        List<UpDetail.DataBean.FavouriteBean.ItemBeanX.CoverBean> cover = item.cover;
        int[] coverId = new int[]{R.id.iv_view1, R.id.iv_view2, R.id.iv_view3};
        if (EmptyUtils.isNotEmpty(cover)) {
            for (int i = 0; i < cover.size(); i++) {
                Glide.with(mContext)
                        .load(cover.get(i).pic)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate()
                        .into((ImageView) holder.getView(coverId[i]));
            }
            holder.setText(R.id.tv_favourite_title, item.name)
                    .setText(R.id.tv_favourite_count, item.cur_count + "");
        }
    }
}
