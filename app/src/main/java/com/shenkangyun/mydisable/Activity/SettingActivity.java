package com.shenkangyun.mydisable.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shenkangyun.mydisable.R;
import com.shenkangyun.mydisable.Utils.FuncUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FuncUtil.iniSystemBar(this, R.color.colorWhite);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.change_btn_commit, R.id.change_btn_quit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.change_btn_commit:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.change_btn_quit:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                finish();
                break;
        }
    }
}
