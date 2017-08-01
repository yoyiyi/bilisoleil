package com.yoyiyi.soleil.module.app;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseActivity;
import com.yoyiyi.soleil.constant.Constants;
import com.yoyiyi.soleil.module.home.MainActivity;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.NetworkUtils;
import com.yoyiyi.soleil.utils.PrefsUtils;
import com.yoyiyi.soleil.utils.ToastUtils;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/10 14:38
 * 描述:登录界面
 */

public class LoginActivity extends BaseActivity {


    @BindView(R.id.iv_icon_left)
    ImageView mIvIconLeft;
    @BindView(R.id.iv_icon_center)
    ImageView mIvIconCenter;
    @BindView(R.id.iv_icon_right)
    ImageView mIvIconRight;
    @BindView(R.id.rl_logo)
    RelativeLayout mRlLogo;
    @BindView(R.id.et_username)
    EditText mEtUsername;
    @BindView(R.id.delete_username)
    ImageButton mDeleteUsername;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    @BindView(R.id.btn_login)
    Button mBtnLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    protected void initWidget() {
        //名称监听
        RxView.focusChanges(mEtUsername)
                .compose(bindToLifecycle())
                .subscribe(aBoolean -> {
                    if (aBoolean) {
                        if (mEtUsername.getText().length() > 0) {
                            visible(mDeleteUsername);
                        } else {
                            gone(mDeleteUsername);
                        }
                    } else {
                        gone(mDeleteUsername);
                    }
                    mIvIconLeft.setImageResource(R.drawable.ic_22);
                    mIvIconRight.setImageResource(R.drawable.ic_33);
                });
        //密码监听
        RxView.focusChanges(mEtPassword)
                .compose(bindToLifecycle())
                .subscribe(aBoolean -> {
                    if (aBoolean) {
                        mIvIconLeft.setImageResource(R.drawable.ic_22_hide);
                        mIvIconRight.setImageResource(R.drawable.ic_33_hide);
                    }
                });
        //监听名称变化
        RxTextView.textChangeEvents(mEtUsername)
                .compose(bindToLifecycle())
                .subscribe(textViewTextChangeEvent -> {
                    mEtPassword.setText("");
                    if (textViewTextChangeEvent.count() > 0) {
                        visible(mDeleteUsername);
                    } else {
                        gone(mDeleteUsername);
                    }
                });
        //点击登录监听
        RxView.clicks(mBtnLogin)
                .throttleFirst(5, TimeUnit.SECONDS)//5秒内取第一个事件 防止重复点击发送事件
                .compose(bindToLifecycle())
                .subscribe(o -> {
                    boolean isAvailable = NetworkUtils.isConnected(AppUtils.getAppContext());
                    if (!isAvailable) {
                        ToastUtils.showCenterSingleToast("当前网络不可用");
                    } else {
                        //登录
                        login();
                    }
                });
        //点击删除监听
        RxView.clicks(mDeleteUsername)
                .throttleFirst(5, TimeUnit.SECONDS)//5秒内取第一个事件 防止重复
                .compose(bindToLifecycle())
                .subscribe(o -> {
                    // 清空用户名以及密码
                    mEtUsername.setText("");
                    mEtPassword.setText("");
                    mDeleteUsername.setVisibility(View.GONE);
                    mEtUsername.setFocusable(true);
                    mEtUsername.setFocusableInTouchMode(true);
                    mEtUsername.requestFocus();
                });
    }

    /**
     * 假登录
     */
    private void login() {
        String name = mEtUsername.getText().toString();
        String password = mEtPassword.getText().toString();
        if (TextUtils.isEmpty(name)) {
            ToastUtils.showCenterSingleToast("用户名不能为空");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            ToastUtils.showCenterSingleToast("密码不能为空");
            return;
        }

        PrefsUtils.getInstance().putBoolean(Constants.IS_LOGINED_FLAG, true);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        mToolbar.setTitle("登录");
    }

}
