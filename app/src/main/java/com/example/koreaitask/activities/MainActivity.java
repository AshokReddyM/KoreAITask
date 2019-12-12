package com.example.koreaitask.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.koreaitask.R;
import com.example.koreaitask.adapters.ViewPagerAdapter;
import com.example.koreaitask.custom_classes.CustomBottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn_open_sheet)
    Button btnOpenSheet;

    @BindView(R.id.fl_bottom_sheet)
    FrameLayout bottomSheet;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.vp_pager)
    ViewPager mPager;

    private CustomBottomSheetBehavior<FrameLayout> behavior;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().setElevation(0);

        behavior = CustomBottomSheetBehavior.from(bottomSheet);
        mPager.setAdapter(new ViewPagerAdapter(this.getSupportFragmentManager()));
        tabLayout.setupWithViewPager(mPager);

        behavior.setHideable(true);
        behavior.setPeekHeight(0);
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        mPager.addOnAdapterChangeListener((viewPager, oldAdapter, newAdapter) -> {

        });


    }

    @OnClick(R.id.btn_open_sheet)
    public void onClickOpenSheet() {
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);

    }

    public void allowDragging(boolean canDragging){
        behavior.setAllowDragging(canDragging);
    }





}