package com.example.youfeadaway.banmi.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.youfeadaway.banmi.R;
import com.example.youfeadaway.banmi.activity.MineActivity.AccountActivity;
import com.example.youfeadaway.banmi.activity.MineActivity.PersonActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class DFragment extends Fragment implements View.OnClickListener {


    private View view;
    private ImageView mIvBird;
    private RelativeLayout mRlLogin;
    private LinearLayout mLlMoney;

    public DFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_d, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mIvBird = (ImageView) inflate.findViewById(R.id.iv_bird);

        RequestOptions options = new RequestOptions().circleCrop();

        Glide.with(getActivity()).load(R.mipmap.bird).apply(options).into(mIvBird);
        mRlLogin = (RelativeLayout) inflate.findViewById(R.id.rl_login);
        mRlLogin.setOnClickListener(this);
        mLlMoney = (LinearLayout) inflate.findViewById(R.id.ll_money);
        mLlMoney.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rl_login:
                Intent intent = new Intent(getContext(), PersonActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_money:
                Intent intent1 = new Intent(getContext(), AccountActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
