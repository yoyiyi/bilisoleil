package com.yoyiyi.soleil.adapter.discover;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.discover.ActivityCenter;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/5 23:15
 * 描述:
 */
public class ActivityCenterAdapter extends BaseQuickAdapter<ActivityCenter.ListBean,BaseViewHolder> {
    public ActivityCenterAdapter(@Nullable List<ActivityCenter.ListBean> data) {
        super(R.layout.item_activity_center, data);
    }


    @Override
    protected void convert(BaseViewHolder baseViewHolder, ActivityCenter.ListBean listBean) {

    }
}
