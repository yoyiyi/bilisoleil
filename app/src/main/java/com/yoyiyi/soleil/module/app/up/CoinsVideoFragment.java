package com.yoyiyi.soleil.module.app.up;

import android.os.Bundle;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseFragment;
import com.yoyiyi.soleil.constant.Constants;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/16 15:09
 * 描述:投币
 */

public class CoinsVideoFragment extends BaseFragment{

    private int mSetting;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_up_coins_video;
    }
    public static CoinsVideoFragment newInstance(int setting){
        CoinsVideoFragment fragment = new CoinsVideoFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.EXTRA_SETTING,setting);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public void initVariables() {
        Bundle bundle = getArguments();
        if (bundle!=null){
            mSetting = bundle.getInt(Constants.EXTRA_SETTING);
        }
    }
}
