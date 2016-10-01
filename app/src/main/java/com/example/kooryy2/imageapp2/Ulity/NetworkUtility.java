package com.example.kooryy2.imageapp2.Ulity;

import android.content.Context;
import android.net.ConnectivityManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Veteran Commander on 8/24/2016.
 */
public class NetworkUtility {
    //Bien singleton
    private static NetworkUtility sInstance;
    private static RequestQueue mRequestQueue;
    private static Context mContext;

    // Lop get va khoi tao singleton
    public static synchronized NetworkUtility getsInstance(Context context) {
        if (sInstance == null) {
            sInstance = new NetworkUtility(context);
        }
        return sInstance;
    }

    //ham tao
    public NetworkUtility(Context context) {
        initNetworkConfig(context);
    }

    public void initNetworkConfig(Context context) {
        mContext = context;
        mRequestQueue = getRequestQueue();
    }

    //ham tao requestqueue
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mContext);
        }
        return mRequestQueue;
    }

    //ham dua request vao requestqueue
    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        return (connectivityManager.getActiveNetworkInfo() != null
                && connectivityManager.getActiveNetworkInfo().isAvailable()
                && connectivityManager.getActiveNetworkInfo().isConnected());
    }





}
