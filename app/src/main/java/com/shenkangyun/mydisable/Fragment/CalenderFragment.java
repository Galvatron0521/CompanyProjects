package com.shenkangyun.mydisable.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ldf.calendar.Utils;
import com.ldf.calendar.component.CalendarAttr;
import com.ldf.calendar.component.CalendarViewAdapter;
import com.ldf.calendar.interf.OnSelectDateListener;
import com.ldf.calendar.model.CalendarDate;
import com.ldf.calendar.view.Calendar;
import com.ldf.calendar.view.MonthPager;
import com.shenkangyun.mydisable.Adapter.CalenderAdapter;
import com.shenkangyun.mydisable.R;
import com.shenkangyun.mydisable.Utils.CustomDayView;
import com.shenkangyun.mydisable.Utils.ThemeDayView;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/10/14.
 */

public class CalenderFragment extends Fragment {

    @BindView(R.id.show_month_view)
    TextView showMonthView;
    @BindView(R.id.show_year_view)
    TextView showYearView;
    @BindView(R.id.choose_date_view)
    LinearLayout chooseDateView;
    @BindView(R.id.back_today_button)
    TextView backTodayButton;
    @BindView(R.id.scroll_switch)
    TextView scrollSwitch;
    @BindView(R.id.next_month)
    TextView nextMonth;
    @BindView(R.id.last_month)
    TextView lastMonth;
    @BindView(R.id.calendar_view)
    MonthPager calendarView;
    @BindView(R.id.list)
    RecyclerView list;
    @BindView(R.id.content)
    CoordinatorLayout content;
    private ArrayList<Calendar> currentCalendars = new ArrayList<>();
    private CalendarViewAdapter calendarAdapter;
    private OnSelectDateListener onSelectDateListener;
    private int mCurrentPage = MonthPager.CURRENT_DAY_INDEX;
    private Context context;
    private CalendarDate currentDate;
    private boolean initiated = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calender, container, false);
        ButterKnife.bind(this, view);
        context = getActivity();
        calendarView.setViewheight(Utils.dpi2px(context, 270));
        list.setHasFixedSize(true);
        //这里用线性显示 类似于listview
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.setAdapter(new CalenderAdapter(getActivity()));
        initCurrentDate();
        initCalendarView();
        initToolbarClickListener();
        initCalendarView();
        return view;
    }

    private void initToolbarClickListener() {
        backTodayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickBackToDayBtn();
            }
        });
        scrollSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (calendarAdapter.getCalendarType() == CalendarAttr.CalendayType.WEEK) {
                    Utils.scrollTo(content, list, calendarView.getViewHeight(), 200);
                    calendarAdapter.switchToMonth();
                } else {
                    Utils.scrollTo(content, list, calendarView.getCellHeight(), 200);
                    calendarAdapter.switchToWeek(calendarView.getRowIndex());
                }
            }
        });
        nextMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarView.setCurrentItem(calendarView.getCurrentPosition() + 1);
            }
        });
        lastMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarView.setCurrentItem(calendarView.getCurrentPosition() - 1);
            }
        });
    }

    /**
     * 初始化currentDate
     *
     * @return void
     */
    private void initCurrentDate() {
        currentDate = new CalendarDate();
        showYearView.setText(currentDate.getYear() + "年");
        showMonthView.setText(currentDate.getMonth() + "");
    }

    /**
     * 初始化CustomDayView，并作为CalendarViewAdapter的参数传入
     *
     * @return void
     */
    private void initCalendarView() {
        initListener();
        CustomDayView customDayView = new CustomDayView(context, R.layout.custom_day);
        calendarAdapter = new CalendarViewAdapter(
                context,
                onSelectDateListener,
                CalendarAttr.CalendayType.MONTH,
                customDayView);
        initMarkData();
        initMonthPager();
    }

    /**
     * 初始化标记数据，HashMap的形式，可自定义
     *
     * @return void
     */
    private void initMarkData() {
        HashMap<String, String> markData = new HashMap<>();
        markData.put("2017-8-9", "1");
        markData.put("2017-7-9", "0");
        markData.put("2017-6-9", "1");
        markData.put("2017-6-10", "0");
        calendarAdapter.setMarkData(markData);
    }

    private void initListener() {
        onSelectDateListener = new OnSelectDateListener() {
            @Override
            public void onSelectDate(CalendarDate date) {
                refreshClickDate(date);
            }

            @Override
            public void onSelectOtherMonth(int offset) {
                //偏移量 -1表示刷新成上一个月数据 ， 1表示刷新成下一个月数据
                calendarView.selectOtherMonth(offset);
            }
        };
    }

    private void refreshClickDate(CalendarDate date) {
        currentDate = date;
        showYearView.setText(date.getYear() + "年");
        showMonthView.setText(date.getMonth() + "");
    }

    /**
     * 初始化calendarView，MonthPager继承自ViewPager
     *
     * @return void
     */
    private void initMonthPager() {
        calendarView.setAdapter(calendarAdapter);
        calendarView.setCurrentItem(MonthPager.CURRENT_DAY_INDEX);
        calendarView.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                position = (float) Math.sqrt(1 - Math.abs(position));
                page.setAlpha(position);
            }
        });
        calendarView.addOnPageChangeListener(new MonthPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mCurrentPage = position;
                currentCalendars = calendarAdapter.getPagers();
                if (currentCalendars.get(position % currentCalendars.size()) instanceof Calendar) {
                    CalendarDate date = currentCalendars.get(position % currentCalendars.size()).getSeedDate();
                    currentDate = date;
                    showYearView.setText(date.getYear() + "年");
                    showMonthView.setText(date.getMonth() + "");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void onClickBackToDayBtn() {
        refreshMonthPager();
    }

    private void refreshMonthPager() {
        CalendarDate today = new CalendarDate();
        calendarAdapter.notifyDataChanged(today);
        showYearView.setText(today.getYear() + "年");
        showMonthView.setText(today.getMonth() + "");
    }

    private void refreshSelectBackground() {
        ThemeDayView themeDayView = new ThemeDayView(context, R.layout.custom_day_focus);
        calendarAdapter.setCustomDayRenderer(themeDayView);
        calendarAdapter.notifyDataSetChanged();
        calendarAdapter.notifyDataChanged(new CalendarDate());
    }
}
