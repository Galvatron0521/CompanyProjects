package com.shenkangyun.mydisable.Activity;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.shenkangyun.mydisable.Adapter.DrawerRecyclerAdapter;
import com.shenkangyun.mydisable.Fragment.CalenderFragment;
import com.shenkangyun.mydisable.Fragment.CommunityFragment;
import com.shenkangyun.mydisable.Fragment.MarketFragment;
import com.shenkangyun.mydisable.Fragment.ServiceFragment;
import com.shenkangyun.mydisable.Fragment.SettingFragment;
import com.shenkangyun.mydisable.Fragment.UserFragment;
import com.shenkangyun.mydisable.Fragment.UserInfoFragment;
import com.shenkangyun.mydisable.R;
import com.shenkangyun.mydisable.Utils.FuncUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.layout_frame)
    FrameLayout layoutFrame;
    @BindView(R.id.main_btn_market)
    RadioButton mainBtnMarket;
    @BindView(R.id.main_btn_community)
    RadioButton mainBtnCommunity;
    @BindView(R.id.main_btn_service)
    RadioButton mainBtnService;
    @BindView(R.id.main_btn_calender)
    RadioButton mainBtnCalender;
    @BindView(R.id.main_btn_user)
    RadioButton mainBtnUser;
    @BindView(R.id.drawer_recycler)
    RecyclerView drawerRecycler;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.main_tooBar)
    Toolbar mainTooBar;
    @BindView(R.id.toolBar_menu)
    ImageView toolBarMenu;

    private FragmentManager fragmentManager;
    private MarketFragment marketFragment;
    private CommunityFragment communityFragment;
    private ServiceFragment serviceFragment;
    private CalenderFragment calenderFragment;
    private UserFragment userFragment;
    private UserInfoFragment userInfoFragment;
    private SettingFragment settingFragment;
    private DrawerRecyclerAdapter drawerRecyclerAdapter;
    private List<String> item = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FuncUtil.iniSystemBar(this, R.color.colorWhite);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mainTooBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        initView();
        initAdapter();
    }
    @OnClick(R.id.toolBar_menu)
    public void onViewClicked() {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    private void initView() {
        fragmentManager = getSupportFragmentManager();
        marketFragment = new MarketFragment();
        communityFragment = new CommunityFragment();
        serviceFragment = new ServiceFragment();
        calenderFragment = new CalenderFragment();
        userFragment = new UserFragment();
        userInfoFragment = new UserInfoFragment();
        settingFragment = new SettingFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.layout_frame, serviceFragment);
        transaction.commit();
        toolbarTitle.setText("首页");
    }

    private void initAdapter() {
        item.add("个人信息");
        item.add("设置");
        drawerRecyclerAdapter = new DrawerRecyclerAdapter(this, item);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        drawerRecycler.setLayoutManager(manager);
        drawerRecycler.setAdapter(drawerRecyclerAdapter);
        drawerRecyclerAdapter.setOnItemClick(new DrawerRecyclerAdapter.onItemClick() {
            @Override
            public void onItemClick(int position) {
                switch (position) {
                    case 0:
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        transaction.replace(R.id.layout_frame, userInfoFragment);
                        transaction.commit();
                        toolbarTitle.setText("个人信息");
                        drawerLayout.closeDrawer(GravityCompat.START);

                        break;
                    case 1:
                        FragmentTransaction transaction1 = fragmentManager.beginTransaction();
                        transaction1.replace(R.id.layout_frame, settingFragment);
                        transaction1.commit();
                        toolbarTitle.setText("设置");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

            }
        });
    }

    @OnClick({R.id.main_btn_market, R.id.main_btn_community, R.id.main_btn_service, R.id.main_btn_calender, R.id.main_btn_user})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_btn_market:
                FragmentTransaction transaction1 = fragmentManager.beginTransaction();
                transaction1.replace(R.id.layout_frame, marketFragment);
                transaction1.commit();
                toolbarTitle.setText("商城");
                break;
            case R.id.main_btn_community:
                FragmentTransaction transaction2 = fragmentManager.beginTransaction();
                transaction2.replace(R.id.layout_frame, communityFragment);
                transaction2.commit();
                toolbarTitle.setText("社区");
                break;
            case R.id.main_btn_service:
                FragmentTransaction transaction3 = fragmentManager.beginTransaction();
                transaction3.replace(R.id.layout_frame, serviceFragment);
                transaction3.commit();
                toolbarTitle.setText("首页");
                break;
            case R.id.main_btn_calender:
                FragmentTransaction transaction4 = fragmentManager.beginTransaction();
                transaction4.replace(R.id.layout_frame, calenderFragment);
                transaction4.commit();
                toolbarTitle.setText("日历");
                break;
            case R.id.main_btn_user:
                FragmentTransaction transaction5 = fragmentManager.beginTransaction();
                transaction5.replace(R.id.layout_frame, userFragment);
                transaction5.commit();
                toolbarTitle.setText("我的");
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
