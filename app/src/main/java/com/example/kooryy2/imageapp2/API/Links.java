package com.example.kooryy2.imageapp2.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kooryy2 on 9/19/2016.
 */
public class Links {

    @SerializedName("self")
    @Expose
    public String self;
    @SerializedName("html")
    @Expose
    public String html;
    @SerializedName("photos")
    @Expose
    public String photos;
    @SerializedName("likes")
    @Expose
    public String likes;
    @SerializedName("portfolio")
    @Expose
    public String portfolio;

}