package com.yoyiyi.soleil.mvp.contract.search;

import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.search.Search;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/18 13:57
 * 描述:搜索
 */

public interface SearchContract {
    interface View extends BaseContract.BaseView {

        void showSearch(Search search);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getSearchData();
    }
}
