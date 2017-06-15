package com.yoyiyi.soleil.adapter.app.video;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.bean.app.video.MulSummary;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/15 10:07
 * 描述:
 */

public class SummaryAdapter extends BaseMultiItemQuickAdapter<MulSummary, BaseViewHolder> {

    public SummaryAdapter(List<MulSummary> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder holder, MulSummary mulSummary) {

    }
}
