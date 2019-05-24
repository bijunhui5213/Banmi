package com.example.youfeadaway.banmi.activity.MineActivity;

import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.youfeadaway.banmi.R;

public class ImgActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvBack;
    private ImageView mIvDian;
    private LinearLayout ll_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        initView();
    }

    private void initView() {
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mIvBack.setOnClickListener(this);
        mIvDian = (ImageView) findViewById(R.id.iv_dian);
        mIvDian.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_dian:
                final PopupWindow pw = new PopupWindow();
                View inflate = LayoutInflater.from(this).inflate(R.layout.pw_img, null);
                ll_pw = inflate.findViewById(R.id.ll_pw);
                pw.setContentView(inflate);
                pw.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                pw.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
                pw.setOutsideTouchable(true);
                pw.setBackgroundDrawable(new ColorDrawable());
                ll_pw.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pw.dismiss();
                    }
                });
                Button bt_cancel = inflate.findViewById(R.id.bt_cancel);
                bt_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pw.dismiss();
                    }
                });
                pw.showAsDropDown(ll_pw);

                break;
        }
    }





}
