package com.yoyiyi.soleil.bean.search;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/19 13:04
 * 描述:
 */

public class Season {

    /**
     * code : 0
     * data : {"items":[{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/15992a6e1d737ae0319ab3788f598c223501d043.jpg","finish":1,"goto":"bangumi","index":"13","newest_cat":"tv","newest_season":"TV","param":"2932","started":0,"status":0,"title":"打工吧！魔王大人","total_count":13,"uri":"bilibili://bangumi/season/2932"},{"attentions":0,"cat_desc":"TV(2) OVA/OAD/SP(1)","cover":"https://i0.hdslb.com/bfs/bangumi/7ec9487f007c278733212908a6f607e4a245b1d4.jpg","finish":1,"goto":"bangumi","index":"1","newest_cat":"ova","newest_season":"OVA","param":"1588","started":0,"status":0,"title":"罪恶王冠","total_count":1,"uri":"bilibili://bangumi/season/1588"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/29d001c8083a224da99b72239be5680c6ac907e7.jpg","goto":"bangumi","index":"12","newest_cat":"tv","newest_season":"第一季","param":"6043","started":0,"status":0,"title":"第六天魔王","total_count":-1,"uri":"bilibili://bangumi/season/6043"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/41b4ae625c78944ebde3910ea16d8112b6bf1076.jpg","finish":1,"goto":"bangumi","index":"13","newest_cat":"sp","newest_season":"SP","param":"291","started":0,"status":0,"title":"魔弹之王与战姬","total_count":14,"uri":"bilibili://bangumi/season/291"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/871040b2d1f51d94a6238beba89af8ba4cef75bf.jpg","finish":1,"goto":"bangumi","index":"146","newest_cat":"tv","newest_season":"游☆戏☆王 ZEXAL","param":"159","started":0,"status":0,"title":"游☆戏☆王 ZEXAL","total_count":146,"uri":"bilibili://bangumi/season/159"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/ec29542c3b1526efd514c93d33b2fdd4f4021a70.jpg","finish":1,"goto":"bangumi","index":"180","newest_cat":"tv","newest_season":"TV","param":"157","started":0,"status":0,"title":"游☆戏☆王 GX","total_count":180,"uri":"bilibili://bangumi/season/157"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/3467797f5bab8b178ca939da3b430c8636bb480c.jpg","goto":"bangumi","index":"6","newest_cat":"tv","newest_season":"TV","param":"6163","started":0,"status":0,"title":"游戏王VRAINS","total_count":12,"uri":"bilibili://bangumi/season/6163"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/dc99c5c10c3705fd5d0dbdbaf1ef1cf7e7595588.jpg","goto":"bangumi","index":"3","newest_cat":"tv","newest_season":"短篇动画","param":"6008","started":0,"status":0,"title":"梦王国与沉睡的100王子","total_count":10,"uri":"bilibili://bangumi/season/6008"},{"attentions":0,"cat_desc":"TV(2) ","cover":"https://i0.hdslb.com/bfs/bangumi/adedefcac8473e2b5ed94f03a9e870acd742a3f2.jpg","finish":1,"goto":"bangumi","index":"39","newest_cat":"tv","newest_season":"第二季","param":"582","started":0,"status":0,"title":"王者天下","total_count":39,"uri":"bilibili://bangumi/season/582"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/ce3b743cd661ad3edfa7f580d0ea388caf8e8987.jpg","finish":1,"goto":"bangumi","index":"224","newest_cat":"tv","newest_season":"TV","param":"3054","started":0,"status":0,"title":"游☆戏☆王 Duel Monsters","total_count":224,"uri":"bilibili://bangumi/season/3054"},{"attentions":0,"cat_desc":"TV(2) OVA/OAD/SP(1)","cover":"https://i0.hdslb.com/bfs/bangumi/6c960a0dbb7cbe2b57f1a3ca4f547079d2aa5839.jpg","finish":1,"goto":"bangumi","index":"12","newest_cat":"tv","newest_season":"05年修改版","param":"1823","started":0,"status":0,"title":"勇者王GAOGAIGAR","total_count":12,"uri":"bilibili://bangumi/season/1823"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/b3f9ffad82a1c70195958a564145b5cc713c1215.jpg","finish":1,"goto":"bangumi","index":"13","newest_cat":"tv","newest_season":"外传","param":"1226","started":0,"status":0,"title":"北斗神拳","total_count":13,"uri":"bilibili://bangumi/season/1226"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/b5f4eb72d861ce0d647a4e7783f9d86bcecaf94f.jpg","finish":1,"goto":"bangumi","index":"43","newest_cat":"tv","newest_season":"WEB","param":"5206","started":0,"status":0,"title":"弱酸性百万亚瑟王","total_count":48,"uri":"bilibili://bangumi/season/5206"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/650a0897c42bc3acb4d44865ef9c14d8e94f7512.jpg","finish":1,"goto":"bangumi","index":"20","newest_cat":"tv","newest_season":"第一季","param":"5301","started":0,"status":0,"title":"墓王之王","total_count":20,"uri":"bilibili://bangumi/season/5301"},{"attentions":0,"cat_desc":"TV(4) OVA/OAD/SP(1)","cover":"https://i0.hdslb.com/bfs/bangumi/54c3d07e6095aaa60821e3b6659bd6d03eaf27b8.jpg","finish":1,"goto":"bangumi","index":"2","newest_cat":"ova","newest_season":"OVA","param":"1717","started":0,"status":0,"title":"游☆戏☆王 5D's","total_count":2,"uri":"bilibili://bangumi/season/1717"},{"attentions":0,"cat_desc":"TV(3) OVA/OAD/SP(1)","cover":"https://i0.hdslb.com/bfs/bangumi/ac6971abe51749ed1af2026390e4fc87cbb37c73.jpg","finish":1,"goto":"bangumi","index":"5","newest_cat":"ova","newest_season":"OVA","param":"3764","started":0,"status":0,"title":"今天开始做魔王！","total_count":5,"uri":"bilibili://bangumi/season/3764"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/ff2c83562a5dae530f83d1449cd3be80b5865592.jpg","finish":1,"goto":"bangumi","index":"69","newest_cat":"tv","newest_season":"TV","param":"1887","started":0,"status":0,"title":"日式面包王","total_count":69,"uri":"bilibili://bangumi/season/1887"},{"attentions":0,"cat_desc":"TV(2) ","cover":"https://i0.hdslb.com/bfs/bangumi/6d20b92d10a00f9b00e248f99561a4c71c2d506a.jpg","finish":1,"goto":"bangumi","index":"13","newest_cat":"tv","newest_season":"第二季","param":"1015","started":0,"status":0,"title":"王牌投手 振臂高挥","total_count":14,"uri":"bilibili://bangumi/season/1015"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/cbb7b1521827d79426d39aaa236721fc6560272d.jpg","finish":1,"goto":"bangumi","index":"26","newest_cat":"tv","newest_season":"TV","param":"3220","started":0,"status":0,"title":"隐之王","total_count":26,"uri":"bilibili://bangumi/season/3220"},{"attentions":0,"cat_desc":"剧场版(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/809204fcbb6c21e7c2a8965e8e700ebd90bbc7ef.jpg","finish":1,"goto":"bangumi","index":"1","newest_cat":"movie","newest_season":"剧场版","param":"4654","started":0,"status":0,"title":"游戏王","total_count":1,"uri":"bilibili://bangumi/season/4654"}],"pages":3,"trackid":"2679500176269405229"}
     * message :
     * ttl : 1
     */

    public int code;
    public DataBean data;
    public String message;
    public int ttl;

    public static class DataBean {
        /**
         * items : [{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/15992a6e1d737ae0319ab3788f598c223501d043.jpg","finish":1,"goto":"bangumi","index":"13","newest_cat":"tv","newest_season":"TV","param":"2932","started":0,"status":0,"title":"打工吧！魔王大人","total_count":13,"uri":"bilibili://bangumi/season/2932"},{"attentions":0,"cat_desc":"TV(2) OVA/OAD/SP(1)","cover":"https://i0.hdslb.com/bfs/bangumi/7ec9487f007c278733212908a6f607e4a245b1d4.jpg","finish":1,"goto":"bangumi","index":"1","newest_cat":"ova","newest_season":"OVA","param":"1588","started":0,"status":0,"title":"罪恶王冠","total_count":1,"uri":"bilibili://bangumi/season/1588"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/29d001c8083a224da99b72239be5680c6ac907e7.jpg","goto":"bangumi","index":"12","newest_cat":"tv","newest_season":"第一季","param":"6043","started":0,"status":0,"title":"第六天魔王","total_count":-1,"uri":"bilibili://bangumi/season/6043"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/41b4ae625c78944ebde3910ea16d8112b6bf1076.jpg","finish":1,"goto":"bangumi","index":"13","newest_cat":"sp","newest_season":"SP","param":"291","started":0,"status":0,"title":"魔弹之王与战姬","total_count":14,"uri":"bilibili://bangumi/season/291"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/871040b2d1f51d94a6238beba89af8ba4cef75bf.jpg","finish":1,"goto":"bangumi","index":"146","newest_cat":"tv","newest_season":"游☆戏☆王 ZEXAL","param":"159","started":0,"status":0,"title":"游☆戏☆王 ZEXAL","total_count":146,"uri":"bilibili://bangumi/season/159"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/ec29542c3b1526efd514c93d33b2fdd4f4021a70.jpg","finish":1,"goto":"bangumi","index":"180","newest_cat":"tv","newest_season":"TV","param":"157","started":0,"status":0,"title":"游☆戏☆王 GX","total_count":180,"uri":"bilibili://bangumi/season/157"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/3467797f5bab8b178ca939da3b430c8636bb480c.jpg","goto":"bangumi","index":"6","newest_cat":"tv","newest_season":"TV","param":"6163","started":0,"status":0,"title":"游戏王VRAINS","total_count":12,"uri":"bilibili://bangumi/season/6163"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/dc99c5c10c3705fd5d0dbdbaf1ef1cf7e7595588.jpg","goto":"bangumi","index":"3","newest_cat":"tv","newest_season":"短篇动画","param":"6008","started":0,"status":0,"title":"梦王国与沉睡的100王子","total_count":10,"uri":"bilibili://bangumi/season/6008"},{"attentions":0,"cat_desc":"TV(2) ","cover":"https://i0.hdslb.com/bfs/bangumi/adedefcac8473e2b5ed94f03a9e870acd742a3f2.jpg","finish":1,"goto":"bangumi","index":"39","newest_cat":"tv","newest_season":"第二季","param":"582","started":0,"status":0,"title":"王者天下","total_count":39,"uri":"bilibili://bangumi/season/582"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/ce3b743cd661ad3edfa7f580d0ea388caf8e8987.jpg","finish":1,"goto":"bangumi","index":"224","newest_cat":"tv","newest_season":"TV","param":"3054","started":0,"status":0,"title":"游☆戏☆王 Duel Monsters","total_count":224,"uri":"bilibili://bangumi/season/3054"},{"attentions":0,"cat_desc":"TV(2) OVA/OAD/SP(1)","cover":"https://i0.hdslb.com/bfs/bangumi/6c960a0dbb7cbe2b57f1a3ca4f547079d2aa5839.jpg","finish":1,"goto":"bangumi","index":"12","newest_cat":"tv","newest_season":"05年修改版","param":"1823","started":0,"status":0,"title":"勇者王GAOGAIGAR","total_count":12,"uri":"bilibili://bangumi/season/1823"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/b3f9ffad82a1c70195958a564145b5cc713c1215.jpg","finish":1,"goto":"bangumi","index":"13","newest_cat":"tv","newest_season":"外传","param":"1226","started":0,"status":0,"title":"北斗神拳","total_count":13,"uri":"bilibili://bangumi/season/1226"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/b5f4eb72d861ce0d647a4e7783f9d86bcecaf94f.jpg","finish":1,"goto":"bangumi","index":"43","newest_cat":"tv","newest_season":"WEB","param":"5206","started":0,"status":0,"title":"弱酸性百万亚瑟王","total_count":48,"uri":"bilibili://bangumi/season/5206"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/650a0897c42bc3acb4d44865ef9c14d8e94f7512.jpg","finish":1,"goto":"bangumi","index":"20","newest_cat":"tv","newest_season":"第一季","param":"5301","started":0,"status":0,"title":"墓王之王","total_count":20,"uri":"bilibili://bangumi/season/5301"},{"attentions":0,"cat_desc":"TV(4) OVA/OAD/SP(1)","cover":"https://i0.hdslb.com/bfs/bangumi/54c3d07e6095aaa60821e3b6659bd6d03eaf27b8.jpg","finish":1,"goto":"bangumi","index":"2","newest_cat":"ova","newest_season":"OVA","param":"1717","started":0,"status":0,"title":"游☆戏☆王 5D's","total_count":2,"uri":"bilibili://bangumi/season/1717"},{"attentions":0,"cat_desc":"TV(3) OVA/OAD/SP(1)","cover":"https://i0.hdslb.com/bfs/bangumi/ac6971abe51749ed1af2026390e4fc87cbb37c73.jpg","finish":1,"goto":"bangumi","index":"5","newest_cat":"ova","newest_season":"OVA","param":"3764","started":0,"status":0,"title":"今天开始做魔王！","total_count":5,"uri":"bilibili://bangumi/season/3764"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/ff2c83562a5dae530f83d1449cd3be80b5865592.jpg","finish":1,"goto":"bangumi","index":"69","newest_cat":"tv","newest_season":"TV","param":"1887","started":0,"status":0,"title":"日式面包王","total_count":69,"uri":"bilibili://bangumi/season/1887"},{"attentions":0,"cat_desc":"TV(2) ","cover":"https://i0.hdslb.com/bfs/bangumi/6d20b92d10a00f9b00e248f99561a4c71c2d506a.jpg","finish":1,"goto":"bangumi","index":"13","newest_cat":"tv","newest_season":"第二季","param":"1015","started":0,"status":0,"title":"王牌投手 振臂高挥","total_count":14,"uri":"bilibili://bangumi/season/1015"},{"attentions":0,"cat_desc":"TV(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/cbb7b1521827d79426d39aaa236721fc6560272d.jpg","finish":1,"goto":"bangumi","index":"26","newest_cat":"tv","newest_season":"TV","param":"3220","started":0,"status":0,"title":"隐之王","total_count":26,"uri":"bilibili://bangumi/season/3220"},{"attentions":0,"cat_desc":"剧场版(1) ","cover":"https://i0.hdslb.com/bfs/bangumi/809204fcbb6c21e7c2a8965e8e700ebd90bbc7ef.jpg","finish":1,"goto":"bangumi","index":"1","newest_cat":"movie","newest_season":"剧场版","param":"4654","started":0,"status":0,"title":"游戏王","total_count":1,"uri":"bilibili://bangumi/season/4654"}]
         * pages : 3
         * trackid : 2679500176269405229
         */

        public int pages;
        public String trackid;
        public List<ItemsBean> items;

        public static class ItemsBean {
            /**
             * attentions : 0
             * cat_desc : TV(1)
             * cover : https://i0.hdslb.com/bfs/bangumi/15992a6e1d737ae0319ab3788f598c223501d043.jpg
             * finish : 1
             * goto : bangumi
             * index : 13
             * newest_cat : tv
             * newest_season : TV
             * param : 2932
             * started : 0
             * status : 0
             * title : 打工吧！魔王大人
             * total_count : 13
             * uri : bilibili://bangumi/season/2932
             */

            public int attentions;
            public String cat_desc;
            public String cover;
            public int finish;
            @SerializedName("goto")
            public String gotoX;
            public String index;
            public String newest_cat;
            public String newest_season;
            public String param;
            public int started;
            public int status;
            public String title;
            public int total_count;
            public String uri;
        }
    }
}
