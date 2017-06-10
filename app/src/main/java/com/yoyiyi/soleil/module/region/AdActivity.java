package com.yoyiyi.soleil.module.region;

import android.support.v7.widget.GridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.region.sectiton.RegionRecommendBannerSection;
import com.yoyiyi.soleil.adapter.region.sectiton.RegionRecommendDynamicSection;
import com.yoyiyi.soleil.adapter.region.sectiton.RegionRecommendNewSection;
import com.yoyiyi.soleil.adapter.region.sectiton.RegionRecommendRecommendSection;
import com.yoyiyi.soleil.base.BaseRefreshActivity;
import com.yoyiyi.soleil.bean.region.RegionRecommend;
import com.yoyiyi.soleil.mvp.contract.region.RegionTypeRecommendContract;
import com.yoyiyi.soleil.mvp.presenter.region.RegionTypeRecommendPresenter;
import com.yoyiyi.soleil.widget.section.SectionedRVAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/30 18:35
 * 描述:广告界面
 */
public class AdActivity extends BaseRefreshActivity<RegionTypeRecommendPresenter, RegionRecommend.NewBean>
        implements RegionTypeRecommendContract.View {

    private List<RegionRecommend.BannerBean.TopBean> mTopBeanList = new ArrayList<>();
    private List<RegionRecommend.DynamicBean> mDynamicBeanList = new ArrayList<>();
    private List<RegionRecommend.RecommendBean> mRecommendBeanList = new ArrayList<>();

    private SectionedRVAdapter mSectionedAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_ad;
    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initRecyclerView() {
        mSectionedAdapter = new SectionedRVAdapter();
        GridLayoutManager mLayoutManager = new GridLayoutManager(mContext, 2);
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
    protected void loadData() {
        mPresenter.getRegionRecommendData(165);

    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        mToolbar.setTitle("广告");
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
        mSectionedAdapter.addSection(new RegionRecommendRecommendSection(mRecommendBeanList));
        mSectionedAdapter.addSection(new RegionRecommendNewSection(mList));
        mSectionedAdapter.addSection(new RegionRecommendDynamicSection(mDynamicBeanList));
        mSectionedAdapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_region  , menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {

        }

        return super.onOptionsItemSelected(item);
    }
}
