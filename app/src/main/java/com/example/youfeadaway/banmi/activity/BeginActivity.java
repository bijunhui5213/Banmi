package com.example.youfeadaway.banmi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.example.youfeadaway.banmi.R;
import com.example.youfeadaway.banmi.utils.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeginActivity extends AppCompatActivity {

    @BindView(R.id.iv_begin)
    ImageView mIvBegin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        //渐变动画，从1-1 ，
        AlphaAnimation animation = new AlphaAnimation(1, 1);
        animation.setDuration(2000);
        mIvBegin.startAnimation(animation);
        //动画监听
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            //动画结束后，跳转界面 达到跳跃效果
            @Override
            public void onAnimationEnd(Animation animation) {
                boolean iscom = (boolean) SpUtil.getParam("iscom", false);
                if (iscom) {
                    Intent intent = new Intent(BeginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(BeginActivity.this, WelComeActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
