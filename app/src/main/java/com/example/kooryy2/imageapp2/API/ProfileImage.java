package com.example.kooryy2.imageapp2.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kooryy2 on 9/19/2016.
 */
public class ProfileImage {

    @SerializedName("small")
    @Expose
    public String small;
    @SerializedName("medium")
    @Expose
    public String medium;
    @SerializedName("large")
    @Expose
    public String large;

}
