package com.yoyiyi.soleil.adapter.discover.section;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.discover.GameCenterBookGiftAdapter;
import com.yoyiyi.soleil.bean.discover.GameCenter;
import com.yoyiyi.soleil.widget.section.StatelessSection;
import com.yoyiyi.soleil.widget.section.ViewHolder;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/30 21:44
 * 描述:新游预约
 */
public class GameCenterBookGiftSection extends StatelessSection {
    private List<GameCenter.BookGiftBean> mList;

    public GameCenterBookGiftSection(List<GameCenter.BookGiftBean> list) {
        super(R.layout.layout_item_game_center_head, R.layout.layout_item_game_center_book_lift, R.layout.layout_empty);
        this.mList = list;
    }

    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        holder.setText(R.id.tv_title, "新游预约");
    }

    @Override
    public void onBindFooterViewHolder(ViewHolder holder) {
        RecyclerView recyclerView = holder.getView(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1,
                StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new GameCenterBookGiftAdapter(mList));
    }

}
