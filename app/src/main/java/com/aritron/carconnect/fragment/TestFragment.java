package com.aritron.carconnect.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aritron.carconnect.R;
import com.aritron.carconnect.adapter.PhotoDetailsRecyclerAdapter;

/**
 * Created by Komal on 10-04-2017.
 */

public class TestFragment extends Fragment {
    private View view;
    RecyclerView recyclerViewPhotoDetails;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_test, container, false);

        this.recyclerViewPhotoDetails = (RecyclerView) view.findViewById(R.id.recycler_view_photo_details);
        this.recyclerViewPhotoDetails.setLayoutManager(new LinearLayoutManager(getContext()));
        this.recyclerViewPhotoDetails.setAdapter(new PhotoDetailsRecyclerAdapter(getActivity().getSupportFragmentManager()));
        return view;
    }
}