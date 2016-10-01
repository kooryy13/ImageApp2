package com.example.kooryy2.imageapp2.API;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kooryy2 on 9/19/2016.
 */
public class Result implements Parcelable {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("width")
    @Expose
    public Integer width;
    @SerializedName("height")
    @Expose
    public Integer height;
    @SerializedName("color")
    @Expose
    public String color;
    @SerializedName("likes")
    @Expose
    public Integer likes;
    @SerializedName("liked_by_user")
    @Expose
    public Boolean likedByUser;
    @SerializedName("user")
    @Expose
    public User user;
    @SerializedName("current_user_collections")
    @Expose
    public List<Object> currentUserCollections = new ArrayList<Object>();
    @SerializedName("urls")
    @Expose
    public Urls urls;
    @SerializedName("categories")
    @Expose
    public List<Category> categories = new ArrayList<Category>();
    @SerializedName("links")
    @Expose
    public Link_ links;


    protected Result(Parcel in) {
        id = in.readString();
        createdAt = in.readString();
        color = in.readString();
        categories = in.createTypedArrayList(Category.CREATOR);
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(createdAt);
        parcel.writeString(color);
        parcel.writeTypedList(categories);
    }
}