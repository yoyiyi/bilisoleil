package com.yoyiyi.soleil.mvp.contract.search;

import com.yoyiyi.soleil.bean.search.Movie;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/12 10:09
 * 描述:发现Contract
 */

public interface MovieContract {

    interface View extends BaseSearchContract.View {

        void showSearchMovie(Movie movie);

    }

    interface Presenter<T> extends BaseSearchContract.Presenter<T> {

        // void getSearchArchiveData(String keyword, int page, int pagesize);

        void getSearchMovieData();

    }
}
