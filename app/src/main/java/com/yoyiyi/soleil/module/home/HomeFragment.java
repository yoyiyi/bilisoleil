package com.yoyiyi.soleil.module.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.flyco.tablayout.SlidingTabLayout;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.home.MainAdapter;
import com.yoyiyi.soleil.base.BaseFragment;
import com.yoyiyi.soleil.event.Event;
import com.yoyiyi.soleil.module.discover.GameCenterActivity;
import com.yoyiyi.soleil.rx.RxBus;
import com.yoyiyi.soleil.widget.NoScrollViewPager;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/14 12:20
 * 描述:
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.stl_tabs)
    SlidingTabLayout mStlTabs;
    @BindView(R.id.view_pager)
    NoScrollViewPager mViewPager;
    @BindView(R.id.search_view)
    MaterialSearchView mSearchView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;


    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_home;
    }

    @Override
    public void initWidget() {
        initToolbar();
        initViewPager();
    }

    private void initToolbar() {
        mToolbar.setTitle("");
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        //换成下面这句就OK了
        mToolbar.inflateMenu(R.menu.menu_main);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
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

    private void initViewPager() {
        MainAdapter adapter = new MainAdapter(getChildFragmentManager());
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setAdapter(adapter);
        mStlTabs.setViewPager(mViewPager);
        mViewPager.setCurrentItem(0);
    }

    //点击打开侧滑栏
    @OnClick(R.id.ll_navigation)
    void onClick() {
        Event.StartNavigationEvent event = new Event.StartNavigationEvent();
        event.start = true;
        RxBus.INSTANCE.post(event);
    }


}
