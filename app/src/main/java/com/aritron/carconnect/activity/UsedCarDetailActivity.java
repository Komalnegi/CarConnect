package com.aritron.carconnect.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.aritron.carconnect.R;

public class UsedCarDetailActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView mToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_used_car_detail);

        toolbar = (Toolbar) findViewById(R.id.toolbar_used_car_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbarTitle = (TextView) findViewById(R.id.txt_toolbar_title);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
