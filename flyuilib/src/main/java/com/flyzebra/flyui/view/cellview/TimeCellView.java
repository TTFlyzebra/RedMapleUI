package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flyzebra.flyui.R;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.base.BaseImageCellView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class TimeCellView extends BaseImageCellView {
    private TextView timeView, dateView, weekView;
    private LinearLayout rootLayout;

    public TimeCellView(Context context) {
        super(context);
    }

    @Override
    public void initView(Context context) {
        super.initView(context);
        rootLayout = new LinearLayout(context);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        rootLayout.setGravity(Gravity.CENTER);
        addView(rootLayout, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        timeView = new TextView(context);
        timeView.setGravity(Gravity.CENTER);
        rootLayout.addView(timeView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        weekView = new TextView(context);
        weekView.setGravity(Gravity.CENTER);
        rootLayout.addView(weekView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        dateView = new TextView(context);
        dateView.setGravity(Gravity.CENTER);
        rootLayout.addView(dateView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        upView();
    }

    public void upView() {
        try {
            FlyLog.d("up time");
            timeView.setText(time);
            weekView.setText(week);
            dateView.setText(date);
        } catch (Exception e) {
            FlyLog.e(e.toString());
        }
    }

    @Override
    public void upData(CellBean cellBean) {
        this.mCellBean = cellBean;

        rootLayout.setPadding(cellBean.mLeft, cellBean.mTop, cellBean.mRight, cellBean.mBottom);

        int color = 0xFFFFFFFF;
        try {
            color = Color.parseColor(cellBean.textColor);
        } catch (Exception e) {
            color = 0xFFFFFFFF;
        }
        int margin = (cellBean.height - cellBean.textSize * 3 - cellBean.mBottom - cellBean.mTop) / 6;
        LinearLayout.LayoutParams tlp = (LinearLayout.LayoutParams) timeView.getLayoutParams();
        tlp.height = (int) (cellBean.textSize * 1.5f);
        tlp.setMargins(0, margin, 0, margin);
        timeView.setLayoutParams(tlp);
        LinearLayout.LayoutParams wlp = (LinearLayout.LayoutParams) weekView.getLayoutParams();
        wlp.height = (int) (cellBean.textSize / 2 * 1.5f);
        wlp.setMargins(0, margin, 0, margin);
        weekView.setLayoutParams(wlp);
        LinearLayout.LayoutParams dlp = (LinearLayout.LayoutParams) dateView.getLayoutParams();
        dlp.height = (int) (cellBean.textSize / 2 * 1.5f);
        dlp.setMargins(0, margin, 0, margin);
        dateView.setLayoutParams(dlp);
        timeView.setTextColor(color);
        timeView.setTextSize(TypedValue.COMPLEX_UNIT_PX, cellBean.textSize);
        weekView.setTextColor(color);
        weekView.setTextSize(TypedValue.COMPLEX_UNIT_PX, cellBean.textSize * 32 / 64);
        dateView.setTextColor(color);
        dateView.setTextSize(TypedValue.COMPLEX_UNIT_PX, cellBean.textSize * 32 / 64);
    }

    private static String getCurrentDate(String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.getDefault());
        Date date = new Date(System.currentTimeMillis());
        return sdf.format(date);
    }

    private String[] weeks = new String[7];

    private String getCurrentWeek() {
        weeks = new String[]{getContext().getString(R.string.tv_str_sunday),
                getContext().getString(R.string.tv_str_monday),
                getContext().getString(R.string.tv_str_tuesday),
                getContext().getString(R.string.tv_str_wednesday),
                getContext().getString(R.string.tv_str_thursday),
                getContext().getString(R.string.tv_str_friday),
                getContext().getString(R.string.tv_str_saturday)};
        Date date = new Date(System.currentTimeMillis());
        final Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTime(date);
        return weeks[mCalendar.get(Calendar.DAY_OF_WEEK) - 1];
    }

    private Timer mTimer;
    private String time = "";
    private String date = "";
    private String week = "";

    private Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mTimer == null) {
            mTimer = new Timer();
            mTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    String tmpTime = getCurrentDate("HH:mm");
                    String tmpDate = getCurrentDate("yyyy-MM-dd");
                    String tmpWeek = getCurrentWeek();
                    if (!(tmpTime.equals(time) && tmpDate.equals(date) && tmpWeek.equals(week))) {
                        time = tmpTime;
                        date = tmpDate;
                        week = tmpWeek;
                        mHandler.removeCallbacksAndMessages(null);
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                upView();
                            }
                        });
                    }
                }
            }, 0, 1000);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        mHandler.removeCallbacksAndMessages(null);
        if (mTimer != null) {
            mTimer.cancel();
        }
        super.onDetachedFromWindow();
    }
}
