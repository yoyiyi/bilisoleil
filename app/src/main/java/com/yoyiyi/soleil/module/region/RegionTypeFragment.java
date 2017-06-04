package com.yoyiyi.soleil.module.region;

import android.os.Bundle;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseRefreshFragment;
import com.yoyiyi.soleil.constant.Constants;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/30 18:35
 * 描述:
 */
public class RegionTypeFragment extends BaseRefreshFragment {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_region_type;
    }

    public static RegionTypeFragment newInstance(int tid) {
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.EXTRA_TID, tid);
        RegionTypeFragment fragment = new RegionTypeFragment();
        fragment.setArguments(bundle);
        return fragment;

    }
}
