package com.example.fangyi.googleplay.utils;

import android.content.Context;
import android.content.res.Resources;

import com.example.fangyi.googleplay.base.BaseApplication;

/**
 * Created by FANGYI on 2016/7/19.
 */

public class UiUtils {

    /**
     * 上下文
     * @return
     */
    private static Resources getResources() {
        return BaseApplication.getApplication().getResources();
    }

    public static Context getContext() {
        return BaseApplication.getApplication();
    }

    /**
     * 获取到字符数组
     * @param tab_names 字符数组的id
     */
    public static String[] getStringArray(int tab_names) {
       return getResources().getStringArray(tab_names);
    }

    /** dip转换px */
    public static int dip2px(int dip) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /** pxz转换dip */

    public static int px2dip(int px) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }


    /**
     * 把Runnable方法提交到主线程中运行
     * @param runnable
     */
    public static void runOnUiThread(Runnable runnable) {
        //在主线程运行
        if (android.os.Process.myTid() == BaseApplication.getMainTid()) {
            runnable.run();
        }else {
            //获取handler
            BaseApplication.getHandler().post(runnable);
        }
    }
}
