package com.yoyiyi.soleil.adapter.bangumi;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.bangumi.BangumiSchedule;
import com.yoyiyi.soleil.module.bangumi.BangumiDetailActivity;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.widget.section.StatelessSection;
import com.yoyiyi.soleil.widget.section.ViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/8 17:45
 * 描述:
 */

public class BangumiScheduleSection extends StatelessSection<BangumiSchedule> {
    private String mWeek;
    private String mDate;

    public BangumiScheduleSection(String week, List<BangumiSchedule> list, String date) {
        super(R.layout.layout_item_bangumi_schedule_head, R.layout.layout_item_bangumi_schedule_body, list);
        mWeek = week;
        mDate = date;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        switch (mWeek) {
            case "周一":
                setWeekData(holder, R.drawable.bangumi_timeline_weekday_1);
                break;
            case "周二":
                setWeekData(holder, R.drawable.bangumi_timeline_weekday_2);
                break;
            case "周三":
                setWeekData(holder, R.drawable.bangumi_timeline_weekday_3);
                break;
            case "周四":
                setWeekData(holder, R.drawable.bangumi_timeline_weekday_4);
                break;
            case "周五":
                setWeekData(holder, R.drawable.bangumi_timeline_weekday_5);
                break;
            case "周六":
                setWeekData(holder, R.drawable.bangumi_timeline_weekday_6);
                break;
            case "周日":
                setWeekData(holder, R.drawable.bangumi_timeline_weekday_7);
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setWeekData(ViewHolder holder, int iconRes) {
        Date nowDate = com.yoyiyi.soleil.utils.time.TimeUtils.getNowDate();
        String date2String = com.yoyiyi.soleil.utils.time.TimeUtils.date2String(nowDate, new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()));
        if (TextUtils.equals(mDate, date2String /*TimeUtils.formatDate(TimeUtils.getCurrentTime("yyyy-MM-dd")))*/)) {
            holder.setText(R.id.tv_date, "今天")
                    .setTextColor(R.id.tv_date, AppUtils.getColor(R.color.colorPrimary))
                    .setTextColor(R.id.tv_title, AppUtils.getColor(R.color.colorPrimary));
            ImageView icon = holder.getView(R.id.iv_icon);
            icon.setImageTintList(ColorStateList.valueOf(AppUtils.getColor(R.color.colorPrimary)));
        } else {
            holder.setText(R.id.tv_date, mDate)
                    .setTextColor(R.id.tv_date, AppUtils.getColor(R.color.black_alpha_30))
                    .setTextColor(R.id.tv_title, AppUtils.getColor(R.color.gray_80));
            ImageView icon = holder.getView(R.id.iv_icon);
            icon.setImageTintList(ColorStateList.valueOf(AppUtils.getColor(R.color.gray_80)));
        }
        holder.setImageResource(R.id.iv_icon, iconRes)
                .setText(R.id.tv_title, mWeek);
    }

    @Override
    public void convert(ViewHolder holder, BangumiSchedule schedule, int position) {
        Glide.with(mContext)
                .load(schedule.cover)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bili_default_image_tv)
                .dontAnimate()
                .into((ImageView) holder.getView(R.id.iv_video_preview));
        holder.setText(R.id.tv_video_title, schedule.title)
                .setText(R.id.tv_video_time, schedule.ontime)
                .setText(R.id.tv_video_update, "第 " + schedule.ep_index + " 话");
        holder.itemView.setOnClickListener(view -> mContext.startActivity(new Intent(mContext, BangumiDetailActivity.class)));

    }
}
