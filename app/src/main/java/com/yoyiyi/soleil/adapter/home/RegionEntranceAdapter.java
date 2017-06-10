package com.yoyiyi.soleil.adapter.home;

import android.content.Intent;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.region.RegionEnter;
import com.yoyiyi.soleil.bean.region.RegionTagType;
import com.yoyiyi.soleil.module.discover.GameCenterActivity;
import com.yoyiyi.soleil.module.region.AdActivity;
import com.yoyiyi.soleil.module.region.RegionTypeActivity;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/23 23:30
 * 描述:
 */
public class RegionEntranceAdapter extends BaseQuickAdapter<RegionEnter, BaseViewHolder> {
    private List<RegionTagType> mRegionTypeList;


    public RegionEntranceAdapter(@Nullable List<RegionEnter> data, List<RegionTagType> regionTypeList) {
        super(R.layout.item_home_region_entrance, data);
        this.mRegionTypeList = regionTypeList;
    }


    @Override
    protected void convert(BaseViewHolder helper, RegionEnter item) {
        helper.setText(R.id.tv_title, item.title)
                .setImageResource(R.id.iv_icon, item.img);
        helper.itemView.setOnClickListener(view -> {
            switch (helper.getAdapterPosition()) {
               /* "直播",
                        "番剧",
                        "动画",
                        "国创",
                        "音乐",
                        "舞蹈",
                        "游戏",
                        "科技",
                        "生活",
                        "鬼畜",
                        "时尚",
                        "广告",
                        "娱乐",
                        "电影",
                        "电视剧",
                        "游戏中心"*/
                case 0://直播
                    //LiveRegionActivity.startActivity(mContext);
                    //RegionTypeActivity.startActivity(mContext, mRegionTypeList.get(0));

                    break;
                case 1:
                    RegionTypeActivity.startActivity(mContext, mRegionTypeList.get(1));
                    break;
                case 2:
                    RegionTypeActivity.startActivity(mContext, mRegionTypeList.get(2));
                    break;
                case 3://国创
                    // RegionTypeActivity.startActivity(mContext, mRegionTypeList.get(1), "国创");
                    break;
                case 4:
                    RegionTypeActivity.startActivity(mContext, mRegionTypeList.get(3));

                    break;
                case 5:
                    RegionTypeActivity.startActivity(mContext, mRegionTypeList.get(4));

                    break;
                case 6:
                    RegionTypeActivity.startActivity(mContext, mRegionTypeList.get(5));

                    break;
                case 7:
                    RegionTypeActivity.startActivity(mContext, mRegionTypeList.get(6));

                    break;
                case 8:
                    RegionTypeActivity.startActivity(mContext, mRegionTypeList.get(7));

                    break;
                case 9:
                    RegionTypeActivity.startActivity(mContext, mRegionTypeList.get(8));

                    break;
                case 10:
                    RegionTypeActivity.startActivity(mContext, mRegionTypeList.get(9));

                    break;
                case 11://广告
                    mContext.startActivity(new Intent(mContext, AdActivity.class));

                    break;
                case 12:
                    RegionTypeActivity.startActivity(mContext, mRegionTypeList.get(10));

                    break;
                case 13:
                    RegionTypeActivity.startActivity(mContext, mRegionTypeList.get(11));

                    break;
                case 14:
                    RegionTypeActivity.startActivity(mContext, mRegionTypeList.get(12));

                    break;
                case 15:
                    //游戏中心
                    mContext.startActivity(new Intent(mContext, GameCenterActivity.class));
                    break;

            }


        });
    }

}