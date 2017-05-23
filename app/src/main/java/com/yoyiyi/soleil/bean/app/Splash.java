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
     * data : [{"id":175,"type":4,"animate":1,"duration":3,"start_time":1478502652,"end_time":1480489853,"thumb":"http://i0.hdslb.com/bfs/archive/ba17d4df28fb0c28c8f596082d7328b4415ee28b.png","hash":"41971d8954d2edbd4c9542bfe2c6eaa5","times":1,"skip":0,"uri":""}]
     * message :
     * ttl : 1
     * ver : 16808511608003266256
     */

    public int code;
    public String message;
    public int ttl;
    public String ver;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * id : 175
         * type : 4
         * animate : 1
         * duration : 3
         * start_time : 1478502652
         * end_time : 1480489853
         * thumb : http://i0.hdslb.com/bfs/archive/ba17d4df28fb0c28c8f596082d7328b4415ee28b.png
         * hash : 41971d8954d2edbd4c9542bfe2c6eaa5
         * times : 1
         * skip : 0
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
