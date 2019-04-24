package com.flyzebra.flyui.config;

/**
 * Author FlyZebra
 * 2019/4/2 15:17
 * Describ:
 **/
public interface ActionKey {
    int REFRESH = 9000;
    int CHANGE_PAGER_WITH_RESID = 1018;
    int KEY_HIDE = 1001;//执行隐藏动画

    int KEY_PLAY = 1009;//播放暂停
    int KEY_NEXT = 1010;//播放下一首
    int KEY_PREV = 1011;//插放上一首
    int KEY_SEEK = 1013;//跳转到指定时间播放
    int KEY_MENU = 1014;//菜单按键
    int KEY_URL = 1015;//播放文件
    int KEY_LOOP = 1016;//切换播放状态
    int KEY_STORE = 1017;//选择存储器
    int KEY_ZOOM = 1018;//放大图片

    int MSG_PLAY_STATUS = 2001;//播放状态
    int MSG_MENU_STATUS = 2002;//菜单状态
    int MSG_LOOP_STATUS = 2004;//循环状态

    int MUSIC_NAME = 3007;//音乐歌名
    int MUSIC_ALBUM = 3008;//音乐专辑名
    int MUSIC_ARTIST = 3009;//音乐艺术家
    int MUSIC_TIME = 3010;//音乐播放时间
    int MUSIC_TEXT = 3013;//音乐歌词
    int MUSIC_LIST = 3014;//音乐播放列表
    int MUSIC_URL = 3015;//音乐播放地址

    int STORE_LIST = 3017;//存储器列表
    int STORE_URL = 3018;//存储器地址
    int STORE_NAME = 3020;//存储器名称
    int RES_URL = 3019;//存储器图片资源

    int VIDEO_NAME = 3021;//视频文件名称
    int VIDEO_URL = 3022;//视频文件地址
    int VIDEO_LIST = 3023;//视频播放列表

    int IMAGE_NAME = 3024;//图片文件名称
    int IMAGE_URL = 3025;//图片文件地址
    int IMAGE_LIST = 3026;//图片播放列表
    int IMAGE_LIST_FOLDER = 3027;//图片文件夹列表
}
