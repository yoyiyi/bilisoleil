package com.yoyiyi.soleil.mvp.contract.home;

import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.dynamic.MulDynamic;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 22:02
 * 描述:分区
 */
public interface DynamicContract {
    interface View extends BaseContract.BaseView {
        void showMulDynamic(List<MulDynamic> mulDynamic);


    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getMulDynamicData();
    }
}
