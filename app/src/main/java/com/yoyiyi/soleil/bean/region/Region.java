package com.yoyiyi.soleil.bean.region;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/26 14:35
 * 描述:分区
 */

public class Region {

    /**
     * param : 13
     * type : bangumi
     * style : medium
     * title : 番剧区
     * body : [{"title":"时钟机关之星","cover":"http://i2.hdslb.com/bfs/archive/7cf3a5aa4fc13630ca538fb93415340378aac68a.jpg","uri":"bilibili://bangumi/season/6000","param":"6000","goto":"bangumi","play":5371083,"index":"8","total_count":"12","mtime":"2017-05-26 12:00:02.0","status":2,"favourite":728259,"is_ad":false,"cm_mark":0},{"title":"青春歌舞伎","cover":"http://i2.hdslb.com/bfs/archive/d8857d228221205b725e34a6717952b29ea682a3.jpg","uri":"bilibili://bangumi/season/5991","param":"5991","goto":"bangumi","play":642812,"index":"8","total_count":"12","mtime":"2017-05-26 02:28:00.0","status":2,"favourite":153401,"is_ad":false,"cm_mark":0},{"title":"梦王国与沉睡的100王子 短篇动画","cover":"http://i2.hdslb.com/bfs/archive/2b44d67d3acb87fac32481839fdfa21dfa1c9d1b.jpg","uri":"bilibili://bangumi/season/6008","param":"6008","goto":"bangumi","play":443661,"index":"3","total_count":"10","mtime":"2017-05-25 10:00:02.0","status":2,"favourite":129651,"is_ad":false,"cm_mark":0},{"title":"博人传 火影忍者新时代","cover":"http://i0.hdslb.com/bfs/archive/2595e6799ef4be1737430dfe70ae7a61e9164f93.jpg","uri":"bilibili://bangumi/season/5978","param":"5978","goto":"bangumi","play":14287447,"index":"8","total_count":"51","mtime":"2017-05-24 17:55:02.0","status":2,"favourite":1123249,"is_ad":false,"cm_mark":0}]
     */

    public String param;
    public String type;
    public String style;
    public String title;
    public List<BodyBean> body;

    public static class BodyBean {
        /**
         * title : 时钟机关之星
         * cover : http://i2.hdslb.com/bfs/archive/7cf3a5aa4fc13630ca538fb93415340378aac68a.jpg
         * uri : bilibili://bangumi/season/6000
         * param : 6000
         * goto : bangumi
         * play : 5371083
         * index : 8
         * total_count : 12
         * mtime : 2017-05-26 12:00:02.0
         * status : 2
         * favourite : 728259
         * is_ad : false
         * cm_mark : 0
         */

        public String title;
        public String cover;
        public String uri;
        public String param;
        @SerializedName("goto")
        public String gotoX;
        public int play;
        public String index;
        public String total_count;
        public String mtime;
        public int status;
        public int favourite;
        public boolean is_ad;
        public int cm_mark;
        public int danmaku;

    }
}
