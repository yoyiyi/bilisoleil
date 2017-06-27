package com.yoyiyi.soleil.media.callback;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/23 9:03
 * 描述:控制视频回调
 */
public interface MediaPlayerListener {

    void start();//开始

    void pause();//暂停

    int getDuration();//获取时间

    int getCurrentPosition();//获取当前位置

    void seekTo(long pos);//跳

    boolean isPlaying();//判断是否正在播放

    int getBufferPercentage();

    boolean canPause();//能暂停
}
