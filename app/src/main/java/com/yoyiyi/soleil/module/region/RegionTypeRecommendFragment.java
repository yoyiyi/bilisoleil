package com.yoyiyi.soleil.module.region;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.region.sectiton.RegionRecommendBannerSection;
import com.yoyiyi.soleil.adapter.region.sectiton.RegionRecommendDynamicSection;
import com.yoyiyi.soleil.adapter.region.sectiton.RegionRecommendEntranceSection;
import com.yoyiyi.soleil.adapter.region.sectiton.RegionRecommendNewSection;
import com.yoyiyi.soleil.adapter.region.sectiton.RegionRecommendRecommendSection;
import com.yoyiyi.soleil.base.BaseRefreshFragment;
import com.yoyiyi.soleil.bean.region.RegionRecommend;
import com.yoyiyi.soleil.constant.Constants;
import com.yoyiyi.soleil.mvp.contract.region.RegionTypeRecommendContract;
import com.yoyiyi.soleil.mvp.presenter.region.RegionTypeRecommendPresenter;
import com.yoyiyi.soleil.widget.section.SectionedRVAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/30 18:35
 * 描述:分区推荐界面
 */
public class RegionTypeRecommendFragment extends BaseRefreshFragment<RegionTypeRecommendPresenter, RegionRecommend.NewBean>
        implements RegionTypeRecommendContract.View {

    private int mTid;
    private List<RegionRecommend.BannerBean.TopBean> mTopBeanList = new ArrayList<>();
    private List<RegionRecommend.DynamicBean> mDynamicBeanList = new ArrayList<>();
    private List<RegionRecommend.RecommendBean> mRecommendBeanList = new ArrayList<>();

    private SectionedRVAdapter mSectionedAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_region_type_recommend;
    }

    public static RegionTypeRecommendFragment newInstance(int tid) {
        RegionTypeRecommendFragment fragment = new RegionTypeRecommendFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.EXTRA_TID, tid);
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
    protected void initRecyclerView() {
        mSectionedAdapter = new SectionedRVAdapter();
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (mSectionedAdapter.getSectionItemViewType(position)) {
                    case SectionedRVAdapter.VIEW_TYPE_HEADER:
                        return 2;//2格
                    case SectionedRVAdapter.VIEW_TYPE_FOOTER:
                        return 2;//2格
                    default:
                        return 1;
                }
            }
        });
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(mSectionedAdapter);
    }

    @Override
    protected void clear() {
        mRecommendBeanList.clear();
        mDynamicBeanList.clear();
        mTopBeanList.clear();
        mSectionedAdapter.removeAllSections();
    }

    @Override
    protected void lazyLoadData() {
        mPresenter.getRegionRecommendData(mTid);
    }

    @Override
    public void showRegionRecommend(RegionRecommend regionRecommend) {
        mList.addAll(regionRecommend.newX);
        mRecommendBeanList.addAll(regionRecommend.recommend);
        mTopBeanList.addAll(regionRecommend.banner.top);
        mDynamicBeanList.addAll(regionRecommend.dynamic);
        finishTask();
    }


    @Override
    protected void finishTask() {
        mSectionedAdapter.addSection(new RegionRecommendBannerSection(mTopBeanList));
        mSectionedAdapter.addSection(new RegionRecommendEntranceSection(mTid));
        mSectionedAdapter.addSection(new RegionRecommendRecommendSection(mRecommendBeanList));
        mSectionedAdapter.addSection(new RegionRecommendNewSection(mList));
        mSectionedAdapter.addSection(new RegionRecommendDynamicSection(mDynamicBeanList));
        mSectionedAdapter.notifyDataSetChanged();
    }

}
