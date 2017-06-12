package com.yoyiyi.soleil.adapter.bangumi;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.bangumi.BangumiDetail;
import com.yoyiyi.soleil.bean.bangumi.MulBangumiDetail;
import com.yoyiyi.soleil.utils.NumberUtils;
import com.yoyiyi.soleil.widget.flowlayout.FlowLayout;
import com.yoyiyi.soleil.widget.flowlayout.TagAdapter;
import com.yoyiyi.soleil.widget.flowlayout.TagFlowLayout;

import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/11 22:02
 * 描述:番剧详情
 */
public class BangumiDetailAdapter extends BaseMultiItemQuickAdapter<MulBangumiDetail, BaseViewHolder> {


    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;

    public BangumiDetailAdapter(List<MulBangumiDetail> data) {
        super(data);
        addItemType(MulBangumiDetail.TYPE_HEAD, R.layout.layout_item_bangumi_detail_info);//头部信息
        addItemType(MulBangumiDetail.TYPE_SEASON, R.layout.common_recycler);//分季
        addItemType(MulBangumiDetail.TYPE_EPISODE_HEAD, R.layout.layout_item_bangumi_detail_head);//分集头部
        addItemType(MulBangumiDetail.TYPE_EPISODE_ITEM, R.layout.common_recycler);//分集
        addItemType(MulBangumiDetail.TYPE_CONTRACTED, R.layout.layout_bangumi_detail_contracted);//追番
        addItemType(MulBangumiDetail.TYPE_DES, R.layout.layout_item_bangumi_detail_des);//简介
        addItemType(MulBangumiDetail.TYPE_RECOMMEND_HEAD, R.layout.layout_item_bangumi_detail_head);//更多推荐
        addItemType(MulBangumiDetail.TYPE_RECOMMEND_ITEM, R.layout.common_recycler);//更多推荐
        addItemType(MulBangumiDetail.TYPE_COMMENT_HEAD, R.layout.layout_item_bangumi_detail_head);//更多推荐
        addItemType(MulBangumiDetail.TYPE_COMMENT_HOT_ITEM, R.layout.common_recycler);//更多推荐
        addItemType(MulBangumiDetail.TYPE_COMMENT_MORE, R.layout.common_recycler);//更多推荐
        addItemType(MulBangumiDetail.TYPE_COMMENT_NOMAL_ITEM, R.layout.common_recycler);//更多推荐

    }

    @Override
    protected void convert(BaseViewHolder holder, MulBangumiDetail mulBangumiDetail) {
        switch (mulBangumiDetail.mItemType) {
            case MulBangumiDetail.TYPE_HEAD://头部信息
                holder.setText(R.id.tv_play, "播放:" + NumberUtils.format(mulBangumiDetail.mPlayCount + ""))
                        .setText(R.id.tv_follow, "追番" + NumberUtils.format(mulBangumiDetail.mFavorites + ""))
                        .setText(R.id.tv_state, TextUtils.equals(mulBangumiDetail.mIsFinish, "0") ? "连载中" : "已完结");
                Glide.with(mContext)
                        .load(mulBangumiDetail.mCover)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate()
                        .into((ImageView) holder.getView(R.id.iv_pic));
                Glide.with(mContext)
                        .load(mulBangumiDetail.mCover)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .bitmapTransform(new BlurTransformation(mContext, 26))
                        .dontAnimate()
                        .into((ImageView) holder.getView(R.id.iv_pic_big));
                break;

            case MulBangumiDetail.TYPE_SEASON://分季
                mRecyclerView = holder.getView(R.id.recycler);
                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.setNestedScrollingEnabled(false);
                mLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(new BangumiDetailSeasonAdapter(mulBangumiDetail.mSeasonsBeanList, mulBangumiDetail.mSeasonsTitle));
                break;
            case MulBangumiDetail.TYPE_EPISODE_ITEM://选集
                mRecyclerView = holder.getView(R.id.recycler);
                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.setNestedScrollingEnabled(false);
                mLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(new BangumiDetailEpisodeAdapter(mulBangumiDetail.mEpisodesBeans));
                break;
            case MulBangumiDetail.TYPE_EPISODE_HEAD://选集头部
                holder.setText(R.id.tv_title, "选集");
                if (TextUtils.equals(mulBangumiDetail.mIsFinish, "0")) {
                    holder.setText(R.id.tv_online, "一共 " + mulBangumiDetail.mTotalCount + " 话");
                } else {
                    holder.setText(R.id.tv_online, "更新至第 " + mulBangumiDetail.mTotalCount + " 话");
                }

                break;
            case MulBangumiDetail.TYPE_CONTRACTED://承包

                break;
            case MulBangumiDetail.TYPE_DES://简介
                holder.setText(R.id.tv_title, mulBangumiDetail.mEvaluate)
                        .setText(R.id.tv_online, "更多");
                TagFlowLayout tagsLayout = holder.getView(R.id.tags_layout);
                tagsLayout.setAdapter(new TagAdapter<BangumiDetail.TagsBean>(mulBangumiDetail.mTagsBeanList) {
                    @Override
                    public View getView(FlowLayout flowLayout, int i, BangumiDetail.TagsBean listBean) {
                        TextView mTags = (TextView) LayoutInflater.from(mContext)
                                .inflate(R.layout.layout_hot_tags_item, flowLayout, false);
                        mTags.setText(listBean.tag_name);
                        //mTags.setOnClickListener(view -> TotalSearchActivity.startActivity(mContext, listBean.keyword));
                        return mTags;
                    }
                });
                break;
            case MulBangumiDetail.TYPE_RECOMMEND_HEAD://推荐头部
                holder.setText(R.id.tv_title, "更多推荐")
                        .setText(R.id.tv_online, "换一换")
                        .setVisible(R.id.iv_trans, true)
                        .setVisible(R.id.iv_arrow, false);
                break;
            case MulBangumiDetail.TYPE_RECOMMEND_ITEM://推荐内容
                mRecyclerView = holder.getView(R.id.recycler);
                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.setNestedScrollingEnabled(false);
                GridLayoutManager layoutManager = new GridLayoutManager(mContext, 3);
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setAdapter(new BangumiDetailRecommendAdapter(mulBangumiDetail.mBangumiRecommendList));
                break;
            case MulBangumiDetail.TYPE_COMMENT_HEAD://评论头部


                break;
            case MulBangumiDetail.TYPE_COMMENT_HOT_ITEM://评论头部

                break;
            case MulBangumiDetail.TYPE_COMMENT_MORE://更多评论

                break;
            case MulBangumiDetail.TYPE_COMMENT_NOMAL_ITEM://更多评论

                break;
        }
    }
}
