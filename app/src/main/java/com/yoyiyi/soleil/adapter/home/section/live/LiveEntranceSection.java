package com.yoyiyi.soleil.adapter.home.section.live;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.home.LiveEntranceAdapter;
import com.yoyiyi.soleil.bean.live.support.LiveEnter;
import com.yoyiyi.soleil.widget.section.StatelessSection;
import com.yoyiyi.soleil.widget.section.ViewHolder;

import java.util.Arrays;
import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/15 16:28
 * 描述:首页直播入口Section
 */

public class LiveEntranceSection extends StatelessSection {
    private List<LiveEnter> mList;

    public LiveEntranceSection() {
        super(R.layout.layout_item_home_live_entrance, R.layout.layout_empty);
        init();
    }

    private void init() {
        mList = Arrays.asList(
                new LiveEnter("关注", R.drawable.live_home_follow_anchor),
                new LiveEnter("中心", R.drawable.live_home_live_center),
                new LiveEnter("小视频", R.drawable.live_home_clip_video),
                new LiveEnter("搜索", R.drawable.live_home_search_room),
                new LiveEnter("分类", R.drawable.live_home_all_category));
    }

    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        RecyclerView recyclerView = holder.getView(R.id.recycler);
        recyclerView.setHasFixedSize(false);
        recyclerView.setNestedScrollingEnabled(false);
        GridLayoutManager layoutManager = new GridLayoutManager(mContext, 5);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new LiveEntranceAdapter(mList));

    }


}
