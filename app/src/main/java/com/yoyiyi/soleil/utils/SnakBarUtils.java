package com.yoyiyi.soleil.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/15 11:59
 * 描述:
 */

public class SnakBarUtils {
    public static void showMessage(View view, String text) {
        Snackbar.make(view, text, Snackbar.LENGTH_LONG).show();
    }
}
