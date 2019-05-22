package com.example.youfeadaway.banmi.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.youfeadaway.banmi.R;
import com.example.youfeadaway.banmi.adapter.VpAdapter;
import com.example.youfeadaway.banmi.base.SimplActivity;
import com.example.youfeadaway.banmi.fragment.AFragment;
import com.example.youfeadaway.banmi.fragment.BFragment;
import com.example.youfeadaway.banmi.fragment.CFragment;
import com.example.youfeadaway.banmi.fragment.DFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends SimplActivity {


    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.rel)
    RelativeLayout rel;
    @BindView(R.id.vp)
    ViewPager vp;

    private ArrayList<Fragment> fragments;

    @Override
    protected void initData() {


    }

    @Override
    protected void createView(View inflate) {
        fragments = new ArrayList<>();
        fragments.add(new AFragment());
        fragments.add(new BFragment());
        fragments.add(new CFragment());
        fragments.add(new DFragment());
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(vpAdapter);
        tab.addTab(tab.newTab().setText(R.string.a).setIcon(R.drawable.select_a));
        tab.addTab(tab.newTab().setText(R.string.b).setIcon(R.drawable.select_b));
        tab.addTab(tab.newTab().setText(R.string.c).setIcon(R.drawable.select_c));
        tab.addTab(tab.newTab().setText(R.string.d).setIcon(R.drawable.selcet_d));
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
    }


    @Override
    protected int createLayout() {
        return R.layout.activity_main;
    }


}
