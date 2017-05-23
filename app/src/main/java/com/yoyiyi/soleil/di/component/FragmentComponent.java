package com.yoyiyi.soleil.di.component;

import android.app.Activity;

import com.yoyiyi.soleil.di.module.FragmentModule;
import com.yoyiyi.soleil.di.scope.FragmentScope;

import dagger.Component;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/4/27 19:30
 * 描述:FragmentComponent
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    /*void inject(RecommendFragment recommendFragment);

    void inject(LiveFragment liveFragment);

    void inject(BangumiFragment bangumiFragment);

    void inject(RegionFragment regionFragment);

    void inject(DiscoverFragment discoverFragment);

    void inject(AttentionFragment attentionFragment);*/


}
