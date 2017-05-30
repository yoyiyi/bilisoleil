package com.yoyiyi.soleil.mvp.contract.search;

import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.search.SearchArchive;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/12 10:09
 * 描述:发现Contract
 */

public interface TotalSearchContract {

    interface View extends BaseContract.BaseView {

        void showSearchNav(List<SearchArchive.NavBean> navBeans);

        void showLoading();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getSearchNavData(String keyword, int page, int pagesize);
    }
}
