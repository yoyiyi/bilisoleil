package com.yoyiyi.soleil.module.bangumi;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseRefreshActivity;
import com.yoyiyi.soleil.bean.bangumi.BangumiDetail;
import com.yoyiyi.soleil.bean.bangumi.BangumiDetailComment;
import com.yoyiyi.soleil.bean.bangumi.BangumiDetailRecommend;
import com.yoyiyi.soleil.mvp.contract.bangumi.BangumiDetailContract;
import com.yoyiyi.soleil.mvp.presenter.bangumi.BangumiDetailPresenter;

import javax.annotation.Nullable;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/10 14:39
 * 描述:
 */
public class BangumiDetailActivity extends BaseRefreshActivity<BangumiDetailPresenter, Nullable> implements BangumiDetailContract.View {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bangumi_detail;
    }

    @Override
    public void showBangumiDetail(BangumiDetail bangumiDetail) {

    }

    @Override
    public void showBangumiDetailComment(BangumiDetailComment bangumiDetailComment) {

    }

    @Override
    public void showBangumiDetailRecommend(BangumiDetailRecommend bangumiDetailRecommend) {

    }


}
