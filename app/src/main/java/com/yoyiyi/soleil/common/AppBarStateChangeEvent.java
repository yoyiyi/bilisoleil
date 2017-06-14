package com.yoyiyi.soleil.common;

import android.support.design.widget.AppBarLayout;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/14 18:19
 * 描述: 监听折叠状态
 */

public abstract  class AppBarStateChangeEvent implements AppBarLayout.OnOffsetChangedListener {
    protected enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    private State mCurrentState = State.IDLE;
    public abstract void onStateChanged(AppBarLayout appBarLayout, State state, int verticalOffset);
    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

        if (verticalOffset == 0) {
            if (mCurrentState != State.EXPANDED) {
                onStateChanged(appBarLayout, State.EXPANDED, verticalOffset);
            }
            mCurrentState = State.EXPANDED;
        } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
            if (mCurrentState != State.COLLAPSED) {
                onStateChanged(appBarLayout, State.COLLAPSED, verticalOffset);
            }
            mCurrentState = State.COLLAPSED;
        } else {
            if (mCurrentState != State.IDLE) {
                onStateChanged(appBarLayout, State.IDLE, verticalOffset);
            }
            mCurrentState = State.IDLE;
        }
    }
}
