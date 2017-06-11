package com.yoyiyi.soleil.bean.discover;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/10 21:43
 * 描述:兴趣圈分类
 */
public class InterestCategrory {


        public List<ResultBean> result;

        public static class ResultBean {
                /**
                 * id : 71
                 * name : 萌战赢家
                 * avatar : http://img.yo9.com/f4bef5d099b311e6bd4a00163e000128
                 */

                public int id;
                public String name;
                public String avatar;
        }
}
