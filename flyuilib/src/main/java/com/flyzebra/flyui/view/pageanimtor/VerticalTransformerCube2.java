package com.flyzebra.flyui.view.pageanimtor;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.flyzebra.flyui.utils.FlyLog;

/**
 * Author FlyZebra
 * 2019/6/11 17:00
 * Describ:
 **/
public class VerticalTransformerCube2 implements ViewPager.PageTransformer {
    @Override
    public void transformPage(@NonNull View view, float position) {
        FlyLog.d("%d:position="+position,view.getTag());

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);

        } else if (position <= 1) { // [-1,1]
            view.setAlpha(1);

            // Counteract the default slide transition
            view.setTranslationX(view.getWidth() * -position);

            //set Y position to swipe in from top
            float yPosition = position * view.getHeight();
            view.setTranslationY(yPosition);

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);
        }

        float rotation = -45f * position;
        if (position >= 0) {
            view.setPivotY(0);
        } else {
            view.setPivotY(view.getHeight());
        }
        view.setPivotX(view.getWidth() * 0.5f);
        view.setRotationX(rotation);
        if (position > -1.0f && position < 1.0f) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setTranslationY(0);
            view.setRotation(0);
            view.setVisibility(View.INVISIBLE);
        }

    }
}
