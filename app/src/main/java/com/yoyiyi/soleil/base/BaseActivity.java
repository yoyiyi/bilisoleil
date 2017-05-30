package com.yoyiyi.soleil.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yoyiyi.soleil.BiliSoleilApplication;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.di.component.ActivityComponent;
import com.yoyiyi.soleil.di.component.DaggerActivityComponent;
import com.yoyiyi.soleil.di.module.ActivityModule;
import com.yoyiyi.soleil.widget.statusbar.StatusBarUtil;
import com.yoyiyi.soleil.utils.AppUtils;

import javax.inject.Inject;

import butterknife.ButterKnife;


/**
 * 基础Activity
 * Created by zzq on 2016/12/5.
 */
public abstract class BaseActivity<T extends BaseContract.BasePresenter> extends RxAppCompatActivity implements BaseContract.BaseView {

    @Inject
    protected T mPresenter;
    protected Toolbar mToolbar;//Toolbar
    protected Context mContext;//上下文环境
    protected DrawerLayout mDrawerLayout;
    protected boolean mBack = true;
    private ConstraintLayout mError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mContext = this;
        ButterKnife.bind(this);
        mDrawerLayout = ButterKnife.findById(this, R.id.drawer_layout);
        mToolbar = ButterKnife.findById(this, R.id.toolbar);
        mError = ButterKnife.findById(this, R.id.cl_error);
        initStatusBar();
        initInject();
        initPresenter();
        initVariables();
        BiliSoleilApplication.getInstance().addActivity(this);
        if (mToolbar != null) {
            //初始化Toolbar
            initToolbar();
            //让组件支持Toolbar
            setSupportActionBar(mToolbar);
            if (mBack) mToolbar.setNavigationOnClickListener(v -> finish());
        }
        initWidget();
        initDatas();
    }


    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(BiliSoleilApplication.getInstance().getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    /**
     * 注入依赖
     */
    protected void initInject() {

    }

    /**
     * 完成请求
     */
    protected void finishTask() {
    }

    /**
     * 初始化StatusBar
     */
    protected void initStatusBar() {
        if (mDrawerLayout != null) {
            StatusBarUtil.setColorNoTranslucentForDrawerLayout((Activity) mContext, mDrawerLayout, AppUtils.getColor(R.color.colorPrimary));
        } else {
            StatusBarUtil.setColorNoTranslucent((Activity) mContext, AppUtils.getColor(R.color.colorPrimary));

        }
    }


    /**
     * 初始化Presenter
     */
    private void initPresenter() {
        if (mPresenter != null) mPresenter.attachView(this);
    }


    @Override
    public void showError(String msg) {
        if (mError != null) {
            visible(mError);
        }
    }

    @Override
    public void complete() {
        if (mError != null) {
            gone(mError);
        }
    }

    /**
     * 销毁
     */
    @Override
    protected void onDestroy() {
        if (mPresenter != null) mPresenter.detachView();
        BiliSoleilApplication.getInstance().removeActivity(this);
        super.onDestroy();
    }

    /**
     * 初始化Toolbar
     */
    protected void initToolbar() {
        if (mBack) mToolbar.setNavigationIcon(R.drawable.ic_clip_back_white);
    }

    /**
     * 布局文件
     *
     * @return 布局文件
     */
    protected abstract
    @LayoutRes
    int getLayoutId();

    /**
     * 初始化控件
     */
    protected void initWidget() {
    }

    /**
     * 加载数据
     */
    protected void loadData() {
    }

    /**
     * 初始化数据
     */
    protected void initDatas() {
        loadData();
    }

    /**
     * 初始化变量
     */
    protected void initVariables() {
    }

    /**
     * 隐藏View
     *
     * @param views 视图
     */
    protected void gone(final View... views) {
        if (views != null && views.length > 0) {
            for (View view : views) {
                if (view != null) {
                    view.setVisibility(View.GONE);
                }
            }
        }
    }

    /**
     * 显示View
     *
     * @param views 视图
     */
    protected void visible(final View... views) {
        if (views != null && views.length > 0) {
            for (View view : views) {
                if (view != null) {
                    view.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}
