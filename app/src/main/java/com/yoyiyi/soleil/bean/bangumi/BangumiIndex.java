package com.yoyiyi.soleil.bean.bangumi;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/9 9:30
 * 描述:番剧索引
 */

public class BangumiIndex {

    /**
     * cover : http://i2.hdslb.com/u_user/f7a16e4a28fe524ceddfe0860b52d057.jpg
     * tag_id : 117
     * tag_name : 轻改
     */
    public List<CategoryBean> category;

    public List<String> years;

    public static class CategoryBean {

        public String cover;

        public String tag_id;

        public String tag_name;
    }
}
