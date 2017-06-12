package com.yoyiyi.soleil.module.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jakewharton.rxbinding2.view.RxView;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yoyiyi.soleil.BiliSoleilApplication;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.app.Splash;
import com.yoyiyi.soleil.constant.Constants;
import com.yoyiyi.soleil.di.component.DaggerActivityComponent;
import com.yoyiyi.soleil.di.module.ActivityModule;
import com.yoyiyi.soleil.module.home.MainActivity;
import com.yoyiyi.soleil.mvp.contract.app.SplashContract;
import com.yoyiyi.soleil.mvp.presenter.app.SplashPresenter;
import com.yoyiyi.soleil.utils.PrefsUtils;
import com.yoyiyi.soleil.widget.statusbar.StatusBarUtil;

import java.util.Random;
import java.util.concurrent.TimeUnit;

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
    @BindView(R.id.ll_count_down)
    LinearLayout mLlCountDown;

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
        initWidget();
        loadData();

    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) mPresenter.detachView();
        super.onDestroy();
    }

    private void loadData() {
        mPresenter.getSplashData();
        mPresenter.setCountDown();
    }

    private void initWidget() {
        RxView.clicks(mLlCountDown)
                .throttleFirst(3, TimeUnit.SECONDS)//3秒内响应第一次发射数据
                .compose(bindToLifecycle())
                .subscribe(object -> redirect());
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
        mPresenter.attachView(this);//依赖 保持p和v生命周期一致
    }

    @Override
    public void showError(String msg) {
        //设置默认图片
        mIvSplash.setImageResource(R.mipmap.ic_default_bg);
    }


    @Override
    public void complete() {

    }

    @Override
    public void showSplash(Splash splash) {
        if (!splash.data.isEmpty()) {
            int pos = new Random().nextInt(splash.data.size());
            Glide.with(this)
                    .load(splash.data.get(pos).thumb)
                    //.load("http://i0.hdslb.com/bfs/archive/ba17d4df28fb0c28c8f596082d7328b4415ee28b.png")
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .dontAnimate()
                    .into(mIvSplash);
        } else {
            mIvSplash.setImageResource(R.mipmap.ic_default_bg);
        }
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
        if (flag) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

    }
}
