package com.yoyiyi.soleil.mvp.contract.bangumi;

import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.bangumi.MulBangumiDetail;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/12 10:09
 * 描述:番剧详情Contract
 */

public interface BangumiDetailContract {

    interface View extends BaseContract.BaseView {



        void showMulBangumiDetail(List<MulBangumiDetail> mulBangumiDetails, String title);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getBangumiDetailData();

    }
}
