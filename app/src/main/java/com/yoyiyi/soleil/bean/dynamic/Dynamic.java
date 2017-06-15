package com.yoyiyi.soleil.bean.dynamic;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/31 10:40
 * 描述:动态
 */

public class Dynamic {

    public List<ItemBean> item;

    public static class ItemBean {
        public int isRecent;
        public int position;//折叠的位置

        /**
         * title : 【炒鸡饿搬运】【Tasty】超简单巧克力甜甜圈
         * cover : http://i1.hdslb.com/bfs/archive/656d2dface08d8a2a2864f1c9af90141a6ba3721.jpg
         * uri : bilibili://video/10962203
         * param : 10962203
         * goto : av
         * desc : YouTube
         * 原视频：https://www.youtube.com/watch?v=VcjmqrCJYm4
         * 来源：Tasty
         * play : 45
         * danmaku : 5
         * reply : 2
         * favorite : 5
         * tid : 76
         * tname : 美食圈
         * tag : {"tag_id":1207642,"tag_name":"美食圈","count":{"atten":40739}}
         * ctime : 1496194271
         * duration : 83
         * mid : 12617707
         * name : 炒鸡饿吃苹果还是饿
         * face : http://i2.hdslb.com/bfs/face/c984a7049d210b1079df470611f6cc04eb3e9338.jpg
         * is_atten : 1
         * recent_count : 6
         * recent : [{"title":"【炒鸡饿搬运】【Tasty】脆皮米果炸鸡","cover":"http://i2.hdslb.com/bfs/archive/7b2c9c48b15476ed345de5ba32b2134c89fbd198.jpg","uri":"bilibili://video/10959798","param":"10959798","goto":"av","desc":"YouTube\n原视频： https://www.youtube.com/watch?v=1xn2l1uUQEU&amp;t=0s\n来源：Tasty Japan","play":138,"danmaku":2,"reply":3,"favorite":13,"tid":76,"tname":"美食圈","tag":{"tag_id":1207642,"tag_name":"美食圈","count":{"atten":40739}},"ctime":1496176745,"duration":43,"mid":12617707,"name":"炒鸡饿吃苹果还是饿","face":"http://i2.hdslb.com/bfs/face/c984a7049d210b1079df470611f6cc04eb3e9338.jpg","is_atten":1},{"title":"【炒鸡饿搬运】【Tasty】用章鱼烧机器制作油炸豆腐团","cover":"http://i1.hdslb.com/bfs/archive/5954b84b41c019086f9fdb51020391dd677d301c.jpg","uri":"bilibili://video/10959651","param":"10959651","goto":"av","desc":"YouTube\n原视频： https://www.youtube.com/watch?v=nn7jm6AKzII&amp;t=0s\n来源：Tasty Japan","play":85,"favorite":8,"tid":76,"tname":"美食圈","tag":{"tag_id":1207642,"tag_name":"美食圈","count":{"atten":40739}},"ctime":1496176669,"duration":49,"mid":12617707,"name":"炒鸡饿吃苹果还是饿","face":"http://i2.hdslb.com/bfs/face/c984a7049d210b1079df470611f6cc04eb3e9338.jpg","is_atten":1},{"title":"【耳骚料理ASMR】耳机党福利！香蕉巧克力蛋糕卷","cover":"http://i0.hdslb.com/bfs/archive/8450d4ddfca0e990bdeb66b02afca5bcfb4fde84.jpg","uri":"bilibili://video/10959768","param":"10959768","goto":"av","desc":"YouTube\n转载自YouTube\n原po：cooking tree\n原标题：달콤한 바나나가 통으로! 바나나 초코 롤케이크 만들기 : Banana chocolate roll cake Recipe : バナナロールケーキ -Cookingtree쿠킹트리","play":90,"reply":1,"favorite":16,"share":1,"tid":174,"tname":"其他","tag":{"tag_id":1207642,"tag_name":"美食圈","count":{"atten":40739}},"ctime":1496176610,"duration":269,"mid":12617707,"name":"炒鸡饿吃苹果还是饿","face":"http://i2.hdslb.com/bfs/face/c984a7049d210b1079df470611f6cc04eb3e9338.jpg","is_atten":1},{"title":"【炒鸡饿搬运】【Tastemade】薯片金枪鱼蛋黄酱土豆沙拉","cover":"http://i1.hdslb.com/bfs/archive/c6940c152d2db13ceaedfe80b0633be075dbbd8e.jpg","uri":"bilibili://video/10959685","param":"10959685","goto":"av","desc":"YouTube\n原视频：https://www.youtube.com/watch?v=UmhtavyZAlk&amp;t=0s\n来源：tastemade","play":94,"reply":3,"favorite":12,"coin":1,"tid":76,"tname":"美食圈","tag":{"tag_id":1207642,"tag_name":"美食圈","count":{"atten":40739}},"ctime":1496176167,"duration":47,"mid":12617707,"name":"炒鸡饿吃苹果还是饿","face":"http://i2.hdslb.com/bfs/face/c984a7049d210b1079df470611f6cc04eb3e9338.jpg","is_atten":1},{"title":"【炒鸡饿搬运】【Tastemade】多彩缤纷的小可爱番茄芝士蛋糕","cover":"http://i1.hdslb.com/bfs/archive/6a939c97b5c8f0bf29900c02806cb4948bef66f1.jpg","uri":"bilibili://video/10959599","param":"10959599","goto":"av","desc":"YouTube\n原视频： https://www.youtube.com/watch?v=4-uKNM7vmYs&amp;t=0s\n来源：tastemade","play":156,"reply":4,"favorite":26,"tid":76,"tname":"美食圈","tag":{"tag_id":1207642,"tag_name":"美食圈","count":{"atten":40739}},"ctime":1496175748,"duration":78,"mid":12617707,"name":"炒鸡饿吃苹果还是饿","face":"http://i2.hdslb.com/bfs/face/c984a7049d210b1079df470611f6cc04eb3e9338.jpg","is_atten":1},{"title":"【一分钟快手料理】创新料理！饺子皮生煎章鱼烧！","cover":"http://i1.hdslb.com/bfs/archive/e1835322eb741ce520888030e6a0ca16bd1a0932.jpg","uri":"bilibili://video/10959530","param":"10959530","goto":"av","desc":"YouTube\n原视频： https://www.youtube.com/watch?v=BKSOKksjgi4&amp;t=0s\n来源：mogoo [もぐー]","play":174,"danmaku":1,"reply":4,"favorite":11,"tid":76,"tname":"美食圈","tag":{"tag_id":1207642,"tag_name":"美食圈","count":{"atten":40739}},"ctime":1496175265,"duration":46,"mid":12617707,"name":"炒鸡饿吃苹果还是饿","face":"http://i2.hdslb.com/bfs/face/c984a7049d210b1079df470611f6cc04eb3e9338.jpg","is_atten":1}]
         * coin : 5
         * share : 1
         * count : 40
         * type : 2
         * index : 7
         * index_title : 求你 帮帮我
         * updates : 107005
         */

        public String title;
        public String cover;
        public String uri;
        public String param;
        @SerializedName("goto")
        public String gotoX;
        public String desc;
        public int play;
        public int danmaku;
        public int reply;
        public int favorite;
        public int tid;
        public String tname;
        public TagBean tag;
        public long ctime;
        public int duration;
        public int mid;
        public String name;
        public String face;
        public int is_atten;
        public int recent_count;
        public int coin;
        public int share;
        public int count;
        public int type;
        public String index;
        public String index_title;
        public int updates;
        public List<RecentBean> recent;

        public static class TagBean {
            /**
             * tag_id : 1207642
             * tag_name : 美食圈
             * count : {"atten":40739}
             */

            public int tag_id;
            public String tag_name;
            public CountBean count;

            public static class CountBean {
                /**
                 * atten : 40739
                 */

                public int atten;
            }
        }

        public static class RecentBean {
            /**
             * title : 【炒鸡饿搬运】【Tasty】脆皮米果炸鸡
             * cover : http://i2.hdslb.com/bfs/archive/7b2c9c48b15476ed345de5ba32b2134c89fbd198.jpg
             * uri : bilibili://video/10959798
             * param : 10959798
             * goto : av
             * desc : YouTube
             * 原视频： https://www.youtube.com/watch?v=1xn2l1uUQEU&amp;t=0s
             * 来源：Tasty Japan
             * play : 138
             * danmaku : 2
             * reply : 3
             * favorite : 13
             * tid : 76
             * tname : 美食圈
             * tag : {"tag_id":1207642,"tag_name":"美食圈","count":{"atten":40739}}
             * ctime : 1496176745
             * duration : 43
             * mid : 12617707
             * name : 炒鸡饿吃苹果还是饿
             * face : http://i2.hdslb.com/bfs/face/c984a7049d210b1079df470611f6cc04eb3e9338.jpg
             * is_atten : 1
             * share : 1
             * coin : 1
             */

            public String title;
            public String cover;
            public String uri;
            public String param;
            @SerializedName("goto")
            public String gotoX;
            public String desc;
            public int play;
            public int danmaku;
            public int reply;
            public int favorite;
            public int tid;
            public String tname;
            public TagBeanX tag;
            public int ctime;
            public int duration;
            public int mid;
            public String name;
            public String face;
            public int is_atten;
            public int share;
            public int coin;

            public static class TagBeanX {
                /**
                 * tag_id : 1207642
                 * tag_name : 美食圈
                 * count : {"atten":40739}
                 */

                public int tag_id;
                public String tag_name;
                public CountBeanX count;

                public static class CountBeanX {
                    /**
                     * atten : 40739
                     */

                    public int atten;
                }
            }
        }
    }
}
