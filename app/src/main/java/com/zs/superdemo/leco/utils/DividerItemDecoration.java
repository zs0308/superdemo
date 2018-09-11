package com.zs.superdemo.leco.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2016/5/30.
 * 线性listview 分割线
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private static final int[] ATTRS = new int[]{
            android.R.attr.listDivider
    };

    //列表水平
    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;

    //列表垂直
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

    private Drawable mDivider;
    private Paint mPaint;
    private int mDividerHeight = 2;//分割线高度

    private int mOrientation;

    /**
     * 使用系统分割线（可能无效）
     * @param context
     * @param orientation
     */
    public DividerItemDecoration(Context context, int orientation) {
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
        setOrientation(orientation);
    }

    /**
     * 自定义分割线
     *
     * @param context
     * @param orientation   列表方向
     * @param drawableId  分割线drawableid
     */
    public DividerItemDecoration(Context context, int orientation, int drawableId) {
        this(context, orientation);
        mDivider = context.getResources().getDrawable(drawableId);
    }

    /**
     * 自定义分割线
     *
     * @param context
     * @param orientation   列表方向
     * @param dividerHeight 分割线高度
     * @param dividerColor  分割线颜色
     */
    public DividerItemDecoration(Context context, int orientation, int dividerHeight, int dividerColor) {
        this(context, orientation);
        mDividerHeight = dividerHeight;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(context.getResources().getColor(dividerColor));
        mPaint.setStrokeWidth(dividerHeight);
        mPaint.setStyle(Paint.Style.FILL);
    }

    /**
     * 设置列表方向
     * @param orientation
     */
    public void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent) {
        if (mOrientation == VERTICAL_LIST) {
            drawVertical(c, parent);
        } else {
            drawHorizontal(c, parent);
        }
    }

    /**
     * 画分割线 垂直列表
     * @param canvas
     * @param parent
     */
    public void drawVertical(Canvas canvas, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            if (mDivider != null) {
                int bottom = top + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(canvas);
            }
            if (mPaint != null) {
                int bottom = (int) (top + mPaint.getStrokeWidth());
                canvas.drawRect(left, top, right, bottom, mPaint);
            }
        }
    }

    /**
     * 画分割线 水平列表
     * @param canvas
     * @param parent
     */
    public void drawHorizontal(Canvas canvas, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            if (mDivider != null) {
                int right = left + mDivider.getIntrinsicWidth();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(canvas);
            }
            if (mPaint != null) {
                int right = (int) (left + mPaint.getStrokeWidth());
                canvas.drawRect(left, top, right, bottom, mPaint);
            }
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        if (mOrientation == VERTICAL_LIST) {
            if (mDivider != null) {
                outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
            }
            if (mPaint != null) {
                outRect.set(0, 0, 0, mDividerHeight);
            }
        } else {
            if (mDivider != null) {
                outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
            }
            if (mPaint != null) {
                outRect.set(0, 0, (int) mPaint.getStrokeWidth(), 0);
            }
        }
    }
}
