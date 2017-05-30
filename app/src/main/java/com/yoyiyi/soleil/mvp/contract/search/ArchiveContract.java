package com.yoyiyi.soleil.mvp.contract.search;

import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.search.SearchArchive;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/12 10:09
 * 描述:发现Contract
 */

public interface ArchiveContract {

    interface View extends BaseContract.BaseView {

        void showSearchArchive(SearchArchive searchArchive);

        void showLoading();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getSearchArchiveData(String keyword, int page, int pagesize);
    }
}
