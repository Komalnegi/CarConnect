package com.aritron.carconnect.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aritron.carconnect.R;
import com.aritron.carconnect.model.ClassifiedModel;
import com.aritron.carconnect.model.LatestNewsModel;
import com.aritron.carconnect.recycler.RcycleViewHandler;
import com.aritron.carconnect.recycler.RcycleViewLayoutItem;

import java.util.ArrayList;

public class ClassifiedActivity extends AppCompatActivity {
    private ArrayList<ClassifiedModel> classifiedModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classified);

        ClassifiedModel classifiedModel = new ClassifiedModel(R.drawable.default_car_image,"Samsung",
                "Description","18000");
        ClassifiedModel classifiedModel1 = new ClassifiedModel(R.drawable.default_car_image,"Samsung",
                "Description","18000");

        classifiedModels.add(classifiedModel);
        classifiedModels.add(classifiedModel1);

        recyclerViewItem();
    }

    private void recyclerViewItem() {
        RcycleViewLayoutItem image = new RcycleViewLayoutItem<>("image",
                R.id.image_classified,
                new RcycleViewLayoutItem.DisplayLayoutItem<ClassifiedModel>() {
                    @Override
                    public void displayLayoutItem(View view, ClassifiedModel model) {
                        ((ImageView) view).setBackgroundResource(model.getImage());
                    }
                },
                null);


        RcycleViewLayoutItem name = new RcycleViewLayoutItem<>("name",
                R.id.txt_classified_name,
                new RcycleViewLayoutItem.DisplayLayoutItem<ClassifiedModel>() {
                    @Override
                    public void displayLayoutItem(View view, ClassifiedModel model) {
                        ((TextView) view).setText(model.getName());
                    }
                },
                null);

        RcycleViewLayoutItem desc = new RcycleViewLayoutItem<>("desc",
                R.id.txt_classified_desc,
                new RcycleViewLayoutItem.DisplayLayoutItem<ClassifiedModel>() {
                    @Override
                    public void displayLayoutItem(View view, ClassifiedModel model) {
                        ((TextView) view).setText(model.getDesc());
                    }
                },
                null);
        RcycleViewLayoutItem price = new RcycleViewLayoutItem<>("price",
                R.id.txt_classified_price,
                new RcycleViewLayoutItem.DisplayLayoutItem<ClassifiedModel>() {
                    @Override
                    public void displayLayoutItem(View view, ClassifiedModel model) {
                        ((TextView) view).setText(model.getPrice());
                    }
                },
                null);

        RcycleViewHandler rcView = new RcycleViewHandler<>(ClassifiedActivity.this,
                R.id.recyclerview_classified,
                R.layout.card,
                classifiedModels);

        rcView.addLayoutItem(image);
        rcView.addLayoutItem(name);
        rcView.addLayoutItem(desc);
        rcView.addLayoutItem(price);

        rcView.render();
    }
}
