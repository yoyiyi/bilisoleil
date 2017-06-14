package com.yoyiyi.soleil.module.app.video;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseFragment;
import com.yoyiyi.soleil.bean.app.VideoDetail;
import com.yoyiyi.soleil.mvp.contract.app.live.SummaryContract;
import com.yoyiyi.soleil.mvp.presenter.app.live.SummaryPresenter;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/14 15:57
 * 描述:简介
 */

public class SummaryFragment extends BaseFragment<SummaryPresenter> implements SummaryContract.View {

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
    public void showSummary(VideoDetail.DataBean videoDetail) {
        mVideoDetail = videoDetail;
    }
}
