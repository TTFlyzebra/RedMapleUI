package com.flyzebra.flyui.bean;

import java.util.List;

/**
 * Author FlyZebra
 * 2019/5/8 10:19
 * Describ:
 **/
public class CellProBean {
    public int cellId;
    public int celltype;
    public int resId;
    public int width;
    public int height;
    public String backColor;
    public String filterColor;
    public String recv;
    public EventBean send;
    public List<TextBean> texts;
    public List<ImageBean> images;
    public List<PageBean> pages;
    public List<CellProBean> subCells;
    public int x;
    public int y;
    public String remark;
}
