package com.example.youfeadaway.banmi.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.youfeadaway.banmi.R;
import com.example.youfeadaway.banmi.base.SimplActivity;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

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

    private static final String TAG = "LoginActivity";

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
                login(SHARE_MEDIA.SINA);
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

    private void login(SHARE_MEDIA type) {
        UMShareAPI umShareAPI = UMShareAPI.get(this);
        umShareAPI.getPlatformInfo(this, type, umAuthListener);
    }
    UMAuthListener umAuthListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            for (Map.Entry<String, String> entry:data.entrySet()){
                String key = entry.getKey();
                String value = entry.getValue();
                Log.d(TAG, "key: "+key+",value:"+value);

            }
            Toast.makeText(LoginActivity.this, "成功了", Toast.LENGTH_LONG).show();

        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(LoginActivity.this, "失败：" + t.getMessage(),                                     Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(LoginActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };

    private void showPopup() {
        View view = LayoutInflater.from(this).inflate(R.layout.auto_popup, null);

        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


        popupWindow.setFocusable(true);
       /* popupWindow.setBackgroundDrawable(null);
        popupWindow.setOutsideTouchable(false);*/

        popupWindow.showAsDropDown(tv2,0,150);






    }
}
