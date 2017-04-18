package com.aritron.carconnect.recycler;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aritron.carconnect.adapter.DisplayRowAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 27-01-2017.
 */

public class RcycleViewHandler <T> {
    public List<T> objectList;
    public List<RcycleViewLayoutItem<T>> itemLayouts;
    public int rcViewRowId;
    public int rcViewId;
    private View view;

    private Context context;
    private Activity activity;

    public RcycleViewHandler(AppCompatActivity appActivity, int rcViewId, int rcViewRowId, List <T> list){
        this.objectList = list;
        this.rcViewRowId = rcViewRowId;
        this.rcViewId = rcViewId;
        this.itemLayouts = new ArrayList<>();
        this.context = appActivity.getApplicationContext();
        this.activity=appActivity;
    }

    public RcycleViewHandler(View fragmentActivity, int rcViewId, int rcViewRowId, List <T> list){
        this.objectList = list;
        this.rcViewRowId = rcViewRowId;
        this.rcViewId = rcViewId;
        this.itemLayouts = new ArrayList<>();
        this.context = fragmentActivity.getContext();
        this.view = fragmentActivity;
    }

    public void addLayoutItem(RcycleViewLayoutItem item) {
        itemLayouts.add(item);
    }

    //Display Recycler view
    public void render() {
        RecyclerView deviceListView = (RecyclerView) activity.findViewById(rcViewId);
        deviceListView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        deviceListView.setLayoutManager(mLayoutManager);

        DisplayRowAdapter devRowAdapter = new DisplayRowAdapter<T>(this);
        deviceListView.setAdapter(devRowAdapter);
    }

    public void renderGrid() {
        RecyclerView deviceListView = (RecyclerView) activity.findViewById(rcViewId);
        deviceListView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(context,4);
        deviceListView.setLayoutManager(mLayoutManager);

        DisplayRowAdapter devRowAdapter = new DisplayRowAdapter<T>(this);
        deviceListView.setAdapter(devRowAdapter);
    }

    public void render(View view) {
        RecyclerView deviceListView = (RecyclerView) view.findViewById(rcViewId);
        deviceListView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        deviceListView.setLayoutManager(mLayoutManager);

        DisplayRowAdapter devRowAdapter = new DisplayRowAdapter<T>(this);
        deviceListView.setAdapter(devRowAdapter);
    }
    public List<T> getObjectList(){
        return objectList;
    }
}
