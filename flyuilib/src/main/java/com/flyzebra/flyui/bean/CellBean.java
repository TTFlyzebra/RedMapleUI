package com.flyzebra.flyui.bean;

import java.util.List;

public class CellBean implements Cloneable{
    public String imageurl1;
    public String imageurl2;
    public String backcolor;
    public int celltype = 0;

    public LanguageText textTitle;
    public int textSize = 0;
    public String textColor;

    public int mLeft = 0;
    public int mRight = 0;
    public int mTop = 0;
    public int mBottom = 0;
    public int gravity;

    public String launchAction;
    public String acceptAction;
    public int sendAction;
    public int recvAction;
    public String clickevent;

    public int x = 0;
    public int y = 0;
    public int width = 0;
    public int height = 0;
    public List<CellBean> subCells;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "CellBean{" +
                "launchAction='" + launchAction + '\'' +
                ", acceptAction='" + acceptAction + '\'' +
                ", sendAction=" + sendAction +
                ", recvAction=" + recvAction +
                ", clickEvent='" + clickevent + '\'' +
                ", imageurl1='" + imageurl1 + '\'' +
                ", imageurl2='" + imageurl2 + '\'' +
                ", backcolor='" + backcolor + '\'' +
                ", celltype=" + celltype +
                ", textTitle=" + textTitle +
                ", textSize=" + textSize +
                ", textColor='" + textColor + '\'' +
                ", left=" + mLeft +
                ", right=" + mRight +
                ", top=" + mTop +
                ", bottom=" + mBottom +
                ", gravity=" + gravity +
                ", x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", subCells=" + subCells +
                '}';
    }
}
