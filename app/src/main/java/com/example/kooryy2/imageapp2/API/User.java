package com.example.kooryy2.imageapp2.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kooryy2 on 9/19/2016.
 */
public class User {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("username")
    @Expose
    public String username;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("portfolio_url")
    @Expose
    public String portfolioUrl;
    @SerializedName("bio")
    @Expose
    public String bio;
    @SerializedName("location")
    @Expose
    public String location;
    @SerializedName("total_likes")
    @Expose
    public Integer totalLikes;
    @SerializedName("total_photos")
    @Expose
    public Integer totalPhotos;
    @SerializedName("total_collections")
    @Expose
    public Integer totalCollections;
    @SerializedName("profile_image")
    @Expose
    public ProfileImage profileImage;
    @SerializedName("links")
    @Expose
    public Links links;

}
