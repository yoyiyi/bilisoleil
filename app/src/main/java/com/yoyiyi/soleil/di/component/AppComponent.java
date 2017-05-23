package com.yoyiyi.soleil.di.component;
import android.content.Context;
import com.yoyiyi.soleil.di.module.ApiModule;
import com.yoyiyi.soleil.di.module.AppModule;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import javax.inject.Singleton;
import dagger.Component;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/4/27 16:39
 * 描述:AppComponent
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {
    Context getContext();

    RetrofitHelper getRetrofitHelper();

}
