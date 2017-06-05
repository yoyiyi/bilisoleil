package com.yoyiyi.soleil.module.region;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.region.sectiton.RegionTypeNewSection;
import com.yoyiyi.soleil.adapter.region.sectiton.RegionTypeRecommendSection;
import com.yoyiyi.soleil.base.BaseRefreshFragment;
import com.yoyiyi.soleil.bean.region.RegionType;
import com.yoyiyi.soleil.constant.Constants;
import com.yoyiyi.soleil.mvp.contract.region.RegionTypeContract;
import com.yoyiyi.soleil.mvp.presenter.region.RegionTypePresenter;
import com.yoyiyi.soleil.widget.section.SectionedRVAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/30 18:35
 * 描述:分区Tag
 */
public class RegionTypeFragment extends BaseRefreshFragment<RegionTypePresenter, RegionType.RecommendBean> implements
        RegionTypeContract.View {
    private int mTid;
    private List<RegionType.NewBean> mNewBeanList = new ArrayList<>();
    private SectionedRVAdapter mSectionedAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_region_type;
    }

    public static RegionTypeFragment newInstance(int tid) {
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.EXTRA_TID, tid);
        RegionTypeFragment fragment = new RegionTypeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void initVariables() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            mTid = bundle.getInt(Constants.EXTRA_TID);
        }
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void lazyLoadData() {
        mPresenter.getRegionTypeData(mTid);
    }

    @Override
    protected void clear() {
        mNewBeanList.clear();
        mSectionedAdapter.removeAllSections();
    }

    @Override
    protected void initRecyclerView() {
        mSectionedAdapter = new SectionedRVAdapter();
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,
                false);
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(mSectionedAdapter);
    }

    @Override
    public void showRegionType(RegionType regionType) {
        mList.addAll(regionType.recommend);
        mNewBeanList.addAll(regionType.newX);
        finishTask();
    }

    @Override
    protected void finishTask() {
        mSectionedAdapter.addSection(new RegionTypeRecommendSection(mList));
        mSectionedAdapter.addSection(new RegionTypeNewSection(mNewBeanList));
        mSectionedAdapter.notifyDataSetChanged();
    }
}
