package com.example.youfeadaway.banmi.fragment.A;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.youfeadaway.banmi.R;
import com.example.youfeadaway.banmi.fragment.A.adapter.PlayAdapter;
import com.example.youfeadaway.banmi.fragment.A.bean.WeiBoBean;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {

    private RecyclerView banmi_rlv;

    private ArrayList<WeiBoBean.ResultBean.RoutesBean> list;
    private PlayAdapter adapter;
    private SmartRefreshLayout smart;


    public AFragment() {
        // Required empty public constructor
    }

    private int page = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_a, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {

        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request
                .Builder()
                .get()
                .url("http://api.banmi.com/api/3.0/content/routesbundles?" + page + "&token=JVy0IvZamK7f7FBZLKFtoniiixKMlnnJ6dWZ6NlsY4HGsxcAA9qvFo8yacHCKHE8YAcd0UF9L59nEm7zk9AUixee0Hl8EeWA880c0ikZBW0KEYuxQy5Z9NP3BNoBi3o3Q0g")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String trim = response.body().string().trim();
                Gson gson = new Gson();
                WeiBoBean weiBoBean = gson.fromJson(trim, WeiBoBean.class);
                final List<WeiBoBean.ResultBean.RoutesBean> routes = weiBoBean.getResult().getRoutes();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        list.addAll(routes);
                        adapter.setList(list);
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });


    }

    private void initView(View inflate) {
        banmi_rlv = (RecyclerView) inflate.findViewById(R.id.banmi_rlv);
        smart = (SmartRefreshLayout) inflate.findViewById(R.id.smart);

        list = new ArrayList<>();
        adapter = new PlayAdapter(list, getContext());
        banmi_rlv.setAdapter(adapter);
        banmi_rlv.setLayoutManager(new LinearLayoutManager(getContext()));

        //smart上拉加载，下拉刷新
        smart.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                initData();
                smart.finishLoadmore();
            }
        });

        smart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page = 1;
                initData();
                smart.finishRefresh();
            }
        });

        adapter.setOnClickLink(new PlayAdapter.onClickLink() {
            @Override
            public void getClickLink(WeiBoBean.ResultBean.RoutesBean bean, int position) {
                Intent intent = new Intent(getContext(),WebActivity.class);
                intent.putExtra("content",list.get(position).getContentURL());
                startActivity(intent);
            }
        });

    }
}
