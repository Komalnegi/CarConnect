package com.aritron.carconnect.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.aritron.carconnect.R;
import com.aritron.carconnect.adapter.NavDrawerAdapter;
import com.aritron.carconnect.model.NavDrawerItem;

import java.util.ArrayList;
import java.util.List;


public class NavDrawerFragment extends Fragment {

    private static String[] titles = null;

    private RecyclerView recyclerView;
    private NavDrawerAdapter adapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private FragmentDrawerListener drawerListener;
    private View containerView;

    private static final int[] navTitleIcon = new int[]{R.drawable.ic_home, R.drawable.ic_home,
            R.drawable.ic_home, R.drawable.ic_home, R.drawable.ic_home, R.drawable.ic_home,
            R.drawable.ic_home,R.drawable.ic_home, R.drawable.ic_home};

    public NavDrawerFragment() {
        super();
    }

    public void setDrawerListener(FragmentDrawerListener listener) {
        this.drawerListener = listener;
    }

    public interface FragmentDrawerListener {
        public void onDrawerItemSelected(View view, int position);
    }

    public static List<NavDrawerItem> getData() {

        List<NavDrawerItem> data = new ArrayList<NavDrawerItem>();

        // preparing navigation drawer items

        for (int i = 0; i < titles.length; i++) {
            NavDrawerItem navItem = new NavDrawerItem();
            navItem.setNavItem(titles[i]);
            navItem.setIconId(navTitleIcon[i]);
            data.add(navItem);
        }

        return data;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        titles = getActivity().getResources().getStringArray(R.array.nav_drawer_item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);

        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);
        adapter = new NavDrawerAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {

            @Override
            public void onLongClick(View view, int position) {

            }

            @Override
            public void onClick(View view, int position) {
                drawerListener.onDrawerItemSelected(view, position);
                mDrawerLayout.closeDrawer(containerView);
            }
        }));

        return layout;
    }



    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {

        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, R.string.drawer_open,
                R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                toolbar.setAlpha(1 - slideOffset / 2);
            }

            @Override
            public void onConfigurationChanged(Configuration newConfig) {
                super.onConfigurationChanged(newConfig);
                mDrawerToggle.onConfigurationChanged(newConfig);
            }

        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                // Sync the toggle state after onRestoreInstanceState has
                // occurred.
                mDrawerToggle.syncState();
            }
        });
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private ClickListener clickListener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView,
                                     final ClickListener clickListener) {

            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent me) {
            View child = recyclerView.findChildViewUnder(me.getX(), me.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(me)) {
                clickListener.onClick(child, recyclerView.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean arg0) {

        }

        @Override
        public void onTouchEvent(RecyclerView arg0, MotionEvent arg1) {

        }

    }

    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }
}
