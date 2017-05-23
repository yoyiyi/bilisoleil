package com.yoyiyi.soleil.utils.image;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/4/28 9:26
 * 描述:Glide工具类
 */

public class ImageLoader {
    public enum CacheState {
        ALL, SOURCE, NONE, RESULT
    }

    public static void load(Activity activity, String url, ImageView iv) {    //使用Glide加载圆形ImageView(如头像)时，不要使用占位图
        if (!activity.isDestroyed()) {
            Glide.with(activity).load(url).crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
        }
    }

    public static void loadAll(Context context, String url, ImageView iv) {    //不缓存，全部从网络加载
        loadAll(context, url, iv, DiskCacheStrategy.NONE);
    }

    public static void loadAll(Activity activity, String url, ImageView iv) {    //不缓存，全部从网络加载
        if (!activity.isDestroyed()) {
            loadAll(activity, url, iv, DiskCacheStrategy.NONE);
        }
    }


    public static void loadAll(Activity activity, String url, ImageView iv, DiskCacheStrategy cacheStrategy) {
        if (!activity.isDestroyed()) {
            Glide.with(activity).load(url).crossFade().skipMemoryCache(true).diskCacheStrategy(cacheStrategy).into(iv);
        }
    }

    public static void loadAll(Context context, String url, ImageView iv, DiskCacheStrategy cacheStrategy) {
        Glide.with(context).load(url).crossFade().skipMemoryCache(true).diskCacheStrategy(cacheStrategy).into(iv);
    }

    public static void loadCircle(Context context, String url, int erroImg, int emptyImg, ImageView iv) { //加载圆形
        Glide.with(context).load(url).placeholder(emptyImg).error(erroImg).transform(new GlideCircleTransform(context)).into(iv);
    }

    public static void loadRound(Context context, String url, int erroImg, int emptyImg, ImageView iv, int dp) { //加载圆角
        Glide.with(context).load(url).placeholder(emptyImg).error(erroImg).transform(new GlideRoundTransform(context, dp)).into(iv);

    }

    public static void loadAll(Context context, String url, ImageView iv, CacheState cacheState) {    //缓存，
        switch (cacheState) {
            case ALL:
                loadAll(context, url, iv, DiskCacheStrategy.ALL);
                break;
            case SOURCE:
                loadAll(context, url, iv, DiskCacheStrategy.SOURCE);
                break;
            case NONE:
                loadAll(context, url, iv, DiskCacheStrategy.NONE);
                break;
            case RESULT:
                loadAll(context, url, iv, DiskCacheStrategy.RESULT);
                break;
            default:
                break;
        }
    }

    public static void load(Context context, Uri url, int empty, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(empty)
                .dontAnimate()
                .into(imageView);
    }
    public static void load(Context context, String url, int empty, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(empty)
                .dontAnimate()
                .into(imageView);
    }
}
