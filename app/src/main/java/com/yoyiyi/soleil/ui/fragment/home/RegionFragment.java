package com.yoyiyi.soleil.ui.fragment.home;

import android.support.v7.widget.GridLayoutManager;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseRefreshFragment;
import com.yoyiyi.soleil.bean.region.Region;
import com.yoyiyi.soleil.mvp.contract.home.RegionContract;
import com.yoyiyi.soleil.mvp.presenter.home.RegionPresenter;
import com.yoyiyi.soleil.ui.widget.section.SectionedRVAdapter;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 14:23
 * 描述:分区
 */

public class RegionFragment extends BaseRefreshFragment<RegionPresenter, Region> implements RegionContract.View {
    private SectionedRVAdapter mSectionedAdapter;

    public static RegionFragment newInstance() {
        return new RegionFragment();
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
    protected void lazyLoadData() {
        //懒加载数据
        mPresenter.getRegionData();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_region;
    }


    @Override
    public void showRegion(List<Region> regions) {

    }

}
