package com.example.kooryy2.imageapp2.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.kooryy2.imageapp2.Adapter.GalleryAdapter;
import com.example.kooryy2.imageapp2.Fragment.ListFragment;
import com.example.kooryy2.imageapp2.Interface.OnItemClick;
import com.example.kooryy2.imageapp2.R;
import com.example.kooryy2.imageapp2.Ulity.NetworkUtility;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportFragmentManager().beginTransaction().replace(R.id.Contain , new ListFragment()).commit();

    }
}

/* JSON Parceable
 */
//    private void requestGalleryImage() {
//        mProgressDialog.setMessage("Loanging");
//        mProgressDialog.show();
//        mProgressDialog.setCancelable(false);
//
//        String url = "http://api.androidhive.info/json/glide.json";
//        StringRequest galleryRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Log.d(TAG, response);
//
//                        JSONObject jsonObject = new JSONObject();
//                        try {
//
//                            imageArrayList = parseData(response);
//                            mAdapter = new GalleryAdapter(imageArrayList);
//                            mAdapter.setOnItemClick(MainActivity.this);
//                            recyclerView.setAdapter(mAdapter);
//                            mProgressDialog.dismiss();
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d(TAG, error.getMessage());
//                mProgressDialog.dismiss();
//            }
//        });
//        NetworkUtility.getsInstance(getApplicationContext()).addToRequestQueue(galleryRequest);
//    }
//
//    private ArrayList<Image> parseData(String data) throws JSONException {
//        imageArrayList = new ArrayList<>();
//        JSONArray jsonArray = new JSONArray(data);
//        for (int i = 0; i < jsonArray.length(); i++) {
//
//            JSONObject item = jsonArray.getJSONObject(i);
//            Image image = new Image();
//            image.name = item.getString("name");
//            image.timestamp = item.getString("timestamp");
//
//            JSONObject url = item.getJSONObject("url");
//            image.large = url.getString("large");
//            image.medium = url.getString("medium");
//            image.smaill = url.getString("small");
//
//            imageArrayList.add(image);
//        }
//        return imageArrayList;
//    }
