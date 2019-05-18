package com.flyzebra.flyui.view.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.event.FlyEvent;
import com.flyzebra.flyui.event.IFlyEvent;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.cellview.ICell;

/**
 * Author FlyZebra
 * 2019/5/17 15:15
 * Describ:
 **/
public abstract class BaseView extends View implements IFlyEvent, ICell {
    protected CellBean mCellBean;

    public BaseView(Context context) {
        super(context);
    }

    @Override
    protected void onAttachedToWindow() {
        FlyLog.v("onAttachedToWindow");
        super.onAttachedToWindow();
        FlyEvent.register(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        FlyLog.v("onDetachedFromWindow");
        FlyEvent.unregister(this);
        super.onDetachedFromWindow();
    }

    @Override
    public final void setCellBean(CellBean cellBean) {
        FlyLog.d("setCellBean");
        this.mCellBean = cellBean;
        if (verify(mCellBean)) {
            initView(getContext());
            loadingRes(mCellBean);
        }
    }

    @Override
    public boolean verify(CellBean cellBean) {
        return false;
    }

    @Override
    public void initView(Context context) {

    }

    @Override
    public void loadingRes(CellBean cellBean) {

    }

    @Override
    public void refreshView(CellBean cellBean) {

    }

    @Override
    public void onClick() {

    }

    @Override
    public void bindMirrorView(ViewGroup viewGroup, ViewGroup.LayoutParams lpMirror) {

    }

    @Override
    public boolean recvEvent(byte[] key) {
        return false;
    }
}
