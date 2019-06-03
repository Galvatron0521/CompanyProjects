package com.shenkangyun.mydisable.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shenkangyun.mydisable.R;
import com.shenkangyun.mydisable.Utils.FuncUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgetPassActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FuncUtil.iniSystemBar(this, R.color.colorTransParent);
        setContentView(R.layout.activity_forget_pass);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.forget_btn_confirm, R.id.forget_btn_quit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forget_btn_confirm:
                Intent intent1 = new Intent(this, LoginActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.forget_btn_quit:
                Intent intent2 = new Intent(this, LoginActivity.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
}
