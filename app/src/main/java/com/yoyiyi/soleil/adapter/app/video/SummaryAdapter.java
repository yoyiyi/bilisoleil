package com.yoyiyi.soleil.adapter.app.video;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.annimon.stream.Stream;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.app.video.MulSummary;
import com.yoyiyi.soleil.utils.NumberUtils;
import com.yoyiyi.soleil.utils.time.TimeUtils;
import com.yoyiyi.soleil.widget.flowlayout.FlowLayout;
import com.yoyiyi.soleil.widget.flowlayout.TagAdapter;
import com.yoyiyi.soleil.widget.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/15 10:07
 * 描述:
 */

public class SummaryAdapter extends BaseMultiItemQuickAdapter<MulSummary, BaseViewHolder> {

    public SummaryAdapter(List<MulSummary> data) {
        super(data);
        addItemType(MulSummary.TYPE_DES, R.layout.layout_item_video_detail_summary_des);
        addItemType(MulSummary.TYPE_OWNER, R.layout.layout_item_video_detail_summary_owner);
        addItemType(MulSummary.TYPE_RELATE, R.layout.layout_item_video_detail_summary_relate);
        addItemType(MulSummary.TYPE_RELATE_HEAD, R.layout.layout_item_video_detail_summary_relate_head);
    }

    @Override
    protected void convert(BaseViewHolder holder, MulSummary mulSummary) {
        switch (mulSummary.getItemType()) {
            case MulSummary.TYPE_DES:
                holder.setText(R.id.tv_title, mulSummary.title)
                        .setText(R.id.tv_video_play_num, NumberUtils.format(mulSummary.state.view + ""))
                        .setText(R.id.tv_video_danmaku, NumberUtils.format(mulSummary.state.danmaku + ""))
                        .setText(R.id.tv_share, NumberUtils.format(mulSummary.state.share + ""))
                        .setText(R.id.tv_coin, NumberUtils.format(mulSummary.state.coin + ""))
                        .setText(R.id.tv_favourite, NumberUtils.format(mulSummary.state.favorite + ""))
                        .setText(R.id.tv_down, "缓存")
                        .setText(R.id.tv_des, mulSummary.desc);

                break;
            case MulSummary.TYPE_OWNER:
                Glide.with(mContext)
                        .load(mulSummary.owner.face)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate()
                        .into((ImageView) holder.getView(R.id.iv_avatar));
                String date = TimeUtils.millis2String((long) (mulSummary.ctime * Math.pow(10, 3)));
                String[] split = date.split("-");
                holder.setText(R.id.tv_name, mulSummary.owner.name)
                        .setText(R.id.tv_time, split[0] + "年" + split[1] + "月" +  (split[2].split(" "))[0] + "日" + "投递");

                TagFlowLayout tagsLayout = holder.getView(R.id.tags_layout);
                List<String > tag = new ArrayList<>();
                Stream.of(mulSummary.tags).forEach(tagBean -> tag.add(tagBean.tag_name));
                tagsLayout.setAdapter(new TagAdapter<String>(tag) {
                    @Override
                    public View getView(FlowLayout flowLayout, int i, String  listBean) {
                        TextView mTags = (TextView) LayoutInflater.from(mContext)
                                .inflate(R.layout.layout_hot_tags_item, flowLayout, false);
                        mTags.setText(listBean);
                        //mTags.setOnClickListener(view -> TotalSearchActivity.startActivity(mContext, listBean.keyword));
                        return mTags;
                    }
                });
                break;

            case MulSummary.TYPE_RELATE_HEAD:


                break;
            case MulSummary.TYPE_RELATE:
                Glide.with(mContext)
                        .load(mulSummary.relates.pic)
                        .centerCrop()
                        .placeholder(R.drawable.bili_default_image_tv)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate()
                        .into((ImageView) holder.getView(R.id.iv_video_preview));
                holder.setText(R.id.tv_video_title, mulSummary.relates.title)
                        .setText(R.id.tv_video_up, mulSummary.relates.owner.name)
                        .setText(R.id.tv_video_play, NumberUtils.format(mulSummary.relates.stat.view + ""))
                        .setText(R.id.tv_video_danmaku, NumberUtils.format(mulSummary.relates.stat.danmaku + ""));
                break;
        }
    }
}
