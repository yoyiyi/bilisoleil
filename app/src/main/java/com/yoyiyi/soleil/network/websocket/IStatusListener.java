package com.yoyiyi.soleil.network.websocket;

import okhttp3.Response;
import okio.ByteString;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/27 14:37
 * 描述:设置ws监听
 */

public interface IStatusListener {

    /**
     * 打开
     *
     * @param response
     */
    void onOpen(Response response);

    /**
     * 信息
     *
     * @param text
     */
    void onMessage(String text);

    /**
     * 信息
     *
     * @param bytes
     */
    void onMessage(ByteString bytes);

    /**
     * 重连
     */
    void onReconnect();

    /**
     * 关闭
     *
     * @param code
     * @param reason
     */
    void onClosing(int code, String reason);

    /**
     * 关闭
     *
     * @param code
     * @param reason
     */
    void onClosed(int code, String reason);

    /**
     * 失败
     *
     * @param t
     * @param response
     */
    void onFailure(Throwable t, Response response);
}
