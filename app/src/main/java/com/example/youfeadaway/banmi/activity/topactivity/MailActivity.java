package com.example.youfeadaway.banmi.activity.topactivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.youfeadaway.banmi.R;
import com.example.youfeadaway.banmi.adapter.VpAdapter;
import com.example.youfeadaway.banmi.adapter.Vp_informAdapter;
import com.example.youfeadaway.banmi.custom.CustomViewPager;
import com.example.youfeadaway.banmi.fragment.InFormFragment;
import com.example.youfeadaway.banmi.utils.TabIndicatorUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MailActivity extends AppCompatActivity {

    @BindView(R.id.iv_finish)
    ImageView mIvFinish;
    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    CustomViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dingwei);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new InFormFragment());
        fragments.add(new InFormFragment());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("通知");
        strings.add("消息");
        Vp_informAdapter vp_informAdapter = new Vp_informAdapter(getSupportFragmentManager(), fragments, strings);
        mVp.setAdapter(vp_informAdapter);
        mTab.setupWithViewPager(mVp);
        //TabLayout修改指示器长度
        mTab.post(new Runnable() {
            @Override
            public void run() {//
                mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        int position = tab.getPosition();
                        if (position == 0) {
                            new TabIndicatorUtils().setIndicator(mTab, 140, 20);
                        } else if (position == 1) {
                            new TabIndicatorUtils().setIndicator(mTab, 20, 120);
                        }
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });


            }
        });
    }

    @OnClick(R.id.iv_finish)
    public void onViewClicked() {
    }
}
