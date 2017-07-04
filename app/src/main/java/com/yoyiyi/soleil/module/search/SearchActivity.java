package com.yoyiyi.soleil.module.search;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.search.Search;
import com.yoyiyi.soleil.event.Event;
import com.yoyiyi.soleil.module.region.BaseRegionActivity;
import com.yoyiyi.soleil.mvp.contract.search.SearchContract;
import com.yoyiyi.soleil.mvp.presenter.search.SearchPresenter;
import com.yoyiyi.soleil.rx.RxBus;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.StatusBarFontUtil;
import com.yoyiyi.soleil.widget.statusbar.StatusBarUtil;

import javax.annotation.Nullable;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/18 13:55
 * 描述:搜索
 */

public class SearchActivity extends BaseRegionActivity<SearchPresenter, Nullable> implements SearchContract.View {

    private Search mSearch;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void showSearch(Search search) {
        mSearch = search;
        finishTask();
    }

    @Override
    protected void initStatusBar() {
        //设置状态栏颜色
        StatusBarUtil.setColorNoTranslucent(this, AppUtils.getColor(R.color.gray_light_30));
        //设置状态栏字体
        StatusBarFontUtil.from(this).setLightStatusBar(true).process();
    }

    @Override
    protected void initTitle() {
        mTitles.add("综合");
        mTitles.add(mSearch.data.nav.get(0).name + (
                mSearch.data.nav.get(0).total == 0 ? "" : "(" + (mSearch.data.nav.get(0).total > 99 ? "99+" : mSearch.data.nav.get(0).total) + ")"));
        mTitles.add(mSearch.data.nav.get(1).name + (
                mSearch.data.nav.get(1).total == 0 ? "" : "(" + (mSearch.data.nav.get(1).total > 99 ? "99+" : mSearch.data.nav.get(1).total) + ")"));
        mTitles.add(mSearch.data.nav.get(2).name + (
                mSearch.data.nav.get(2).total == 0 ? "" : "(" + (mSearch.data.nav.get(2).total > 99 ? "99+" : mSearch.data.nav.get(2).total) + ")"));

    }

    @Override
    protected void initFragment() {
        mFragments.add(ArchiveFragment.newsInstance());
        mFragments.add(SeasonFragment.newsInstance());
        mFragments.add(UpFragment.newsInstance());
        mFragments.add(MovieFragment.newsInstance());

    }

    @Override
    protected void initViewPager() {
        super.initViewPager();
        setCurrentItem(0);
    }

    @Override
    protected void loadData() {
        mPresenter.getSearchData();
    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }


    @Override
    protected void initEvent() {
        //发射数据 给首页
        Event.SearchArchiveEvent searchArchiveEvent = new Event.SearchArchiveEvent();
        searchArchiveEvent.itemBean = mSearch.data.items;
        searchArchiveEvent.movieCount = mSearch.data.nav.get(2).total;
        searchArchiveEvent.seasonCount = mSearch.data.nav.get(1).total;
        RxBus.INSTANCE.post(searchArchiveEvent);
    }

}
