package com.shenkangyun.mydisable.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.shenkangyun.mydisable.Activity.SettingActivity;
import com.shenkangyun.mydisable.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/10/16.
 */

public class SettingFragment extends Fragment {
    @BindView(R.id.setting_btn_changeWord)
    Button settingBtnChangeWord;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.setting_btn_changeWord)
    public void onViewClicked() {
        Intent intent = new Intent(getContext(), SettingActivity.class);
        startActivity(intent);
    }
}
