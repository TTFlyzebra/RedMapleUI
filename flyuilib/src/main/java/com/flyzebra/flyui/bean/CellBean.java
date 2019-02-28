package com.flyzebra.flyui.bean;

public class CellBean implements Cloneable{
    public String flyAction = "";
    public String packName = "";
    public String className = "";
    public String action = "";
    public String intentFlag = "";
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "CellBean{" +
                "flyAction='" + flyAction + '\'' +
                ", packName='" + packName + '\'' +
                ", className='" + className + '\'' +
                ", action='" + action + '\'' +
                ", intentFlag='" + intentFlag + '\'' +
                ", imageurl1='" + imageurl1 + '\'' +
                ", imageurl2='" + imageurl2 + '\'' +
                ", type=" + celltype +
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
