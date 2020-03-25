package com.parkho;

import android.os.Parcel;
import android.os.Parcelable;

public class ShareData implements Parcelable {

    private String name;
    private int number;
    private boolean isParcelable;

    public void setName(String a_name) {
        name = a_name;
    }

    public void setNumber(int a_number) {
        number = a_number;
    }

    public void setParcelable(boolean a_isParcelable) {
        isParcelable = a_isParcelable;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public boolean isParcelable() {
        return isParcelable;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel a_dest, int flags) {
        a_dest.writeString(name);
        a_dest.writeInt(number);
        a_dest.writeByte((byte) (isParcelable ? 1 : 0));
    }

    public static final Parcelable.Creator<ShareData> CREATOR =
            new Creator<ShareData>() {
                @Override
                public ShareData createFromParcel(Parcel a_src) {
                    ShareData shareData = new ShareData();
                    shareData.name = a_src.readString();
                    shareData.number = a_src.readInt();
                    shareData.isParcelable = a_src.readByte() != 0;

                    return shareData;
                }

                @Override
                public ShareData[] newArray(int size) {
                    return new ShareData[size];
                }
            };
}