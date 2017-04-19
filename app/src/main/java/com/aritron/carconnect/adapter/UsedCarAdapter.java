package com.aritron.carconnect.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.aritron.carconnect.R;
import com.aritron.carconnect.model.Card;

import java.util.ArrayList;

/**
 * Created by Komal on 10-04-2017.
 */

public class UsedCarAdapter extends ArrayAdapter<Card> {
    private final ArrayList<Card> cards;
    private final LayoutInflater layoutInflater;

    public UsedCarAdapter(Context context, ArrayList<Card> cards) {
        super(context, -1);
        this.cards = cards;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Card card = cards.get(position);
        View view = layoutInflater.inflate(R.layout.card_used_cars, parent, false);
        ((ImageView) view.findViewById(R.id.card_image)).setImageResource(card.imageId);
        return view;
    }

    @Override
    public Card getItem(int position) {
        return cards.get(position);
    }

    @Override
    public int getCount() {
        return cards.size();
    }
}
