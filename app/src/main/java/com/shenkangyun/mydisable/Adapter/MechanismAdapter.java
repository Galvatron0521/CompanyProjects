package com.shenkangyun.mydisable.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shenkangyun.mydisable.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/10/27.
 */

public class MechanismAdapter extends RecyclerView.Adapter<MechanismAdapter.ViewHolder> {


    private Context context;
    private List<String> name;

    public MechanismAdapter(Context context, List<String> name) {
        this.context = context;
        this.name = name;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mec_recycler_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mecName.setText(name.get(position));

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.mec_name)
        TextView mecName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
