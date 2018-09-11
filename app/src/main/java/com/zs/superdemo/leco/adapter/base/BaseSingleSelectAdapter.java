package com.zs.superdemo.leco.adapter.base;

import android.content.Context;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2015/8/15  17:33.
 * Description: 单项基类适配器
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2015/8/15        ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public abstract class BaseSingleSelectAdapter<T> extends BaseRecyclerAdapter<T> {
    protected int mCurrentSelect = -1;
    protected boolean isEnableSelect = true;

    public BaseSingleSelectAdapter(Context context) {
        super(context);
    }

    public boolean isSelectDate() {
        return mCurrentSelect >= 0;
    }

    public void setEnableSelect(boolean isEnableSelect) {
        this.isEnableSelect = isEnableSelect;
    }

    public int getCurrentSelect() {
        return mCurrentSelect;
    }


    public void setCurrentSelect(int currentSelect) {
        notifyItemChanged(mCurrentSelect);
        this.mCurrentSelect = currentSelect;
        notifyItemChanged(mCurrentSelect);
    }
}
