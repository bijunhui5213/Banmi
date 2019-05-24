package com.example.youfeadaway.banmi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.youfeadaway.banmi.R;
import com.example.youfeadaway.banmi.base.SimplActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class C_ImgActivity extends SimplActivity {


    @BindView(R.id.img)
    ImageView img;

    @Override
    protected void initData() {
        Glide.with(this).load(R.drawable.img3288).into(img);
    }

    @Override
    protected void createView(View inflate) {
     img.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             finish();
         }
     });
    }

    @Override
    protected int createLayout() {
        return R.layout.activity_c__img;
    }


}
