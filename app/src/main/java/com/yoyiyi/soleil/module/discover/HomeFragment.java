package com.yoyiyi.soleil.module.discover;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.trello.rxlifecycle2.components.support.RxFragment;
import com.yoyiyi.soleil.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/11 12:04
 * 描述:主页
 */
public class HomeFragment extends RxFragment {

    @BindView(R.id.iv_empty)
    ImageView mIvEmpty;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mIvEmpty.setOnClickListener(v -> {
            Activity activity = getActivity();
            if (activity instanceof InterestActivity) {
                InterestActivity interestActivity = (InterestActivity) activity;
                interestActivity.mViewPager.setCurrentItem(1);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
