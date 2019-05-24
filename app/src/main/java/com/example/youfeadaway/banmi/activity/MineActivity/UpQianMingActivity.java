package com.example.youfeadaway.banmi.activity.MineActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.youfeadaway.banmi.R;
import com.example.youfeadaway.banmi.utils.SpUtil;

public class UpQianMingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvBack;
    /**
     * 完成
     */
    private TextView mTvFinish;
    /**
     * 请输入个性签名
     */
    private EditText mEtName;
    /**
     * 0
     */
    private TextView mTvNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_qian_ming);
        initView();

        Intent intent = getIntent();
        String name = intent.getStringExtra("qianming");
        mEtName.setText(name);
    }

    private void initView() {
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mIvBack.setOnClickListener(this);
        mTvFinish = (TextView) findViewById(R.id.tv_finish);
        mTvFinish.setOnClickListener(this);
        mEtName = (EditText) findViewById(R.id.et_name);
        mTvNum = (TextView) findViewById(R.id.tv_num);
        mEtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mEtName.setSelection(mEtName.getText().length());
                mTvNum.setText(String.valueOf(s.length())+"/30");
                if (s.length() >= 30) {
                    Toast.makeText(UpQianMingActivity.this, "抱歉您输入的字数太多了，请控制在30字以内", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_finish:
                Intent intent = getIntent();
                String upname = mEtName.getText().toString();
                if (!upname.isEmpty()) {
                    intent.putExtra("upqian", upname);
                    SpUtil.setParam("upqian",upname);
                    setResult(4, intent);
                    Toast.makeText(UpQianMingActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(UpQianMingActivity.this, "请输入您的昵称", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
