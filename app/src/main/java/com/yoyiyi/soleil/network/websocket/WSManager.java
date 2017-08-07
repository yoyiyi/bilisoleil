package com.yoyiyi.soleil.network.websocket;

import android.content.Context;
import android.os.Looper;

import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.NetworkUtils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/27 14:37
 * 描述:WS 管理
 */


public class WSManager implements IWSManager {
    //重连相关
    private final static int RECONNECT_INTERVAL = 10 * 1000;//间隔
    private final static long RECONNECT_MAX_TIME = 120 * 1000;//重连最大时间
    private Context mContext;//上下文
    private String mWsUrl;//地址
    private volatile WebSocket mWebSocket;//websoket
    private OkHttpClient mOkHttpClient;//okhttp
    private Request mRequest;//请求
    private int mCurrentStatus = WSStatus.DISCONNECTED;//状态
    private boolean isNeedReconnect = true;//需要重新连接
    private IStatusListener mIStatusListener;//回调
    private Lock mLock;//锁
    private int reconnectCount = 3;   //重连次数
    //初始化websocket监听
    private WebSocketListener mWebSocketListener = new WebSocketListener() {
        @Override
        public void onOpen(WebSocket webSocket, Response response) {
            mWebSocket = webSocket;
            setCurrentStatus(WSStatus.CONNECTED);
            connected();
            if (mIStatusListener != null) {
                mIStatusListener.onOpen(response);
            }
        }

        @Override
        public void onMessage(WebSocket webSocket, final ByteString bytes) {
            if (mIStatusListener != null) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    AppUtils.runOnUI(new Runnable() {
                        @Override
                        public void run() {
                            mIStatusListener.onMessage(bytes);
                        }
                    });
                } else {
                    mIStatusListener.onMessage(bytes);
                }
            }
        }

        @Override
        public void onMessage(WebSocket webSocket, final String text) {
            if (mIStatusListener != null) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    AppUtils.runOnUI(new Runnable() {
                        @Override
                        public void run() {
                            mIStatusListener.onMessage(text);
                        }
                    });
                } else {
                    mIStatusListener.onMessage(text);
                }
            }
        }

        @Override
        public void onClosing(WebSocket webSocket, int code, String reason) {
            if (mIStatusListener != null) {
                mIStatusListener.onClosing(code, reason);
            }
        }

        @Override
        public void onClosed(WebSocket webSocket, int code, String reason) {
            if (mIStatusListener != null) {
                mIStatusListener.onClosed(code, reason);
            }
        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable t, Response response) {
            tryReconnect();
            if (mIStatusListener != null) {
                mIStatusListener.onFailure(t, response);
            }
        }
    };


    private Runnable reconnectRunnable = new Runnable() {
        @Override
        public void run() {
            if (mIStatusListener != null) {
                mIStatusListener.onReconnect();
            }
            //建立连接
            buildConnect();
        }
    };


    /**
     * 构造函数
     *
     * @param builder
     */
    public WSManager(Builder builder) {
        mContext = builder.mContext;
        mWsUrl = builder.mWsUrl;
        mOkHttpClient = builder.mOkHttpClient;
        this.mLock = new ReentrantLock();
    }

    private void initWebSocket() {
        if (mOkHttpClient == null) {
            HttpHelper.SSLParams sslParams1 = HttpHelper.getSslSocketFactory(HttpHelper.UnSafeTrustManager);
            mOkHttpClient = new OkHttpClient.Builder()
                    .readTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                    .writeTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                    .connectTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                    .hostnameVerifier(HttpHelper.UnSafeHostnameVerifier)
                    .sslSocketFactory(sslParams1.sSLSocketFactory, sslParams1.trustManager)
                    .retryOnConnectionFailure(true)
                    .build();
        }
        if (mRequest == null) {
            mRequest = new Request.Builder()
                   // .addHeader(SessionInfo.SESSIONID_KEY, SessionInfo.getSessionID(mContext))//增加Cookie
                    .url(mWsUrl)
                    .build();
        }
        mOkHttpClient.dispatcher().cancelAll();
        try {
            mLock.lockInterruptibly();
            try {
                mOkHttpClient.newWebSocket(mRequest, mWebSocketListener);
            } finally {
                mLock.unlock();
            }
        } catch (InterruptedException e) {
        }
    }

    @Override
    public WebSocket getWebSocket() {
        return mWebSocket;
    }


    public void setIStatusListener(IStatusListener IStatusListener) {
        this.mIStatusListener = IStatusListener;
    }

    @Override
    public synchronized boolean isWsConnected() {
        return mCurrentStatus == WSStatus.CONNECTED;
    }

    @Override
    public synchronized int getCurrentStatus() {
        return mCurrentStatus;
    }

    /**
     * 设置连接状态
     *
     * @param currentStatus
     */
    @Override
    public synchronized void setCurrentStatus(int currentStatus) {
        this.mCurrentStatus = currentStatus;
    }

    /**
     * 开始连接
     */
    @Override
    public void startConnect() {
        isNeedReconnect = true;
        buildConnect();
    }

    /**
     * 结束连接
     */
    @Override
    public void stopConnect() {
        isNeedReconnect = false;
        disconnect();
    }

    private void tryReconnect() {
        if (!isNeedReconnect) {
            return;
        }

        if (!NetworkUtils.isConnected(mContext)) {
            setCurrentStatus(WSStatus.DISCONNECTED);
            return;
        }

        setCurrentStatus(WSStatus.RECONNECT);

        long delay = reconnectCount * RECONNECT_INTERVAL;
        AppUtils.runOnUIDelayed(reconnectRunnable, delay > RECONNECT_MAX_TIME ? RECONNECT_MAX_TIME : delay);
        reconnectCount++;
    }

    /**
     * 清空最近连接
     */
    private void cancelReconnect() {
      //  AppUtils.sHandler.removeCallbacks(reconnectRunnable);
        reconnectCount = 0;
    }

    /**
     * 设置连接
     */
    private void connected() {
        cancelReconnect();
    }

    private void disconnect() {
        if (mCurrentStatus == WSStatus.DISCONNECTED) {
            return;
        }
        cancelReconnect();
        if (mOkHttpClient != null) {
            mOkHttpClient.dispatcher().cancelAll();
        }
        if (mWebSocket != null) {
            boolean isClosed = mWebSocket.close(WSStatus.CODE.NORMAL_CLOSE, WSStatus.TIP.NORMAL_CLOSE);
            //非正常关闭连接
            if (!isClosed) {
                if (mIStatusListener != null) {
                    mIStatusListener.onClosed(WSStatus.CODE.ABNORMAL_CLOSE, WSStatus.TIP.ABNORMAL_CLOSE);
                }
            }
        }
        setCurrentStatus(WSStatus.DISCONNECTED);
    }

    /**
     * 建立连接
     */
    private synchronized void buildConnect() {
        if (!NetworkUtils.isConnected(mContext)) {
            setCurrentStatus(WSStatus.DISCONNECTED);
            return;
        }
        switch (getCurrentStatus()) {
            case WSStatus.CONNECTED:
            case WSStatus.CONNECTING:
                break;
            default:
                setCurrentStatus(WSStatus.CONNECTING);
                initWebSocket();
        }
    }

    //发送消息
    @Override
    public boolean sendMessage(String msg) {
        return send(msg);
    }

    //发送消息
    @Override
    public boolean sendMessage(ByteString byteString) {
        return send(byteString);
    }

    private boolean send(Object msg) {
        boolean isSend = false;
        if (mWebSocket != null && mCurrentStatus == WSStatus.CONNECTED) {
            if (msg instanceof String) {
                isSend = mWebSocket.send((String) msg);
            } else if (msg instanceof ByteString) {
                isSend = mWebSocket.send((ByteString) msg);
            }
            //发送消息失败，尝试重连
            if (!isSend) {
                tryReconnect();
            }
        }
        return isSend;
    }

    /**
     * builder
     */
    public static final class Builder {

        private Context mContext;
        private String mWsUrl;
        private OkHttpClient mOkHttpClient;

        public Builder(Context val) {
            mContext = val;
        }

        public Builder wsUrl(String val) {
            mWsUrl = val;
            return this;
        }

        public Builder client(OkHttpClient val) {
            mOkHttpClient = val;
            return this;
        }

        public WSManager build() {
            return new WSManager(this);
        }
    }
}
