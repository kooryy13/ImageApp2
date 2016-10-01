package com.example.kooryy2.imageapp2.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class UnspashResponse {

    @SerializedName("total")
    @Expose
    public Integer total;
    @SerializedName("total_pages")
    @Expose
    public Integer totalPages;
    @SerializedName("results")
    @Expose
    public List<Result> results = new ArrayList<Result>();

}
