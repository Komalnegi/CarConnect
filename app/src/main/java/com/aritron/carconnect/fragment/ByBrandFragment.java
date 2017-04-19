package com.aritron.carconnect.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aritron.carconnect.R;
import com.aritron.carconnect.activity.NewCarsDetailActivity;
import com.aritron.carconnect.model.BrandModel;
import com.aritron.carconnect.recycler.RcycleViewHandler;
import com.aritron.carconnect.recycler.RcycleViewLayoutItem;

import java.util.ArrayList;

/**
 * Created by Komal on 18-04-2017.
 */

public class ByBrandFragment extends Fragment {
    private View view;
    private ArrayList<BrandModel> brandModelArrayList = new ArrayList<>();

    public static ByBrandFragment newInstance(Bundle b) {
        ByBrandFragment fragment = new ByBrandFragment();
        fragment.setArguments(b);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_brand, container, false);

        setGridRecycler();

        setOtherRecycler();

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

        return view;
    }

    private void setOtherRecycler() {
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
                        Intent intent = new Intent(getContext(), NewCarsDetailActivity.class);
                        startActivity(intent);
                    }
                });

        RcycleViewHandler rcView = new RcycleViewHandler<>(view,
                R.id.recyclerview_other_brands_new_cars,
                R.layout.grid_single,
                brandModelArrayList);

        rcView.addLayoutItem(carName);
        rcView.addLayoutItem(carImage);
        rcView.addLayoutItem(onClick);

        rcView.renderGridView(view);
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
                        Intent intent = new Intent(getContext(), NewCarsDetailActivity.class);
                        startActivity(intent);
                    }
                });

        RcycleViewHandler rcView = new RcycleViewHandler<>(view,
                R.id.recyclerview_brand_new_cars,
                R.layout.grid_single,
                brandModelArrayList);

        rcView.addLayoutItem(carName);
        rcView.addLayoutItem(carImage);
        rcView.addLayoutItem(onClick);

        rcView.renderGridView(view);
    }
}
