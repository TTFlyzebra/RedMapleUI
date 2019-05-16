package com.flyzebra.flyui.bean;


import android.os.Parcel;
import android.os.Parcelable;
import android.view.Gravity;
import android.widget.ImageView;

import java.util.List;

public class CellBean implements Parcelable {
    public int cellId;
    public int celltype;
    public int resId;
    public int x;
    public int y;
    public int width;
    public int height;
    public String backColor;
    public String filterColor;
    public String recv;
    public EventBean send;
    public List<TextBean> texts;
    public List<ImageBean> images;
    public List<PageBean> pages;
    public List<CellBean> subCells;
    public String remark;

    protected CellBean(Parcel in) {
        cellId = in.readInt();
        celltype = in.readInt();
        resId = in.readInt();
        width = in.readInt();
        height = in.readInt();
        backColor = in.readString();
        filterColor = in.readString();
        recv = in.readString();
        x = in.readInt();
        y = in.readInt();
        remark = in.readString();
    }

    public static final Creator<CellBean> CREATOR = new Creator<CellBean>() {
        @Override
        public CellBean createFromParcel(Parcel in) {
            return new CellBean(in);
        }

        @Override
        public CellBean[] newArray(int size) {
            return new CellBean[size];
        }
    };

    public int getTextGravity() {
        return Gravity.CENTER;
    }

    public ImageView.ScaleType getImageGravity() {
        return ImageView.ScaleType.FIT_XY;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(cellId);
        dest.writeInt(celltype);
        dest.writeInt(resId);
        dest.writeInt(width);
        dest.writeInt(height);
        dest.writeString(backColor);
        dest.writeString(filterColor);
        dest.writeString(recv);
        dest.writeInt(x);
        dest.writeInt(y);
        dest.writeString(remark);
    }
}
