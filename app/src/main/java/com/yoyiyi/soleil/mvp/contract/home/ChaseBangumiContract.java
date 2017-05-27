package com.yoyiyi.soleil.mvp.contract.home;

import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.chase.ChaseBangumi;
import com.yoyiyi.soleil.bean.chase.RecommendBangumi;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 22:02
 * 描述:
 */
public interface ChaseBangumiContract {
    interface View extends BaseContract.BaseView {
        void showChaseBangumi(ChaseBangumi chaseBangumi);

        void showRecommendBangumi(RecommendBangumi recommendBangumi);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getChaseBangumiData();

    }
}
