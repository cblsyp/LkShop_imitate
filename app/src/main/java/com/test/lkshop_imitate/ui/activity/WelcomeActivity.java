package com.test.lkshop_imitate.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.test.lkshop_imitate.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yubo7 on 2017/6/19.
 */

public class WelcomeActivity extends Activity {
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.goComing)
    TextView goComing;
    @BindView(R.id.goLogin)
    TextView goLogin;
    @BindView(R.id.goLayout)
    RelativeLayout goLayout;
//    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

    }
}
