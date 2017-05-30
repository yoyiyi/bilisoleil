package com.yoyiyi.soleil.base;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/15 11:13
 * 描述:基础刷新的Fragment
 */

public abstract class BaseRefreshFragment<T extends BaseContract.BasePresenter, K> extends BaseFragment<T> implements SwipeRefreshLayout.OnRefreshListener {
    protected RecyclerView mRecycler;
    protected SwipeRefreshLayout mRefresh;
    protected boolean mIsRefreshing = false;
    protected List<K> mList = new ArrayList<>();

    @Override
    protected void initRefreshLayout() {
        if (mRefresh != null) {
            mRefresh.setColorSchemeResources(R.color.colorPrimary);
            mRecycler.post(() -> {
                mRefresh.setRefreshing(true);
                lazyLoadData();
            });
            mRefresh.setOnRefreshListener(this);
        }

    }

    @Override
    public void onRefresh() {
        clearData();
        lazyLoadData();
    }


    @Override
    protected void clearData() {
        mIsRefreshing = true;

    }

    @Override
    public void finishCreateView(Bundle state) {
        mRefresh = ButterKnife.findById(mRootView, R.id.refresh);
        mRecycler = ButterKnife.findById(mRootView, R.id.recycler);
        isPrepared = true;
        lazyLoad();
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible) return;
        initRefreshLayout();
        initRecyclerView();
        if (mRefresh == null) lazyLoadData();
        isPrepared = false;
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
    }

    protected void clear() {

    }


    @Override
    public void initWidget() {

    }
}
