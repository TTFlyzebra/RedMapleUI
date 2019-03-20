package com.flyzebra.flyui.view.themeview;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;

import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.bean.PageBean;
import com.flyzebra.flyui.bean.ThemeBean;
import com.flyzebra.flyui.module.Switch3DPageTransformer;
import com.flyzebra.flyui.view.customview.NavForViewPager;
import com.flyzebra.flyui.view.pageview.SimplePageView;

/**
 * Author FlyZebra
 * 2019/3/20 14:26
 * Describ:
 **/
public class ThemeView extends FrameLayout implements ITheme {
    private Context mContext;
    private ThemeBean mThemeBean;
    private float screenWidth = 1024;
    private float screenHeigh = 600;
    private float screenScacle = 1.0f;
    private ViewPagerTheme iTheme;
    private NavForViewPager navView;
    private SimplePageView topView;

    public ThemeView(Context context) {
        super(context);
        init(context);
    }

    public ThemeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ThemeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ThemeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }


    private void init(Context context) {
        mContext = context;
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenWidth = dm.widthPixels;
        screenHeigh = dm.heightPixels;
    }

    @Override
    public void setData(ThemeBean themeBean) {
        if (themeBean == null || themeBean.pageList == null || themeBean.pageList.isEmpty()) {
            return;
        }
        mThemeBean = themeBean;

        /**
         * 适应多分辨率
         */
        float wScale = screenWidth / (float) mThemeBean.width;
        float hScale = screenHeigh / (float) mThemeBean.height;
        screenScacle = Math.min(wScale, hScale);
        int moveX = (int) ((screenWidth / screenScacle - mThemeBean.width) / 2);
        int moveY = (int) ((screenHeigh / screenScacle - mThemeBean.height) / 2);
        for (PageBean pageBean : mThemeBean.pageList) {
            for (CellBean cellBean : pageBean.cellList) {
                cellBean.x = (int) (cellBean.x * screenScacle) + moveX;
                cellBean.y = (int) (cellBean.y * screenScacle) + moveY;
                cellBean.width = (int) (cellBean.width * screenScacle);
                cellBean.height = (int) (cellBean.height * screenScacle);
            }
        }

        iTheme = new ViewPagerTheme(mContext);
        addView((View) iTheme);
        switch (themeBean.animType) {
            case 1:
                iTheme.setPageTransformer(true, new Switch3DPageTransformer());
                break;
            default:
                iTheme.setPageTransformer(true, null);
                break;
        }

        iTheme.setData(mThemeBean);
        navView = new NavForViewPager(mContext);
        addView(navView);
        navView.setViewPager((ViewPager) iTheme);


    }

    @Override
    public void selectPage(int page) {
        if (iTheme != null) {
            iTheme.selectPage(page);
        }
    }

    @Override
    public void selectCell(CellBean cell) {
        if (iTheme != null) {
            iTheme.selectCell(cell);
        }
    }
}
