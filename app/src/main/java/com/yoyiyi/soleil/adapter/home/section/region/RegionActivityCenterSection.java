package com.yoyiyi.soleil.adapter.home.section.region;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.home.RegionActivityCenterAdapter;
import com.yoyiyi.soleil.bean.region.Region;
import com.yoyiyi.soleil.widget.section.StatelessSection;
import com.yoyiyi.soleil.widget.section.ViewHolder;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/26 21:59
 * 描述:
 */
public class RegionActivityCenterSection extends StatelessSection {

    private List<Region.BodyBean> mList;

    public RegionActivityCenterSection(List<Region.BodyBean> list) {
        super(R.layout.layout_item_home_region_head, R.layout.layout_item_home_region_activity_center, R.layout.layout_empty);
        this.mList = list;
    }


    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        holder.setText(R.id.tv_title, "活动中心")
                .setImageResource(R.id.iv_icon, R.drawable.ic_header_activity_center);
    }

    @Override
    public void onBindFooterViewHolder(ViewHolder holder) {
        RecyclerView recyclerView = holder.getView(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1,
                StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RegionActivityCenterAdapter(mList));
    }
}
