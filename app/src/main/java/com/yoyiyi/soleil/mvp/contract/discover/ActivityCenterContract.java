package com.yoyiyi.soleil.mvp.contract.discover;

import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.discover.ActivityCenter;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/12 10:09
 * 描述:话题中心Contract
 */

public interface ActivityCenterContract {

    interface View extends BaseContract.BaseView {

        void showActivityCenter(List<ActivityCenter.ListBean> listBeanList, int total);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getActivityCenterData(int page, int pageSize);
    }
}
