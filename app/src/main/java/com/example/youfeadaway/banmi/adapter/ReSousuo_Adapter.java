package com.example.youfeadaway.banmi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.youfeadaway.banmi.R;
import com.example.youfeadaway.banmi.activity.topactivity.SouSuoActivity;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/5/26.
 */

public class ReSousuo_Adapter extends RecyclerView.Adapter<ReSousuo_Adapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<String> mStrings;

    public ReSousuo_Adapter(Context context, ArrayList<String> strings) {

        mContext = context;
        mStrings = strings;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.layout_text, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
       String s = mStrings.get(position);
        holder.mText.setText(s);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickListener.OnClick(position, mStrings);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStrings.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView mText;

        public MyViewHolder(View itemView) {
            super(itemView);
            mText = itemView.findViewById(R.id.text);
        }
    }

    OnClickListener mOnClickListener;

    public interface OnClickListener {
        void OnClick(int position, ArrayList<String> beans);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }
}
