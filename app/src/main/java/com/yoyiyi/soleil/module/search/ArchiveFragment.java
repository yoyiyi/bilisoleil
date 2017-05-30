package com.yoyiyi.soleil.module.search;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.search.SearchArchive;
import com.yoyiyi.soleil.constant.Constants;
import com.yoyiyi.soleil.mvp.contract.search.ArchiveContract;
import com.yoyiyi.soleil.mvp.presenter.search.ArchivePresenter;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/29 11:46
 * 描述:综合搜索
 */
public class ArchiveFragment extends BaseSearchFragment<ArchivePresenter, SearchArchive.ItemsBean.ArchiveBean>
        implements ArchiveContract.View {
    private String mKeyword;
    private int mPager = 1;
    private int mPagerSize = 20;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search_archive;
    }

    public static ArchiveFragment newsInstance(String keyword) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.EXTRA_KEYWORD, keyword);
        ArchiveFragment fragment = new ArchiveFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void initVariables() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            mKeyword = bundle.getString(Constants.EXTRA_KEYWORD);
        }
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void showSearchArchive(SearchArchive searchArchive) {
        mList.addAll(searchArchive.items.archive);
        finishTask();
    }

    @Override
    protected void lazyLoadData() {
        mPresenter.getSearchArchiveData(mKeyword, mPager, mPagerSize);
    }

    @Override
    public void showLoading() {
        mIvSearchLoad.setImageResource(R.drawable.anim_search_loading);
        mAnimationDrawable = (AnimationDrawable) mIvSearchLoad.getDrawable();
        visible(mIvSearchLoad);
        gone(mRecycler);
        mAnimationDrawable.start();
    }

    @Override
    protected void finishTask() {
        super.finishTask();
    }
}
