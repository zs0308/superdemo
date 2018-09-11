package com.zs.superdemo.leco.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/*
private void initUI() {
        list = new ArrayList<>();
        adapter = new FarmListAdapter(getBaseContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(layoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration decoration = new DividerItemDecoration(getBaseContext(), DividerItemDecoration.VERTICAL_LIST, 1, R.color.line_color);
        recycler.addItemDecoration(decoration);
        //初始化list数据
        for (int i = 0; i < 6; i++) {
            list.add("" + i);
        }
        adapter.addItems(list);
        recycler.setAdapter(adapter);
    }
 */

/**
 * Created by leco on 2017/4/21.
 */
public class Recyclerviewdapter工具 extends BaseRecyclerAdapter<String> {

    private ItemClickListener mItemClickListener;

    public void setItemClickListener(ItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public interface ItemClickListener {
        public void onItemClick(View view, int postion);
    }

    public Recyclerviewdapter工具(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, android.R.layout.simple_gallery_item, null);
        return new MyViewHolder(view);

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
        //防止重复点击,用这个
//        holder.itemView.setOnClickListener(new NoDoubleClickListener() {
//            @Override
//            protected void onNoDoubleClick(View v) {
//                if (mItemClickListener != null) {
//                    mItemClickListener.onItemClick(v, position);
//                }
//            }
//        });
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).bindViewData(getItemData(position), position);
        }

    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }

        public void bindViewData(String itemData, int position) {
        }
    }

}
