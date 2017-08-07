package com.yoyiyi.soleil.network.websocket;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/27 14:44
 * 描述:状态值
 */

public interface WSStatus {
    int CONNECTING = 0;//正在连接
    int CONNECTED = 1;//已经连接
    int RECONNECT = 2;//重新连接
    int DISCONNECTED = -1;//未连接

    interface CODE {
        int NORMAL_CLOSE = 1000;//正常关闭
        int ABNORMAL_CLOSE = 1001;//异常关闭
    }

    interface TIP {
        String NORMAL_CLOSE = "WEBSOCKET正常关闭";//正常关闭
        String ABNORMAL_CLOSE = "WEBSOCKET异常关闭";//异常关闭
    }
}
