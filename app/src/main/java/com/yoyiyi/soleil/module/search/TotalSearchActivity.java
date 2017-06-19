package com.yoyiyi.soleil.module.search;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.CardView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.flyco.tablayout.SlidingTabLayout;
import com.jakewharton.rxbinding2.view.RxView;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseActivity;
import com.yoyiyi.soleil.bean.search.SearchArchive;
import com.yoyiyi.soleil.constant.Constants;
import com.yoyiyi.soleil.mvp.contract.search.TotalSearchContract;
import com.yoyiyi.soleil.mvp.presenter.search.TotalSearchPresenter;
import com.yoyiyi.soleil.widget.NoScrollViewPager;
import com.yoyiyi.soleil.widget.statusbar.StatusBarUtil;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.StatusBarFontUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/29 10:44
 * 描述:搜索界面
 */
public class TotalSearchActivity extends BaseActivity<TotalSearchPresenter> implements TotalSearchContract.View {

    @BindView(R.id.iv_search_back)
    ImageView mIvSearchBack;
    @BindView(R.id.et_search)
    EditText mEtSearch;
    @BindView(R.id.iv_search_clear)
    ImageView mIvSearchClear;
    @BindView(R.id.iv_search)
    ImageView mIvSearch;
    @BindView(R.id.search_card_view)
    CardView mSearchCardView;
    @BindView(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTabs;
    @BindView(R.id.view_pager)
    NoScrollViewPager mViewPager;
    @BindView(R.id.iv_search_load)
    ImageView mIvSearchLoad;
    @BindView(R.id.rl_search_content)
    RelativeLayout mRlSearchContent;
    private String mKeyword = "";

    private List<SearchArchive.NavBean> mList = new ArrayList<>();
    private AnimationDrawable mAnimationDrawable;
    private List<String> mTitles = new ArrayList<>();
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_total_search;
    }

    public static void startActivity(Context context, String keyword) {
        Intent intent = new Intent(context, TotalSearchActivity.class);
        intent.putExtra(Constants.EXTRA_KEYWORD, keyword);
        context.startActivity(intent);
    }

    @Override
    protected void initStatusBar() {
        //设置状态栏颜色
        StatusBarUtil.setColorNoTranslucent(this, AppUtils.getColor(R.color.gray_light_30));
        //设置状态栏字体
        StatusBarFontUtil.from(this).setLightStatusBar(true).process();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initVariables() {
        Intent intent = getIntent();
        if (intent != null) {
            mKeyword = intent.getStringExtra(Constants.EXTRA_KEYWORD);
        }
    }

    @Override
    protected void initWidget() {
        initSearchView();
    }


    private void initSearchView() {
        mEtSearch.setText(mKeyword);
        mIvSearchBack.setOnClickListener(v -> onBackPressed());
        RxView.clicks(mIvSearch)
                .compose(bindToLifecycle())
                .throttleFirst(5, TimeUnit.SECONDS)
                .subscribe(o -> {
                    //TODO  发起搜索请求

                });
    }

    @Override
    public void showSearchNav(List<SearchArchive.NavBean> navBeans) {
        mList.clear();
        mList.addAll(navBeans);
        finishTask();
    }

    @Override
    public void showLoading() {
        mIvSearchLoad.setImageResource(R.drawable.anim_search_loading);
        mAnimationDrawable = (AnimationDrawable) mIvSearchLoad.getDrawable();
        visible(mIvSearchLoad);
        gone(mRlSearchContent);
        mAnimationDrawable.start();
    }


    @Override
    protected void finishTask() {
        mTitles.add("综合");
        mTitles.add(mList.get(0).name + formatTotal(mList.get(0).total));
        mTitles.add(mList.get(1).name + formatTotal(mList.get(1).total));
        mTitles.add(mList.get(2).name + formatTotal(mList.get(2).total));

        mFragments.add(ArchiveFragment.newsInstance());
        mFragments.add(SeasonFragment.newsInstance());
        mFragments.add(UpFragment.newsInstance());
        mFragments.add(MovieFragment.newsInstance());

        SearchNavAdapter navAdapter = new SearchNavAdapter(getSupportFragmentManager(), mTitles, mFragments);
        mViewPager.setAdapter(navAdapter);
        mViewPager.setOffscreenPageLimit(mTitles.size());
        mSlidingTabs.setViewPager(mViewPager);
        //设置指示条宽度
        mSlidingTabs.setCurrentTab(0);
        navAdapter.notifyDataSetChanged();
        mSlidingTabs.notifyDataSetChanged();
    }

    private String formatTotal(int total) {
        if (total == 0) return "";
        else if (total > 99) return "(99+)";
        else return "(" + total + ")";
    }

    @Override
    public void complete() {
        gone(mIvSearchLoad);
        visible(mRlSearchContent);
        if (mAnimationDrawable != null) {
            mAnimationDrawable.stop();
        }
    }

    @Override
    public void showError(String msg) {
        mIvSearchLoad.setImageResource(R.drawable.search_failed);
        visible(mIvSearchLoad);
        gone(mRlSearchContent);
        if (mAnimationDrawable != null) {
            mAnimationDrawable.stop();
        }
    }

    @Override
    protected void loadData() {
        mPresenter.getSearchNavData(mKeyword, 1, 20);
    }

    private static class SearchNavAdapter extends FragmentStatePagerAdapter {
        private List<String> titles;
        private List<Fragment> fragments;

        public SearchNavAdapter(FragmentManager fm, List<String> titles, List<Fragment> fragments) {
            super(fm);
            this.titles = titles;
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

    @Override
    public void onBackPressed() {
        if (mAnimationDrawable != null && mAnimationDrawable.isRunning()) {
            mAnimationDrawable.stop();
            mAnimationDrawable = null;
        }
        super.onBackPressed();
    }
}
