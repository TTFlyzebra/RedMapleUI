package com.flyzebra.flyui.bean;

import java.util.List;

public class PageBean {
    public int columns = 0;
    public String imageurl;
    public int rows = 0;
    public int itemPadding = 0;
    public int itemWidth= 0;
    public int itemHeight = 0;
    public int x = 0;
    public int y= 0;
    public List<CellBean> cellList;

    @Override
    public String toString() {
        return "PageBean{" +
                "columns=" + columns +
                ", rows=" + rows +
                ", itemPadding=" + itemPadding +
                ", itemWidth=" + itemWidth +
                ", itemHeight=" + itemHeight +
                ", x=" + x +
                ", y=" + y +
                ", cellList=" + cellList +
                '}';
    }
}
