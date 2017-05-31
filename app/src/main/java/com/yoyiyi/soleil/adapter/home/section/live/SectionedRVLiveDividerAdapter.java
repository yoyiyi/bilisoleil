package com.yoyiyi.soleil.adapter.home.section.live;

import android.support.v7.widget.RecyclerView;

import com.yoyiyi.soleil.widget.divider.FlexibleDividerDecoration;
import com.yoyiyi.soleil.widget.section.SectionedRVAdapter;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/31 23:36
 * 描述:
 */
public class SectionedRVLiveDividerAdapter extends SectionedRVAdapter implements FlexibleDividerDecoration.VisibilityProvider {


    public SectionedRVLiveDividerAdapter() {

    }

    @Override
    public boolean shouldHideDivider(int position, RecyclerView parent) {
        if (position == 0 || position == 1 || position ==2) {
            return true;
        } else {
            return false;
        }
    }
}
