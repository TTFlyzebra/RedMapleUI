package com.jancar.media.model.listener;

public interface IMusicPlayerListener {
    void playStatusChange(int statu);

    void loopStatusChange(int staut);

    void playtime(long current,long total);
}
