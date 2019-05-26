package com.example.youfeadaway.banmi.activity;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class MainActivity extends SimplActivity {

    //5ce7f53b3fc195c17e0010b8

    @BindView(R.id.rel)
    RelativeLayout rel;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.bt1)
    RadioButton bt1;
    @BindView(R.id.bt2)
    RadioButton bt2;
    @BindView(R.id.bt3)
    RadioButton bt3;
    @BindView(R.id.bt4)
    RadioButton bt4;
    @BindView(R.id.rg)
    RadioGroup rg;

    private ArrayList<Fragment> fragments;

    @Override
    protected void initData() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bt1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.bt2:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.bt3:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.bt4:
                        vp.setCurrentItem(3);
                        break;
                }
            }
        });

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

    }

    @Override
    protected int createLayout() {
        return R.layout.activity_main;
    }


}
