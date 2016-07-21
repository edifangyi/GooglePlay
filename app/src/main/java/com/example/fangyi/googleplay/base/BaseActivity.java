package com.example.fangyi.googleplay.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 基类Activity，让所有Activity继承自这个，好实现所有此Activity定义的方法
 * Created by FANGYI on 2016/7/19.
 */

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    protected void initData() {
    }

    protected void initView() {
    }


}
