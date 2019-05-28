package com.jancar.media.model.musicplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;

import com.jancar.media.data.Music;
import com.jancar.media.model.listener.IMusicPlayerListener;
import com.jancar.media.model.storage.Storage;
import com.jancar.media.utils.FlyLog;
import com.jancar.media.utils.SPUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MusicPlayer implements IMusicPlayer,
        MediaPlayer.OnCompletionListener,
        MediaPlayer.OnErrorListener,
        MediaPlayer.OnPreparedListener,
        IPlayStatus,
        ILoopStatus {
    private final static Executor executor = Executors.newFixedThreadPool(1);
    private Context mContext;
    private List<IMusicPlayerListener> listeners = new ArrayList<>();
    private MediaPlayer mMediaPlayer;
    private int mPlayStatus = STATUS_IDLE;
    private int mLoopStatus = LOOP_ALL;
    private String mPlayUrl = "";
    private final static List<Music> mPlayUrls = Collections.synchronizedList(new ArrayList<Music>());
    private int mPlayPos = -1;
    private String mPlayPath = "";
    private Map<String, Integer> mPosMap = new HashMap<>();
    private boolean isPlayNext = true;
    private static final HandlerThread sWorkerThread = new HandlerThread("music-thread");

    static {
        sWorkerThread.start();
    }

    private static final Handler tHandler = new Handler(sWorkerThread.getLooper());
    private Handler mHandler = new Handler(Looper.getMainLooper());

    private int cretTime = 0, totalTime = 0;
    private int saveIntaval = 5;
    private int savaCount = 0;
    private Runnable timeTask = new Runnable() {
        @Override
        public void run() {
            try {
                int c = getCurrentPosition();
                int t = getDuration();
                if (c != cretTime || t != totalTime) {
                    cretTime = c;
                    totalTime = t;
                    notifyPlayTime();
                    savaCount++;
                    if (savaCount % saveIntaval == 2) {
                        savePathUrl();
                    }
                }
            } catch (Exception e) {
                FlyLog.e(e.toString());
            }
            mHandler.postDelayed(this, 1000);
        }
    };

    private Runnable playPosTask = new Runnable() {
        @Override
        public void run() {
            synchronized (mPlayUrls) {
                if (mPlayPos >= 0 && mPlayUrls.size() > mPlayPos) {
                    play(mPlayUrls.get(mPlayPos).url);
                } else {
                    play(mPlayUrl);
                }
            }
        }
    };

    private Runnable nextTask = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (mPlayUrls) {
                    switch (mLoopStatus) {
                        case LOOP_RAND:
                            mPlayPos = (int) (Math.random() * mPlayUrls.size());
                            break;
                        case LOOP_ALL:
                        case LOOP_ONE:
                            if (!mPlayUrls.isEmpty()) {
                                mPlayPos = (mPlayPos + 1) % (mPlayUrls.size());
                            } else {
                                mPlayPos = -1;
                            }
                            break;
                        case LOOP_SINGER:
                            if (!mPlayUrls.isEmpty()) {
                                String artist = mPlayUrls.get(mPlayPos).artist;
                                int i = 0;
                                while (i < mPlayUrls.size()) {
                                    int num = (mPlayPos + i + 1) % (mPlayUrls.size());
                                    if (TextUtils.isEmpty(mPlayUrls.get(num).artist)) {
                                        i++;
                                        continue;
                                    }
                                    if (mPlayUrls.get(num).artist.equals(artist)) {
                                        mPlayPos = num;
                                        break;
                                    }
                                    i++;
                                }
                            } else {
                                mPlayPos = -1;
                            }
                            break;
                    }
                }
            } catch (Exception e) {
                mPlayPos = -1;
                FlyLog.e(e.toString());
            }
            mHandler.removeCallbacks(playPosTask);
            mHandler.post(playPosTask);
        }
    };

    private Runnable prevTask = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (mPlayUrls) {
                    switch (mLoopStatus) {
                        case LOOP_RAND:
                            mPlayPos = (int) (Math.random() * mPlayUrls.size());
                            break;
                        case LOOP_ALL:
                        case LOOP_ONE:
                            if (!mPlayUrls.isEmpty()) {
                                mPlayPos = (mPlayPos - 1 + mPlayUrls.size()) % mPlayUrls.size();
                            } else {
                                mPlayPos = -1;
                            }
                            break;
                        case LOOP_SINGER:
                            if (!mPlayUrls.isEmpty()) {
                                String artist = mPlayUrls.get(mPlayPos).artist;
                                int i = mPlayUrls.size();
                                int count = 0;
                                while (i > 0) {
                                    count++;
                                    int num = (mPlayPos + mPlayUrls.size() - count) % (mPlayUrls.size());
                                    if (TextUtils.isEmpty(mPlayUrls.get(num).artist)) {
                                        i--;
                                        continue;
                                    }
                                    if (mPlayUrls.get(num).artist.equals(artist)) {
                                        mPlayPos = num;
                                        break;
                                    }
                                    i--;
                                }
                            } else {
                                mPlayPos = -1;
                            }
                            break;
                    }
                }
            } catch (Exception e) {
                mPlayPos = -1;
                FlyLog.e(e.toString());
            }
            mHandler.removeCallbacks(playPosTask);
            mHandler.post(playPosTask);
        }
    };

    private MusicPlayer() {
    }

    public void onPrepared(MediaPlayer mp) {
        cretTime = 0;
        totalTime = mp.getDuration();
        if (saveSeek > 0) {
            seekTo(saveSeek);
            saveSeek = 0;
        }
        start();
        mPlayStatus = STATUS_PLAYING;
        notifyStatus();
    }

    private static class MusicPlayerHolder {
        public static final MusicPlayer sInstance = new MusicPlayer();
    }

    public static MusicPlayer getInstance() {
        return MusicPlayerHolder.sInstance;
    }


    @Override
    public void addListener(IMusicPlayerListener iMusicPlayerListener) {
        listeners.add(iMusicPlayerListener);
        iMusicPlayerListener.loopStatusChange(mLoopStatus);
        iMusicPlayerListener.playStatusChange(mPlayStatus);
        iMusicPlayerListener.playtime(getCurrentPosition(), getDuration());
    }

    @Override
    public void removeListener(IMusicPlayerListener iMusicPlayerListener) {
        listeners.remove(iMusicPlayerListener);
    }

    @Override
    public void init(Context context) {
        this.mContext = context;
        mLoopStatus = (int) SPUtil.get(mContext, "LOOPSTATUS", LOOP_ALL);
    }

    private void initMediaPlayer() {
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setOnCompletionListener(this);
        mMediaPlayer.setOnPreparedListener(this);
        mMediaPlayer.setOnErrorListener(this);
//        mMediaPlayer.setOnInfoListener(this);
        mHandler.removeCallbacks(timeTask);
        mHandler.post(timeTask);
    }

    @Override
    public void play(String url) {
        if (url == null || url.equals(mPlayUrl)) {
            FlyLog.d("url is null or is playing-" + url);
            return;
        }
        FlyLog.d("start url=%s", url);
        try {
            this.mPlayUrl = url;
            if (mMediaPlayer == null) {
                initMediaPlayer();
            } else {
                mMediaPlayer.reset();
            }
            mPlayStatus = STATUS_STARTPLAY;
            notifyStatus();
            mMediaPlayer.setDataSource(mPlayUrl);
            mMediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int saveSeek = 0;

    private void play(String mPlayUrl, int seek) {
        FlyLog.d("start url=%s,seek=%d", mPlayUrl, seek);
        saveSeek = seek;
        try {
            this.mPlayUrl = mPlayUrl;
            if (mMediaPlayer == null) {
                initMediaPlayer();
            } else {
                mMediaPlayer.reset();
            }
            mPlayStatus = STATUS_STARTPLAY;
            notifyStatus();
            mMediaPlayer.setDataSource(mPlayUrl);
            mMediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getPlayUrl() {
        return mPlayUrl;
    }

    @Override
    public void start() {
        if (mMediaPlayer != null) {
            mMediaPlayer.start();
            mPlayStatus = STATUS_PLAYING;
            notifyStatus();
        }
    }

    @Override
    public void pause() {
        if (mMediaPlayer != null) {
            savePathUrl();
            mMediaPlayer.pause();
            mPlayStatus = STATUS_PAUSE;
            notifyStatus();
        }
    }

    @Override
    public boolean isPause() {
        return mPlayStatus == STATUS_PAUSE;
    }

    @Override
    public void destory() {
        FlyLog.d("player destory");
        synchronized (mPlayUrls) {
            mPlayUrls.clear();
        }
        mPosMap.clear();
        mPlayPos = -1;
        mPlayUrl = "";
        mPlayStatus = STATUS_IDLE;
        cretTime = 0;
        totalTime = 0;
        notifyStatus();
        notifyPlayTime();
        releaseMediaPlay();

    }

    private void releaseMediaPlay() {
        tHandler.removeCallbacksAndMessages(null);
        mHandler.removeCallbacksAndMessages(null);
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    @Override
    public boolean isPlaying() {
        return mMediaPlayer != null && mMediaPlayer.isPlaying();
    }

    @Override
    public int getCurrentPosition() {
        int time = mMediaPlayer == null ? 0 : mMediaPlayer.getCurrentPosition();
        return Math.min(Math.max(time, 0), 359999000);
    }

    @Override
    public int getDuration() {
        int time = mMediaPlayer == null ? 0 : totalTime;
        return Math.min(Math.max(time, 0), 359999000);
    }


    @Override
    public void setPlayUrls(List<Music> urls) {
        if (urls == null || urls.isEmpty()) return;
        mPosMap.clear();
        String playUrl = "";
        synchronized (mPlayUrls) {
            mPlayUrls.clear();
            mPlayUrls.addAll(urls);
            for (int i = 0; i < mPlayUrls.size(); i++) {
                mPosMap.put(mPlayUrls.get(i).url, i);
            }
        }

        if ((!TextUtils.isEmpty(mPlayUrl)) && ((new File(mPlayUrl).exists()) && mPlayUrl.startsWith(mPlayPath))) {
            mPlayPos = getPlayPos();
        } else {
            mPlayPos = 0;
            play(urls.get(0).url);
        }
        FlyLog.d("setPlayUrls mPlayPos=%d", mPlayPos);
    }

    @Override
    public void playNext() {
        isPlayNext = true;
        FlyLog.d("playNext");
        tHandler.removeCallbacks(nextTask);
        tHandler.post(nextTask);
    }


    @Override
    public void playPrev() {
        isPlayNext = false;
        FlyLog.d("playPrev");
        tHandler.removeCallbacks(prevTask);
        tHandler.post(prevTask);
    }

    @Override
    public int getPlayPos() {
        if (mPosMap.get(mPlayUrl) == null) {
            return -1;
        }
        return mPosMap.get(mPlayUrl);
    }

    @Override
    public void switchLoopStatus() {
        mLoopStatus = (mLoopStatus + 1) % 4;
        SPUtil.set(mContext, "LOOPSTATUS", mLoopStatus);
        for (IMusicPlayerListener iMusicPlayerListener : listeners) {
            iMusicPlayerListener.loopStatusChange(mLoopStatus);
        }
    }

    @Override
    public void setLoopStatus(int loopStatus) {
        mLoopStatus = loopStatus;
        SPUtil.set(mContext, "LOOPSTATUS", mLoopStatus);
        for (IMusicPlayerListener iMusicPlayerListener : listeners) {
            iMusicPlayerListener.loopStatusChange(mLoopStatus);
        }
    }

    @Override
    public int getLoopStatus() {
        return mLoopStatus;
    }

    @Override
    public void savePathUrl() {
        final String path = mPlayPath;
        final String url = mPlayUrl;
        final int seek = cretTime;
        if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(url)) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (!TextUtils.isEmpty(url) && url.startsWith(path)) {
                            SPUtil.set(mContext, path + "MUSIC_URL", url);
                            SPUtil.set(mContext, path + "MUSIC_SEEK", seek);
                            FlyLog.d("savePathUrl seek=%d,path=%s,url=%s", seek, path, url);
                        } else {
                            FlyLog.e("save failed! seek=%d,path=%s,url=%s", seek, path, url);
                        }
                    } catch (Exception e) {
                        FlyLog.e(e.toString());
                    }
                }
            });
        } else {
            FlyLog.d("save failed! seek=%d,path=%s,url=%s", seek, path, url);
        }
    }

    @Override
    public void playPause() {
        if (isPlaying()) {
            pause();
        } else {
            start();
        }
    }

    @Override
    public int getPlayStatus() {
        return mPlayStatus;
    }


    @Override
    public void playSaveUrlByPath(String path) {
        FlyLog.d("playSaveUrlByPath path=%s", path);
        mPlayPath = path;
        String url = (String) SPUtil.get(mContext, path + "MUSIC_URL", "");
        int seek = (int) SPUtil.get(mContext, mPlayPath + "MUSIC_SEEK", 0);
        FlyLog.d("get Save url=%s,seek=%d", url, seek);
        if (url.equals(mPlayUrl)) {
            FlyLog.e("start save is playing so return, start url=%s", url);
            return;
        }
        if (!TextUtils.isEmpty(url)) {
            File file = new File(url);
            if (file.exists()) {
                play(url, seek);
            }
        } else {
            FlyLog.e("start file no exists url=%s", url);
            mPlayUrl = "";
            saveSeek = 0;
        }
    }

    @Override
    public void playOpenFile(List<String> fileStr) {
        if (fileStr == null) return;
        String url = fileStr.get(0);
        if (!TextUtils.isEmpty(url)) {
            File file = new File(url);
            if (file.exists()) {
                setLoopStatus(LOOP_SINGER);
                mPlayPath = Storage.ALL_STORAGE;
                SPUtil.set(mContext, mPlayPath + "MUSIC_URL", url);
                SPUtil.set(mContext, mPlayPath + "MUSIC_SEEK", 0);
                play(url);
            }
        } else {
            FlyLog.e("start file no exists url=%s", url);
            mPlayUrl = "";
            saveSeek = 0;
        }
    }


    @Override
    public void setVolume(float v, float v1) {
        if (mMediaPlayer != null) {
            mMediaPlayer.setVolume(v, v1);
        }
    }


    @Override
    public void seekTo(int seekPos) {
        if (mMediaPlayer != null) {
            mMediaPlayer.seekTo(seekPos);
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        FlyLog.d("onCompletion url=%s", mPlayUrl);
        /**
         * 拔掉U盘停止播放
         */
        cretTime = 0;
        totalTime = 0;

        if (mPlayStatus == STATUS_ERROR) {
            if (isPlayNext) {
                playNext();
            } else {
                playPrev();
            }
        } else {
            mPlayStatus = STATUS_COMPLETED;
            notifyStatus();
            switch (mLoopStatus) {
                case LOOP_RAND:
                case LOOP_ALL:
                case LOOP_SINGER:
                    playNext();
                    break;
                case LOOP_ONE:
                    play(mPlayUrl);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        FlyLog.d("onError what=%d,extra=%d", what, extra);
        mPlayStatus = STATUS_ERROR;
        notifyStatus();
        return false;
    }

    private void notifyStatus() {
        mPlayPos = getPlayPos();
        for (IMusicPlayerListener iMusicPlayerListener : listeners) {
            iMusicPlayerListener.playStatusChange(mPlayStatus);
        }
    }

    private void notifyPlayTime() {
        for (IMusicPlayerListener listener : listeners) {
            try {
                listener.playtime(cretTime, totalTime);
            } catch (Exception e) {
                FlyLog.e(e.toString());
            }
        }
    }


}

