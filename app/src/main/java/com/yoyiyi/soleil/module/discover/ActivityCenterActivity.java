package com.yoyiyi.soleil.module.discover;

import android.support.v7.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.discover.ActivityCenterAdapter;
import com.yoyiyi.soleil.base.BaseRefreshActivity;
import com.yoyiyi.soleil.bean.discover.ActivityCenter;
import com.yoyiyi.soleil.mvp.contract.discover.ActivityCenterContract;
import com.yoyiyi.soleil.mvp.presenter.discover.ActivityCenterPresenter;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.widget.CustomLoadMoreView;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/5 22:28
 * 描述:活动中心
 */
public class ActivityCenterActivity extends BaseRefreshActivity<ActivityCenterPresenter, ActivityCenter.ListBean> implements ActivityCenterContract.View,
        BaseQuickAdapter.RequestLoadMoreListener {

    private ActivityCenterAdapter mAdapter;
    private int mPage = 1;
    private static final int PS = 20;
    private int mTotal = 0;
    private boolean mIsError = false;
    private boolean mIsLoadMore = false;

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
        mPresenter.getActivityCenterData(mPage, PS);
    }

    @Override
    protected void clearData() {
        super.clearData();
        mPage = 1;
        mIsLoadMore = false;
        mIsError = false;
        //刷新时候关闭上拉加载
        mAdapter.setEnableLoadMore(false);
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
        mAdapter.setLoadMoreView(new CustomLoadMoreView());
        //设置加载更多监听
        mAdapter.setOnLoadMoreListener(this, mRecycler);
    }


    @Override
    protected void finishTask() {
        mAdapter.setNewData(mList);
    }

    @Override
    public void showActivityCenter(List<ActivityCenter.ListBean> listBeanList, int total) {
        if (!mIsLoadMore) {
            mList.addAll(listBeanList);
            mTotal = total;//总数
            finishTask();
        } else {
            //加载更多
            mAdapter.addData(listBeanList);
            mAdapter.loadMoreComplete();//加载完成
        }
    }

    @Override
    public void onLoadMoreRequested() {
        AppUtils.runOnUIDelayed(() -> {
            //加载更多
            if (mAdapter.getItemCount() >= mTotal) {
                mAdapter.loadMoreEnd();//结束加载
            } else {
                if (!mIsError) {
                    mPage++;
                    loadData();
                } else {
                    mIsError = true;
                    mAdapter.loadMoreFail();//加载失败
                }
            }
        }, 650);


    }

    @Override
    public void showError(String msg) {
        super.showError(msg);
        mIsError = true;
    }

    @Override
    public void complete() {
        super.complete();
        //需要重新开启监听
        mAdapter.setEnableLoadMore(true);
    }

}
