package com.yoyiyi.soleil.mvp.contract.bangumi;

import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.bangumi.BangumiIndex;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/12 10:09
 * 描述:番剧索引Contract
 */

public interface BangumiIndexContract {

    interface View extends BaseContract.BaseView {

        void showBangumiIndex(BangumiIndex bangumiIndex);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getBangumiIndex();
    }
}
