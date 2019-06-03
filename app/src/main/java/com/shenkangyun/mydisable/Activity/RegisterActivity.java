package com.shenkangyun.mydisable.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shenkangyun.mydisable.R;
import com.shenkangyun.mydisable.Utils.FuncUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {


    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FuncUtil.iniSystemBar(this, R.color.colorTransParent);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.register_btn_commit, R.id.register_btn_quit})
    public void onViewClicked(View view) {
        intent = new Intent(this, LoginActivity.class);
        switch (view.getId()) {
            case R.id.register_btn_commit:
                startActivity(intent);
                finish();
                break;
            case R.id.register_btn_quit:
                startActivity(intent);
                finish();
                break;
        }
    }
}
