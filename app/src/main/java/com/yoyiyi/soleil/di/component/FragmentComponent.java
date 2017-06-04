package com.yoyiyi.soleil.di.component;

import android.app.Activity;

import com.yoyiyi.soleil.di.module.FragmentModule;
import com.yoyiyi.soleil.di.scope.FragmentScope;
import com.yoyiyi.soleil.module.home.ChaseBangumiFragment;
import com.yoyiyi.soleil.module.home.DiscoverFragment;
import com.yoyiyi.soleil.module.home.LiveFragment;
import com.yoyiyi.soleil.module.home.RecommendFragment;
import com.yoyiyi.soleil.module.home.RegionFragment;
import com.yoyiyi.soleil.module.region.RegionTypeRecommendFragment;
import com.yoyiyi.soleil.module.search.ArchiveFragment;

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

    void inject(LiveFragment liveFragment);

    void inject(RecommendFragment recommendFragment);

    void inject(RegionFragment regionFragment);

    void inject(ChaseBangumiFragment chaseBangumiFragment);

    void inject(DiscoverFragment discoverFragment);

    void inject(ArchiveFragment archiveFragment);

    void inject(RegionTypeRecommendFragment regionTypeRecommendFragment);


}
