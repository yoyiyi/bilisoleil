package com.yoyiyi.soleil.module.recommend;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.module.region.BaseRegionActivity;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/30 18:11
 * 描述:全站排行
 */
public class AllStationRankActivity extends BaseRegionActivity {

    private String[] mTitlesArr = new String[]{"原创", "全站", "番剧"};

    private String[] mTypesArr = new String[]{"origin-03.json", "all-03.json", "all-3-33.json"};

    @Override
    protected int getLayoutId() {
        return R.layout.activity_region_type;
    }


    @Override
    protected void initWidget() {
        super.initWidget();
        mViewPager.setOffscreenPageLimit(mTitlesArr.length + 1);
        mViewPager.setAdapter(new BaseRegionTypeAdapte(getSupportFragmentManager(), mTitles, mFragments));
        mSlidingTabLayout.setViewPager(mViewPager);
        mViewPager.setCurrentItem(0);

    }

    @Override
    protected void initVariables() {
        for (int i = 0; i < mTitlesArr.length; i++) {
            mTitles.add(mTitlesArr[i]);
            mFragments.add(AllStationRankFragment.newInstance(mTypesArr[i]));
        }
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        setTitle("排行榜");
    }


}
