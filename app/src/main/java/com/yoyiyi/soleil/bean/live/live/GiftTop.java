package com.yoyiyi.soleil.bean.live.live;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/29 14:14
 * 描述:
 */

public class GiftTop {

    /**
     * code : 0
     * message : OK
     * data : {"unlogin":0,"uname":"yoyiyi3","rank":0,"coin":0,"list":[{"uid":38764227,"uname":"善解人衣542","coin":408500,"face":"http://i0.hdslb.com/bfs/face/2fc069be9d8cd0fa98577e4718cf44f22515d301.jpg","guard_level":3},{"uid":56789263,"uname":"琼beibi","coin":295300,"face":"http://i1.hdslb.com/bfs/face/e1061fde8a612a92d2b6848836166ca3cdbd655b.jpg","guard_level":3},{"uid":12804161,"uname":"s嬰児s","coin":258268,"face":"http://i2.hdslb.com/bfs/face/ceacfa5398cdfdf40d7069943b72256918de8785.jpg","guard_level":3},{"uid":846907,"uname":"泗锐qwqqq","coin":228200,"face":"http://i0.hdslb.com/bfs/face/a9c198ab788a6f7fdfa94f5ac7e2904e01228d99.jpg","guard_level":0},{"uid":878912,"uname":"BAKA呆唯","coin":200598,"face":"http://i0.hdslb.com/bfs/face/1386409afd34ce21fbe85f76177c6d93f1ffc918.jpg","guard_level":0},{"uid":38394347,"uname":"独行独行","coin":169729,"face":"http://i0.hdslb.com/bfs/face/09aa9e3a45ee7e7544a1ca7fb51d51b9e309c33e.jpg","guard_level":0},{"uid":1634581,"uname":"无双的凶喵","coin":167900,"face":"http://i0.hdslb.com/bfs/face/4494f8747ef24d7cf5f62d843b3a7bef2187fbc8.jpg","guard_level":0},{"uid":12370179,"uname":"没有梦想的AD","coin":167600,"face":"http://i2.hdslb.com/bfs/face/2740cd8af20938b85856dc8b581093173eb58f89.jpg","guard_level":0},{"uid":13129970,"uname":"浅笑迷情","coin":157100,"face":"http://i0.hdslb.com/bfs/face/a8db52736a0c02631af45d5c34de89c49538bd27.jpg","guard_level":0},{"uid":2234639,"uname":"元宝啊元宝","coin":147500,"face":"http://i2.hdslb.com/bfs/face/16f139b0e08e3e98f24a492e58639c7235f9aa46.jpg","guard_level":0}]}
     */

    public int code;
    public String message;
    public DataBean data;

    public static class DataBean {
        /**
         * unlogin : 0
         * uname : yoyiyi3
         * rank : 0
         * coin : 0
         * list : [{"uid":38764227,"uname":"善解人衣542","coin":408500,"face":"http://i0.hdslb.com/bfs/face/2fc069be9d8cd0fa98577e4718cf44f22515d301.jpg","guard_level":3},{"uid":56789263,"uname":"琼beibi","coin":295300,"face":"http://i1.hdslb.com/bfs/face/e1061fde8a612a92d2b6848836166ca3cdbd655b.jpg","guard_level":3},{"uid":12804161,"uname":"s嬰児s","coin":258268,"face":"http://i2.hdslb.com/bfs/face/ceacfa5398cdfdf40d7069943b72256918de8785.jpg","guard_level":3},{"uid":846907,"uname":"泗锐qwqqq","coin":228200,"face":"http://i0.hdslb.com/bfs/face/a9c198ab788a6f7fdfa94f5ac7e2904e01228d99.jpg","guard_level":0},{"uid":878912,"uname":"BAKA呆唯","coin":200598,"face":"http://i0.hdslb.com/bfs/face/1386409afd34ce21fbe85f76177c6d93f1ffc918.jpg","guard_level":0},{"uid":38394347,"uname":"独行独行","coin":169729,"face":"http://i0.hdslb.com/bfs/face/09aa9e3a45ee7e7544a1ca7fb51d51b9e309c33e.jpg","guard_level":0},{"uid":1634581,"uname":"无双的凶喵","coin":167900,"face":"http://i0.hdslb.com/bfs/face/4494f8747ef24d7cf5f62d843b3a7bef2187fbc8.jpg","guard_level":0},{"uid":12370179,"uname":"没有梦想的AD","coin":167600,"face":"http://i2.hdslb.com/bfs/face/2740cd8af20938b85856dc8b581093173eb58f89.jpg","guard_level":0},{"uid":13129970,"uname":"浅笑迷情","coin":157100,"face":"http://i0.hdslb.com/bfs/face/a8db52736a0c02631af45d5c34de89c49538bd27.jpg","guard_level":0},{"uid":2234639,"uname":"元宝啊元宝","coin":147500,"face":"http://i2.hdslb.com/bfs/face/16f139b0e08e3e98f24a492e58639c7235f9aa46.jpg","guard_level":0}]
         */

        public int unlogin;
        public String uname;
        public int rank;
        public int coin;
        public List<ListBean> list;

        public static class ListBean {
            /**
             * uid : 38764227
             * uname : 善解人衣542
             * coin : 408500
             * face : http://i0.hdslb.com/bfs/face/2fc069be9d8cd0fa98577e4718cf44f22515d301.jpg
             * guard_level : 3
             */

            public int uid;
            public String uname;
            public int coin;
            public String face;
            public int guard_level;
        }
    }
}
