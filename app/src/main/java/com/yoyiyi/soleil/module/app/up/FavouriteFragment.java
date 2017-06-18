package com.yoyiyi.soleil.module.app.up;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.app.up.FavouriteAdapter;
import com.yoyiyi.soleil.base.BaseFragment;
import com.yoyiyi.soleil.bean.user.MulUpDetail;
import com.yoyiyi.soleil.constant.Constants;
import com.yoyiyi.soleil.mvp.contract.app.up.FavouriteContract;
import com.yoyiyi.soleil.mvp.presenter.app.up.FavouritePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/16 15:09
 * 描述:收藏
 */

public class FavouriteFragment extends BaseFragment<FavouritePresenter> implements FavouriteContract.View {

    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    @BindView(R.id.iv_empty)
    ImageView mIvEmpty;
    @BindView(R.id.cl_error)
    ConstraintLayout mClError;
    private int mSetting;
    private List<MulUpDetail> mList = new ArrayList<>();
    private FavouriteAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_up_favourite;
    }

    public static FavouriteFragment newInstance(int setting) {
        FavouriteFragment fragment = new FavouriteFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.EXTRA_SETTING, setting);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void showFavourite(List<MulUpDetail> mulUpDetailList) {
        mList.addAll(mulUpDetailList);
        finishTask();
    }

    @Override
    public void initVariables() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            mSetting = bundle.getInt(Constants.EXTRA_SETTING);
        }
        if (mSetting == 0) {
            visible(R.id.iv_empty);
        } else {
            gone(R.id.iv_empty);
        }
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void loadData() {
        if (mSetting == 1)
            mPresenter.getFavouriteData();
    }

    @Override
    protected void initRecyclerView() {
        mAdapter = new FavouriteAdapter(mList);
        mRecycler.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(mAdapter);
    }


    @Override
    public void initWidget() {
        initRecyclerView();
    }

    @Override
    protected void finishTask() {
        gone(mIvEmpty, mClError);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String msg) {
        visible(mClError);
        gone(mIvEmpty);
    }

}
