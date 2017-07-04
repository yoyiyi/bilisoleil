package com.yoyiyi.soleil.di.module;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.yoyiyi.soleil.di.qualifier.ApiUrl;
import com.yoyiyi.soleil.di.qualifier.AppUrl;
import com.yoyiyi.soleil.di.qualifier.BangumiUrl;
import com.yoyiyi.soleil.di.qualifier.Im9Url;
import com.yoyiyi.soleil.di.qualifier.LiveUrl;
import com.yoyiyi.soleil.di.qualifier.RankUrl;
import com.yoyiyi.soleil.network.api.ApiService;
import com.yoyiyi.soleil.network.api.AppService;
import com.yoyiyi.soleil.network.api.BangumiService;
import com.yoyiyi.soleil.network.api.Im9Service;
import com.yoyiyi.soleil.network.api.LiveService;
import com.yoyiyi.soleil.network.api.RankService;
import com.yoyiyi.soleil.network.helper.OkHttpHelper;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;
import com.yoyiyi.soleil.network.support.ApiConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/4/27 16:41
 * 描述:Api网络模型
 */
@Module
public class ApiModule {
    public Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient() {
        return OkHttpHelper.getInstance().getOkHttpClient();
    }

    @Singleton
    @Provides
    public Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    public RetrofitHelper provideRetrofitHelper(AppService appService, LiveService liveService, BangumiService bangumiService, RankService rankService
    ,ApiService apiService,Im9Service im9Service) {
        return new RetrofitHelper(appService, liveService, bangumiService, rankService,apiService,im9Service);
    }


    @Singleton
    @Provides
    @AppUrl
    public Retrofit provideAppRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ApiConstants.APP_BASE_URL);
    }

    @Singleton
    @Provides
    public AppService provideAppService(@AppUrl Retrofit retrofit) {
        return retrofit.create(AppService.class);
    }

    @Singleton
    @Provides
    @LiveUrl
    public Retrofit provideLiveRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ApiConstants.LIVE_BASE_URL);
    }

    @Singleton
    @Provides
    public LiveService provideLiveService(@LiveUrl Retrofit retrofit) {
        return retrofit.create(LiveService.class);
    }


    @Singleton
    @Provides
    @BangumiUrl
    public Retrofit provideBangumiRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ApiConstants.BANGUMI_BASE_URL);
    }

    @Singleton
    @Provides
    public BangumiService provideBangumiService(@BangumiUrl Retrofit retrofit) {
        return retrofit.create(BangumiService.class);
    }

    @Singleton
    @Provides
    @RankUrl
    public Retrofit provideRankRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ApiConstants.RANK_BASE_URL);
    }

    @Singleton
    @Provides
    public RankService provideRankService(@RankUrl Retrofit retrofit) {
        return retrofit.create(RankService.class);
    }

    @Singleton
    @Provides
    @ApiUrl
    public Retrofit provideApiRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ApiConstants.API_BASE_URL);
    }

    @Singleton
    @Provides
    public ApiService provideApiService(@ApiUrl Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
    @Singleton
    @Provides
    @Im9Url
    public Retrofit provideIm9Retrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ApiConstants.IM9_BASE_URL);
    }

    @Singleton
    @Provides
    public Im9Service provideIm9Service(@Im9Url Retrofit retrofit) {
        return retrofit.create(Im9Service.class);
    }
}
