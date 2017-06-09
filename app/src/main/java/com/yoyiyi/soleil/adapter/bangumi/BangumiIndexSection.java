package com.yoyiyi.soleil.adapter.bangumi;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.bangumi.BangumiIndex;
import com.yoyiyi.soleil.widget.section.StatelessSection;
import com.yoyiyi.soleil.widget.section.ViewHolder;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/9 16:19
 * 描述:
 */

public class BangumiIndexSection extends StatelessSection<BangumiIndex.CategoryBean> {

    public BangumiIndexSection(List<BangumiIndex.CategoryBean> data) {
        super(R.layout.layout_item_bangumi_index_head, R.layout.layout_item_bangumi_index_body, data);
    }

    @Override
    public void convert(ViewHolder holder, BangumiIndex.CategoryBean categoryBean, int position) {
        holder.setText(R.id.tv_title, categoryBean.tag_name);
        Glide.with(mContext)
                .load(categoryBean.cover)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_icon));
    }
}
