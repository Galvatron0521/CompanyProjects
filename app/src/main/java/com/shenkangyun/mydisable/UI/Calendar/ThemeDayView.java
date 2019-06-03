package com.shenkangyun.mydisable.UI.Calendar;

import android.content.Context;

import com.ldf.calendar.interf.IDayRenderer;
import com.ldf.calendar.view.DayView;

/**
 * Created by Administrator on 2017/11/2.
 */

public class ThemeDayView extends DayView {


    public ThemeDayView(Context context, int layoutResource) {
        super(context, layoutResource);
    }

    @Override
    public IDayRenderer copy() {
        return null;
    }
}
