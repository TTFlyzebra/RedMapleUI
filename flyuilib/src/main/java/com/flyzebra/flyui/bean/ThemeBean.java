package com.flyzebra.flyui.bean;

import java.util.List;

/**
 * Author FlyZebra
 * 2018/12/25 15:01
 * Describ:
 **/
public class ThemeBean {
    public String themeName;
    public String themeType;
    public String imageurl = "";
    public List<PageBean> pageList;
    public PageBean topPage;
    public int x = 0;
    public int y = 0;
    public int width = 0;
    public int height = 0;
    public int screenWidth = 1024;
    public int screenHeight = 600;
    public int animType = 0;
    public int isMirror = 0;
}
