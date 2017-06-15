package com.yoyiyi.soleil.module.bangumi;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.bangumi.BangumiDetailAdapter;
import com.yoyiyi.soleil.base.BaseRefreshActivity;
import com.yoyiyi.soleil.bean.bangumi.MulBangumiDetail;
import com.yoyiyi.soleil.mvp.contract.bangumi.BangumiDetailContract;
import com.yoyiyi.soleil.mvp.presenter.bangumi.BangumiDetailPresenter;
import com.yoyiyi.soleil.widget.statusbar.StatusBarUtil;

import java.util.List;

import butterknife.BindView;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/10 14:39
 * 描述:番剧详情界面
 */
public class BangumiDetailActivity extends BaseRefreshActivity<BangumiDetailPresenter, MulBangumiDetail> implements BangumiDetailContract.View {

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private int mDistanceY;
    private BangumiDetailAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bangumi_detail;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }


    @Override
    protected void initToolbar() {
        super.initToolbar();
        mToolbar.setTitle("");//设置标题

    }

    @Override
    protected void initRecyclerView() {
        mAdapter = new BangumiDetailAdapter(mList);
        mRecycler.setHasFixedSize(true);
        mRecycler.setNestedScrollingEnabled(false);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(mAdapter);
        initHead();
        mAdapter.notifyDataSetChanged();
    }

    private void initHead() {
        mList.add(new MulBangumiDetail()
                .setItemType(MulBangumiDetail.TYPE_HEAD)
                .setPrepare(true));
    }

    @Override
    protected void loadData() {
        mPresenter.getBangumiDetailData();
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        mRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //滑动的距离
                mDistanceY += dy;
                //toolbar的高度
                int toolbarHeight = mToolbar.getBottom();
                //当滑动的距离 <= toolbar高度的时候，改变Toolbar背景色的透明度，达到渐变的效果
                if (mDistanceY <= toolbarHeight) {
                    float scale = (float) mDistanceY / toolbarHeight;
                    float alpha = scale * 255;
                    mToolbar.setBackgroundColor(Color.argb((int) alpha, 251, 114, 153));
                } else {
                    //上述虽然判断了滑动距离与toolbar高度相等的情况，但是实际测试时发现，标题栏的背景色
                    //很少能达到完全不透明的情况，所以这里又判断了滑动距离大于toolbar高度的情况，
                    //将标题栏的颜色设置为完全不透明状态
                    mToolbar.setBackgroundResource(R.color.colorPrimary);
                }

            }
        });
    }

    @Override
    protected void initStatusBar() {
        StatusBarUtil.setTranslucentForCoordinatorLayout(this, 0);
    }

    @Override
    protected void finishTask() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMulBangumiDetail(List<MulBangumiDetail> mulBangumiDetails, String title) {
        mList.clear();
        mList.addAll(mulBangumiDetails);
        mTvTitle.setText(title);
        finishTask();
    }
}
