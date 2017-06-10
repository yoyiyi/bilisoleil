package com.yoyiyi.soleil.module.home;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseFragment;
import com.yoyiyi.soleil.bean.discover.HotSearchTag;
import com.yoyiyi.soleil.constant.Constants;
import com.yoyiyi.soleil.module.app.BrowerActivity;
import com.yoyiyi.soleil.module.discover.ActivityCenterActivity;
import com.yoyiyi.soleil.module.discover.GameCenterActivity;
import com.yoyiyi.soleil.module.discover.TopicCenterActivity;
import com.yoyiyi.soleil.module.recommend.AllStationRankActivity;
import com.yoyiyi.soleil.module.region.AllRegionRankActivity;
import com.yoyiyi.soleil.module.search.TotalSearchActivity;
import com.yoyiyi.soleil.mvp.contract.home.DiscoverContract;
import com.yoyiyi.soleil.mvp.presenter.home.DiscoverPresenter;
import com.yoyiyi.soleil.widget.flowlayout.FlowLayout;
import com.yoyiyi.soleil.widget.flowlayout.TagAdapter;
import com.yoyiyi.soleil.widget.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 14:23
 * 描述:首页发现界面
 */

public class DiscoverFragment extends BaseFragment<DiscoverPresenter> implements DiscoverContract.View {


    @BindView(R.id.iv_search_scan)
    ImageView mIvSearchScan;
    @BindView(R.id.tv_search_edit)
    TextView mTvSearchEdit;
    @BindView(R.id.iv_search_code)
    ImageView mIvSearchCode;
    @BindView(R.id.card_view)
    CardView mCardView;
    @BindView(R.id.tags_layout)
    TagFlowLayout mTagsLayout;
    @BindView(R.id.hide_tags_layout)
    TagFlowLayout mHideTagsLayout;
    @BindView(R.id.hide_scroll_view)
    NestedScrollView mHideScrollView;
    @BindView(R.id.tv_more)
    TextView mTvMore;
    @BindView(R.id.ll_more)
    LinearLayout mLlMore;
    @BindView(R.id.iv_group)
    ImageView mIvGroup;
    @BindView(R.id.rl_group)
    RelativeLayout mRlGroup;
    @BindView(R.id.iv_topic_center)
    ImageView mIvTopicCenter;
    @BindView(R.id.rl_topic_center)
    RelativeLayout mRlTopicCenter;
    @BindView(R.id.iv_activity_center)
    ImageView mIvActivityCenter;
    @BindView(R.id.rl_activity_center)
    RelativeLayout mRlActivityCenter;
    @BindView(R.id.iv_black_list)
    ImageView mIvBlackList;
    @BindView(R.id.rl_black_list)
    RelativeLayout mRlBlackList;
    @BindView(R.id.iv_rank_original)
    ImageView mIvRankOriginal;
    @BindView(R.id.rl_rank_original)
    RelativeLayout mRlRankOriginal;
    @BindView(R.id.iv_rank_all)
    ImageView mIvRankAll;
    @BindView(R.id.rl_rank_all)
    RelativeLayout mRlRankAll;
    @BindView(R.id.iv_game)
    ImageView mIvGame;
    @BindView(R.id.rl_game)
    RelativeLayout mRlGame;
    @BindView(R.id.iv_mall)
    ImageView mIvMall;
    @BindView(R.id.rl_mall)
    RelativeLayout mRlMall;
    boolean isShowMore = false;

    private List<HotSearchTag.ListBean> mList = new ArrayList<>();

    public static DiscoverFragment newInstance() {
        return new DiscoverFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_discover;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void lazyLoadData() {
        mPresenter.getHotSearchTagData();
    }

    @Override
    public void showHotSearchTag(HotSearchTag hotSearchTag) {
        mList.addAll(hotSearchTag.list);
        finishTask();
    }

    @Override
    protected void finishTask() {
        mTagsLayout.setAdapter(new TagAdapter<HotSearchTag.ListBean>(mList.subList(0, 9)) {
            @Override
            public View getView(FlowLayout flowLayout, int i, HotSearchTag.ListBean listBean) {
                TextView mTags = (TextView) LayoutInflater.from(getActivity())
                        .inflate(R.layout.layout_hot_tags_item, flowLayout, false);
                mTags.setText(listBean.keyword);
                mTags.setOnClickListener(view -> TotalSearchActivity.startActivity(mContext, listBean.keyword));
                return mTags;
            }
        });
        mHideTagsLayout.setAdapter(new TagAdapter<HotSearchTag.ListBean>(mList) {
            @Override
            public View getView(FlowLayout parent, int position, HotSearchTag.ListBean listBean) {

                TextView mTags = (TextView) LayoutInflater.from(getActivity())
                        .inflate(R.layout.layout_hot_tags_item, parent, false);
                mTags.setText(listBean.keyword);
                mTags.setOnClickListener(view -> TotalSearchActivity.startActivity(mContext, listBean.keyword));
                return mTags;
            }
        });
    }

    @OnClick(R.id.ll_more)
    void showAndHideMoreLayout() {
        if (isShowMore) {
            isShowMore = false;
            visible(mHideScrollView);
            mTvMore.setText("收起");
            gone(mTagsLayout);
            Drawable upDrawable = getResources().getDrawable(R.drawable.ic_arrow_up_gray_round);
            upDrawable.setBounds(0, 0, upDrawable.getMinimumWidth(), upDrawable.getMinimumHeight());
            mTvMore.setCompoundDrawables(upDrawable, null, null, null);
        } else {
            isShowMore = true;
            gone(mHideScrollView);
            mTvMore.setText("查看更多");
            visible(mTagsLayout);
            Drawable downDrawable = getResources().getDrawable(R.drawable.ic_arrow_down_gray_round);
            downDrawable.setBounds(0, 0, downDrawable.getMinimumWidth(), downDrawable.getMinimumHeight());
            mTvMore.setCompoundDrawables(downDrawable, null, null, null);
        }
    }

    @OnClick({R.id.rl_group, R.id.rl_activity_center, R.id.rl_topic_center,
            R.id.rl_black_list, R.id.rl_rank_original, R.id.rl_rank_all, R.id.rl_game, R.id.rl_mall})
    void startActivity(View view) {
        switch (view.getId()) {
            case R.id.rl_rank_original://原创排行
                startActivity(new Intent(getApplicationContext(), AllStationRankActivity.class));
                break;
            case R.id.rl_rank_all://全站排行
                AllRegionRankActivity.startActivity(getApplicationContext(), "番剧");
                break;
            case R.id.rl_topic_center://话题中心
                startActivity(new Intent(getApplicationContext(), TopicCenterActivity.class));
                break;
            case R.id.rl_activity_center://活动中心
                startActivity(new Intent(getApplicationContext(), ActivityCenterActivity.class));
                break;
            case R.id.rl_game://游戏中心
                startActivity(new Intent(getApplicationContext(), GameCenterActivity.class));
                break;
            case R.id.rl_mall://周边商城
                BrowerActivity.startActivity(getActivity(), Constants.SHOP_URL, "bilibili - 周边商城");
                break;
            case R.id.rl_black_list://小黑屋
                BrowerActivity.startActivity(getActivity(), Constants.BLACK_URL, "小黑屋");
                break;
        }
    }
}
