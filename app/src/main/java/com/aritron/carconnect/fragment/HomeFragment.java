package com.aritron.carconnect.fragment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aritron.carconnect.R;
import com.aritron.carconnect.activity.ViewNewCarsActivity;
import com.aritron.carconnect.adapter.CardsAdapter;
import com.aritron.carconnect.adapter.MyViewPagerAdapter;
import com.aritron.carconnect.model.Card;
import com.aritron.carconnect.model.LatestNewsModel;
import com.aritron.carconnect.recycler.RcycleViewHandler;
import com.aritron.carconnect.recycler.RcycleViewLayoutItem;

import java.util.ArrayList;

import in.arjsna.swipecardlib.SwipeCardView;

/**
 * Created by Komal on 06-04-2017.
 */

public class HomeFragment extends Fragment implements View.OnClickListener{
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private TextView mNewCar ,mNewComparison;
    private int[] layouts;
    private ArrayList<Card> al,a2,a3;
    private CardsAdapter arrayAdapter;
    public SwipeCardView swipeCardView_new_car,swipeCardView_used_car,swipeCardView_new_comparison;
    private ArrayList<LatestNewsModel> latestNewsModels = new ArrayList<>();
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.frag_home, container, false);

        LatestNewsModel latestNewsModel = new LatestNewsModel(R.drawable.ic_car_mer,"Toyota",
                "18 March 2017");
        LatestNewsModel latestNewsModel1 = new LatestNewsModel(R.drawable.ic_car_mer,"Toyota",
                "18 March 2017");

        latestNewsModels.add(latestNewsModel);
        latestNewsModels.add(latestNewsModel1);

        recyclerViewItem();

        mNewComparison = (TextView)view.findViewById(R.id.txt_new_comparison);
        mNewComparison.setOnClickListener(this);

        mNewCar = (TextView)view.findViewById(R.id.txt_new_car);
        mNewCar.setOnClickListener(this);

        viewPager = (ViewPager) view.findViewById(R.id.view_pager);

        dotsLayout = (LinearLayout) view.findViewById(R.id.layoutDots);

        layouts = new int[]{
                R.layout.slide1,
                R.layout.slide2,
                R.layout.slide3,
                R.layout.slide4};

        // adding bottom dots
        addBottomDots(0);

        myViewPagerAdapter = new MyViewPagerAdapter(getActivity(),layouts);
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);


        al = new ArrayList<>();
        getDummyData(al);
        arrayAdapter = new CardsAdapter(getActivity(), al);

        swipeCardView_new_car = (SwipeCardView)view.findViewById(R.id.swipe_card_view_popular_new_cars);
        swipeCardView_new_car.setAdapter(arrayAdapter);
        swipeCardView_new_car.setFlingListener(new SwipeCardView.OnCardFlingListener() {
            @Override public void onCardExitLeft(Object dataObject) {
                //makeToast(CardSwipeActivity.this, "Left!");
            }

            @Override public void onCardExitRight(Object dataObject) {
                //makeToast(CardSwipeActivity.this, "Right!");
            }

            @Override public void onAdapterAboutToEmpty(int itemsInAdapter) {

            }

            @Override public void onScroll(float scrollProgressPercent) {

            }

            @Override public void onCardExitTop(Object dataObject) {
                //makeToast(CardSwipeActivity.this, "Top!");
            }

            @Override public void onCardExitBottom(Object dataObject) {
                //makeToast(CardSwipeActivity.this, "Bottom!");
            }
        });

        // Optionally add an OnItemClickListener
        swipeCardView_new_car.setOnItemClickListener(new SwipeCardView.OnItemClickListener() {
            @Override public void onItemClicked(int itemPosition, Object dataObject) {
                //makeToast(CardSwipeActivity.this, String.valueOf(swipeCardView_new_car.getCurrentPosition()));
            }
        });


        a2 = new ArrayList<>();
        getDummyData(a2);
        arrayAdapter = new CardsAdapter(getActivity(), a2);

        swipeCardView_used_car = (SwipeCardView)view.findViewById(R.id.swipe_card_view_popular_used_cars);
        swipeCardView_used_car.setAdapter(arrayAdapter);
        swipeCardView_used_car.setFlingListener(new SwipeCardView.OnCardFlingListener() {
            @Override public void onCardExitLeft(Object dataObject) {
                //makeToast(CardSwipeActivity.this, "Left!");
            }

            @Override public void onCardExitRight(Object dataObject) {
                //makeToast(CardSwipeActivity.this, "Right!");
            }

            @Override public void onAdapterAboutToEmpty(int itemsInAdapter) {

            }

            @Override public void onScroll(float scrollProgressPercent) {

            }

            @Override public void onCardExitTop(Object dataObject) {
                //makeToast(CardSwipeActivity.this, "Top!");
            }

            @Override public void onCardExitBottom(Object dataObject) {
                //makeToast(CardSwipeActivity.this, "Bottom!");
            }
        });

        // Optionally add an OnItemClickListener
        swipeCardView_used_car.setOnItemClickListener(new SwipeCardView.OnItemClickListener() {
            @Override public void onItemClicked(int itemPosition, Object dataObject) {
                //makeToast(CardSwipeActivity.this, String.valueOf(swipeCardView_new_car.getCurrentPosition()));
            }
        });

        a3 = new ArrayList<>();
        getDummyData(a3);
        arrayAdapter = new CardsAdapter(getActivity(), a3);

        swipeCardView_new_comparison = (SwipeCardView)view.findViewById(R.id.swipe_card_view_new_comparison);
        swipeCardView_new_comparison.setAdapter(arrayAdapter);
        swipeCardView_new_comparison.setFlingListener(new SwipeCardView.OnCardFlingListener() {
            @Override public void onCardExitLeft(Object dataObject) {
                //makeToast(CardSwipeActivity.this, "Left!");
            }

            @Override public void onCardExitRight(Object dataObject) {
                //makeToast(CardSwipeActivity.this, "Right!");
            }

            @Override public void onAdapterAboutToEmpty(int itemsInAdapter) {

            }

            @Override public void onScroll(float scrollProgressPercent) {

            }

            @Override public void onCardExitTop(Object dataObject) {
                //makeToast(CardSwipeActivity.this, "Top!");
            }

            @Override public void onCardExitBottom(Object dataObject) {
                //makeToast(CardSwipeActivity.this, "Bottom!");
            }
        });

        // Optionally add an OnItemClickListener
        swipeCardView_new_comparison.setOnItemClickListener(new SwipeCardView.OnItemClickListener() {
            @Override public void onItemClicked(int itemPosition, Object dataObject) {
                //makeToast(CardSwipeActivity.this, String.valueOf(swipeCardView_new_car.getCurrentPosition()));
            }
        });
        return view;
    }

    private void recyclerViewItem() {
        RcycleViewLayoutItem car_image = new RcycleViewLayoutItem<>("car_image",
                R.id.img_car_latest_news,
                new RcycleViewLayoutItem.DisplayLayoutItem<LatestNewsModel>() {
                    @Override
                    public void displayLayoutItem(View view, LatestNewsModel model) {
                        ((ImageView) view).setBackgroundResource(model.getCar_image());
                    }
                },
                null);


        RcycleViewLayoutItem car_name = new RcycleViewLayoutItem<>("car_name",
                R.id.txt_car_name_latest_news,
                new RcycleViewLayoutItem.DisplayLayoutItem<LatestNewsModel>() {
                    @Override
                    public void displayLayoutItem(View view, LatestNewsModel model) {
                        ((TextView) view).setText(model.getCar_name());
                    }
                },
                null);

        RcycleViewLayoutItem news_date = new RcycleViewLayoutItem<>("news_date",
                R.id.txt_news_date,
                new RcycleViewLayoutItem.DisplayLayoutItem<LatestNewsModel>() {
                    @Override
                    public void displayLayoutItem(View view, LatestNewsModel model) {
                        ((TextView) view).setText(model.getNews_date());
                    }
                },
                null);

        RcycleViewHandler rcView = new RcycleViewHandler<>(view,
                R.id.recyclerview_latest_news,
                R.layout.item_latest_news,
                latestNewsModels);

        rcView.addLayoutItem(car_image);
        rcView.addLayoutItem(car_name);
        rcView.addLayoutItem(news_date);

        rcView.render(view);
    }

    private void getDummyData(ArrayList<Card> al) {
        Card card = new Card();
        card.name = "Card1";
        card.imageId = R.drawable.ic_car_mer;
        al.add(card);

        Card card2 = new Card();
        card2.name = "Card2";
        card2.imageId = R.drawable.ic_car_mer;
        al.add(card2);
        Card card3 = new Card();
        card3.name = "Card3";
        card3.imageId = R.drawable.ic_car_mer;
        al.add(card3);
        Card card4 = new Card();
        card4.name = "Card4";
        card4.imageId = R.drawable.ic_car_mer;
        al.add(card4);
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getActivity());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
            } else {
                // still pages are left
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.txt_new_car:
                Intent intent = new Intent(getActivity(),ViewNewCarsActivity.class);
                startActivity(intent);
                break;

            case R.id.txt_new_comparison:
                CompareFragment compareFragment = new CompareFragment();
                android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_frame,compareFragment);
                transaction.commit();
                break;
        }

    }
}
