package com.yoyiyi.soleil.adapter.bangumi;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.bangumi.BangumiDetail;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/12 17:31
 * 描述:
 */

public class BangumiDetailSeasonAdapter extends BaseQuickAdapter<BangumiDetail.SeasonsBean, BaseViewHolder> {

    private int mOldPos;
    private String mSeasonTitle;
    private int mNewPos;

    public BangumiDetailSeasonAdapter(@Nullable List<BangumiDetail.SeasonsBean> data, String seasonTitle) {
        super(R.layout.item_bangumi_detail_seasons, data);
        mSeasonTitle = seasonTitle;
    }

    @Override
    protected void convert(BaseViewHolder holder, BangumiDetail.SeasonsBean seasonsBean) {
        holder.setText(R.id.tv_index_title, seasonsBean.title);
        if (TextUtils.equals(seasonsBean.title, mSeasonTitle)) {
            mOldPos = holder.getAdapterPosition();
            holder.getView(R.id.tv_index_title).setEnabled(true);
            notifyDataSetChanged();
        }
        holder.itemView.setOnClickListener(view -> {
            mNewPos = holder.getAdapterPosition();//新位置
        });
        if (holder.getAdapterPosition() == mNewPos && holder.getAdapterPosition() != mOldPos) {
            holder.getView(R.id.tv_index_title).setEnabled(true);
        }
        if (holder.getAdapterPosition() == mOldPos && holder.getAdapterPosition() != mNewPos) {
            holder.getView(R.id.tv_index_title).setEnabled(false);
        }
        mOldPos = mNewPos;
    }
}
