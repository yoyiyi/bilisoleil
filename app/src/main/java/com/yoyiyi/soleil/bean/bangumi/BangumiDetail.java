package com.yoyiyi.soleil.bean.bangumi;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/10 14:39
 * 描述:番剧详情界面
 */
public class BangumiDetail {
    //  https://bangumi.bilibili.com/api/season_v5?access_key=ccfbb1b10ce8ab8418a2e00b9ca9a3a0&appkey=1d8b6e7d45233436&build=505000&mobi_app=android&platform=android&season_id=6066&ts=1497169313&type=bangumi&sign=c6796f6ea4a6cae28a4d8fc555fde2da
    /**
     * actor : [{"actor":"林美秀","actor_id":0,"role":"小奇"},{"actor":"四刀辉彰","actor_id":0,"role":"洋平"}]
     * alias : こねこのチー ポンポンらー大冒険,甜甜起司猫,起司猫,甜甜私房猫 第三季
     * allow_bp : 1
     * allow_download : 0
     * area : 日本
     * arealimit : 0
     * bangumi_id : 727
     * bangumi_title : 甜甜私房猫
     * brief : 中配版由北斗企鹅工作室配音。描述一只黑灰斑纹的小猫跟丢母亲又找不到回家的路，在筋疲力尽累瘫之际巧遇一...
     * coins : 310
     * copyright : bilibili
     * cover : http://i0.hdslb.com/bfs/bangumi/e4eaa21feb4449abe887ca50618638e953d05413.jpg
     * danmaku_count : 1672
     * ed_jump : 5
     * episodes : [{"av_id":"11233465","coins":"6","cover":"http://i0.hdslb.com/bfs/archive/69264d3d920edc4a402ee489399ca22eecdc35b1.jpg","danmaku":"18580541","episode_id":"108754","episode_status":2,"index":"19","index_title":"大黑，要巡逻","is_new":"1","is_webplay":"0","mid":"928123","page":"1","up":{},"update_time":"2017-06-11 12:00:03.0"},{"av_id":"11183534","coins":"6","cover":"http://i2.hdslb.com/bfs/archive/a33d2fcdf23237c6f64839b65443ce2efca06c39.jpg","danmaku":"18502719","episode_id":"108752","episode_status":2,"index":"18","index_title":"小奇、当教练","is_webplay":"0","mid":"928123","page":"1","up":{},"update_time":"2017-06-09 12:00:03.0"},{"av_id":"11051889","coins":"6","cover":"http://i1.hdslb.com/bfs/archive/644d43fb82e1c61c058e194717de58b8c73cfdc8.jpg","danmaku":"18290105","episode_id":"108133","episode_status":2,"index":"17","index_title":"小奇，又又学习","is_webplay":"0","mid":"928123","page":"1","up":{},"update_time":"2017-06-04 12:00:02.0"},{"av_id":"11009671","coins":"6","cover":"http://i1.hdslb.com/bfs/archive/9e90370c70231523fa02010fc8ec54363f5c2374.jpg","danmaku":"18221908","episode_id":"108132","episode_status":2,"index":"16","index_title":"小奇、要工作","is_webplay":"0","mid":"928123","page":"1","up":{},"update_time":"2017-06-02 12:00:02.0"},{"av_id":"10880355","coins":"10","cover":"http://i1.hdslb.com/bfs/archive/4e9a5f2eac2ff26d5adee8d53f0d2a95ed51c6f2.jpg","danmaku":"18015450","episode_id":"107658","episode_status":2,"index":"15","index_title":"小奇，又学习","is_webplay":"0","mid":"928123","page":"1","up":{},"update_time":"2017-05-28 12:07:02.0"},{"av_id":"10831038","coins":"10","cover":"http://i2.hdslb.com/bfs/archive/ea494e65d13522fc515019f100759ecc9208035a.jpg","danmaku":"17873480","episode_id":"107657","episode_status":2,"index":"14","index_title":"小奇、要暖和","is_webplay":"0","mid":"928123","page":"1","up":{},"update_time":"2017-05-26 12:00:02.0"},{"av_id":"10716677","coins":"12","cover":"http://i2.hdslb.com/bfs/archive/195ac2834e4c5415141faba03735c82882e94ded.jpg","danmaku":"17682923","episode_id":"107004","episode_status":2,"index":"13","index_title":"小奇，回来了","is_webplay":"0","mid":"928123","page":"1","up":{},"update_time":"2017-05-21 12:00:02.0"},{"av_id":"10661305","coins":"10","cover":"http://i2.hdslb.com/bfs/archive/84779956e6466153f72b6d54145ddf837b7ea8f8.jpg","danmaku":"17596927","episode_id":"107003","episode_status":2,"index":"12","index_title":"小奇，去好地方","is_webplay":"0","mid":"928123","page":"1","up":{},"update_time":"2017-05-19 12:00:02.0"},{"av_id":"10549012","coins":"11","cover":"http://i1.hdslb.com/bfs/archive/f3e78eff1fec61c7e37a8170beac789e1616c3cb.jpg","danmaku":"17416310","episode_id":"106290","episode_status":2,"index":"11","index_title":"小奇，出门","is_webplay":"0","mid":"928123","page":"1","up":{},"update_time":"2017-05-14 12:00:02.0"},{"av_id":"10494123","coins":"8","cover":"http://i0.hdslb.com/bfs/archive/8ca68ac8b4b2e21ed399a7319b7fa8adebf5ae60.jpg","danmaku":"17329563","episode_id":"106289","episode_status":2,"index":"10","index_title":"小奇，遇见鹦鹉","is_webplay":"0","mid":"928123","page":"1","up":{},"update_time":"2017-05-12 12:00:02.0"},{"av_id":"10378572","coins":"10","cover":"http://i1.hdslb.com/bfs/archive/55ef301ab2c1c51c84ca4e52f08944d606915685.jpg","danmaku":"17141538","episode_id":"105083","episode_status":2,"index":"9","index_title":"小奇，比试","is_webplay":"0","mid":"928123","page":"1","up":{},"update_time":"2017-05-07 12:00:03.0"},{"av_id":"10322929","coins":"8","cover":"http://i2.hdslb.com/bfs/archive/0d0525b0a1f4e04f175f73c8109522df5f61015b.jpg","danmaku":"17054699","episode_id":"105082","episode_status":2,"index":"8","index_title":"小奇，要冒险","is_webplay":"0","mid":"928123","page":"1","up":{},"update_time":"2017-05-05 12:02:02.0"},{"av_id":"10198610","coins":"18","cover":"http://i1.hdslb.com/bfs/archive/62926a462d742f956c7a5e49c4799664ecac7d32.jpg","danmaku":"16849196","episode_id":"104932","episode_status":2,"index":"7","index_title":"小奇，野营","is_webplay":"0","mid":"928123","page":"1","up":{},"update_time":"2017-04-30 12:00:00.0"},{"av_id":"10147216","coins":"14","cover":"http://i1.hdslb.com/bfs/archive/b0aa148da8dd168eb8a540cf41dc70a78bfc7cbf.jpg","danmaku":"16765765","episode_id":"104931","episode_status":2,"index":"6","index_title":"小奇，被刷毛","is_webplay":"0","mid":"928123","page":"1","up":{},"update_time":"2017-04-28 12:01:02.0"},{"av_id":"10036211","coins":"19","cover":"http://i0.hdslb.com/bfs/archive/a3e32d2825a5b1a29208bc6713976b84117a2363.jpg","danmaku":"16587085","episode_id":"104243","episode_status":2,"index":"5","index_title":"小奇，过万圣节","is_webplay":"0","mid":"928123","page":"1","up":{},"update_time":"2017-04-23 12:00:02.0"},{"av_id":"9979397","coins":"16","cover":"http://i2.hdslb.com/bfs/archive/a6fe346ddc04ef3bf4ba3cd65b60943d328c41bd.jpg","danmaku":"16497147","episode_id":"104242","episode_status":2,"index":"4","index_title":"小奇，吃奶酪","is_webplay":"0","mid":"928123","page":"1","up":{},"update_time":"2017-04-21 12:00:02.0"},{"av_id":"9871622","coins":"23","cover":"http://i1.hdslb.com/bfs/archive/ab0f1f5e2e45524f9939a8665c0835be478430a2.jpg","danmaku":"16319807","episode_id":"104065","episode_status":2,"index":"3","index_title":"小奇，要学习","is_webplay":"0","mid":"928123","page":"1","up":{},"update_time":"2017-04-16 12:00:02.0"},{"av_id":"9825634","coins":"43","cover":"http://i0.hdslb.com/bfs/archive/c5637914b8495ec63b075ca6bb96eec8d56319b5.jpg","danmaku":"16245293","episode_id":"103954","episode_status":2,"index":"2","index_title":"小奇，被阻止了","is_webplay":"0","mid":"928123","page":"1","up":{},"update_time":"2017-04-14 12:00:03.0"},{"av_id":"9716141","coins":"74","cover":"http://i0.hdslb.com/bfs/archive/d9ae122e067a673072c939a1a63349231fb23ad5.jpg","danmaku":"16058191","episode_id":"103953","episode_status":2,"index":"1","index_title":"小奇、回来啦","is_webplay":"0","mid":"928123","page":"1","up":{},"update_time":"2017-04-09 12:00:02.0"}]
     * evaluate : 中配版由北斗企鹅工作室配音。描述一只黑灰斑纹的小猫跟丢母亲又找不到回家的路，在筋疲力尽累瘫之际巧遇一个跌倒的小男孩，从此由男孩一家暂时照顾。因男孩家为禁止饲养宠物的公寓，一家人还得费尽心机不让邻居发现小猫的存在，只是偏偏一直找不到饲主又和小猫日久生情。在经历某些事情后，一家人终于搬到新公寓展开全新的生活。
     * favorites : 6572
     * has_unfollow : 0
     * is_finish : 0
     * is_guide_follow : 1
     * jp_title : こねこのチー ポンポンらー大冒険
     * limit_info : {"code":0,"data":{"down":0,"play":2},"message":""}
     * newest_ep_id : 108754
     * newest_ep_index : 19
     * play_count : 241198
     * pub_time : 2017-04-09 12:00:00
     * rank : {"list":[{"face":"http://i1.hdslb.com/bfs/face/88da15affaa670c507769395529abf7b128eb36d.jpg","uid":"749010","uname":"ruanlis"},{"face":"http://i2.hdslb.com/bfs/face/c3c46064847f822b63700b3a7feb784896e61d01.jpg","uid":"4672892","uname":"DesideRatus"},{"face":"http://i0.hdslb.com/bfs/face/fa11da3b651ecbb2422feb1fbf02e4d3c40eec4c.jpg","uid":"555152","uname":"gaborsun"},{"face":"http://static.hdslb.com/images/member/noface.gif","uid":"45365953","uname":"郁闷的团子"}],"total_bp_count":119,"week_bp_count":21}
     * related_seasons : []
     * rights : {"arealimit":0,"is_started":1}
     * season_id : 6066
     * season_status : 2
     * season_title : 中配版
     * seasons : [{"bangumi_id":"727","cover":"http://i0.hdslb.com/bfs/bangumi/29dfb0679a873a44e2609cc7bca31f6a2a3791b6.jpg","is_finish":"1","newest_ep_id":"34146","newest_ep_index":"104","season_id":"1119","season_status":2,"title":"第一季","total_count":"104"},{"bangumi_id":"727","cover":"http://i0.hdslb.com/bfs/bangumi/8d5f4764d793629b952625278bae69eebfd528a0.jpg","is_finish":"1","newest_ep_id":"34360","newest_ep_index":"104","season_id":"1772","season_status":2,"title":"第二季","total_count":"104"},{"bangumi_id":"727","cover":"http://i0.hdslb.com/bfs/bangumi/e4eaa21feb4449abe887ca50618638e953d05413.jpg","is_finish":"0","is_new":"1","newest_ep_id":"104073","newest_ep_index":"36","season_id":"5563","season_status":2,"title":"第三季","total_count":"12"},{"bangumi_id":"727","cover":"http://i0.hdslb.com/bfs/bangumi/e4eaa21feb4449abe887ca50618638e953d05413.jpg","is_finish":"0","is_new":"1","newest_ep_id":"108754","newest_ep_index":"19","season_id":"6066","season_status":2,"title":"中配版","total_count":"51"},{"bangumi_id":"727","cover":"http://i0.hdslb.com/bfs/bangumi/4f15b9e37aa99750e5d7bcb9d8b5d4f3bad0c227.jpg","is_finish":"1","newest_ep_index":"-1","season_id":"3774","season_status":2,"title":"OAD","total_count":"1"}]
     * share_url : http://bangumi.bilibili.com/anime/6066/
     * squareCover : http://i0.hdslb.com/bfs/bangumi/56fa9a3e45129f7387fa88c9a05b9fad51cef4fc.jpg
     * staff : 原作：こなみかなた
     * 音乐：近藤研二
     * 剪辑：伊藤潤一
     * 音响监督：中嶋聡彦
     * 音响：HALF H・P STUDIO
     * 副导演：沓名健一
     * 官方网站：http：//chissweethome.com/
     * 播放电视台：テレビ東京
     * Copyright：©こなみかなた・講談社／こねこのチー製作委員会
     * 总监修：北本かおり
     * 导演：草野公紀
     * 系列构成：千葉美鈴
     * 人物设计：皆川恵美里、鴻巣智
     * 艺术监督：梅田年哉
     * 音效：山田香織
     * 动画制作：マーザ・アニメーションプラネット
     * tag2s : []
     * tags : [{"cover":"http://i0.hdslb.com/bfs/bangumi/596fc0d465852dbda114dffc931d74c8342af3f6.jpg","tag_id":"16","tag_name":"日常"},{"cover":"http://i0.hdslb.com/bfs/bangumi/2dd9492da6692e5254e0240d10ea23f4cfec3461.png","tag_id":"81","tag_name":"萌系"}]
     * title : 甜甜私房猫 第三季 中配版
     * total_count : 51
     * user_season : {"attention":"0","bp":0,"last_ep_id":"","last_ep_index":"","last_time":"0","report_ts":0}
     * viewRank : 0
     * vip_quality : 1
     * watchingCount : 0
     * weekday : -1
     */

    public String alias;
    public String allow_bp;
    public String allow_download;
    public String area;
    public int arealimit;
    public String bangumi_id;
    public String bangumi_title;
    public String brief;
    public String coins;
    public String copyright;
    public String cover;
    public String danmaku_count;
    public int ed_jump;
    public String evaluate;
    public String favorites;
    public int has_unfollow;
    public String is_finish;
    public int is_guide_follow;
    public String jp_title;
    public LimitInfoBean limit_info;
    public String newest_ep_id;
    public String newest_ep_index;
    public String play_count;
    public String pub_time;
    public RankBean rank;
    public RightsBean rights;
    public String season_id;
    public int season_status;
    public String season_title;
    public String share_url;
    public String squareCover;
    public String staff;
    public String title;
    public String total_count;
    public UserSeasonBean user_season;
    public int viewRank;
    public int vip_quality;
    public String watchingCount;
    public String weekday;
    public List<ActorBean> actor;
    public List<EpisodesBean> episodes;
    public List<?> related_seasons;
    public List<SeasonsBean> seasons;
    public List<?> tag2s;
    public List<TagsBean> tags;

    public static class LimitInfoBean {
        /**
         * code : 0
         * data : {"down":0,"play":2}
         * message :
         */

        public int code;
        public DataBean data;
        public String message;

        public static class DataBean {
            /**
             * down : 0
             * play : 2
             */

            public int down;
            public int play;
        }
    }

    public static class RankBean {
        /**
         * list : [{"face":"http://i1.hdslb.com/bfs/face/88da15affaa670c507769395529abf7b128eb36d.jpg","uid":"749010","uname":"ruanlis"},{"face":"http://i2.hdslb.com/bfs/face/c3c46064847f822b63700b3a7feb784896e61d01.jpg","uid":"4672892","uname":"DesideRatus"},{"face":"http://i0.hdslb.com/bfs/face/fa11da3b651ecbb2422feb1fbf02e4d3c40eec4c.jpg","uid":"555152","uname":"gaborsun"},{"face":"http://static.hdslb.com/images/member/noface.gif","uid":"45365953","uname":"郁闷的团子"}]
         * total_bp_count : 119
         * week_bp_count : 21
         */

        public int total_bp_count;
        public int week_bp_count;
        public List<ListBean> list;

        public static class ListBean {
            /**
             * face : http://i1.hdslb.com/bfs/face/88da15affaa670c507769395529abf7b128eb36d.jpg
             * uid : 749010
             * uname : ruanlis
             */

            public String face;
            public String uid;
            public String uname;
        }
    }

    public static class RightsBean {
        /**
         * arealimit : 0
         * is_started : 1
         */

        public int arealimit;
        public int is_started;
    }

    public static class UserSeasonBean {
        /**
         * attention : 0
         * bp : 0
         * last_ep_id :
         * last_ep_index :
         * last_time : 0
         * report_ts : 0
         */

        public String attention;
        public int bp;
        public String last_ep_id;
        public String last_ep_index;
        public String last_time;
        public int report_ts;
    }

    public static class ActorBean {
        /**
         * actor : 林美秀
         * actor_id : 0
         * role : 小奇
         */

        public String actor;
        public int actor_id;
        public String role;
    }

    public static class EpisodesBean {
        /**
         * av_id : 11233465
         * coins : 6
         * cover : http://i0.hdslb.com/bfs/archive/69264d3d920edc4a402ee489399ca22eecdc35b1.jpg
         * danmaku : 18580541
         * episode_id : 108754
         * episode_status : 2
         * index : 19
         * index_title : 大黑，要巡逻
         * is_new : 1
         * is_webplay : 0
         * mid : 928123
         * page : 1
         * up : {}
         * update_time : 2017-06-11 12:00:03.0
         */

        public String av_id;
        public String coins;
        public String cover;
        public String danmaku;
        public String episode_id;
        public int episode_status;
        public String index;
        public String index_title;
        public String is_new;
        public String is_webplay;
        public String mid;
        public String page;
        public UpBean up;
        public String update_time;

        public static class UpBean {
        }
    }

    public static class SeasonsBean {
        /**
         * bangumi_id : 727
         * cover : http://i0.hdslb.com/bfs/bangumi/29dfb0679a873a44e2609cc7bca31f6a2a3791b6.jpg
         * is_finish : 1
         * newest_ep_id : 34146
         * newest_ep_index : 104
         * season_id : 1119
         * season_status : 2
         * title : 第一季
         * total_count : 104
         * is_new : 1
         */

        public String bangumi_id;
        public String cover;
        public String is_finish;
        public String newest_ep_id;
        public String newest_ep_index;
        public String season_id;
        public int season_status;
        public String title;
        public String total_count;
        public String is_new;
    }

    public static class TagsBean {
        /**
         * cover : http://i0.hdslb.com/bfs/bangumi/596fc0d465852dbda114dffc931d74c8342af3f6.jpg
         * tag_id : 16
         * tag_name : 日常
         */

        public String cover;
        public String tag_id;
        public String tag_name;
    }
}
