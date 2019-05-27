package com.example.youfeadaway.banmi.activity.topactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.youfeadaway.banmi.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.guanyu)
    LinearLayout mGuanyu;
    @BindView(R.id.qingchu)
    LinearLayout mQingchu;
    @BindView(R.id.weixin)
    LinearLayout mWeixin;
    @BindView(R.id.weibo)
    LinearLayout mWeibo;
    @BindView(R.id.textsize)
    LinearLayout mTextsize;
    @BindView(R.id.tuichu)
    Button mTuichu;
    @BindView(R.id.shouji)
    LinearLayout mShouji;
    @BindView(R.id.wai)
    LinearLayout mWai;
    @BindView(R.id.text_xiao)
    TextView mTextXiao;
    private TextView mText;
    private TextView mText2;
    private TextView mText3;
    private TextView mQuxiao;
    private PopupWindow mPopupWindow;
    private RelativeLayout rlt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.guanyu, R.id.qingchu, R.id.weixin, R.id.weibo, R.id.textsize, R.id.tuichu, R.id.shouji})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.guanyu:

                break;
            case R.id.qingchu:
                break;
            case R.id.shouji:
                break;
            case R.id.weixin:
                break;
            case R.id.weibo:
                break;
            case R.id.textsize:
                popupwindows();
                break;
            case R.id.tuichu:
                break;

        }
    }

    private void popupwindows() {
        View inflate = LayoutInflater.from(SettingActivity.this).inflate(R.layout.layout_popup, null);
        mPopupWindow = new PopupWindow();
        mPopupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setContentView(inflate);
        mPopupWindow.setBackgroundDrawable(null);
        mPopupWindow.setOutsideTouchable(true);
        //创建PopupWindow时显示阴影
        WindowManager.LayoutParams window = this.getWindow().getAttributes();
        window.alpha = 0.7f;
        SettingActivity.this.getWindow().setAttributes(window);
        mPopupWindow.showAtLocation(mWai, Gravity.BOTTOM, 0, 0);
        mText = inflate.findViewById(R.id.text1);
        mText2 = inflate.findViewById(R.id.text2);
        mText3 = inflate.findViewById(R.id.text3);
        mQuxiao = inflate.findViewById(R.id.quxiao);
        rlt = inflate.findViewById(R.id.rlt);
        mText.setOnClickListener(this);
        mText2.setOnClickListener(this);
        mText3.setOnClickListener(this);
        mQuxiao.setOnClickListener(this);
        rlt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text1:
                String s = mText.getText().toString();
                mTextXiao.setText(s);
                mPopupWindow.dismiss();

                cancelPopupWindow();
                break;
            case R.id.text2:
                String s2 = mText2.getText().toString();
                mTextXiao.setText(s2);
                mPopupWindow.dismiss();
                cancelPopupWindow();
                break;
            case R.id.text3:
                String s3 = mText3.getText().toString();
                mTextXiao.setText(s3);
                mPopupWindow.dismiss();
                cancelPopupWindow();
                break;
            case R.id.quxiao:
                mPopupWindow.dismiss();
                cancelPopupWindow();
                break;
            case R.id.rlt:
                mPopupWindow.dismiss();
                cancelPopupWindow();
                break;
        }
    }

    private void cancelPopupWindow() {
        //取消PopupWindow时取消阴影
        WindowManager.LayoutParams window = this.getWindow().getAttributes();
        window.alpha = 1f;
        SettingActivity.this.getWindow().setAttributes(window);
    }
}
