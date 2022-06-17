package com.hongik.project.graduation.store.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageButton;


import com.hongik.project.graduation.store.R;
import com.hongik.project.graduation.store.ui.fragment.CouponDealBoardFragment;
import com.hongik.project.graduation.store.ui.fragment.EventListFragment;
import com.hongik.project.graduation.store.ui.fragment.NaviContentFragment;
import com.hongik.project.graduation.store.ui.fragment.NaviHeaderFragment;
import com.hongik.project.graduation.store.ui.fragment.UserRecommendationFragment;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private DrawerLayout drawerLayout;
    private ImageButton menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment naviHeaderFragment = getSupportFragmentManager().findFragmentById(R.id.navigation_header_container);
        Fragment naviContentFragment = getSupportFragmentManager().findFragmentById(R.id.navigation_content_container);

        initMenuBar(naviHeaderFragment, naviContentFragment);

        menuButton = findViewById(R.id.menu_bar);
        drawerLayout = findViewById(R.id.drawer_layout);

        menuButton.setOnClickListener(view -> {

            if(!drawerLayout.isDrawerOpen(Gravity.LEFT)){
                drawerLayout.openDrawer(GravityCompat.START);
            } else {
                drawerLayout.closeDrawer(Gravity.LEFT);
            }

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");

        Fragment userRecommendationFragment = getSupportFragmentManager().findFragmentById(R.id.user_recommendation_fragment_container);
        Fragment eventListFragment = getSupportFragmentManager().findFragmentById(R.id.event_list_fragment_container);
        Fragment couponDealBoardFragment = getSupportFragmentManager().findFragmentById(R.id.coupon_deal_board_fragment_container);

        initMainContent(userRecommendationFragment, eventListFragment, couponDealBoardFragment);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");

    }

    private void initMainContent(Fragment userRecommendationFragment, Fragment eventListFragment, Fragment couponDealBoardFragment) {
        if(userRecommendationFragment == null){
            UserRecommendationFragment recommendationFragment = new UserRecommendationFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.user_recommendation_fragment_container, recommendationFragment)
                    .commit();
        }

        if(eventListFragment == null){
            Log.d(TAG, "eventListFragment create");
            EventListFragment eventFragment = new EventListFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.event_list_fragment_container, eventFragment)
                    .commit();
        }

        if(couponDealBoardFragment == null){
            CouponDealBoardFragment couponFragment = new CouponDealBoardFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.coupon_deal_board_fragment_container, couponFragment)
                    .commit();
        }
    }

    private void initMenuBar(Fragment naviHeaderFragment, Fragment naviContentFragment) {
        if(naviHeaderFragment == null){
            NaviHeaderFragment headerFragment = new NaviHeaderFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.navigation_header_container, headerFragment)
                    .commit();
        }

        if(naviContentFragment == null){
            NaviContentFragment contentFragment = new NaviContentFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.navigation_content_container, contentFragment)
                    .commit();
        }
    }

}