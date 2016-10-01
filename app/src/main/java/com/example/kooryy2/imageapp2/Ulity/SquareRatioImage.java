package com.example.kooryy2.imageapp2.Ulity;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by kooryy2 on 9/27/2016.
 */

public class SquareRatioImage extends RelativeLayout {
    public SquareRatioImage(Context context) {
        super(context);
    }

    public SquareRatioImage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareRatioImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SquareRatioImage(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
