package com.flyzebra.flyui.config;

/**
 * Author FlyZebra
 * 2019/4/2 15:17
 * Describ:
 **/
public interface ActionKey {
    int REFRESH = 9000;
    int PAGER_RESID = 1018;
    int KEY_HIDE = 1001;//执行隐藏动画

    int KEY_PLAY = 1009;//播放暂停
    int KEY_NEXT = 1010;//播放下一首
    int KEY_PREV = 1011;//插放上一首
    int KEY_SEEK = 1013;//跳转到指定时间播放
    int KEY_MENU = 1014;//菜单按键
    int KEY_URL = 1015;//播放文件
    int KEY_LOOP = 1016;//切换播放状态
    int KEY_STORE = 1017;//选择存储器

    int STATUS_PLAY = 2001;//播放状态
    int STATUS_MENU = 2002;//菜单状态
    int STATUS_PAGE = 2003;//页面改变
    int STATUS_LOOP = 2004;//循环状态
    int STATUS_ZOOM = 2005;//缩放状态

    int MEDIA_NAME = 3007;//音乐歌名
    int MEDIA_ALBUM = 3008;//音乐专辑名
    int MEDIA_ARTIST = 3009;//音乐艺术家
    int MEDIA_TIME = 3010;//音乐播放时间
    int MUSIC_IMAGE = 3012;//媒体音乐图片
    int MEDIA_TEXT = 3013;//媒体歌词
    int MEDIA_LIST = 3014;//媒体单曲列表
    int MEDIA_URL = 3015;//音乐播放地址
    int VIDEO_IMAGE = 3016;//媒体视频图片

    int STORE_LIST = 3017;//存储器列表
    int STORE_URL = 3018;//存储器地址
    int STORE_NAME = 3020;//存储器名称
    int RES_IMAGE = 3019;//存储器图片资源

}
