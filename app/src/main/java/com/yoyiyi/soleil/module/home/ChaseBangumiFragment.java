package com.yoyiyi.soleil.module.home;

import android.support.v7.widget.LinearLayoutManager;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.home.section.chase.ChaseAdSection;
import com.yoyiyi.soleil.adapter.home.section.chase.ChaseFollowSection;
import com.yoyiyi.soleil.adapter.home.section.chase.ChaseIndexSection;
import com.yoyiyi.soleil.adapter.home.section.chase.ChaseRecommendCNSection;
import com.yoyiyi.soleil.adapter.home.section.chase.ChaseRecommendJPSection;
import com.yoyiyi.soleil.base.BaseRefreshFragment;
import com.yoyiyi.soleil.bean.chase.ChaseBangumi;
import com.yoyiyi.soleil.bean.chase.RecommendBangumi;
import com.yoyiyi.soleil.mvp.contract.home.ChaseBangumiContract;
import com.yoyiyi.soleil.mvp.presenter.home.ChaseBangumiPresenter;
import com.yoyiyi.soleil.utils.EmptyUtils;
import com.yoyiyi.soleil.widget.section.SectionedRVAdapter;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 14:23
 * 描述:首页追番
 */

public class ChaseBangumiFragment extends BaseRefreshFragment<ChaseBangumiPresenter, ChaseBangumi.FollowsBean>
        implements ChaseBangumiContract.View {
    private SectionedRVAdapter mSectionedAdapter;
    private volatile ChaseBangumi mChaseBangumi;
    private RecommendBangumi.RecommendCnBean mRecommendCnBean;
    private RecommendBangumi.RecommendJpBean mRecommendJpBean;
    private RecommendBangumi mRecommendBangumi;

    public static ChaseBangumiFragment newInstance() {
        return new ChaseBangumiFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_chase_bangumi;
    }

    @Override
    protected void clear() {
        mSectionedAdapter.removeAllSections();
    }

    @Override
    protected void lazyLoadData() {
        mPresenter.getChaseBangumiData();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initRecyclerView() {
        mSectionedAdapter = new SectionedRVAdapter();
        mRecycler.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(mSectionedAdapter);
    }

    @Override
    public void showChaseBangumi(ChaseBangumi chaseBangumi) {
        mChaseBangumi = chaseBangumi;
    }

    @Override
    public void showRecommendBangumi(RecommendBangumi recommendBangumi) {
        mList.addAll(mChaseBangumi.follows);
        mRecommendBangumi = recommendBangumi;
        mRecommendCnBean = recommendBangumi.recommend_cn;
        mRecommendJpBean = recommendBangumi.recommend_jp;
        finishTask();
    }


    @Override
    protected void finishTask() {
        mSectionedAdapter.addSection(new ChaseIndexSection());
        mSectionedAdapter.addSection(new ChaseFollowSection(mChaseBangumi.update_count + "", mList));
        if (EmptyUtils.isNotEmpty(mRecommendBangumi.ad)) {
            mSectionedAdapter.addSection(new ChaseAdSection(mRecommendBangumi.ad.get(0)));
        }
        mSectionedAdapter.addSection(new ChaseRecommendJPSection(mRecommendJpBean.recommend, mRecommendJpBean.foot.get(0)));
        mSectionedAdapter.addSection(new ChaseRecommendCNSection(mRecommendCnBean.recommend, mRecommendCnBean.foot.get(0)));
        mSectionedAdapter.notifyDataSetChanged();
    }
}
