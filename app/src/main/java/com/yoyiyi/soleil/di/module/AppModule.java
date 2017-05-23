package com.yoyiyi.soleil.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/4/27 14:41
 * 描述:App模型
 */
@Module
public class AppModule {
    private Context mContext;

    public AppModule(Context context) {
        this.mContext = context;
    }

    @Provides
    public Context provideContext() {
        return mContext;
    }
}
