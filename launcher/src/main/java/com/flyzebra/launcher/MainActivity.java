package com.flyzebra.launcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.flyzebra.flyui.bean.ThemeBean;
import com.flyzebra.flyui.utils.AppUtil;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.launcher.network.ApiAction;
import com.flyzebra.launcher.network.ApiActionlmpl;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Author FlyZebra
 * 2019/5/27 16:04
 * Describ:
 **/
public class MainActivity extends Activity implements Adapater.OnItemClickListener {
    private RecyclerView recyclerView;
    private Adapater adapater;
    private List<ThemeBean> list = new ArrayList<>();
    private ApiAction apiAction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        FlyLog.d("onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiAction = new ApiActionlmpl();

        recyclerView = findViewById(R.id.ac_main_rv01);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapater = new Adapater(this, list);
        recyclerView.setAdapter(adapater);

        adapater.setOnItemClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        apiAction.doTheme(AppUtil.getApplicationName(this),new Subscriber<List<ThemeBean>>() {
            @Override
            public void onCompleted() {
                FlyLog.d("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                FlyLog.d(e.toString());
            }

            @Override
            public void onNext(List<ThemeBean> themeBeans) {
                FlyLog.d("themeBeans=" + themeBeans);
                list.clear();
                list.addAll(themeBeans);
                adapater.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onDestroy() {
        FlyLog.d("onDestroy");
        super.onDestroy();
    }

    @Override
    public void onItemClick(View view, int pos) {
        try {
            Intent intent = new Intent(this, FlyuiActivity.class);
            intent.putExtra("THEME_NAME", list.get(pos).themeName);
            startActivity(intent);
        } catch (Exception e) {
            FlyLog.e(e.toString());
        }
    }
}
