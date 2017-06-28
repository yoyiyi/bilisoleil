package com.yoyiyi.soleil.module.app.video;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yoyiyi.soleil.R;
import com.yoyiyi.soleil.adapter.app.video.CommentAdapter;
import com.yoyiyi.soleil.base.BaseFragment;
import com.yoyiyi.soleil.bean.app.video.MulComment;
import com.yoyiyi.soleil.mvp.contract.app.video.CommentContract;
import com.yoyiyi.soleil.mvp.presenter.app.video.CommentPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/6/14 15:58
 * 描述:评论
 */

public class CommentFragment extends BaseFragment<CommentPresenter> implements CommentContract.View {
    @BindView(R.id.recycler)
    RecyclerView mRecycler;

    private CommentAdapter mAdapter;
    private List<MulComment> mList = new ArrayList<>();

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
    public void initWidget() {
        initRecyclerView();
    }

    @Override
    protected void initRecyclerView() {
        mAdapter = new CommentAdapter(mList);
        mRecycler.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void showComment(List<MulComment> mulComments) {
        mList.addAll(mulComments);
        finishTask();
    }

    @Override
    protected void finishTask() {
        mAdapter.notifyDataSetChanged();
    }
}
