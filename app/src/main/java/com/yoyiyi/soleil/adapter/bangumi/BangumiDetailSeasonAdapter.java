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
 * 描述:分季
 */

public class BangumiDetailSeasonAdapter extends BaseQuickAdapter<BangumiDetail.SeasonsBean, BaseViewHolder> {

    private int mOldPos;
    private String mSeasonTitle;
    private int mNewPos = -1;

    private boolean mFlag = true;

    public BangumiDetailSeasonAdapter(@Nullable List<BangumiDetail.SeasonsBean> data, String seasonTitle) {
        super(R.layout.item_bangumi_detail_seasons, data);
        mSeasonTitle = seasonTitle;
    }

    @Override
    protected void convert(BaseViewHolder holder, BangumiDetail.SeasonsBean seasonsBean) {
        holder.setText(R.id.tv_index, seasonsBean.title);
        if (mFlag) {
            if (TextUtils.equals(seasonsBean.title, mSeasonTitle)) {
                mNewPos = holder.getAdapterPosition();
                mOldPos = mNewPos;
                mFlag = false;
            }
        }
        holder.itemView.setOnClickListener(view -> {
            mNewPos = holder.getAdapterPosition();//新位置
            mOldPos = mNewPos;
            notifyDataSetChanged();
        });
        if (holder.getAdapterPosition() == mNewPos) {
            holder.getView(R.id.tv_index).setEnabled(true);
            holder.getView(R.id.ll_root).setEnabled(true);
        } else {
            holder.getView(R.id.tv_index).setEnabled(false);
            holder.getView(R.id.ll_root).setEnabled(false);
        }
        if (mNewPos != mOldPos) {
            holder.getView(R.id.tv_index).setEnabled(false);
            holder.getView(R.id.ll_root).setEnabled(false);
        }
        if (holder.getAdapterPosition() == getItemCount() - 1) {
            holder.setVisible(R.id.space, true);
        } else {
            holder.setVisible(R.id.space, false);
        }
    }


}
