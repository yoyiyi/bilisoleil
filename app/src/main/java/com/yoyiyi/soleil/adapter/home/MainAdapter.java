package com.yoyiyi.soleil.adapter.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.module.home.ChaseBangumiFragment;
import com.yoyiyi.soleil.module.home.DiscoverFragment;
import com.yoyiyi.soleil.module.home.DynamicFragment;
import com.yoyiyi.soleil.module.home.LiveFragment;
import com.yoyiyi.soleil.module.home.RecommendFragment;
import com.yoyiyi.soleil.module.home.RegionFragment;
import com.yoyiyi.soleil.utils.AppUtils;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 18:25
 * 描述:主页Tag
 */

public class MainAdapter extends FragmentPagerAdapter {
    private String[] mTitle;
    private Fragment[] mFragment;

    public MainAdapter(FragmentManager fm) {
        super(fm);
        init();
    }


    private void init() {
        mTitle = AppUtils.getStringArray(R.array.main_title);
        mFragment = new Fragment[mTitle.length];
    }

    @Override
    public Fragment getItem(int position) {
        if (mFragment[position] == null) {
            switch (position) {
                case 0:
                    //直播
                    mFragment[position] = LiveFragment.newInstance();
                    break;
                case 1:
                    //推荐
                    mFragment[position] = RecommendFragment.newInstance();
                    break;
                case 2:
                    //追番
                    mFragment[position] = ChaseBangumiFragment.newInstance();
                    break;
                case 3:
                    //分区
                    mFragment[position] = RegionFragment.newInstance();
                    break;
                case 4:
                    //动态
                    mFragment[position] = DynamicFragment.newInstance();
                    break;
                case 5:
                    //发现
                    mFragment[position] = DiscoverFragment.newInstance();
                    break;
                default:
                    break;
            }
        }
        return mFragment[position];
    }

    @Override
    public int getCount() {
        return mTitle.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }
}
