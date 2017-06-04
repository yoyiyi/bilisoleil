package com.yoyiyi.soleil.adapter.region.sectiton;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/15 16:28
 * 描述:分区入口Section
 */

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.region.RegionRecommendEntranceAdapter;
import com.yoyiyi.soleil.bean.region.RegionEnter;
import com.yoyiyi.soleil.widget.section.StatelessSection;
import com.yoyiyi.soleil.widget.section.ViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/26 21:59
 * 描述:
 */
public class RegionRecommendEntranceSection extends StatelessSection {

    private List<RegionEnter> mList = new ArrayList<>();
    private int mTid;

    public RegionRecommendEntranceSection(int tid) {
        super(R.layout.layout_item_region_recommend_entrance, R.layout.layout_empty);
        this.mTid = tid;
        init();
    }

    private void init() {
        switch (mTid) {
            case 13://番剧
                mList = Arrays.asList(new RegionEnter("连载动画", R.mipmap.ic_category_t33),
                        new RegionEnter("完结动画", R.mipmap.ic_category_t32),
                        new RegionEnter("国产动画", R.mipmap.ic_category_t153),
                        new RegionEnter("资讯", R.mipmap.ic_category_t51),
                        new RegionEnter("官方延伸", R.mipmap.ic_category_t152));
                break;
            case 1://动画
                mList = Arrays.asList(new RegionEnter("MAD·AMV", R.mipmap.ic_category_t24),
                        new RegionEnter("MMD·3D", R.mipmap.ic_category_t25),
                        new RegionEnter("短片·手书·配音", R.mipmap.ic_category_t47),
                        new RegionEnter("综合", R.mipmap.ic_category_t27));
                break;
            case 3://音乐
                mList = Arrays.asList(new RegionEnter("翻唱", R.mipmap.ic_category_t31),
                        new RegionEnter("VOCALOID·UTAU", R.mipmap.ic_category_t30),
                        new RegionEnter("演奏", R.mipmap.ic_category_t59),
                        new RegionEnter("OP/ED/OST", R.mipmap.ic_category_t54),
                        new RegionEnter("原创音乐", R.mipmap.ic_category_t28),
                        new RegionEnter("三次元音乐", R.mipmap.ic_category_t29),
                        new RegionEnter("音乐选集", R.mipmap.ic_category_t130));
                break;
            case 129://舞蹈
                mList = Arrays.asList(new RegionEnter("宅舞", R.mipmap.ic_category_t20),
                        new RegionEnter("三次元舞蹈", R.mipmap.ic_category_t154),
                        new RegionEnter("舞蹈教程", R.mipmap.ic_category_t156));
                break;
            case 4://游戏
                mList = Arrays.asList(new RegionEnter("单机联机", R.mipmap.ic_category_t17),
                        new RegionEnter("网游·电竞", R.mipmap.ic_category_t65),
                        new RegionEnter("音游", R.mipmap.ic_category_t136),
                        new RegionEnter("MUGEN", R.mipmap.ic_category_t19),
                        new RegionEnter("GMV", R.mipmap.ic_category_t121),
                        new RegionEnter("游戏中心", R.mipmap.ic_category_game_center2));
                break;
            case 36://科技
                mList = Arrays.asList(new RegionEnter("纪录片", R.mipmap.ic_category_t37),
                        new RegionEnter("趣味科普人文", R.mipmap.ic_category_t124),
                        new RegionEnter("野生技术协会", R.mipmap.ic_category_t122),
                        new RegionEnter("演讲·公开课", R.mipmap.ic_category_t39),
                        new RegionEnter("星海", R.mipmap.ic_category_t96),
                        new RegionEnter("数码", R.mipmap.ic_category_t95),
                        new RegionEnter("机械", R.mipmap.ic_category_t98));
                break;
            case 160://生活
                mList = Arrays.asList(new RegionEnter("搞笑", R.mipmap.ic_category_t138),
                        new RegionEnter("日常", R.mipmap.ic_category_t21),
                        new RegionEnter("美食圈", R.mipmap.ic_category_t76),
                        new RegionEnter("动物圈", R.mipmap.ic_category_t75),
                        new RegionEnter("手工", R.mipmap.ic_category_t161),
                        new RegionEnter("绘画", R.mipmap.ic_category_t162),
                        new RegionEnter("运动", R.mipmap.ic_category_t163));
                break;
            case 119://鬼畜
                mList = Arrays.asList(new RegionEnter("鬼畜调教", R.mipmap.ic_category_t22),
                        new RegionEnter("音MAD", R.mipmap.ic_category_t26),
                        new RegionEnter("人力VOCALOID", R.mipmap.ic_category_t126),
                        new RegionEnter("教程演示", R.mipmap.ic_category_t127));
                break;
            case 155://时尚
                mList = Arrays.asList(new RegionEnter("美妆", R.mipmap.ic_category_t157),
                        new RegionEnter("服饰", R.mipmap.ic_category_t158),
                        new RegionEnter("资讯", R.mipmap.ic_category_t159),
                        new RegionEnter("健身", R.mipmap.ic_category_t164));
                break;
            case 5://娱乐
                mList = Arrays.asList(new RegionEnter("综艺", R.mipmap.ic_category_t71),
                        new RegionEnter("明星", R.mipmap.ic_category_t137),
                        new RegionEnter("KOREA相关", R.mipmap.ic_category_t131));
                break;
            case 23://电影
                mList = Arrays.asList(new RegionEnter("电影相关", R.mipmap.ic_category_t82),
                        new RegionEnter("短片", R.mipmap.ic_category_t85),
                        new RegionEnter("欧美电影", R.mipmap.ic_category_t145),
                        new RegionEnter("日本电影", R.mipmap.ic_category_t146),
                        new RegionEnter("国产电影", R.mipmap.ic_category_t147),
                        new RegionEnter("其他国家", R.mipmap.ic_category_t83));
                break;
            case 11://电视剧
                mList = Arrays.asList(new RegionEnter("连载剧集", R.mipmap.ic_category_t15),
                        new RegionEnter("完结剧集", R.mipmap.ic_category_t34),
                        new RegionEnter("特辑·布袋戏", R.mipmap.ic_category_t86),
                        new RegionEnter("电视剧相关", R.mipmap.ic_category_t128));
                break;
        }

    }

    @Override
    public void onBindHeaderViewHolder(ViewHolder holder) {
        RecyclerView recyclerView = holder.getView(R.id.recycler);
        recyclerView.setHasFixedSize(false);
        recyclerView.setNestedScrollingEnabled(false);
        GridLayoutManager layoutManager = new GridLayoutManager(mContext, mList.size() >= 4 ? 4 : mList.size());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RegionRecommendEntranceAdapter(mList));
    }
}

