package com.shenkangyun.mydisable.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shenkangyun.mydisable.Activity.EvaluatingActivity;
import com.shenkangyun.mydisable.Activity.ItemsActivity;
import com.shenkangyun.mydisable.Activity.MechanismActivity;
import com.shenkangyun.mydisable.Activity.PolicyActivity;
import com.shenkangyun.mydisable.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/10/14.
 */

public class ServiceFragment extends Fragment {


    @BindView(R.id.service_mechanism)
    CardView serviceMechanism;
    @BindView(R.id.service_policy)
    CardView servicePolicy;
    @BindView(R.id.service_items)
    CardView serviceItems;
    @BindView(R.id.service_evaluating)
    CardView serviceEvaluating;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.service_mechanism, R.id.service_policy, R.id.service_items, R.id.service_evaluating})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.service_mechanism:
                Intent intent1 = new Intent(getActivity(), MechanismActivity.class);
                startActivity(intent1);
                break;
            case R.id.service_policy:
                Intent intent2 = new Intent(getActivity(), PolicyActivity.class);
                startActivity(intent2);
                break;
            case R.id.service_items:
                Intent intent3 = new Intent(getActivity(), ItemsActivity.class);
                startActivity(intent3);
                break;
            case R.id.service_evaluating:
                Intent intent4 = new Intent(getActivity(), EvaluatingActivity.class);
                startActivity(intent4);
                break;
        }
    }
}