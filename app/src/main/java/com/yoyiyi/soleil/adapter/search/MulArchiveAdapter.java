package com.yoyiyi.soleil.adapter.search;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.search.MulSearchArchive;
import com.yoyiyi.soleil.utils.AppUtils;
import com.yoyiyi.soleil.utils.NumberUtils;
import com.yoyiyi.soleil.utils.SpanUtils;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/19 9:56
 * 描述:
 */

public class MulArchiveAdapter extends BaseMultiItemQuickAdapter<MulSearchArchive, BaseViewHolder> {

    public MulArchiveAdapter(List<MulSearchArchive> data) {
        super(data);
        addItemType(MulSearchArchive.TYPE_SEASON, R.layout.layout_item_search_archive_season);
        addItemType(MulSearchArchive.TYPE_SEASON_MORE, R.layout.layout_item_search_archive_seanson_more);
        addItemType(MulSearchArchive.TYPE_MOVIE, R.layout.layout_item_search_archive_movie);
        addItemType(MulSearchArchive.TYPE_MOVIE_MORE, R.layout.layout_item_search_archive_movie_more);
        addItemType(MulSearchArchive.TYPE_ARCHIVE, R.layout.layout_item_search_archive_video);

    }

    @Override
    protected void convert(BaseViewHolder holder, MulSearchArchive mulSearchArchive) {
        switch (mulSearchArchive.getItemType()) {
            case MulSearchArchive.TYPE_SEASON:
                holder.setText(R.id.tv_video_title, mulSearchArchive.season.title);
                String des;
                if (mulSearchArchive.season.finish == 1) {
                    des = mulSearchArchive.season.newest_season + " · " + mulSearchArchive.season.total_count + "话全";
                } else {
                    des = mulSearchArchive.season.newest_season + " · " + "更新至第" + mulSearchArchive.season.index + "话";
                }
                holder.setText(R.id.tv_video_des, des)
                        .setText(R.id.tv_video_newest_season, mulSearchArchive.season.cat_desc);
                Glide.with(mContext)
                        .load(mulSearchArchive.season.cover)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.bili_default_image_tv)
                        .dontAnimate()
                        .into((ImageView) holder.getView(R.id.iv_video_preview));
                break;
            case MulSearchArchive.TYPE_SEASON_MORE:
                int seasonCount = mulSearchArchive.seasonCount;
                if (seasonCount == 0) {
                    holder.itemView.setVisibility(View.GONE);
                } else {
                    holder.itemView.setVisibility(View.VISIBLE);
                    holder.setText(R.id.tv_more, "更多番剧(" + seasonCount + ") >>");
                }
                break;
            case MulSearchArchive.TYPE_MOVIE:

                String[] split = mulSearchArchive.movie.screen_date.split(" ");
                SpanUtils spanUtils = new SpanUtils().append(mulSearchArchive.movie.title)
                        .appendSpace(10)
                        .append(split[0].substring(0, 4))
                        .setFontSize((int) mContext.getResources().getDimension(R.dimen.text_size_12))
                        .setForegroundColor(AppUtils.getColor(R.color.font_gray));
                holder.setText(R.id.tv_video_title, spanUtils.create())
                        .setText(R.id.tv_video_area, "地区:" + mulSearchArchive.movie.area)
                        .setText(R.id.tv_video_staff, mulSearchArchive.movie.staff)
                        .setText(R.id.tv_video_actors, mulSearchArchive.movie.actors);
                Glide.with(mContext)
                        .load(mulSearchArchive.movie.cover)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.bili_default_image_tv)
                        .dontAnimate()
                        .into((ImageView) holder.getView(R.id.iv_video_preview));
                break;
            case MulSearchArchive.TYPE_MOVIE_MORE:
                int movieCount = mulSearchArchive.movieCount;
                if (movieCount == 0) {
                    holder.itemView.setVisibility(View.GONE);
                } else {
                    holder.itemView.setVisibility(View.VISIBLE);
                    holder.setText(R.id.tv_more, "更多影视(" + movieCount + ") >>");
                }
                break;
            case MulSearchArchive.TYPE_ARCHIVE:
                Glide.with(mContext)
                        .load(mulSearchArchive.archive.cover)
                        .centerCrop()
                        .placeholder(R.drawable.bili_default_image_tv)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate()
                        .into((ImageView) holder.getView(R.id.iv_video_preview));
                holder.setText(R.id.tv_video_title, mulSearchArchive.archive.title)
                        .setText(R.id.tv_video_up, mulSearchArchive.archive.author)
                        .setText(R.id.tv_duration, mulSearchArchive.archive.duration)
                        .setText(R.id.tv_video_play, NumberUtils.format(mulSearchArchive.archive.play + ""))
                        .setText(R.id.tv_video_danmaku, NumberUtils.format(mulSearchArchive.archive.danmaku + ""));
                break;

        }

    }
}
