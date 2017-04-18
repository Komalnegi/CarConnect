package com.aritron.carconnect.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aritron.carconnect.R;
import com.aritron.carconnect.model.NewCars;
import com.aritron.carconnect.recycler.RcycleViewHandler;
import com.aritron.carconnect.recycler.RcycleViewLayoutItem;

import java.util.ArrayList;

public class ViewNewCarsActivity extends AppCompatActivity {
    private ArrayList<NewCars> homeArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_new_cars);

        NewCars home = new NewCars(R.drawable.default_car_image,"Toyota", "2393 CC", "13.86 KMPL","28,179 EMI","13.99-21.19 Lakh");
        NewCars home1 = new NewCars(R.drawable.default_car_image,"Toyota", "2393 CC", "13.86 KMPL","28,179 EMI","13.99-21.19 Lakh");
        NewCars home2 = new NewCars(R.drawable.default_car_image,"Toyota", "2393 CC", "13.86 KMPL","28,179 EMI","13.99-21.19 Lakh");
        NewCars home3 = new NewCars(R.drawable.default_car_image,"Toyota", "2393 CC", "13.86 KMPL","28,179 EMI","13.99-21.19 Lakh");
        NewCars home4 = new NewCars(R.drawable.default_car_image,"Toyota", "2393 CC", "13.86 KMPL","28,179 EMI","13.99-21.19 Lakh");
        NewCars home5 = new NewCars(R.drawable.default_car_image,"Toyota", "2393 CC", "13.86 KMPL","28,179 EMI","13.99-21.19 Lakh");
        NewCars home6 = new NewCars(R.drawable.default_car_image,"Toyota", "2393 CC", "13.86 KMPL","28,179 EMI","13.99-21.19 Lakh");
        NewCars home7 = new NewCars(R.drawable.default_car_image,"Toyota", "2393 CC", "13.86 KMPL","28,179 EMI","13.99-21.19 Lakh");
        homeArrayList.add(home);
        homeArrayList.add(home1);
        homeArrayList.add(home2);
        homeArrayList.add(home3);
        homeArrayList.add(home4);
        homeArrayList.add(home5);
        homeArrayList.add(home6);
        homeArrayList.add(home7);

        recyclerViewItem();
    }

    private void recyclerViewItem() {
        RcycleViewLayoutItem iconImages = new RcycleViewLayoutItem<>("iconImages",
                R.id.img_car,
                new RcycleViewLayoutItem.DisplayLayoutItem<NewCars>() {
                    @Override
                    public void displayLayoutItem(View view, NewCars model) {
                        ((ImageView) view).setBackgroundResource(model.getImageView());
                    }
                },
                null);


        RcycleViewLayoutItem iconName = new RcycleViewLayoutItem<>("iconName",
                R.id.txt_car_name,
                new RcycleViewLayoutItem.DisplayLayoutItem<NewCars>() {
                    @Override
                    public void displayLayoutItem(View view, NewCars model) {
                        ((TextView) view).setText(model.getName());
                    }
                },
                null);

        RcycleViewLayoutItem iconTag = new RcycleViewLayoutItem<>("iconTag",
                R.id.txt_car_speed,
                new RcycleViewLayoutItem.DisplayLayoutItem<NewCars>() {
                    @Override
                    public void displayLayoutItem(View view, NewCars model) {
                        ((TextView) view).setText(model.getSpeed());
                    }
                },
                null);

        RcycleViewLayoutItem car_emi = new RcycleViewLayoutItem<>("car_emi",
                R.id.txt_car_rate,
                new RcycleViewLayoutItem.DisplayLayoutItem<NewCars>() {
                    @Override
                    public void displayLayoutItem(View view, NewCars model) {
                        ((TextView) view).setText(model.getRate());
                    }
                },
                null);

        RcycleViewLayoutItem car_cost = new RcycleViewLayoutItem<>("car_cost",
                R.id.txt_car_cost,
                new RcycleViewLayoutItem.DisplayLayoutItem<NewCars>() {
                    @Override
                    public void displayLayoutItem(View view, NewCars model) {
                        ((TextView) view).setText(model.getCost());
                    }
                },
                null);


        RcycleViewHandler rcView = new RcycleViewHandler<>(ViewNewCarsActivity.this,
                R.id.recyclerview_new_cars,
                R.layout.item_new_cars,
                homeArrayList);

        rcView.addLayoutItem(iconImages);
        rcView.addLayoutItem(iconName);
        rcView.addLayoutItem(iconTag);
        rcView.addLayoutItem(car_emi);
        rcView.addLayoutItem(car_cost);

        rcView.render();
    }
}
