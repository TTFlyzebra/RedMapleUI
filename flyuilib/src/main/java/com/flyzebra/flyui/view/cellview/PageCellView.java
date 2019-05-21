//package com.flyzebra.flyui.view.cellview;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.os.Handler;
//import android.os.Looper;
//import android.view.MotionEvent;
//import android.widget.FrameLayout;
//
//import com.flyzebra.flyui.event.IAction;
//import com.flyzebra.flyui.bean.CellBean;
//import com.flyzebra.flyui.event.ActionKey;
//import com.flyzebra.flyui.config.Gravity;
//import com.flyzebra.flyui.event.FlyAction;
//import com.flyzebra.flyui.utils.FlyLog;
//import com.flyzebra.flyui.utils.RtlTools;
//import com.flyzebra.flyui.view.customview.MirrorView;
//import com.flyzebra.flyui.view.pageview.SimplePageView;
//
///**
// * Author FlyZebra
// * 2019/4/2 16:15
// * Describ:
// **/
//public class PageCellView extends FrameLayout implements ICell, IAction {
//    private CellBean mCellBean;
//    private static Handler sHander = new Handler(Looper.getMainLooper());
//    private static Runnable hideMenuTask = new Runnable() {
//        @Override
//        public void run() {
//            FlyLog.d("hide Menu Task run");
//            FlyAction.sendEvent(ActionKey.MSG_MENU_STATUS, 0);
//        }
//    };
//
//    public PageCellView(Context context) {
//        super(context);
//    }
//
//    @Override
//    public void init(CellBean cellBean) {
//
//    }
//
//    @Override
//    public void setCellBean(CellBean cellBean) {
//        this.mCellBean = cellBean;
//        if (mCellBean != null && mCellBean.cellpage != null) {
//            SimplePageView simplePageView = new SimplePageView(getContext());
//            addView(simplePageView);
//            simplePageView.setCellBean(mCellBean.cellpage);
//        }
//
//        try {
//            setBackgroundColor(Color.parseColor(mCellBean.backcolor));
//        } catch (Exception e) {
//            FlyLog.d("error! parseColor exception!" + e.toString());
//        }
//    }
//
//    @Override
//    public void onClick() {
//
//    }
//
//    @Override
//    public void bindMirrorView(MirrorView mirrorView) {
//
//    }
//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        //TODO:处理弹出菜单
//        if (mCellBean.recvAction == ActionKey.MSG_MENU_STATUS) {
//            sHander.removeCallbacks(hideMenuTask);
//            sHander.postDelayed(hideMenuTask, 5000);
//        }
//        return super.dispatchTouchEvent(ev);
//    }
//
//    @Override
//    protected void onAttachedToWindow() {
//        super.onAttachedToWindow();
//        FlyAction.register(this);
//        if (mCellBean.recvAction == ActionKey.MSG_MENU_STATUS) {
//            goAnimtor(false, 0);
//            FlyAction.sendEvent(ActionKey.MSG_MENU_STATUS, 0);
//        } else if (mCellBean.recvAction > 0) {
//            sendEvent(mCellBean.recvAction);
//        }
//    }
//
//    @Override
//    protected void onDetachedFromWindow() {
//        sHander.removeCallbacksAndMessages(null);
//        FlyAction.unregister(this);
//        super.onDetachedFromWindow();
//    }
//
//    @Override
//    public boolean sendEvent(int key) {
//        if (mCellBean == null || mCellBean.recvAction != key) return false;
//        switch (key) {
//            case ActionKey.MSG_MENU_STATUS:
//                Object obj = FlyAction.getValue(key);
//                FlyLog.d("cellid=%d,key=%d,obj=" + obj, mCellBean.cellId, key);
//                if (obj instanceof Integer) {
//                    goAnimtor((Integer) obj > 0, 300);
//                }
//                return false;
//        }
//        return false;
//    }
//
//    private void goAnimtor(final boolean isShow, long during) {
//        FlyLog.d("isShow=" + isShow);
//        if (isShow) {
//            sHander.removeCallbacks(hideMenuTask);
//            sHander.postDelayed(hideMenuTask, 5000);
//        } else {
//            sHander.removeCallbacks(hideMenuTask);
//        }
//        switch (mCellBean.gravity) {
//            case Gravity.LEFT:
//                break;
//            case Gravity.RIGHT:
//                boolean isRtl = RtlTools.isRtl();
//                animate().translationX(isShow ? 0 : (isRtl ? -(mCellBean.width - mCellBean.mLeft + mCellBean.mRight)
//                        : (mCellBean.width - mCellBean.mLeft + mCellBean.mRight))
//                ).setDuration(during).start();
//                break;
//            case Gravity.TOP:
//                break;
//            case Gravity.BOTTOM:
//                break;
//        }
//    }
//}
