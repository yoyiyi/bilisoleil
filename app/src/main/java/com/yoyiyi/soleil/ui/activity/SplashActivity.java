package com.yoyiyi.soleil.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yoyiyi.soleil.BiliSoleilApplication;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.app.Splash;
import com.yoyiyi.soleil.constant.Constants;
import com.yoyiyi.soleil.di.component.DaggerActivityComponent;
import com.yoyiyi.soleil.di.module.ActivityModule;
import com.yoyiyi.soleil.mvp.contract.app.SplashContract;
import com.yoyiyi.soleil.mvp.presenter.app.SplashPresenter;
import com.yoyiyi.soleil.ui.activity.home.MainActivity;
import com.yoyiyi.soleil.ui.widget.statusbar.StatusBarUtil;
import com.yoyiyi.soleil.utils.PrefsUtils;
import com.yoyiyi.soleil.utils.image.ImageLoader;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/4/28 11:27
 * 描述:欢迎界面
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG             #
 * #                                                   #
 */

public class SplashActivity extends RxAppCompatActivity implements SplashContract.View {
    @Inject
    SplashPresenter mPresenter;
    @BindView(R.id.iv_splash)
    ImageView mIvSplash;
    @BindView(R.id.tv_count_down)
    TextView mTvCountDown;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        //设置透明
        StatusBarUtil.setTransparent(this);
        ButterKnife.bind(this);
        initInject();
        loadData();

    }

    private void loadData() {
        mPresenter.getSplashData();
        mPresenter.setCountDown();
    }

    /**
     * 注入依赖
     */
    private void initInject() {
        DaggerActivityComponent.builder()
                .appComponent(BiliSoleilApplication.getInstance().getAppComponent())
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);
        mPresenter.attachView(this);
    }

    @Override
    public void showError(String msg) {
        //设置默认图片
        // mIvSplash.setImageResource(R.);
    }


    @Override
    protected void onDestroy() {
        if (mPresenter != null) mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void complete() {

    }

    @Override
    public void showSplash(Splash splash) {
        ImageLoader.load(this, splash.data.get(0).thumb, mIvSplash);
    }

    @Override
    public void showCountDown(int count) {
        mTvCountDown.setText(count + "");
        if (count == 0) {
            redirect();
        }
    }

    /**
     * 跳转到首页
     */
    private void redirect() {
        boolean flag = PrefsUtils.getInstance().getBoolean(Constants.IS_LOGINED_FLAG, false);
        if (flag)
            startActivity(new Intent(this, MainActivity.class));
        else
            startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
