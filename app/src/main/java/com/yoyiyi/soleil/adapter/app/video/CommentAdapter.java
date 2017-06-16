package com.yoyiyi.soleil.adapter.app.video;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.app.video.MulComment;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.SpanUtils;
import com.yoyiyi.soleil.utils.time.TimeUtils;
import com.yoyiyi.soleil.widget.CircleImageView;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/15 10:07
 * 描述:
 */

public class CommentAdapter extends BaseMultiItemQuickAdapter<MulComment, BaseViewHolder> {
    public CommentAdapter(List<MulComment> data) {
        super(data);
        addItemType(MulComment.TYPE_COMMENT_HOT_ITEM, R.layout.layout_item_video_detail_comment);
        addItemType(MulComment.TYPE_COMMENT_MORE, R.layout.layout_item_video_detail_more);
        addItemType(MulComment.TYPE_COMMENT_HOT_ITEM, R.layout.layout_item_video_detail_comment);

    }

    @Override
    protected void convert(BaseViewHolder holder, MulComment mulComment) {
        switch (mulComment.getItemType()) {
            case MulComment.TYPE_COMMENT_HOT_ITEM:
                holder.setText(R.id.tv_uname, new SpanUtils()
                        .append(mulComment.hotsBean.member.uname)
                        .setForegroundColor(AppUtils.getColor(R.color.gray_20))
                        .appendSpace(10)
                        .appendImage(getIdRes(mulComment.hotsBean.member.level_info.current_level), SpanUtils.ALIGN_CENTER)
                        .create())
                        .setText(R.id.tv_like, mulComment.hotsBean.like + "")
                        .setText(R.id.tv_floor, "#" + mulComment.hotsBean.floor)
                        .setText(R.id.tv_time, TimeUtils.millis2String((long) (mulComment.hotsBean.ctime * Math.pow(10, 3))))
                        .setText(R.id.tv_message, mulComment.hotsBean.content.message)
                        .setText(R.id.tv_rcount, "共有" + mulComment.hotsBean.rcount + "条回复 >");
                Glide.with(mContext)
                        .load(mulComment.hotsBean.member.avatar)
                        .centerCrop()
                        .placeholder(R.drawable.bili_default_avatar)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate()
                        .into((CircleImageView) holder.getView(R.id.iv_avatar));
                break;
            case MulComment.TYPE_COMMENT_MORE:

                break;

                case MulComment.TYPE_COMMENT_NOMAL_ITEM:
                    holder.setVisible(R.id.tv_rcount, false)
                            .setText(R.id.tv_like, mulComment.repliesBean.like + "")
                            .setText(R.id.tv_uname, new SpanUtils()
                                    .append(mulComment.repliesBean.member.uname + " ")
                                    .setForegroundColor(AppUtils.getColor(R.color.gray_20))
                                    .appendSpace(10)
                                    .appendImage(getIdRes(mulComment.repliesBean.member.level_info.current_level), SpanUtils.ALIGN_CENTER)
                                    .create())
                            .setText(R.id.tv_floor, "#" + mulComment.repliesBean.floor)
                            .setText(R.id.tv_time, com.yoyiyi.soleil.utils.time.TimeUtils.millis2String((long) (mulComment.repliesBean.ctime * Math.pow(10, 3))))
                            .setText(R.id.tv_message, mulComment.repliesBean.content.message);
                    Glide.with(mContext)
                            .load(mulComment.repliesBean.member.avatar)
                            .centerCrop()
                            .placeholder(R.drawable.bili_default_avatar)
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .dontAnimate()
                            .into((CircleImageView) holder.getView(R.id.iv_avatar));
                    break;
        }
    }

    private int getIdRes(int lv) {
        int idRes;
        switch (lv) {
            case 1:
                idRes = R.drawable.ic_lv1;
                break;
            case 2:
                idRes = R.drawable.ic_lv2;
                break;
            case 3:
                idRes = R.drawable.ic_lv3;
                break;
            case 4:
                idRes = R.drawable.ic_lv4;
                break;
            case 5:
                idRes = R.drawable.ic_lv5;
                break;
            case 6:
                idRes = R.drawable.ic_lv6;
                break;
            case 7:
                idRes = R.drawable.ic_lv7;
                break;
            case 8:
                idRes = R.drawable.ic_lv8;
                break;
            case 9:
                idRes = R.drawable.ic_lv9;
                break;
            default:
                idRes = R.drawable.ic_lv0;
                break;
        }
        return idRes;
    }
}
