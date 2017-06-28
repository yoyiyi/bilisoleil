package com.yoyiyi.soleil.network.helper;


import com.yoyiyi.soleil.bean.app.Splash;
import com.yoyiyi.soleil.bean.app.video.VideoDetail;
import com.yoyiyi.soleil.bean.app.video.VideoDetailComment;
import com.yoyiyi.soleil.bean.app.video.VideoPlayer;
import com.yoyiyi.soleil.bean.bangumi.BangumiDetail;
import com.yoyiyi.soleil.bean.bangumi.BangumiDetailComment;
import com.yoyiyi.soleil.bean.bangumi.BangumiDetailRecommend;
import com.yoyiyi.soleil.bean.bangumi.BangumiIndex;
import com.yoyiyi.soleil.bean.bangumi.BangumiSchedule;
import com.yoyiyi.soleil.bean.chase.ChaseBangumi;
import com.yoyiyi.soleil.bean.chase.RecommendBangumi;
import com.yoyiyi.soleil.bean.discover.ActivityCenter;
import com.yoyiyi.soleil.bean.discover.Community;
import com.yoyiyi.soleil.bean.discover.HotSearchTag;
import com.yoyiyi.soleil.bean.discover.InterestAd;
import com.yoyiyi.soleil.bean.discover.InterestCategrory;
import com.yoyiyi.soleil.bean.discover.TopicCenter;
import com.yoyiyi.soleil.bean.live.LiveEntrance;
import com.yoyiyi.soleil.bean.live.LivePartition;
import com.yoyiyi.soleil.bean.live.LiveRecommend;
import com.yoyiyi.soleil.bean.recommend.AllStationRank;
import com.yoyiyi.soleil.bean.recommend.Recommend;
import com.yoyiyi.soleil.bean.region.AllRegionRank;
import com.yoyiyi.soleil.bean.region.Region;
import com.yoyiyi.soleil.bean.region.RegionRecommend;
import com.yoyiyi.soleil.bean.region.RegionType;
import com.yoyiyi.soleil.bean.search.Movie;
import com.yoyiyi.soleil.bean.search.Search;
import com.yoyiyi.soleil.bean.search.SearchArchive;
import com.yoyiyi.soleil.bean.search.Season;
import com.yoyiyi.soleil.bean.search.Up;
import com.yoyiyi.soleil.bean.user.UpDetail;
import com.yoyiyi.soleil.network.api.ApiService;
import com.yoyiyi.soleil.network.api.AppService;
import com.yoyiyi.soleil.network.api.BangumiService;
import com.yoyiyi.soleil.network.api.Im9Service;
import com.yoyiyi.soleil.network.api.LiveService;
import com.yoyiyi.soleil.network.api.RankService;
import com.yoyiyi.soleil.network.response.HttpResponse;

import java.util.List;

import io.reactivex.Flowable;


/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/10 17:57
 * 描述:RetrofitHelper 帮助类
 */

public class RetrofitHelper {
    private final LiveService mLiveService;
    private final AppService mAppService;
    private final BangumiService mBangumiService;
    private final RankService mRankService;
    private final ApiService mApiService;
    private final Im9Service mIm9Service;

    public RetrofitHelper(AppService appService, LiveService liveService, BangumiService bangumiService, RankService rankService, ApiService apiService, Im9Service im9Service) {
        this.mAppService = appService;
        this.mLiveService = liveService;
        this.mBangumiService = bangumiService;
        this.mRankService = rankService;
        this.mApiService = apiService;
        this.mIm9Service = im9Service;
    }


    /*******************************AppApi****************************************/
    public Flowable<Splash> getSplash() {
        return mAppService.getSplash();
    }

    public Flowable<HttpResponse<List<Recommend>>> getRecommend() {
        return mAppService.getRecommend();
    }

    public Flowable<HttpResponse<List<Region>>> getRegion() {
        return mAppService.getRegion();
    }

    public Flowable<HttpResponse<HotSearchTag>> getHotSearchTag() {
        return mAppService.getHotSearchTag();
    }

    public Flowable<HttpResponse<SearchArchive>> getSearchArchive(String keyword, int page, int pagesize) {
        return mAppService.getSearchArchive(keyword, page, pagesize);
    }

    public Flowable<HttpResponse<RegionRecommend>> getRegionRecommend(int rid) {
        return mAppService.getRegionRecommend(rid);
    }

    public Flowable<HttpResponse<RegionType>> getRegionType(int rid) {
        return mAppService.getRegionType(rid);
    }

    public Flowable<VideoDetail> getVideoDetail() {
        return mAppService.getVideoDetail();
    }

    public Flowable<VideoDetailComment> getVideoDetailComment() {
        return mApiService.getVideoDetailComment();
    }

    public Flowable<UpDetail> getUpDetail() {
        return mAppService.getUpDetail();
    }

    public Flowable<Search> getSearch() {
        return mAppService.getSearch();
    }

    public Flowable<Up> getUp() {
        return mAppService.getUp();
    }

    public Flowable<Movie> getMovie() {
        return mAppService.getMovie();
    }

    public Flowable<Season> getSeason() {
        return mAppService.getSeason();
    }
    public Flowable<VideoPlayer> getVideoPlayer() {
        return mAppService.getVideoPlayer();
    }
    /*******************************LiveApi****************************************/

    public Flowable<HttpResponse<LiveRecommend>> getLiveRecommend() {
        return mLiveService.getLiveRecommend();
    }

    public Flowable<HttpResponse<LivePartition>> getLivePartition() {
        return mLiveService.getLivePartition();
    }

    public Flowable<HttpResponse<List<LiveEntrance>>> getLiveEntrance() {
        return mLiveService.getLiveEntrance();
    }

    /*******************************BangumiApi****************************************/

    public Flowable<HttpResponse<ChaseBangumi>> getChaseBangumi() {
        return mBangumiService.getChaseBangumi();
    }

    public Flowable<HttpResponse<RecommendBangumi>> getRecommendBangumi() {
        return mBangumiService.getRecommendBangumi();
    }

    public Flowable<HttpResponse<List<BangumiSchedule>>> getBangumiSchedule() {
        return mBangumiService.getBangumiSchedule();
    }

    public Flowable<HttpResponse<BangumiIndex>> getBangumiIndex() {
        return mBangumiService.getBangumiIndex();
    }

    public Flowable<HttpResponse<BangumiDetail>> getBangumiDetail() {
        return mBangumiService.getBangumiDetail();
    }

    public Flowable<HttpResponse<BangumiDetailRecommend>> getBangumiDetailRecommend() {
        return mBangumiService.getBangumiDetailRecommend();
    }

    /*******************************RankApi****************************************/
    public Flowable<AllRegionRank> getAllRegionRank(String type) {
        return mRankService.getAllRegionRank(type);
    }

    public Flowable<AllStationRank> getAllStationRank(String type) {
        return mRankService.getAllStationRank(type);
    }

    /*******************************ApiApi****************************************/
    public Flowable<TopicCenter> getTopicCenter() {
        return mApiService.getTopicCenter();
    }

    public Flowable<ActivityCenter> getActivityCenter(int page, int pageSize) {
        return mApiService.getActivityCenter(page, pageSize);
    }

    public Flowable<BangumiDetailComment> getBangumiDetailComment() {
        return mApiService.getBangumiDetailComment();
    }

    /*******************************Im9Api****************************************/

    public Flowable<HttpResponse<InterestCategrory>> getInterestCategrory() {
        return mIm9Service.getInterestCategrory();
    }

    public Flowable<HttpResponse<Community>> getCommunity() {
        return mIm9Service.getCommunity();
    }

    public Flowable<HttpResponse<InterestAd>> getInterestAd() {
        return mIm9Service.getInterestAd();
    }


}
