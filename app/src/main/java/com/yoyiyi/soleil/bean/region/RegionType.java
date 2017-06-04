package com.yoyiyi.soleil.bean.region;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/4 18:46
 * 描述:分区tag详情
 */
public class RegionType {
    /**
     * title : 【AMV/60fps】视觉的极致盛宴 Umbrella Corp【Nostromo】
     * cover : http://i0.hdslb.com/bfs/archive/70315d46e396d55cc6785a1bf8caf114cef0cbcc.jpg
     * uri : bilibili://video/6733923
     * param : 6733923
     * goto : av
     * name : ここにいるよ
     * play : 224795
     * danmaku : 1858
     * reply : 1280
     * favourite : 40890
     */

    public List<RecommendBean> recommend;

    /**
     * title : 【超燃/AMV】• Runnin ♫♪
     * cover : http://i1.hdslb.com/bfs/archive/ddbd80d656994ff6d9b1250ca8da7c3fc9154fc1.jpg
     * uri : bilibili://video/6770288
     * param : 6770288
     * goto : av
     * name : 来自火星的小火龙
     */

    @SerializedName("new")
    public List<NewBean> newX;

    public static class RecommendBean {
        public String title;
        public String cover;
        public String uri;
        public String param;
        @SerializedName("goto")
        public String gotoX;
        public String name;
        public int play;
        public int danmaku;
        public int reply;
        public int favourite;

    }

    public static class NewBean {
        public String title;
        public String cover;
        public String uri;
        public String param;
        @SerializedName("goto")
        public String gotoX;
        public String name;
        public int play;
        public int danmaku;

    }
}
