package com.example.fangyi.googleplay.fragment;

import android.view.View;
import android.widget.TextView;

import com.example.fangyi.googleplay.base.BaseFragment;
import com.example.fangyi.googleplay.view.LoadingPage;

/**
 * Created by FANGYI on 2016/7/18.
 */

public class AppFragment extends BaseFragment {

    @Override
    public View createSuccessView() {
        TextView view = new TextView(getContext());
        view.setText("哈哈哈哈哈");
        return view;
    }

    @Override
    protected LoadingPage.LoadResult load() {
        return LoadingPage.LoadResult.success;
    }
}
