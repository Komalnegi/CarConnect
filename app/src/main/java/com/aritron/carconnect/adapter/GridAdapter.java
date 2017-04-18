package com.aritron.carconnect.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aritron.carconnect.R;

/**
 * Created by Komal on 17-04-2017.
 */

public class GridAdapter extends BaseAdapter {
    private Context mContext;
    private final String[] carName;
    private final int[] carImage;

    public GridAdapter(Context mContext, String[] carName, int[] carImage) {
        this.mContext = mContext;
        this.carName = carName;
        this.carImage = carImage;
    }

    @Override
    public int getCount() {
        return carName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(carName[position]);
            imageView.setImageResource(carImage[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
