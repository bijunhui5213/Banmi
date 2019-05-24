package com.example.youfeadaway.banmi.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youfeadaway.banmi.R;
import com.example.youfeadaway.banmi.activity.C_DetailsActivity;
import com.example.youfeadaway.banmi.activity.C_ImgActivity;
import com.example.youfeadaway.banmi.base.SimplFragment;

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

    @Override
    protected void initData() {
        Glide.with(getActivity()).load(R.drawable.img3288).into(imgFengjing);
        Glide.with(getActivity()).load(R.mipmap.icon_me_kaquan_banmi1).circleCrop().into(img);
    }

    @Override
    protected void createView(View inflate) {
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
                Intent intent = new Intent(getActivity(), C_ImgActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int createLayout() {
        return R.layout.fragment_c;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
