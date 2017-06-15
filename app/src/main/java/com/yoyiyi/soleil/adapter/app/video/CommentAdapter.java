package com.yoyiyi.soleil.adapter.app.video;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.bean.app.video.MulComment;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/15 10:07
 * 描述:
 */

public class CommentAdapter  extends BaseMultiItemQuickAdapter<MulComment,BaseViewHolder>{
    public CommentAdapter(List<MulComment> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder holder, MulComment mulComment) {


    }
}
