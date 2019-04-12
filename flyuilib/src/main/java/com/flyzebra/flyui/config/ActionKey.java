package com.flyzebra.flyui.config;

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

    int KEY_PLAY = 1009;//播放暂停
    int KEY_NEXT = 1010;//播放下一首
    int KEY_PREV = 1011;//插放上一首
    int KEY_MENU = 1012;//打开菜单

    int STATUS_PLAY = 2001;//播放状态
    int STATUS_MENU = 2002;//菜单状态
    int STATUS_PAGE = 2003;//页面改变
    int STATUS_LOOP = 2004;//循环状态
    int STATUS_ZOOM = 2005;//循环状态

    int MEDIA_NAME = 3007;//音乐歌名
    int MEDIA_ALBUM = 3008;//音乐专辑名
    int MEDIA_ARTIST = 3009;//音乐艺术家
    int MEDIA_TIME = 3010;//音乐播放时间
    int MEDIA_SEEK = 3011;//跳转到指定时间播放
    int MUSIC_IMAGE = 3012;//音乐图片
    int MEDIA_TEXT = 3013;//歌词
    int MEDIA_PLAYLIST = 3014;//歌词
    int MEDIA_URL = 3015;//音乐歌名
}
