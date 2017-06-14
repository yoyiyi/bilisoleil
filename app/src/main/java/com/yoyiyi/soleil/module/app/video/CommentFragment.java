package com.yoyiyi.soleil.module.app.video;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.base.BaseFragment;
import com.yoyiyi.soleil.bean.app.VideoDetailComment;
import com.yoyiyi.soleil.mvp.contract.app.live.CommentContract;
import com.yoyiyi.soleil.mvp.presenter.app.live.CommentPresenter;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/14 15:58
 * 描述:评论
 */

public class CommentFragment extends BaseFragment<CommentPresenter> implements CommentContract.View {
    private VideoDetailComment.DataBean mVideoDetailComment;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_comment;
    }

    public static CommentFragment newInstance() {
        return new CommentFragment();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void loadData() {
        mPresenter.getCommentData();
    }

    @Override
    public void showComment(VideoDetailComment.DataBean videoDetailComment) {
        mVideoDetailComment = videoDetailComment;
    }
}
