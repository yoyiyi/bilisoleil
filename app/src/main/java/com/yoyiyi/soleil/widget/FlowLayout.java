package com.yoyiyi.soleil.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by yoyiyi on 2016/9/19.
 */
public class FlowLayout extends ViewGroup {
    private boolean mNeedLayout = true;//判断是否需要重新布局
    private int mUseWidth; //当前行已使用宽度
    private int mHorizontalSpec = 6;
    private int mVerticalSpec = 8;
    private NewLine mLine;
    private ArrayList<NewLine> mLineList = new ArrayList<>();
    private static final int MAX_LINE = 100;//最大行数100行

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (!mNeedLayout || changed) {// 没有发生改变就不重新布局
            mNeedLayout = false;
            int left = l + getPaddingLeft();
            int top = t + getPaddingTop();
            //设置子控件位置
            for (int i = 0; i < mLineList.size(); i++) {
                NewLine newLine = mLineList.get(i);
                newLine.layout(left, top);
                top += mVerticalSpec + newLine.mMaxHeight;//更新top值
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec)
                - getPaddingLeft() - getPaddingRight();//得到有效宽度
        int height = MeasureSpec.getSize(heightMeasureSpec)
                - getPaddingTop() - getPaddingBottom();//得到有效高度

        int widthMode = MeasureSpec.getSize(widthMeasureSpec);//得到宽度模式
        int heightMode = MeasureSpec.getSize(heightMeasureSpec);//得到高度模式

        restoreLine();// 还原数据，以便重新记录

        int childCount = getChildCount();//得到子控件数量
        for (int i = 0; i < childCount; i++) {//循环子控件
            //子控件测量
            View childAt = getChildAt(i);//得到子控件
            if (childAt.getVisibility() == GONE) {
                continue;
            }
            //如果父控件为确定模式 子控件为包裹内容；否则子控件和父控件一致
            int chilWidthSpec = MeasureSpec.makeMeasureSpec(width,
                    (widthMode == MeasureSpec.EXACTLY)
                            ? MeasureSpec.AT_MOST
                            : widthMode);
            int childHeightSpec = MeasureSpec.makeMeasureSpec(height,
                    (heightMode == MeasureSpec.EXACTLY)
                            ? MeasureSpec.AT_MOST
                            : heightMode);
            //开始测量
            childAt.measure(chilWidthSpec, childHeightSpec);
            //如果当前行为空，new对象
            if (mLine == null) {
                mLine = new NewLine();
            }
            //获取子控件宽度
            int childWidth = childAt.getMeasuredWidth();
            mUseWidth += childWidth;//已使用当前行宽度
            if (mUseWidth <= width) {//判断是否超出边界
                mLine.addView(childAt);//添加子控件
                //没有超出边界
                mUseWidth += mHorizontalSpec;//增加水平间距
                if (mUseWidth > width) {
                    //超出边界 需要换行
                    if (!newLine()) {
                        break;//结束循环 创建行失败 不再添加
                    }

                }

            } else {
                //超出边界
                //1.子控件非常长 而且行中没有其他控件
                if (mLine.getChildCount() == 0) {
                    mLine.addView(childAt);
                    if (!newLine()) {
                        break;
                    }

                } else {
                    //2.最后一个子控件添加进去之后 明显超出原来行长度
                    if (!newLine()) {
                        break;
                    }
                    mLine.addView(childAt);
                    mUseWidth += childWidth + mHorizontalSpec;
                }
            }

            // int childHeight = childAt.getMeasuredHeight();

        }

        //保存最后一行
        if (mLine != null
                && mLine.getChildCount() != 0
                && !mLineList.contains(mLine)) {
            mLineList.add(mLine);

        }
        int totalWidth = MeasureSpec.getSize(widthMeasureSpec);//控件整体宽度
        int totalHeight = 0;//控件整体高度
        for (int i = 0; i < mLineList.size(); i++) {
            totalHeight += mLineList.get(i).mMaxHeight;
        }
        totalHeight += (mLineList.size() - 1) * mVerticalSpec;
        totalHeight += getPaddingTop() + getPaddingBottom();

        //根据最新宽高设置
        setMeasuredDimension(totalWidth, totalHeight);
    }


    //换行
    private boolean newLine() {
        mLineList.add(mLine);//保存上一行
        if (mLineList.size() < MAX_LINE) {
            //继续添加
            mLine = new NewLine();
            mUseWidth = 0;//清零
            return true;
        }
        return false;
    }

    //没一行对象封装
    class NewLine {
        public int mTotalWidth;//总宽度
        public int mMaxHeight; //当前行最高的高度
        private ArrayList<View> mChildViewList = new ArrayList<>();

        //增加一个子控件
        public void addView(View view) {
            mChildViewList.add(view);
            //总宽度增加
            mTotalWidth += view.getMeasuredWidth();
            int height = view.getMeasuredHeight();
            //0 10 20
            mMaxHeight = mMaxHeight < height ? height : mMaxHeight;
        }

        //子控件位置设置
        public void layout(int left, int top) {
            int childCount = getChildCount();
            //将剩余控件平均分配子控件
            int validWidth = getMeasuredWidth()
                    - getPaddingLeft() - getPaddingRight();
            //剩余宽度
            int surplusWidth = validWidth - mTotalWidth - (childCount - 1)
                    * mHorizontalSpec;
            if (surplusWidth >= 0) {
                //有剩余空间
                int space = (int) ((float) surplusWidth / childCount + 0.5f);
                //重新测量子控件
                for (int i = 0; i < childCount; i++) {
                    View childView = mChildViewList.get(i);
                    int measuredWidth = childView.getMeasuredWidth();
                    int measuredHeight = childView.getMeasuredHeight();
                    measuredWidth += space;
                    int measuredWidthSpec = MeasureSpec.makeMeasureSpec(
                            measuredWidth, MeasureSpec.EXACTLY);
                    int measuredHeightSpec = MeasureSpec.makeMeasureSpec(
                            measuredHeight, MeasureSpec.EXACTLY);
                    //重新测量控件
                    childView.measure(measuredWidthSpec, measuredHeightSpec);
                    int topOffset = (mMaxHeight - measuredHeight) / 2;
                    if (topOffset < 0) {
                        topOffset = 0;
                    }
                    //设置位置
                    childView.layout(
                            left,
                            top + topOffset,
                            left + measuredWidth,
                            top + topOffset + measuredHeight);
                    //设置left
                    left += measuredWidth + mHorizontalSpec;
                }
            } else {
                View childView = mChildViewList.get(0);
                childView.layout(
                        left,
                        top,
                        left + childView.getMeasuredWidth(),
                        top + childView.getMeasuredHeight());
            }
        }

        //当前子控件个数
        public int getChildCount() {
            return mChildViewList.size();
        }
    }

    public void setSpac(int horizontalSpec, int verticalSpec) {
        this.mHorizontalSpec = horizontalSpec;
        this.mVerticalSpec = verticalSpec;

    }

    private void restoreLine() {
        mLineList.clear();
        mLine = new NewLine();
        mUseWidth = 0;
    }
}
