package com.yoyiyi.soleil.adapter.home.section.chase;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.home.ChaseRecommendCNAdapter;
import com.yoyiyi.soleil.bean.chase.RecommendBangumi;
import com.yoyiyi.soleil.widget.section.StatelessSection;
import com.yoyiyi.soleil.widget.section.ViewHolder;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/26 21:59
 * 描述:
 */
public class ChaseRecommendCNSection extends StatelessSection {

    private RecommendBangumi.RecommendCnBean.FootBean mFootBean;
    private List<RecommendBangumi.RecommendCnBean.RecommendBean> mList;

    public ChaseRecommendCNSection(List<RecommendBangumi.RecommendCnBean.RecommendBean> data, RecommendBangumi.RecommendCnBean.FootBean footBean) {
        super(R.layout.layout_item_home_chase_head, R.layout.layout_item_home_chase_footer, R.layout.layout_item_home_chase_body);
        this.mFootBean = footBean;
        this.mList = data;
    }


    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        holder.setText(R.id.tv_title, "国产动画推荐")
                .setImageResource(R.id.iv_icon, R.drawable.bangumi_follow_home_ic_domestic);

    }

    @Override
    public void onBindItemViewHolder(ViewHolder holder, int position) {
        RecyclerView recyclerView = holder.getView(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        GridLayoutManager layoutManager = new GridLayoutManager(mContext, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ChaseRecommendCNAdapter(mList));


    }

    @Override
    public void onBindFooterViewHolder(ViewHolder holder) {
        Glide.with(mContext)
                .load(mFootBean.cover)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_video_preview));
        holder.setText(R.id.tv_title, mFootBean.title)
                .setText(R.id.tv_des, mFootBean.desc);
        if (mFootBean.is_new == 1) {
            holder.setVisible(R.id.tv_new_tag, true);
        } else {
            holder.setVisible(R.id.tv_new_tag, false);
        }
    }
}
