package com.yoyiyi.soleil.ui.fragment.home;

import android.support.v7.widget.GridLayoutManager;

import com.annimon.stream.Stream;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseRefreshFragment;
import com.yoyiyi.soleil.bean.live.LivePartition;
import com.yoyiyi.soleil.bean.live.LiveRecommend;
import com.yoyiyi.soleil.mvp.contract.home.LiveContract;
import com.yoyiyi.soleil.mvp.presenter.home.LivePresenter;
import com.yoyiyi.soleil.ui.adapter.home.section.live.LiveBannerSection;
import com.yoyiyi.soleil.ui.adapter.home.section.live.LiveEntranceSection;
import com.yoyiyi.soleil.ui.adapter.home.section.live.LiveRecommendBannerSection;
import com.yoyiyi.soleil.ui.adapter.home.section.live.LiveRecommendPartitionSection;
import com.yoyiyi.soleil.ui.adapter.home.section.live.LiveRecommendSection;
import com.yoyiyi.soleil.ui.widget.section.SectionedRVAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 14:23
 * 描述:推荐
 */

public class LiveFragment extends BaseRefreshFragment<LivePresenter, LivePartition.PartitionsBean> implements LiveContract.View {

    private SectionedRVAdapter mSectionedAdapter;
    private List<LivePartition.BannerBean> mBannerList = new ArrayList<>();//轮播条
    private List<LiveRecommend.RecommendDataBean.BannerDataBean> mBannerRecommendList = new ArrayList<>();//推荐
    private List<LiveRecommend.RecommendDataBean.LivesBean> mRecommendLiveList = new ArrayList<>();//推荐直播

    private LiveRecommend.RecommendDataBean.PartitionBean mPartitionBean;

    public static LiveFragment newInstance() {
        return new LiveFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_recommend;
    }

    @Override
    protected void lazyLoadData() {
        mPresenter.getLiveData();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
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
    protected void clear() {
        mBannerList.clear();
        mRecommendLiveList.clear();
        mBannerRecommendList.clear();
    }

    @Override
    protected void clearData() {
        super.clearData();
        mSectionedAdapter.removeAllSections();
    }


    @Override
    public void showLiveRecommend(LiveRecommend liveRecommend) {
        mRecommendLiveList.addAll(liveRecommend.recommend_data.lives);
        mBannerRecommendList.addAll(liveRecommend.recommend_data.banner_data);
        mPartitionBean = liveRecommend.recommend_data.partition;
        finishTask();
    }

    @Override
    public void showLivePartition(LivePartition livePartition) {
        mBannerList.addAll(livePartition.banner);
        mList.addAll(livePartition.partitions);

    }

    @Override
    protected void finishTask() {
        mSectionedAdapter.addSection(new LiveBannerSection(mBannerList));
        mSectionedAdapter.addSection(new LiveEntranceSection());
        //推荐主播
        if (mBannerRecommendList.size() != 0) {
            int allot = mRecommendLiveList.size() / 2;
            if (mBannerRecommendList.size() == 1) {
                mSectionedAdapter.addSection(new LiveRecommendSection(true, false,
                        mPartitionBean.name,
                        mPartitionBean.sub_icon.src, mPartitionBean.count + "",
                        mRecommendLiveList.subList(0, allot)));
                mSectionedAdapter.addSection(new LiveRecommendBannerSection(mBannerRecommendList.get(0)));
                mSectionedAdapter.addSection(new LiveRecommendSection(false, true,
                        mPartitionBean.name,
                        mPartitionBean.sub_icon.src, mPartitionBean.count + "",
                        mRecommendLiveList.subList(allot, mRecommendLiveList.size())));
            } else {
                mSectionedAdapter.addSection(new LiveRecommendSection(true, false, mPartitionBean.name,
                        mPartitionBean.sub_icon.src, mPartitionBean.count + "",
                        mRecommendLiveList.subList(0, allot),
                        mBannerRecommendList.get(0)));
                mSectionedAdapter.addSection(new LiveRecommendBannerSection(mBannerRecommendList.get(1)));
                mSectionedAdapter.addSection(new LiveRecommendSection(false, true, mPartitionBean.name,
                        mPartitionBean.sub_icon.src, mPartitionBean.count + "",
                        mRecommendLiveList.subList(allot, mRecommendLiveList.size())));
            }
        } else {
            mSectionedAdapter.addSection(new LiveRecommendSection(true, true, mPartitionBean.name,
                    mPartitionBean.sub_icon.src
                    , mPartitionBean.count + "", mRecommendLiveList));
        }
        //分区
        Stream.of(mList.subList(0, mList.size())).forEach(partitionsBean ->
                mSectionedAdapter.addSection(new LiveRecommendPartitionSection(partitionsBean.partition.name,
                        partitionsBean.partition.sub_icon.src,
                        partitionsBean.partition.count + "", partitionsBean.lives.subList(0, 4))));
        //显示最后加载更多
        /*mSectionedAdapter.addSection(
                new LiveRecommendPartitionSection(true, mList.get(mList.size() - 1).partition.name,
                mList.get(mList.size() - 1).partition.sub_icon.src,
                mList.get(mList.size() - 1).partition.count + "", mList.get(mList.size() - 1).lives.subList(0, 4)));*/
        mSectionedAdapter.notifyDataSetChanged();
    }

}
