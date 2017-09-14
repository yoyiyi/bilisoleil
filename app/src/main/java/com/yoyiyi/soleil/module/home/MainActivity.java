package com.yoyiyi.soleil.module.home;


import android.content.Intent;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseActivity;
import com.yoyiyi.soleil.constant.Constants;
import com.yoyiyi.soleil.event.Event;
import com.yoyiyi.soleil.module.app.BrowerActivity;
import com.yoyiyi.soleil.module.entrance.OfflineDownloadActivity;
import com.yoyiyi.soleil.module.entrance.VipActivity;
import com.yoyiyi.soleil.rx.RxBus;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.ToastUtils;
import com.yoyiyi.soleil.widget.statusbar.StatusBarUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 14:23
 * 描述:首页
 */

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    long exitTime = 0L;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    private int mCurrentPos = -1;
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initWidget() {
        disableNavigationViewScrollbars(mNavView);
        mNavView.setNavigationItemSelectedListener(this);
        switchFragmentIndex(0);//初始化位置
    }


    private void initFragment() {
        mFragments = Arrays.asList(HomeFragment.newInstance());

    }

    @Override
    protected void initStatusBar() {
        StatusBarUtil.setColorNoTranslucentForDrawerLayout(this, mDrawerLayout, AppUtils.getColor(R.color.colorPrimary));
    }

    @Override
    protected void initVariables() {
        initFragment();
        //监听事件
        RxBus.INSTANCE.toFlowable(Event.StartNavigationEvent.class)
                .compose(bindToLifecycle())
                .subscribe(event -> {
                    if (event.start) {
                        toggleDrawer();//打开
                    }
                });
    }

    private void switchFragmentIndex(int pos) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (mCurrentPos != -1)
            transaction.hide(mFragments.get(mCurrentPos));
        if (!mFragments.get(pos).isAdded()) {
            transaction.add(R.id.fl_content, mFragments.get(pos));
        }
        transaction.show(mFragments.get(pos)).commit();
        mCurrentPos = pos;

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
            // BiliSoleilApplication.getInstance().exitApp();
            Event.ExitEvent event = new Event.ExitEvent();
            event.exit = -1;
            RxBus.INSTANCE.post(event);
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
                case R.id.item_unicom:
                    BrowerActivity.startActivity(MainActivity.this, Constants.BLACK_BOARD_URL, "联通免流量服务", "");
                    break;
                case R.id.item_down:
                    startActivity(new Intent(MainActivity.this, OfflineDownloadActivity.class));
                    break;
            }
        }, 230);
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
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
     * 监听back键处理
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

}
