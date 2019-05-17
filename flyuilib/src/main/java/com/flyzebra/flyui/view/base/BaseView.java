package com.flyzebra.flyui.view.base;

import android.content.Context;
import android.view.View;

import com.flyzebra.flyui.event.FlyAction;
import com.flyzebra.flyui.event.IAction;
import com.flyzebra.flyui.utils.FlyLog;

/**
 * Author FlyZebra
 * 2019/5/17 15:15
 * Describ:
 **/
public abstract class BaseView extends View implements IAction {
    public BaseView(Context context) {
        super(context);
    }

    @Override
    protected void onAttachedToWindow() {
        FlyLog.d("onAttachedToWindow");
        super.onAttachedToWindow();
        FlyAction.register(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        FlyLog.d("onDetachedFromWindow");
        FlyAction.unregister(this);
        super.onDetachedFromWindow();
    }

    @Override
    public boolean handleAction(byte[] key) {
        return false;
    }

}
