package com.yoyiyi.soleil.ui.fragment.home;

import android.support.v7.widget.GridLayoutManager;

import com.annimon.stream.Stream;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseRefreshFragment;
import com.yoyiyi.soleil.bean.region.Region;
import com.yoyiyi.soleil.mvp.contract.home.RegionContract;
import com.yoyiyi.soleil.mvp.presenter.home.RegionPresenter;
import com.yoyiyi.soleil.ui.adapter.home.section.region.RegionActivityCenterSection;
import com.yoyiyi.soleil.ui.adapter.home.section.region.RegionEntranceSection;
import com.yoyiyi.soleil.ui.adapter.home.section.region.RegionSection;
import com.yoyiyi.soleil.ui.adapter.home.section.region.RegionTopicSection;
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
        mPresenter.getRegionData();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_region;
    }


    @Override
    public void showRegion(List<Region> regions) {
        mList.addAll(regions);
        finishTask();
    }

    @Override
    protected void finishTask() {
        mSectionedAdapter.addSection(new RegionEntranceSection());
        Stream.of(mList).forEach(region -> {
            String type = region.type;
            if ("topic".equals(type)) {//话题
                mSectionedAdapter.addSection(new RegionTopicSection(region.body.get(0)));
            } else if ("activity".equals(type)) {//活动中心
                mSectionedAdapter.addSection(new RegionActivityCenterSection(region.body));
            } else {//分区和番剧区
                mSectionedAdapter.addSection(new RegionSection(region.title, region.body));
            }
        });
        mSectionedAdapter.notifyDataSetChanged();
    }
}
