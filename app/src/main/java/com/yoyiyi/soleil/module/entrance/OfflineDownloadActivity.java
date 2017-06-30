package com.yoyiyi.soleil.module.entrance;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseActivity;
import com.yoyiyi.soleil.utils.ToastUtils;
import com.yoyiyi.soleil.utils.sdcard.SDCardUtils;
import com.yoyiyi.soleil.widget.progress.NumberProgressBar;

import butterknife.BindView;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/30 22:41
 * 描述:离线缓存
 */
public class OfflineDownloadActivity extends BaseActivity {
    @BindView(R.id.progress_bar)
    NumberProgressBar mProgressBar;
    @BindView(R.id.tv_cache_size)
    TextView mTvCacheSize;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_offline_download;
    }

    @Override
    protected void initWidget() {
        String allSpace = SDCardUtils.getAllSpace();
        String freeSpace = SDCardUtils.getFreeSpace();
        int progress = countProgress( Float.parseFloat( allSpace
                .replaceAll("GB","")
                .replaceAll("MB","")
                .replaceAll("KB","")
        ),  Float.parseFloat(freeSpace
                .replaceAll("GB","")
                .replaceAll("MB","")
                .replaceAll("KB","")
        ));
        mProgressBar.setProgress(progress);
        mTvCacheSize.setText("主存储:" + allSpace + "/" + "可用:" + freeSpace);
    }

    private int countProgress(float allSpace, float freeSpace) {
        //取整相减
        int size = (int) (Math.floor(allSpace) - Math.floor(freeSpace));
        double v = (size / Math.floor(allSpace)) * 100;
        return (int) Math.floor(v);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_off, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_more) {
            ToastUtils.showLongToast("离线设置");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
       mToolbar.setTitle("离线缓存");
    }
}
