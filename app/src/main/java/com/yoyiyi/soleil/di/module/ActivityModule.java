package com.yoyiyi.soleil.di.module;

import android.app.Activity;

import com.yoyiyi.soleil.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/4/27 16:41
 * 描述:Activity模型
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}
