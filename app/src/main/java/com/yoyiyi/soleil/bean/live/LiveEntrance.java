package com.yoyiyi.soleil.bean.live;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/30 12:03
 * 描述:直播入口
 */
public class LiveEntrance {

    /**
     * entrance_icon : {"height":120,"src":"http://static.hdslb.com/live-static/live-app/areaicon/android/xxhdpi/12.png?20170525111300","width":120}
     * id : 12
     * name : 手游直播
     */

    public EntranceIconBean entrance_icon;
    public int id;
    public String name;

    public static class EntranceIconBean {
        /**
         * height : 120
         * src : http://static.hdslb.com/live-static/live-app/areaicon/android/xxhdpi/12.png?20170525111300
         * width : 120
         */

        public int height;
        public String src;
        public int width;
    }
}
