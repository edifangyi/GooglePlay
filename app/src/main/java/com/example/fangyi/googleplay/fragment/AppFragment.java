package com.example.fangyi.googleplay.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.fangyi.googleplay.R;
import com.example.fangyi.googleplay.adapter.XRVHomeAdapter;
import com.example.fangyi.googleplay.base.BaseFragment;
import com.example.fangyi.googleplay.domain.AppInfo;
import com.example.fangyi.googleplay.protocol.AppProtocol;
import com.example.fangyi.googleplay.utils.UiUtils;
import com.example.fangyi.googleplay.view.LoadingPage;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by FANGYI on 2016/7/18.
 */

public class AppFragment extends BaseFragment {
    @BindView(R.id.xrv_app)
    XRecyclerView xrvApp;
    private AppInfo datas;

    @Override
    public View createSuccessView() {
        View view = View.inflate(UiUtils.getContext(), R.layout.fragment_app, null);
        ButterKnife.bind(this, view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrvApp.setLayoutManager(layoutManager);
        xrvApp.setAdapter(new XRVHomeAdapter(datas, getContext()));

        return view;
    }

    /**
     * 服务器数据
     *
     * @return
     */
    protected LoadingPage.LoadResult load() {
        AppProtocol protocol = new AppProtocol();

        datas = protocol.load(0);

        List<AppInfo.Inner> inners = datas.getList();

        return checkData(inners);
    }
}
