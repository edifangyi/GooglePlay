package com.example.fangyi.googleplay.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.fangyi.googleplay.R;
import com.example.fangyi.googleplay.adapter.XRVHomeAdapter;
import com.example.fangyi.googleplay.base.BaseFragment;
import com.example.fangyi.googleplay.domain.AppInfo;
import com.example.fangyi.googleplay.protocol.HomeProtocol;
import com.example.fangyi.googleplay.view.LoadingPage;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.socks.library.KLog;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by FANGYI on 2016/7/18.
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.xrv_home)
    XRecyclerView xrvHome;

    private AppInfo datas;

    //当Fragment挂载的Activity创建的时候调用
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show();

    }

    /**
     * 成功界面
     *
     * @return
     */
    public View createSuccessView() {
        View view = View.inflate(getActivity(), R.layout.fragment_home, null);
        ButterKnife.bind(this, view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrvHome.setLayoutManager(layoutManager);
        xrvHome.setAdapter(new XRVHomeAdapter(datas,getActivity()));

        return view;
    }

    /**
     * 服务器数据
     *
     * @return
     */
    protected LoadingPage.LoadResult load() {
        HomeProtocol protocol = new HomeProtocol();

        datas = protocol.load(0);

        return checkData(datas);
    }

    /**
     * 校验
     *
     * @param load
     * @return
     */
    private LoadingPage.LoadResult checkData(AppInfo load) {
        if (load == null) {
            KLog.e("8.请求方式 == error ");
            return LoadingPage.LoadResult.error;//服务器请求失败
        } else {
            if (load.getList().size() == 0) {
                KLog.e("8.请求方式 == empty ");
                return LoadingPage.LoadResult.empty;//请求为空
            } else {
                KLog.e("8.请求方式 == success ");
                return LoadingPage.LoadResult.success;//请求成功
            }

        }
    }

}
