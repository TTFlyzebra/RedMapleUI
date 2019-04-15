package com.flyzebra.flyui.view.cellview;

public interface CellType {
    /**
     *背景图片
     */
    int TYPE_IMAGE = 0;
    /**
     * 普通应用
     */
    int TYPE_APP_NORMAL = 1;
    /**
     * 收音机应用
     */
    int TYPE_APP_RADIO = 2;
    /**
     * 时间
     */
    int TYPE_APP_TIME = 3;
    /**
     * 媒体小部件
     */
    int TYPE_APP_MEDIA = 4;
    /**
     * 可镜像的小部件
     */
    int TYPE_APP_MIRRORIMG = 5;
    /**
     * 导航条
     */
    int TYPE_APP_NAV = 6;
    /**
     * 可产生按键事件
     */
    int TYPE_SEEKBAR = 7;
    /**
     * 组合控件
     */
    int TYPE_PAGE = 8;
    /**
     * 可根据条件变化的控件
     */
    int TYPE_SWITH = 9;

    /**
     * 可根据条件变化的控件
     */
    int TYPE_TEXT = 10;


    int TYPE_LISTVIEW = 11;


    int TYPE_ANIMTOR = 12;


    int TYPE_PAGE_MENU= 13;

}
