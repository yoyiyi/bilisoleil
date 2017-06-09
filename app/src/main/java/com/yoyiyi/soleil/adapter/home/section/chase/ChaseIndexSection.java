package com.yoyiyi.soleil.adapter.home.section.chase;

import android.content.Intent;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.module.bangumi.BangumiIndexActivity;
import com.yoyiyi.soleil.module.bangumi.BangumiScheduleActivity;
import com.yoyiyi.soleil.widget.section.StatelessSection;
import com.yoyiyi.soleil.widget.section.ViewHolder;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/26 21:59
 * 描述:
 */
public class ChaseIndexSection extends StatelessSection {


    public ChaseIndexSection() {
        super(R.layout.layout_item_home_chase_bangumi_index, R.layout.layout_empty);
    }

    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        holder.getView(R.id.ll_bangumi_timeline)
                .setOnClickListener(view ->
                        mContext.startActivity(new Intent(mContext, BangumiScheduleActivity.class)));
        holder.getView(R.id.ll_bangumi_index)
                .setOnClickListener(view ->
                        mContext.startActivity(new Intent(mContext, BangumiIndexActivity.class)));
    }
}
