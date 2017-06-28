package com.yoyiyi.soleil.bean.app.video;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/28 16:12
 * 描述:视频播放
 */

public class VideoPlayer {

    /**
     * from : local
     * result : suee
     * format : mp4
     * timelength : 2401795
     * accept_format : flv,hdmp4,mp4
     * accept_quality : [80,48,16]
     * seek_param : start
     * seek_type : second
     * durl : [{"order":1,"length":2401795,"size":145182349,"url":"http://122.228.103.130/vg5/2/c0/6191437-1.mp4?expires=1498647600&platform=android&ssig=ccG6v0orsCMxz4TScpdJcA&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006","backup_url":["http://58.220.29.4/vg7/e/33/6191437-1.mp4?expires=1498647600&platform=android&ssig=L6Bx5smjA8bVbMUepGmFbg&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006","http://116.207.118.5/vg6/4/4c/6191437-1.mp4?expires=1498647600&platform=android&ssig=3WdIhs49V_e1Dt7jfONEIg&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006"]}]
     */

    public String from;
    public String result;
    public String format;
    public int timelength;
    public String accept_format;
    public String seek_param;
    public String seek_type;
    public List<Integer> accept_quality;
    public List<DurlBean> durl;

    public static class DurlBean {
        /**
         * order : 1
         * length : 2401795
         * size : 145182349
         * url : http://122.228.103.130/vg5/2/c0/6191437-1.mp4?expires=1498647600&platform=android&ssig=ccG6v0orsCMxz4TScpdJcA&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006
         * backup_url : ["http://58.220.29.4/vg7/e/33/6191437-1.mp4?expires=1498647600&platform=android&ssig=L6Bx5smjA8bVbMUepGmFbg&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006","http://116.207.118.5/vg6/4/4c/6191437-1.mp4?expires=1498647600&platform=android&ssig=3WdIhs49V_e1Dt7jfONEIg&oi=3080483261&nfa=zn2OTN7O9p3rqnr0+3S2RQ==&dynamic=1&hfa=2069907006"]
         */

        public int order;
        public int length;
        public int size;
        public String url;
        public List<String> backup_url;
    }
}
