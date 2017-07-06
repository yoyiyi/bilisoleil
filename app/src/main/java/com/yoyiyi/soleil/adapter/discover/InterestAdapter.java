package com.yoyiyi.soleil.adapter.discover;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.yoyiyi.soleil.bean.discover.Community;
import com.yoyiyi.soleil.bean.discover.InterestAd;
import com.yoyiyi.soleil.bean.discover.MulInterest;
import com.yoyiyi.soleil.module.app.BrowerActivity;
import com.yoyiyi.soleil.utils.TimeUtils;
import com.yoyiyi.soleil.widget.CircleImageView;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/10 22:45
 * 描述:
 */
public class InterestAdapter extends BaseMultiItemQuickAdapter<MulInterest, BaseViewHolder> {

    public InterestAdapter(List<MulInterest> data) {
        super(data);
        addItemType(MulInterest.TYPE_BANNER, R.layout.layout_banner);
        addItemType(MulInterest.TYPE_CATEGRORY, R.layout.layout_item_interest_categroty);
        addItemType(MulInterest.TYPR_HEADER, R.layout.layout_item_interest_head);
        addItemType(MulInterest.TYPR_ITEM, R.layout.layout_item_interest_item);

    }

    @Override
    protected void convert(BaseViewHolder holder, MulInterest mulInterest) {
        switch (mulInterest.getItemType()) {
            case MulInterest.TYPE_BANNER:
                Banner banner = holder.getView(R.id.banner);
                List<InterestAd.ResultBean> adList = mulInterest.mInterestAdList.result;
                List<String> urls = Stream.of(adList).map(bannerBean -> bannerBean.ads_image).collect(Collectors.toList());
                banner.setIndicatorGravity(BannerConfig.RIGHT)
                        .setImages(urls)
                        .setImageLoader(new GlideImageLoader())
                        .start();
                banner.setOnBannerListener(i -> {
                    InterestAd.ResultBean interestAd = adList.get(i);
                    BrowerActivity.startActivity(mContext, interestAd.ads_image_link, interestAd.ads_title,interestAd.ads_image);
                });
                break;
            case MulInterest.TYPE_CATEGRORY:
                RecyclerView recyclerView = holder.getView(R.id.recycler);
                recyclerView.setHasFixedSize(false);
                recyclerView.setNestedScrollingEnabled(false);
                GridLayoutManager layoutManager = new GridLayoutManager(mContext, 4);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(new IntersetCategroyAdapter(mulInterest.mInterestCategroryList));
                break;
            case MulInterest.TYPR_HEADER:

                break;
            case MulInterest.TYPR_ITEM:
                Community.ResultBean community = mulInterest.mCommunity;
                Glide.with(mContext)
                        .load(community.post_info.author_avatar)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate()
                        .into((CircleImageView) holder.getView(R.id.iv_author_avatar));
                holder.setText(R.id.tv_name, community.post_info.author_name)
                        .setText(R.id.tv_summary, community.post_info.post_summary)
                        .setText(R.id.tv_title, community.post_info.post_title)
                        .setText(R.id.tv_group, "["+community.community_info.community_name+"]")
                        .setText(R.id.tv_time, TimeUtils.formatDate(com.yoyiyi.soleil.utils.time.TimeUtils.millis2String(community.post_info.post_time)))
                        .setText(R.id.tv_img_count, community.post_info.image_count + "")
                        .setText(R.id.tv_reply_count, community.post_info.reply_count + "")
                        .setVisible(R.id.iv_image, community.post_info.image_count == 0 ? false : true)
                        .setVisible(R.id.tv_img_count, community.post_info.image_count == 0 ? false : true);
                if (community.post_info.image_count != 0) {
                    Glide.with(mContext)
                            .load(community.post_info.post_image_list.get(0).image_url)
                            .centerCrop()
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .dontAnimate()
                            .into((ImageView) holder.getView(R.id.iv_image));
                }
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
