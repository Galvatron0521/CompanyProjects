package com.shenkangyun.mydisable.Adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.shenkangyun.mydisable.R;
import com.shenkangyun.mydisable.UI.List.Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/3.
 */

public class RightAdapter extends RecyclerView.Adapter {

    private static final String TAG = RightAdapter.class.getSimpleName();
    private Context mContext;
    private ArrayList<Bean> mDataList = new ArrayList<>();
    private ArrayList<Integer> mTitleIntList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private boolean mShouldScroll = false;

    public RightAdapter(Context context, ArrayList<Bean> dataList, ArrayList<Integer> titleIntList, RecyclerView recyclerView) {
        mContext = context;
        mDataList = dataList;
        mTitleIntList = titleIntList;
        mRecyclerView = recyclerView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_right, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        if (null != mDataList && mDataList.size() > 0) {
            viewHolder.textContent.setText(mDataList.get(position).getText());
        } else {
            Log.i(TAG, "getView: null == mDataList");
        }
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mDataList.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void setSelection(int pos) {
        if (pos < mDataList.size()) {
            moveToPosition(pos);
        }
    }

    /**
     * 使RecyclerView移动到指定的位置
     */
    private void moveToPosition(final int n) {
        //先从RecyclerView的LayoutManager中获取第一项和最后一项的Position
        int firstItem = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        int lastItem = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
        int pos = mTitleIntList.get(n);
        mShouldScroll = false;
        mRecyclerView.setOnScrollListener(new RecyclerViewListener(n));
        //然后区分情况
        if (pos <= firstItem) {
            //当要置顶的项在当前显示的第一个项的前面时
            mRecyclerView.scrollToPosition(pos);
        } else if (pos <= lastItem) {
            //当要置顶的项已经在屏幕上显示时
            int top = mRecyclerView.getChildAt(pos - firstItem).getTop() - 50;
            mRecyclerView.scrollBy(0, top);
        } else {
            //当要置顶的项在当前显示的最后一项的后面时,调用scrollToPosition只会将该项滑动到屏幕上。需要再次滑动到顶部
            mRecyclerView.scrollToPosition(pos);
            //这里这个变量是用在RecyclerView滚动监听里面的
            mShouldScroll = true;
        }
    }

    /**
     * 滚动监听
     */
    class RecyclerViewListener extends RecyclerView.OnScrollListener{
        private int n = 0;
        RecyclerViewListener(int n) {
            this.n = n;
        }
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            //在这里进行第二次滚动
            if (mShouldScroll ){
                mShouldScroll = false;
                moveToPosition(n);
            }
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textContent;
        private View view;
        ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            textContent = (TextView) itemView.findViewById(R.id.text_content);
        }
    }
}