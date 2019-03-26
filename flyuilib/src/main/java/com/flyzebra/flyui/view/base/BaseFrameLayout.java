package com.flyzebra.flyui.view.base;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.flyzebra.flyui.module.FlyFindClass;

/**
 * Author FlyZebra
 * 2019/3/26 9:30
 * Describ:
 **/
public class BaseFrameLayout extends FrameLayout {
    public BaseFrameLayout( Context context) {
        super(context);
    }

    public BaseFrameLayout( Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseFrameLayout( Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BaseFrameLayout( Context context,  AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        FlyFindClass.register(getClass(),this);
    }


    @Override
    protected void onDetachedFromWindow() {
        FlyFindClass.unregister(getClass());
        super.onDetachedFromWindow();
    }
}
