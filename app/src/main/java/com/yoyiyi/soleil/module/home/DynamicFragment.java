package com.yoyiyi.soleil.module.home;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.home.DynamicAdapter;
import com.yoyiyi.soleil.base.BaseRefreshFragment;
import com.yoyiyi.soleil.bean.dynamic.MulDynamic;
import com.yoyiyi.soleil.mvp.contract.home.DynamicContract;
import com.yoyiyi.soleil.mvp.presenter.home.DynamicPresenter;
import com.yoyiyi.soleil.widget.expand.ExpandableLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 14:23
 * 描述:推荐
 */

public class DynamicFragment extends BaseRefreshFragment<DynamicPresenter, MulDynamic> implements DynamicContract.View {

    @BindView(R.id.guideline)
    Guideline mGuideline;
    @BindView(R.id.tv_follow)
    TextView mTvFollow;
    @BindView(R.id.tv_all)
    TextView mTvAll;
    @BindView(R.id.iv_all)
    ImageView mIvAll;
    @BindView(R.id.cl_all)
    ConstraintLayout mClAll;
    @BindView(R.id.v_bottom)
    View mVBottom;
    @BindView(R.id.tv_all_select)
    TextView mTvAllSelect;
    @BindView(R.id.tv_up_select)
    TextView mTvUpSelect;
    @BindView(R.id.tv_bangumi_select)
    TextView mTvBangumiSelect;
    @BindView(R.id.expand)
    ExpandableLayout mExpand;

    private String mTextSelect;
    private DynamicAdapter mAdapter;

    public static DynamicFragment newInstance() {
        return new DynamicFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_dynamic;
    }

    @Override
    public void initWidget() {
        mTvAllSelect.setSelected(true);
    }

    @Override
    protected void lazyLoadData() {
        mPresenter.getMulDynamicData();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @OnClick(R.id.cl_all)
    public void onClickAllExpand(View view) {
        if (mExpand.isExpanded()) {
            mExpand.collapse();
        } else {
            mExpand.expand();
        }
    }

    @OnClick({R.id.tv_all_select, R.id.tv_up_select, R.id.tv_bangumi_select})
    public void onClickSelect(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.tv_all_select:
                mTvAllSelect.setSelected(true);
                mTvUpSelect.setSelected(false);
                mTvBangumiSelect.setSelected(false);
                mExpand.collapse();
                break;
            case R.id.tv_up_select:
                mTvAllSelect.setSelected(false);
                mTvUpSelect.setSelected(true);
                mTvBangumiSelect.setSelected(false);
                mExpand.collapse();
                break;
            case R.id.tv_bangumi_select:
                mTvAllSelect.setSelected(false);
                mTvUpSelect.setSelected(false);
                mTvBangumiSelect.setSelected(true);
                mExpand.collapse();
                break;
        }
    }

    @Override
    protected void initRecyclerView() {
        mAdapter = new DynamicAdapter(mList);
        mRecycler.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void showMulDynamic(List<MulDynamic> mulDynamic) {
        mList.addAll(mulDynamic);
        finishTask();
    }

    @Override
    protected void finishTask() {
        mAdapter.notifyDataSetChanged();
    }
}
