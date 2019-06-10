package com.flyzebra.flyui.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class PageBean implements Parcelable {
    public int pageId;
    public String imageurl;
    public int rows = 0;
    public int x = 0;
    public int y= 0;
    public List<CellBean> cellList;
    public int width;
    public int height;
    public String backColor;
    public SendBean send;
    public RecvBean recv;

    protected PageBean(Parcel in) {
        pageId = in.readInt();
        imageurl = in.readString();
        rows = in.readInt();
        x = in.readInt();
        y = in.readInt();
        cellList = in.createTypedArrayList(CellBean.CREATOR);
        width = in.readInt();
        height = in.readInt();
        backColor = in.readString();
        send = in.readParcelable(SendBean.class.getClassLoader());
        recv = in.readParcelable(RecvBean.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(pageId);
        dest.writeString(imageurl);
        dest.writeInt(rows);
        dest.writeInt(x);
        dest.writeInt(y);
        dest.writeTypedList(cellList);
        dest.writeInt(width);
        dest.writeInt(height);
        dest.writeString(backColor);
        dest.writeParcelable(send, flags);
        dest.writeParcelable(recv, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PageBean> CREATOR = new Creator<PageBean>() {
        @Override
        public PageBean createFromParcel(Parcel in) {
            return new PageBean(in);
        }

        @Override
        public PageBean[] newArray(int size) {
            return new PageBean[size];
        }
    };

    @Override
    public String toString() {
        return "PageBean{" +
                "imageurl='" + imageurl + '\'' +
                ", rows=" + rows +
                ", x=" + x +
                ", y=" + y +
                ", cellList=" + cellList +
                ", width=" + width +
                ", height=" + height +
                ", backColor='" + backColor + '\'' +
                ", send=" + send +
                ", recv=" + recv +
                '}';
    }
}
