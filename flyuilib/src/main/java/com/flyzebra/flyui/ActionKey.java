package com.flyzebra.flyui;

/**
 * Author FlyZebra
 * 2019/4/2 15:17
 * Describ:
 **/
public interface ActionKey {
    int REFRESH = 9000;

    int KEY_HIDE_START = 1001;//执行左边隐藏动画
    int KEY_HIDE_END = 1002;//执行右边隐藏动画
    int KEY_HIDE_TOP = 1003;//执行上面隐藏动画
    int KEY_HIDE_BOTTOM = 1004;//执行下面隐藏动画

    int KEY_PLAY = 1006;//播放暂停
    int KEY_NEXT = 1010;//播放下一首
    int KEY_PREV = 1011;//插放上一首
    int KEY_MENU = 1012;//打开菜单

    int MUSIC_NAME = 1007;//音乐歌名
    int MUSIC_ALBUM = 1008;//音乐专辑名
    int MUSIC_ARTIST = 1009;//音乐艺术家

    int STATUS_PLAY = 2001;//播放状态
    int STATUS_MENU = 2002;//菜单状态
    int STATUS_PAGE = 2003;//页面改变
}
