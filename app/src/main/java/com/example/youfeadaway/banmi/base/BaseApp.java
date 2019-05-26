package com.example.youfeadaway.banmi.base;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

public class BaseApp extends Application {

    private static BaseApp baseApp;
    //默认不是夜间模式
    public static int mMode = AppCompatDelegate.MODE_NIGHT_NO;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApp = this;
        //三方登录
        UMConfigure.init(this,"5ce7f53b3fc195c17e0010b8"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");

        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        //豆瓣RENREN平台目前只能在服务器端配置
        PlatformConfig.setSinaWeibo("1535156177", "Secret：c5791d46d8f144d9b42adc8b912888cb","http://api.banmi.com/api/3.0/account/login/oauth");
        PlatformConfig.setYixin("yxc0614e80c9304c11b0391514d09f13bf");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setTwitter("3aIN7fuF685MuZ7jtXkQxalyi", "MK6FEYG63eWcpDFgRYw4w9puJhzDl0tyuqWjZ3M7XJuuG7mMbO");

    }

    public static BaseApp getBaseApp() {
        return baseApp;
    }

}
