package com.yoyiyi.soleil.mvp.contract.app.up;


import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.user.MulUpDetail;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 9:45
 * 描述:欢迎界面Contract
 */

public interface ArchiveContract {
    interface View extends BaseContract.BaseView {

        void showArchive(List<MulUpDetail> mulUpDetailList);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getArchiveData();

    }
}
