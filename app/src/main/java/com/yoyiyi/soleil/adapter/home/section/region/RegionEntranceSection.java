package com.yoyiyi.soleil.adapter.home.section.region;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.region.RegionEnter;
import com.yoyiyi.soleil.bean.region.RegionTagType;
import com.yoyiyi.soleil.adapter.home.RegionEntranceAdapter;
import com.yoyiyi.soleil.widget.section.StatelessSection;
import com.yoyiyi.soleil.widget.section.ViewHolder;

import java.util.Arrays;
import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/26 21:59
 * 描述:
 */
public class RegionEntranceSection extends StatelessSection {

    private List<RegionEnter> mList;
    private List<RegionTagType> mRegionTypeList;

    public RegionEntranceSection(List<RegionTagType> regionTypeList) {
        super(R.layout.layout_item_home_region_entrance, R.layout.layout_empty);
        this.mRegionTypeList = regionTypeList;
        init();
    }

    private void init() {
        mList = Arrays.asList(
                new RegionEnter("直播", R.mipmap.ic_category_live),
                new RegionEnter("番剧", R.mipmap.ic_category_t13),
                new RegionEnter("动画", R.mipmap.ic_category_t1),
                new RegionEnter("国创", R.mipmap.ic_category_t167),
                new RegionEnter("音乐", R.mipmap.ic_category_t3),
                new RegionEnter("舞蹈", R.mipmap.ic_category_t129),
                new RegionEnter("游戏", R.mipmap.ic_category_t4),
                new RegionEnter("科技", R.mipmap.ic_category_t36),
                new RegionEnter("生活", R.mipmap.ic_category_t160),
                new RegionEnter("鬼畜", R.mipmap.ic_category_t11),
                new RegionEnter("时尚", R.mipmap.ic_category_t155),
                new RegionEnter("广告", R.mipmap.ic_category_t165),
                new RegionEnter("娱乐", R.mipmap.ic_category_t5),
                new RegionEnter("电影", R.mipmap.ic_category_t23),
                new RegionEnter("电视剧", R.mipmap.ic_category_t11),
                new RegionEnter("游戏中心", R.mipmap.ic_category_game_center));
    }

    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        RecyclerView recyclerView = holder.getView(R.id.recycler);
        recyclerView.setHasFixedSize(false);
        recyclerView.setNestedScrollingEnabled(false);
        GridLayoutManager layoutManager = new GridLayoutManager(mContext, 4);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RegionEntranceAdapter(mList,mRegionTypeList));
    }
}
