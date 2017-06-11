package com.yoyiyi.soleil.bean.discover;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/10 21:36
 * 描述:兴趣圈
 */
public class Community {
    /*  total_count":1996,"total_page":67,"result":[*/
    public List<ResultBean> result;
    public int total_count;
    public int total_page;


    /**
     * community_info : {"certification":0,"community_avatar":"http://img.yo9.com/ffb5c320978711e6bd4a00163e000128","community_id":12,"community_name":"Bilibili萌战日本动画场","community_url":"http://www.im9.com/community.html?community_id=12","member_num":22608,"post_count":4900}
     * post_info : {"author_avatar":"http://i1.hdslb.com/bfs/face/d5feee58476452c0c43ef71fab38c50e4119294f.jpg","author_mid":3061924,"author_name":"路过的小轩","chosen_time":1481107581000,"image_count":2,"last_reply_author":"51xx点info","last_reply_mid":82581258,"last_reply_time":1496979724000,"level":4,"modify_time":1481049163000,"post_id":11636,"post_image_list":[{"height":155,"id":43197,"image_id":"49e55c70bbe211e6b4bb00163e00043c","image_url":"http://img.yo9.com/49e55c70bbe211e6b4bb00163e00043c","img_suffix":"jpg","praise_count":0,"width":220},{"height":359,"id":43198,"image_id":"3e471e30bbe211e6b4bb00163e00043c","image_url":"http://img.yo9.com/3e471e30bbe211e6b4bb00163e00043c","img_suffix":"jpg","praise_count":0,"width":640}],"post_summary":"灰与幻想的格林姆迦尔我觉得是一部良番了（虽然推图进度慢的可以）画风清新音乐好听，和素晴（没有日）是同一时间的番，据说销量也是黑马，在此强推没有看过的可以去看看。...","post_time":1481049163000,"post_title":"为哈尔希洛而拉票（没想到我居然会为男的拉选票）长文本注意！","praise_count":17,"reply_count":80,"sex":0,"tags":[]}
     */
    public static class ResultBean {

        public CommunityInfoBean community_info;
        public PostInfoBean post_info;

        public static class CommunityInfoBean {
            /**
             * certification : 0
             * community_avatar : http://img.yo9.com/ffb5c320978711e6bd4a00163e000128
             * community_id : 12
             * community_name : Bilibili萌战日本动画场
             * community_url : http://www.im9.com/community.html?community_id=12
             * member_num : 22608
             * post_count : 4900
             */

            public int certification;
            public String community_avatar;
            public int community_id;
            public String community_name;
            public String community_url;
            public int member_num;
            public int post_count;
        }

        public static class PostInfoBean {
            /**
             * author_avatar : http://i1.hdslb.com/bfs/face/d5feee58476452c0c43ef71fab38c50e4119294f.jpg
             * author_mid : 3061924
             * author_name : 路过的小轩
             * chosen_time : 1481107581000
             * image_count : 2
             * last_reply_author : 51xx点info
             * last_reply_mid : 82581258
             * last_reply_time : 1496979724000
             * level : 4
             * modify_time : 1481049163000
             * post_id : 11636
             * post_image_list : [{"height":155,"id":43197,"image_id":"49e55c70bbe211e6b4bb00163e00043c","image_url":"http://img.yo9.com/49e55c70bbe211e6b4bb00163e00043c","img_suffix":"jpg","praise_count":0,"width":220},{"height":359,"id":43198,"image_id":"3e471e30bbe211e6b4bb00163e00043c","image_url":"http://img.yo9.com/3e471e30bbe211e6b4bb00163e00043c","img_suffix":"jpg","praise_count":0,"width":640}]
             * post_summary : 灰与幻想的格林姆迦尔我觉得是一部良番了（虽然推图进度慢的可以）画风清新音乐好听，和素晴（没有日）是同一时间的番，据说销量也是黑马，在此强推没有看过的可以去看看。...
             * post_time : 1481049163000
             * post_title : 为哈尔希洛而拉票（没想到我居然会为男的拉选票）长文本注意！
             * praise_count : 17
             * reply_count : 80
             * sex : 0
             * tags : []
             */

            public String author_avatar;
            public int author_mid;
            public String author_name;
            public long chosen_time;
            public int image_count;
            public String last_reply_author;
            public int last_reply_mid;
            public long last_reply_time;
            public int level;
            public long modify_time;
            public int post_id;
            public String post_summary;
            public long post_time;
            public String post_title;
            public int praise_count;
            public int reply_count;
            public int sex;
            public List<PostImageListBean> post_image_list;
            public List<?> tags;

            public static class PostImageListBean {
                /**
                 * height : 155
                 * id : 43197
                 * image_id : 49e55c70bbe211e6b4bb00163e00043c
                 * image_url : http://img.yo9.com/49e55c70bbe211e6b4bb00163e00043c
                 * img_suffix : jpg
                 * praise_count : 0
                 * width : 220
                 */

                public int height;
                public int id;
                public String image_id;
                public String image_url;
                public String img_suffix;
                public int praise_count;
                public int width;
            }
        }
    }


}
