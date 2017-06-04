package com.yoyiyi.soleil.mvp.contract.region.game;

import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.game.GameCenter;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/12 10:09
 * 描述:发现Contract
 */

public interface GameCenterContract {

    interface View extends BaseContract.BaseView {

        void showGameCenter(GameCenter gameCenter);

        void showLoading();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getGameCenterData();
    }
}
