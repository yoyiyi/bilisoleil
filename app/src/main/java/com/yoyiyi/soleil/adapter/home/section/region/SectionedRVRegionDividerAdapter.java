package com.yoyiyi.soleil.adapter.home.section.region;

import android.support.v7.widget.RecyclerView;

import com.yoyiyi.soleil.widget.divider.FlexibleDividerDecoration;
import com.yoyiyi.soleil.widget.section.SectionedRVAdapter;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/31 23:36
 * 描述:
 */
public class SectionedRVRegionDividerAdapter extends SectionedRVAdapter implements FlexibleDividerDecoration.VisibilityProvider {



    @Override
    public boolean shouldHideDivider(int position, RecyclerView parent) {
        if (position < 2) {
            return true;
        } else {
            return false;
        }
    }
}
