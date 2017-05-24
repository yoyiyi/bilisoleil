package com.yoyiyi.soleil.ui.adapter.home.section.live;

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
import com.yoyiyi.soleil.bean.live.LiveRecommend;
import com.yoyiyi.soleil.ui.widget.section.StatelessSection;
import com.yoyiyi.soleil.ui.widget.section.ViewHolder;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 22:27
 * 描述:
 */
public class LiveBannerSection extends StatelessSection {

    private List<LiveRecommend.DataBean.BannerBean> mList;

    public LiveBannerSection(List<LiveRecommend.DataBean.BannerBean> list) {
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
    }

    class GlideImageLoader extends ImageLoader {
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
