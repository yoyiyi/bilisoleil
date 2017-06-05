package com.yoyiyi.soleil.module.discover;

import android.support.v7.widget.LinearLayoutManager;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.discover.ActivityCenterAdapter;
import com.yoyiyi.soleil.base.BaseRefreshActivity;
import com.yoyiyi.soleil.bean.discover.ActivityCenter;
import com.yoyiyi.soleil.mvp.contract.discover.ActivityCenterContract;
import com.yoyiyi.soleil.mvp.presenter.discover.ActivityCenterPresenter;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/5 22:28
 * 描述:活动中心
 */
public class ActivityCenterActivity extends BaseRefreshActivity<ActivityCenterPresenter, ActivityCenter.ListBean> implements ActivityCenterContract.View {

    private ActivityCenterAdapter mAdapter;
    private int mPageSize;
    private int mPage;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_topic_center;
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        mToolbar.setTitle("话题中心");
    }

    @Override
    protected void loadData() {
        mPresenter.getActivityCenterData(mPage, mPageSize);
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initRecyclerView() {
        mAdapter = new ActivityCenterAdapter(mList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(mAdapter);
    }


    @Override
    protected void finishTask() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showActivityCenter(List<ActivityCenter.ListBean> listBeanList) {
        mList.addAll(listBeanList);
        finishTask();
    }
}
