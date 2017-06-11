package com.yoyiyi.soleil.bean.app;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 9:15
 * 描述:欢迎界面
 */

public class Splash {


    /**
     * code : 0
     * data : [{"id":405,"type":1,"animate":1,"duration":2,"start_time":1497715200,"end_time":1497801600,"thumb":"http://i0.hdslb.com/bfs/archive/c28871c3007caab0c057638c760d76142005740e.jpg","hash":"2161228cf701f9d7a9ba7e9a17167b4c","times":5,"skip":1,"uri":""},{"id":428,"type":1,"animate":1,"duration":2,"start_time":1497110400,"end_time":1497283200,"thumb":"http://i0.hdslb.com/bfs/archive/818eccc6f2bb26d364801366d81e2a1ad9f69906.jpg","hash":"f51eb9926486ee88f0741345134df861","times":5,"skip":1,"uri":"https://bml.bilibili.com/2017/guide-m.html#/home"},{"id":206,"type":4,"animate":1,"duration":3,"start_time":1480058707,"end_time":1480490708,"thumb":"http://i0.hdslb.com/bfs/archive/29204aa43c1ed90ab5c33ecf8003753617c52823.png","hash":"8ff78e25ea4427baba4ce82c298e22aa","times":1,"skip":0,"uri":""}]
     * message :
     * ttl : 1
     * ver : 1857977265110596573
     */

    public int code;
    public String message;
    public int ttl;
    public String ver;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * id : 405
         * type : 1
         * animate : 1
         * duration : 2
         * start_time : 1497715200
         * end_time : 1497801600
         * thumb : http://i0.hdslb.com/bfs/archive/c28871c3007caab0c057638c760d76142005740e.jpg
         * hash : 2161228cf701f9d7a9ba7e9a17167b4c
         * times : 5
         * skip : 1
         * uri :
         */

        public int id;
        public int type;
        public int animate;
        public int duration;
        public int start_time;
        public int end_time;
        public String thumb;
        public String hash;
        public int times;
        public int skip;
        public String uri;
    }
}
