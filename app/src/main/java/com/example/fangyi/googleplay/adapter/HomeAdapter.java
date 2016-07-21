package com.example.fangyi.googleplay.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fangyi.googleplay.R;
import com.example.fangyi.googleplay.domain.AppInfo;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by FANGYI on 2016/7/21.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.NormalTextViewHolder> {

    private AppInfo datas;
    private final LayoutInflater mLayoutInflater;

    public HomeAdapter(AppInfo datas, Context context) {
        this.datas = datas;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.recycler_home_item, parent, false));
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
        holder.newsInfoDesc.setText(datas.getList().get(position).getName());
    }

    @Override
    public int getItemCount() {
        return datas.getList().size();
    }

    public class NormalTextViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.news_info_photo)
        ImageView newsInfoPhoto;
        @BindView(R.id.news_info_desc)
        TextView newsInfoDesc;

        NormalTextViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("NormalTextViewHolder", "onClick--> position = " + getPosition());
                }
            });
        }
    }
}
