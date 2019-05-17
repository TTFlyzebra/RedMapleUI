package com.flyzebra.flyui.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author FlyZebra
 * 2019/5/14 11:07
 * Describ:
 **/
public class RecvBean implements Parcelable {
    public int eventId;
    public int eventContent;

    protected RecvBean(Parcel in) {
        eventId = in.readInt();
        eventContent = in.readInt();
    }

    public static final Creator<RecvBean> CREATOR = new Creator<RecvBean>() {
        @Override
        public RecvBean createFromParcel(Parcel in) {
            return new RecvBean(in);
        }

        @Override
        public RecvBean[] newArray(int size) {
            return new RecvBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(eventId);
        dest.writeInt(eventContent);
    }
}
