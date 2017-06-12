package com.yoyiyi.soleil.adapter.bangumi;

import android.support.annotation.Nullable;

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

public class BangumiDetailEpisodeAdapter extends BaseQuickAdapter<BangumiDetail.EpisodesBean, BaseViewHolder> {

    private int mOldPos;
    private int mNewPos = 1;

    public BangumiDetailEpisodeAdapter(@Nullable List<BangumiDetail.EpisodesBean> data) {
        super(R.layout.item_bangumi_detail_episodes, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, BangumiDetail.EpisodesBean episodesBean) {
        holder.setText(R.id.tv_index, "第" + episodesBean.index + "话");
        holder.setText(R.id.tv_index_title, episodesBean.index_title);
        holder.itemView.setOnClickListener(view -> {
            mNewPos = holder.getAdapterPosition();//新位置
            notifyDataSetChanged();
        });
        if (holder.getAdapterPosition() == mNewPos && holder.getAdapterPosition() != mOldPos) {
            holder.getView(R.id.tv_index_title).setEnabled(true);
            holder.getView(R.id.tv_index).setEnabled(true);
            holder.getView(R.id.button).setEnabled(true);
        }
        if (holder.getAdapterPosition() == mOldPos && holder.getAdapterPosition() != mNewPos) {
            holder.getView(R.id.tv_index_title).setEnabled(false);
            holder.getView(R.id.tv_index).setEnabled(false);
            holder.getView(R.id.button).setEnabled(false);
        }
        mOldPos = mNewPos;
    }
}
