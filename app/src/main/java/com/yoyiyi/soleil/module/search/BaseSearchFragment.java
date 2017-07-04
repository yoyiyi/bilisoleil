package com.yoyiyi.soleil.module.search;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.base.BaseFragment;
import com.yoyiyi.soleil.mvp.contract.search.BaseSearchContract;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/29 11:46
 * 描述:基础搜索
 */
public abstract class BaseSearchFragment<T extends BaseContract.BasePresenter, K> extends BaseFragment<T> implements BaseSearchContract.View {

    protected List<K> mList = new ArrayList<>();
    protected ImageView mIvSearchLoad;
    protected AnimationDrawable mAnimationDrawable;
    protected RecyclerView mRecycler;

    @Override
    public void initWidget() {
        mIvSearchLoad = ButterKnife.findById(mRootView, R.id.iv_search_load);
        mRecycler = ButterKnife.findById(mRootView, R.id.recycler);
        initRecyclerView();
    }



    @Override
    public void showError(String msg) {
        //显示搜索不到
        if (mIvSearchLoad != null) {
            mIvSearchLoad.setImageResource(R.drawable.search_failed);
            visible(mIvSearchLoad);
            if (mRecycler != null) gone(mRecycler);
        }
        if (mAnimationDrawable != null) {
            mAnimationDrawable.stop();
        }
    }

    @Override
    public void complete() {
        if (mIvSearchLoad != null) {
            gone(mIvSearchLoad);
            if (mRecycler != null) visible(mRecycler);
        }
        if (mAnimationDrawable != null) {
            mAnimationDrawable.stop();
        }
    }

    @Override
    public void showLoading() {
        if (mIvSearchLoad != null)
            mIvSearchLoad.setImageResource(R.drawable.anim_search_loading);
        if (mAnimationDrawable != null)
            mAnimationDrawable = (AnimationDrawable) mIvSearchLoad.getDrawable();
        if (mIvSearchLoad != null)
            visible(mIvSearchLoad);
        if (mRecycler != null)
            gone(mRecycler);
        if (mAnimationDrawable != null)
            mAnimationDrawable.start();
    }
}
