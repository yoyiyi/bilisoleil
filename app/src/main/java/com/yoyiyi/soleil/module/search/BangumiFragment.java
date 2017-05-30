package com.yoyiyi.soleil.module.search;

import com.yoyiyi.soleil.R;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/29 11:46
 * 描述:
 */
public class BangumiFragment extends BaseSearchFragment{
    @Override
    public int getLayoutId() {
        return R.layout.fragment_search_archive;
    }
    public static BangumiFragment newsInstance() {

        return new BangumiFragment();
    }
}
