package com.aritron.carconnect.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aritron.carconnect.R;
import com.aritron.carconnect.adapter.NewCarsPagerAdapter;
import com.aritron.carconnect.model.BrandModel;

/**
 * Created by Komal on 18-04-2017.
 */

public class NewCarsFragment extends Fragment {
    private View view;
    private TabLayout tablayout;
    private ViewPager viewpager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_new_cars, container, false);

        viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        setUpViewPager(viewpager);

        tablayout = (TabLayout) view.findViewById(R.id.tablayout);
        tablayout.setupWithViewPager(viewpager);

        return view;
    }

    private void setUpViewPager(ViewPager viewpager) {
        NewCarsPagerAdapter adapter = new NewCarsPagerAdapter(getActivity().getSupportFragmentManager());

        Bundle bundle1 =new Bundle();
        ByBrandFragment fragobj1 = ByBrandFragment.newInstance(bundle1);
        fragobj1.setArguments(bundle1);
        adapter.addFragment(fragobj1, "By Brand");

        Bundle bundle =new Bundle();
        ByPriceFragment fragobj = ByPriceFragment.newInstance(bundle);
        fragobj.setArguments(bundle);
        adapter.addFragment(fragobj, "By Price");

        viewpager.setAdapter(adapter);
    }
}
