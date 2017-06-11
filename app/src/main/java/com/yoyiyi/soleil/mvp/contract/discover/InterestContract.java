package com.yoyiyi.soleil.mvp.contract.discover;

import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.discover.Community;
import com.yoyiyi.soleil.bean.discover.InterestAd;
import com.yoyiyi.soleil.bean.discover.InterestCategrory;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/12 10:09
 * 描述:话题中心Contract
 */

public interface InterestContract {

    interface View extends BaseContract.BaseView {

        void showInterestAd(InterestAd interestAdList);

        void showCommunity(Community community);

        void showInterestCategrory(List<InterestCategrory.ResultBean> interestCategroryList);

        void onComplete();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getInterestData();
    }
}
