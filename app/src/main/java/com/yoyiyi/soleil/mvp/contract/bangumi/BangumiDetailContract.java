package com.yoyiyi.soleil.mvp.contract.bangumi;

import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.bangumi.BangumiDetail;
import com.yoyiyi.soleil.bean.bangumi.BangumiDetailComment;
import com.yoyiyi.soleil.bean.bangumi.BangumiDetailRecommend;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/12 10:09
 * 描述:番剧详情Contract
 */

public interface BangumiDetailContract {

    interface View extends BaseContract.BaseView {


        void showBangumiDetail(BangumiDetail bangumiDetail);

        void showBangumiDetailComment(BangumiDetailComment bangumiDetailComment);

        void showBangumiDetailRecommend(BangumiDetailRecommend bangumiDetailRecommend);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getBangumiDetailData();

    }
}
