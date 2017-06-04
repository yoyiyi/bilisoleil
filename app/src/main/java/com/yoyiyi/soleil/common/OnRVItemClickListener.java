
package com.yoyiyi.soleil.common;

import android.view.View;

/**
 * 点击事件
 *
 * @param <T>
 */
public interface OnRVItemClickListener<T> {
    void onItemClick(View view, int position, T data);
}