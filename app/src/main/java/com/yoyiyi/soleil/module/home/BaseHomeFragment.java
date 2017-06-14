package com.yoyiyi.soleil.module.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/14 14:12
 * 描述:首页基础base
 */

public abstract class BaseHomeFragment extends BaseFragment {
    public Toolbar mToolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);//支持menu
    }

    @Override
    public void initWidget() {
        initToolbar();
    }

    @SuppressLint("CheckResult")
    private void initToolbar() {
        mToolbar = ButterKnife.findById(mRootView, R.id.toolbar);
        if (mToolbar != null) {
            mToolbar.setTitle("");
            ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
            //换成下面这句就OK了
            mToolbar.inflateMenu(R.menu.menu_main);
        }
    }
}
