package com.example.youfeadaway.banmi.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/5/22.
 */

public class Vp_Welcome_Adapter extends PagerAdapter{

    private ArrayList<View> list;

    public Vp_Welcome_Adapter(ArrayList<View> list) {
        super();
        this.list = list;
    }
    //传入我存好布局加载器加载好的的布局

    @Override
    public int getCount() {
        return list.size();
        //控制能显示页面或视图的数目(滑动界面的数量)
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return  arg0 == arg1;
        //view和它对应的下标
    }
    //滑动要显示的
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = list.get(position);//要显示的view
        container.addView(view);
        //滑动显示的view,添加到container
        //position要显示的view的下标
        return view; //返回要显示的view
    }
  //滑动看不见的
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = list.get(position);//要移除的view
        //position要显示的view的下标
        container.removeView(view);
    }
}
