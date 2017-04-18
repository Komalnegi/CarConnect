package com.aritron.carconnect.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aritron.carconnect.R;
import com.aritron.carconnect.adapter.GridAdapter;
import com.aritron.carconnect.model.BrandModel;
import com.aritron.carconnect.model.ModelSelectionModel;
import com.aritron.carconnect.model.VariantModel;
import com.aritron.carconnect.recycler.RcycleViewHandler;
import com.aritron.carconnect.recycler.RcycleViewLayoutItem;

import java.util.ArrayList;

public class CompareActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ArrayList<ModelSelectionModel> modelSelectionModelArrayList = new ArrayList<>();
    private ArrayList<VariantModel> variantModelArrayList = new ArrayList<>();
    private ArrayList<BrandModel> brandModelArrayList = new ArrayList<>();
    private RecyclerView mBrandRecyclerView,mModelRecyclerView,mVariantRecyclerView;
    private View mBrandView,mModelView,mVariantView;
    private TextView mPopularBrand,mSelectModel,mSelectVariant,mToolbarTitle;
    private LinearLayout mOtherBrandLayout;
    private String mCarName,mVariantName,mcarCost,mCarFuel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        setUpUI();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mToolbarTitle.setText("Select Brand");

        setGridRecycler();


        BrandModel brandModel = new BrandModel("Maruti Suzuki", R.drawable.ic_maruti_suzuki);
        BrandModel brandModel1 = new BrandModel("Toyota", R.drawable.ic_toyota);
        BrandModel brandModel2 = new BrandModel("Hyundai", R.drawable.ic_hyundai);
        BrandModel brandModel3 = new BrandModel("Volkswagon", R.drawable.ic_volksvagon);
        BrandModel brandModel4 = new BrandModel("Tata", R.drawable.ic_tata);
        BrandModel brandModel5 = new BrandModel("Dutsun", R.drawable.ic_dustan);
        BrandModel brandModel6 = new BrandModel("Renault", R.drawable.ic_renault);
        BrandModel brandModel7 = new BrandModel("Audi", R.drawable.ic_audi);
        BrandModel brandModel8 = new BrandModel("Ford", R.drawable.ic_ford);
        BrandModel brandModel9 = new BrandModel("Honda", R.drawable.ic_honda);
        BrandModel brandModel10 = new BrandModel("Mahindra", R.drawable.ic_mahindra);
        BrandModel brandModel11 = new BrandModel("Nissan", R.drawable.ic_nissaan);

        brandModelArrayList.add(brandModel);
        brandModelArrayList.add(brandModel1);
        brandModelArrayList.add(brandModel2);
        brandModelArrayList.add(brandModel3);
        brandModelArrayList.add(brandModel4);
        brandModelArrayList.add(brandModel5);
        brandModelArrayList.add(brandModel6);
        brandModelArrayList.add(brandModel7);
        brandModelArrayList.add(brandModel8);
        brandModelArrayList.add(brandModel9);
        brandModelArrayList.add(brandModel10);
        brandModelArrayList.add(brandModel11);

        ModelSelectionModel modelSelectionModel = new ModelSelectionModel("Maruti Omni", "2.37-2.98 Lakh");
        ModelSelectionModel modelSelectionModel1 = new ModelSelectionModel("Maruti Omni", "2.37-2.98 Lakh");
        ModelSelectionModel modelSelectionModel2 = new ModelSelectionModel("Maruti Omni", "2.37-2.98 Lakh");
        ModelSelectionModel modelSelectionModel3 = new ModelSelectionModel("Maruti Omni", "2.37-2.98 Lakh");
        ModelSelectionModel modelSelectionModel4 = new ModelSelectionModel("Maruti Omni", "2.37-2.98 Lakh");
        ModelSelectionModel modelSelectionModel5 = new ModelSelectionModel("Maruti Omni", "2.37-2.98 Lakh");
        ModelSelectionModel modelSelectionModel6 = new ModelSelectionModel("Maruti Omni", "2.37-2.98 Lakh");
        ModelSelectionModel modelSelectionModel7 = new ModelSelectionModel("Maruti Omni", "2.37-2.98 Lakh");
        ModelSelectionModel modelSelectionModel8 = new ModelSelectionModel("Maruti Omni", "2.37-2.98 Lakh");

        modelSelectionModelArrayList.add(modelSelectionModel);
        modelSelectionModelArrayList.add(modelSelectionModel1);
        modelSelectionModelArrayList.add(modelSelectionModel2);
        modelSelectionModelArrayList.add(modelSelectionModel3);
        modelSelectionModelArrayList.add(modelSelectionModel4);
        modelSelectionModelArrayList.add(modelSelectionModel5);
        modelSelectionModelArrayList.add(modelSelectionModel6);
        modelSelectionModelArrayList.add(modelSelectionModel7);
        modelSelectionModelArrayList.add(modelSelectionModel8);

        VariantModel variantModel = new VariantModel("Maruti KWID", "2.37-2.98 Lakh");
        VariantModel variantModel1 = new VariantModel("Maruti Omni", "2.37-2.98 Lakh");
        VariantModel variantModel2 = new VariantModel("Maruti Omni", "2.37-2.98 Lakh");
        VariantModel variantModel3 = new VariantModel("Maruti Omni", "2.37-2.98 Lakh");
        VariantModel variantModel4 = new VariantModel("Maruti Omni", "2.37-2.98 Lakh");
        VariantModel variantModel5 = new VariantModel("Maruti Omni", "2.37-2.98 Lakh");
        VariantModel variantModel6 = new VariantModel("Maruti Omni", "2.37-2.98 Lakh");
        VariantModel variantModel7 = new VariantModel("Maruti Omni", "2.37-2.98 Lakh");
        VariantModel variantModel8 = new VariantModel("Maruti Omni", "2.37-2.98 Lakh");

        variantModelArrayList.add(variantModel);
        variantModelArrayList.add(variantModel1);
        variantModelArrayList.add(variantModel2);
        variantModelArrayList.add(variantModel3);
        variantModelArrayList.add(variantModel4);
        variantModelArrayList.add(variantModel5);
        variantModelArrayList.add(variantModel6);
        variantModelArrayList.add(variantModel7);
        variantModelArrayList.add(variantModel8);
    }

    private void setGridRecycler() {
        RcycleViewLayoutItem carName = new RcycleViewLayoutItem<>("carName",
                R.id.grid_text,
                new RcycleViewLayoutItem.DisplayLayoutItem<BrandModel>() {
                    @Override
                    public void displayLayoutItem(View view, BrandModel model) {
                        ((TextView) view).setText(model.getmCarName());
                    }
                },
                null);


        RcycleViewLayoutItem carImage = new RcycleViewLayoutItem<>("carImage",
                R.id.grid_image,
                new RcycleViewLayoutItem.DisplayLayoutItem<BrandModel>() {
                    @Override
                    public void displayLayoutItem(View view, BrandModel model) {
                        ((ImageView) view).setImageResource(model.getmCarImage());
                    }
                },
                null);

        RcycleViewLayoutItem onClick = new RcycleViewLayoutItem<>("onClick",
                R.id.lay_brand,
                null,
                new RcycleViewLayoutItem.LayoutItemClickListner<BrandModel>() {
                    @Override
                    public void layoutItemOnClick(BrandModel model) {
                        recyclerModelViewItem();
                        mModelRecyclerView.setVisibility(View.VISIBLE);
                        mBrandRecyclerView.setVisibility(View.INVISIBLE);
                        mBrandView.setVisibility(View.INVISIBLE);
                        mModelView.setVisibility(View.VISIBLE);
                        mSelectModel.setVisibility(View.VISIBLE);
                        mPopularBrand.setVisibility(View.INVISIBLE);
                        mOtherBrandLayout.setVisibility(View.GONE);
                        mToolbarTitle.setText("Select Model");
                        mCarName = model.getmCarName();
                    }
                });

        RcycleViewHandler rcView = new RcycleViewHandler<>(this,
                R.id.recyclerview_brand,
                R.layout.grid_single,
                brandModelArrayList);

        rcView.addLayoutItem(carName);
        rcView.addLayoutItem(carImage);
        rcView.addLayoutItem(onClick);

        rcView.renderGrid();
    }

    private void setUpUI() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_compare);
        //mGridLayout = (GridLayout) findViewById(R.id.grid);
        mModelRecyclerView = (RecyclerView)findViewById(R.id.recyclerview_model);
        mVariantRecyclerView = (RecyclerView)findViewById(R.id.recyclerview_variant);
        mBrandRecyclerView = (RecyclerView)findViewById(R.id.recyclerview_brand);
        mBrandView = (View) findViewById(R.id.view_brand);
        mModelView = (View)findViewById(R.id.view_brand);
        mVariantView = (View)findViewById(R.id.view_brand);
        mPopularBrand  = (TextView)findViewById(R.id.txt_popular_brands);
        mSelectModel  = (TextView)findViewById(R.id.txt_select_model);
        mSelectVariant  = (TextView)findViewById(R.id.txt_select_variant);
        mOtherBrandLayout = (LinearLayout)findViewById(R.id.lay_other_brand);
        mToolbarTitle = (TextView) findViewById(R.id.txt_toolbar_title);
    }

    private void recyclerModelViewItem() {
        RcycleViewLayoutItem modelName = new RcycleViewLayoutItem<>("modelName",
                R.id.txt_model_name,
                new RcycleViewLayoutItem.DisplayLayoutItem<ModelSelectionModel>() {
                    @Override
                    public void displayLayoutItem(View view, ModelSelectionModel model) {
                        ((TextView) view).setText(model.getmModelName());
                    }
                },
                null);


        RcycleViewLayoutItem modelCost = new RcycleViewLayoutItem<>("modelCost",
                R.id.txt_model_cost,
                new RcycleViewLayoutItem.DisplayLayoutItem<ModelSelectionModel>() {
                    @Override
                    public void displayLayoutItem(View view, ModelSelectionModel model) {
                        ((TextView) view).setText(model.getmModelCost());
                    }
                },
                null);

        RcycleViewLayoutItem onClick = new RcycleViewLayoutItem<>("onClick",
                R.id.lay_model,
                null,
                new RcycleViewLayoutItem.LayoutItemClickListner<ModelSelectionModel>() {
                    @Override
                    public void layoutItemOnClick(ModelSelectionModel model) {
                        recyclerVariantViewItem();
                        mVariantRecyclerView.setVisibility(View.VISIBLE);
                        mModelRecyclerView.setVisibility(View.INVISIBLE);
                        mBrandRecyclerView.setVisibility(View.INVISIBLE);
                        mBrandView.setVisibility(View.INVISIBLE);
                        mModelView.setVisibility(View.INVISIBLE);
                        mVariantView.setVisibility(View.VISIBLE);
                        mSelectVariant.setVisibility(View.VISIBLE);
                        mSelectModel.setVisibility(View.INVISIBLE);
                        mToolbarTitle.setText("Select Variant");
                        mcarCost = model.getmModelCost();
                    }
                });

        RcycleViewHandler rcView = new RcycleViewHandler<>(this,
                R.id.recyclerview_model,
                R.layout.card_model,
                modelSelectionModelArrayList);

        rcView.addLayoutItem(modelName);
        rcView.addLayoutItem(modelCost);
        rcView.addLayoutItem(onClick);

        rcView.render();
    }

    private void recyclerVariantViewItem() {
        final RcycleViewLayoutItem modelName = new RcycleViewLayoutItem<>("modelName",
                R.id.txt_variant_name,
                new RcycleViewLayoutItem.DisplayLayoutItem<VariantModel>() {
                    @Override
                    public void displayLayoutItem(View view, VariantModel model) {
                        ((TextView) view).setText(model.getName());
                    }
                },
                null);


        RcycleViewLayoutItem modelCost = new RcycleViewLayoutItem<>("modelCost",
                R.id.txt_variant_cost,
                new RcycleViewLayoutItem.DisplayLayoutItem<VariantModel>() {
                    @Override
                    public void displayLayoutItem(View view, VariantModel model) {
                        ((TextView) view).setText(model.getFeature());
                    }
                },
                null);

        RcycleViewLayoutItem onClick = new RcycleViewLayoutItem<>("onClick",
                R.id.lay_card_variant,
                null,
                new RcycleViewLayoutItem.LayoutItemClickListner<VariantModel>() {
                    @Override
                    public void layoutItemOnClick(VariantModel model) {
                        mVariantName = model.getName();
                        Intent intent = new Intent(CompareActivity.this,CompareCarsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("carName",mCarName);
                        bundle.putString("variantName",mVariantName);
                        bundle.putString("carCost",mcarCost);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });

        RcycleViewHandler rcView = new RcycleViewHandler<>(this,
                R.id.recyclerview_variant,
                R.layout.card_variant,
                variantModelArrayList);

        rcView.addLayoutItem(modelName);
        rcView.addLayoutItem(modelCost);
        rcView.addLayoutItem(onClick);

        rcView.render();
    }
}
