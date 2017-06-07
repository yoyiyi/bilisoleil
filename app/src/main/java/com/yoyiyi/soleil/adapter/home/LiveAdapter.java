package com.yoyiyi.soleil.adapter.home;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
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
import com.yoyiyi.soleil.bean.live.LivePartition;
import com.yoyiyi.soleil.bean.live.LiveRecommend;
import com.yoyiyi.soleil.bean.live.MulLive;
import com.yoyiyi.soleil.bean.live.support.LiveEnter;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.NumberUtils;
import com.yoyiyi.soleil.utils.SpannableStringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/7 11:38
 * 描述:直播界面的Adapter
 */

public class LiveAdapter extends BaseMultiItemQuickAdapter<MulLive, BaseViewHolder> {

    public LiveAdapter(List<MulLive> data) {
        super(data);
        addItemType(MulLive.TYPE_BANNER, R.layout.layout_banner);
        addItemType(MulLive.TYPE_ENTRANCE, R.layout.layout_item_home_live_entrance);
        addItemType(MulLive.TYPR_HEADER, R.layout.layout_item_home_live_head);
        addItemType(MulLive.TYPE_RECOMMEND_ITEM, R.layout.layout_item_home_live_body);
        addItemType(MulLive.TYPE_RECOMMEND_BANNER, R.layout.layout_item_home_live_body);
        addItemType(MulLive.TYPE_PARTY_ITEM, R.layout.layout_item_home_live_body);
        addItemType(MulLive.TYPE_FOOTER, R.layout.layout_item_home_live_footer);
    }

    @Override
    protected void convert(BaseViewHolder holder, MulLive mulLive) {
        switch (holder.getItemViewType()) {
            case MulLive.TYPE_BANNER:
                Banner bannar = holder.getView(R.id.banner);
                List<LivePartition.BannerBean> bannerBeanList = mulLive.mBannerBeanList;
                List<String> urls = Stream.of(bannerBeanList)
                        .map(bannerBean -> bannerBean.img)
                        .collect(Collectors.toList());
                bannar.setIndicatorGravity(BannerConfig.RIGHT)
                        .setImages(urls)
                        .setImageLoader(new GlideImageLoader())
                        .start();
                break;
            case MulLive.TYPE_ENTRANCE:
                List<LiveEnter> liveEnterList = initEntrance();
                RecyclerView recyclerView = holder.getView(R.id.recycler);
                recyclerView.setHasFixedSize(false);
                recyclerView.setNestedScrollingEnabled(false);
                GridLayoutManager layoutManager = new GridLayoutManager(mContext, 5);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(new LiveEntranceAdapter(liveEnterList));

                break;
            case MulLive.TYPE_RECOMMEND_BANNER:
                LiveRecommend.RecommendDataBean.BannerDataBean bannerDataBean = mulLive.mBannerDataBean;
                Glide.with(mContext)
                        .load(bannerDataBean.cover.src)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.bili_default_image_tv)
                        .dontAnimate()
                        .into((ImageView) holder.getView(R.id.iv_video_preview));
                holder.setText(R.id.tv_video_live_up, TextUtils.isEmpty(bannerDataBean.owner.name) ? "未知" : bannerDataBean.owner.name)//up
                        .setText(R.id.tv_video_online, bannerDataBean.online + "");//在线人数;
                SpannableStringBuilder builder = new SpannableStringUtils.Builder()
                        .append("#" + bannerDataBean.area + "#")
                        .append(bannerDataBean.title)
                        .setForegroundColor(AppUtils.getColor(R.color.pink_text_color))
                        .create();
                holder.setText(R.id.tv_video_title, builder);

                break;
            case MulLive.TYPR_HEADER:
                Glide.with(mContext)
                        .load(mulLive.mUrl)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate()
                        .into((ImageView) holder.getView(R.id.iv_icon));
                holder.setText(R.id.tv_title, mulLive.mTitle);
                SpannableStringBuilder headBuilder = new SpannableStringUtils.Builder()
                        .append("当前")
                        .append("" + mulLive.mCount)
                        .setForegroundColor(AppUtils.getColor(R.color.pink_text_color))
                        .append("个直播")
                        .create();
                holder.setText(R.id.tv_online, headBuilder);

                break;
            case MulLive.TYPE_RECOMMEND_ITEM:
                LiveRecommend.RecommendDataBean.LivesBean recommendLivesBean = mulLive.mRecommendLivesBean;
                Glide.with(mContext)
                        .load(recommendLivesBean.cover.src)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.bili_default_image_tv)
                        .dontAnimate()
                        .into((ImageView) holder.getView(R.id.iv_video_preview));
                holder.setText(R.id.tv_video_live_up, recommendLivesBean.owner.name)//up
                        .setText(R.id.tv_video_online, NumberUtils.format(recommendLivesBean.online + ""));//在线人数;
                SpannableStringUtils.Builder Recommendbuilder = new SpannableStringUtils.Builder()
                        .append("#" + recommendLivesBean.area + "#")
                        .setForegroundColor(AppUtils.getColor(R.color.pink_text_color))
                        .append(recommendLivesBean.title);
                holder.setText(R.id.tv_video_title, Recommendbuilder.create());
               /* if (position % 2 == 0) {
                    holder.setVisible(R.id.space, true);
                } else {
                    holder.setVisible(R.id.space, false);
                }
*/
                break;
            case MulLive.TYPE_PARTY_ITEM:
                LivePartition.PartitionsBean.LivesBean partityLivesBean = mulLive.mPartityLivesBean;
                Glide.with(mContext)
                        .load(partityLivesBean.cover.src)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.bili_default_image_tv)
                        .dontAnimate()
                        .into((ImageView) holder.getView(R.id.iv_video_preview));
                holder.setText(R.id.tv_video_live_up, partityLivesBean.owner.name)//up
                        .setText(R.id.tv_video_online, NumberUtils.format(partityLivesBean.online + ""));//在线人数;
                holder.setText(R.id.tv_video_title, partityLivesBean.title);
               /* if (position % 2 == 0) {
                    holder.setVisible(R.id.space, true);
                } else {
                    holder.setVisible(R.id.space, false);
                }
                */
                break;
            case MulLive.TYPE_FOOTER:
                Random random = new Random();
                if (mulLive.mHasMore) {
                    holder.setVisible(R.id.bt_more_live, true);
                } else {
                    holder.setVisible(R.id.bt_more_live, false);
                    holder.getView(R.id.bt_more_live).setOnClickListener(view -> {

                    });
                }
                holder.setText(R.id.tv_dynamic, String.valueOf(random.nextInt(200) + "条新动态，点击这里刷新"));
                holder.getView(R.id.iv_refresh).setOnClickListener(view ->
                        view.animate()
                                .rotation(360)
                                .setInterpolator(new LinearInterpolator())
                                .setDuration(1000).start());
                break;

        }
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

    /**
     * 初始化入口
     */
    private List<LiveEnter> initEntrance() {
        return Arrays.asList(
                new LiveEnter("关注", R.drawable.live_home_follow_anchor),
                new LiveEnter("中心", R.drawable.live_home_live_center),
                new LiveEnter("小视频", R.drawable.live_home_clip_video),
                new LiveEnter("搜索", R.drawable.live_home_search_room),
                new LiveEnter("分类", R.drawable.live_home_all_category));

    }

}
