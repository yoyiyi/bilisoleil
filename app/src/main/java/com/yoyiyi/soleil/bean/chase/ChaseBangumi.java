package com.yoyiyi.soleil.bean.chase;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/27 18:01
 * 描述:追番
 */

public class ChaseBangumi {

    /**
     * delay_notice : []
     * follow_count : 8
     * follows : [{"brief":"神秘瑰丽的妖灵世界，奇奥无穷的时空妖灵之书，聂离追寻着世界的真相。美丽温柔的叶紫芸、倔强高傲的肖凝儿...","cover":"http://i0.hdslb.com/bfs/bangumi/c57c4f3a68a3df841cbbb534c407081b431ef2f7.jpg","ed_jump":5,"is_finish":"0","is_started":1,"limitGroupId":317,"new_ep":{"episode_id":"105251","episode_status":2,"index":"6","update_time":"2017-05-26 12:00:00.0"},"newest_ep_id":"105251","newest_ep_index":"6","pub_time":"2017-05-09 12:00:00","season_id":"6159","season_status":2,"squareCover":"http://i0.hdslb.com/bfs/bangumi/427394ad2c27c23d90acd1b63fa17dde110fd24a.jpg","title":"妖神记","total_count":"40","trailerAid":"-1","user_season":{"attention":"1","bp":0,"last_ep_id":"105246","last_ep_index":"1","last_time":"44","report_ts":1495900198000},"weekday":"-1"},{"brief":"中华美食世界仙界与人界的平衡被神秘的异次元力量\u201c食荒者\u201d打破，中华美食陷入生死存亡危机。前任中华食神...","cover":"http://i0.hdslb.com/bfs/bangumi/a7a97abdf146427289d3c752e17d0c25e1c32f2b.jpg","ed_jump":5,"is_finish":"0","is_started":1,"limitGroupId":316,"new_ep":{"episode_id":"107349","episode_status":2,"index":"1","update_time":"2017-05-26 10:00:00.0"},"newest_ep_id":"107349","newest_ep_index":"1","pub_time":"2017-05-26 10:00:00","season_id":"6186","season_status":2,"squareCover":"http://i0.hdslb.com/bfs/bangumi/4d20aade9ea0880ec8258e9657b4eca492a14e79.jpg","title":"食神魂","total_count":"12","trailerAid":"-1","user_season":{"attention":"1","bp":0,"last_ep_id":"","last_ep_index":"","last_time":"0","report_ts":0},"weekday":"5"},{"brief":"高中生兼小说作家的\u201c和泉正宗\u201d（笔名：和泉征宗）有个家里蹲的妹妹\u201c和泉纱雾\u201d。一年前才成为家人的她，...","cover":"http://i0.hdslb.com/bfs/bangumi/a223b1376633625be1cd214c34d8bf34a1e03770.jpg","ed_jump":5,"is_finish":"0","is_started":1,"limitGroupId":340,"new_ep":{"episode_id":"103924","episode_status":2,"index":"8","update_time":"2017-05-28 01:00:00.0"},"newest_ep_id":"103924","newest_ep_index":"8","pub_time":"2017-04-09 01:00:00","season_id":"5997","season_status":2,"squareCover":"http://i0.hdslb.com/bfs/bangumi/8cc2ec4691707e94768c392c3ced37a1c3107430.jpg","title":"埃罗芒阿老师","total_count":"12","trailerAid":"-1","user_season":{"attention":"1","bp":0,"last_ep_id":"","last_ep_index":"","last_time":"0","report_ts":0},"weekday":"0"}]
     * update_count : 2
     */

    public int follow_count;
    public int update_count;
    public List<?> delay_notice;
    public List<FollowsBean> follows;

    public static class FollowsBean {
        /**
         * brief : 神秘瑰丽的妖灵世界，奇奥无穷的时空妖灵之书，聂离追寻着世界的真相。美丽温柔的叶紫芸、倔强高傲的肖凝儿...
         * cover : http://i0.hdslb.com/bfs/bangumi/c57c4f3a68a3df841cbbb534c407081b431ef2f7.jpg
         * ed_jump : 5
         * is_finish : 0
         * is_started : 1
         * limitGroupId : 317
         * new_ep : {"episode_id":"105251","episode_status":2,"index":"6","update_time":"2017-05-26 12:00:00.0"}
         * newest_ep_id : 105251
         * newest_ep_index : 6
         * pub_time : 2017-05-09 12:00:00
         * season_id : 6159
         * season_status : 2
         * squareCover : http://i0.hdslb.com/bfs/bangumi/427394ad2c27c23d90acd1b63fa17dde110fd24a.jpg
         * title : 妖神记
         * total_count : 40
         * trailerAid : -1
         * user_season : {"attention":"1","bp":0,"last_ep_id":"105246","last_ep_index":"1","last_time":"44","report_ts":1495900198000}
         * weekday : -1
         */

        public String brief;
        public String cover;
        public int ed_jump;
        public String is_finish;
        public int is_started;
        public int limitGroupId;
        public NewEpBean new_ep;
        public String newest_ep_id;
        public String newest_ep_index;
        public String pub_time;
        public String season_id;
        public int season_status;
        public String squareCover;
        public String title;
        public String total_count;
        public String trailerAid;
        public UserSeasonBean user_season;
        public String weekday;

        public static class NewEpBean {
            /**
             * episode_id : 105251
             * episode_status : 2
             * index : 6
             * update_time : 2017-05-26 12:00:00.0
             */

            public String episode_id;
            public int episode_status;
            public String index;
            public String update_time;
        }

        public static class UserSeasonBean {
            /**
             * attention : 1
             * bp : 0
             * last_ep_id : 105246
             * last_ep_index : 1
             * last_time : 44
             * report_ts : 1495900198000
             */

            public String attention;
            public int bp;
            public String last_ep_id;
            public String last_ep_index;
            public String last_time;
            public long report_ts;
        }
    }
}
