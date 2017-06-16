package com.yoyiyi.soleil.mvp.contract.app.video;


import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.app.video.MulComment;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 9:45
 * 描述:欢迎界面Contract
 */

public interface CommentContract {
    interface View extends BaseContract.BaseView {
        void showComment(List<MulComment> mulComments);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getCommentData();


    }
}
