package com.yoyiyi.soleil.adapter.search;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.search.Up;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/19 20:45
 * 描述:
 */
public class UpAdapter extends BaseQuickAdapter<Up.DataBean.ItemsBean,BaseViewHolder> {

    public UpAdapter(@Nullable List<Up.DataBean.ItemsBean> data) {
        super(R.layout.item_search_up, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, Up.DataBean.ItemsBean itemsBean) {
    }
}
