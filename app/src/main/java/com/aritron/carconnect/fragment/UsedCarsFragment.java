package com.aritron.carconnect.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aritron.carconnect.R;
import com.aritron.carconnect.adapter.MyViewPagerAdapter;
import com.aritron.carconnect.model.LatestNewsModel;
import com.aritron.carconnect.model.UsedCarModel;
import com.aritron.carconnect.recycler.RcycleViewHandler;
import com.aritron.carconnect.recycler.RcycleViewLayoutItem;

import java.util.ArrayList;

/**
 * Created by Komal on 10-04-2017.
 */

public class UsedCarsFragment extends android.app.Fragment {
    private View view;
    private ArrayList<UsedCarModel> usedCarModelArrayList = new ArrayList<>();
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_used_car, container, false);

        /*viewPager = (ViewPager) view.findViewById(R.id.view_pager);

        dotsLayout = (LinearLayout) view.findViewById(R.id.layoutDots_used_cars);

        layouts = new int[]{
                R.layout.slide1,
                R.layout.slide2,
                R.layout.slide3,
                R.layout.slide4};

        // adding bottom dots
        addBottomDots(0);

        myViewPagerAdapter = new MyViewPagerAdapter(getContext(),layouts);
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);*/

        UsedCarModel usedCarModel = new UsedCarModel(R.drawable.ic_car_mer,"Toyota",
                "4.56 Lakh","2014","58,574 Kms","Diesel");
        UsedCarModel usedCarModel1 = new UsedCarModel(R.drawable.ic_car_mer,"Toyota",
                "4.56 Lakh","2014","58,574 Kms","Diesel");

        usedCarModelArrayList.add(usedCarModel);
        usedCarModelArrayList.add(usedCarModel1);

        recyclerViewItem();
        return view;
    }

    /*private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getContext());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
            } else {
                // still pages are left
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };*/

    private void recyclerViewItem() {
        /*RcycleViewLayoutItem carImage = new RcycleViewLayoutItem<>("carImage",
                R.id.img_car_latest_news,
                new RcycleViewLayoutItem.DisplayLayoutItem<LatestNewsModel>() {
                    @Override
                    public void displayLayoutItem(View view, LatestNewsModel model) {
                        ((ImageView) view).setBackgroundResource(model.getCar_image());
                    }
                },
                null);*/


        RcycleViewLayoutItem carName = new RcycleViewLayoutItem<>("carName",
                R.id.txt_car_used_car_name,
                new RcycleViewLayoutItem.DisplayLayoutItem<UsedCarModel>() {
                    @Override
                    public void displayLayoutItem(View view, UsedCarModel model) {
                        ((TextView) view).setText(model.getName());
                    }
                },
                null);

        RcycleViewLayoutItem carCost = new RcycleViewLayoutItem<>("carCost",
                R.id.txt_used_car_cost,
                new RcycleViewLayoutItem.DisplayLayoutItem<UsedCarModel>() {
                    @Override
                    public void displayLayoutItem(View view, UsedCarModel model) {
                        ((TextView) view).setText(model.getCost());
                    }
                },
                null);

        RcycleViewLayoutItem year = new RcycleViewLayoutItem<>("year",
                R.id.txt_year,
                new RcycleViewLayoutItem.DisplayLayoutItem<UsedCarModel>() {
                    @Override
                    public void displayLayoutItem(View view, UsedCarModel model) {
                        ((TextView) view).setText(model.getYear());
                    }
                },
                null);

        RcycleViewLayoutItem speed = new RcycleViewLayoutItem<>("speed",
                R.id.txt_speed,
                new RcycleViewLayoutItem.DisplayLayoutItem<UsedCarModel>() {
                    @Override
                    public void displayLayoutItem(View view, UsedCarModel model) {
                        ((TextView) view).setText(model.getSpeed());
                    }
                },
                null);

        RcycleViewLayoutItem fuel = new RcycleViewLayoutItem<>("fuel",
                R.id.txt_fuel,
                new RcycleViewLayoutItem.DisplayLayoutItem<UsedCarModel>() {
                    @Override
                    public void displayLayoutItem(View view, UsedCarModel model) {
                        ((TextView) view).setText(model.getFuel());
                    }
                },
                null);

        RcycleViewHandler rcView = new RcycleViewHandler<>(view,
                R.id.recyclerview_used_cars,
                R.layout.card_new_cars,
                usedCarModelArrayList);

        //rcView.addLayoutItem(carImage);
        rcView.addLayoutItem(carName);
        rcView.addLayoutItem(carCost);
        rcView.addLayoutItem(year);
        rcView.addLayoutItem(speed);
        rcView.addLayoutItem(fuel);

        rcView.render(view);
    }
}
