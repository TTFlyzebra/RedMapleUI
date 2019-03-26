package com.flyzebra.redmapleui;

import android.app.Activity;
import android.os.Bundle;

import com.flyzebra.flyui.FlyuiAction;
import com.flyzebra.flyui.bean.Action;
import com.flyzebra.flyui.bean.ThemeBean;
import com.flyzebra.flyui.module.FlyAction;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.themeview.ThemeView;
import com.flyzebra.redmapleui.network.ApiAction;
import com.flyzebra.redmapleui.network.ApiActionlmpl;

import rx.Subscriber;

/**
 * Author FlyZebra
 * 2019/3/20 10:55
 * Describ:
 **/
public class FlyuiActivity extends Activity implements FlyuiAction {

    private ThemeView mThemeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FlyLog.d();
        super.onCreate(savedInstanceState);
        mThemeView = new ThemeView(this);
        setContentView(mThemeView);
        mThemeView.onCreate(this);

        ApiAction apiActionlmpl = new ApiActionlmpl();

        apiActionlmpl.doTheme("Launcher-AP1", new Subscriber<ThemeBean>() {
            @Override
            public void onCompleted() {
                FlyLog.d();
            }

            @Override
            public void onError(Throwable e) {
                FlyLog.d(e.toString());
            }

            @Override
            public void onNext(ThemeBean themeBean) {
                FlyLog.v("ThemeBean=%s", themeBean);
                mThemeView.upData(themeBean);
            }
        });
    }

    @Override
    protected void onStart() {
        FlyAction.notifyAction(new Action());
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        FlyLog.d();
        mThemeView.onDestory();
        super.onDestroy();
    }

    @Override
    public void onAction(Action action) {
        switch (action.key) {
            default:
                break;
        }
    }
}
