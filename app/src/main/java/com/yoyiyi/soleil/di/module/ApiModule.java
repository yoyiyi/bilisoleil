package com.yoyiyi.soleil.di.module;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.yoyiyi.soleil.di.qualifier.AppUrl;
import com.yoyiyi.soleil.di.qualifier.BangumiUrl;
import com.yoyiyi.soleil.di.qualifier.LiveUrl;
import com.yoyiyi.soleil.network.api.AppService;
import com.yoyiyi.soleil.network.api.BangumiService;
import com.yoyiyi.soleil.network.api.LiveService;
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
    public RetrofitHelper provideRetrofitHelper(AppService appService, LiveService liveService, BangumiService bangumiService) {
        return new RetrofitHelper(appService, liveService, bangumiService);
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

   /* @Singleton
    @Provides
    @AppUrl
    public Retrofit provideAppRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ApiConstants.APP_BASE_URL);
    }

    @Singleton
    @Provides
    @AccountUrl
    public Retrofit provideAccountRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ApiConstants.ACCOUNT_BASE_URL);
    }



    @Singleton
    @Provides
    @BangumiUrl
    public Retrofit provideBangumiRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ApiConstants.BANGUMI_BASE_URL);
    }

    @Singleton
    @Provides
    @BiliUrl
    public Retrofit provideBiliRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ApiConstants.BILI_BASE_URL);
    }

    @Singleton
    @Provides
    @Im9Url
    public Retrofit provideIm9Retrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ApiConstants.IM9_BASE_URL);
    }

    @Singleton
    @Provides
    @LiveUrl
    public Retrofit provideLiveRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ApiConstants.LIVE_BASE_URL);
    }

    @Singleton
    @Provides
    @RankUrl
    public Retrofit provideRankRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ApiConstants.RANK_BASE_URL);
    }

    @Singleton
    @Provides
    @SearchUrl
    public Retrofit provideSearchRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ApiConstants.SEARCH_BASE_URL);
    }

    @Singleton
    @Provides
    @UserUrl
    public Retrofit provideUserRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ApiConstants.USER_BASE_URL);
    }

    @Singleton
    @Provides
    @VipUrl
    public Retrofit provideVipRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ApiConstants.VIP_BASE_URL);
    }
    @Singleton
    @Provides
    @ApiUrl
    public Retrofit provideApiRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ApiConstants.API_BASE_URL);
    }
    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient() {
        return OkHttpHelper.getInstance().getOkHttpClient();
    }
*/
   /* @Singleton
    @Provides
    public RetrofitHelper provideRetrofitHelper(AccountApi accountApi, AppApi appApi, BangumiApi bangumiApi, BiliApi biliApi, Im9Api im9Api, LiveApi liveApi,
                                                RankApi rankApi, SearchApi searchApi, UserApi userApi, VipApi vipApi, ApiApi apiApi) {
        return new RetrofitHelper(accountApi, appApi, bangumiApi, biliApi, im9Api, liveApi, rankApi, searchApi, userApi, vipApi,apiApi);
    }*/

   /* @Singleton
    @Provides
    public AccountApi provideAccountApi(@AccountUrl Retrofit retrofit) {
        return retrofit.create(AccountApi.class);
    }

    @Singleton
    @Provides
    public AppApi provideAppApi(@AppUrl Retrofit retrofit) {
        return retrofit.create(AppApi.class);
    }

    @Singleton
    @Provides
    public BangumiApi provideBangumiApi(@BangumiUrl Retrofit retrofit) {
        return retrofit.create(BangumiApi.class);
    }

    @Singleton
    @Provides
    public BiliApi provideBiliApi(@BiliUrl Retrofit retrofit) {
        return retrofit.create(BiliApi.class);
    }

    @Singleton
    @Provides
    public Im9Api provideIm9Api(@Im9Url Retrofit retrofit) {
        return retrofit.create(Im9Api.class);
    }

    @Singleton
    @Provides
    public LiveApi provideLiveApi(@LiveUrl Retrofit retrofit) {
        return retrofit.create(LiveApi.class);
    }

    @Singleton
    @Provides
    public RankApi provideRankApi(@RankUrl Retrofit retrofit) {
        return retrofit.create(RankApi.class);
    }

    @Singleton
    @Provides
    public SearchApi provideSearchApi(@SearchUrl Retrofit retrofit) {
        return retrofit.create(SearchApi.class);
    }

    @Singleton
    @Provides
    public UserApi provideUserApi(@UserUrl Retrofit retrofit) {
        return retrofit.create(UserApi.class);
    }

    @Singleton
    @Provides
    public VipApi provideVipApi(@VipUrl Retrofit retrofit) {
        return retrofit.create(VipApi.class);
    }

    @Singleton
    @Provides
    public ApiApi provideApiApi(@ApiUrl Retrofit retrofit) {
        return retrofit.create(ApiApi.class);
    }*/
}
