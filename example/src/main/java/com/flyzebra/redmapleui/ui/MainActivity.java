package com.flyzebra.redmapleui.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.bean.PageBean;
import com.flyzebra.flyui.bean.TemplateBean;
import com.flyzebra.flyui.http.FlyOkHttp;
import com.flyzebra.flyui.http.IHttp;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.utils.GsonUtils;
import com.flyzebra.flyui.view.pageview.SimplePageView;
import com.flyzebra.flyui.view.viewpager.LauncherView;
import com.flyzebra.flyui.view.viewpager.NavForViewPager;
import com.flyzebra.flyui.view.viewpager.Switch3DPageTransformer;
import com.flyzebra.redmapleui.R;

import java.util.List;


public class MainActivity extends Activity implements IHttp.HttpResult {
    private LauncherView launcherView;
    private SimplePageView topView;
    private RelativeLayout pagesView;
    private NavForViewPager navForViewPager;
    private IHttp iHttp = FlyOkHttp.getInstance();
    private String HTTPTAG = "MANIACTIVITY";
    private String URL = "http://192.168.1.119:801/uiweb/api/app?appname=Launcher-AP1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launcherView = (LauncherView) findViewById(R.id.ac_main_launcherview);
        topView = (SimplePageView) findViewById(R.id.ac_main_topview);
        pagesView = (RelativeLayout) findViewById(R.id.ac_main_pages);
        launcherView.setOffscreenPageLimit(10);
        navForViewPager = (NavForViewPager) findViewById(R.id.ac_main_navforviewpager);
        iHttp.getString(URL, HTTPTAG, this);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void showUI(String jsonStr) {
        TemplateBean templateBean = GsonUtils.json2Object(jsonStr, TemplateBean.class);
        if (templateBean != null) {
            List<PageBean> pageBeans = templateBean.pageList;
            if (templateBean.x != 0 || templateBean.y != 0 || templateBean.width != 0 || templateBean.height != 0) {
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) pagesView.getLayoutParams();
                lp.setMargins(templateBean.x, templateBean.y, 0, 0);
                lp.setMarginStart(templateBean.x);
                lp.width = templateBean.width;
                lp.height = templateBean.height;
                pagesView.setLayoutParams(lp);
                for (PageBean pageBean : pageBeans) {
                    if (pageBean.cellList == null || pageBean.cellList.isEmpty()) continue;
                    for (CellBean cellBean : pageBean.cellList) {
                        cellBean.x = cellBean.x - templateBean.x;
                        cellBean.y = cellBean.y - templateBean.y;
                    }
                }
            } else {
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) pagesView.getLayoutParams();
                lp.setMargins(templateBean.x, templateBean.y, 0, 0);
                lp.setMarginStart(templateBean.x);
                lp.width = -1;
                lp.height = -1;
                pagesView.setLayoutParams(lp);
            }

            if (pageBeans != null && !pageBeans.isEmpty()) {
                switch (templateBean.animtor) {
                    case 1:
                        launcherView.setPageTransformer(true, new Switch3DPageTransformer());
                        break;
                    default:
                        launcherView.setPageTransformer(true, null);
                        break;
                }
                launcherView.setData(templateBean);
                navForViewPager.setViewPager(launcherView);
            }

            topView.removeAllViews();
            if (templateBean.topPage != null && templateBean.topPage.cellList != null && !templateBean.topPage.cellList.isEmpty()) {
                topView.setData(templateBean.topPage);
            }

            //设置壁纸
            if (!TextUtils.isEmpty(templateBean.imageurl))
                setBackGround(templateBean.imageurl);
        }
    }

    private void setBackGround(String bkimg) {
        Glide.with(this).load(bkimg).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                getWindow().getDecorView().setBackground(glideDrawable);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iHttp.cancelAll(HTTPTAG);
    }

    @Override
    public void succeed(Object object) {
        FlyLog.d(""+object);
        if (object != null) {
            showUI((String) object);
        }
    }

    @Override
    public void failed(Object object) {

    }
}
