package com.yoyiyi.soleil.module.home;


import android.content.Intent;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.flyco.tablayout.SlidingTabLayout;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.yoyiyi.soleil.BiliSoleilApplication;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.home.MainAdapter;
import com.yoyiyi.soleil.base.BaseActivity;
import com.yoyiyi.soleil.module.discover.GameCenterActivity;
import com.yoyiyi.soleil.module.entrance.VipActivity;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.ToastUtils;
import com.yoyiyi.soleil.widget.CircleImageView;
import com.yoyiyi.soleil.widget.NoScrollViewPager;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

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
        mNavView.setNavigationItemSelectedListener(this);
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

    /**
     * 侧滑面板监听事件
     *
     * @param item
     * @return
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        AppUtils.runOnUIDelayed(() -> {
            int id = item.getItemId();
            switch (id) {
                case R.id.item_vip:
                    startActivity(new Intent(MainActivity.this, VipActivity.class));
                    break;
            }
        }, 230);
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_game:
                startActivity(new Intent(mContext, GameCenterActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * DrawerLayout侧滑菜单开关
     */
    public void toggleDrawer() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }

    /**
     * 监听back键处理DrawerLayout和SearchView
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mDrawerLayout.isDrawerOpen(mDrawerLayout.getChildAt(1))) {
                mDrawerLayout.closeDrawers();
            } else {
                exitApp();
            }
        }
        return true;
    }

    @OnClick(R.id.ll_navigation)
    public void onClick(View view) {
        toggleDrawer();
    }
}
