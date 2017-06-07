package com.yoyiyi.soleil.module.home;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;

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
import com.yoyiyi.soleil.widget.divider.VerticalDividerItemDecoration;
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
        return R.layout.fragment_home_live;
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
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (mSectionedAdapter.getSectionItemViewType(position)) {
                    case SectionedRVAdapter.VIEW_TYPE_HEADER:
                        return 3;//2格
                    case SectionedRVAdapter.VIEW_TYPE_FOOTER:
                        return 3;//2格
                    default:
                        return 1;
                }
            }
        });
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(mSectionedAdapter);
        //添加分割线
        VerticalDividerItemDecoration build = new VerticalDividerItemDecoration.Builder(getActivity())
                //.color(AppUtils.getColor(R.color.transparent))
                .color(Color.RED)
                .margin(20,20)
                .sizeResId(R.dimen.dp10)
                .showLastDivider()
                .visibilityProvider((position, parent) -> {
                    if (position < 2) {
                        return true;
                    } else {
                        return false;
                    }
                })
                .build();
        mRecycler.addItemDecoration(build);
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
