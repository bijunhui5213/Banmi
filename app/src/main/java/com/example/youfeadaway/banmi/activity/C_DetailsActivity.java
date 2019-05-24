package com.example.youfeadaway.banmi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youfeadaway.banmi.R;
import com.example.youfeadaway.banmi.base.SimplActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class C_DetailsActivity extends SimplActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.img_tou)
    ImageView imgTou;
    @BindView(R.id.tv_banxiaomis)
    TextView tvBanxiaomis;
    @BindView(R.id.checkbox)
    CheckBox checkbox;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.tv_banxiaomi)
    TextView tvBanxiaomi;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.img_fengjing)
    ImageView imgFengjing;
    @BindView(R.id.tv_time)
    TextView tvTime;

    @Override
    protected void initData() {
        Glide.with(this).load(R.drawable.img3288).into(imgFengjing);
        Glide.with(this).load(R.mipmap.icon_me_kaquan_banmi1).circleCrop().into(img);
        Glide.with(this).load(R.mipmap.icon_me_kaquan_banmi1).circleCrop().into(imgTou);
    }

    @Override
    protected void createView(final View inflate) {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.back_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        imgFengjing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C_DetailsActivity.this, C_ImgActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int createLayout() {
        return R.layout.activity_c__details;
    }


}
