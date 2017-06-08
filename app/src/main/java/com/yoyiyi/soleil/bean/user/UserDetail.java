package com.yoyiyi.soleil.bean.user;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/10 11:42
 * 描述:用户
 */

public class UserDetail {

    /**
     * code : 0
     * card : {"mid":"185546","name":"小可儿","approve":false,"sex":"保密","rank":"10000","face":"http://i1.hdslb.com/bfs/face/5022986b528c74efadb6ab4669137214e066925c.x-png","coins":0,"DisplayRank":"1036","regtime":1312561293,"spacesta":2,"birthday":"1996-06-16","place":"上海市 长宁区","description":"","article":0,"attentions":[319291,690546,374377,186759,1296804,1318455,742564,311888,482524,264264,2695314,669173,375375,644202,7329,687883,99224,201434,2986310,542884,591541,776558,699049,149065,1284747,386004,546195,2848416,602496,3857249,525024,168598,270744,2740963,6881318,547008,1770706,1272598,667850,1643718,2731733,3173802,2853209,398510,477009,12434430,430031,122879,3947820,4385354,913497,699438,12464176,322892,1894748,777536,1532165,6927351,4391879,2101645,2735222,6997378,4548018,7661994,2152304,814450,4203935,622723,454636,2778733,231563,20771487,3097441,486183,2798449,71106,9550310,11684516,1438811,1951038,423442,391679,139905,20503549,442520,22965,27434809,688969,11758387,920713,26922,8585525,10552107,8688933,4440520,10414152,13736797,3379951,8332697,689753,500198,172683,515993,328212,61999,3226226,2470678,19285836,4431898,808171,25282560,592761,1963054,234256,6332228,4138198,7508296,6510526,14634764,346059,814727,14415563,12564758,1396558,453972,1936132,24314825,43536,2459948,25775194,1652288,282994,20484551,22986236,288239,329932],"fans":139476,"friend":135,"attention":135,"sign":"粉丝的支持是我创作的源泉。\r\n微博@小可儿有剁不光的手 粉丝群569465513 网易云音乐:小可儿spike","level_info":{"current_level":6,"current_min":28800,"current_exp":298859,"next_exp":"-"},"pendant":{"pid":0,"name":"","image":"","expire":0},"nameplate":{"nid":1,"name":"黄金殿堂","image":"http://i2.hdslb.com/bfs/face/82896ff40fcb4e7c7259cb98056975830cb55695.png","image_small":"http://i2.hdslb.com/bfs/face/627e342851dfda6fe7380c2fa0cbd7fae2e61533.png","level":"稀有勋章","condition":"单个自制视频总播放数>=100万"},"official_verify":{"type":-1,"desc":""}}
     */

    public int code;

    /**
     * mid : 185546
     * name : 小可儿
     * approve : false
     * sex : 保密
     * rank : 10000
     * face : http://i1.hdslb.com/bfs/face/5022986b528c74efadb6ab4669137214e066925c.x-png
     * coins : 0
     * DisplayRank : 1036
     * regtime : 1312561293
     * spacesta : 2
     * birthday : 1996-06-16
     * place : 上海市 长宁区
     * description :
     * article : 0
     * attentions : [319291,690546,374377,186759,1296804,1318455,742564,311888,482524,264264,2695314,669173,375375,644202,7329,687883,99224,201434,2986310,542884,591541,776558,699049,149065,1284747,386004,546195,2848416,602496,3857249,525024,168598,270744,2740963,6881318,547008,1770706,1272598,667850,1643718,2731733,3173802,2853209,398510,477009,12434430,430031,122879,3947820,4385354,913497,699438,12464176,322892,1894748,777536,1532165,6927351,4391879,2101645,2735222,6997378,4548018,7661994,2152304,814450,4203935,622723,454636,2778733,231563,20771487,3097441,486183,2798449,71106,9550310,11684516,1438811,1951038,423442,391679,139905,20503549,442520,22965,27434809,688969,11758387,920713,26922,8585525,10552107,8688933,4440520,10414152,13736797,3379951,8332697,689753,500198,172683,515993,328212,61999,3226226,2470678,19285836,4431898,808171,25282560,592761,1963054,234256,6332228,4138198,7508296,6510526,14634764,346059,814727,14415563,12564758,1396558,453972,1936132,24314825,43536,2459948,25775194,1652288,282994,20484551,22986236,288239,329932]
     * fans : 139476
     * friend : 135
     * attention : 135
     * sign : 粉丝的支持是我创作的源泉。
     * 微博@小可儿有剁不光的手 粉丝群569465513 网易云音乐:小可儿spike
     * level_info : {"current_level":6,"current_min":28800,"current_exp":298859,"next_exp":"-"}
     * pendant : {"pid":0,"name":"","image":"","expire":0}
     * nameplate : {"nid":1,"name":"黄金殿堂","image":"http://i2.hdslb.com/bfs/face/82896ff40fcb4e7c7259cb98056975830cb55695.png","image_small":"http://i2.hdslb.com/bfs/face/627e342851dfda6fe7380c2fa0cbd7fae2e61533.png","level":"稀有勋章","condition":"单个自制视频总播放数>=100万"}
     * official_verify : {"type":-1,"desc":""}
     */

    public CardBean card;

    public static class CardBean {

        public String mid;

        public String name;

        public boolean approve;

        public String sex;

        public String rank;

        public String face;

        public int coins;

        public String DisplayRank;

        public int regtime;

        public int spacesta;

        public String birthday;

        public String place;

        public String description;

        public int article;

        public int fans;

        public int friend;

        public int attention;

        public String sign;

        /**
         * current_level : 6
         * current_min : 28800
         * current_exp : 298859
         * next_exp : -
         */

        public LevelInfoBean level_info;

        /**
         * pid : 0
         * name :
         * image :
         * expire : 0
         */

        public PendantBean pendant;

        /**
         * nid : 1
         * name : 黄金殿堂
         * image : http://i2.hdslb.com/bfs/face/82896ff40fcb4e7c7259cb98056975830cb55695.png
         * image_small : http://i2.hdslb.com/bfs/face/627e342851dfda6fe7380c2fa0cbd7fae2e61533.png
         * level : 稀有勋章
         * condition : 单个自制视频总播放数>=100万
         */

        public NameplateBean nameplate;

        /**
         * type : -1
         * desc :
         */

        public OfficialVerifyBean official_verify;

        public List<Integer> attentions;

        public static class LevelInfoBean {

            public int current_level;

            public int current_min;

            public int current_exp;

            public String next_exp;

        }

        public static class PendantBean {

            public int pid;

            public String name;

            public String image;

            public int expire;

        }

        public static class NameplateBean {

            public int nid;

            public String name;

            public String image;

            public String image_small;

            public String level;

            public String condition;


        }

        public static class OfficialVerifyBean {

            public int type;

            public String desc;

        }
    }
}