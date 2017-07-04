package com.yoyiyi.soleil.adapter.app.up;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.user.MulUpDetail;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.LogUtils;
import com.yoyiyi.soleil.utils.NumberUtils;
import com.yoyiyi.soleil.utils.SpanUtils;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/17 16:06
 * 描述:
 */

public class ArchiveAdapter extends BaseMultiItemQuickAdapter<MulUpDetail, BaseViewHolder> {
    public ArchiveAdapter(List<MulUpDetail> data) {
        super(data);
        addItemType(MulUpDetail.TYPE_ARCHIVE_LIVE,R.layout.layout_item_up_detail_archive_live);
        addItemType(MulUpDetail.TYPE_ARCHIVE_HEAD, R.layout.layout_item_up_detail_archive_head);
        addItemType(MulUpDetail.TYPE_ARCHIVE_ALL_SUBMIT_VIDEO, R.layout.layout_item_up_detail_archive_submited_video_item);
        addItemType(MulUpDetail.TYPE_ARCHIVE_FAVOURITE, R.layout.layout_item_up_detail_archive_favourite);

    }


    @Override
    protected void convert(BaseViewHolder holder, MulUpDetail mulUpDetail) {
        switch (mulUpDetail.itemType) {
            case MulUpDetail.TYPE_ARCHIVE_LIVE:
                holder.setText(R.id.tv_live_state,"正在轮播: "+mulUpDetail.live.title);
                break;
            case MulUpDetail.TYPE_ARCHIVE_HEAD:
                SpanUtils span = new SpanUtils();
                if (mulUpDetail.state == 0) {
                    span.append(mulUpDetail.title)
                            .appendSpace(10)
                            .append(mulUpDetail.count + "")
                            .setForegroundColor(AppUtils.getColor(R.color.font_gray))
                            .appendSpace(10)
                            .appendImage(R.drawable.ic_invisible)
                            .append("未公开")
                            .setForegroundColor(AppUtils.getColor(R.color.font_gray));
                } else {
                    span.append(mulUpDetail.title)
                            .append(mulUpDetail.count + "")
                            .setForegroundColor(AppUtils.getColor(R.color.font_gray));
                }
                holder.setText(R.id.tv_title, span.create());
                holder.setVisible(R.id.tv_more, mulUpDetail.count == 0 ? false : true);
                break;

            case MulUpDetail.TYPE_ARCHIVE_ALL_SUBMIT_VIDEO://全部投稿
                LogUtils.d("shiAda",holder.getAdapterPosition());
                LogUtils.d("shiLay",holder.getLayoutPosition());
                LogUtils.d("shiOld",holder.getOldPosition());


                holder.setText(R.id.tv_video_title, mulUpDetail.archiveBean.title)
                        .setText(R.id.tv_video_play_num, NumberUtils.format(mulUpDetail.archiveBean.play + ""))
                        .setText(R.id.tv_video_favourite, NumberUtils.format(mulUpDetail.archiveBean.danmaku + ""));
                Glide.with(mContext)
                        .load(mulUpDetail.archiveBean.cover)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.bili_default_image_tv)
                        .dontAnimate()
                        .into((ImageView) holder.getView(R.id.iv_video_preview));

                if (mulUpDetail.position % 2 == 0){
                    ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams)holder.itemView.getLayoutParams();
                    params.setMargins(
                            (int) mContext.getResources().getDimension(R.dimen.dp10),
                            (int) mContext.getResources().getDimension(R.dimen.dp10),
                            (int)mContext.getResources().getDimension(R.dimen.dp5),
                            (int)mContext.getResources().getDimension(R.dimen.dp10));
                    holder.itemView.setLayoutParams(params);
                }else {
                    ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams)holder.itemView.getLayoutParams();
                    params.setMargins(
                            (int) mContext.getResources().getDimension(R.dimen.dp5),
                            (int) mContext.getResources().getDimension(R.dimen.dp10),
                            (int)mContext.getResources().getDimension(R.dimen.dp10),
                            (int)mContext.getResources().getDimension(R.dimen.dp10));
                    holder.itemView.setLayoutParams(params);
                }
                break;

            case MulUpDetail.TYPE_ARCHIVE_FAVOURITE:
                RecyclerView recyclerView = holder.getView(R.id.recycler);
                recyclerView.setHasFixedSize(true);
                // recyclerView.setNestedScrollingEnabled(false);
                StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1,
                        StaggeredGridLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(new ArchiveFavouriteAdapter(mulUpDetail.favourite.item));

                break;
        }

    }
}
