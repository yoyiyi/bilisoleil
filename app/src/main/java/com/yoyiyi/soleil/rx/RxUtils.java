package com.yoyiyi.soleil.rx;

import com.yoyiyi.soleil.network.exception.ApiException;
import com.yoyiyi.soleil.network.response.HttpResponse;

import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/4/7 15:37
 * 描述:RxUtils
 */
public class RxUtils {
    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程 统一处理线程
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    /**
     * 生成Flowable
     *
     * @param <T>
     * @return
     */
    public static <T> Flowable<T> createData(final T t) {
        return Flowable.create(emitter -> {
            try {
                emitter.onNext(t);
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        }, BackpressureStrategy.BUFFER);
    }

    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<HttpResponse<T>, T> handleResult() {
        return httpResponseFlowable ->
                httpResponseFlowable.flatMap((Function<HttpResponse<T>, Flowable<T>>) httpResponse -> {
                    if (httpResponse.code == 0) {
                        if (httpResponse.data != null)
                            return createData(httpResponse.data);
                        if (httpResponse.result != null)
                            return createData(httpResponse.result);
                        return Flowable.error(new ApiException("服务器返回error"));
                    } else {
                        return Flowable.error(new ApiException("服务器返回error"));
                    }
                });
    }

    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<HttpResponse<List<T>>, List<T>> handleListResult() {
        return httpResponseFlowable ->
                httpResponseFlowable.flatMap((Function<HttpResponse<List<T>>, Flowable<List<T>>>) httpResponse -> {
                    if (httpResponse.code == 0) {
                        if (httpResponse.data != null)
                            return createData(httpResponse.data);
                        if (httpResponse.result != null)
                            return createData(httpResponse.result);
                        return Flowable.error(new ApiException("服务器返回error"));
                    } else {
                        return Flowable.error(new ApiException("服务器返回error"));
                    }
                });
    }
}
