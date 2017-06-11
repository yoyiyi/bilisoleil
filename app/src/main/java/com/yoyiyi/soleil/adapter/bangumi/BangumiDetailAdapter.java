package com.yoyiyi.soleil.adapter.bangumi;

import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.bangumi.BangumiDetail;
import com.yoyiyi.soleil.bean.bangumi.MulBangumiDetail;
import com.yoyiyi.soleil.utils.NumberUtils;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/11 22:02
 * 描述:番剧详情
 */
public class BangumiDetailAdapter extends BaseMultiItemQuickAdapter<MulBangumiDetail, BaseViewHolder> {

    public BangumiDetailAdapter(List<MulBangumiDetail> data) {
        super(data);
        addItemType(MulBangumiDetail.TYPE_HEAD, R.layout.layout_item_bangumi_detail_info);
    }

    @Override
    protected void convert(BaseViewHolder holder, MulBangumiDetail mulBangumiDetail) {
        switch (mulBangumiDetail.mItemType) {
            case MulBangumiDetail.TYPE_COMMENT_HEAD:
                BangumiDetail bangumiDetail = mulBangumiDetail.mBangumiDetail;
                holder.setText(R.id.tv_play, "播放:" + NumberUtils.format(bangumiDetail.play_count + ""))
                        .setText(R.id.tv_follow, "追番" + NumberUtils.format(bangumiDetail.favorites))
                        .setText(R.id.tv_state, TextUtils.equals(bangumiDetail.is_finish, "0") ? "连载中" : "已完结");
                Glide.with(mContext)
                        .load(bangumiDetail.cover)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate()
                        .into((ImageView) holder.getView(R.id.iv_pic));
                Glide.with(mContext)
                        .load(bangumiDetail.cover)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate()
                        .into((ImageView) holder.getView(R.id.iv_pic_big));
                break;

        }
    }
}
