package com.aritron.carconnect.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aritron.carconnect.R;

/**
 * Created by Komal on 10-04-2017.
 */

public class CommentsFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_comments, container, false);
        return view;
    }
}
