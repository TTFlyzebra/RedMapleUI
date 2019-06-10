package com.flyzebra.flyui.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import java.util.List;

/**
 * Author FlyZebra
 * 2018/12/25 15:01
 * Describ:
 **/
public class ThemeBean implements Parcelable {
    public static int filterColor = 0xFF0370E5;
    public static int normalColor = 0xFFFFFFFF;
    public String themeName;
    public String themeType;
    public String imageurl = "";
    public String exampleurl = "";
    public List<PageBean> pageList;
    public PageBean topPage;
    public int left = 0;
    public int top = 0;
    public int right = 0;
    public int bottom = 0;
    public int screenWidth = 1024;
    public int screenHeight = 600;
    public int animType = 0;
    public int isMirror = 0;

    protected ThemeBean(Parcel in) {
        themeName = in.readString();
        themeType = in.readString();
        imageurl = in.readString();
        exampleurl = in.readString();
        pageList = in.createTypedArrayList(PageBean.CREATOR);
        topPage = in.readParcelable(PageBean.class.getClassLoader());
        left = in.readInt();
        top = in.readInt();
        right = in.readInt();
        bottom = in.readInt();
        screenWidth = in.readInt();
        screenHeight = in.readInt();
        animType = in.readInt();
        isMirror = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(themeName);
        dest.writeString(themeType);
        dest.writeString(imageurl);
        dest.writeString(exampleurl);
        dest.writeTypedList(pageList);
        dest.writeParcelable(topPage, flags);
        dest.writeInt(left);
        dest.writeInt(top);
        dest.writeInt(right);
        dest.writeInt(bottom);
        dest.writeInt(screenWidth);
        dest.writeInt(screenHeight);
        dest.writeInt(animType);
        dest.writeInt(isMirror);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ThemeBean> CREATOR = new Creator<ThemeBean>() {
        @Override
        public ThemeBean createFromParcel(Parcel in) {
            return new ThemeBean(in);
        }

        @Override
        public ThemeBean[] newArray(int size) {
            return new ThemeBean[size];
        }
    };

    @Override
    public String toString() {
        return "ThemeBean{" +
                "themeName='" + themeName + '\'' +
                ", themeType='" + themeType + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", pageList=" + pageList +
                ", topPage=" + topPage +
                ", left=" + left +
                ", top=" + top +
                ", right=" + right +
                ", bottom=" + bottom +
                ", screenWidth=" + screenWidth +
                ", screenHeight=" + screenHeight +
                ", animType=" + animType +
                ", isMirror=" + isMirror +
                '}';
    }

    public boolean isValid() {
        return pageList != null && !TextUtils.isEmpty(themeName);
    }
}
