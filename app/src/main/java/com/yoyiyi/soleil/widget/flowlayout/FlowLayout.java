package com.yoyiyi.soleil.widget.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.yoyiyi.soleil.R;

import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {
    private static final String TAG = "FlowLayout";
    private static final int LEFT = -1;
    private static final int CENTER = 0;
    private static final int RIGHT = 1;

    protected List<List<View>> mAllViews = new ArrayList<List<View>>();
    protected List<Integer> mLineHeight = new ArrayList<Integer>();
    protected List<Integer> mLineWidth = new ArrayList<Integer>();
    private int mGravity;
    private List<View> lineViews = new ArrayList<>();

    public FlowLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TagFlowLayout);
        mGravity = ta.getInt(R.styleable.TagFlowLayout_gravity, LEFT);
        ta.recycle();
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowLayout(Context context) {
        this(context, null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        // wrap_content
        int width = 0;
        int height = 0;

        int lineWidth = 0;
        int lineHeight = 0;

        int cCount = getChildCount();

        for (int i = 0; i < cCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == View.GONE) {
                if (i == cCount - 1) {
                    width = Math.max(lineWidth, width);
                    height += lineHeight;
                }
                continue;
            }
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams lp = (MarginLayoutParams) child
                    .getLayoutParams();

            int childWidth = child.getMeasuredWidth() + lp.leftMargin
                    + lp.rightMargin;
            int childHeight = child.getMeasuredHeight() + lp.topMargin
                    + lp.bottomMargin;

            if (lineWidth + childWidth > sizeWidth - getPaddingLeft() - getPaddingRight()) {
                width = Math.max(width, lineWidth);
                lineWidth = childWidth;
                height += lineHeight;
                lineHeight = childHeight;
            } else {
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight, childHeight);
            }
            if (i == cCount - 1) {
                width = Math.max(lineWidth, width);
                height += lineHeight;
            }
        }
        setMeasuredDimension(
                //
                modeWidth == MeasureSpec.EXACTLY ? sizeWidth : width + getPaddingLeft() + getPaddingRight(),
                modeHeight == MeasureSpec.EXACTLY ? sizeHeight : height + getPaddingTop() + getPaddingBottom()//
        );

    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mAllViews.clear();
        mLineHeight.clear();
        mLineWidth.clear();
        lineViews.clear();

        int width = getWidth();

        int lineWidth = 0;
        int lineHeight = 0;


        //总子控件
        int cCount = getChildCount();

        for (int i = 0; i < cCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == View.GONE) continue;
            MarginLayoutParams lp = (MarginLayoutParams) child
                    .getLayoutParams();

            int childWidth = child.getMeasuredWidth();//宽
            int childHeight = child.getMeasuredHeight();//高

            if (childWidth + lineWidth + lp.leftMargin + lp.rightMargin > width - getPaddingLeft() - getPaddingRight()) {
                mLineHeight.add(lineHeight);
                mAllViews.add(lineViews);
                //行宽
                mLineWidth.add(lineWidth);

                lineWidth = 0;
                lineHeight = childHeight + lp.topMargin + lp.bottomMargin;
                lineViews = new ArrayList<View>();
            }
            lineWidth += childWidth + lp.leftMargin + lp.rightMargin;
            lineHeight = Math.max(lineHeight, childHeight + lp.topMargin
                    + lp.bottomMargin);
            lineViews.add(child);

        }
        mLineHeight.add(lineHeight);
        mLineWidth.add(lineWidth);
        mAllViews.add(lineViews);

        int left = getPaddingLeft();
        int top = getPaddingTop();
        int lineNum = mAllViews.size();
        for (int i = 0; i < lineNum; i++) { //多少行
            lineViews = mAllViews.get(i);
            lineHeight = mLineHeight.get(i);
            // set gravity
            int currentLineWidth = this.mLineWidth.get(i);
            switch (this.mGravity) {
                case LEFT:
                    left = getPaddingLeft();
                    break;
                case CENTER:
                    left = (width - currentLineWidth) / 2 + getPaddingLeft();
                    break;
                case RIGHT:
                    left = width - currentLineWidth + getPaddingLeft();
                    break;
            }
            for (int j = 0; j < lineViews.size(); j++) {
                View child = lineViews.get(j);
                if (child.getVisibility() == View.GONE) {
                    continue;
                }
                MarginLayoutParams lp = (MarginLayoutParams) child
                        .getLayoutParams();

                int lc = left + lp.leftMargin;
                int tc = top + lp.topMargin;
                int rc = lc + child.getMeasuredWidth();
                int bc = tc + child.getMeasuredHeight();

                child.layout(lc, tc, rc, bc);

                left += child.getMeasuredWidth() + lp.leftMargin
                        + lp.rightMargin;
            }
           // if (lineViews.size() != 0)
             //   layoutView(left, top, lineViews, lineWidth, lineHeight);
            top += lineHeight;
        }

    }

    public void layoutView(int l, int t, List<View> views, int width, int height) {
        int left = l;
        int top = t;
        int count = views.size();//一行一共View个数
        // 总宽度
        int layoutWidth = getMeasuredWidth() - getPaddingLeft()
                - getPaddingRight();
        // 剩余的宽度，是除了View和间隙的剩余空间
        int surplusWidth = layoutWidth - width /*- mHorizontalSpacing * (count - 1)*/;
        if (surplusWidth >= 0) {// 剩余空间
            // 采用float类型数据计算后四舍五入能减少int类型计算带来的误差
            int splitSpacing = (int) (surplusWidth / count + 0.5);
            for (int i = 0; i < count; i++) {
                final View view = views.get(i);
                int childWidth = view.getMeasuredWidth();
                int childHeight = view.getMeasuredHeight();
                // 计算出每个View的顶点，是由最高的View和该View高度的差值除以2
                int topOffset = (int) ((height - childHeight) / 2.0 + 0.5);
                if (topOffset < 0) {
                    topOffset = 0;
                }
                // 把剩余空间平均到每个View上
                childWidth = childWidth + splitSpacing;
                view.getLayoutParams().width = childWidth;
                if (splitSpacing > 0) {// View的长度改变了，需要重新measure
                    int widthMeasureSpec = MeasureSpec.makeMeasureSpec(
                            childWidth, MeasureSpec.EXACTLY);
                    int heightMeasureSpec = MeasureSpec.makeMeasureSpec(
                            childHeight, MeasureSpec.EXACTLY);
                    view.measure(widthMeasureSpec, heightMeasureSpec);
                }
                // 布局View
                view.layout(left, top + topOffset, left + childWidth, top
                        + topOffset + childHeight);
                left += childWidth /*+ mHorizontalSpacing*/; // 为下一个View的left赋值
            }
        } else {
            if (count == 1) {
                View view = views.get(0);
                view.layout(left, top, left + view.getMeasuredWidth(), top
                        + view.getMeasuredHeight());
            } else {
                // 走到这里来，应该是代码出问题了，目前按照逻辑来看，是不可能走到这一步
            }
        }
    }


    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }
}
