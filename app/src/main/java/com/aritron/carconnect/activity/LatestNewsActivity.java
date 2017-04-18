package com.aritron.carconnect.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aritron.carconnect.R;
import com.aritron.carconnect.model.LatestNewsModel;
import com.aritron.carconnect.model.NewCars;
import com.aritron.carconnect.recycler.RcycleViewHandler;
import com.aritron.carconnect.recycler.RcycleViewLayoutItem;

import java.util.ArrayList;

public class LatestNewsActivity extends AppCompatActivity {
    private ArrayList<LatestNewsModel> latestNewsModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest_news);

        LatestNewsModel latestNewsModel = new LatestNewsModel(R.drawable.default_car_image,"Toyota",
                "18 March 2017");
        LatestNewsModel latestNewsModel1 = new LatestNewsModel(R.drawable.default_car_image,"Toyota",
                "18 March 2017");

        latestNewsModels.add(latestNewsModel);
        latestNewsModels.add(latestNewsModel1);

        recyclerViewItem();
    }

    private void recyclerViewItem() {
        RcycleViewLayoutItem car_image = new RcycleViewLayoutItem<>("car_image",
                R.id.img_car_latest_news,
                new RcycleViewLayoutItem.DisplayLayoutItem<LatestNewsModel>() {
                    @Override
                    public void displayLayoutItem(View view, LatestNewsModel model) {
                        ((ImageView) view).setBackgroundResource(model.getCar_image());
                    }
                },
                null);


        RcycleViewLayoutItem car_name = new RcycleViewLayoutItem<>("car_name",
                R.id.txt_car_name_latest_news,
                new RcycleViewLayoutItem.DisplayLayoutItem<LatestNewsModel>() {
                    @Override
                    public void displayLayoutItem(View view, LatestNewsModel model) {
                        ((TextView) view).setText(model.getCar_name());
                    }
                },
                null);

        RcycleViewLayoutItem news_date = new RcycleViewLayoutItem<>("news_date",
                R.id.txt_news_date,
                new RcycleViewLayoutItem.DisplayLayoutItem<LatestNewsModel>() {
                    @Override
                    public void displayLayoutItem(View view, LatestNewsModel model) {
                        ((TextView) view).setText(model.getNews_date());
                    }
                },
                null);

        RcycleViewHandler rcView = new RcycleViewHandler<>(LatestNewsActivity.this,
                R.id.recyclerview_new_cars,
                R.layout.item_new_cars,
                latestNewsModels);

        rcView.addLayoutItem(car_image);
        rcView.addLayoutItem(car_name);
        rcView.addLayoutItem(news_date);

        rcView.render();
    }
}
