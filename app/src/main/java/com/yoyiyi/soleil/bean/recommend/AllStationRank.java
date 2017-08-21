package com.yoyiyi.soleil.bean.recommend;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/5 20:54
 * 描述:全站排行
 */
public class AllStationRank {

    public RankBean rank;

    public static class RankBean {
        public List<ListBean> list;


        /**
         * aid : 6482189
         * typename : 鬼畜调教
         * title : 【高能Rap】你从未看过的家有儿女
         * subtitle :
         * play : 642497
         * review : 48
         * video_review : 12428
         * favorites : 43142
         * mid : 375375
         * author : 伊丽莎白鼠
         * description : 花了2个多月终于把这个大坑填完了，顺便也把小时候很喜欢的家有儿女复习了一遍，果然小时候还是太纯洁，长大之后发现了许多有意思的地方，       *
         * 值得当代年轻人细细回味学习。只可惜自己已经不如晚年，不知道下次做鬼畜又是什么时候了，不得不说，做鬼畜真有意思。
         * <p>
         * BGM：Unity - TheFatRat
         * <p>
         * 营销号简直要逼死我，这次上了动态水印，转载请勿遮挡水印并注明出处。
         * create : 2016-10-01 13:52
         * pic : http://i1.hdslb.com/bfs/archive/4e812d44fcfd9fcadcaf1195d28eb24bc63eaccc.jpg_320x200.jpg
         * coins : 65355
         * duration : 2:30
         * badgepay : false
         * pts : 880957
         */
        public static class ListBean {

            public int aid;

            public String typename;

            public String title;

            public String subtitle;

            public String play;

            public int review;

            public int video_review;

            public int favorites;

            public int mid;

            public String author;

            public String description;

            public String create;

            public String pic;

            public int coins;

            public String duration;

            public boolean badgepay;

            public int pts;

        }
    }
}
