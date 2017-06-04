package com.yoyiyi.soleil.module.region.live;

import com.yoyiyi.soleil.module.region.BaseRegionActivity;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/30 12:12
 * 描述:直播分区
 */
public class LiveRegionActivity extends BaseRegionActivity/*<LivePresenter, LiveEntrance>*/ /*implements LiveContract.View */{
   /* @Override
    public void showLiveEntrance(List<LiveEntrance> liveEntrances) {

    }
*/
    @Override
    protected int getLayoutId() {
        return 0;
    }

  /*  @Override
    protected int getLayoutId() {
        return R.layout.activity_live_region;
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, LiveRegionActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        setTitle("直播");
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void loadData() {
        mPresenter.getLiveEntranceData();
    }


    @Override
    protected void finishTask() {
        mTitles.clear();
        mTitles.add("推荐");
        Stream.of(mList)
                .map(liveEntrance -> liveEntrance.name)
                .forEach(name -> mTitles.add(name));

        Stream.of(mTitles).forEach(title -> {
            mFragments.add(LiveFragment.newInstance());
        });
        mViewPager.setAdapter(new BaseRegionTypeAdapte(getSupportFragmentManager(), mTitles, mFragments));
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    @Override
    public void showLiveEntrance(List<LiveEntrance> liveEntrances) {
        mList.addAll(liveEntrances);
        finishTask();
    }
*/

}
