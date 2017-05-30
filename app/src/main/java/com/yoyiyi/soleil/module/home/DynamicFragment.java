package com.yoyiyi.soleil.module.home;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseRefreshFragment;
import com.yoyiyi.soleil.widget.expand.ExpandableLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 14:23
 * 描述:推荐
 */

public class DynamicFragment extends BaseRefreshFragment {

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
    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    @BindView(R.id.refresh)
    SwipeRefreshLayout mRefresh;
    @BindView(R.id.tv_all_select)
    TextView mTvAllSelect;
    @BindView(R.id.tv_up_select)
    TextView mTvUpSelect;
    @BindView(R.id.tv_bangumi_select)
    TextView mTvBangumiSelect;
    @BindView(R.id.expand)
    ExpandableLayout mExpand;

    private String mTextSelect;

    public static DynamicFragment newInstance() {
        return new DynamicFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_dynamic;
    }

    @Override
    public void initWidget() {

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

}
