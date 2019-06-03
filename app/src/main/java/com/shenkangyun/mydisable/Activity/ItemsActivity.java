package com.shenkangyun.mydisable.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.shenkangyun.mydisable.Adapter.ItemsNameAdapter;
import com.shenkangyun.mydisable.R;
import com.shenkangyun.mydisable.Utils.FuncUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ItemsActivity extends AppCompatActivity {

    @BindView(R.id.toolBar_back)
    ImageView toolBarBack;
    @BindView(R.id.toolBar_title)
    TextView toolBarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.items_recycler)
    ExpandableListView itemsRecycler;
    @BindView(R.id.items_details)
    TextView itemsDetails;

    public String[] GroupStrings = {"盲人", "低视力者", "0-6岁听力残疾儿童", "0-11岁听力残疾儿童", "12-17岁听力残疾少年", "成年听力残疾人",
            "0-11岁肢体残疾儿童", "12岁以上肢体残疾人", "0-11岁智力残疾儿童", "12岁以上智力残疾人", "0-11岁精神残疾儿童", "12-17岁精神残疾少年", "成年精神残疾人",
            "残疾预防", "0-11岁儿童残疾筛查", "持证残疾人"};

    public String[][] ChildStrings = {{"白内障复明手术", "辅助器具适配及服务", "定向行走及训练", "支持性服务"}, {"辅助器具适配及服务", "视功能训练"},
            {"人工耳蜗植入手术及服务"}, {"助听器适配及服务", "听觉言语功能训练", "支持性服务"}, {"辅助器具适配及服务", "支持性服务"},
            {"辅助器具适配及适应训练"}, {"矫治手术", "辅助器具适配及服务", "运动及适应训练", "支持性服务"}, {"辅助器具适配及服务", "康复治疗及训练", "支持性服务"},
            {"认知及适应训练", "支持性服务"}, {"认知及适应训练", "支持性服务"}, {"沟通及适应训练", "支持性服务"}, {"沟通及适应训练", "支持性服务"},
            {"精神疾病治疗", "精神障碍作业疗法训练", "支持性服务"}, {"听力遗传基因检测项目"}, {"新发儿童疾病信息"}, {"心理健康", "家庭医生签约服务", "居民基本医疗保险代缴"}};


    private ItemsNameAdapter nameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FuncUtil.iniSystemBar(this, R.color.colorTransParent);
        setContentView(R.layout.activity_items);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        nameAdapter = new ItemsNameAdapter(this, GroupStrings, ChildStrings);
        itemsRecycler.setAdapter(nameAdapter);
        itemsRecycler.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                switch (groupPosition) {
                    case 0:
                        switch (childPosition) {
                            case 0:
                                itemsDetails.setText("白内障摘除术和人工晶体植入术，做好术后护理。标准参见《临床诊疗指南-眼科学分册》。");
                                break;
                            case 1:
                                itemsDetails.setText("盲杖、读书机等视力残疾人辅助器具，根据使用年限评估调换。");
                                break;
                            case 2:
                                itemsDetails.setText("功能评估；定向技能及行走训练，每年4次，每次2小时；社 会适应能力训练，每年4次，每次2小时。");
                                break;
                            case 3:
                                itemsDetails.setText("中途盲者心理疏导，盲后半年内，每月不少于1次");
                                break;
                        }
                        break;
                    case 1:
                        switch (childPosition) {
                            case 0:
                                itemsDetails.setText("基本型远距离助视器、近距离助视器；助视器适应性训练 根据使用年限评估调换。");
                                break;
                            case 1:
                                itemsDetails.setText("功能评估；视觉基本技能训练含固定注视．定位注视，视觉 跟踪与追踪．视觉搜寻训练，训练时间不少于1个月。");
                                break;
                        }
                        break;
                    case 2:
                        switch (childPosition) {
                            case 0:
                                itemsDetails.setText("植入人工耳蜗。标准参见《人工耳蜗植入工作指南 2013年版》中华医学会编著．单耳佩戴；第 一年调机不少于3次，之后每年调机不少于1次。");
                                break;
                        }
                        break;
                    case 3:
                        switch (childPosition) {
                            case 0:
                                itemsDetails.setText("1．助听器。双耳配戴；每年助听器调试不少于2次。 2．助听器辅助材料。耳模，每半年评估1次。电池，每日自行评估。根据评估结果更换耳模．电池。");
                                break;
                            case 1:
                                itemsDetails.setText("功能评估，至少提供2次听觉、言语康复能力评估术 前或适配前1次，术后或适配后1次；康复训练，根 据评估结果，每年训练时间不少于10个月，全日制康 复训练每天单训不少于30分钟；非全曰制康复训练 的儿童，每周单训不少于3次，每次不少于1小时。");
                                break;
                            case 2:
                                itemsDetails.setText("儿童家长康复指导、心理辅导、康复咨询和家庭康复 指导等服务。每年家长康复指导不少于10个月，每 月至少服务2次，每次不少于30分钟。");
                                break;
                        }
                        break;
                    case 4:
                        switch (childPosition) {
                            case 0:
                                itemsDetails.setText(" 助听器，双耳配戴，适配后第一年助听调试不少于2 次，之后每年助听调试不少于1次；助听器适应性训 练，训练时问不少于1个月，每周至少服务1次，每  次不少于30分钟。");
                                break;
                            case 1:
                                itemsDetails.setText("家长康复指导、心理辅导，康复咨询和家庭康复指导 等服务，每半年至少1次，每次不少于30分钟。");
                                break;
                        }
                        break;
                    case 5:
                        switch (childPosition) {
                            case 0:
                                itemsDetails.setText("助听器，至少1耳配戴助听器，适配后第一年助听调 试不少于2次，之后每年助听调试不少于1次；助听 墨适应性训练，训练时间不少于1个月，每周至少服 务1次，每次不少于30分钟。");
                                break;
                        }
                        break;
                    case 6:
                        switch (childPosition) {
                            case 0:
                                itemsDetails.setText("先天性马蹄内翻足等足畸形、小儿麻痹后遗症霰 导致严重痉挛、肌艘挛缩、关节畸形及脱位、脊柱裂 导致下肢畸形等矫治手术。标堆参见《l临床诊疗指南 -小儿外科学分册》(中华医学会编著，人民卫生出版社)、《临床技术操作规范-小儿外科学分册》(中华医学会编著，人民军医出版社)");
                                break;
                            case 1:
                                itemsDetails.setText("根据评估结果选择适配基本型假肢、矫形器、轮椅、 助行器具、坐姿椅、站立架等辅助器具，提供使用指 导；每半年评估1次，必要时更换。");
                                break;
                            case 2:
                                itemsDetails.setText("功能评估（含运动功能、语言、日常生活、社会参与能力等）；康复训练，包括维持关节活动度、增强肌力、语言训练、日常生活能力训练、社会参与能力训练等，根据评估结果，每年训练时间不少于10个月，全日制康复训练每天单训不少于30分钟，非全日制康复训练的儿童，每周单训不少于3次，每次不少于1小时。");
                                break;
                            case 3:
                                itemsDetails.setText("儿童家长康复知识培训、心理辅导、康复咨询，家庭康复指导等服务。每年家长康复指导不少于10个月， 每月至少服务2次，每次不少于30分钟。");
                                break;
                        }
                        break;
                    case 7:
                        switch (childPosition) {
                            case 0:
                                itemsDetails.setText("根据评估结果选择适配基本型假肢、矫形器、轮椅、 助行器具，生活自助具等辅助器具，提供使用指导； 每3年评估1次，必要时更换（13-17岁儿童少年每年评估1次）。");
                                break;
                            case 1:
                                itemsDetails.setText("功能评估（含运动功能，认知能力、日常生活、社会参与能力等）；康复治疗及训练，包括运动疗法、作业疗法、肢体综合训练、认知训练等，每月训练不少于1次，每次30分钟。");
                                break;
                            case 2:
                                itemsDetails.setText("重度肢体残疾人日间照料，长期护理、居家护理、家庭康复指导等服务。");
                                break;
                        }
                        break;
                    case 8:
                        switch (childPosition) {
                            case 0:
                                itemsDetails.setText("功能评估（含认知、生活自理和社会适应能力等）；康复训练，包括认知．生活自理和社会适应能力训练等，根据评估结果，每年训练时间不少于10个月，全日制康复训练每天单训不少于30分钟，非全日制康复训练的儿童，每周单训不少于3次，每次不少于1小时");
                                break;
                            case 1:
                                itemsDetails.setText("儿童家长康复知识培训、心理辅导、康复咨询、家庭 康复指导等服务。每年家长康复指导不少于10个月， 每月至少服务2次，每次不少于30分钟。");
                                break;
                        }
                        break;
                    case 9:
                        switch (childPosition) {
                            case 0:
                                itemsDetails.setText("功能评估含认知、生活自理和社会适应能力等； 康复训练，包括认知、生活自理、职业康复训练和社 会适应能力训练等，每月不少于1次，每次不少于30 分钟。");
                                break;
                            case 1:
                                itemsDetails.setText("重度智力残疾人日间照料、长期护理、居家护理、家 庭康复指导等服务。");
                                break;
                        }
                        break;
                    case 10:
                        switch (childPosition) {
                            case 0:
                                itemsDetails.setText("功能评估（含言语沟通．社交能力，生活自理等）；康复训练，包括言语沟通，社交能力．生活自理能力等，根据评估结果，每年训练时间不少于10个月，全日制康复训练每天单训不少于30分钟，非全日制康复训练的儿童，每周单训不少于3次，每次不少于1小时。");
                                break;
                            case 1:
                                itemsDetails.setText("儿童家长康复知识培训、心理辅导．康复咨询、家庭康复指导等服务。每年家长康复指导不少于10个月，每月至少服务2次，每次不少于30分钟。");
                                break;
                        }
                        break;
                    case 11:
                        switch (childPosition) {
                            case 0:
                                itemsDetails.setText("功能评估（含言语沟通、情绪和行为、社交能力、生活自理等）；康复训练，包括言语沟通，情绪和行为、社交能力、生活自理能力等，根据评估结果，每月不少于1次，每次不少于30分钟。");
                                break;
                            case 1:
                                itemsDetails.setText("儿童家长康复知识培训、心理辅导、康复咨询、家庭 康复指导等服务，每半年至少1次，每次不少于30 分钟。");
                                break;
                        }
                        break;
                    case 12:
                        switch (childPosition) {
                            case 0:
                                itemsDetails.setText("精神病治疗基本药物；重症急性期患者住院治疗。标准参见《临床诊疗指南-精神病学分册》（中华医学会编著，人民卫生出版社）");
                                break;
                            case 1:
                                itemsDetails.setText("功能评估（含生活自理、社会交往、体能等）；作业疗法训练，包括日常生活活动（ADL）训练、家务活动训练等，每月不少于1次，每次训练不少于30分钟。");
                                break;
                            case 2:
                                itemsDetails.setText("生活自理、心理疏导、日间照料、工（娱）疗、农疗、职业康复、家庭康复指导等服务；每月随访1次。");
                                break;
                        }
                        break;
                    case 13:
                        switch (childPosition) {
                            case 0:
                                itemsDetails.setText("对检测对象每人提供一次遗传性致聋基因免费检测，并提供分析报告、遗传咨询和婚育指导等服务。");
                                break;
                        }
                        break;
                    case 14:
                        switch (childPosition) {
                            case 0:
                                itemsDetails.setText("开展儿童残疾筛查服务，重点对视力、听力、肢体、智力及孤独症五类残疾儿童进行筛查和预防；做好辖区儿童残疾筛查的信息登记、上报和管理工作。");
                                break;
                        }
                        break;
                    case 15:
                        switch (childPosition) {
                            case 0:
                                itemsDetails.setText("心理疏导、咨询、诊疗。");
                                break;
                            case 1:
                                itemsDetails.setText("为每名残疾人建立健康档案，包括0-6岁儿童健康管 理、残疾人康复指导、重性精神病患者健康管理；对残疾人提供个性化健康管理服务，每年对其进行2次 健康状况评估，制订个性化的健康规划；发放健康教育材料，每年不少于1份；为行动不便并有需求的残疾人提供健康咨询和指导服务；为签约残疾人优先提供双向转诊服务，联系预约二级以上医院相关专家。");
                                break;
                            case 2:
                                itemsDetails.setText("参加居民基本医疗保险，享受个人缴费最低档政府补助。");
                                break;
                        }
                        break;
                }
                return true;
            }
        });
    }

    @OnClick(R.id.toolBar_back)
    public void onViewClicked() {
        finish();
    }
}
