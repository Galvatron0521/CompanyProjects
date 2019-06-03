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
 * Created by Administrator on 2017/10/17.
 */

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.ViewHolder> {

    private Context context;
    private List<Integer> imgList;
    private List<String> imgName = new ArrayList<>();

    private onItemClick onItemClick;

    public void setOnItemClick(onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public interface onItemClick {
        void onItemClick(int position);
    }

    public MarketAdapter(Context context, List<Integer> imgList) {
        this.context = context;
        this.imgList = imgList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.market_recycler_item, parent, false);
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
        imgName.clear();
        imgName.add("脑控康复训练系统");
        imgName.add("脑控外骨骼上肢康复机器人");
        imgName.add("脑控外骨骼下肢康复机器人");
        imgName.add("脑控手功能康复机器人");
        imgName.add("可穿戴生命体征监测系统");
        imgName.add("便携式磁诱导脑神经调控仪");
        imgName.add("智能康复训练器");
        imgName.add("智能轮椅");
        holder.marketGoodsImg.setImageResource(imgList.get(position));
        holder.marketGoodsName.setText(imgName.get(position));
    }

    @Override
    public int getItemCount() {
        return imgList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.market_goods_img)
        ImageView marketGoodsImg;
        @BindView(R.id.market_goods_name)
        TextView marketGoodsName;

        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            view = itemView;
        }
    }
}
