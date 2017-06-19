package com.yoyiyi.soleil.mvp.contract.search;

import com.yoyiyi.soleil.base.BaseContract;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/19 9:19
 * 描述:基础的查找
 */

public interface BaseSearchContract {
    interface View extends BaseContract.BaseView {

        void showLoading();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

    }
}
