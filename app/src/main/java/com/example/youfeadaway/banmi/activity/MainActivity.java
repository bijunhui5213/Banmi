package com.example.youfeadaway.banmi.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.youfeadaway.banmi.R;
import com.example.youfeadaway.banmi.activity.topactivity.MailActivity;
import com.example.youfeadaway.banmi.activity.topactivity.SettingActivity;
import com.example.youfeadaway.banmi.activity.topactivity.SouSuoActivity;
import com.example.youfeadaway.banmi.adapter.VpAdapter;
import com.example.youfeadaway.banmi.base.SimplActivity;
import com.example.youfeadaway.banmi.fragment.A.AFragment;
import com.example.youfeadaway.banmi.fragment.BFragment;
import com.example.youfeadaway.banmi.fragment.CFragment;
import com.example.youfeadaway.banmi.fragment.DFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @BindView(R.id.tv_dingwei)
    TextView mTvDingwei;
    @BindView(R.id.setting)
    ImageView mSetting;
    @BindView(R.id.edit)
    EditText mEdit;
    @BindView(R.id.lv_sousuo)
    LinearLayout mLvSousuo;
    @BindView(R.id.xinfeng)
    ImageView mXinfeng;

    private ArrayList<Fragment> fragments;

    @Override
    protected void initData() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bt1:
                        vp.setCurrentItem(0);
                        mLvSousuo.setVisibility(View.VISIBLE);
                        mTvDingwei.setVisibility(View.GONE);
                        mSetting.setVisibility(View.GONE);
                        break;
                    case R.id.bt2:
                        vp.setCurrentItem(1);
                        mLvSousuo.setVisibility(View.GONE);
                        mTvDingwei.setVisibility(View.VISIBLE);
                        mSetting.setVisibility(View.GONE);
                        break;
                    case R.id.bt3:
                        vp.setCurrentItem(2);
                        mLvSousuo.setVisibility(View.GONE);
                        mTvDingwei.setVisibility(View.GONE);
                        mSetting.setVisibility(View.GONE);
                        break;
                    case R.id.bt4:
                        vp.setCurrentItem(3);
                        mLvSousuo.setVisibility(View.GONE);
                        mTvDingwei.setVisibility(View.GONE);
                        mSetting.setVisibility(View.VISIBLE);
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

    @OnClick({R.id.tv_dingwei, R.id.setting, R.id.lv_sousuo, R.id.xinfeng})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lv_sousuo:
                startActivity(new Intent(MainActivity.this, SouSuoActivity.class));
                break;
            case R.id.tv_dingwei:
                Intent intent = new Intent(MainActivity.this, SouSuoActivity.class);
                startActivity(intent);
                break;
            case R.id.setting:
                Intent intent1 = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent1);
                break;
            case R.id.xinfeng:
                Intent intent2 = new Intent(MainActivity.this, MailActivity.class);
                startActivity(intent2);
                break;

        }
    }


}
