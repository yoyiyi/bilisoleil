package com.yoyiyi.soleil.adapter.home.section.live;

import android.content.Context;
import android.widget.ImageView;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.live.LivePartition;
import com.yoyiyi.soleil.module.app.BrowerActivity;
import com.yoyiyi.soleil.widget.section.StatelessSection;
import com.yoyiyi.soleil.widget.section.ViewHolder;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 22:27
 * 描述:首页直播轮播条
 */
public class LiveBannerSection extends StatelessSection {

    private List<LivePartition.BannerBean> mList;

    public LiveBannerSection(List<LivePartition.BannerBean> list) {
        super(R.layout.layout_banner, R.layout.layout_empty);
        mList = list;
    }


    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        Banner bannar = holder.getView(R.id.banner);
        List<String> urls = Stream.of(mList).map(bannerBean -> bannerBean.img).collect(Collectors.toList());
        bannar.setIndicatorGravity(BannerConfig.RIGHT)
                .setImages(urls)
                .setImageLoader(new GlideImageLoader())
                .start();
        bannar.setOnBannerListener(i -> {
            LivePartition.BannerBean bannerBean = mList.get(i);
            BrowerActivity.startActivity(mContext,bannerBean.link,bannerBean.title,bannerBean.img);
        });

    }

    static class GlideImageLoader extends ImageLoader {
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
