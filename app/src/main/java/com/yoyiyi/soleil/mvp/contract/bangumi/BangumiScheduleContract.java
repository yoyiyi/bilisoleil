package com.yoyiyi.soleil.mvp.contract.bangumi;

import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.bangumi.BangumiSchedule;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/12 10:09
 * 描述:全区排行Contract
 */

public interface BangumiScheduleContract {

    interface View extends BaseContract.BaseView {

        void showBangumiSchedule(List<BangumiSchedule> bangumiScheduleList);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getBangumiSchedule();
    }
}
