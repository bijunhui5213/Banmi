package com.example.youfeadaway.banmi.fragment.A.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youfeadaway.banmi.R;
import com.example.youfeadaway.banmi.fragment.A.bean.WeiBoBean;

import java.util.ArrayList;

public class PlayAdapter extends RecyclerView.Adapter {

    private ArrayList<WeiBoBean.ResultBean.RoutesBean> list;
    private Context context;


    public PlayAdapter(ArrayList<WeiBoBean.ResultBean.RoutesBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<WeiBoBean.ResultBean.RoutesBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.play_fragment_layout, parent,false);
            return new ViewHolder1(inflate);
        }
            View inflate = LayoutInflater.from(context).inflate(R.layout.a_fragment_item, parent,false);
            return new ViewHolder2(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0) {
            ViewHolder1 holder1 = (ViewHolder1) holder;
            Glide.with(context).load(list.get(position).getCardURL()).into(holder1.img);
            holder1.city.setText(list.get(position).getCity());
            holder1.title.setText(list.get(position).getTitle());
            holder1.content.setText(list.get(position).getIntro());
            holder1.money.setText(list.get(position).getPrice());
            holder1.buy.setText(list.get(position).getPurchasedTimes()+"人感兴趣");
        } else if (itemViewType == 1) {
            ViewHolder2 holder2 = (ViewHolder2) holder;
            Glide.with(context).load(list.get(position).getCardURL()).into(holder2.images);
            holder2.images.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickLink != null) {
                        onClickLink.getClickLink(list.get(position),position);
                    }
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getType().equals("route")) {
            return 0;
        }
        return 1;
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView city;
        private TextView title;
        private TextView content;
        private TextView money;
        private TextView buy;
        public ViewHolder1(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            city = itemView.findViewById(R.id.city);
            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
            money = itemView.findViewById(R.id.money);
            buy = itemView.findViewById(R.id.buy);
        }
    }


    private class ViewHolder2 extends RecyclerView.ViewHolder {
        private ImageView images;
        public ViewHolder2(View inflate) {
            super(inflate);
            images = inflate.findViewById(R.id.images);
        }
    }

    public interface onClickLink{
        void getClickLink(WeiBoBean.ResultBean.RoutesBean bean, int position);
    }
    private onClickLink onClickLink;

    public void setOnClickLink(PlayAdapter.onClickLink onClickLink) {
        this.onClickLink = onClickLink;
    }
}
