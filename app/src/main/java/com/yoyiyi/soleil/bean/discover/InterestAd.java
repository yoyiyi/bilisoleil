package com.yoyiyi.soleil.bean.discover;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/10 21:54
 * 描述:
 */
public class InterestAd {


    /**
     * total_count : 6
     * result : [{"ads_title":"月刊","ads_image":"http://img.yo9.com/21017e60086311e79c2500163e000128","ads_image_link":"bilibili://group/1154?post_id=10839"},{"ads_title":"沙发","ads_image":"http://img.yo9.com/2e8dfc00e93e11e685e400163e000128","ads_image_link":"bilibili://group/133?post_id=12486"},{"ads_title":"净网","ads_image":"http://img.yo9.com/96570850d7fe11e68ae800163e000128","ads_image_link":"bilibili://group/1?post_id=25273"},{"ads_title":"月刊","ads_image":"http://img.yo9.com/0273b290231d11e78a4900163e000128","ads_image_link":"bilibili://group/1154?post_id=11216"},{"ads_title":"京蜜13","ads_image":"http://img.yo9.com/de537ec099d011e6bd4a00163e000128","ads_image_link":"bilibili://group/154?post_id=22242"},{"ads_title":"物语第二期","ads_image":"http://img.yo9.com/1ae78e407d7411e6b42f00163e000128","ads_image_link":"bilibili://group/133?post_id=9907"}]
     */

    public int total_count;
    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * ads_title : 月刊
         * ads_image : http://img.yo9.com/21017e60086311e79c2500163e000128
         * ads_image_link : bilibili://group/1154?post_id=10839
         */

        public String ads_title;
        public String ads_image;
        public String ads_image_link;
    }
}
