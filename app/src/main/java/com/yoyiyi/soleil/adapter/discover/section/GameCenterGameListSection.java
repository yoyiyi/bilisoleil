package com.yoyiyi.soleil.adapter.discover.section;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.discover.GameCenter;
import com.yoyiyi.soleil.widget.section.StatelessSection;
import com.yoyiyi.soleil.widget.section.ViewHolder;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/30 21:44
 * 描述:精品推荐游戏
 */
public class GameCenterGameListSection extends StatelessSection<GameCenter.GameListBean> {
    public GameCenterGameListSection(List<GameCenter.GameListBean> data) {
        super(R.layout.layout_item_game_center_head, R.layout.layout_item_game_center_body, data);
    }


    @Override
    public void convert(ViewHolder holder, GameCenter.GameListBean gameListBean, int position) {

    }

    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        holder.setText(R.id.tv_title, "精品推荐游戏");
    }
}
