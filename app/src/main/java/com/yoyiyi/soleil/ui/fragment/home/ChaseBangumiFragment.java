package com.yoyiyi.soleil.ui.fragment.home;

import android.support.v7.widget.GridLayoutManager;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseRefreshFragment;
import com.yoyiyi.soleil.bean.chase.ChaseBangumi;
import com.yoyiyi.soleil.bean.chase.RecommendBangumi;
import com.yoyiyi.soleil.mvp.contract.home.ChaseBangumiContract;
import com.yoyiyi.soleil.mvp.presenter.home.ChaseBangumiPresenter;
import com.yoyiyi.soleil.ui.widget.section.SectionedRVAdapter;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 14:23
 * 描述:推荐
 */

public class ChaseBangumiFragment extends BaseRefreshFragment<ChaseBangumiPresenter, ChaseBangumi.FollowsBean>
        implements ChaseBangumiContract.View {

    private SectionedRVAdapter mSectionedAdapter;
    private volatile ChaseBangumi mChaseBangumi;
    private RecommendBangumi.RecommendCnBean mRecommendCnBean;
    private RecommendBangumi.RecommendJpBean mRecommendJpBean;

    public static ChaseBangumiFragment newInstance() {
        return new ChaseBangumiFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_recommend;
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
    }

    @Override
    public void showChaseBangumi(ChaseBangumi chaseBangumi) {
        mChaseBangumi = chaseBangumi;
    }

    @Override
    public void showRecommendBangumi(RecommendBangumi recommendBangumi) {
        mList.addAll(mChaseBangumi.follows);
        mRecommendCnBean = recommendBangumi.recommend_cn;
        mRecommendJpBean = recommendBangumi.recommend_jp;
    }
}
