package com.example.youfeadaway.banmi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
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
    private PopupWindow popupWindow;

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
                View inflate1 = LayoutInflater.from(C_DetailsActivity.this).inflate(R.layout.activity_c__img, null);
                RelativeLayout rl = inflate1.findViewById(R.id.rl);
                ImageView imgs = inflate1.findViewById(R.id.imgs);
                Glide.with(C_DetailsActivity.this).load(R.drawable.img3288).into(imgs);

                popupWindow = new PopupWindow();
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.setContentView(inflate1);
                popupWindow.setBackgroundDrawable(null);
                popupWindow.setOutsideTouchable(true);

                popupWindow.showAsDropDown(imgs, Gravity.CENTER_VERTICAL, 0, 0);
                rl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
            }
        });
    }

    @Override
    protected int createLayout() {
        return R.layout.activity_c__details;
    }


}
