package com.example.youfeadaway.banmi.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.youfeadaway.banmi.R;
import com.example.youfeadaway.banmi.base.SimplActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends SimplActivity {
    @BindView(R.id.bt_login_wb)
    Button btLoginWb;
    @BindView(R.id.bt_login_wechat)
    Button btLoginWechat;
    @BindView(R.id.bt_login_phone)
    Button btLoginPhone;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv_agreement)
    TextView tvAgreement;
    @BindView(R.id.tv_gg)
    TextView tvGg;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.rell)
    RelativeLayout rel;

    @Override
    protected void initData() {

    }

    @Override
    protected void createView(View inflate) {
        tvAgreement.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    }

    @Override
    protected int createLayout() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.bt_login_wb, R.id.bt_login_wechat, R.id.bt_login_phone, R.id.tv_agreement, R.id.tv_gg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_login_wb:
                break;
            case R.id.bt_login_wechat:
                break;
            case R.id.bt_login_phone:
                showPopup();
                break;
            case R.id.tv_agreement:
                break;
            case R.id.tv_gg:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void showPopup() {
        View view = LayoutInflater.from(this).inflate(R.layout.auto_popup, null);

        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


        popupWindow.setFocusable(true);
       /* popupWindow.setBackgroundDrawable(null);
        popupWindow.setOutsideTouchable(false);*/

        popupWindow.showAsDropDown(tv2,0,150);






    }
}
