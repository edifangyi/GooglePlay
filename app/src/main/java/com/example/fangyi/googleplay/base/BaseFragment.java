package com.example.fangyi.googleplay.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fangyi.googleplay.utils.ViewUtils;
import com.example.fangyi.googleplay.view.LoadingPage;
import com.socks.library.KLog;

import java.util.List;

/**
 * Created by FANGYI on 2016/7/19.
 */

public abstract class BaseFragment extends Fragment {

    private LoadingPage loadingPage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (loadingPage == null) {  // 之前的frameLayout 已经记录了一个爹了  爹是之前的ViewPager
            loadingPage = new LoadingPage(getActivity()){

                @Override
                public View createSuccessView() {
                    return BaseFragment.this.createSuccessView();
                }

                @Override
                protected LoadResult load() {
                    return BaseFragment.this.load();
                }
            };
        }else{
            ViewUtils.removeParent(loadingPage);// 移除frameLayout之前的爹
        }

        return loadingPage;  //  拿到当前viewPager 添加这个framelayout
    }

    /**
     * 创建成功的界面
     *
     * @return
     */
    public abstract View createSuccessView();

    /**
     * 请求服务器
     *
     * @return
     */
    protected abstract LoadingPage.LoadResult load();


    public void show() {
        if (loadingPage != null) {
            loadingPage.show();
        }
    }


    /**
     * 校验
     *
     * @param datas
     * @return
     */
    public LoadingPage.LoadResult checkData(List datas) {
        if (datas == null) {
            KLog.e("8.请求方式 == error ");
            return LoadingPage.LoadResult.error;//服务器请求失败
        } else {
            if (datas.size() == 0) {
                KLog.e("8.请求方式 == empty ");
                return LoadingPage.LoadResult.empty;//请求为空
            } else {
                KLog.e("8.请求方式 == success ");
                return LoadingPage.LoadResult.success;//请求成功
            }

        }
    }

}
