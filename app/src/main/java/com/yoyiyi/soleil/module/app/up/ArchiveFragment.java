package com.yoyiyi.soleil.module.app.up;

import android.os.Bundle;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseFragment;
import com.yoyiyi.soleil.constant.Constants;
import com.yoyiyi.soleil.mvp.presenter.app.up.ArchivePresenter;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/16 15:09
 * 描述:主页
 */

public class ArchiveFragment extends BaseFragment<ArchivePresenter> {

    private int mSetting;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_up_archive;
    }

    public static ArchiveFragment newInstance(int setting) {
        ArchiveFragment fragment = new ArchiveFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.EXTRA_SETTING, setting);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void loadData() {
        mPresenter.getArchiveData();
    }

    @Override
    public void initVariables() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            mSetting = bundle.getInt(Constants.EXTRA_SETTING);
        }
        if (mSetting == 0) {
            visible(R.id.iv_empty);
        } else {
            gone(R.id.iv_empty);
        }
    }

}
