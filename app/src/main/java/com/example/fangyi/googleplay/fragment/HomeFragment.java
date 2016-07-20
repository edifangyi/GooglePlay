package com.example.fangyi.googleplay.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.fangyi.googleplay.base.BaseFragment;
import com.example.fangyi.googleplay.view.LoadingPage;

/**
 * Created by FANGYI on 2016/7/18.
 */

public class HomeFragment extends BaseFragment {
    //当Fragment挂载的Activity创建的时候调用
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show();

    }

    /**
     * 成功界面
     * @return
     */
    public View createSuccessView() {

        return null;
    }

    /**
     * 服务器返回的状态码
     * @return
     */
    protected LoadingPage.LoadResult load() {

        return LoadingPage.LoadResult.success;
    }
}
