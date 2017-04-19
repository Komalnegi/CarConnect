package com.aritron.carconnect.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.aritron.carconnect.R;
import com.aritron.carconnect.adapter.RecyclerViewAdapter;
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
    private CompareCarsModel compareCarsModel;
    private RecyclerView recyclerView ;
    private RecyclerViewAdapter adapter;
    static final String STATE_SCORE = "playerScore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,"CREATE",Toast.LENGTH_SHORT).show();
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
        /*String json = bun.getString("json");
        compareCarsModel = gson.fromJson(json,CompareCarsModel.class);*/
        compareCarsModel = new CompareCarsModel(R.drawable.car_image,
                bun.getString("carName"), bun.getString("variantName"),
                bun.getString("carCost"),
                "Diesel");

        appSharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this.getApplicationContext());
        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
        json = gson.toJson(compareCarsModel);
        Toast.makeText(this,json,Toast.LENGTH_SHORT).show();
        Log.v("put_json",json);
        prefsEditor.putString("MyObject", json);
        prefsEditor.commit();

        compareCarsModelArrayList.add(compareCarsModel);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_compare_cars);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerViewAdapter(compareCarsModelArrayList);
        recyclerView.setAdapter(adapter);

        //recyclerCompare();

        /*if(json == null) {
            Toast.makeText(this,"JSON IS NULL",Toast.LENGTH_SHORT).show();
            compareCarsModel = new CompareCarsModel(R.drawable.car_image,
                    bun.getString("carName"), bun.getString("variantName"),
                    bun.getString("carCost"),
                    "Diesel");
            compareCarsModelArrayList.add(compareCarsModel);

            recyclerCompare();

            appSharedPrefs = PreferenceManager
                    .getDefaultSharedPreferences(this.getApplicationContext());
            SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
            json = gson.toJson(compareCarsModel);
            Toast.makeText(this,json,Toast.LENGTH_SHORT).show();
            Log.v("put_json",json);
            prefsEditor.putString("MyObject", json);
            prefsEditor.commit();

        }

        else if(json == gson.toJson(compareCarsModel)) {
            Toast.makeText(this,"JSON IS NOT NULL",Toast.LENGTH_SHORT).show();
            CompareCarsModel compareCarsModel1 = gson.fromJson(json, CompareCarsModel.class);
            compareCarsModelArrayList.add(compareCarsModel1);

            compareCarsModel = new CompareCarsModel(R.drawable.car_image,
                    bun.getString("carName"), bun.getString("variantName"),
                    bun.getString("carCost"),
                    "Diesel");
            compareCarsModelArrayList.add(compareCarsModel);

            recyclerCompare();

        }
*/
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
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"RESUME",Toast.LENGTH_SHORT).show();

        /*SharedPreferences appSharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this.getApplicationContext());
        json = appSharedPrefs.getString("MyObject", "");
        Log.v("get_json",json);*/
        /*if(json == null) {
            appSharedPrefs = PreferenceManager
                    .getDefaultSharedPreferences(this.getApplicationContext());
            SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
            json = gson.toJson(compareCarsModel);
            Toast.makeText(this,json,Toast.LENGTH_SHORT).show();
            Log.v("json",json);
            prefsEditor.putString("MyObject", json);
            prefsEditor.commit();

        }*/
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Toast.makeText(this,"SAVE_INSTANCE_STATE",Toast.LENGTH_SHORT).show();
        savedInstanceState.putString(STATE_SCORE, json);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,CompareActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"RESTART",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"PAUSE",Toast.LENGTH_SHORT).show();

        /*CompareCarsModel compareCarsModel2 = new CompareCarsModel(R.drawable.car_image,
                bun.getString("carName"), bun.getString("variantName"),
                bun.getString("carCost"),
                "Diesel");*/

    }
}
