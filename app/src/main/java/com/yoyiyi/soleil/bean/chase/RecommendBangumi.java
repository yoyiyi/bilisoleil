package com.yoyiyi.soleil.bean.chase;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/27 18:04
 * 描述:推荐番剧
 */

public class RecommendBangumi {

    /**
     * ad : []
     * recommend_cn : {"foot":[{"cover":"http://i0.hdslb.com/bfs/bangumi/cbac3fc8fe52afa0d511bf314c1af51376d6ae40.jpg","cursor":1.495735320752E12,"id":4951,"is_new":1,"link":"http://www.bilibili.com/blackboard/topic/activity-H1PhfKM-b.html","onDt":"2017-05-26 02:02:00","title":"5\u202229 等你祝叶修生日快乐"}],"recommend":[{"cover":"http://i0.hdslb.com/bfs/bangumi/465effa90d0dc3d916fe9d51a73ec066c831bce9.jpg","favourites":"520779","is_auto":0,"is_finish":0,"is_started":1,"last_time":1495785600,"newest_ep_index":"9","pub_time":1490889600,"season_id":5856,"season_status":2,"title":"银之守墓人","total_count":-1,"watching_count":0,"badge":"付费抢先"},{"badge":"付费抢先","cover":"http://i0.hdslb.com/bfs/bangumi/958cffa5054239ae9695469708949de0caaeabe4.jpg","favourites":"2837498","is_auto":0,"is_finish":0,"is_started":1,"last_time":1495770649,"newest_ep_index":"9","pub_time":1491494400,"season_id":5852,"season_status":7,"title":"全职高手","total_count":-1,"watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/a7a97abdf146427289d3c752e17d0c25e1c32f2b.jpg","favourites":"7671","is_auto":0,"is_finish":0,"is_started":1,"last_time":1495764000,"newest_ep_index":"1","pub_time":1495728000,"season_id":6186,"season_status":2,"title":"食神魂","total_count":12,"watching_count":0}]}
     * recommend_jp : {"foot":[{"cover":"http://i0.hdslb.com/bfs/bangumi/408fca63b1a8787735c384a5c256a4de27c8da94.jpg","cursor":1.49579280004E12,"desc":"6月在即，7月还会远吗~","id":4967,"is_new":1,"link":"http://www.bilibili.com/blackboard/topic/activity-SyQqwNNZ-.html","onDt":"2017-05-26 18:00:00","title":"【资讯档】2017年第21周"}],"recommend":[{"cover":"http://i0.hdslb.com/bfs/bangumi/357e75a1fb3e17a80b49f60af35f5d211d639921.jpg","favourites":"3292","is_auto":0,"is_finish":0,"is_started":1,"last_time":1495831922,"newest_ep_index":"59","pub_time":1459526400,"season_id":6041,"season_status":2,"title":"暖暖日记 2nd","total_count":59,"watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/f56ef640d5f97371536f9cbb9f1a7dd14a6662e6.jpg","favourites":"73760","is_auto":0,"is_finish":0,"is_started":1,"last_time":1495820100,"newest_ep_index":"34","pub_time":1491494400,"season_id":5965,"season_status":2,"title":"忍者少女千鸟～伊势・金崎篇～","total_count":26,"watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/2298bee824a966a44b3dcff6c2f9377aa1d95fa8.jpg","favourites":"434520","is_auto":0,"is_finish":0,"is_started":1,"last_time":1495805402,"newest_ep_index":"8","pub_time":1491494400,"season_id":5993,"season_status":2,"title":"雏子的笔记","total_count":12,"watching_count":0}]}
     */

    public RecommendCnBean recommend_cn;
    public RecommendJpBean recommend_jp;
    public List<AdBean> ad;

    public static class AdBean {
        public List<BodyBean> body;
        public List<HeadBean> head;

        public static class HeadBean {
            /**
             * id : 0
             * img : http://i0.hdslb.com/bfs/bangumi/177951c41558b18bd9001c512a8ebc14ed395b60.jpg
             * link : http://bangumi.bilibili.com/anime/5576
             * pub_time : 2017-05-20 23:00:00
             * title : 喜欢上你的瞬间
             */

            public int id;
            public String img;
            public String link;
            public String pub_time;
            public String title;
        }

        public static class BodyBean {

            public String img;

            public int index;

            public String link;

            public String title;
        }
    }


    public static class RecommendCnBean {
        public List<FootBean> foot;
        public List<RecommendBean> recommend;

        public static class FootBean {
            /**
             * cover : http://i0.hdslb.com/bfs/bangumi/cbac3fc8fe52afa0d511bf314c1af51376d6ae40.jpg
             * cursor : 1.495735320752E12
             * id : 4951
             * is_new : 1
             * link : http://www.bilibili.com/blackboard/topic/activity-H1PhfKM-b.html
             * onDt : 2017-05-26 02:02:00
             * title : 5•29 等你祝叶修生日快乐
             */

            public String cover;
            public double cursor;
            public int id;
            public int is_new;
            public String link;
            public String onDt;
            public String title;
        }

        public static class RecommendBean {
            /**
             * cover : http://i0.hdslb.com/bfs/bangumi/465effa90d0dc3d916fe9d51a73ec066c831bce9.jpg
             * favourites : 520779
             * is_auto : 0
             * is_finish : 0
             * is_started : 1
             * last_time : 1495785600
             * newest_ep_index : 9
             * pub_time : 1490889600
             * season_id : 5856
             * season_status : 2
             * title : 银之守墓人
             * total_count : -1
             * watching_count : 0
             * badge : 付费抢先
             */

            public String cover;
            public String favourites;
            public int is_auto;
            public int is_finish;
            public int is_started;
            public int last_time;
            public String newest_ep_index;
            public int pub_time;
            public int season_id;
            public int season_status;
            public String title;
            public int total_count;
            public int watching_count;
            public String badge;
        }
    }

    public static class RecommendJpBean {
        public List<FootBeanX> foot;
        public List<RecommendBeanX> recommend;

        public static class FootBeanX {
            /**
             * cover : http://i0.hdslb.com/bfs/bangumi/408fca63b1a8787735c384a5c256a4de27c8da94.jpg
             * cursor : 1.49579280004E12
             * desc : 6月在即，7月还会远吗~
             * id : 4967
             * is_new : 1
             * link : http://www.bilibili.com/blackboard/topic/activity-SyQqwNNZ-.html
             * onDt : 2017-05-26 18:00:00
             * title : 【资讯档】2017年第21周
             */

            public String cover;
            public double cursor;
            public String desc;
            public int id;
            public int is_new;
            public String link;
            public String onDt;
            public String title;
        }

        public static class RecommendBeanX {
            /**
             * cover : http://i0.hdslb.com/bfs/bangumi/357e75a1fb3e17a80b49f60af35f5d211d639921.jpg
             * favourites : 3292
             * is_auto : 0
             * is_finish : 0
             * is_started : 1
             * last_time : 1495831922
             * newest_ep_index : 59
             * pub_time : 1459526400
             * season_id : 6041
             * season_status : 2
             * title : 暖暖日记 2nd
             * total_count : 59
             * watching_count : 0
             */

            public String cover;
            public String favourites;
            public int is_auto;
            public int is_finish;
            public int is_started;
            public int last_time;
            public String newest_ep_index;
            public int pub_time;
            public int season_id;
            public int season_status;
            public String title;
            public int total_count;
            public int watching_count;
        }
    }
}
