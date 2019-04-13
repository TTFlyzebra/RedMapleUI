package com.flyzebra.flyui.bean;


import android.view.Gravity;

import java.util.List;

public class CellBean implements Cloneable {
    public String imageurl1;
    public String imageurl2;
    public String backcolor;
    public int celltype;
    public String resId;

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

    public PageBean cellpage;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "CellBean{" +
                "imageurl1='" + imageurl1 + '\'' +
                ", imageurl2='" + imageurl2 + '\'' +
                ", backcolor='" + backcolor + '\'' +
                ", celltype=" + celltype +
                ", resId='" + resId + '\'' +
                ", textTitle=" + textTitle +
                ", textSize=" + textSize +
                ", textColor='" + textColor + '\'' +
                ", mLeft=" + mLeft +
                ", mRight=" + mRight +
                ", mTop=" + mTop +
                ", mBottom=" + mBottom +
                ", gravity=" + gravity +
                ", launchAction='" + launchAction + '\'' +
                ", acceptAction='" + acceptAction + '\'' +
                ", sendAction=" + sendAction +
                ", recvAction=" + recvAction +
                ", clickevent='" + clickevent + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", subCells=" + subCells +
                ", cellpage=" + cellpage +
                '}';
    }

    public int getGravity() {
        switch (gravity) {
            case 1:
                return Gravity.START;
            case 2:
                return Gravity.END;
            default:
                return Gravity.CENTER;
        }
    }
}
