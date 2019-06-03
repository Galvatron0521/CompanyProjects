package com.shenkangyun.mydisable.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.shenkangyun.mydisable.R;
import com.shenkangyun.mydisable.Utils.FuncUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuestionActivity extends AppCompatActivity {

    @BindView(R.id.question_toolbar_title)
    TextView questionToolbarTitle;
    @BindView(R.id.question_toolbar)
    Toolbar questionToolbar;
    @BindView(R.id.question_btn_admit)
    Button questionBtnAdmit;
    @BindView(R.id.question_btn_quit)
    Button questionBtnQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FuncUtil.iniSystemBar(this, R.color.colorWhite);
        setContentView(R.layout.activity_question);
        ButterKnife.bind(this);
        setSupportActionBar(questionToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        finish();
    }

    @OnClick({R.id.question_btn_admit, R.id.question_btn_quit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.question_btn_admit:
                Intent intent = new Intent(this, FeedBackActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.question_btn_quit:
                finish();
                break;
        }
    }
}
