package com.flyzebra.flyui.view.base;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import com.flyzebra.flyui.module.FlyFindClass;

/**
 * Author FlyZebra
 * 2019/3/26 9:30
 * Describ:
 **/
public class BaseViewPager extends ViewPager {
    public BaseViewPager( Context context) {
        super(context);
    }

    public BaseViewPager( Context context,  AttributeSet attrs) {
        super(context, attrs);
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
