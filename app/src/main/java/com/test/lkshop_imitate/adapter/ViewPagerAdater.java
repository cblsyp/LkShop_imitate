package com.test.lkshop_imitate.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

/**
 * Created by yubo7 on 2017/6/21.
 */

public class ViewPagerAdater extends PagerAdapter {
    private ArrayList<SimpleDraweeView> list;
    public ViewPagerAdater(ArrayList<SimpleDraweeView> views){
        this.list=views;
    }
    @Override
    public int getCount() {
        if(list.size()>0){
            return list.size();
        }
        return 0;
    }

    /**
     *
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    /*

   你好啊
     */
}
