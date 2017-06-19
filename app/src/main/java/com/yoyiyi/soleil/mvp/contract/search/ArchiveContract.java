package com.yoyiyi.soleil.mvp.contract.search;

import com.yoyiyi.soleil.bean.search.MulSearchArchive;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/12 10:09
 * 描述:发现Contract
 */

public interface ArchiveContract {

    interface View extends BaseSearchContract.View {

        void showSearchArchive(List<MulSearchArchive> mulSearchArchiveList);

    }

    interface Presenter<T> extends BaseSearchContract.Presenter<T> {

        // void getSearchArchiveData(String keyword, int page, int pagesize);

        void getSearchArchiveData();

    }
}
