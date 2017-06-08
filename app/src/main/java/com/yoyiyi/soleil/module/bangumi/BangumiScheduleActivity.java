package com.yoyiyi.soleil.module.bangumi;

import android.support.v7.widget.LinearLayoutManager;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseRefreshActivity;
import com.yoyiyi.soleil.bean.bangumi.BangumiSchedule;
import com.yoyiyi.soleil.mvp.contract.bangumi.BangumiScheduleContract;
import com.yoyiyi.soleil.mvp.presenter.bangumi.BangumiSchedulePresenter;
import com.yoyiyi.soleil.widget.section.HeadOrFooterSection;
import com.yoyiyi.soleil.widget.section.SectionedRVAdapter;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/8 16:35
 * 描述:番剧时间表
 */

public class BangumiScheduleActivity extends BaseRefreshActivity<BangumiSchedulePresenter, BangumiSchedule>
        implements BangumiScheduleContract.View {

    private SectionedRVAdapter mSectionedAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bangumi_schedule;
    }

    @Override
    protected void loadData() {
        mPresenter.getBangumiSchedule();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initRecyclerView() {
        mSectionedAdapter = new SectionedRVAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(mSectionedAdapter);
    }

    @Override
    public void showBangumiSchedule(List<BangumiSchedule> bangumiScheduleList) {
        mList.addAll(bangumiScheduleList);
        finishTask();
    }

    @Override
    protected void finishTask() {
        mSectionedAdapter.addSection(new HeadOrFooterSection(R.layout.layout_item_bangumi_schedule_header));
        mSectionedAdapter.addSection(new HeadOrFooterSection(R.layout.layout_item_bangumi_schedule_footer));
        mSectionedAdapter.notifyDataSetChanged();

    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        mToolbar.setTitle("时间表");
    }
}
