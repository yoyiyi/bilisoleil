package com.yoyiyi.soleil.bean.discover;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/22 13:19
 * 描述:发现界面热门搜索界面
 */

public class HotSearchTag {


    /**
     * trackid : 10987946868864499550
     * list : [{"keyword":"王者荣耀","status":"keep"},{"keyword":"全职高手","status":"up"},{"keyword":"自由之翼","status":"down"},{"keyword":"桃源恋歌","status":"down"},{"keyword":"逐月之月","status":"down"},{"keyword":"崩坏3","status":"up"},{"keyword":"剑网3","status":"up"},{"keyword":"埃罗芒阿老师","status":"down"},{"keyword":"大司马","status":"down"},{"keyword":"阴阳师","status":"up"},{"keyword":"fate/go","status":"up"},{"keyword":"dnf","status":"down"},{"keyword":"英雄联盟","status":"up"},{"keyword":"守望先锋","status":"down"},{"keyword":"炉石传说","status":"down"},{"keyword":"爱来了别错过2","status":"down"},{"keyword":"唱歌","status":"up"},{"keyword":"暴走大事件","status":"up"},{"keyword":"天府泰剧","status":"down"},{"keyword":"主播炸了","status":"keep"},{"keyword":"哥哥太爱我怎么办","status":"up"},{"keyword":"300英雄","status":"up"},{"keyword":"超人回来了","status":"up"},{"keyword":"学习","status":"down"},{"keyword":"running+man","status":"up"},{"keyword":"嗨氏","status":"down"},{"keyword":"dota2","status":"up"},{"keyword":"进击的巨人第二季","status":"up"},{"keyword":"skam","status":"up"},{"keyword":"龙珠传奇","status":"up"},{"keyword":"csgo","status":"down"},{"keyword":"cf","status":"up"},{"keyword":"msi","status":"down"},{"keyword":"rm","status":"up"},{"keyword":"瞎看什么","status":"up"},{"keyword":"主播真会玩","status":"down"},{"keyword":"摔跤吧爸爸","status":"up"},{"keyword":"火影忍者","status":"down"},{"keyword":"声之形","status":"up"},{"keyword":"坦克世界","status":"up"},{"keyword":"minecraft","status":"down"},{"keyword":"假面骑士","status":"up"},{"keyword":"极乐净土","status":"down"},{"keyword":"狼人杀","status":"down"},{"keyword":"三世情缘","status":"up"},{"keyword":"周星驰","status":"down"},{"keyword":"snh48","status":"down"},{"keyword":"海贼王","status":"up"},{"keyword":"逗鱼时刻","status":"down"},{"keyword":"狐妖小红娘","status":"up"}]
     */

    public String trackid;
    public List<ListBean> list;

    public static class ListBean {
        /**
         * keyword : 王者荣耀
         * status : keep
         */

        public String keyword;
        public String status;
    }
}
