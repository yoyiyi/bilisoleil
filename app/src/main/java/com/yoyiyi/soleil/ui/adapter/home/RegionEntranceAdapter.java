package com.yoyiyi.soleil.ui.adapter.home;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.region.RegionEnter;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 23:30
 * 描述:
 */
public class RegionEntranceAdapter extends BaseQuickAdapter<RegionEnter, BaseViewHolder> {

    public RegionEntranceAdapter(@Nullable List<RegionEnter> data) {
        super(R.layout.item_live_entrance, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RegionEnter item) {
        helper.setText(R.id.tv_title, item.title)
                .setImageResource(R.id.iv_icon, item.img);
    }

}