package com.example.youfeadaway.banmi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.youfeadaway.banmi.R;
import com.example.youfeadaway.banmi.adapter.Vp_Welcome_Adapter;
import com.example.youfeadaway.banmi.base.SimplActivity;
import com.example.youfeadaway.banmi.custom.PreviewIndicator;
import com.example.youfeadaway.banmi.utils.SpUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelComeActivity extends SimplActivity {


    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.pi)
    PreviewIndicator mPi;
    @BindView(R.id.btn)
    Button mBtn;

    @Override
    protected void initData() {

    }

    @Override
    protected void createView(View inflate) {
        View inflate1 = LayoutInflater.from(this).inflate(R.layout.layout_welcome_one, null);
        View inflate2 = LayoutInflater.from(this).inflate(R.layout.layout_welcome_two, null);
        View inflate3 = LayoutInflater.from(this).inflate(R.layout.layout_welcome_three, null);
        ArrayList<View> views = new ArrayList<>();
        views.add(inflate1);
        views.add(inflate2);
        views.add(inflate3);
        Vp_Welcome_Adapter vpAdapter = new Vp_Welcome_Adapter(views);
        mPi.initSize(80, 32, 6);
        mPi.setNumbers(3);

        mVp.setAdapter(vpAdapter);
        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2){
                    mPi.setVisibility(View.GONE);
                    mBtn.setVisibility(View.VISIBLE);
                }else{
                    mPi.setVisibility(View.VISIBLE);
                    mBtn.setVisibility(View.GONE);
                }
                mPi.setSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected int createLayout() {
        return R.layout.activity_wel_come;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        SpUtil.setParam("iscom",true);
        Intent intent = new Intent(WelComeActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
