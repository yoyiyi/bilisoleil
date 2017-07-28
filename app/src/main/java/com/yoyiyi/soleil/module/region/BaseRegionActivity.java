package com.yoyiyi.soleil.module.region;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseActivity;
import com.yoyiyi.soleil.base.BaseContract;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/30 12:30
 * 描述:基础分区
 */
public abstract class BaseRegionActivity<T extends BaseContract.BasePresenter, K> extends BaseActivity<T> {
    protected TextView mTvTitle;
    protected ImageView mIvBack;
    protected List<K> mList = new ArrayList<>();
    protected List<String> mTitles = new ArrayList<>();
    protected List<Fragment> mFragments = new ArrayList<>();
    protected SlidingTabLayout mSlidingTabLayout;
    public ViewPager mViewPager;

    @SuppressLint("CheckResult")
    @Override
    protected void initToolbar() {
        mTvTitle = ButterKnife.findById(this, R.id.tv_title);
        mIvBack = ButterKnife.findById(this, R.id.iv_back);
        if (mIvBack != null)
            mIvBack.setOnClickListener(view -> {
                finish();
            });
    }

    protected void setTitle(String title) {
        if (mTvTitle != null) {
            mTvTitle.setText(title);
        }
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        initSlidingTabLayout();
    }

    protected void initSlidingTabLayout() {
        mSlidingTabLayout = ButterKnife.findById(this, R.id.sliding_tabs);
        mViewPager = ButterKnife.findById(this, R.id.view_pager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_region, menu);
        return true;
    }

    protected void initFragment() {
    }

    protected void initTitle() {
    }

    @Override
    protected void finishTask() {
        initTitle();
        initFragment();
        initViewPager();
        initEvent();
    }

    protected void initViewPager(){
        mViewPager.setOffscreenPageLimit(mTitles.size());
        mViewPager.setAdapter(new BaseRegionTypeAdapte(getSupportFragmentManager(), mTitles, mFragments));
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    /**
     * 初始化事件
     */
    protected void initEvent() {

    }

    protected void setCurrentItem(int pos){
        mViewPager.setCurrentItem(pos);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {

        }

        return super.onOptionsItemSelected(item);
    }

    protected static class BaseRegionTypeAdapte extends FragmentStatePagerAdapter {
        private List<String> mTitles;
        private List<Fragment> mFragments;

        public BaseRegionTypeAdapte(FragmentManager fm, List<String> titels, List<Fragment> fragments) {
            super(fm);
            this.mTitles = titels;
            this.mFragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mTitles.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }
    }

}
