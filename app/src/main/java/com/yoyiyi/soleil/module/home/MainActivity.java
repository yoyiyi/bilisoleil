package com.yoyiyi.soleil.module.home;


import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.widget.LinearLayout;

import com.flyco.tablayout.SlidingTabLayout;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.yoyiyi.soleil.BiliSoleilApplication;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseActivity;
import com.yoyiyi.soleil.adapter.home.MainAdapter;
import com.yoyiyi.soleil.widget.CircleImageView;
import com.yoyiyi.soleil.widget.NoScrollViewPager;
import com.yoyiyi.soleil.utils.ToastUtils;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar_user_avatar)
    CircleImageView mToolbarUserAvatar;
    @BindView(R.id.ll_navigation)
    LinearLayout mLlNavigation;
    @BindView(R.id.stl_tabs)
    SlidingTabLayout mStlTabs;
    @BindView(R.id.view_pager)
    NoScrollViewPager mViewPager;
    @BindView(R.id.search_view)
    MaterialSearchView mSearchView;
    @BindView(R.id.nav_view)
    NavigationView mNavView;

    long exitTime = 0L;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initWidget() {
        initViewPager();
        disableNavigationViewScrollbars(mNavView);
    }

    @Override
    protected void initVariables() {
        mBack = false;
    }

    @Override
    protected void initToolbar() {
        mToolbar.setTitle("");
    }

    private void initViewPager() {
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setAdapter(adapter);
        mStlTabs.setViewPager(mViewPager);
        mViewPager.setCurrentItem(0);
    }

    /**
     * 去掉滚动条
     *
     * @param navigationView navigationView
     */
    private void disableNavigationViewScrollbars(NavigationView navigationView) {
        if (navigationView != null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
            if (navigationMenuView != null) {
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }

    /**
     * 双击退出App
     */
    private void exitApp() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            ToastUtils.showToast("再按一次退出");
            exitTime = System.currentTimeMillis();
        } else {
            BiliSoleilApplication.getInstance().exitApp();
        }
    }

}
