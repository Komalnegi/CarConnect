package com.aritron.carconnect.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.aritron.carconnect.R;
import com.aritron.carconnect.activity.CompareActivity;
import com.aritron.carconnect.adapter.CardsAdapter;
import com.aritron.carconnect.adapter.NewComparisonCardAdapter;
import com.aritron.carconnect.model.Card;
import com.aritron.carconnect.model.NewComparisonCard;

import java.util.ArrayList;

import in.arjsna.swipecardlib.SwipeCardView;


/**
 * Created by Komal on 04-04-2017.
 */

public class CompareFragment extends Fragment implements View.OnClickListener{
    private View view;
    public SwipeCardView swipeCardView_new_comparison;
    private ArrayList<NewComparisonCard> al;
    private NewComparisonCardAdapter arrayAdapter;
    private Button mAddToCompareButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_compare, container, false);

        mAddToCompareButton = (Button)view.findViewById(R.id.btn_add_car_compare);
        mAddToCompareButton.setOnClickListener(this);

        al = new ArrayList<>();
        getDummyData(al);
        arrayAdapter = new NewComparisonCardAdapter(getActivity(), al);

        swipeCardView_new_comparison = (SwipeCardView)view.findViewById(R.id.swipe_card_view_comparison);
        swipeCardView_new_comparison.setAdapter(arrayAdapter);
        swipeCardView_new_comparison.setFlingListener(new SwipeCardView.OnCardFlingListener() {
            @Override public void onCardExitLeft(Object dataObject) {
                //makeToast(CardSwipeActivity.this, "Left!");
            }

            @Override public void onCardExitRight(Object dataObject) {
                //makeToast(CardSwipeActivity.this, "Right!");
            }

            @Override public void onAdapterAboutToEmpty(int itemsInAdapter) {

            }

            @Override public void onScroll(float scrollProgressPercent) {

            }

            @Override public void onCardExitTop(Object dataObject) {
                //makeToast(CardSwipeActivity.this, "Top!");
            }

            @Override public void onCardExitBottom(Object dataObject) {
                //makeToast(CardSwipeActivity.this, "Bottom!");
            }
        });
        return view;
    }

    private void getDummyData(ArrayList<NewComparisonCard> al) {
        NewComparisonCard card = new NewComparisonCard();
        card.car1_name = "Card1";
        card.car1_image = R.drawable.default_car_image;

        card.car2_name = "Card1";
        card.car2_image = R.drawable.ic_car_des;

        al.add(card);

        NewComparisonCard card2 = new NewComparisonCard();
        card2.car1_name = "Card2";
        card2.car1_image = R.drawable.default_car_image;

        card2.car2_name = "Card2";
        card2.car2_image = R.drawable.ic_car_des;

        al.add(card2);

        NewComparisonCard card3 = new NewComparisonCard();
        card3.car1_name = "Card3";
        card3.car1_image = R.drawable.default_car_image;

        card3.car2_name = "Card3";
        card3.car2_image = R.drawable.ic_car_des;
        al.add(card3);

        NewComparisonCard card4 = new NewComparisonCard();
        card4.car1_name = "Card4";
        card4.car1_image = R.drawable.default_car_image;

        card4.car2_name = "Card4";
        card4.car2_image = R.drawable.ic_car_des;
        al.add(card4);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), CompareActivity.class);
        startActivity(intent);
    }
}

