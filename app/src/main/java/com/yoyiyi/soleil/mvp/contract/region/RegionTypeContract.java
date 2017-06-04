package com.yoyiyi.soleil.mvp.contract.region;

import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.region.RegionType;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/12 10:09
 * 描述:发现Contract
 */

public interface RegionTypeContract {

    interface View extends BaseContract.BaseView {

        void showRegionType(RegionType regionType);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getRegionTypeData(int rid);
    }
}
