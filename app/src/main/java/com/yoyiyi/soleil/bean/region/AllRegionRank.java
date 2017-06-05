package com.yoyiyi.soleil.bean.region;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/4 22:04
 * 描述:全区排行
 */
public class AllRegionRank {

    public RankBean rank;

    public static class RankBean {
        public List<ListBean> list;

        public static class ListBean {
            /**
             * aid : 11028727
             * author : LexBurner
             * badgepay : false
             * coins : 33732
             * create : 2017-06-03 12:00
             * description : 新浪微博@LexBurner
             * duration : 11:16
             * favorites : 19262
             * mid : 777536
             * pic : http://i2.hdslb.com/bfs/archive/329920d269aec76fe55e29a14f1c15ced95e1534.jpg_320x200.jpg
             * play : 597006
             * pts : 604256
             * review : 8966
             * subtitle :
             * title : 【Lex】纪念诚哥十周年，小评后宫奇番《日在校园》
             * typename : 综合
             * video_review : 19655
             */

            public String aid;
            public String author;
            public boolean badgepay;
            public int coins;
            public String create;
            public String description;
            public String duration;
            public int favorites;
            public int mid;
            public String pic;
            public int play;
            public int pts;
            public int review;
            public String subtitle;
            public String title;
            public String typename;
            public int video_review;
        }
    }

}
