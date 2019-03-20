package com.flyzebra.redmapleui.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.bean.PageBean;
import com.flyzebra.flyui.bean.ThemeBean;
import com.flyzebra.flyui.http.FlyOkHttp;
import com.flyzebra.flyui.http.IHttp;
import com.flyzebra.flyui.module.Switch3DPageTransformer;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.utils.GsonUtils;
import com.flyzebra.flyui.view.customview.NavForViewPager;
import com.flyzebra.flyui.view.pageview.SimplePageView;
import com.flyzebra.flyui.view.themeview.ViewPagerTheme;
import com.flyzebra.redmapleui.R;

import java.util.List;


public class MainActivity extends Activity implements IHttp.HttpResult {
    private ViewPagerTheme launcherView;
    private SimplePageView topView;
    private RelativeLayout pagesView;
    private NavForViewPager navForViewPager;
    private IHttp iHttp = FlyOkHttp.getInstance();
    private String HTTPTAG = "MainActivity" + hashCode();
    private String URL = "http://192.168.1.119:801/uiweb/api/app?appname=Launcher-AP1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launcherView = (ViewPagerTheme) findViewById(R.id.ac_main_launcherview);
        topView = (SimplePageView) findViewById(R.id.ac_main_topview);
        pagesView = (RelativeLayout) findViewById(R.id.ac_main_pages);
        launcherView.setOffscreenPageLimit(10);
        navForViewPager = (NavForViewPager) findViewById(R.id.ac_main_navforviewpager);
        iHttp.getString(URL, HTTPTAG, this);

    }

    private void showUI(String jsonStr) {
        ThemeBean themeBean = GsonUtils.json2Object(jsonStr, ThemeBean.class);
        if (themeBean != null) {
//            themeBean.x = themeBean.x*1280/1024;
//            themeBean.y = themeBean.y*1280/1024;
//            themeBean.width = themeBean.width*1280/1024;
//            themeBean.height = themeBean.height*1280/1024;
            List<PageBean> pageBeans = themeBean.pageList;
            if (themeBean.x != 0 || themeBean.y != 0 || themeBean.width != 0 || themeBean.height != 0) {
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) pagesView.getLayoutParams();
                lp.setMargins(themeBean.x, themeBean.y, 0, 0);
                lp.setMarginStart(themeBean.x);
                lp.width = themeBean.width;
                lp.height = themeBean.height;
                pagesView.setLayoutParams(lp);
                for (PageBean pageBean : pageBeans) {
                    if (pageBean.cellList == null || pageBean.cellList.isEmpty()) continue;
                    for (CellBean cellBean : pageBean.cellList) {
                        cellBean.x = cellBean.x - themeBean.x;
                        cellBean.y = cellBean.y - themeBean.y;
                    }
                }
            } else {
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) pagesView.getLayoutParams();
                lp.setMargins(themeBean.x, themeBean.y, 0, 0);
                lp.setMarginStart(themeBean.x);
                lp.width = -1;
                lp.height = -1;
                pagesView.setLayoutParams(lp);
            }

            if (pageBeans != null && !pageBeans.isEmpty()) {
                switch (themeBean.animType) {
                    case 1:
                        launcherView.setPageTransformer(true, new Switch3DPageTransformer());
                        break;
                    default:
                        launcherView.setPageTransformer(true, null);
                        break;
                }
                launcherView.setData(themeBean);
                navForViewPager.setViewPager(launcherView);
            }

            topView.removeAllViews();
            if (themeBean.topPage != null && themeBean.topPage.cellList != null && !themeBean.topPage.cellList.isEmpty()) {
                topView.setData(themeBean.topPage);
            }

            //设置壁纸
            if (!TextUtils.isEmpty(themeBean.imageurl)) {
                Glide.with(this).load(themeBean.imageurl).override(themeBean.width, themeBean.height).into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        getWindow().getDecorView().setBackground(glideDrawable);
                    }
                });
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iHttp.cancelAll(HTTPTAG);
    }

    @Override
    public void succeed(Object object) {
        if (object != null) {
            showUI((String) object);
        }
    }

    @Override
    public void failed(Object object) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        FlyLog.d(event.toString());
        return super.onTouchEvent(event);
    }
}
