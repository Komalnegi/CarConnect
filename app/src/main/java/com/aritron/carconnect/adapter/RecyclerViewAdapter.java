package com.aritron.carconnect.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aritron.carconnect.R;
import com.aritron.carconnect.model.CompareCarsModel;

import java.util.ArrayList;

/**
 * Created by Komal on 18-04-2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<CompareCarsModel> items;

    public RecyclerViewAdapter(ArrayList<CompareCarsModel> items) {
        this.items = items;
    }

    public  static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mCArName,mVariantName,mCarCost;

        public ViewHolder(View itemView) {
            super(itemView);
            mCArName = (TextView) itemView.findViewById(R.id.txt_car_name);
            mVariantName = (TextView) itemView.findViewById(R.id.txt_variant_name);
            mCarCost = (TextView) itemView.findViewById(R.id.txt_car_cost);
        }
    }
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_compare_cars, parent, false);
        return new ViewHolder(v);
    }

    public void updateData(ArrayList<CompareCarsModel> viewModels) {
        items.clear();
        items.addAll(viewModels);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        CompareCarsModel item = items.get(position);
        holder.mCArName.setText(item.getmCarName());
        holder.mVariantName.setText(item.getmVariantName());
        holder.mCarCost.setText(item.getmCarCost());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
