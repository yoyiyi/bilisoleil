package com.yoyiyi.soleil.module.bangumi;

import android.support.v7.widget.GridLayoutManager;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.bangumi.BangumiIndexSection;
import com.yoyiyi.soleil.base.BaseRefreshActivity;
import com.yoyiyi.soleil.bean.bangumi.BangumiIndex;
import com.yoyiyi.soleil.mvp.contract.bangumi.BangumiIndexContract;
import com.yoyiyi.soleil.mvp.presenter.bangumi.BangumiIndexPresenter;
import com.yoyiyi.soleil.widget.section.SectionedRVAdapter;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/8 16:35
 * 描述:番剧索引
 */

public class BangumiIndexActivity extends BaseRefreshActivity<BangumiIndexPresenter, BangumiIndex.CategoryBean>
        implements BangumiIndexContract.View {

    private SectionedRVAdapter mSectionedAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_bangumi_schedule;
    }

    @Override
    protected void loadData() {
        mPresenter.getBangumiIndex();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initRecyclerView() {
        mRecycler.setHasFixedSize(true);
        mSectionedAdapter = new SectionedRVAdapter();
        GridLayoutManager mLayoutManager = new GridLayoutManager(mContext, 3);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (mSectionedAdapter.getSectionItemViewType(position)) {
                    case SectionedRVAdapter.VIEW_TYPE_HEADER:
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
    public void showBangumiIndex(BangumiIndex bangumiIndex) {
        mList.addAll(bangumiIndex.category);
        finishTask();
    }

    @Override
    protected void finishTask() {
        mSectionedAdapter.addSection(new BangumiIndexSection(mList));
        mSectionedAdapter.notifyDataSetChanged();

    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        mToolbar.setTitle("索引");
    }


}
