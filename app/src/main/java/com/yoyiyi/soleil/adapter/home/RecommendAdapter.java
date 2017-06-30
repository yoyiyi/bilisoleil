package com.yoyiyi.soleil.adapter.home;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.recommend.MulRecommend;
import com.yoyiyi.soleil.bean.recommend.Recommend;
import com.yoyiyi.soleil.module.app.BrowerActivity;
import com.yoyiyi.soleil.module.app.video.VideoDetailActivity;
import com.yoyiyi.soleil.utils.NumberUtils;
import com.yoyiyi.soleil.utils.time.FormatUtils;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/31 11:28
 * 描述:推荐Adapter
 */

public class RecommendAdapter extends BaseMultiItemQuickAdapter<MulRecommend, BaseViewHolder> {
    public RecommendAdapter(List<MulRecommend> data) {
        super(data);
        addItemType(MulRecommend.TYPR_HEADER, R.layout.layout_recommend_banner);
        addItemType(MulRecommend.TYPE_ITEM, R.layout.layout_item_home_recommend_body);
    }

    @Override
    protected void convert(BaseViewHolder holder, MulRecommend mulRecommend) {
        switch (holder.getItemViewType()) {
            case MulRecommend.TYPR_HEADER:
                Banner bannar = holder.getView(R.id.banner);
                List<Recommend.BannerItemBean> banner_item = mulRecommend.mBannerItemBean;
                List<String> urls = Stream.of(banner_item).map(bannerBean -> bannerBean.image).collect(Collectors.toList());
                bannar.setIndicatorGravity(BannerConfig.RIGHT)
                        .setImages(urls)
                        .setImageLoader(new GlideImageLoader())
                        .start();
                bannar.setOnBannerListener(i -> {
                    Recommend.BannerItemBean bannerBean = banner_item.get(i);
                    BrowerActivity.startActivity(mContext, bannerBean.uri, bannerBean.title, bannerBean.image);
                });
                break;

            case MulRecommend.TYPE_ITEM:
                Glide.with(mContext)
                        .load(mulRecommend.mRecommend.cover)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.bili_default_image_tv)
                        .dontAnimate()
                        .into((ImageView) holder.getView(R.id.iv_video_preview));
                holder.setText(R.id.tv_video_play_num, NumberUtils.format(mulRecommend.mRecommend.play + ""))
                        .setText(R.id.tv_video_time, FormatUtils.formatDuration(mulRecommend.mRecommend.duration + ""))
                        .setText(R.id.tv_video_danmaku, NumberUtils.format(mulRecommend.mRecommend.danmaku + ""))
                        .setText(R.id.tv_video_title, mulRecommend.mRecommend.title);
                if (mulRecommend.mRecommend.open != 0) {
                    //直播
                    holder.setText(R.id.tv_video_tag, mulRecommend.mRecommend.area);
                } else {
                    //推荐
                    holder.setText(R.id.tv_video_tag, mulRecommend.mRecommend.tname + " · " + mulRecommend.mRecommend.tag.tag_name);
                }
                holder.itemView.setOnClickListener(view ->
                        mContext.startActivity(new Intent(mContext, VideoDetailActivity.class)));
                break;
        }
    }

    private static class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context)
                    .load((String) path)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .dontAnimate()
                    .into(imageView);
        }
    }
}
