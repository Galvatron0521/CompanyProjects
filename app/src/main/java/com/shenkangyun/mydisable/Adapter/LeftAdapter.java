package com.shenkangyun.mydisable.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.shenkangyun.mydisable.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/3.
 */

public class LeftAdapter extends BaseAdapter {
    private static final String TAG = LeftAdapter.class.getSimpleName();
    private Context mContext;
    private ArrayList<String> mDataList = new ArrayList<>();
    private int mSelection = 0;

    public LeftAdapter(Context mContext, ArrayList<String> mDataList) {
        this.mContext = mContext;
        this.mDataList = mDataList;
    }

    @Override
    public int getCount() {
        if (null != mDataList)
            return mDataList.size();
        return 0;
    }

    @Override
    public Object getItem(int i) {
        if (null != mDataList)
            return mDataList.get(i);
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (null == view){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.item_left, null);
            viewHolder.textContent = (TextView) view.findViewById(R.id.text_content);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        // 设置被选中的item的字体颜色
        if (null != viewHolder.textContent && mSelection == position){
            viewHolder.textContent.setTextColor(Color.RED);
        }else {
            viewHolder.textContent.setTextColor(Color.BLACK);
        }
        if (null != viewHolder.textContent && null != mDataList && mDataList.size()>0){
            viewHolder.textContent.setText(mDataList.get(position));
        }else {
            Log.i(TAG, "getView: null == mDataList");
        }
        return view;
    }

    public int getSelection() {
        return mSelection;
    }

    public void setSelection(int selection) {
        mSelection = selection;
        notifyDataSetChanged();
    }

    class ViewHolder{
        TextView textHead;
        TextView textContent;
    }
}
