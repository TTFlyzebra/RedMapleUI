package com.flyzebra.flyui.bean;


import android.os.Parcel;
import android.os.Parcelable;
import android.view.Gravity;
import android.widget.ImageView;

import java.util.List;

public class CellBean implements Parcelable {
    public int cellId;
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

    protected CellBean(Parcel in) {
        cellId = in.readInt();
        imageurl1 = in.readString();
        imageurl2 = in.readString();
        backcolor = in.readString();
        celltype = in.readInt();
        resId = in.readString();
        textSize = in.readInt();
        textColor = in.readString();
        mLeft = in.readInt();
        mRight = in.readInt();
        mTop = in.readInt();
        mBottom = in.readInt();
        gravity = in.readInt();
        launchAction = in.readString();
        acceptAction = in.readString();
        sendAction = in.readInt();
        recvAction = in.readInt();
        clickevent = in.readString();
        x = in.readInt();
        y = in.readInt();
        width = in.readInt();
        height = in.readInt();
        subCells = in.createTypedArrayList(CellBean.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(cellId);
        dest.writeString(imageurl1);
        dest.writeString(imageurl2);
        dest.writeString(backcolor);
        dest.writeInt(celltype);
        dest.writeString(resId);
        dest.writeInt(textSize);
        dest.writeString(textColor);
        dest.writeInt(mLeft);
        dest.writeInt(mRight);
        dest.writeInt(mTop);
        dest.writeInt(mBottom);
        dest.writeInt(gravity);
        dest.writeString(launchAction);
        dest.writeString(acceptAction);
        dest.writeInt(sendAction);
        dest.writeInt(recvAction);
        dest.writeString(clickevent);
        dest.writeInt(x);
        dest.writeInt(y);
        dest.writeInt(width);
        dest.writeInt(height);
        dest.writeTypedList(subCells);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public int getTextGravity() {
        switch (gravity) {
            case 1:
                return Gravity.START;
            case 2:
                return Gravity.END;
            default:
                return Gravity.CENTER;
        }
    }

    public ImageView.ScaleType getImageGravity() {
        switch (gravity) {
            default:
                return ImageView.ScaleType.CENTER;
        }
    }
}
