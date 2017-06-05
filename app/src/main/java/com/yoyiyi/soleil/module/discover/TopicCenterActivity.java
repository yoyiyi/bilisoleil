package com.yoyiyi.soleil.module.discover;

import android.support.v7.widget.LinearLayoutManager;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.discover.TopicCenterAdapter;
import com.yoyiyi.soleil.base.BaseRefreshActivity;
import com.yoyiyi.soleil.bean.discover.TopicCenter;
import com.yoyiyi.soleil.mvp.contract.discover.TopicCenterContract;
import com.yoyiyi.soleil.mvp.presenter.discover.TopicCenterPresenter;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/5 22:28
 * 描述:话题中心
 */
public class TopicCenterActivity extends BaseRefreshActivity<TopicCenterPresenter, TopicCenter.ListBean> implements TopicCenterContract.View {

    private TopicCenterAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_topic_center;
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        mToolbar.setTitle("话题中心");
    }

    @Override
    protected void loadData() {
        mPresenter.getTopicCenterData();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initRecyclerView() {
        mAdapter = new TopicCenterAdapter(mList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void showTopicCenter(List<TopicCenter.ListBean> topicCenterList) {
        mList.addAll(topicCenterList);
        finishTask();
    }

    @Override
    protected void finishTask() {
        mAdapter.notifyDataSetChanged();
    }
}
