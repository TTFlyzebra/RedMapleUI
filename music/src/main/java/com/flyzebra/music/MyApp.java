package com.flyzebra.music;

import android.app.Application;

import com.jancar.media.model.mediascan.MediaScan;
import com.jancar.media.model.musicplayer.MusicPlayer;
import com.squareup.leakcanary.LeakCanary;

/**
 * Author FlyZebra
 * 2019/4/4 11:37
 * Describ:
 **/
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        MediaScan.getInstance().init(getApplicationContext());
        MusicPlayer.getInstance().init(getApplicationContext());
    }
}
