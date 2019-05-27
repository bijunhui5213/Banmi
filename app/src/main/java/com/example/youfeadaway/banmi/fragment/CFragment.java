package com.example.youfeadaway.banmi.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youfeadaway.banmi.R;
import com.example.youfeadaway.banmi.activity.C_DetailsActivity;
import com.example.youfeadaway.banmi.activity.topactivity.SettingActivity;
import com.example.youfeadaway.banmi.base.SimplFragment;

import java.nio.file.Path;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CFragment extends SimplFragment {


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
    Unbinder unbinder;
    @BindView(R.id.lin)
    LinearLayout lin;
    private PopupWindow popupWindow;

    @Override
    protected void initData() {
        Glide.with(getActivity()).load(R.drawable.img3288).into(imgFengjing);
        Glide.with(getActivity()).load(R.mipmap.icon_me_kaquan_banmi1).circleCrop().into(img);
    }

    @Override
    protected void createView(final View inflate) {
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), C_DetailsActivity.class);
                startActivity(intent);
            }
        });


        imgFengjing.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                View inflate1 = LayoutInflater.from(getActivity()).inflate(R.layout.activity_c__img, null);
                RelativeLayout rl = inflate1.findViewById(R.id.rl);
                ImageView imgs = inflate1.findViewById(R.id.imgs);
                Glide.with(getActivity()).load(R.drawable.img3288).into(imgs);


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
        return R.layout.fragment_c;
    }


}
