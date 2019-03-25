package com.flyzebra.flyui.view.pageanimtor;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Author FlyZebra
 * 2019/3/25 17:37
 * Describ:
 **/
public class PageTransformerPage implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View view, float position) {
        int pagerWidth = view.getWidth();

        if (position >= 1 || position <= -1) {
            view.setVisibility(View.GONE);
        } else {
            view.setVisibility(View.VISIBLE);
        }

        if (position >= 0) {
            float translationX = (0 - pagerWidth) * position;
            view.setTranslationX(translationX);
            view.setScaleX(1-position);
            view.setScaleY(1-position);
        }
        if (position > -1 && position < 0) {
            view.setAlpha((position * position * position + 1));
        } else if (position > 0) {
            view.setAlpha((float) (1 - position + Math.floor(position)));
        } else {
            view.setRotation(0);
            view.setAlpha(1);
        }

//        ViewCompat.setElevation(view, (1 - position) * 5);
    }
}
