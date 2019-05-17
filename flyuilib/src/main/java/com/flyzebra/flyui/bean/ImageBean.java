package com.flyzebra.flyui.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author FlyZebra
 * 2019/5/8 9:47
 * Describ:
 **/
public class ImageBean implements Parcelable {
    public int width;
    public int height;
    public String url;
    public String filterColor;
    public int left;
    public int top;
    public int right;
    public int bottom;
    public int scaleType;
    public String recv;
    public String send;

    protected ImageBean(Parcel in) {
        width = in.readInt();
        height = in.readInt();
        url = in.readString();
        filterColor = in.readString();
        left = in.readInt();
        top = in.readInt();
        right = in.readInt();
        bottom = in.readInt();
        scaleType = in.readInt();
        recv = in.readString();
        send = in.readString();
    }

    public static final Creator<ImageBean> CREATOR = new Creator<ImageBean>() {
        @Override
        public ImageBean createFromParcel(Parcel in) {
            return new ImageBean(in);
        }

        @Override
        public ImageBean[] newArray(int size) {
            return new ImageBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(width);
        dest.writeInt(height);
        dest.writeString(url);
        dest.writeString(filterColor);
        dest.writeInt(left);
        dest.writeInt(top);
        dest.writeInt(right);
        dest.writeInt(bottom);
        dest.writeInt(scaleType);
        dest.writeString(recv);
        dest.writeString(send);
    }
}
