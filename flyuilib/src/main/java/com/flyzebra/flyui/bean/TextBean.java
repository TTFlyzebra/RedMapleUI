package com.flyzebra.flyui.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author FlyZebra
 * 2019/5/8 9:47
 * Describ:
 **/
public class TextBean implements Parcelable {
    public int textSize;
    public int textLines;
    public String textColor;
    public String filterColor;
    public LanguageText text;
    public int left;
    public int top;
    public int right;
    public int bottom;
    public int gravity;
    public String recv;
    public String send;

    protected TextBean(Parcel in) {
        textSize = in.readInt();
        textLines = in.readInt();
        textColor = in.readString();
        filterColor = in.readString();
        text = in.readParcelable(LanguageText.class.getClassLoader());
        left = in.readInt();
        top = in.readInt();
        right = in.readInt();
        bottom = in.readInt();
        gravity = in.readInt();
        recv = in.readString();
        send = in.readString();
    }

    public static final Creator<TextBean> CREATOR = new Creator<TextBean>() {
        @Override
        public TextBean createFromParcel(Parcel in) {
            return new TextBean(in);
        }

        @Override
        public TextBean[] newArray(int size) {
            return new TextBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(textSize);
        dest.writeInt(textLines);
        dest.writeString(textColor);
        dest.writeString(filterColor);
        dest.writeParcelable(text, flags);
        dest.writeInt(left);
        dest.writeInt(top);
        dest.writeInt(right);
        dest.writeInt(bottom);
        dest.writeInt(gravity);
        dest.writeString(recv);
        dest.writeString(send);
    }
}
