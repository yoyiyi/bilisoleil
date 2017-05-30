package com.yoyiyi.soleil.bean.chase;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/27 18:04
 * 描述:推荐番剧
 */

public class RecommendBangumi {


    /**
     * ad : [{"img":"http://i0.hdslb.com/bfs/bangumi/095df0181442362ac1bc445d7f542eb6bf66f7da.jpg","index":1,"link":"http://bangumi.bilibili.com/anime/5997","title":"黄漫老师"}]
     * recommend_cn : {"foot":[{"cover":"http://i0.hdslb.com/bfs/bangumi/21de47368b07316ae9a0ea5ef62d9cd53d4b82d4.jpg","cursor":1495900800158,"desc":"杨敬华再次醒来后发现自己变成年轻了10岁的水灵少年！但这个自称\u201c阳冥司\u201d的白发帅哥却说\u201c你已经死了。少年，和我签订契约吗？\u201d","id":4985,"is_new":1,"link":"http://bangumi.bilibili.com/anime/5102","onDt":"2017-05-28 00:00:00","title":"少年，和我签订契约吗？"}],"recommend":[{"cover":"http://i0.hdslb.com/bfs/bangumi/465effa90d0dc3d916fe9d51a73ec066c831bce9.jpg","favourites":"523329","is_auto":0,"is_finish":0,"is_started":1,"last_time":1495785600,"newest_ep_index":"9","pub_time":1490889600,"season_id":5856,"season_status":2,"title":"银之守墓人","total_count":-1,"watching_count":0,"badge":"付费抢先"},{"badge":"付费抢先","cover":"http://i0.hdslb.com/bfs/bangumi/958cffa5054239ae9695469708949de0caaeabe4.jpg","favourites":"2857653","is_auto":0,"is_finish":0,"is_started":1,"last_time":1495770649,"newest_ep_index":"9","pub_time":1491494400,"season_id":5852,"season_status":7,"title":"全职高手","total_count":-1,"watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/a7a97abdf146427289d3c752e17d0c25e1c32f2b.jpg","favourites":"10829","is_auto":0,"is_finish":0,"is_started":1,"last_time":1495764000,"newest_ep_index":"1","pub_time":1495728000,"season_id":6186,"season_status":2,"title":"食神魂","total_count":12,"watching_count":0}]}
     * recommend_jp : {"foot":[{"cover":"http://i0.hdslb.com/bfs/bangumi/608d2d8ca81cee746088bacd6d7b145a508e10df.jpg","cursor":1495879200238,"desc":"弐瓶勉X东亚重工动画制作局","id":4914,"is_new":1,"link":"http://www.bilibili.com/video/av10700614/","onDt":"2017-05-27 18:00:00","reply":"921","title":"【周末剧场】BLAME!"}],"recommend":[{"cover":"http://i0.hdslb.com/bfs/bangumi/f0841da0acbb37bfd2d51700cc2a6c4dfa045295.jpg","favourites":"508376","is_auto":0,"is_finish":0,"is_started":1,"last_time":1495917002,"newest_ep_index":"9","pub_time":1491062400,"season_id":5970,"season_status":2,"title":"自由之翼 第二季（僅台灣地區）","total_count":12,"watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/a223b1376633625be1cd214c34d8bf34a1e03770.jpg","favourites":"2214504","is_auto":0,"is_finish":0,"is_started":1,"last_time":1495904400,"newest_ep_index":"8","pub_time":1491667200,"season_id":5997,"season_status":2,"title":"埃罗芒阿老师","total_count":12,"watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/3944fe0b84a5763cde6b0573773b89ba86b4321d.jpg","favourites":"1373787","is_auto":0,"is_finish":0,"is_started":1,"last_time":1495900802,"newest_ep_index":"8","pub_time":1491667200,"season_id":5998,"season_status":2,"title":"Re:CREATORS","total_count":22,"watching_count":0}]}
     */

    public RecommendCnBean recommend_cn;
    public RecommendJpBean recommend_jp;
    public List<AdBean> ad;

    public static class RecommendCnBean {
        public List<FootBean> foot;
        public List<RecommendBean> recommend;

        public static class FootBean {
            /**
             * cover : http://i0.hdslb.com/bfs/bangumi/21de47368b07316ae9a0ea5ef62d9cd53d4b82d4.jpg
             * cursor : 1495900800158
             * desc : 杨敬华再次醒来后发现自己变成年轻了10岁的水灵少年！但这个自称“阳冥司”的白发帅哥却说“你已经死了。少年，和我签订契约吗？”
             * id : 4985
             * is_new : 1
             * link : http://bangumi.bilibili.com/anime/5102
             * onDt : 2017-05-28 00:00:00
             * title : 少年，和我签订契约吗？
             */

            public String cover;
            public long cursor;
            public String desc;
            public int id;
            public int is_new;
            public String link;
            public String onDt;
            public String title;
        }

        public static class RecommendBean {
            /**
             * cover : http://i0.hdslb.com/bfs/bangumi/465effa90d0dc3d916fe9d51a73ec066c831bce9.jpg
             * favourites : 523329
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
             * cover : http://i0.hdslb.com/bfs/bangumi/608d2d8ca81cee746088bacd6d7b145a508e10df.jpg
             * cursor : 1495879200238
             * desc : 弐瓶勉X东亚重工动画制作局
             * id : 4914
             * is_new : 1
             * link : http://www.bilibili.com/video/av10700614/
             * onDt : 2017-05-27 18:00:00
             * reply : 921
             * title : 【周末剧场】BLAME!
             */

            public String cover;
            public long cursor;
            public String desc;
            public int id;
            public int is_new;
            public String link;
            public String onDt;
            public String reply;
            public String title;
        }

        public static class RecommendBeanX {
            /**
             * cover : http://i0.hdslb.com/bfs/bangumi/f0841da0acbb37bfd2d51700cc2a6c4dfa045295.jpg
             * favourites : 508376
             * is_auto : 0
             * is_finish : 0
             * is_started : 1
             * last_time : 1495917002
             * newest_ep_index : 9
             * pub_time : 1491062400
             * season_id : 5970
             * season_status : 2
             * title : 自由之翼 第二季（僅台灣地區）
             * total_count : 12
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

    public static class AdBean {
        /**
         * img : http://i0.hdslb.com/bfs/bangumi/095df0181442362ac1bc445d7f542eb6bf66f7da.jpg
         * index : 1
         * link : http://bangumi.bilibili.com/anime/5997
         * title : 黄漫老师
         */

        public String img;
        public int index;
        public String link;
        public String title;
    }
}
