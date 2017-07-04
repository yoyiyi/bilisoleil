package com.yoyiyi.soleil.module.search;

import android.support.v7.widget.LinearLayoutManager;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.search.SeasonAdapter;
import com.yoyiyi.soleil.bean.search.Season;
import com.yoyiyi.soleil.mvp.contract.search.SeasonContract;
import com.yoyiyi.soleil.mvp.presenter.search.SeasonPresenter;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/29 11:46
 * 描述:番剧
 */
public class SeasonFragment extends BaseSearchFragment<SeasonPresenter, Season.DataBean.ItemsBean> implements SeasonContract.View {
    private SeasonAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search_season;
    }

    public static SeasonFragment newsInstance() {

        return new SeasonFragment();
    }

    @Override
    protected void lazyLoadData() {
        mPresenter.getSearchSeasonData();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void finishTask() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initRecyclerView() {
        mAdapter = new SeasonAdapter(mList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,
                false);
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void showSearchSeason(Season season) {
        mList.addAll(season.data.items);
        finishTask();
    }
}
