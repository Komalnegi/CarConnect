package com.aritron.carconnect.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aritron.carconnect.R;
import com.aritron.carconnect.model.BrandModel;
import com.aritron.carconnect.model.NewCars;
import com.aritron.carconnect.recycler.RcycleViewHandler;
import com.aritron.carconnect.recycler.RcycleViewLayoutItem;

import java.util.ArrayList;

public class NewCarsDetailActivity extends AppCompatActivity {
    private ArrayList<NewCars> newCarsArrayList = new ArrayList<>();
    private Toolbar toolbar;
    private TextView mToolbarTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_cars_detail);

        toolbar = (Toolbar) findViewById(R.id.toolbar_new_cars);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbarTitle = (TextView) findViewById(R.id.txt_toolbar_title);
        mToolbarTitle.setText("Maruti");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });


        setRecyclerView();

        NewCars brandModel = new NewCars(R.drawable.car_image,"Maruti Suzuki", "1248 CC","24.3 KMPL"
                ,"14,633 EMI","7.26-9.92 Lakh");
        newCarsArrayList.add(brandModel);
        brandModel = new NewCars(R.drawable.car_image,"Maruti Suzuki", "1248 CC","24.3 KMPL"
                ,"14,633 EMI","7.26-9.92 Lakh");
        newCarsArrayList.add(brandModel);brandModel = new NewCars(R.drawable.car_image,"Maruti Suzuki", "1248 CC","24.3 KMPL"
                ,"14,633 EMI","7.26-9.92 Lakh");
        newCarsArrayList.add(brandModel);brandModel = new NewCars(R.drawable.car_image,"Maruti Suzuki", "1248 CC","24.3 KMPL"
                ,"14,633 EMI","7.26-9.92 Lakh");
        newCarsArrayList.add(brandModel);brandModel = new NewCars(R.drawable.car_image,"Maruti Suzuki", "1248 CC","24.3 KMPL"
                ,"14,633 EMI","7.26-9.92 Lakh");
        newCarsArrayList.add(brandModel);brandModel = new NewCars(R.drawable.car_image,"Maruti Suzuki", "1248 CC","24.3 KMPL"
                ,"14,633 EMI","7.26-9.92 Lakh");
        newCarsArrayList.add(brandModel);
        brandModel = new NewCars(R.drawable.car_image,"Maruti Suzuki", "1248 CC","24.3 KMPL"
                ,"14,633 EMI","7.26-9.92 Lakh");
        newCarsArrayList.add(brandModel);
        brandModel = new NewCars(R.drawable.car_image,"Maruti Suzuki", "1248 CC","24.3 KMPL"
                ,"14,633 EMI","7.26-9.92 Lakh");
        newCarsArrayList.add(brandModel);
        brandModel = new NewCars(R.drawable.car_image,"Maruti Suzuki", "1248 CC","24.3 KMPL"
                ,"14,633 EMI","7.26-9.92 Lakh");
        newCarsArrayList.add(brandModel);
        brandModel = new NewCars(R.drawable.car_image,"Maruti Suzuki", "1248 CC","24.3 KMPL"
                ,"14,633 EMI","7.26-9.92 Lakh");
        newCarsArrayList.add(brandModel);
        brandModel = new NewCars(R.drawable.car_image,"Maruti Suzuki", "1248 CC","24.3 KMPL"
                ,"14,633 EMI","7.26-9.92 Lakh");
        newCarsArrayList.add(brandModel);

    }

    private void setRecyclerView() {
        RcycleViewLayoutItem carName = new RcycleViewLayoutItem<>("carName",
                R.id.txt_car_name,
                new RcycleViewLayoutItem.DisplayLayoutItem<NewCars>() {
                    @Override
                    public void displayLayoutItem(View view, NewCars model) {
                        ((TextView) view).setText(model.getName());
                    }
                },
                null);


        RcycleViewLayoutItem carImage = new RcycleViewLayoutItem<>("carImage",
                R.id.img_car,
                new RcycleViewLayoutItem.DisplayLayoutItem<NewCars>() {
                    @Override
                    public void displayLayoutItem(View view, NewCars model) {
                        ((ImageView) view).setImageResource(model.getImageView());
                    }
                },
                null);

        RcycleViewLayoutItem carCC = new RcycleViewLayoutItem<>("carCC",
                R.id.txt_car_cc,
                new RcycleViewLayoutItem.DisplayLayoutItem<NewCars>() {
                    @Override
                    public void displayLayoutItem(View view, NewCars model) {
                        ((TextView) view).setText(model.getCc());
                    }
                },
                null);

        RcycleViewLayoutItem carSpeed = new RcycleViewLayoutItem<>("carSpeed",
                R.id.txt_car_speed,
                new RcycleViewLayoutItem.DisplayLayoutItem<NewCars>() {
                    @Override
                    public void displayLayoutItem(View view, NewCars model) {
                        ((TextView) view).setText(model.getSpeed());
                    }
                },
                null);

        RcycleViewLayoutItem carCost = new RcycleViewLayoutItem<>("carCost",
                R.id.txt_car_cost,
                new RcycleViewLayoutItem.DisplayLayoutItem<NewCars>() {
                    @Override
                    public void displayLayoutItem(View view, NewCars model) {
                        ((TextView) view).setText(model.getCost());
                    }
                },
                null);

        RcycleViewLayoutItem carRate = new RcycleViewLayoutItem<>("carRate",
                R.id.txt_car_rate,
                new RcycleViewLayoutItem.DisplayLayoutItem<NewCars>() {
                    @Override
                    public void displayLayoutItem(View view, NewCars model) {
                        ((TextView) view).setText(model.getRate());
                    }
                },
                null);



        RcycleViewLayoutItem onClick = new RcycleViewLayoutItem<>("onClick",
                R.id.card_car_detail,
                null,
                new RcycleViewLayoutItem.LayoutItemClickListner<NewCars>() {
                    @Override
                    public void layoutItemOnClick(NewCars model) {
                        Intent intent = new Intent(NewCarsDetailActivity.this,CarDetailActivity.class);
                        startActivity(intent);
                    }
                });

        RcycleViewHandler rcView = new RcycleViewHandler<>(this,
                R.id.recyclerview_new_cars,
                R.layout.item_new_cars,
                newCarsArrayList);

        rcView.addLayoutItem(carName);
        rcView.addLayoutItem(carImage);
        rcView.addLayoutItem(carCC);
        rcView.addLayoutItem(carSpeed);
        rcView.addLayoutItem(carCost);
        rcView.addLayoutItem(carRate);
        rcView.addLayoutItem(onClick);

        rcView.render();
    }
}
