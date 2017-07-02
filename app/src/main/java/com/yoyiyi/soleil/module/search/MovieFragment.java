package com.yoyiyi.soleil.module.search;

import android.support.v7.widget.LinearLayoutManager;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.search.MovieAdapter;
import com.yoyiyi.soleil.bean.search.Movie;
import com.yoyiyi.soleil.mvp.contract.search.MovieContract;
import com.yoyiyi.soleil.mvp.presenter.search.MoviePresenter;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/29 11:46
 * 描述:影视
 */
public class MovieFragment extends BaseSearchFragment<MoviePresenter, Movie.DataBean.ItemsBean> implements MovieContract.View {
    private MovieAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search_movie;
    }

    public static MovieFragment newsInstance() {
        return new MovieFragment();
    }

    @Override
    protected void lazyLoadData() {
        mPresenter.getSearchMovieData();
    }

    @Override
    public void showSearchMovie(Movie movie) {
        mList.addAll(movie.data.items);
        finishTask();
    }
    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void finishTask() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initRecyclerView() {
        mAdapter = new MovieAdapter(mList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,
                false);
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(mAdapter);
    }
}
