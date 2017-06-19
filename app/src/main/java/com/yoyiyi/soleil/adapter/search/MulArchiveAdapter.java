package com.yoyiyi.soleil.adapter.search;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.bean.search.MulSearchArchive;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/19 9:56
 * 描述:
 */

public class MulArchiveAdapter extends BaseMultiItemQuickAdapter<MulSearchArchive, BaseViewHolder> {
  /*  public static final int TYPE_SEASON = 1;
    public static final int TYPE_SEASON_MORE = 2;
    public static final int TYPE_MOVIE = 3;
    public static final int TYPE_MOVIE_MORE = 4;
    public static final int TYPE_ARCHIVE = 5;
*/

    public MulArchiveAdapter(List<MulSearchArchive> data) {
        super(data);
        addItemType(MulSearchArchive.TYPE_SEASON, R.layout.layout_item_search_archive_season);
        addItemType(MulSearchArchive.TYPE_SEASON_MORE, R.layout.layout_item_search_archive_seanson_more);
        addItemType(MulSearchArchive.TYPE_MOVIE, R.layout.layout_item_search_archive_movie);
        addItemType(MulSearchArchive.TYPE_MOVIE_MORE, R.layout.layout_item_search_archive_movie_more);
        addItemType(MulSearchArchive.TYPE_ARCHIVE, R.layout.layout_item_search_archive_video);

    }

    @Override
    protected void convert(BaseViewHolder helper, MulSearchArchive item) {

    }
}
