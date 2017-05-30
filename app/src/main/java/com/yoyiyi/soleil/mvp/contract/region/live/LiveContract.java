package com.yoyiyi.soleil.mvp.contract.region.live;

import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.live.LiveEntrance;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/12 10:09
 * 描述:发现Contract
 */

public interface LiveContract {

    interface View extends BaseContract.BaseView {

        void showLiveEntrance(List<LiveEntrance> liveEntrances);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getLiveEntranceData();
    }
}
