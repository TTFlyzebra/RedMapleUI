package com.flyzebra.flyui.bean;

import java.util.List;

public class CellBean implements Cloneable{
    public String flyAction = "";
    public String launchAction = "";
    public String acceptAction = "";
    public String event = "";
    public String imageurl1 = "";
    public String imageurl2 ="";
    public int celltype = 0;
    public LanguageText textTitle;
    public int textSize = 0;
    public String textColor = "";
    public int textLeft = 0;
    public int textRight = 0;
    public int textTop = 0;
    public int textBottom = 0;
    public int sort;
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
                "flyAction='" + flyAction + '\'' +
                ", packName='" + launchAction + '\'' +
                ", className='" + acceptAction + '\'' +
                ", action='" + event + '\'' +
                ", imageurl1='" + imageurl1 + '\'' +
                ", imageurl2='" + imageurl2 + '\'' +
                ", celltype=" + celltype +
                ", textTitle=" + textTitle +
                ", textSize=" + textSize +
                ", textColor='" + textColor + '\'' +
                ", textLeft=" + textLeft +
                ", textRight=" + textRight +
                ", textTop=" + textTop +
                ", textBottom=" + textBottom +
                ", sort=" + sort +
                ", x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
