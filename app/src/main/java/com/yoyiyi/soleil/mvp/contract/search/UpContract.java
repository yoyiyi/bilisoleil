package com.yoyiyi.soleil.mvp.contract.search;

import com.yoyiyi.soleil.bean.search.Up;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/12 10:09
 * 描述:发现Contract
 */

public interface UpContract {

    interface View extends BaseSearchContract.View {

        void showSearchUp(Up up);

    }

    interface Presenter<T> extends BaseSearchContract.Presenter<T> {


        void getSearchUpData();

    }
}
