package com.yoyiyi.soleil.event;


import com.yoyiyi.soleil.bean.app.video.VideoDetail;
import com.yoyiyi.soleil.bean.app.video.VideoDetailComment;
import com.yoyiyi.soleil.bean.search.Search;
import com.yoyiyi.soleil.bean.user.UpDetail;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/4 15:24
 * 描述:事件
 */
public class Event {
    public static class RegionEntrancePositionEvent {
        public int position;
    }

    public static class ExitEvent {
        public int exit;
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

    public static class UpDetailArchiveEvent {
        public UpDetail.DataBean.ArchiveBean archive;
        public UpDetail.DataBean.SettingBean setting;
        public UpDetail.DataBean.FavouriteBean favourite;
        public UpDetail.DataBean.LiveBean live;

    }

    public static class UpDetailSubmitedVideoEvent {
        public List<UpDetail.DataBean.ArchiveBean.ItemBean> archivList;
    }

    public static class UpDetailFavourteEvent {
        public List<UpDetail.DataBean.FavouriteBean.ItemBeanX> favouriteList;
    }

    public static class SearchArchiveEvent {
        public Search.DataBean.ItemsBean itemBean;
        public int seasonCount;
        public int movieCount;
    }
}
