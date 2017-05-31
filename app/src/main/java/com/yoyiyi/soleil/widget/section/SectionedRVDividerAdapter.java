package com.yoyiyi.soleil.widget.section;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;

import com.yoyiyi.soleil.widget.divider.FlexibleDividerDecoration;

/**
 * A custom RecyclerView with Sections with custom Titles.
 * Sections are displayed in the same order they were added.
 * 修改 @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 *
 * @author Gustavo Pagani
 */
public class SectionedRVDividerAdapter extends SectionedRVAdapter implements FlexibleDividerDecoration.PaintProvider {
    @Override
    public Paint dividerPaint(int position, RecyclerView parent) {
        return null;
    }


}
