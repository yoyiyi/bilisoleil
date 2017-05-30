package com.yoyiyi.soleil.mvp.presenter.region.game;


import com.yoyiyi.soleil.base.RxPresenter;
import com.yoyiyi.soleil.mvp.contract.region.game.GameCenterContract;
import com.yoyiyi.soleil.network.helper.RetrofitHelper;

import javax.inject.Inject;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/17 18:00
 * 描述:游戏中心presenter
 */

public class GameCenterPresenter extends RxPresenter<GameCenterContract.View> implements GameCenterContract.Presenter<GameCenterContract.View> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public GameCenterPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;

    }

    @Override
    public void getGameCenter() {

    }

   /* @Override
    public void getLiveEntranceData() {
        BaseListSubscriber<LiveEntrance> subscriber = mRetrofitHelper.getLiveEntrance()
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseListSubscriber<LiveEntrance>(mView) {
                    @Override
                    public void onSuccess(List<LiveEntrance> liveEntrances) {
                        mView.showLiveEntrance(liveEntrances);
                    }
                });
        addSubscribe(subscriber);

    }
*/
}
