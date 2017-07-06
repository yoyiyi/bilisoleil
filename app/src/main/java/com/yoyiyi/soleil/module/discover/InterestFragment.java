package com.yoyiyi.soleil.module.discover;

import android.support.v7.widget.LinearLayoutManager;

import com.annimon.stream.Stream;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.discover.InterestAdapter;
import com.yoyiyi.soleil.base.BaseRefreshFragment;
import com.yoyiyi.soleil.bean.discover.Community;
import com.yoyiyi.soleil.bean.discover.InterestAd;
import com.yoyiyi.soleil.bean.discover.InterestCategrory;
import com.yoyiyi.soleil.bean.discover.MulInterest;
import com.yoyiyi.soleil.mvp.contract.discover.InterestContract;
import com.yoyiyi.soleil.mvp.presenter.discover.InterestPresenter;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.ToastUtils;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/10 22:25
 * 描述:兴趣圈
 */
public class InterestFragment extends BaseRefreshFragment<InterestPresenter, MulInterest> implements InterestContract.View {
    private InterestAdapter mAdapter;
    private InterestAd mInterestAdList;
    private List<InterestCategrory.ResultBean> mInterestCategroryList;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_interest;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }


    @Override
    protected void lazyLoadData() {
        mPresenter.getInterestData();
    }

    @Override
    protected void initRecyclerView() {
        mAdapter = new InterestAdapter(mList);
        mRecycler.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(mAdapter);
    }


    @Override
    public void showInterestAd(InterestAd interestAdList) {
        mInterestAdList = interestAdList;
    }

    @Override
    public void showCommunity(Community community) {
        mList.add(new MulInterest(MulInterest.TYPE_BANNER, mInterestAdList));
        mList.add(new MulInterest(MulInterest.TYPE_CATEGRORY, mInterestCategroryList));
        mList.add(new MulInterest(MulInterest.TYPR_HEADER));
        List<Community.ResultBean> result = community.result;
        Stream.of(result).forEach(result1 -> mList.add(new MulInterest(MulInterest.TYPR_ITEM, result1)));
        finishTask();
    }

    @Override
    public void showInterestCategrory(List<InterestCategrory.ResultBean> interestCategroryList) {
        mInterestCategroryList = interestCategroryList;
    }

    @Override
    public void onComplete() {
        AppUtils.runOnUIDelayed(() -> {
            if (mRefresh != null)
                mRefresh.setRefreshing(false);
        }, 650);
        if (mIsRefreshing) {
            if (mList != null) mList.clear();
            clear();
            ToastUtils.showSingleLongToast("刷新成功");
        }
        mIsRefreshing = false;
    }

    @Override
    protected void finishTask() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void complete() {
        if (mError != null) {
            gone(mError);
        }
    }
}
