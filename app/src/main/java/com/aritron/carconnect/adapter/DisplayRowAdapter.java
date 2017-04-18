package com.aritron.carconnect.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aritron.carconnect.recycler.RcycleViewHandler;
import com.aritron.carconnect.recycler.RcycleViewLayoutItem;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 15-11-2016.
 */

public class DisplayRowAdapter<T> extends RecyclerView.Adapter<DisplayRowAdapter.MyViewHolder> {

    private RcycleViewHandler<T> rcViewHandler;
    private List<Object> itemList = new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder {

        List<View> views = new ArrayList<>();
        //View testView;
        int itemCount = 0;
        public MyViewHolder(final View view) {
            super(view);
            for (RcycleViewLayoutItem<T> itemLayout: rcViewHandler.itemLayouts) {
                View itemView =  view.findViewById(itemLayout.viewId);
                views.add(itemCount++, itemView);
            }
        }
    }

    public DisplayRowAdapter(RcycleViewHandler<T> rcViewHandler) {
        this.rcViewHandler = rcViewHandler;
        for (RcycleViewLayoutItem<T> itemLayout: rcViewHandler.itemLayouts) {
            itemList.add(itemLayout);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(rcViewHandler.rcViewRowId, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final DisplayRowAdapter.MyViewHolder holder, final int position) {

        int itemCount = 0;
        Object obj = rcViewHandler.getObjectList().get(position);
        for (Object item: itemList) {
            View view = (View) holder.views.get(itemCount);
            try {
                Class[] displayFnArgs = new Class[2];
                displayFnArgs[0] = View.class;
                displayFnArgs[1] = Object.class;
                Method method = item.getClass().getMethod("generateLayoutItemDisplay", displayFnArgs);
                method.invoke(item, view, obj);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Class[] clickFnArgs = new Class[2];
                clickFnArgs[0] = View.class;
                clickFnArgs[1] = Object.class;
                Method method = item.getClass().getMethod("handleLayoutItemClick", clickFnArgs);
                method.invoke(item, view, obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
            itemCount++;
        }
    }

    @Override
    public int getItemCount(){
        // TODO Auto-generated method stub
        return rcViewHandler.objectList.size();
    }
}
