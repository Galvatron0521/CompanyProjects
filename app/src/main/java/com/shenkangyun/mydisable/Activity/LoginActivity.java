package com.shenkangyun.mydisable.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.shenkangyun.mydisable.R;
import com.shenkangyun.mydisable.Utils.FuncUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.login_edt_userName)
    EditText loginEdtUserName;
    @BindView(R.id.login_edt_passWord)
    EditText loginEdtPassWord;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.login_tv_register)
    TextView loginTvRegister;
    @BindView(R.id.login_tv_forgotPass)
    TextView loginTvForgotPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FuncUtil.iniSystemBar(this, R.color.colorTransParent);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_login, R.id.login_tv_register, R.id.login_tv_forgotPass})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                Intent intent1 = new Intent(this,MainActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.login_tv_register:
                Intent intent2 = new Intent(this,RegisterActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.login_tv_forgotPass:
                Intent intent3 = new Intent(this,ForgetPassActivity.class);
                startActivity(intent3);
                finish();
                break;
        }
    }
}
