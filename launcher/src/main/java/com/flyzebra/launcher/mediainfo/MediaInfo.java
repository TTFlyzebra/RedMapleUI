package com.flyzebra.launcher.mediainfo;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

import com.flyzebra.flyui.event.FlyEvent;
import com.flyzebra.flyui.utils.ByteUtil;
import com.flyzebra.flyui.utils.FlyLog;
import com.jancar.media.JacMediaController;
import com.jancar.source.Page;

/**
 * Author FlyZebra
 * 2019/5/20 13:27
 * Describ:
 **/
public class MediaInfo {
    private JacMediaController mMediaController;
    private Context mContext;

    public MediaInfo(Context context) {
        this.mContext = context;
    }

    public void onCreate() {
        mMediaController = new JacMediaController(mContext.getApplicationContext()) {
            @Override
            public void onSession(String page) {
                FlyLog.d("onSession page=%s", page);
                if (!TextUtils.isEmpty(page)) {
                    switch (page) {
                        case Page.PAGE_FM:
                            FlyEvent.sendEvent("100201", new byte[]{0x02});
                            break;
                        case Page.PAGE_MUSIC:
                            FlyEvent.sendEvent("100201", new byte[]{0x03});
                            break;
                        case Page.PAGE_A2DP:
                            FlyEvent.sendEvent("100201", new byte[]{0x04});
                            break;
                        default:
                            FlyEvent.sendEvent("100201", new byte[]{0x01});
                            break;
                    }
                }
            }

            @Override
            public void onPlayUri(String url) {
                FlyLog.d("onPlayUri url="+url);
                FlyEvent.sendEvent("100221", url);
            }

            @Override
            public void onPlayId(int currentId, int total) {
                byte[] bt1 = ByteUtil.intToBytes(currentId);
                byte[] bt2 = ByteUtil.intToBytes(total);
                byte[] bt3 = new byte[bt1.length + bt2.length];
                System.arraycopy(bt1, 0, bt3, 0, bt1.length);
                System.arraycopy(bt2, 0, bt3, bt1.length, bt2.length);
                FlyEvent.sendEvent("100228", bt3);
            }

            @Override
            public void onPlayState(int state) {
                FlyEvent.sendEvent("100225", new byte[]{(byte) state});
            }

            @Override
            public void onProgress(long current, long duration) {
                byte[] bt1 = ByteUtil.intToBytes((int) (current / 1000));
                byte[] bt2 = ByteUtil.intToBytes((int) (duration / 1000));
                byte[] bt3 = new byte[bt1.length + bt2.length];
                System.arraycopy(bt1, 0, bt3, 0, bt1.length);
                System.arraycopy(bt2, 0, bt3, bt1.length, bt2.length);
                FlyEvent.sendEvent("100226", bt3);
            }

            @Override
            public void onRepeat(int repeat) {
                FlyLog.d("onRepeat repeat=%d", repeat);
            }

            @Override
            public void onFavor(boolean bFavor) {
                FlyLog.d("onFavor bFavor=" + bFavor);
            }

            @Override
            public void onID3(String title, String artist, String album, byte[] artWork) {
                FlyEvent.sendEvent("100222", title);
                FlyEvent.sendEvent("100223", artist);
                FlyEvent.sendEvent("100224", album);
                FlyEvent.sendEvent("100227", artWork);
            }

            @Override
            public void onMediaEvent(String action, Bundle extras) {
                FlyLog.d("onMediaEvent action=%s,extras=" + extras, action);
                try {
                    int fmType = extras.getInt("Band");
                    FlyEvent.sendEvent("100211", new byte[]{(byte) fmType});
                    String fmName = extras.getString("name");
                    FlyEvent.sendEvent("100212", fmName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        mMediaController.Connect();
    }

    public void onDestory() {
        mMediaController.release();
    }

    public void playNext() {
        try {
            mMediaController.requestNext();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playPrev() {
        try {
            mMediaController.requestPrev();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playPasue() {
        try {
            mMediaController.requestPPause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
