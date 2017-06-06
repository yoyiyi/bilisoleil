package com.yoyiyi.soleil.widget;

import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.yoyiyi.soleil.R;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/6 9:44
 * 描述:自定义加载更多布局
 */

public class CustomLoadMoreView extends LoadMoreView {
    @Override
    public int getLayoutId() {
        return R.layout.layout_load_more;
    }

    @Override
    protected int getLoadingViewId() {
        return R.id.ll_loading;
    }

    @Override
    protected int getLoadFailViewId() {
        return R.id.ll_load_fail;
    }

    @Override
    protected int getLoadEndViewId() {
        return R.id.ll_load_end;
    }
}
