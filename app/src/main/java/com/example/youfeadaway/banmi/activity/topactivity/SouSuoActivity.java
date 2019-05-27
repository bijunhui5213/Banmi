package com.example.youfeadaway.banmi.activity.topactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.youfeadaway.banmi.R;
import com.example.youfeadaway.banmi.adapter.ReSousuo_Adapter;
import com.example.youfeadaway.banmi.custom.FlowlayoutManger;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SouSuoActivity extends AppCompatActivity implements ReSousuo_Adapter.OnClickListener {

    @BindView(R.id.edit)
    EditText mEdit;
    @BindView(R.id.lv_sousuo)
    LinearLayout mLvSousuo;
    @BindView(R.id.quxiao)
    TextView mQuxiao;
    @BindView(R.id.delete)
    TextView mDelete;
    @BindView(R.id.rlv1)
    RecyclerView mRlv1;
    @BindView(R.id.rlv2)
    RecyclerView mRlv2;
    @BindView(R.id.rlv3)
    RecyclerView mRlv3;
    @BindView(R.id.rlv4)
    RecyclerView mRlv4;
    @BindView(R.id.rtl_history)
    RelativeLayout mRtlHistory;
    private ReSousuo_Adapter mMadapter1;
    private ArrayList<String> mStrings1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sou_suo);
        ButterKnife.bind(this);
        initData();

    }

    private void initData() {
        ArrayList<String> string2 = new ArrayList<>();
        string2.add("购物");
        string2.add("拍摄");
        string2.add("美食");
        string2.add("骑行");
        string2.add("自驾");
        string2.add("人文");
        string2.add("故宫");
        ArrayList<String> strings3 = new ArrayList<>();
        strings3.add("东京");
        strings3.add("北京");
        strings3.add("清迈");
        strings3.add("厦门");
        strings3.add("香港");
        strings3.add("台北");
        strings3.add("天津");
        strings3.add("潮汕");
        strings3.add("成都");
        strings3.add("大阪");
        ArrayList<String> strings4 = new ArrayList<>();
        strings4.add("王自如");
        strings4.add("吴晓波");
        strings4.add("郭振乾");
        strings4.add("卫晨旭");
        strings4.add("毕俊晖");
        strings4.add("范玥琪");
        strings4.add("常义磊");
        strings4.add("泰国");
        strings4.add("美国");
        strings4.add("二次元");
        strings4.add("艺术");
        mStrings1 = new ArrayList<>();
        mMadapter1 = new ReSousuo_Adapter(SouSuoActivity.this, mStrings1);
        ReSousuo_Adapter madapter2 = new ReSousuo_Adapter(SouSuoActivity.this, string2);
        ReSousuo_Adapter madapter3 = new ReSousuo_Adapter(SouSuoActivity.this, strings3);
        ReSousuo_Adapter madapter4 = new ReSousuo_Adapter(SouSuoActivity.this, strings4);
        mRlv1.setLayoutManager(new FlowlayoutManger());
        mRlv1.setAdapter(mMadapter1);
        mRlv2.setLayoutManager(new FlowlayoutManger());
        mRlv2.setAdapter(madapter2);
        mRlv3.setLayoutManager(new FlowlayoutManger());
        mRlv3.setAdapter(madapter3);
        mRlv4.setLayoutManager(new FlowlayoutManger());
        mRlv4.setAdapter(madapter4);

        madapter2.setOnClickListener(this);
        madapter3.setOnClickListener(this);
        madapter4.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @OnClick({R.id.quxiao, R.id.delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.quxiao:
                finish();
                break;
            case R.id.delete:
                mStrings1.clear();
                mMadapter1.notifyDataSetChanged();
                mRtlHistory.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void OnClick(int position, ArrayList<String> beans) {
        String s = beans.get(position);
        mEdit.setText(s);
        mEdit.setSelection(mEdit.getText().length());
        int length = mEdit.getText().length();
        if (length > 0) {
            mRtlHistory.setVisibility(View.VISIBLE);
            String s1 = mEdit.getText().toString();
            if (!mStrings1.contains(s1)) {
                mStrings1.add(s1);
            }
            mMadapter1.notifyDataSetChanged();
        }
    }
}
