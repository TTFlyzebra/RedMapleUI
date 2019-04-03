package com.flyzebra.flyui.view.base;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.flyzebra.flyui.module.FlyClass;

/**
 * Author FlyZebra
 * 2019/3/26 9:27
 * Describ:
 **/
public class BaseView extends View{
    public BaseView(Context context) {
        super(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BaseView(Context context,  AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        FlyClass.register(getClass(),this);
    }


    @Override
    protected void onDetachedFromWindow() {
        FlyClass.unregister(getClass());
        super.onDetachedFromWindow();
    }
}
