package com.flyzebra.music;

import android.app.Application;
import android.view.ViewConfiguration;

import com.flyzebra.flyui.utils.FlyLog;
import com.jancar.media.model.mediascan.MediaScan;
import com.jancar.media.model.musicplayer.MusicPlayer;
import com.jancar.media.model.storage.Storage;

import java.lang.reflect.Field;

/**
 * Author FlyZebra
 * 2019/4/4 11:37
 * Describ:
 **/
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        LeakCanary.install(this);
        MediaScan.getInstance().init(getApplicationContext());
        MusicPlayer.getInstance().init(getApplicationContext());
        Storage.getInstance().init(getApplicationContext());


        /**
         * 设置Marquee不显示省略号
         */
        try {
            ViewConfiguration configuration = ViewConfiguration.get(getApplicationContext());
            Class claz = configuration.getClass();
            Field field = claz.getDeclaredField("mFadingMarqueeEnabled");
            field.setAccessible(true);
            field.set(configuration, true);
        } catch (Exception e) {
            FlyLog.e(e.toString());
        }
    }
}
