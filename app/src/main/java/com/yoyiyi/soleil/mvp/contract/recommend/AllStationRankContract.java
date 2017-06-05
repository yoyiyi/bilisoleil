package com.yoyiyi.soleil.mvp.contract.recommend;

import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.recommend.AllStationRank;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/12 10:09
 * 描述:全区排行Contract
 */

public interface AllStationRankContract {

    interface View extends BaseContract.BaseView {

        void showAllStationRank(List<AllStationRank.RankBean.ListBean> regionRank);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getAllStationRankData(String type);
    }
}
