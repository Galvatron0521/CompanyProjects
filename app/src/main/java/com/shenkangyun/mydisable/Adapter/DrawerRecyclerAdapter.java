package com.shenkangyun.mydisable.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.shenkangyun.mydisable.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/10/14.
 */

public class DrawerRecyclerAdapter extends RecyclerView.Adapter<DrawerRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<String> item;
    private onItemClick onItemClick;

    private List<Integer> img = new ArrayList<>();

    public void setOnItemClick(onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public interface onItemClick {
        void onItemClick(int position);
    }

    public DrawerRecyclerAdapter(Context context, List<String> item) {
        this.context = context;
        this.item = item;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.drawer_recycler_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onItemClick(viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        initView();
        holder.drawerTv.setText(item.get(position));
        holder.drawerImg.setImageResource(img.get(position));
    }

    private void initView() {
        img.clear();
        img.add(R.drawable.userinfo);
        img.add(R.drawable.setting);
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.drawer_img)
        ImageView drawerImg;
        @BindView(R.id.drawer_tv)
        TextView drawerTv;

        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            view = itemView;
        }
    }
}
