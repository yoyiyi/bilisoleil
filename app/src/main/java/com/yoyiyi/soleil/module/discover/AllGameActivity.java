package com.yoyiyi.soleil.module.discover;

import android.support.v7.widget.LinearLayoutManager;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.discover.section.GameCenterGameListSection;
import com.yoyiyi.soleil.base.BaseRefreshActivity;
import com.yoyiyi.soleil.bean.discover.GameCenter;
import com.yoyiyi.soleil.mvp.contract.discover.GameCenterContract;
import com.yoyiyi.soleil.mvp.presenter.discover.GameCenterPresenter;
import com.yoyiyi.soleil.widget.section.SectionedRVAdapter;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/5 22:28
 * 描述:所有游戏
 */
public class AllGameActivity extends BaseRefreshActivity<GameCenterPresenter, GameCenter.GameListBean> implements GameCenterContract.View {
    private SectionedRVAdapter mSectionedAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_game_center;
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        mToolbar.setTitle("全部游戏");
    }

    @Override
    protected void loadData() {
        mPresenter.getGameCenterData();
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
        mList.addAll(gameCenter.game_list);
        finishTask();
    }

    @Override
    protected void finishTask() {
        mSectionedAdapter.addSection(new GameCenterGameListSection(false,mList));
        mSectionedAdapter.notifyDataSetChanged();
    }
}
