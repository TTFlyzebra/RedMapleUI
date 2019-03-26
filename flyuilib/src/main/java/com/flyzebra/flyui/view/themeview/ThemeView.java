package com.flyzebra.flyui.view.themeview;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;

import com.flyzebra.flyui.FlyuiAction;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.bean.PageBean;
import com.flyzebra.flyui.bean.ThemeBean;
import com.flyzebra.flyui.module.FlyAction;
import com.flyzebra.flyui.module.FlyClass;
import com.flyzebra.flyui.view.pageanimtor.PageTransformerCube;
import com.flyzebra.flyui.view.pageanimtor.PageTransformerPage;
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
    private PagesViewPager pagesView;
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

    /**
     * 匹配屏幕分辨率
     */
    private void matchResolution() {
        //如果设置的分辨率无效，设置为系统获取的分辨率和有效区域。
        if (mThemeBean.screenWidth <= 0 || mThemeBean.screenHeight <= 0) {
            mThemeBean.screenWidth = (int) screenWidth;
            mThemeBean.screenHeight = (int) screenHeigh;
            mThemeBean.left = 0;
            mThemeBean.top = 0;
            mThemeBean.right = (int) screenWidth;
            mThemeBean.bottom = (int) screenHeigh;
            return;
        }
        if (mThemeBean.right <= mThemeBean.left || mThemeBean.bottom <= mThemeBean.top) {
            mThemeBean.left = 0;
            mThemeBean.top = 0;
            mThemeBean.right = (int) screenWidth;
            mThemeBean.bottom = (int) screenHeigh;
        }

        //如果设置的有效区域无效，设置有效区域为全屏
        float wScale = screenWidth / (float) mThemeBean.screenWidth;
        float hScale = screenHeigh / (float) mThemeBean.screenHeight;
        if (wScale == 1 && hScale == 1) {
            if (mThemeBean.left != 0 || mThemeBean.top != 0) {
                for (PageBean pageBean : mThemeBean.pageList) {
                    for (CellBean cellBean : pageBean.cellList) {
                        //有效显示区域FitCenter，只显示位于指定区域中的内容
                        cellBean.x = cellBean.x - mThemeBean.left;
                        cellBean.y = cellBean.y - mThemeBean.top;
                    }
                }
            }
            return;
        }

        screenScacle = Math.min(wScale, hScale);
        int moveX = (int) ((screenWidth / screenScacle - mThemeBean.screenWidth) / 2);
        int moveY = (int) ((screenHeigh / screenScacle - mThemeBean.screenHeight) / 2);

        mThemeBean.left = (int) (mThemeBean.left * screenScacle) + moveX;
        mThemeBean.top = (int) (mThemeBean.top * screenScacle) + moveY;
        mThemeBean.right = (int) (mThemeBean.right * screenScacle) + moveX;
        mThemeBean.bottom = (int) (mThemeBean.bottom * screenScacle) + moveY;

        if (mThemeBean.pageList != null) {
            for (PageBean pageBean : mThemeBean.pageList) {
                for (CellBean cellBean : pageBean.cellList) {
                    //有效显示区域FitCenter，只显示位于指定区域中的内容
                    cellBean.x = (int) (cellBean.x * screenScacle) + moveX - mThemeBean.left;
                    cellBean.y = (int) (cellBean.y * screenScacle) + moveY - mThemeBean.top;
                    cellBean.width = (int) (cellBean.width * screenScacle);
                    cellBean.height = (int) (cellBean.height * screenScacle);
                }
            }
            if (mThemeBean.topPage != null && mThemeBean.topPage.cellList != null) {
                for (CellBean cellBean : mThemeBean.topPage.cellList) {
                    cellBean.x = (int) (cellBean.x * screenScacle) + moveX;
                    cellBean.y = (int) (cellBean.y * screenScacle) + moveY;
                    cellBean.width = (int) (cellBean.width * screenScacle);
                    cellBean.height = (int) (cellBean.height * screenScacle);
                }
            }
        }
    }

    private void upView() {
        if (mThemeBean.pageList != null && !mThemeBean.pageList.isEmpty()) {
            switch (mThemeBean.themeType) {
                default:
                    pagesView = new PagesViewPager(mContext);

            }
            LayoutParams lp = new LayoutParams(mThemeBean.right - mThemeBean.left, mThemeBean.bottom - mThemeBean.top);
            lp.leftMargin = mThemeBean.left;
            lp.topMargin = mThemeBean.top;
            addView(pagesView, lp);
            switch (mThemeBean.animType) {
                case 1:
                    pagesView.setPageTransformer(true, new PageTransformerCube());
                    break;
                case 2:
                    pagesView.setPageTransformer(true, new PageTransformerPage());
                    break;
                default:
                    pagesView.setPageTransformer(true, null);
                    break;
            }
            pagesView.setOffscreenPageLimit(10);
            pagesView.upData(mThemeBean);
        }

        if (mThemeBean.topPage != null && mThemeBean.topPage.cellList != null && !mThemeBean.topPage.cellList.isEmpty()) {
            topView = new SimplePageView(mContext);
            addView(topView);
            topView.upData(mThemeBean.topPage);
        }


    }

    private void bindViewEvent() {
    }


    @Override
    public void onCreate(Context context) {
        if(context instanceof FlyuiAction){
            FlyAction.register((FlyuiAction) context);
        }
    }

    @Override
    public void onDestory() {
        if(mContext instanceof FlyuiAction){
            FlyAction.unregister((FlyuiAction) mContext);
        }
        FlyClass.clear();
    }


    @Override
    public void upData(ThemeBean themeBean) {
        FlyClass.clear();
        mThemeBean = themeBean;
        matchResolution();
        upView();
        bindViewEvent();
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
