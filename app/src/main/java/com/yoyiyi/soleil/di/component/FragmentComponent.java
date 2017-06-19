package com.yoyiyi.soleil.di.component;

import android.app.Activity;

import com.yoyiyi.soleil.di.module.FragmentModule;
import com.yoyiyi.soleil.di.scope.FragmentScope;
import com.yoyiyi.soleil.module.app.up.FavouriteFragment;
import com.yoyiyi.soleil.module.app.up.SubmitedVideoFragment;
import com.yoyiyi.soleil.module.app.video.CommentFragment;
import com.yoyiyi.soleil.module.app.video.SummaryFragment;
import com.yoyiyi.soleil.module.discover.InterestFragment;
import com.yoyiyi.soleil.module.home.ChaseBangumiFragment;
import com.yoyiyi.soleil.module.home.DiscoverFragment;
import com.yoyiyi.soleil.module.home.DynamicFragment;
import com.yoyiyi.soleil.module.home.LiveFragment;
import com.yoyiyi.soleil.module.home.RecommendFragment;
import com.yoyiyi.soleil.module.home.RegionFragment;
import com.yoyiyi.soleil.module.recommend.AllStationRankFragment;
import com.yoyiyi.soleil.module.region.AllRegionRankFragment;
import com.yoyiyi.soleil.module.region.RegionTypeFragment;
import com.yoyiyi.soleil.module.region.RegionTypeRecommendFragment;
import com.yoyiyi.soleil.module.search.ArchiveFragment;
import com.yoyiyi.soleil.module.search.MovieFragment;
import com.yoyiyi.soleil.module.search.SeasonFragment;
import com.yoyiyi.soleil.module.search.UpFragment;

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

    void inject(RegionTypeFragment regionTypeFragment);

    void inject(AllRegionRankFragment allRegionRankFragment);

    void inject(AllStationRankFragment allStationRankFragment);

    void inject(InterestFragment interestFragment);

    void inject(DynamicFragment dynamicFragment);

    void inject(SummaryFragment summaryFragment);

    void inject(CommentFragment commentFragment);

    void inject(com.yoyiyi.soleil.module.app.up.ArchiveFragment archiveFragment);

    void inject(SubmitedVideoFragment submitedVideoFragment);

    void inject(FavouriteFragment favouriteFragment);

    void inject(MovieFragment movieFragment);

    void inject(UpFragment upFragment);

    void inject(SeasonFragment seasonFragment);


}
