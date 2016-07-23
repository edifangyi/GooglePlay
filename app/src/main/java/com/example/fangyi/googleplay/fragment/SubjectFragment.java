package com.example.fangyi.googleplay.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.fangyi.googleplay.R;
import com.example.fangyi.googleplay.adapter.XRVSubjectAdapter;
import com.example.fangyi.googleplay.base.BaseFragment;
import com.example.fangyi.googleplay.domain.SubjectInfo;
import com.example.fangyi.googleplay.protocol.SubjectProtocol;
import com.example.fangyi.googleplay.utils.UiUtils;
import com.example.fangyi.googleplay.view.LoadingPage;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.socks.library.KLog;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by FANGYI on 2016/7/18.
 */

public class SubjectFragment extends BaseFragment {


    @BindView(R.id.xrv_subject)
    XRecyclerView xrvSubject;
    private SubjectInfo datas;


    @Override
    public View createSuccessView() {
        View view = View.inflate(UiUtils.getContext(), R.layout.fragment_subject, null);
        ButterKnife.bind(this, view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrvSubject.setLayoutManager(layoutManager);
        xrvSubject.setAdapter(new XRVSubjectAdapter(datas, getContext()));

        return view;
    }

    /**
     * 服务器数据
     *
     * @return
     */
    protected LoadingPage.LoadResult load() {
        SubjectProtocol protocol = new SubjectProtocol();

        datas = protocol.load(0);
        KLog.e(datas);
        return checkData(datas);
    }

    /**
     * 校验
     *
     * @param load
     * @return
     */
    public LoadingPage.LoadResult checkData(SubjectInfo load) {
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
