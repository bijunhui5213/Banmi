package com.example.youfeadaway.banmi.activity.MineActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.youfeadaway.banmi.R;
import com.example.youfeadaway.banmi.utils.SpUtil;

public class PersonActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvBack;
    private RelativeLayout mRlImg;
    private RelativeLayout mRlUsername;
    private RelativeLayout mRlSex;
    private RelativeLayout mRlQianming;
    /**
     * wechat
     */
    private TextView mTvUsername;
    /**
     * 未填写
     */
    private TextView mTvQianming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        initView();
    }

    private void initView() {
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mIvBack.setOnClickListener(this);
        mRlImg = (RelativeLayout) findViewById(R.id.rl_img);
        mRlImg.setOnClickListener(this);
        mRlUsername = (RelativeLayout) findViewById(R.id.rl_username);
        mRlUsername.setOnClickListener(this);
        mRlSex = (RelativeLayout) findViewById(R.id.rl_sex);
        mRlSex.setOnClickListener(this);
        mRlQianming = (RelativeLayout) findViewById(R.id.rl_qianming);
        mRlQianming.setOnClickListener(this);
        mTvUsername = (TextView) findViewById(R.id.tv_username);
        mTvQianming = (TextView) findViewById(R.id.tv_qianming);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_img:
                Intent intent2 = new Intent(this, ImgActivity.class);
                startActivity(intent2);
                break;
            case R.id.rl_username:
                String name = mTvUsername.getText().toString();
                Intent intent = new Intent(this, UpNameActivity.class);
                intent.putExtra("name", name);
                startActivityForResult(intent, 1);
                break;
            case R.id.rl_sex:
                break;
            case R.id.rl_qianming:
                String qianming = mTvQianming.getText().toString();
                Intent intent1 = new Intent(this, UpQianMingActivity.class);
                intent1.putExtra("qianming", qianming);
                startActivityForResult(intent1, 3);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == 2) {
            String upname = data.getStringExtra("upname");
            SpUtil.getParam("upname", upname);
            mTvUsername.setText(upname);
        }
        if (requestCode == 3 && resultCode == 4) {
            String upqian = data.getStringExtra("upqian");
            SpUtil.getParam("upqian", upqian);
            mTvQianming.setText(upqian);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
