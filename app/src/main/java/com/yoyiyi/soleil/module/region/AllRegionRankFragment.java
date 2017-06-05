package com.yoyiyi.soleil.module.region;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.region.AllRegionRankAdapter;
import com.yoyiyi.soleil.base.BaseRefreshFragment;
import com.yoyiyi.soleil.bean.region.AllRegionRank;
import com.yoyiyi.soleil.constant.Constants;
import com.yoyiyi.soleil.mvp.contract.region.AllRegionRankContract;
import com.yoyiyi.soleil.mvp.presenter.region.AllRegionRankPresenter;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/30 18:35
 * 描述:分区Tag
 */
public class AllRegionRankFragment extends BaseRefreshFragment<AllRegionRankPresenter, AllRegionRank.RankBean.ListBean> implements
        AllRegionRankContract.View {

    private String mType;
    private AllRegionRankAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_region_type;
    }

    public static AllRegionRankFragment newInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.EXTRA_TYPE, type);
        AllRegionRankFragment fragment = new AllRegionRankFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void initVariables() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            mType = bundle.getString(Constants.EXTRA_TYPE);
        }
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void lazyLoadData() {
        mPresenter.getAllRegionRankData(mType);
    }

    @Override
    protected void initRecyclerView() {
        mAdapter = new AllRegionRankAdapter(mList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,
                false);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(mAdapter);
    }


    @Override
    protected void finishTask() {
        mAdapter.notifyDataSetChanged();
    }



    @Override
    public void showAllRegionRank(List<AllRegionRank.RankBean.ListBean> regionRank) {
        mList.addAll(regionRank);
        finishTask();
    }
}
