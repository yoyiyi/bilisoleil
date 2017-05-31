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
     * param : 0
     * goto : banner
     * idx : 1496197869
     * banner_item : [{"id":47954,"title":"生活0531","image":"http://i0.hdslb.com/bfs/archive/0316d456b65201d29c07c3b582c3ac5c48e6cc0d.jpg","hash":"d2ea6b8394d9073665364da3a7dc8ccb","uri":"http://www.bilibili.com/blackboard/topic/activity-S1bVTw8--.html","request_id":"1496197858463","server_type":0,"resource_id":631,"index":1,"cm_mark":0},{"id":0,"title":"碧蓝","image":"https://i0.hdslb.com/bfs/archive/559e3d6b7030dca1bb9ef2f7350b60e6fc649655.jpg","hash":"aed9daa33a476e7a441c24abc4c7dac9","uri":"http://blhx.biligame.com/h5","request_id":"1496197858507q172a18a61a110q206","creative_id":17595,"src_id":703,"is_ad_loc":true,"ad_cb":"CLuJARCtMBiQNyAAKAAwADi/BUIfMTQ5NjE5Nzg1ODUwN3ExNzJhMThhNjFhMTEwcTIwNkjLid7ixStSCeadreW3nuW4gloJ5rWZ5rGf55yBYgbkuK3lm71oAXABeACAAQCIAa8VkgEPMTI1LjEyMC4yMjUuMTc0","client_ip":"125.120.225.174","server_type":1,"resource_id":631,"index":2,"cm_mark":2},{"id":0,"title":"【深夜福利】这TM是要搞事啊！！！","image":"https://i0.hdslb.com/bfs/archive/e0b75b518221b0f59352b169a27cbbc7525b966b.jpg","hash":"aaa89e8e949ac95222e8d5bb591564f8","uri":"bilibili://video/10815497","request_id":"1496197858507q172a18a61a110q206","creative_id":17504,"src_id":704,"is_ad":true,"is_ad_loc":true,"ad_cb":"COCIARCIMBjqNiAAKAAwADjABUIfMTQ5NjE5Nzg1ODUwN3ExNzJhMThhNjFhMTEwcTIwNkjLid7ixStSCeadreW3nuW4gloJ5rWZ5rGf55yBYgbkuK3lm71oAXABeACAAQCIAbgYkgEPMTI1LjEyMC4yMjUuMTc0","click_url":"http://t.cr-nielsen.com/hat?_t=r&type=clk&hat_id=MTM3JjI0MCY4MTAwNTI2NSYxMTI1OTE3JjMxODgwMjQ3JoTy&_z=m&rnd=42547380","client_ip":"125.120.225.174","server_type":1,"resource_id":631,"index":3,"cm_mark":1},{"id":48016,"title":"弹幕问卷","image":"http://i0.hdslb.com/bfs/archive/a2daba1a34d7a19449d5447600ac4005f99d8b27.jpg","hash":"011b676d7a00486edc29510c1f6b1136","uri":"http://www.bilibili.com/blackboard/activity-rynk7IHZ-.html","request_id":"1496197858463","server_type":0,"resource_id":631,"index":4,"cm_mark":0}]
     * title : 明唐——定国篇（上）相遇
     * cover : http://i1.hdslb.com/bfs/archive/0ea061024e4aa81425d9cb84f00f8e76952020f1.jpg
     * uri : bilibili://video/10930244
     * desc : 因明唐CP玩起了剑三
     没上80级就手痒开始玩剑网三视频编辑器
     三天肝出来的视频  希望大家喜欢
     另外  重点是
     求各种段子  各种梗  各种剧情  以对白为主
     只要维持住炮哥的正点的形象就行了
     谢谢大家
     * play : 380
     * danmaku : 17
     * reply : 23
     * favorite : 25
     * coin : 17
     * share : 1
     * tid : 65
     * tname : 网络游戏
     * tag : {"tag_id":1052085,"tag_name":"明唐大法好","count":{"atten":155}}
     * dislike_reasons : [{"reason_id":4,"reason_name":"UP主:秋上君"},{"reason_id":2,"reason_name":"分区:网络游戏"},{"reason_id":3,"reason_name":"标签:明唐大法好"},{"reason_id":1,"reason_name":"不感兴趣"}]
     * ctime : 1496085629
     * duration : 173
     * mid : 28650198
     * name : 秋上君
     * face : http://static.hdslb.com/images/member/noface.gif
     * online : 2772
     * area : 单机联机
     * area_id : 1
     * open : 1496186842
     */

    public String param;
    @SerializedName("goto")
    public String gotoX;
    public int idx;
    public String title;
    public String cover;
    public String uri;
    public String desc;
    public int play;
    public int danmaku;
    public int reply;
    public int favorite;
    public int coin;
    public int share;
    public int tid;
    public String tname;
    public TagBean tag;
    public int ctime;
    public int duration;
    public int mid;
    public String name;
    public String face;
    public int online;
    public String area;
    public int area_id;
    public int open;
    public List<BannerItemBean> banner_item;
    public List<DislikeReasonsBean> dislike_reasons;

    public static class TagBean {
        /**
         * tag_id : 1052085
         * tag_name : 明唐大法好
         * count : {"atten":155}
         */

        public int tag_id;
        public String tag_name;
        public CountBean count;

        public static class CountBean {
            /**
             * atten : 155
             */

            public int atten;
        }
    }

    public static class BannerItemBean {
        /**
         * id : 47954
         * title : 生活0531
         * image : http://i0.hdslb.com/bfs/archive/0316d456b65201d29c07c3b582c3ac5c48e6cc0d.jpg
         * hash : d2ea6b8394d9073665364da3a7dc8ccb
         * uri : http://www.bilibili.com/blackboard/topic/activity-S1bVTw8--.html
         * request_id : 1496197858463
         * server_type : 0
         * resource_id : 631
         * index : 1
         * cm_mark : 0
         * creative_id : 17595
         * src_id : 703
         * is_ad_loc : true
         * ad_cb : CLuJARCtMBiQNyAAKAAwADi/BUIfMTQ5NjE5Nzg1ODUwN3ExNzJhMThhNjFhMTEwcTIwNkjLid7ixStSCeadreW3nuW4gloJ5rWZ5rGf55yBYgbkuK3lm71oAXABeACAAQCIAa8VkgEPMTI1LjEyMC4yMjUuMTc0
         * client_ip : 125.120.225.174
         * is_ad : true
         * click_url : http://t.cr-nielsen.com/hat?_t=r&type=clk&hat_id=MTM3JjI0MCY4MTAwNTI2NSYxMTI1OTE3JjMxODgwMjQ3JoTy&_z=m&rnd=42547380
         */

        public int id;
        public String title;
        public String image;
        public String hash;
        public String uri;
        public String request_id;
        public int server_type;
        public int resource_id;
        public int index;
        public int cm_mark;
        public int creative_id;
        public int src_id;
        public boolean is_ad_loc;
        public String ad_cb;
        public String client_ip;
        public boolean is_ad;
        public String click_url;
    }

    public static class DislikeReasonsBean {
        /**
         * reason_id : 4
         * reason_name : UP主:秋上君
         */

        public int reason_id;
        public String reason_name;
    }
}
