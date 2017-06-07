package com.yoyiyi.soleil.widget.section;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Abstract Section with no States.
 * 修改过 @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 *
 * @author Gustavo Pagani
 */
public abstract class StatelessSection<T> extends Section<T> {

    /**
     * 带有泛型构造方法
     *
     * @param itemResourceId
     * @param data
     */
    public StatelessSection(int itemResourceId, List<T> data) {
        super(data);
        this.itemResourceId = itemResourceId;
    }


    /**
     * 带有泛型构造方法
     *
     * @param headerResourceId
     * @param itemResourceId
     * @param data
     */
    public StatelessSection(int headerResourceId, int itemResourceId, List<T> data) {
        this(itemResourceId, data);
        this.headerResourceId = headerResourceId;
        this.hasHeader = true;
    }


    /**
     * 带有泛型构造方法
     *
     * @param headerResourceId
     * @param footerResourceId
     * @param itemResourceId
     * @param data
     */
    public StatelessSection(int headerResourceId, int footerResourceId, int itemResourceId, List<T> data) {
        this(headerResourceId, itemResourceId, data);
        this.footerResourceId = footerResourceId;
        this.hasFooter = true;
    }

    public StatelessSection(int itemResourceId) {
        super();
        this.itemResourceId = itemResourceId;
    }


    /**
     * Create a Section object with loading/failed states, a custom header but no footer
     *
     * @param headerResourceId layout resource for its header
     * @param itemResourceId   layout resource for its items
     */
    public StatelessSection(int headerResourceId, int itemResourceId) {
        this(itemResourceId);
        this.headerResourceId = headerResourceId;
        this.hasHeader = true;
    }


    /**
     * Create a Section object with loading/failed states, a custom header and footer
     *
     * @param headerResourceId layout resource for its header
     * @param footerResourceId layout resource for its footer
     * @param itemResourceId   layout resource for its items
     */
    public StatelessSection(int headerResourceId, int footerResourceId, int itemResourceId) {
        this(headerResourceId, itemResourceId);
        this.footerResourceId = footerResourceId;
        this.hasFooter = true;
    }

    @Override
    public final void onBindLoadingViewHolder(ViewHolder holder) {
        super.onBindLoadingViewHolder(holder);
    }

    @Override
    public final ViewHolder getLoadingViewHolder(View view) {
        return super.getLoadingViewHolder(view);
    }

    @Override
    public final void onBindFailedViewHolder(ViewHolder holder) {
        super.onBindFailedViewHolder(holder);
    }

    @Override
    public final ViewHolder getFailedViewHolder(View view) {
        return super.getFailedViewHolder(view);
    }

    public void setMargins(View view, int left, int top, int right, int bottom) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        params.setMargins(left, top, right, bottom);
        view.setLayoutParams(params);
    }

    public void gone(View view) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = 0;
        params.width = 0;
        view.setLayoutParams(params);
    }

}
