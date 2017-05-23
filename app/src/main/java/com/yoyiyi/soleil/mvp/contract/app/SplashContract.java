package com.yoyiyi.soleil.mvp.contract.app;


import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.app.Splash;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 9:45
 * 描述:欢迎界面Contract
 */

public interface SplashContract {
    interface View extends BaseContract.BaseView {
        void showSplash(Splash splash);

        void showCountDown(int count);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getSplashData();

        void setCountDown();

    }
}
