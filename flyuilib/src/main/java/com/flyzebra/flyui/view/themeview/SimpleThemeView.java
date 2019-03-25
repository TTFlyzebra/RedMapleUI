package com.flyzebra.flyui.view.themeview;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;

import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.bean.PageBean;
import com.flyzebra.flyui.bean.ThemeBean;
import com.flyzebra.flyui.module.PageTransformerCube;

/**
 * Author FlyZebra
 * 2019/3/20 14:26
 * Describ:
 **/
public class SimpleThemeView extends FrameLayout implements ITheme {
    private Context mContext;
    private ThemeBean mThemeBean;
    private float screenWidth = 1024;
    private float screenHeigh = 600;
    private float screenScacle = 1.0f;
    private PagesViewPager pagesView;
    private NavForPages navView;

    public SimpleThemeView(Context context) {
        super(context);
        init(context);
    }

    public SimpleThemeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SimpleThemeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SimpleThemeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
    public void upData(ThemeBean themeBean) {
        if (themeBean == null || themeBean.pageList == null || themeBean.pageList.isEmpty()) {
            return;
        }
        mThemeBean = themeBean;

        /**
         * 适应多分辨率
         */
        float wScale = screenWidth / (float) mThemeBean.screenWidth;
        float hScale = screenHeigh / (float) mThemeBean.screenHeight;
        screenScacle = Math.min(wScale, hScale);
        int moveX = (int) ((screenWidth / screenScacle - mThemeBean.screenWidth) / 2);
        int moveY = (int) ((screenHeigh / screenScacle - mThemeBean.screenHeight) / 2);
        for (PageBean pageBean : mThemeBean.pageList) {
            for (CellBean cellBean : pageBean.cellList) {
                cellBean.x = (int) (cellBean.x * screenScacle) + moveX;
                cellBean.y = (int) (cellBean.y * screenScacle) + moveY;
                cellBean.width = (int) (cellBean.width * screenScacle);
                cellBean.height = (int) (cellBean.height * screenScacle);
            }
        }
        pagesView = new PagesViewPager(mContext);
        addView(pagesView);
        switch (themeBean.animType) {
            case 1:
                pagesView.setPageTransformer(true, new PageTransformerCube());
                break;
            default:
                pagesView.setPageTransformer(true, null);
                break;
        }
        pagesView.setOffscreenPageLimit(10);
        pagesView.upData(mThemeBean);
    }

    @Override
    public void selectPage(int page) {
        if (pagesView != null) {
            pagesView.selectPage(page);
        }
    }

    @Override
    public void selectCell(CellBean cell) {
        if (pagesView != null) {
            pagesView.selectCell(cell);
        }
    }
}
