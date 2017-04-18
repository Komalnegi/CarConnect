package com.aritron.carconnect.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aritron.carconnect.R;
import com.aritron.carconnect.model.CompareCarsModel;
import com.aritron.carconnect.model.CompareList;
import com.aritron.carconnect.recycler.RcycleViewHandler;
import com.aritron.carconnect.recycler.RcycleViewLayoutItem;
import com.google.gson.Gson;

import java.util.ArrayList;

public class CompareCarsActivity extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;
    private Button mAddCar;
    private Bundle bun;
    private ArrayList<CompareCarsModel> compareCarsModelArrayList = new ArrayList<>();
    private SharedPreferences appSharedPrefs;
    private Gson gson;
    private String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_cars);

        setUpUI();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bun = this.getIntent().getExtras();

        gson = new Gson();

        if(json == null) {

            CompareCarsModel compareCarsModel = new CompareCarsModel(R.drawable.car_image,
                    bun.getString("carName"), bun.getString("variantName"),
                    bun.getString("carCost"),
                    "Diesel");

            compareCarsModelArrayList.add(compareCarsModel);
            recyclerCompare();

            appSharedPrefs = PreferenceManager
                    .getDefaultSharedPreferences(this.getApplicationContext());
            SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
            json = gson.toJson(compareCarsModel);
            prefsEditor.putString("MyObject", json);
            prefsEditor.commit();
        }

            SharedPreferences appSharedPrefs = PreferenceManager
                    .getDefaultSharedPreferences(this.getApplicationContext());
            json = appSharedPrefs.getString("MyObject", "");
            CompareCarsModel compareCarsModel1 = gson.fromJson(json, CompareCarsModel.class);

            /*CompareCarsModel compareCarsModel3 = new CompareCarsModel(R.drawable.car_image,
                    compareCarsModel1.getmCarName(), compareCarsModel1.getmVariantName(),
                    compareCarsModel1.getmCarCost(),
                    "Diesel");

            compareCarsModelArrayList.add(compareCarsModel3);

            recyclerCompare();*/

            mAddCar.setOnClickListener(this);

    }

    private void recyclerCompare() {
        RcycleViewLayoutItem carName = new RcycleViewLayoutItem<>("carName",
                R.id.txt_car_name,
                new RcycleViewLayoutItem.DisplayLayoutItem<CompareCarsModel>() {
                    @Override
                    public void displayLayoutItem(View view, CompareCarsModel model) {
                        ((TextView) view).setText(model.getmCarName());
                    }
                },
                null);

        RcycleViewLayoutItem variantName = new RcycleViewLayoutItem<>("variantName",
                R.id.txt_variant_name,
                new RcycleViewLayoutItem.DisplayLayoutItem<CompareCarsModel>() {
                    @Override
                    public void displayLayoutItem(View view, CompareCarsModel model) {
                        ((TextView) view).setText(model.getmVariantName());
                    }
                },
                null);

        RcycleViewLayoutItem carCost = new RcycleViewLayoutItem<>("carCost",
                R.id.txt_car_cost,
                new RcycleViewLayoutItem.DisplayLayoutItem<CompareCarsModel>() {
                    @Override
                    public void displayLayoutItem(View view, CompareCarsModel model) {
                        ((TextView) view).setText(model.getmCarCost());
                    }
                },
                null);

        RcycleViewHandler rcView = new RcycleViewHandler<>(this,
                R.id.recyclerview_compare_cars,
                R.layout.card_compare_cars,
                compareCarsModelArrayList);

        rcView.addLayoutItem(carName);
        rcView.addLayoutItem(variantName);
        rcView.addLayoutItem(carCost);

        rcView.render();

    }

    private void setUpUI() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_compare_cars);
        mAddCar = (Button)findViewById(R.id.btn_add_car);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,CompareActivity.class);
        startActivity(intent);
    }

   /* @Override
    protected void onRestart() {
        super.onRestart();
        CompareCarsModel compareCarsModel2 = new CompareCarsModel(R.drawable.car_image,
                bun.getString("carName"), bun.getString("variantName"),
                bun.getString("carCost"),
                "Diesel");

        compareCarsModelArrayList.add(compareCarsModel2);

        recyclerCompare();
    }*/

    @Override
    protected void onPause() {
        super.onPause();
    }
}
