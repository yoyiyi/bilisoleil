package com.yoyiyi.soleil.ui.fragment.home;

import android.support.v7.widget.GridLayoutManager;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseRefreshFragment;
import com.yoyiyi.soleil.bean.recommend.Recommend;
import com.yoyiyi.soleil.mvp.contract.home.RecommendContract;
import com.yoyiyi.soleil.mvp.presenter.home.RecommendPresenter;
import com.yoyiyi.soleil.ui.widget.section.SectionedRVAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 14:23
 * 描述:推荐
 */

public class RecommendFragment extends BaseRefreshFragment<RecommendPresenter, Recommend>
        implements RecommendContract.View {

    private List<Recommend.BannerItemBean> mBannerItemBeanList = new ArrayList<>();
    private SectionedRVAdapter mSectionedAdapter;

    public static RecommendFragment newInstance() {
        return new RecommendFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_recommend;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void lazyLoadData() {
        mPresenter.getRecommendData();
    }

    @Override
    protected void clearData() {
        mBannerItemBeanList.clear();
    }

    @Override
    protected void initRecyclerView() {
        mSectionedAdapter = new SectionedRVAdapter();
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (mSectionedAdapter.getSectionItemViewType(position)) {
                    case SectionedRVAdapter.VIEW_TYPE_HEADER:
                        return 2;//2格
                    case SectionedRVAdapter.VIEW_TYPE_FOOTER:
                        return 2;//2格
                    default:
                        return 1;
                }
            }
        });
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(mSectionedAdapter);
    }


    @Override
    public void showRecommend(List<Recommend> recommend) {
        if (recommend.get(0).banner_item != null) {
            mBannerItemBeanList.addAll(recommend.get(0).banner_item);
            mList.addAll(recommend.subList(1, mList.size()));
        } else {
            mList.addAll(recommend);
        }
    }
}
