package com.aritron.carconnect.activity;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aritron.carconnect.R;
import com.aritron.carconnect.adapter.ExpandableListAdapter;
import com.aritron.carconnect.fragment.CompareFragment;
import com.aritron.carconnect.fragment.HomeFragment;
import com.aritron.carconnect.fragment.NavDrawerFragment;
import com.aritron.carconnect.fragment.NewCarsFragment;
import com.aritron.carconnect.fragment.TestFragment;
import com.aritron.carconnect.fragment.UsedCarsFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements NavDrawerFragment.FragmentDrawerListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    Toolbar toolbar;
    private NavDrawerFragment drawerFragment;
    private DrawerLayout drawerLayout;
    private LinearLayout toplayout;
    int i = 0;
    private boolean doubleBackToExitPressedOnce;
    private Handler mHandler = new Handler();
    private TextView txt_title;
    private String flag;
    private LinearLayout mHeaderLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        toplayout = (LinearLayout)findViewById(R.id.lay_main);
        mHeaderLayout = (LinearLayout)findViewById(R.id.lay_header);

        setToolbar();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    /*
     * setting up toolbar
     */
    private void setToolbar() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // getSupportActionBar().setHomeButtonEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawerFragment = (NavDrawerFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_navigation_drawer);

        drawerFragment.setUp(R.id.fragment_navigation_drawer, drawerLayout, toolbar);

        drawerFragment.setDrawerListener(this);


        try{
            if (flag.equals("make_quotation")) {
                displayView(2);
            }else{
                displayView(0);
            }
        }catch (Exception e){
            displayView(0);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        Log.d("TEST", "Menu item is selected");

        if (item.getItemId() == android.R.id.home) {

            if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                drawerLayout.closeDrawer(Gravity.LEFT);
            } else {
                drawerLayout.openDrawer(Gravity.LEFT);
            }

        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        Log.d("TEST", "drawer item selected is called");

        displayView(position);

    }

    private void displayView(int position) {

        Fragment fragment = null;
        String title = getString(R.string.app_name);

        switch (position) {

            case 0:
                // pi
                fragment = new HomeFragment();
                title = getResources().getString(R.string.app_name);
                Log.d("TEST", "title is " + title);
                i = 0;
                break;

            case 1:

                i = 0;
                break;

            case 2:
                fragment = new NewCarsFragment();
                title = getResources().getString(R.string.search_new_cars);
                mHeaderLayout.setVisibility(View.GONE);
                i = 0;
                break;

            case 3:
                fragment = new UsedCarsFragment();
                title = getResources().getString(R.string.search_new_cars);
                mHeaderLayout.setVisibility(View.GONE);
                i = 0;
                break;

            case 5:
                fragment = new CompareFragment();
                title = getResources().getString(R.string.app_name);
                Log.d("TEST", "title is " + title);
                i = 0;
                break;

            case 11:

                this.finish();
                break;


            default:
                break;
        }

        if (fragment != null) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_frame, fragment);
            // fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            // set the toolbar title

            getSupportActionBar().setTitle(title);
        }
    }


    @Override
    public void onBackPressed() {

        Fragment fragment = null;
        //	String title = getString(R.string.app_name);
        fragment = new HomeFragment();
        String title = getResources().getString(R.string.app_name);

        if (i == 1) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager
                    .beginTransaction();
            fragmentTransaction.replace(R.id.fragment_frame, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            toolbar.setTitle(title);


            i = 0;


        } else {
            /*Handle backpress exit from application*/
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Snackbar.make(toplayout, "Please click BACK again to exit", Snackbar.LENGTH_LONG).show();

            mHandler.postDelayed(mRunnable, 2000);
        }
    }

    private final Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            doubleBackToExitPressedOnce = false;
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mHandler != null) {
            mHandler.removeCallbacks(mRunnable);
        }
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_fav) {
            Toast.makeText(MainActivity.this, "Favourite is Selected", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.menu_search) {
            Toast.makeText(MainActivity.this, "Search is Selected", Toast.LENGTH_SHORT).show();
            return true;
        }

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
