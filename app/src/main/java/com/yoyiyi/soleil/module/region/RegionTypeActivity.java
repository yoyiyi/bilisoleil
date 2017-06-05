package com.yoyiyi.soleil.module.region;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.annimon.stream.Stream;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.region.RegionTagType;
import com.yoyiyi.soleil.constant.Constants;
import com.yoyiyi.soleil.mvp.contract.region.AllRegionRankPositionContract;
import com.yoyiyi.soleil.mvp.presenter.region.AllRegionRankPositionPresenter;

import javax.annotation.Nullable;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/30 18:11
 * 描述:分区type界面
 */
public class RegionTypeActivity extends BaseRegionActivity<AllRegionRankPositionPresenter, Nullable> implements AllRegionRankPositionContract.View {
    private RegionTagType mRegionType;
    public String mTitle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_region_type;
    }

    public static void startActivity(Context context, RegionTagType type) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(context, RegionTypeActivity.class);
        bundle.putParcelable(Constants.EXTRA_PARCELABLE, type);
        intent.putExtra(Constants.EXTRA_BUNDLE, bundle);
        context.startActivity(intent);
    }

    @Override
    protected void initVariables() {
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getBundleExtra(Constants.EXTRA_BUNDLE);
            mRegionType = bundle.getParcelable(Constants.EXTRA_PARCELABLE);
        }
        mTitle = mRegionType.name;
        mTitles.add("推荐");
        //推荐
        mFragments.add(RegionTypeRecommendFragment.newInstance(mRegionType.tid));
        Stream.of(mRegionType.children)
                .forEach(childrenBean -> {
                    mTitles.add(childrenBean.name);
                    //其他标签页面
                    mFragments.add(RegionTypeFragment.newInstance(childrenBean.tid));
                });

    }

    @Override
    protected void initWidget() {
        super.initWidget();
        mViewPager.setOffscreenPageLimit(mRegionType.children.size() + 1);
        mViewPager.setAdapter(new BaseRegionTypeAdapte(getSupportFragmentManager(), mTitles, mFragments));
        mSlidingTabLayout.setViewPager(mViewPager);
        mViewPager.setCurrentItem(0);
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        setTitle(mTitle);
    }

    @Override
    protected void loadData() {
        //设置推荐Fragment entrance 监听
        mPresenter.getEventPostion();
    }

    @Override
    public void showEventPostion(int postion) {
        //设置位置 viewpager
        mViewPager.setCurrentItem(postion + 1);
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }
}
