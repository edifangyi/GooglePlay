package com.example.fangyi.googleplay.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

/**
 * 基类Activity，让所有Activity继承自这个，好实现所有此Activity定义的方法
 * Created by FANGYI on 2016/7/19.
 */

public class BaseActivity extends AppCompatActivity {
    //管理运行的所有Activity,保证唯一存在
    public final static List<BaseActivity> mActivities = new LinkedList<>();//增删比较快,ArrayList查询比较快

//    private KiiAkkReceiver receiver;
//
//    //当前所有Activity实现广播接受者
//    private class KiiAkkReceiver extends BroadcastReceiver {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            finish();
//        }
//    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //同步代码块,解决线程安全，比如当前Activity还未被复制，就被删除
        synchronized (mActivities) {
            mActivities.add(this);
        }

//        //广播接受者
//        receiver = new KiiAkkReceiver();
//        IntentFilter filter = new IntentFilter("com.fangyi.googleplay.killall");
//        registerReceiver(receiver, filter);

        initData();
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        synchronized (mActivities) {
            mActivities.remove(this);
        }

//        if (receiver != null) {
//            unregisterReceiver(receiver);
//            receiver = null;
//        }
    }

    /**
     * 退出当前Activity
     */
    public void KillAll() {
        //复制一份mActivities集合
        List<BaseActivity> copy;
        synchronized (mActivities) {
            copy = new LinkedList<>(mActivities);
        }
        for (BaseActivity baseActivity : copy) {
            baseActivity.finish();
        }
        //杀死当前的进程
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    protected void initData() {
    }

    protected void initView() {
    }


}
