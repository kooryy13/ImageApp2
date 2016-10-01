package com.example.kooryy2.imageapp2.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.kooryy2.imageapp2.API.Result;
import com.example.kooryy2.imageapp2.R;

import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by kooryy2 on 9/28/2016.
 */

public class ViewpageAdapter extends PagerAdapter {
    private ImageView image_preview;
    private Context mContext;
    private PhotoViewAttacher mAttacher;
    private List<Result> resultList;

    public ViewpageAdapter(Context mContext, List<Result> resultList) {
        this.mContext = mContext;
        this.resultList = resultList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView = layoutInflater.inflate(R.layout.image_fullscreen, container, false);

        image_preview = (ImageView) rootView.findViewById(R.id.image_preview);
//        mAttacher = new PhotoViewAttacher(image_preview);

        Glide.with(mContext).load(resultList.get(position).urls.full).diskCacheStrategy(DiskCacheStrategy.ALL).
                crossFade().into(image_preview);
        container.addView(rootView);
        return rootView ;
    }

    @Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object ;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
