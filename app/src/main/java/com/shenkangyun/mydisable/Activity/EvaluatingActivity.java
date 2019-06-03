package com.shenkangyun.mydisable.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shenkangyun.mydisable.R;
import com.shenkangyun.mydisable.Utils.FuncUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class EvaluatingActivity extends AppCompatActivity implements PhotoViewAttacher.OnPhotoTapListener {

    @BindView(R.id.eva_img)
    PhotoView evaImg;
    @BindView(R.id.toolBar_back)
    ImageView toolBarBack;
    @BindView(R.id.toolBar_title)
    TextView toolBarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FuncUtil.iniSystemBar(this, R.color.colorTransParent);
        setContentView(R.layout.activity_evaluating);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        evaImg.setOnPhotoTapListener(this);
    }

    @Override
    public void onPhotoTap(View view, float x, float y) {
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.toolBar_back)
    public void onViewClicked() {
        finish();
    }
}
