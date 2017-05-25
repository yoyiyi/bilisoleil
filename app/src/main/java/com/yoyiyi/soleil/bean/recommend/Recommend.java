package com.yoyiyi.soleil.bean.recommend;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 14:17
 * 描述:首页推荐
 */

public class Recommend {

    /**
     * banner_item : [{"cm_mark":0,"hash":"d360c83559586445a1c336b50b8d5ee6","id":47350,"image":"http://i0.hdslb.com/bfs/archive/1ac16d4525365268edd592852e7165347d35ccb8.jpg","index":1,"request_id":"1495725192400","resource_id":631,"server_type":0,"title":"音乐0525","uri":"http://www.bilibili.com/blackboard/topic/activity-ByFKsE3gW.html"},{"ad_cb":"CPeEARCuLxjyNSAAKAAwADi/BUIfMTQ5NTcyNTE5MjQxOHExNzJhMThhNjFhMTY2cTIxN0ji6ayBxCtSCeadreW3nuW4gloJ5rWZ5rGf55yBYgbkuK3lm71oAXAAeACAAQCIAdoUkgEMMTEyLjEwLjk1Ljgx","client_ip":"112.10.95.81","cm_mark":2,"creative_id":17015,"hash":"cc5fd23910326879f7723a5a9727cbe1","id":0,"image":"https://i0.hdslb.com/bfs/archive/aad40f231807562d4c6f4b5fa9832c770293683d.jpg","index":2,"is_ad_loc":true,"request_id":"1495725192418q172a18a61a166q217","resource_id":631,"server_type":1,"src_id":703,"title":"碧蓝","uri":"http://blhx.biligame.com/h5"},{"ad_cb":"CMGDARD+LhidNiAAKAAwADjABUIfMTQ5NTcyNTE5MjQxOHExNzJhMThhNjFhMTY2cTIxN0ji6ayBxCtSCeadreW3nuW4gloJ5rWZ5rGf55yBYgbkuK3lm71oAXAAeACAAQCIAfoXkgEMMTEyLjEwLjk1Ljgx","client_ip":"112.10.95.81","cm_mark":1,"creative_id":16833,"hash":"5622253cfe31b18536713218a6fdb52c","id":0,"image":"https://i0.hdslb.com/bfs/archive/1f7d851cee3f4326b872af62f530d7f65cabdbcc.jpg","index":3,"is_ad":true,"is_ad_loc":true,"request_id":"1495725192418q172a18a61a166q217","resource_id":631,"server_type":1,"src_id":704,"title":"小米","uri":"http://live.bilibili.com/545342"},{"cm_mark":0,"hash":"260d5ea1f9922b12ee14ba139e3adddb","id":47517,"image":"http://i0.hdslb.com/bfs/archive/213bf01aea7f6016404b0a5ef4d847cef0d66003.jpg","index":4,"request_id":"1495725192400","resource_id":631,"server_type":0,"title":"bdf","uri":"http://www.bilibili.com/blackboard/activity-BDF2017-m.html"}]
     * goto : banner
     * idx : 1495725203
     * param : 0
     * coin : 150
     * cover : http://i0.hdslb.com/bfs/archive/41b9ae60ede64a4badc29c1dd49e66d6bb02e6e3.jpg
     * ctime : 1495550930
     * danmaku : 2264
     * desc : 史诗级最新电影怪兽合集四，怪兽那么多，你真不来看看？我会说文件又是因为太大了又被我剪成了两个视频吗？有兴趣的朋友可以去看看【史诗级最新电影怪兽合集五】怪兽那么多，你认识几个？。
     * dislike_reasons : [{"reason_id":4,"reason_name":"UP主:大白兔白不白"},{"reason_id":2,"reason_name":"分区:电影相关"},{"reason_id":3,"reason_name":"标签:混剪"},{"reason_id":1,"reason_name":"不感兴趣"}]
     * duration : 1764
     * face : http://i1.hdslb.com/bfs/face/f6e065310976d996db18c3468bedc8e3f23aeb9d.jpg
     * favorite : 1993
     * mid : 101575318
     * name : 大白兔白不白
     * play : 68635
     * reply : 116
     * share : 64
     * tag : {"count":{"atten":55679},"tag_id":147345,"tag_name":"混剪"}
     * tid : 82
     * title : 【史诗级最新电影怪兽合集四】怪兽那么多，你认识几个？
     * tname : 电影相关
     * uri : bilibili://video/10779499
     */

    @SerializedName("goto")
    public String gotoX;
    public int idx;
    public String param;
    public int coin;
    public String cover;
    public int ctime;
    public int danmaku;
    public String desc;
    public int duration;
    public String face;
    public int favorite;
    public int mid;
    public String name;
    public int play;
    public int reply;
    public int share;
    public TagBean tag;
    public int tid;
    public String title;
    public String tname;
    public String uri;
    public List<BannerItemBean> banner_item;
    public List<DislikeReasonsBean> dislike_reasons;

    public static class TagBean {
        /**
         * count : {"atten":55679}
         * tag_id : 147345
         * tag_name : 混剪
         */

        public CountBean count;
        public int tag_id;
        public String tag_name;

        public static class CountBean {
            /**
             * atten : 55679
             */

            public int atten;
        }
    }

    public static class BannerItemBean {
        /**
         * cm_mark : 0
         * hash : d360c83559586445a1c336b50b8d5ee6
         * id : 47350
         * image : http://i0.hdslb.com/bfs/archive/1ac16d4525365268edd592852e7165347d35ccb8.jpg
         * index : 1
         * request_id : 1495725192400
         * resource_id : 631
         * server_type : 0
         * title : 音乐0525
         * uri : http://www.bilibili.com/blackboard/topic/activity-ByFKsE3gW.html
         * ad_cb : CPeEARCuLxjyNSAAKAAwADi/BUIfMTQ5NTcyNTE5MjQxOHExNzJhMThhNjFhMTY2cTIxN0ji6ayBxCtSCeadreW3nuW4gloJ5rWZ5rGf55yBYgbkuK3lm71oAXAAeACAAQCIAdoUkgEMMTEyLjEwLjk1Ljgx
         * client_ip : 112.10.95.81
         * creative_id : 17015
         * is_ad_loc : true
         * src_id : 703
         * is_ad : true
         */

        public int cm_mark;
        public String hash;
        public int id;
        public String image;
        public int index;
        public String request_id;
        public int resource_id;
        public int server_type;
        public String title;
        public String uri;
        public String ad_cb;
        public String client_ip;
        public int creative_id;
        public boolean is_ad_loc;
        public int src_id;
        public boolean is_ad;
    }

    public static class DislikeReasonsBean {
        /**
         * reason_id : 4
         * reason_name : UP主:大白兔白不白
         */

        public int reason_id;
        public String reason_name;
    }
}
