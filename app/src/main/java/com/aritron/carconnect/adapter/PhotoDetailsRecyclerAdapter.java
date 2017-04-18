package com.aritron.carconnect.adapter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aritron.carconnect.R;

/**
 * Created by Komal on 10-04-2017.
 */

public class PhotoDetailsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private FragmentManager fragmentManager;

    public PhotoDetailsRecyclerAdapter(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_new_cars, parent, false);
        return new CommentsAndLikesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class CommentsAndLikesViewHolder extends RecyclerView.ViewHolder {
        private ViewPager viewpager;
        private TabLayout tablayout;

        public CommentsAndLikesViewHolder(View view) {
            super(view);

            tablayout = (TabLayout) view.findViewById(R.id.tablayout_profile);
            viewpager = (ViewPager) view.findViewById(R.id.recycler_view_photo_details);
            viewpager.setAdapter(new CommentsAndLikesPagerAdapter(fragmentManager));

            /*slidingTabLayout.setDistributeEvenly(true);
            tablayout.setViewPager(viewPager);*/
        }
    }
}
