package com.example.kooryy2.imageapp2.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kooryy2 on 9/19/2016.
 */

public class Link_ {

    @SerializedName("self")
    @Expose
    public String self;
    @SerializedName("html")
    @Expose
    public String html;
    @SerializedName("download")
    @Expose
    public String download;
    @SerializedName("download_location")
    @Expose
    public String downloadLocation;

}
