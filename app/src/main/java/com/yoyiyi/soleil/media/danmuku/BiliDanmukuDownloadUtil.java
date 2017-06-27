package com.yoyiyi.soleil.media.danmuku;

import android.text.TextUtils;

import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.DataFormatException;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import master.flame.danmaku.danmaku.loader.ILoader;
import master.flame.danmaku.danmaku.loader.IllegalDataException;
import master.flame.danmaku.danmaku.loader.android.DanmakuLoaderFactory;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.danmaku.parser.IDataSource;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/23 9:03
 * 描述:视频弹幕下载
 */
public class BiliDanmukuDownloadUtil {
    public static Flowable<BaseDanmakuParser> downloadXML(final String uri) {
        return Flowable.create(emitter -> {
            if (TextUtils.isEmpty(uri)) {
                emitter.onNext(new BaseDanmakuParser() {
                    @Override
                    protected IDanmakus parse() {
                        return new Danmakus();
                    }
                });
            }
            ILoader loader = null;
            try {
                HttpConnection.Response rsp = (HttpConnection.Response)
                        Jsoup.connect(uri).timeout(20000).execute();
                InputStream stream = new ByteArrayInputStream(BiliDanmukuCompressionTools.
                        decompressXML(rsp.bodyAsBytes()));

                loader = DanmakuLoaderFactory.
                        create(DanmakuLoaderFactory.TAG_BILI);
                loader.load(stream);
            } catch (IOException | DataFormatException | IllegalDataException e) {
                e.printStackTrace();
            }
            BaseDanmakuParser parser = new BiliDanmukuParser();
            assert loader != null;
            IDataSource<?> dataSource = loader.getDataSource();
            parser.load(dataSource);
            emitter.onNext(parser);
        }, BackpressureStrategy.BUFFER);
    }
}
