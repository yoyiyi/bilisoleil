package com.yoyiyi.soleil.module.discover;

import android.support.v7.widget.LinearLayoutManager;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.discover.section.GameCenterUserSection;
import com.yoyiyi.soleil.base.BaseRefreshActivity;
import com.yoyiyi.soleil.bean.discover.GameCenter;
import com.yoyiyi.soleil.mvp.contract.discover.GameCenterContract;
import com.yoyiyi.soleil.mvp.presenter.discover.ActivityCenterPresenter;
import com.yoyiyi.soleil.widget.section.SectionedRVAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/5 22:28
 * 描述:游戏中心
 */
public class GameCenterActivity extends BaseRefreshActivity<ActivityCenterPresenter, GameCenter.GameListBean> implements GameCenterContract.View {
    private SectionedRVAdapter mSectionedAdapter;
    private List<GameCenter.BookGiftBean> mBookGiftBeanList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_topic_center;
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        mToolbar.setTitle("活动中心");
    }

    @Override
    protected void loadData() {

    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initRecyclerView() {
        mSectionedAdapter = new SectionedRVAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(mSectionedAdapter);


    }

    @Override
    public void showGameCenter(GameCenter gameCenter) {
        if (!gameCenter.game_list.isEmpty() && gameCenter.game_list.size() >= 20) {
            mList.addAll(gameCenter.game_list.subList(0, 20));
        } else {
            mList.addAll(gameCenter.game_list);
        }
        mBookGiftBeanList.addAll(gameCenter.book_gift);
        finishTask();
    }

    @Override
    protected void finishTask() {
        mSectionedAdapter.addSection(new GameCenterUserSection());

    }
}
