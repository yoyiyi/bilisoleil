package com.yoyiyi.soleil.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.ToastUtils;
import com.yoyiyi.soleil.widget.ProgressWheel;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/5 22:43
 * 描述:基础刷新Activity
 */
public abstract class BaseRefreshActivity<T extends BaseContract.BasePresenter, K> extends BaseActivity<T> implements SwipeRefreshLayout.OnRefreshListener {
    protected RecyclerView mRecycler;
    protected SwipeRefreshLayout mRefresh;
    protected boolean mIsRefreshing = false;
    protected List<K> mList = new ArrayList<>();
    private ProgressWheel mLoading;

    protected void initRefreshLayout() {
        if (mRefresh != null) {
            mRefresh.setColorSchemeResources(R.color.colorPrimary);
            mRecycler.post(() -> {
                mRefresh.setRefreshing(true);
                loadData();
            });
            mRefresh.setOnRefreshListener(this);
        }
    }


    @Override
    protected void initWidget() {
        mRefresh = ButterKnife.findById(this, R.id.refresh);
        mRecycler = ButterKnife.findById(this, R.id.recycler);
        //加载框
        mLoading = ButterKnife.findById(this, R.id.pw_loading);
        initRefreshLayout();
        initRecyclerView();
    }

    @Override
    public void onRefresh() {
        clearData();
        loadData();
    }

    protected void clearData() {
        mIsRefreshing = true;
    }

    @Override
    public void complete() {
        super.complete();
        AppUtils.runOnUIDelayed(() -> {
            if (mRefresh != null)
                mRefresh.setRefreshing(false);
        }, 650);
        if (mIsRefreshing) {
            if (mList != null) mList.clear();
            clear();
            ToastUtils.showSingleLongToast("刷新成功");
        }
        mIsRefreshing = false;

        if (mLoading != null) {
            gone(mLoading);
        }
    }

    protected void clear() {

    }

    @Override
    protected void initDatas() {
        if (mRefresh == null) {//
            if (mLoading != null) {
                visible(mLoading);
                AppUtils.runOnUIDelayed(this::loadData, 650);
            } else {
                super.initDatas();
            }
        }
    }
}
