package com.yoyiyi.soleil.adapter.region.sectiton;

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
import com.yoyiyi.soleil.bean.region.RegionRecommend;
import com.yoyiyi.soleil.module.app.BrowerActivity;
import com.yoyiyi.soleil.widget.section.StatelessSection;
import com.yoyiyi.soleil.widget.section.ViewHolder;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/21 11:57
 * 描述:分区推荐主播section
 */
public class RegionRecommendBannerSection extends StatelessSection {
    private List<RegionRecommend.BannerBean.TopBean> mList;

    public RegionRecommendBannerSection(List<RegionRecommend.BannerBean.TopBean> list) {
        super(R.layout.layout_banner, R.layout.layout_empty);
        mList = list;
    }

    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        Banner bannar = holder.getView(R.id.banner);
        List<String> urls = Stream.of(mList).map(bannerBean -> bannerBean.image).collect(Collectors.toList());
        bannar.setIndicatorGravity(BannerConfig.RIGHT)
                .setImages(urls)
                .setImageLoader(new GlideImageLoader())
                .start();
        bannar.setOnBannerListener(i -> {
            RegionRecommend.BannerBean.TopBean bannerBean = mList.get(i);
            BrowerActivity.startActivity(mContext,bannerBean.uri,bannerBean.title);
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
