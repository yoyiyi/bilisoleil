package com.yoyiyi.soleil.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.ArrayRes;
import android.support.annotation.StringRes;

import java.util.Timer;
import java.util.TimerTask;

/**
 * APP工具类
 * Created by zzq on 2016/12/17.
 */
public class AppUtils {

    private static Context mContext;
    private static Thread mUiThread;
    private static Timer mTimer;

    private static Handler sHandler = new Handler(Looper.getMainLooper());

    public static void init(Context context) { //在Application中初始化
        mContext = context;
        mUiThread = Thread.currentThread();
        mTimer = new Timer();
    }


    public static Context getAppContext() {
        return mContext;
    }

    public static AssetManager getAssets() {
        return mContext.getAssets();
    }
    public static float getDimension(int id) {
        return getResource().getDimension(id);
    }
    public static Resources getResource() {
        return mContext.getResources();
    }

    @SuppressWarnings("deprecation")
    public static Drawable getDrawable(int resId) {
        return mContext.getResources().getDrawable(resId);
    }

    @SuppressWarnings("deprecation")
    public static int getColor(int resId) {
        return mContext.getResources().getColor(resId);
    }

    public static String getString(@StringRes int resId) {
        return mContext.getResources().getString(resId);
    }

    public static String[] getStringArray(@ArrayRes int resId) {
        return mContext.getResources().getStringArray(resId);
    }

    public static boolean isUIThread() {
        return Thread.currentThread() == mUiThread;
    }

    public static void runOnUI(Runnable r) {
        sHandler.post(r);
    }

    public static void runOnUIDelayed(Runnable r, long delayMills) {
        sHandler.postDelayed(r, delayMills);
    }

    public static void runOnUITask(TimerTask r, long delay, long rate) {
        mTimer.schedule(r, delay, rate);
    }

    public static void runCancel() {
        mTimer.cancel();
    }

    public static void removeRunnable(Runnable r) {
        if (r == null) {
            sHandler.removeCallbacksAndMessages(null);
        } else {
            sHandler.removeCallbacks(r);
        }
    }
}
