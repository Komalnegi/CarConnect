package com.aritron.carconnect.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aritron.carconnect.R;
import com.aritron.carconnect.model.Card;
import com.aritron.carconnect.model.NewComparisonCard;

import java.util.ArrayList;

/**
 * Created by Komal on 06-04-2017.
 */

public class NewComparisonCardAdapter extends ArrayAdapter<NewComparisonCard> {
    private final ArrayList<NewComparisonCard> cards;
    private final LayoutInflater layoutInflater;

    public NewComparisonCardAdapter(Context context, ArrayList<NewComparisonCard> cards) {
        super(context, -1);
        this.cards = cards;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewComparisonCard card = cards.get(position);
        View view = layoutInflater.inflate(R.layout.item_new_comparison, parent, false);
        ((ImageView) view.findViewById(R.id.img_car1)).setImageResource(card.car1_image);
        ((ImageView) view.findViewById(R.id.img_car2)).setImageResource(card.car2_image);
        ((TextView) view.findViewById(R.id.txt_car1_name)).setText(card.car1_name);
        ((TextView) view.findViewById(R.id.txt_car2_name)).setText(card.car2_name);
        return view;
    }

    @Override
    public NewComparisonCard getItem(int position) {
        return cards.get(position);
    }

    @Override
    public int getCount() {
        return cards.size();
    }
}
