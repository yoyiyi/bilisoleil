package com.yoyiyi.soleil.mvp.contract.home;

import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.live.LivePartition;
import com.yoyiyi.soleil.bean.live.LiveRecommend;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 22:02
 * 描述:
 */
public interface LiveContract {
    interface View extends BaseContract.BaseView {
        void showLiveRecommend(LiveRecommend liveRecommend);

        void showLivePartition(LivePartition livePartition);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getLiveData();

    }
}
