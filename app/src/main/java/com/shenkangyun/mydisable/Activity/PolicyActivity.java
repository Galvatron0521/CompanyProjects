package com.shenkangyun.mydisable.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.shenkangyun.mydisable.Adapter.LeftAdapter;
import com.shenkangyun.mydisable.Adapter.RightAdapter;
import com.shenkangyun.mydisable.R;
import com.shenkangyun.mydisable.UI.List.Bean;
import com.shenkangyun.mydisable.UI.List.ItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PolicyActivity extends AppCompatActivity {


    @BindView(R.id.mec_back)
    ImageView mecBack;
    @BindView(R.id.mec_title)
    TextView mecTitle;
    @BindView(R.id.mec_toolbar)
    Toolbar mecToolbar;
    @BindView(R.id.listview_left)
    ListView listviewLeft;
    @BindView(R.id.listview_right)
    RecyclerView listviewRight;

    private static final String TAG = MainActivity.class.getSimpleName();

    private ListView mListViewLeft;
    private LeftAdapter mLeftAdapter;

    private RecyclerView mListViewRight;
    private RightAdapter mRightAdapter;

    private ArrayList<Bean> dataList = new ArrayList<>();
    private ArrayList<String> titleList = new ArrayList<>();
    private ArrayList<Integer> titlePosList = new ArrayList<>();

    private String mCurTitle = "";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        mListViewLeft = (ListView) findViewById(R.id.listview_left);
        mLeftAdapter = new LeftAdapter(this, titleList);
        mListViewLeft.setAdapter(mLeftAdapter);
        mListViewLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                mLeftAdapter.setSelection(pos);
                if (null != titleList && titleList.size() > pos)
                    mRightAdapter.setSelection(pos);
            }
        });

        mListViewRight = (RecyclerView) findViewById(R.id.listview_right);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mListViewRight.setLayoutManager(linearLayoutManager);
        mRightAdapter = new RightAdapter(this, dataList, titlePosList, mListViewRight);
        mListViewRight.addItemDecoration(new ItemDecoration(this, dataList, new ItemDecoration.OnDecorationCallback() {
            @Override
            public String onGroupId(int pos) {
                if (dataList.get(pos).getTitle() != null)
                    return dataList.get(pos).getTitle();
                return "-1";
            }

            @Override
            public String onGroupFirstStr(int pos) {
                if (dataList.get(pos).getTitle() != null)
                    return dataList.get(pos).getTitle();
                return "";
            }

            @Override
            public void onGroupFirstStr(String title) {
                for (int i = 0; i < titleList.size(); i++) {
                    if (!mCurTitle.equals(title) && title.equals(titleList.get(i))) {
                        mCurTitle = title;
                        mLeftAdapter.setSelection(i);// 设置左边ListView选中item
                        Log.i(TAG, "onGroupFirstStr: i = " + i);
                    }
                }
            }
        }));
        mListViewRight.setAdapter(mRightAdapter);
    }

    /**
     * 数据
     */

    private String[] leftStr = new String[]{"残疾儿童", "精神残疾", "视力残疾", "听力残疾", "肢体残疾", "鉴定与康复指导", "残疾儿童筛查及预防", "孕产妇筛查及预防", "残疾人辅助器具需求及适配", "日间照料及康复"};
    private boolean[] flagArray = {true, false, false, false, false, false, false, false, false, false};
    private String[][] rightStr = new String[][]{{"0-11岁残疾儿童康复救助"}, {"精神病人鉴定及康复救助及康复指导"},
            {"白内障", "0-15岁视力残疾儿童救助", "盲人定向行走"}, {"人工耳蜗"}, {"成年人康复救助"}, {"肢体，听力，视力残疾人"}, {"残疾儿童筛查及预防"},
            {"孕产妇筛查及诊断"}, {"残疾人辅助器具适配及适配"}, {"日间照料及康复"}
    };

    private void initData() {
        titlePosList.add(0);
        Bean bean = new Bean();
        bean.setTitle("残疾儿童");
        bean.setText("0-11岁残疾儿童康复救助");
        dataList.add(bean);
        titleList.add(dataList.get(dataList.size()-1).getTitle());



        titlePosList.add(dataList.size());
        Bean bean2 = new Bean();
        bean2.setTitle("精神残疾");
        bean2.setText("精神病人鉴定及康复救助及康复指导");
        dataList.add(bean2);
        titleList.add(dataList.get(dataList.size()-1).getTitle());

        titlePosList.add(dataList.size());
        Bean bean11 = new Bean();
        bean11.setTitle("视力残疾");
        bean11.setText("白内障");
        Bean bean12 = new Bean();
        bean12.setTitle("视力残疾");
        bean12.setText("0-15岁视力残疾儿童救助");
        Bean bean13 = new Bean();
        bean13.setTitle("视力残疾");
        bean13.setText("盲人定向行走");
        dataList.add(bean13);
        dataList.add(bean11);
        dataList.add(bean12);
        titleList.add(dataList.get(dataList.size()-1).getTitle());


        titlePosList.add(dataList.size());
        Bean bean4 = new Bean();
        bean4.setTitle("听力残疾");
        bean4.setText("人工耳蜗");
        dataList.add(bean4);
        titleList.add(dataList.get(dataList.size()-1).getTitle());


        titlePosList.add(dataList.size());
        Bean bean5 = new Bean();
        bean5.setTitle("肢体残疾");
        bean5.setText("成年人康复救助");
        dataList.add(bean5);
        titleList.add(dataList.get(dataList.size()-1).getTitle());


        titlePosList.add(dataList.size());
        Bean bean6 = new Bean();
        bean6.setTitle("鉴定与康复指导");
        bean6.setText("肢体，听力，视力残疾人");
        dataList.add(bean6);
        titleList.add(dataList.get(dataList.size()-1).getTitle());


        titlePosList.add(dataList.size());
        Bean bean7 = new Bean();
        bean7.setTitle("残疾儿童筛查及预防");
        bean7.setText("残疾儿童筛查及预防");
        dataList.add(bean7);
        titleList.add(dataList.get(dataList.size()-1).getTitle());


        titlePosList.add(dataList.size());
        Bean bean8 = new Bean();
        bean8.setTitle("孕产妇筛查及诊断");
        bean8.setText("孕产妇筛查及诊断");
        dataList.add(bean8);
        titleList.add(dataList.get(dataList.size()-1).getTitle());


        titlePosList.add(dataList.size());
        Bean bean9 = new Bean();
        bean9.setTitle("残疾人辅助器具需求及适配");
        bean9.setText("残疾人辅助器具适配及适配");
        dataList.add(bean9);
        titleList.add(dataList.get(dataList.size()-1).getTitle());


        titlePosList.add(dataList.size());
        Bean bean10 = new Bean();
        bean10.setTitle("日间照料及康复");
        bean10.setText("日间照料及康复");
        dataList.add(bean10);
        titleList.add(dataList.get(dataList.size()-1).getTitle());
//        titlePosList.add(0);
//        for (int i=0; i<5; i++){
//            Bean bean = new Bean();
//            bean.setTitle("0");
//            bean.setText("zzzz");
//            dataList.add(bean);
//        }
//        titleList.add(dataList.get(dataList.size()-1).getTitle());
//        titlePosList.add(dataList.size());
//        for (int i=0; i<15; i++){
//            Bean bean = new Bean();
//            bean.setTitle("1");
//            bean.setText("xxxx");
//            dataList.add(bean);
//        }
//        titleList.add(dataList.get(dataList.size()-1).getTitle());
//        titlePosList.add(dataList.size());
//        for (int i=0; i<20; i++){
//            Bean bean = new Bean();
//            bean.setTitle("2");
//            bean.setText("cccc");
//            dataList.add(bean);
//        }
//        titleList.add(dataList.get(dataList.size()-1).getTitle());
//        titlePosList.add(dataList.size());
//        for (int i=0; i<10; i++){
//            Bean bean = new Bean();
//            bean.setTitle("3");
//            bean.setText("dddd");
//            dataList.add(bean);
//        }
//        titleList.add(dataList.get(dataList.size()-1).getTitle());
        mLeftAdapter.notifyDataSetChanged();
        mRightAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.mec_back)
    public void onViewClicked() {
        finish();
    }
}
