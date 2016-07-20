package com.example.fangyi.googleplay.fragment;

import android.view.View;

import com.example.fangyi.googleplay.base.BaseFragment;
import com.example.fangyi.googleplay.view.LoadingPage;

/**
 * Created by FANGYI on 2016/7/18.
 */

public class AppFragment extends BaseFragment {

    @Override
    public View createSuccessView() {
        return null;
    }

    @Override
    protected LoadingPage.LoadResult load() {
        return LoadingPage.LoadResult.error;
    }
}
