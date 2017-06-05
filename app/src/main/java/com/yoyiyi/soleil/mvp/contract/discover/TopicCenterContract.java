package com.yoyiyi.soleil.mvp.contract.discover;

import com.yoyiyi.soleil.base.BaseContract;
import com.yoyiyi.soleil.bean.discover.TopicCenter;

import java.util.List;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/12 10:09
 * 描述:话题中心Contract
 */

public interface TopicCenterContract {

    interface View extends BaseContract.BaseView {

        void showTopicCenter(List<TopicCenter.ListBean> topicCenterList);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getTopicCenterData();
    }
}
