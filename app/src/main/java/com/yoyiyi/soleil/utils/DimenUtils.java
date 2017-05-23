package com.yoyiyi.soleil.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by zzq on 2016/12/17.
 */
public class DimenUtils {

    public enum EScreenDensity {
        XXHDPI,    //超高分辨率    1080×1920
        XHDPI,    //超高分辨率    720×1280
        HDPI,    //高分辨率         480×800
        MDPI,    //中分辨率         320×480
    }

    public static EScreenDensity getDisply(Context context) {
        EScreenDensity eScreenDensity;
        //初始化屏幕密度
        DisplayMetrics dm = context.getApplicationContext().getResources().getDisplayMetrics();
        int densityDpi = dm.densityDpi;

        if (densityDpi <= 160) {
            eScreenDensity = EScreenDensity.MDPI;
        } else if (densityDpi <= 240) {
            eScreenDensity = EScreenDensity.HDPI;
        } else if (densityDpi < 400) {
            eScreenDensity = EScreenDensity.XHDPI;
        } else {
            eScreenDensity = EScreenDensity.XXHDPI;
        }
        return eScreenDensity;
    }

    /**
     * 获取屏幕宽度
     *
     * @return
     */
    public static int getScreenWidth() {
        return AppUtils.getAppContext().getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @return
     */
    public static int getScreenHeight() {
        return AppUtils.getAppContext().getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 将dp转换成px
     *
     * @param dp
     * @return
     */
    public static float dp2Px(float dp) {
        return dp * AppUtils.getAppContext().getResources().getDisplayMetrics().density;
    }

    public static int dp2PxInt(float dp) {
        return (int) (dp2Px(dp) + 0.5f);
    }

    /**
     * 将px转换成dp
     *
     * @param px
     * @return
     */
    public static float px2Dp(float px) {
        return px / AppUtils.getAppContext().getResources().getDisplayMetrics().density;
    }

    public static int px2DpInt(float px) {
        return (int) (px2Dp(px) + 0.5f);
    }

    /**
     * 将px值转换为sp值
     *
     * @param pxValue
     * @return
     */
    public static float px2Sp(float pxValue) {
        return pxValue / AppUtils.getAppContext().getResources().getDisplayMetrics().scaledDensity;
    }

    /**
     * 将sp值转换为px值
     *
     * @param spValue
     * @return
     */
    public static float sp2Px(float spValue) {
        return spValue * AppUtils.getAppContext().getResources().getDisplayMetrics().scaledDensity;
    }
}
