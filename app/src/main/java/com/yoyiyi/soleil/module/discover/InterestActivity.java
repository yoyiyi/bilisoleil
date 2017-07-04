package com.yoyiyi.soleil.module.discover;

import android.view.Menu;
import android.view.MenuItem;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.module.region.BaseRegionActivity;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/10 22:25
 * 描述:兴趣圈
 */
public class InterestActivity extends BaseRegionActivity {
    private String[] mTitlesArr = new String[]{"首页", "发现", "我的"};

    @Override
    protected int getLayoutId() {
        return R.layout.activity_interest;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        mViewPager.setOffscreenPageLimit(mTitlesArr.length + 1);
        mViewPager.setAdapter(new BaseRegionTypeAdapte(getSupportFragmentManager(), mTitles, mFragments));
        mSlidingTabLayout.setViewPager(mViewPager);
        mViewPager.setCurrentItem(1);

    }

    @Override
    protected void initVariables() {
        for (int i = 0; i < mTitlesArr.length; i++) {
            mTitles.add(mTitlesArr[i]);
            if (i == 1) {
                mFragments.add(new InterestFragment());
            } else if (i == 0) {
                mFragments.add(new HomeFragment());
            } else {
                mFragments.add(new MineFragment());
            }
        }
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        mToolbar.setTitle("兴趣圈");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_interest  , menu);
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
