package com.yoyiyi.soleil.module.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.constant.Constants;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.ClipboardUtils;
import com.yoyiyi.soleil.utils.ToastUtils;
import com.yoyiyi.soleil.widget.ProgressWheel;
import com.yoyiyi.soleil.widget.statusbar.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/9 21:56
 * 描述:浏览器界面
 */
public class BrowerActivity extends AppCompatActivity {
    @BindView(R.id.webView)
    WebView mWebView;
    @BindView(R.id.pw_loading)
    ProgressWheel mPwLoading;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private String mTitle;
    private String mUrl;
    private String mImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brower);
        ButterKnife.bind(this);
        initVariables();

        initWedgit();
        //调用shareSDK
        // ShareSDK.initSDK(this, "");

    }

    public static void startActivity(Context context, String url, String title, String img) {
        Intent intent = new Intent(context, BrowerActivity.class);
        intent.putExtra(Constants.EXTRA_TITLE, title);
        intent.putExtra(Constants.EXTRA_URL, url);
        intent.putExtra(Constants.EXTRA_IMAGE, img);
        context.startActivity(intent);
    }


    private void initToolar() {
        mToolbar.setNavigationIcon(R.drawable.ic_clip_back_white);
        mToolbar.setTitle(TextUtils.isEmpty(mTitle) ? "详情" : mTitle);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    private void initWedgit() {
        initToolar();
        initWebView();
        StatusBarUtil.setColorNoTranslucent(this, AppUtils.getColor(R.color.colorPrimary));
        //强制隐藏加载框
        // AppUtils.runOnUIDelayed(() -> mPwLoading.setVisibility(View.GONE), 650);
    }

    protected void initVariables() {
        Intent intent = getIntent();
        if (intent != null) {
            mTitle = intent.getStringExtra(Constants.EXTRA_TITLE);
            mUrl = intent.getStringExtra(Constants.EXTRA_URL);
            mImg = intent.getStringExtra(Constants.EXTRA_IMAGE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_brower, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_open:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(mUrl));
                startActivity(intent);
                break;
            case R.id.menu_share:
                showShare();
                break;
            case R.id.menu_copy:
                ClipboardUtils.copyText(mUrl);
                ToastUtils.showSingleLongToast("复制成功");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    class WebClientBase extends WebViewClient {
        @Override
        public void onPageStarted(WebView webView, String s, Bitmap bitmap) {
            super.onPageStarted(webView, s, bitmap);
        }

        @Override
        public void onPageFinished(WebView webView, String s) {
            super.onPageFinished(webView, s);
            mPwLoading.setVisibility(View.GONE);
            mWebView.getSettings().setBlockNetworkImage(false);
            int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            mWebView.measure(w, h);
        }

        @Override
        public void onReceivedError(WebView webView, int i, String s, String s1) {
            super.onReceivedError(webView, i, s, s1);
            mPwLoading.setVisibility(View.GONE);
            String errorHtml = "<html><body><h2>找不到网页</h2></body></html>";
            mWebView.loadDataWithBaseURL(null, errorHtml, "text/html", "UTF-8", null);
        }

    }

    @SuppressLint("SetJavaScriptEnabled")
    protected void initWebView() {
        WebClient webChromeClient = new WebClient();
        WebClientBase webViewClient = new WebClientBase();
        WebSettings webSettings = mWebView.getSettings();
        //设置js支持
        webSettings.setJavaScriptEnabled(true);
        // 设置支持javascript脚本
        webSettings.setJavaScriptCanOpenWindowsAutomatically(false);
        //设置缓存
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setDomStorageEnabled(true);
        webSettings.setGeolocationEnabled(true);
        webSettings.setUseWideViewPort(true);//关键点
        webSettings.setLoadWithOverviewMode(true);//全屏
        webSettings.setBuiltInZoomControls(true);// 设置显示缩放按钮
        webSettings.setSupportZoom(true);//支持缩放
        webSettings.setDisplayZoomControls(false);
        webSettings.setAppCacheEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWebView.setDrawingCacheEnabled(true);
        mWebView.getSettings().setBlockNetworkImage(true);
        mWebView.setWebViewClient(webViewClient);
        mWebView.requestFocus(View.FOCUS_DOWN);
        mWebView.getSettings().setDefaultTextEncodingName("UTF-8");
        mWebView.setWebChromeClient(webChromeClient);
        mWebView.loadUrl(mUrl);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
            mWebView.goBack();// 返回前一个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    class WebClient extends WebChromeClient {
        public WebClient() {
            super();
        }

        @Override
        public void onProgressChanged(WebView webView, int i) {
            if (i >= 40) {
                mPwLoading.setVisibility(View.GONE);
            } else {
                mPwLoading.setVisibility(View.VISIBLE);
            }
            mWebView.getSettings().setBlockNetworkImage(false);
            super.onProgressChanged(webView, i);
        }
    }

    @Override
    protected void onDestroy() {
        mWebView.destroy();
        super.onDestroy();
    }

    private void showShare() {
        //  ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("来自" + getString(R.string.app_name) + "的分享");
        // titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl(mUrl);
        // text是分享文本，所有平台都需要这个字段
        oks.setText(mTitle+"" + mUrl);
        oks.setImageUrl(mImg);
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(mUrl);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(mUrl);
        // 启动分享GUI
        oks.show(this);
    }
}
