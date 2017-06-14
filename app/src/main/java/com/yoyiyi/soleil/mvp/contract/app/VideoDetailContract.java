package com.yoyiyi.soleil.mvp.contract.app;

import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.app.VideoDetail;
import com.yoyiyi.soleil.bean.app.VideoDetailComment;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/14 14:30
 * 描述:
 */

public interface VideoDetailContract {
    interface View extends BaseContract.BaseView {
        void showVideoDetail(VideoDetail.DataBean videoDetail);

        void showVideoDetailComment(VideoDetailComment.DataBean videoDetailComment);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getVideoDetailData();

    }
}
