package com.yoyiyi.soleil.module.app.video;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.app.video.SummaryAdapter;
import com.yoyiyi.soleil.base.BaseFragment;
import com.yoyiyi.soleil.bean.app.VideoDetail;
import com.yoyiyi.soleil.bean.app.video.MulSummary;
import com.yoyiyi.soleil.event.Event;
import com.yoyiyi.soleil.mvp.contract.app.live.SummaryContract;
import com.yoyiyi.soleil.mvp.presenter.app.live.SummaryPresenter;
import com.yoyiyi.soleil.rx.RxBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.functions.Consumer;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/14 15:57
 * 描述:简介
 */

public class SummaryFragment extends BaseFragment<SummaryPresenter> implements SummaryContract.View {
    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    private List<MulSummary> mList = new ArrayList<>();
    private SummaryAdapter mAdapter;
    private VideoDetail.DataBean mVideoDetail;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_summary;
    }

    public static SummaryFragment newInstance() {
        return new SummaryFragment();
    }


    @Override
    protected void loadData() {
        mPresenter.getSummaryData();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }


    @Override
    protected void initRecyclerView() {
        mAdapter = new SummaryAdapter(mList);
        mRecycler.setHasFixedSize(true);
        mRecycler.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    protected void finishTask() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showSummary(List<MulSummary> mulSummaries) {
        mList.addAll(mulSummaries);
        finishTask();
    }


    @Override
    public void initWidget() {
        initRecyclerView();
        RxBus.INSTANCE.toDefaultFlowable(Event.VideoDetailEvent.class, new Consumer<Event.VideoDetailEvent>() {
            @Override
            public void accept(Event.VideoDetailEvent videoDetailEvent) throws Exception {
                mVideoDetail = videoDetailEvent.videoDetail;
            }
        });
    }
}
