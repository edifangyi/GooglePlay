package com.example.fangyi.googleplay.base;

import android.app.Application;
import android.os.Handler;

import com.yolanda.nohttp.NoHttp;

/**
 * 代表当前应用程序
 * Created by FANGYI on 2016/7/19.
 */

public class BaseApplication extends Application {
    private static BaseApplication application;
    private static int mainTid;
    private static Handler handler;
    private static Application _instance;

    //在主线程运行
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        //线程id
        mainTid = android.os.Process.myTid();
        handler =new Handler();
        _instance = this;
        NoHttp.init(this);
    }

    public static BaseApplication getApplication() {
        return application;
    }

    public static int getMainTid() {
        return mainTid;
    }

    public static Handler getHandler() {
        return handler;
    }
}
