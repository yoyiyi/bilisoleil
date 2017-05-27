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
     * follow_count : 5
     * follows : [{"brief":"神秘瑰丽的妖灵世界，奇奥无穷的时空妖灵之书，聂离追寻着世界的真相。美丽温柔的叶紫芸、倔强高傲的肖凝儿...","cover":"http://i0.hdslb.com/bfs/bangumi/c57c4f3a68a3df841cbbb534c407081b431ef2f7.jpg","ed_jump":5,"is_finish":"0","is_started":1,"limitGroupId":317,"new_ep":{"episode_id":"105251","episode_status":2,"index":"6","update_time":"2017-05-26 12:00:00.0"},"newest_ep_id":"105251","newest_ep_index":"6","pub_time":"2017-05-09 12:00:00","season_id":"6159","season_status":2,"squareCover":"http://i0.hdslb.com/bfs/bangumi/427394ad2c27c23d90acd1b63fa17dde110fd24a.jpg","title":"妖神记","total_count":"40","trailerAid":"-1","user_season":{"attention":"1","bp":0,"last_ep_id":"","last_ep_index":"","last_time":"0","report_ts":0},"weekday":"-1"},{"brief":"世人皆知，太古之时，万神之师\u201c元始天尊\u201d以一颗\u201c混元玄石\u201d开天辟地，但一场突如其来的天劫却导致封印天...","cover":"http://i0.hdslb.com/bfs/bangumi/1cfffd708dc5ac6b908f7022970f2feb1b5494d0.jpg","ed_jump":5,"is_finish":"0","is_started":1,"limitGroupId":317,"new_ep":{"episode_id":"105244","episode_status":2,"index":"6","update_time":"2017-05-26 12:00:00.0"},"newest_ep_id":"105244","newest_ep_index":"6","pub_time":"2017-04-25 00:00:00","season_id":"5848","season_status":2,"squareCover":"http://i0.hdslb.com/bfs/bangumi/5b05af19ab5a16ad473399057bffc253bc589d55.jpg","title":"太乙仙魔录之灵飞纪 第二季","total_count":"-1","trailerAid":"8877115","user_season":{"attention":"1","bp":0,"last_ep_id":"","last_ep_index":"","last_time":"0","report_ts":0},"weekday":"2"},{"brief":"加贺见一也有着一条母亲留给他的遗物「樱花腰带」，但在某天，腰带竟然变身成一位穿和服的美少女桐叶，并理...","cover":"http://i0.hdslb.com/bfs/bangumi/e362e37b61a11a6808ff7da971f6f8c7ea256301.jpg","ed_jump":5,"is_finish":"0","is_started":1,"limitGroupId":317,"new_ep":{"episode_id":"103182","episode_status":2,"index":"8","update_time":"2017-05-22 00:00:02.0"},"newest_ep_id":"103182","newest_ep_index":"8","pub_time":"2017-04-02 21:00:00","season_id":"5988","season_status":2,"squareCover":"http://i0.hdslb.com/bfs/bangumi/05b32e49d9d0572e54ee2b549e176d9a51ec9466.jpg","title":"怪怪守护神","total_count":"12","trailerAid":"-1","user_season":{"attention":"1","bp":0,"last_ep_id":"","last_ep_index":"","last_time":"0","report_ts":0},"weekday":"1"}]
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
         * user_season : {"attention":"1","bp":0,"last_ep_id":"","last_ep_index":"","last_time":"0","report_ts":0}
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
    }
}
