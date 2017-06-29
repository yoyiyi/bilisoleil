package com.yoyiyi.soleil.bean.live.live;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/29 14:15
 * 描述:舰队
 */

public class GuardRank {

    /**
     * code : 0
     * message : OK
     * data : [{"uid":56789263,"ruid":19738891,"rank":1,"username":"琼beibi","face":"http://i1.hdslb.com/bfs/face/e1061fde8a612a92d2b6848836166ca3cdbd655b.jpg","is_alive":1,"guard_level":3},{"uid":4316031,"ruid":19738891,"rank":2,"username":"肥皂的泡泡","face":"http://i1.hdslb.com/bfs/face/51cd40b6917e4b7b06e5d48b832dc9934bd0369e.jpg","is_alive":1,"guard_level":3},{"uid":38764227,"ruid":19738891,"rank":3,"username":"善解人衣542","face":"http://i0.hdslb.com/bfs/face/2fc069be9d8cd0fa98577e4718cf44f22515d301.jpg","is_alive":0,"guard_level":3},{"uid":12804161,"ruid":19738891,"rank":4,"username":"s嬰児s","face":"http://i2.hdslb.com/bfs/face/ceacfa5398cdfdf40d7069943b72256918de8785.jpg","is_alive":0,"guard_level":3},{"uid":9485467,"ruid":19738891,"rank":5,"username":"天泽灬","face":"http://static.hdslb.com/images/member/noface.gif","is_alive":0,"guard_level":3},{"uid":14587111,"ruid":19738891,"rank":6,"username":"莱娜兔","face":"http://i0.hdslb.com/bfs/face/9b27a1f6608f111853fbc3e88570f40ff2485013.jpg","is_alive":0,"guard_level":3},{"uid":87190877,"ruid":19738891,"rank":7,"username":"安一念一","face":"http://i1.hdslb.com/bfs/face/9633fabb18ef24c54341bd80f9624795c80265d9.jpg","is_alive":0,"guard_level":3}]
     */

    public int code;
    public String message;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * uid : 56789263
         * ruid : 19738891
         * rank : 1
         * username : 琼beibi
         * face : http://i1.hdslb.com/bfs/face/e1061fde8a612a92d2b6848836166ca3cdbd655b.jpg
         * is_alive : 1
         * guard_level : 3
         */

        public int uid;
        public int ruid;
        public int rank;
        public String username;
        public String face;
        public int is_alive;
        public int guard_level;
    }
}
