package com.yoyiyi.soleil.module.bangumi;

import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;

import com.annimon.stream.Stream;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.bangumi.BangumiScheduleSection;
import com.yoyiyi.soleil.base.BaseRefreshActivity;
import com.yoyiyi.soleil.bean.bangumi.BangumiSchedule;
import com.yoyiyi.soleil.mvp.contract.bangumi.BangumiScheduleContract;
import com.yoyiyi.soleil.mvp.presenter.bangumi.BangumiSchedulePresenter;
import com.yoyiyi.soleil.utils.TimeUtils;
import com.yoyiyi.soleil.widget.section.HeadOrFooterSection;
import com.yoyiyi.soleil.widget.section.SectionedRVAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/8 16:35
 * 描述:番剧时间表
 */

public class BangumiScheduleActivity extends BaseRefreshActivity<BangumiSchedulePresenter, BangumiSchedule>
        implements BangumiScheduleContract.View {

    private SectionedRVAdapter mSectionedAdapter;
    private List<BangumiSchedule> mMonList = new ArrayList<>();
    private List<BangumiSchedule> mTuesList = new ArrayList<>();
    private List<BangumiSchedule> mWedList = new ArrayList<>();
    private List<BangumiSchedule> mThurList = new ArrayList<>();
    private List<BangumiSchedule> mFriList = new ArrayList<>();
    private List<BangumiSchedule> mSatList = new ArrayList<>();
    private List<BangumiSchedule> mSunList = new ArrayList<>();

    private enum Week {
        MON("周一"), TUES("周二"), WEB("周三"), THUR("周四"), FRI("周五"), SAT("周六"), SUN("周日");
        private String week;

        Week(String week) {
            this.week = week;
        }

        public String getWeek() {
            return week;
        }
    }

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
        GridLayoutManager mLayoutManager = new GridLayoutManager(mContext, 3);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (mSectionedAdapter.getSectionItemViewType(position)) {
                    case SectionedRVAdapter.VIEW_TYPE_HEADER:
                        return 3;//2格
                    default:
                        return 1;
                }
            }
        });
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(mSectionedAdapter);
    }

    @Override
    public void showBangumiSchedule(List<BangumiSchedule> bangumiScheduleList) {
        mList.addAll(bangumiScheduleList);
        finishTask();
    }

    @Override
    protected void finishTask() {
        Stream.of(mList).forEach(bangumiSchedule -> group(bangumiSchedule));
        mSectionedAdapter.addSection(new HeadOrFooterSection(R.layout.layout_item_bangumi_schedule_header));
        mSectionedAdapter.addSection(
                new BangumiScheduleSection(Week.SUN.getWeek(), mSunList, TimeUtils.formatDate(mSunList.get(0).pub_date)));
        mSectionedAdapter.addSection(
                new BangumiScheduleSection(Week.MON.getWeek(), mMonList, TimeUtils.formatDate(mMonList.get(0).pub_date)));
        mSectionedAdapter.addSection(
                new BangumiScheduleSection(Week.TUES.getWeek(), mTuesList, TimeUtils.formatDate(mTuesList.get(0).pub_date)));
        mSectionedAdapter.addSection(
                new BangumiScheduleSection(Week.WEB.getWeek(), mWedList, TimeUtils.formatDate(mWedList.get(0).pub_date)));
        mSectionedAdapter.addSection(
                new BangumiScheduleSection(Week.THUR.getWeek(), mTuesList, TimeUtils.formatDate(mTuesList.get(0).pub_date)));
        mSectionedAdapter.addSection(
                new BangumiScheduleSection(Week.FRI.getWeek(), mFriList, TimeUtils.formatDate(mFriList.get(0).pub_date)));
        mSectionedAdapter.addSection(
                new BangumiScheduleSection(Week.SAT.getWeek(), mSatList, TimeUtils.formatDate(mSatList.get(0).pub_date)));
        mSectionedAdapter.addSection(new HeadOrFooterSection(R.layout.layout_item_bangumi_schedule_footer));
        mSectionedAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        mToolbar.setTitle("时间表");
    }

    private void group(BangumiSchedule schedule) {
        String week = TimeUtils.getWeek(schedule.pub_date);
        if (TextUtils.equals(Week.MON.getWeek(), week)) {
            mMonList.add(schedule);
        }
        if (TextUtils.equals(Week.TUES.getWeek(), week)) {
            mTuesList.add(schedule);
        }
        if (TextUtils.equals(Week.WEB.getWeek(), week)) {
            mWedList.add(schedule);
        }
        if (TextUtils.equals(Week.FRI.getWeek(), week)) {
            mFriList.add(schedule);
        }
        if (TextUtils.equals(Week.THUR.getWeek(), week)) {
            mThurList.add(schedule);
        }
        if (TextUtils.equals(Week.SAT.getWeek(), week)) {
            mSatList.add(schedule);
        }
        if (TextUtils.equals(Week.SUN.getWeek(), week)) {
            mSunList.add(schedule);
        }
    }
}
