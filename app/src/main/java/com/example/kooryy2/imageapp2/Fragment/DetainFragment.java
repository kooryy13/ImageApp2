package com.example.kooryy2.imageapp2.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kooryy2.imageapp2.API.Result;
import com.example.kooryy2.imageapp2.Adapter.ViewpageAdapter;
import com.example.kooryy2.imageapp2.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetainFragment extends Fragment {
    private String TAG = DetainFragment.class.getSimpleName();
    public static final String IMAGE = "IMAGE";
    public static final String POSITION = "POSITION";
    private List<Result> resultList;
    private FloatingActionButton fap;
    private TextView lblCount, date, title;
    private int selectposition = 0;
    private ProgressDialog mProgressDialog;
    private ViewPager viewPager;


    private OnFragmentInteractionListener mListener;

    public DetainFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DetainFragment newInstance() {
        DetainFragment fragment = new DetainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            resultList = getArguments().getParcelableArrayList("IMAGE");
            selectposition = getArguments().getInt("POSITION");
            Log.e(TAG, "Image size" + resultList.size());
            Log.e(TAG, "position" + selectposition);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.image_slider, container, false);
        fap = (FloatingActionButton) rootView.findViewById(R.id.fap);
        lblCount = (TextView) rootView.findViewById(R.id.lbl_count);
        date = (TextView) rootView.findViewById(R.id.date);
        title = (TextView) rootView.findViewById(R.id.title);
        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);

        ViewpageAdapter vpAdapter = new ViewpageAdapter(resultList);
        viewPager.setAdapter(vpAdapter);
        viewPager.addOnAdapterChangeListener((ViewPager.OnAdapterChangeListener) vpOnPageChangeListener);

        selectCurrentItem(selectposition);
        return rootView;
    }

    ViewPager.OnPageChangeListener vpOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private void selectCurrentItem (int position){
        viewPager.setCurrentItem(position,false);
        disPlayMetaInfo(selectposition , (Result) resultList);
    }

    private void disPlayMetaInfo(int position , Result result) {
        lblCount.setText(result.categories.get(position+1).photoCount);
        date.setText(result.createdAt);
        title.setText(result.categories.get(0).title);
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
