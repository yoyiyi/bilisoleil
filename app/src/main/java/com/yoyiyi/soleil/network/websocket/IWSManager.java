package com.yoyiyi.soleil.network.websocket;

import okhttp3.WebSocket;
import okio.ByteString;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/27 14:41
 * 描述:websocket 接口
 */

public interface IWSManager {
    /**
     * 获取WebSocket
     *
     * @return
     */
    WebSocket getWebSocket();

    /**
     * 开始连接
     */
    void startConnect();

    /**
     * 停止连接
     */
    void stopConnect();

    /**
     * 判断是否在连接
     *
     * @return
     */
    boolean isWsConnected();

    /**
     * 获取状态
     *
     * @return
     */
    int getCurrentStatus();

    /**
     * 设置状态
     *
     * @param currentStatus
     */
    void setCurrentStatus(int currentStatus);

    /**
     * 发送消息
     *
     * @param msg
     * @return
     */
    boolean sendMessage(String msg);

    /**
     * 发送消息
     *
     * @param byteString
     * @return
     */
    boolean sendMessage(ByteString byteString);
}
