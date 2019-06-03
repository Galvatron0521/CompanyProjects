package com.shenkangyun.mydisable;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.shenkangyun.mydisable.Activity.LoginActivity;
import com.shenkangyun.mydisable.Utils.FuncUtil;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FuncUtil.iniSystemBar(this, R.color.colorTransParent);
        setContentView(R.layout.activity_welcome);
        initView();

    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.img_logo);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_logo:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
