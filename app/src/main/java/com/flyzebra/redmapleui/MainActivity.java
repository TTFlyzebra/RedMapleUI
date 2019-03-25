package com.flyzebra.redmapleui;

import android.app.Activity;
import android.os.Bundle;

import com.flyzebra.flyui.bean.ThemeBean;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.themeview.SimpleThemeView;
import com.flyzebra.redmapleui.network.ApiAction;
import com.flyzebra.redmapleui.network.ApiActionlmpl;

import rx.Subscriber;

/**
 * Author FlyZebra
 * 2019/3/20 10:55
 * Describ:
 **/
public class MainActivity extends Activity {

    private SimpleThemeView mThemeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mThemeView = new SimpleThemeView(this);
        setContentView(mThemeView);

        ApiAction apiActionlmpl = new ApiActionlmpl();

        apiActionlmpl.doTheme("Music-AP1", new Subscriber<ThemeBean>() {
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
                FlyLog.d("ThemeBean=%s", themeBean);
                mThemeView.upData(themeBean);
            }
        });
    }
}
