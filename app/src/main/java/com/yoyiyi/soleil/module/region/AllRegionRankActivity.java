package com.yoyiyi.soleil.module.region;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.constant.Constants;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/30 18:11
 * 描述:全区排行界面
 */
public class AllRegionRankActivity extends BaseRegionActivity {

    private String mTitle;
    private String[] mTitlesArr = new String[]{
            "番剧", "动画", "音乐", "舞蹈", "游戏",
            "科技", "生活", "鬼畜", "时尚", "娱乐", "电影", "电视剧"
    };

    private String[] mTypesArr = new String[]{
            "all-03-13.json", "all-03-1.json", "all-03-3.json",
            "all-03-129.json", "all-03-4.json", "all-03-36.json",
            "all-03-160.json", "all-03-155.json", "all-03-5.json",
            "all-03-119.json", "all-03-23.json", "all-03-11.json"
    };


    @Override
    protected int getLayoutId() {
        return R.layout.activity_region_type;
    }


    public static void startActivity(Context context, String title) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(context, AllRegionRankActivity.class);
        bundle.putString(Constants.EXTRA_TITLE, title);
        intent.putExtra(Constants.EXTRA_BUNDLE, bundle);
        context.startActivity(intent);
    }

    @Override
    protected void initVariables() {
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getBundleExtra(Constants.EXTRA_BUNDLE);
            mTitle = bundle.getString(Constants.EXTRA_TITLE);
        }
    }

    @Override
    protected void initTitle() {
        for (int i = 0; i < mTitlesArr.length; i++) {
            mTitles.add(mTitlesArr[i]);
            mFragments.add(AllRegionRankFragment.newInstance(mTypesArr[i]));
        }
    }

    @Override
    protected void initViewPager() {
        super.initViewPager();
        switch (mTitle) {
            case "番剧":
                mViewPager.setCurrentItem(0);
                break;
            case "动画":
                mViewPager.setCurrentItem(1);
                break;
            case "音乐":
                mViewPager.setCurrentItem(2);
                break;
            case "舞蹈":
                mViewPager.setCurrentItem(3);
                break;
            case "游戏":
                mViewPager.setCurrentItem(4);
                break;
            case "科技":
                mViewPager.setCurrentItem(5);
                break;
            case "生活":
                mViewPager.setCurrentItem(6);
                break;
            case "鬼畜":
                mViewPager.setCurrentItem(7);
                break;
            case "时尚":
                mViewPager.setCurrentItem(8);
                break;
            case "电影":
                mViewPager.setCurrentItem(9);
                break;
            case "电视剧":
                mViewPager.setCurrentItem(10);
                break;
        }
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        finishTask();
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        setTitle("全区排行榜");
    }


}
