package com.yoyiyi.soleil.module.search;

import android.support.v7.widget.LinearLayoutManager;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.search.MulArchiveAdapter;
import com.yoyiyi.soleil.bean.search.MulSearchArchive;
import com.yoyiyi.soleil.mvp.contract.search.ArchiveContract;
import com.yoyiyi.soleil.mvp.presenter.search.ArchivePresenter;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/29 11:46
 * 描述:综合搜索
 */
public class ArchiveFragment extends BaseSearchFragment<ArchivePresenter, MulSearchArchive> implements ArchiveContract.View {


    private MulArchiveAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search_archive;
    }


    public static ArchiveFragment newsInstance() {
        ArchiveFragment fragment = new ArchiveFragment();
        return fragment;
    }


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }


    @Override
    protected void lazyLoadData() {
        mPresenter.getSearchArchiveData();
    }

    @Override
    public void showSearchArchive(List<MulSearchArchive> mulSearchArchiveList) {
        mList.addAll(mulSearchArchiveList);
        finishTask();
    }


    @Override
    protected void finishTask() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initRecyclerView() {
        mAdapter = new MulArchiveAdapter(mList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,
                false);
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(mAdapter);
    }


}
