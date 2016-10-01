package com.example.kooryy2.imageapp2.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.kooryy2.imageapp2.API.Result;
import com.example.kooryy2.imageapp2.Interface.OnItemClick;
import com.example.kooryy2.imageapp2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kooryy2 on 9/27/2016.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryViewHolder> {
    private List<Result> resultList;
    private OnItemClick onItemClick;

    public GalleryAdapter(List<Result> resultList) {
        this.resultList = resultList;
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @Override
    public GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new GalleryViewHolder(layoutInflater.inflate(R.layout.layout_image_thumbnail, parent, false));
    }

    @Override
    public void onBindViewHolder(GalleryViewHolder holder, int position) {
        holder.bind(resultList.get(position));
        holder.setOnItemClick(onItemClick);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }
}
