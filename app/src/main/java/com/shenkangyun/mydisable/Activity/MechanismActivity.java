package com.shenkangyun.mydisable.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.shenkangyun.mydisable.Adapter.MechanismAdapter;
import com.shenkangyun.mydisable.R;
import com.shenkangyun.mydisable.Utils.FuncUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MechanismActivity extends AppCompatActivity {


    @BindView(R.id.mec_recycler)
    RecyclerView mecRecycler;
    @BindView(R.id.mec_back)
    ImageView mecBack;
    @BindView(R.id.mec_title)
    TextView mecTitle;
    @BindView(R.id.mec_toolbar)
    Toolbar mecToolbar;

    private MechanismAdapter mechanismAdapter;
    private List<String> name = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FuncUtil.iniSystemBar(this, R.color.colorTransParent);
        setContentView(R.layout.activity_mechanism);
        ButterKnife.bind(this);
        initToolBar();
        initList();
        initView();
    }

    private void initToolBar() {
        setSupportActionBar(mecToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }
        mecTitle.setText("服务机构");
    }

    private void initList() {
        name.clear();
        name.add("泰山区人民医院儿康中心");
        name.add("泰山区小天使康复中心");
        name.add("泰山区智康能力儿童活动中心");
        name.add("泰山区东岳特教中心");
        name.add("泰安市复退军人精神病院");
        name.add("泰安市爱尔眼科医院");
        name.add("泰安市姜玉坤眼镜有限公司");
        name.add("泰安市盲校");
        name.add("省残联");
        name.add("泰安市中医二院");
        name.add("泰山区人民医院");
        name.add("省庄镇卫生院");
        name.add("邱家店镇卫生院");
        name.add("各街道卫生服务中心");
        name.add("泰山区残疾人辅助器具服务中心");
        name.add("社区残疾人康复站");
    }

    private void initView() {
        mechanismAdapter = new MechanismAdapter(this, name);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mecRecycler.setLayoutManager(linearLayoutManager);
        mecRecycler.setAdapter(mechanismAdapter);
    }

    @OnClick(R.id.mec_back)
    public void onViewClicked() {
        finish();
    }
}
