package com.flyzebra.flyui.view.cellview;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
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
            FlyLog.e("error! parseColor exception!" + e.toString());
        }
    }

    @Override
    public void upView() {

    }

    @Override
    public void doEvent() {

    }

    @Override
    public void bindMirrorView(MirrorView mirrorView) {

    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        FlyAction.register(this);
        if(mCellBean.recvAction==ActionKey.STATUS_MENU){
            setVisibility(INVISIBLE);
            FlyAction.notifyAction(ActionKey.STATUS_MENU,false);
        }else if (mCellBean.recvAction > 0) {
            onAction(mCellBean.recvAction);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        FlyAction.unregister(this);
        super.onDetachedFromWindow();
    }

    @Override
    public boolean onAction(int key) {
        Object obj = FlyAction.getValue(key);
        switch (key) {
            case ActionKey.STATUS_MENU:
                FlyLog.d("key=%d,obj=" + obj, key);
                if (obj instanceof Boolean) {
                    goAnimtor((Boolean) obj);
                }
                return false;
        }
        return false;
    }

    private void goAnimtor(final boolean flag) {
        if(flag){
            setVisibility(VISIBLE);
        }
        switch (mCellBean.gravity) {
            case Gravity.LEFT:
                break;
            case Gravity.RIGHT:
                boolean isRtl = RtlTools.isRtl();
                animate().translationX(flag? 0: (isRtl ? -(mCellBean.width - 1) :(mCellBean.width - 1))
                ).setDuration(300).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        setVisibility(flag ? VISIBLE : INVISIBLE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();
                break;
            case Gravity.TOP:
                break;
            case Gravity.BOTTOM:
                break;
        }
    }
}
