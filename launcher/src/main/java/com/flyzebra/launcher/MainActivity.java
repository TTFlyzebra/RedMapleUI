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
import com.flyzebra.flyui.utils.GsonUtil;
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

    private String json = "[{\"themeId\":5,\"themeName\":\"Launcher-AP1\",\"themeType\":0,\"screenWidth\":1024,\"screenHeight\":600,\"left\":0,\"top\":0,\"right\":1024,\"bottom\":600,\"imageurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/5d\\/2f2c0d98a61327de56237b6f6da25c.png\",\"exampleurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/82\\/d522d13cc3cc511587dbeafb9c9d3e.png\",\"backcolor\":\"\",\"isMirror\":1,\"animType\":1,\"status\":1,\"remark\":\"\",\"edittime\":\"2019-06-17 10:41:25\",\"userid\":6,\"ip\":\"192.168.1.119\"},{\"themeId\":6,\"themeName\":\"Launcher-AP2\",\"themeType\":0,\"screenWidth\":1024,\"screenHeight\":600,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"imageurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/5d\\/2f2c0d98a61327de56237b6f6da25c.png\",\"exampleurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/ae\\/821f0e4be5205eaac49ffbbdc9de59.png\",\"backcolor\":\"\",\"isMirror\":0,\"animType\":0,\"status\":1,\"remark\":\"\",\"edittime\":\"2019-06-11 17:54:25\",\"userid\":6,\"ip\":\"192.168.1.119\"},{\"themeId\":7,\"themeName\":\"Launcher-AP3\",\"themeType\":0,\"screenWidth\":1024,\"screenHeight\":600,\"left\":0,\"top\":0,\"right\":1024,\"bottom\":600,\"imageurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/f8\\/fc65ab56c952ebccd91be18b9a2d06.png\",\"exampleurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/65\\/580a5dc97c7ef0e6593fdc93d6f484.png\",\"backcolor\":\"\",\"isMirror\":1,\"animType\":1,\"status\":1,\"remark\":\"\",\"edittime\":\"2019-06-17 10:41:31\",\"userid\":6,\"ip\":\"192.168.1.119\"},{\"themeId\":12,\"themeName\":\"Launcher-AP4\",\"themeType\":0,\"screenWidth\":1024,\"screenHeight\":600,\"left\":0,\"top\":0,\"right\":1024,\"bottom\":600,\"imageurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/cf\\/a58b71a904c624fea7c85c670eba4a.png\",\"exampleurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/c9\\/dcb1202c2b78ffd528100492520875.png\",\"backcolor\":\"\",\"isMirror\":0,\"animType\":0,\"status\":1,\"remark\":\"\",\"edittime\":\"2019-05-27 16:00:19\",\"userid\":6,\"ip\":\"192.168.1.119\"},{\"themeId\":13,\"themeName\":\"Launcher-AP5\",\"themeType\":0,\"screenWidth\":1024,\"screenHeight\":600,\"left\":296,\"top\":0,\"right\":1024,\"bottom\":600,\"imageurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/2f\\/e2f98c6ff84f553cc7c7079b721ad1.png\",\"exampleurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/dd\\/b5de46782680c61408d1f636a6071b.png\",\"backcolor\":\"\",\"isMirror\":0,\"animType\":2,\"status\":1,\"remark\":\"\",\"edittime\":\"2019-05-27 16:00:33\",\"userid\":6,\"ip\":\"192.168.1.119\"},{\"themeId\":14,\"themeName\":\"Launcher-AP6\",\"themeType\":0,\"screenWidth\":1024,\"screenHeight\":600,\"left\":0,\"top\":0,\"right\":1024,\"bottom\":600,\"imageurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/d3\\/b3bb3a1a9a2ae08b6585c8512d769b.png\",\"exampleurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/3b\\/5179a874a1801a6ce396748b34dada.png\",\"backcolor\":\"\",\"isMirror\":0,\"animType\":0,\"status\":1,\"remark\":\"\",\"edittime\":\"2019-05-27 16:00:51\",\"userid\":6,\"ip\":\"192.168.1.119\"},{\"themeId\":18,\"themeName\":\"Launcher-AP7\",\"themeType\":0,\"screenWidth\":1024,\"screenHeight\":600,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"imageurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/42\\/e1f50a04f3daaa87b24d9883631db4.png\",\"exampleurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/56\\/074b95be1f77e433c4ba41203a21fc.png\",\"backcolor\":\"\",\"isMirror\":0,\"animType\":1,\"status\":1,\"remark\":\"\",\"edittime\":\"2019-05-27 16:01:06\",\"userid\":6,\"ip\":\"192.168.1.119\"},{\"themeId\":19,\"themeName\":\"Launcher-AP8\",\"themeType\":0,\"screenWidth\":1024,\"screenHeight\":600,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"imageurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/b5\\/59862e979e64f7f54db8d27ad7ea81.png\",\"exampleurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/57\\/8e8c6520a478538e222bc128117a1b.png\",\"backcolor\":\"\",\"isMirror\":0,\"animType\":0,\"status\":1,\"remark\":\"\",\"edittime\":\"2019-05-27 16:01:18\",\"userid\":6,\"ip\":\"192.168.1.119\"},{\"themeId\":20,\"themeName\":\"Launcher-AP9\",\"themeType\":0,\"screenWidth\":1024,\"screenHeight\":600,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"imageurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/5d\\/2f2c0d98a61327de56237b6f6da25c.png\",\"exampleurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/c4\\/2d9a6784290bc820e72ae90ce7865d.png\",\"backcolor\":\"\",\"isMirror\":0,\"animType\":1,\"status\":1,\"remark\":\"\",\"edittime\":\"2019-06-17 10:39:22\",\"userid\":6,\"ip\":\"192.168.1.119\"},{\"themeId\":26,\"themeName\":\"Launcher-APA\",\"themeType\":0,\"screenWidth\":800,\"screenHeight\":480,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"imageurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/d5\\/3f2745a83a7f4ea7278568652b21d7.png\",\"exampleurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/d8\\/c1c2437852ea84238fe05bbd28c287.png\",\"backcolor\":\"\",\"isMirror\":0,\"animType\":3,\"status\":1,\"remark\":\"\",\"edittime\":\"2019-06-17 10:40:26\",\"userid\":6,\"ip\":\"192.168.1.119\"}]";

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

        apiAction.doTheme(AppUtil.getApplicationName(this),new Subscriber<List<ThemeBean>>() {
            @Override
            public void onCompleted() {
                FlyLog.d("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                FlyLog.d(e.toString());
                List<ThemeBean> themeBeans = GsonUtil.json2ListObject(json,ThemeBean.class);
                list.clear();
                list.addAll(themeBeans);
                adapater.notifyDataSetChanged();
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
    protected void onStart() {
        super.onStart();
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
