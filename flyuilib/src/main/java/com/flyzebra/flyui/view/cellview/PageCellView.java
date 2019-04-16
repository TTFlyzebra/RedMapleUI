package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.flyzebra.flyui.IAction;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.config.ActionKey;
import com.flyzebra.flyui.config.Gravity;
import com.flyzebra.flyui.module.FlyAction;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.utils.RtlTools;
import com.flyzebra.flyui.view.customview.MirrorView;
import com.flyzebra.flyui.view.pageview.SimplePageView;

/**
 * Author FlyZebra
 * 2019/4/2 16:15
 * Describ:
 **/
public class PageCellView extends FrameLayout implements ICell, IAction {
    private CellBean mCellBean;
    private static Handler sHander = new Handler(Looper.getMainLooper());
    private static Runnable hideMenuTask = new Runnable() {
        @Override
        public void run() {
            FlyLog.d("hide Menu Task run");
            FlyAction.notifyAction(ActionKey.STATUS_MENU, false);
        }
    };

    public PageCellView(Context context) {
        super(context);
    }

    @Override
    public void initView(Context context) {

    }

    @Override
    public void upData(CellBean cellBean) {
        this.mCellBean = cellBean;
        if (mCellBean != null && mCellBean.cellpage != null) {
            SimplePageView simplePageView = new SimplePageView(getContext());
            addView(simplePageView);
            simplePageView.upData(mCellBean.cellpage);
        }

        try {
            setBackgroundColor(Color.parseColor(mCellBean.backcolor));
        } catch (Exception e) {
            FlyLog.d("error! parseColor exception!" + e.toString());
        }
    }

    @Override
    public void doEvent() {

    }

    @Override
    public void bindMirrorView(MirrorView mirrorView) {

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //TODO:处理弹出菜单
        if (mCellBean.recvAction == ActionKey.STATUS_MENU) {
            sHander.removeCallbacks(hideMenuTask);
            sHander.postDelayed(hideMenuTask, 5000);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        FlyAction.register(this);
        if (mCellBean.recvAction == ActionKey.STATUS_MENU) {
            goAnimtor(false,0);
            FlyAction.notifyAction(ActionKey.STATUS_MENU, false);
        } else if (mCellBean.recvAction > 0) {
            onAction(mCellBean.recvAction);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        sHander.removeCallbacksAndMessages(null);
        FlyAction.unregister(this);
        super.onDetachedFromWindow();
    }

    @Override
    public boolean onAction(int key) {
        if (mCellBean == null) return false;
        Object obj = FlyAction.getValue(key);
        switch (key) {
            case ActionKey.STATUS_MENU:
                if (mCellBean.recvAction == ActionKey.STATUS_MENU) {
                    FlyLog.d("cellid=%d,key=%d,obj=" + obj, mCellBean.cellId, key);
                    if (obj instanceof Boolean) {
                        goAnimtor((Boolean) obj,300);
                    }
                }
                return false;
        }
        return false;
    }

    private void goAnimtor(final boolean isShow, long during) {
        FlyLog.d("isShow=" + isShow);
        if (isShow) {
            sHander.removeCallbacks(hideMenuTask);
            sHander.postDelayed(hideMenuTask, 5000);
        } else {
            sHander.removeCallbacks(hideMenuTask);
        }
        switch (mCellBean.gravity) {
            case Gravity.LEFT:
                break;
            case Gravity.RIGHT:
                boolean isRtl = RtlTools.isRtl();
                animate().translationX(isShow ? 0 : (isRtl ? -(mCellBean.width - mCellBean.mLeft + mCellBean.mRight)
                        : (mCellBean.width - mCellBean.mLeft + mCellBean.mRight))
                ).setDuration(during).start();
                break;
            case Gravity.TOP:
                break;
            case Gravity.BOTTOM:
                break;
        }
    }
}
