package com.yoyiyi.soleil.event;

import com.yoyiyi.soleil.bean.app.VideoDetail;
import com.yoyiyi.soleil.bean.app.VideoDetailComment;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/4 15:24
 * 描述:事件
 */
public class Event {
    public static class RegionEntrancePositionEvent {
        public int position;
    }

    public static class AllStationPositionEvent {
        public int position;
    }

    public static class StartNavigationEvent {
        public boolean start;
    }

    public static class VideoDetailEvent {
        public VideoDetail.DataBean videoDetail;
    }

    public static class VideoDetailCommentEvent {
        public VideoDetailComment.DataBean videoDetailComment;
    }
}
