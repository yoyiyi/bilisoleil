package com.yoyiyi.soleil.bean.search;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/18 15:06
 * 描述:
 */

public class MulSearchArchive implements MultiItemEntity {
    public static final int TYPE_SEASON = 1;
    public static final int TYPE_SEASON_MORE = 2;
    public static final int TYPE_MOVIE = 3;
    public static final int TYPE_MOVIE_MORE = 4;
    public static final int TYPE_ARCHIVE = 5;

    public int itemType;
    public int seasonCount;
    public int movieCount;

    public Search.DataBean.ItemsBean.ArchiveBean archive;
    public Search.DataBean.ItemsBean.MovieBean movie;
    public Search.DataBean.ItemsBean.SeasonBean season;

    public MulSearchArchive setItemType(int itemType) {
        this.itemType = itemType;
        return this;
    }

    public MulSearchArchive setSeasonCount(int seasonCount) {
        this.seasonCount = seasonCount;
        return this;
    }

    public MulSearchArchive setMovieCount(int movieCount) {
        this.movieCount = movieCount;
        return this;
    }

    public MulSearchArchive setArchive(Search.DataBean.ItemsBean.ArchiveBean archive) {
        this.archive = archive;
        return this;
    }

    public MulSearchArchive setMovie(Search.DataBean.ItemsBean.MovieBean movie) {
        this.movie = movie;
        return this;
    }

    public MulSearchArchive setSeason(Search.DataBean.ItemsBean.SeasonBean season) {
        this.season = season;
        return this;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
