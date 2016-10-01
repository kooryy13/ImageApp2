package com.example.kooryy2.imageapp2.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.kooryy2.imageapp2.API.Result;
import com.example.kooryy2.imageapp2.Interface.OnItemClick;
import com.example.kooryy2.imageapp2.R;

/**
 * Created by kooryy2 on 9/27/2016.
 */

public class GalleryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private OnItemClick onItemClick;
    private ImageView ivThumbnal;

    public GalleryViewHolder(View itemView) {
        super(itemView);
        ivThumbnal = (ImageView) itemView.findViewById(R.id.ivThumbnail);
        itemView.setOnClickListener(this);
    }

    public void bind(Result result) {
        Glide.with(itemView.getContext()).load(result.urls.full).thumbnail(0.5f).crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivThumbnal);
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @Override
    public void onClick(View view) {
         if (onItemClick != null){
             onItemClick.onItemClicked(view , getAdapterPosition());
         }
    }
}
