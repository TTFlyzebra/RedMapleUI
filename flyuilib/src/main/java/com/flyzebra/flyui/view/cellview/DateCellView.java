package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.utils.FlyLog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class DateCellView extends SimpleCellView {
    private Timer mTimer;
    private String time = "";
    private String date = "";
    private String week = "";
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public DateCellView(Context context) {
        super(context);
    }

    @Override
    public boolean verify(CellBean cellBean) {
        return mCellBean != null && ((mCellBean.texts != null && (mCellBean.texts.size()>=3)));
    }

    @Override
    public void initView(Context context) {
        super.initView(context);
        if (mTimer == null) {
            mTimer = new Timer();
            mTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    String tmpTime = getCurrentDate("HH:mm");
                    String tmpDate = getCurrentDate("yyyy-MM-dd");
                    String tmpWeek = getCurrentDate("E");
                    tmpWeek = tmpWeek.replace("周","星期");
                    tmpWeek = tmpWeek.replace("週","星期");
                    if (!(tmpTime.equals(time) && tmpDate.equals(date) && tmpWeek.equals(week))) {
                        time = tmpTime;
                        date = tmpDate;
                        week = tmpWeek;
                        mHandler.removeCallbacksAndMessages(null);
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                refreshView(mCellBean);
                            }
                        });
                    }
                }
            }, 0, 1000);
        }
    }

    @Override
    public void refreshView(CellBean cellBean) {
        super.refreshView(cellBean);
        try {
            FlyLog.d("up time");
            if(textViewList.size()>=3) {
                textViewList.get(0).setText(time);
                textViewList.get(1).setText(date);
                textViewList.get(2).setText(week);
            }
        } catch (Exception e) {
            FlyLog.e(e.toString());
        }
    }

    private static String getCurrentDate(String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.getDefault());
        Date date = new Date(System.currentTimeMillis());
        return sdf.format(date);
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
