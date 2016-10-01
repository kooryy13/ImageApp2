package com.example.kooryy2.imageapp2.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.kooryy2.imageapp2.API.Result;
import com.example.kooryy2.imageapp2.API.UnspashResponse;
import com.example.kooryy2.imageapp2.Adapter.GalleryAdapter;
import com.example.kooryy2.imageapp2.Interface.OnItemClick;
import com.example.kooryy2.imageapp2.R;
import com.example.kooryy2.imageapp2.Ulity.GsonRequest;
import com.example.kooryy2.imageapp2.Ulity.NetworkUtility;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment implements OnItemClick {


    private String TAG = ListFragment.class.getSimpleName();
    private ProgressDialog mProgressDialog;
    private List<Result> resultList;
    private RecyclerView recyclerView;
    private GalleryAdapter mAdapter;
    private int responsesize;


    private OnFragmentInteractionListener mListener;

    public ListFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_contain, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mProgressDialog = new ProgressDialog(getActivity());

        requestGalleryApp();
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    private void requestGalleryApp() {
        String url = "https://api.unsplash.com/search/photos?client_id=9ad2a5ea2e599e80e57be625809dc0f79dddbe6046cbc26f8f399820dce1cd6f&query=natural";
        GsonRequest<UnspashResponse> gsonRequest = new GsonRequest<>(Request.Method.GET, url,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, error.getMessage());
                        mProgressDialog.dismiss();
                    }
                }, UnspashResponse.class);
        gsonRequest.setListener(new Response.Listener<UnspashResponse>() {
            @Override
            public void onResponse(UnspashResponse response) {
                mProgressDialog.setTitle("Loading");
                mProgressDialog.setMessage("Doi Trong Giay Lat");
                mProgressDialog.dismiss();
                GalleryAdapter mAdapter = new GalleryAdapter(resultList);
                recyclerView.setAdapter(mAdapter);
            }
        });

        NetworkUtility.getsInstance(getActivity()).addToRequestQueue(gsonRequest);
    }


    @Override
    public void onItemClicked(View view, int position) {
        DetainFragment fragment = new DetainFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("IMAGE" , (ArrayList<? extends Parcelable>) resultList);
        bundle.putInt("POSITION" , position);
        fragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.Contain ,DetainFragment.newInstance()).commit();

    }

    @Override
    public void onLongClicked(View view, int position) {

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
