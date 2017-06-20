package com.test.lkshop_imitate.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.test.lkshop_imitate.MainActivity;
import com.test.lkshop_imitate.R;
import com.test.lkshop_imitate.utils.PreferenceUtils;
import com.umeng.message.PushAgent;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yubo7 on 2017/6/19.
 */

public class ApplicationActivity extends Activity {
    @BindView(R.id.application_bg)
    ImageView applicationBg;
    //define three animation
    private Animation mFadeIn;
    private Animation mFadeOut;
    private Animation mFadeInScale;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PushAgent.getInstance(this).onAppStart();
        DoAction();

    }

    private void DoAction() {
        boolean isFirst = PreferenceUtils.readBoolean(this, "First", "isFirst", true);
        if (isFirst == true) {
            PreferenceUtils.write(this, "First", "isFirst", false);
            Welcome();
        } else {
            comeingApp();
        }
    }

    /**
     * 直接进入App
     */
    private void comeingApp() {
        setContentView(R.layout.activity_application);
        ButterKnife.bind(this);

        RandomApplicationBg();
        initAnim();
        setAnimListener();

    }

    /**
     * 建立监听事件
     */
    private void setAnimListener() {
        mFadeIn.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                applicationBg.startAnimation(mFadeInScale);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mFadeInScale.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                applicationBg.startAnimation(mFadeOut);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mFadeOut.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                Intent intent = new Intent();
                intent.setClass(ApplicationActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void initAnim() {
        mFadeIn = AnimationUtils.loadAnimation(this, R.anim.application_fade_in);
        mFadeIn.setDuration(500);
        mFadeInScale = AnimationUtils.loadAnimation(this, R.anim.application_fade_in_scale);
        mFadeInScale.setDuration(2000);
        mFadeOut = AnimationUtils.loadAnimation(this, R.anim.application_fade_out);
        mFadeOut.setDuration(500);
        applicationBg.setAnimation(mFadeIn);
        //  applicationBg.startAnimation(mFadeIn);
    }

    private void RandomApplicationBg() {
        int index = new Random().nextInt(2);
        if (index == 1) {
            applicationBg.setImageResource(R.mipmap.entrance1);
        } else {
            applicationBg.setImageResource(R.mipmap.entrance2);
        }
    }

    private void Welcome() {
        Intent intent = new Intent();
        intent.setClass(this, WelcomeActivity.class);
        startActivity(intent);
        finish();
    }
}
