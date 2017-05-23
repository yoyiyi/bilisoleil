package com.yoyiyi.soleil.network.support;

import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Logger拦截器
 * Created by zzq on 2016/12/5.
 */

public final  class LoggerInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Logger.d(String.format("Sending request %s on %s%n%s",
                request.url(), chain.connection(), request.headers()));
        long t1 = System.nanoTime();
        Response response = chain.proceed(chain.request());
        long t2 = System.nanoTime();
        Logger.d(String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));
        MediaType mediaType = response.body().contentType();
        String content = response.body().string();
        Logger.json(content);
        return response
                .newBuilder()
                .body(ResponseBody.create(mediaType, content))
                .build();
    }
}
