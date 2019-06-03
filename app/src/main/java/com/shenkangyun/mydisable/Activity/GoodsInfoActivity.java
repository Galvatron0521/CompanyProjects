package com.shenkangyun.mydisable.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.shenkangyun.mydisable.R;
import com.shenkangyun.mydisable.Utils.FuncUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoodsInfoActivity extends AppCompatActivity {

    @BindView(R.id.goods_info_title)
    TextView goodsInfoTitle;
    @BindView(R.id.goods_toolbar)
    Toolbar goodsToolbar;
    @BindView(R.id.goods_info_img)
    ImageView goodsInfoImg;
    @BindView(R.id.goods_info_detail)
    TextView goodsInfoDetail;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FuncUtil.iniSystemBar(this, R.color.colorWhite);
        setContentView(R.layout.activity_goods_info);
        ButterKnife.bind(this);
        setSupportActionBar(goodsToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        initView();
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        finish();
    }

    private void initView() {
        intent = getIntent();
        int img = intent.getIntExtra("img", R.mipmap.ic_launcher);
        String info = intent.getStringExtra("info");
        goodsInfoImg.setImageResource(img);
        goodsInfoDetail.setText(info);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
