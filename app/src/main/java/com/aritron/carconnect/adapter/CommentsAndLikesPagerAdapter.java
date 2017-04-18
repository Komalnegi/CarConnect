package com.aritron.carconnect.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * Created by Komal on 10-04-2017.
 */

class CommentsAndLikesPagerAdapter extends FragmentPagerAdapter {
    private static final int TOTAL_TABS = 2;

    private String[] tabs = { "comments", "likes" };

    public CommentsAndLikesPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return new CommentsFragment();
        } else {
            return new LikesFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public int getCount() {
        return TOTAL_TABS;


    }
}
