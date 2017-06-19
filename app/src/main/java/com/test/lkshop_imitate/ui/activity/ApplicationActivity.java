package com.test.lkshop_imitate.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.Animation;

import com.test.lkshop_imitate.utils.PreferenceUtils;

/**
 * Created by yubo7 on 2017/6/19.
 */

public class ApplicationActivity extends Activity {
    //define three animation
    private Animation mFadeIn;
    private Animation mFadeOut;
    private Animation mFadeInScale;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    private void comeingApp() {
        setContentView(R.layout.activity_application);
    }

    private void Welcome() {
        Intent intent = new Intent();
        intent.setClass(this, WelcomeActivity.class);
        startActivity(intent);
        finish();
    }
}
