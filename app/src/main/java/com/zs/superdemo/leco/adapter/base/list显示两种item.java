package com.zs.superdemo.leco.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by leco on 2017/4/21.
 * 农场list adapter
 */
public class list显示两种item extends BaseRecyclerAdapter<String> {
    private final int FARM = 1;
    private final int PRODUCTS = 2;

    private ItemClickListener mItemClickListener;

    public void setItemClickListener(ItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public interface ItemClickListener {
        public void onItemClick(View view, int postion);
    }

    public list显示两种item(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == FARM) {
            view = View.inflate(mContext,android.R.layout.activity_list_item, null);
            return new MyFarmViewHolder(view);
        } else if (viewType == PRODUCTS) {
            view = View.inflate(mContext, android.R.layout.test_list_item, null);
            return new MyProductsViewHolder(view);
        } else {
            return new MyFarmViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(v, position);
                }
            }
        });
        if (holder instanceof MyFarmViewHolder) {
            ((MyFarmViewHolder) holder).bindViewData(getItemData(position), position);
        }
        if (holder instanceof MyProductsViewHolder) {
            ((MyProductsViewHolder) holder).bindViewData(getItemData(position), position);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position < 4) {
//            return Integer.parseInt(getItemData(position)) % 2 == 0 ? FARM : PRODUCTS;
            return FARM;
        } else {
            return PRODUCTS;
        }
    }

    //农场item页面
    class MyFarmViewHolder extends RecyclerView.ViewHolder {

        public MyFarmViewHolder(View itemView) {
            super(itemView);
        }

        public void bindViewData(String itemData, int position) {
        }
    }

    //产品item页面
    class MyProductsViewHolder extends RecyclerView.ViewHolder {

        public MyProductsViewHolder(View itemView) {
            super(itemView);
        }

        public void bindViewData(String itemData, int position) {

        }
    }
}
