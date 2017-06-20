package com.test.lkshop_imitate.app;

import android.app.Application;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.jude.utils.JUtils;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

/**
 * Created by yubo7 on 2017/6/20.
 */

public class App extends Application {
    private static final String TAG="chen debug";
    public static final String FILENAME="userInfo.json";
    private static App singleton;

    public enum Dir{
        Object
    }

    public static App getApp() {
        if (singleton == null) {
            synchronized (App.class) {
                singleton = new App();
            }
        }
        return singleton;
    }
    @Override
    public void onCreate(){
        super.onCreate();
        Fresco.initialize(this);
        JUtils.initialize(this);
        U_push();

    }

    private void U_push() {
        PushAgent mPushAgent = PushAgent.getInstance(this);
//注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.e(TAG,"myToken:"+deviceToken.toString());
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });
    }
}
