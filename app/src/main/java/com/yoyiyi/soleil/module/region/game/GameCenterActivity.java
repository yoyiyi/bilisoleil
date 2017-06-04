package com.yoyiyi.soleil.module.region.game;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.home.section.region.game.GameCenterUserSection;
import com.yoyiyi.soleil.base.BaseActivity;
import com.yoyiyi.soleil.bean.game.GameCenter;
import com.yoyiyi.soleil.mvp.contract.region.game.GameCenterContract;
import com.yoyiyi.soleil.mvp.presenter.region.game.GameCenterPresenter;
import com.yoyiyi.soleil.widget.ProgressWheel;
import com.yoyiyi.soleil.widget.section.SectionedRVAdapter;

import butterknife.BindView;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/30 21:10
 * 描述:
 */
public class GameCenterActivity extends BaseActivity<GameCenterPresenter> implements GameCenterContract.View {
    @BindView(R.id.tv_error)
    TextView mTvError;
    @BindView(R.id.cl_error)
    ConstraintLayout mClError;
    @BindView(R.id.pw_loading)
    ProgressWheel mPwLoading;
    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    private SectionedRVAdapter mSectionedAdapter;
    private GameCenter mGameCenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_game_center;
    }


    @Override
    public void showError(String msg) {
        visible(mClError);
        mTvError.setText("加载失败了_(:3 」∠)_");
        gone(mRecycler);
    }


    @Override
    protected void initWidget() {
        super.initWidget();
        initRecyclerView();
    }

    @Override
    public void complete() {
        gone(mClError, mPwLoading);
        visible(mRecycler);
    }

    @Override
    protected void initRecyclerView() {
        mSectionedAdapter = new SectionedRVAdapter();
        GridLayoutManager mLayoutManager = new GridLayoutManager(mContext, 1);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (mSectionedAdapter.getSectionItemViewType(position)) {
                    default:
                        return 1;
                }
            }
        });
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(mSectionedAdapter);
    }

    @Override
    protected void loadData() {
        mPresenter.getGameCenterData();
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void showGameCenter(GameCenter gameCenter) {
        mGameCenter = gameCenter;
        finishTask();
    }

    @Override
    protected void finishTask() {
        mSectionedAdapter.addSection(new GameCenterUserSection());


        mSectionedAdapter.notifyDataSetChanged();
    }

}
