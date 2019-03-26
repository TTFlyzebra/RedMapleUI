package com.flyzebra.flyui.view.base;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.flyzebra.flyui.module.FlyFindClass;

/**
 * Author FlyZebra
 * 2019/3/26 9:27
 * Describ:
 **/
public class BaseView extends View{
    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BaseView(Context context,  AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
