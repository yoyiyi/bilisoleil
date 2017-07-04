package com.yoyiyi.soleil.module.search;

import android.support.v7.widget.LinearLayoutManager;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.search.UpAdapter;
import com.yoyiyi.soleil.bean.search.Up;
import com.yoyiyi.soleil.mvp.contract.search.UpContract;
import com.yoyiyi.soleil.mvp.presenter.search.UpPresenter;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/29 11:46
 * 描述:up
 */
public class UpFragment extends BaseSearchFragment<UpPresenter, Up.DataBean.ItemsBean> implements UpContract.View {
    private UpAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search_up;
    }

    public static UpFragment newsInstance() {
        return new UpFragment();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void lazyLoadData() {
        mPresenter.getSearchUpData();
    }

    @Override
    protected void initRecyclerView() {
        mAdapter = new UpAdapter(mList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,
                false);
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void showSearchUp(Up up) {
        mList.addAll(up.data.items);
        finishTask();
    }

    @Override
    protected void finishTask() {
        mAdapter.notifyDataSetChanged();
    }
}
