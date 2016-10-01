package com.example.kooryy2.imageapp2.API;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kooryy2 on 9/19/2016.
 */
public class Urls implements Parcelable {

    @SerializedName("raw")
    @Expose
    public String raw;
    @SerializedName("full")
    @Expose
    public String full;
    @SerializedName("regular")
    @Expose
    public String regular;
    @SerializedName("small")
    @Expose
    public String small;
    @SerializedName("thumb")
    @Expose
    public String thumb;

    protected Urls(Parcel in) {
        raw = in.readString();
        full = in.readString();
        regular = in.readString();
        small = in.readString();
        thumb = in.readString();
    }

    public static final Creator<Urls> CREATOR = new Creator<Urls>() {
        @Override
        public Urls createFromParcel(Parcel in) {
            return new Urls(in);
        }

        @Override
        public Urls[] newArray(int size) {
            return new Urls[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(raw);
        parcel.writeString(full);
        parcel.writeString(regular);
        parcel.writeString(small);
        parcel.writeString(thumb);
    }
}
