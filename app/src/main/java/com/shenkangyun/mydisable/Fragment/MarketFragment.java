package com.shenkangyun.mydisable.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.shenkangyun.mydisable.Activity.GoodsInfoActivity;
import com.shenkangyun.mydisable.Adapter.MarketAdapter;
import com.shenkangyun.mydisable.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/10/14.
 */

public class MarketFragment extends Fragment {

    @BindView(R.id.market_recycler)
    RecyclerView marketRecycler;
    private MarketAdapter marketAdapter;
    private List<Integer> imgList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_market, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        imgList.clear();
        imgList.add(R.drawable.lsr_a);
        imgList.add(R.drawable.lsr_b);
        imgList.add(R.drawable.lsr_c);
        imgList.add(R.drawable.lsr_d);
        imgList.add(R.drawable.lsr_e);
        imgList.add(R.drawable.lsr_f);
        imgList.add(R.drawable.lsr_g);
        imgList.add(R.drawable.lsr_h);
        marketAdapter = new MarketAdapter(getActivity(), imgList);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        marketRecycler.setLayoutManager(gridLayoutManager);
        marketRecycler.setAdapter(marketAdapter);
        marketAdapter.setOnItemClick(new MarketAdapter.onItemClick() {
            @Override
            public void onItemClick(int position) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(getActivity(), GoodsInfoActivity.class);
                        intent.putExtra("img", imgList.get(position));
                        intent.putExtra("info", "对中风后运动障碍的病人通过分析脑区激活程度搭建人脑和偏瘫肢体的信息通路，可以有效促进原有运动障碍反射弧的逐渐恢复。");
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(), GoodsInfoActivity.class);
                        intent1.putExtra("img", imgList.get(position));
                        intent1.putExtra("info", "脑控外骨骼上肢康复机器人以康复理论为基础，结合临床上常用的偏瘫康复疗法，针对性地解决中枢神经损伤后所导致的上肢运动功能障碍，提高患者康复训练效果。");
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getActivity(), GoodsInfoActivity.class);
                        intent2.putExtra("img", imgList.get(position));
                        intent2.putExtra("info", "脑控外骨骼下肢康复机器人以康复理论为基础，结合临床上常用的偏瘫康复疗法，针对性地解决中枢神经损伤后所导致的下肢运动功能障碍，提高患者康复训练效果。");
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getActivity(), GoodsInfoActivity.class);
                        intent3.putExtra("img", imgList.get(position));
                        intent3.putExtra("info", "脑控手功能康复机器人是根据人手的各种运动特征设计的，将其穿戴于患者手部生理机能丧失或障碍的手上，使患者能够模拟在日常生活中所需的手部的运动，达到手部各个关节的运动康复锻炼，使机器人与人体手指能够协调的运动，从而达到最佳的手部康复效果。");
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getActivity(), GoodsInfoActivity.class);
                        intent4.putExtra("img", imgList.get(position));
                        intent4.putExtra("info", "适用于运动员比赛及训练、部队军事训练、军事作战等高强度运动条件下或危重病患者、在轨航天员等特殊人群的生命体征各项指标的实时监测。");
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(getActivity(), GoodsInfoActivity.class);
                        intent5.putExtra("img", imgList.get(position));
                        intent5.putExtra("info", "适用于军人、运动员、学生、老年人等神经高度亢奋或低落需要改善的人群，以及焦虑症、抑郁症患者经常失眠的人群。");
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(getActivity(), GoodsInfoActivity.class);
                        intent6.putExtra("img", imgList.get(position));
                        intent6.putExtra("info", "适于患者的上、下肢的主动性训练和被动性训练适应人群。");
                        startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(getActivity(), GoodsInfoActivity.class);
                        intent7.putExtra("img", imgList.get(position));
                        intent7.putExtra("info", "智能轮椅能实现自我坐标和方向定位，并与使用者人机交互，通过语音交流可以到达患者想去的地方。");
                        startActivity(intent7);
                        break;
                }
            }
        });
    }
}
