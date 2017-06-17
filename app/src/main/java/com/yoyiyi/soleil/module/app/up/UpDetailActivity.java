package com.yoyiyi.soleil.module.app.up;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.flyco.tablayout.SlidingTabLayout;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.user.UpDetail;
import com.yoyiyi.soleil.event.Event;
import com.yoyiyi.soleil.module.region.BaseRegionActivity;
import com.yoyiyi.soleil.mvp.contract.app.UpDetailContract;
import com.yoyiyi.soleil.mvp.presenter.app.UpDetailPresenter;
import com.yoyiyi.soleil.rx.RxBus;
import com.yoyiyi.soleil.utils.NumberUtils;
import com.yoyiyi.soleil.utils.SpanUtils;
import com.yoyiyi.soleil.widget.CircleImageView;
import com.yoyiyi.soleil.widget.statusbar.StatusBarUtil;

import java.util.Arrays;

import javax.annotation.Nullable;

import butterknife.BindView;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/16 14:50
 * 描述:up主详情街界面
 */

public class UpDetailActivity extends BaseRegionActivity<UpDetailPresenter, Nullable> implements UpDetailContract.View {
    @BindView(R.id.iv_zone_bg)
    ImageView mIvZoneBg;
    @BindView(R.id.iv_avatar)
    CircleImageView mIvAvatar;
    @BindView(R.id.tv_uname)
    TextView mTvUname;
    @BindView(R.id.tv_favourite)
    TextView mTvFavourite;
    @BindView(R.id.tv_fans)
    TextView mTvFans;
    @BindView(R.id.tv_user_des)
    TextView mTvUserDes;
    @BindView(R.id.tv_pay)
    TextView mTvPay;
    @BindView(R.id.tv_letter)
    TextView mTvLetter;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.line)
    View mLine;
    @BindView(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTabs;
    @BindView(R.id.app_bar_layout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    private UpDetail mUpDetail;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_up_detail;
    }


    @Override
    public void showUpDetail(UpDetail upDetail) {
        mUpDetail = upDetail;
        finishTask();
    }

    @Override
    protected void loadData() {
        mPresenter.getUpDetailData();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }


    @Override
    protected void finishTask() {
        initUpInfo();
        mTitles.addAll(Arrays.asList(
                "主页",
                "投稿(" + mUpDetail.data.archive.count + ")",
                "收藏(" + mUpDetail.data.favourite.count + ")",
                "追番",
                "兴趣圈",
                "投币",
                "游戏"
        ));
        mFragments.add(ArchiveFragment.newInstance(1));
        mFragments.add(SubmitedVideoFragment.newInstance(mUpDetail.data.setting.submited_video));
        mFragments.add(FavouriteFragment.newInstance(mUpDetail.data.setting.fav_video));
        mFragments.add(BangumiFragment.newInstance(mUpDetail.data.setting.bangumi));
        mFragments.add(GroupFragment.newInstance(mUpDetail.data.setting.groups));
        mFragments.add(CoinsVideoFragment.newInstance(mUpDetail.data.setting.coins_video));
        mFragments.add(PlayGamesFragment.newInstance(mUpDetail.data.setting.played_game));

        mViewPager.setOffscreenPageLimit(mTitles.size());
        mViewPager.setAdapter(new BaseRegionTypeAdapte(getSupportFragmentManager(), mTitles, mFragments));
        mSlidingTabLayout.setViewPager(mViewPager);

        initEvent();
    }


    /**
     * 初始化发射事件
     */
    private void initEvent() {
        //投稿
        Event.UpDetailSubmitedVideoEvent upDetailSubmitedVideoEvent = new Event.UpDetailSubmitedVideoEvent();
        upDetailSubmitedVideoEvent.archivList = mUpDetail.data.archive.item;
        RxBus.INSTANCE.post(upDetailSubmitedVideoEvent);
        //
    }


    private void initUpInfo() {
        //设置图片
        Glide.with(mContext)
                .load(mUpDetail.data.card.face)
                .centerCrop()
                .placeholder(R.drawable.bili_default_image_tv)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(mIvAvatar);
        //设置基本信息
        mTvUname.setText(new SpanUtils()
                .append(mUpDetail.data.card.name)
                .appendSpace(18)
                .appendImage(getSex(mUpDetail.data.card.sex), SpanUtils.ALIGN_CENTER)
                .appendSpace(18)
                .appendImage(getLv(mUpDetail.data.card.level_info.current_level), SpanUtils.ALIGN_CENTER)
                .create());
        mTvFans.setText(NumberUtils.format(mUpDetail.data.card.fans + "") + " 粉丝");
        mTvFavourite.setText(NumberUtils.format(mUpDetail.data.card.attention + "") + " 关注");
        mTvUserDes.setText(mUpDetail.data.card.sign);
    }


    @Override
    protected void initToolbar() {
        mToolbar.setNavigationIcon(R.drawable.ic_clip_back_white);
        mToolbar.setTitle("");
    }

    @Override
    protected void initStatusBar() {
        StatusBarUtil.setTranslucentForCoordinatorLayout(this, 0);
    }

    private int getSex(String sex) {
        switch (sex) {
            case "男":
                return R.drawable.ic_user_male;
            case "女":
                return R.drawable.ic_user_female;
            default://握草 gay
                return R.drawable.ic_user_gay_border;
        }
    }


    private int getLv(int lv) {
        int lvRes;
        switch (lv) {
            case 1:
                lvRes = R.drawable.ic_lv1_large;
                break;
            case 2:
                lvRes = R.drawable.ic_lv2_large;
                break;
            case 3:
                lvRes = R.drawable.ic_lv3_large;
                break;
            case 4:
                lvRes = R.drawable.ic_lv4_large;
                break;
            case 5:
                lvRes = R.drawable.ic_lv5_large;
                break;
            case 6:
                lvRes = R.drawable.ic_lv6_large;
                break;
            case 7:

                lvRes = R.drawable.ic_lv7_large;
                break;
            case 8:
                lvRes = R.drawable.ic_lv8_large;
                break;
            case 9:
                lvRes = R.drawable.ic_lv9_large;
                break;
            default:
                lvRes = R.drawable.ic_lv0_large;
                break;
        }
        return lvRes;
    }
}
