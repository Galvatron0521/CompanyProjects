package com.shenkangyun.mydisable.Activity;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.MyLocationStyle;
import com.shenkangyun.mydisable.R;
import com.shenkangyun.mydisable.Utils.FuncUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FeedBackActivity extends AppCompatActivity {


    @BindView(R.id.result_toolBar)
    Toolbar resultToolBar;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.Map)
    MapView Map;

    private AMap aMap;
    private MyLocationStyle myLocationStyle = new MyLocationStyle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FuncUtil.iniSystemBar(this, R.color.colorWhite);
        setContentView(R.layout.activity_feed_back);
        ButterKnife.bind(this);
        setSupportActionBar(resultToolBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        Map.onCreate(savedInstanceState);// 此方法必须重写
    }

    private void init() {

        if (aMap == null) {
            aMap = Map.getMap();
        }
        //定位一次，且将视角移动到地图中心点。
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_SHOW);
        //设置是否显示定位小蓝点，用于满足只想使用定位，不想使用定位小蓝点的场景，设置false以后图面上不再有定位蓝点的概念，但是会持续回调位置信息。
        myLocationStyle.showMyLocation(true);
        //设置默认定位按钮是否显示，非必需设置。
        aMap.getUiSettings().setMyLocationButtonEnabled(true);
        // 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
        aMap.setMyLocationEnabled(true);

    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();
        Map.onResume();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onPause() {
        super.onPause();
        Map.onPause();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Map.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Map.onDestroy();
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        finish();
    }


}
