package com.yoyiyi.soleil.base;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.NetworkUtils;
import com.yoyiyi.soleil.widget.CustomLoadMoreView;


/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/29 17:22
 * 描述:
 */

public abstract class BaseRVMoreActivity<T extends BaseContract.BasePresenter, K, H extends BaseQuickAdapter> extends BaseRefreshActivity<T, K> implements
        BaseQuickAdapter.RequestLoadMoreListener {
    protected H mAdapter;
    protected int mPage = 1;
    protected static final int PS = 20;
    protected int mTotal = 0;
    protected boolean mIsError = false;
    protected boolean mIsLoadMore = false;


    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        mAdapter.setLoadMoreView(new CustomLoadMoreView());


    }

    @Override
    public void onLoadMoreRequested() {
        if (NetworkUtils.isConnected(this)){
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
        }else {
            mIsError = true;
            mAdapter.loadMoreFail();//加载失败
        }
    }


    /**
     * 设置Adapter
     *
     * @param adapter
     */
    protected void setAdapter(H adapter) {
        mAdapter = adapter;
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
