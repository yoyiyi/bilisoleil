package com.yoyiyi.soleil.module.recommend;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.recommend.AllStationRankAdapter;
import com.yoyiyi.soleil.base.BaseRefreshFragment;
import com.yoyiyi.soleil.bean.recommend.AllStationRank;
import com.yoyiyi.soleil.constant.Constants;
import com.yoyiyi.soleil.mvp.contract.recommend.AllStationRankContract;
import com.yoyiyi.soleil.mvp.presenter.recommend.AllStationRankPresenter;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/30 18:35
 * 描述:全站排行
 */
public class AllStationRankFragment extends BaseRefreshFragment<AllStationRankPresenter, AllStationRank.RankBean.ListBean> implements
        AllStationRankContract.View {

    private String mType;
    private AllStationRankAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_region_type;
    }

    public static AllStationRankFragment newInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.EXTRA_TYPE, type);
        AllStationRankFragment fragment = new AllStationRankFragment();
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
        mPresenter.getAllStationRankData(mType);
    }

    @Override
    protected void initRecyclerView() {
        mAdapter = new AllStationRankAdapter(mList);
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
    public void showAllStationRank(List<AllStationRank.RankBean.ListBean> regionRank) {
        mList.addAll(regionRank);
        finishTask();
    }
}
