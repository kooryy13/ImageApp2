package com.example.kooryy2.imageapp2.Interface;

import android.view.View;

/**
 * Created by kooryy2 on 9/27/2016.
 */

public interface OnItemClick {
    void onItemClicked(View view, int position);

    void onLongClicked(View view, int position);
}