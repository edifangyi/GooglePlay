package com.example.fangyi.googleplay.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fangyi.googleplay.R;
import com.example.fangyi.googleplay.domain.SubjectInfo;
import com.example.fangyi.googleplay.global.GlobalContants;
import com.socks.library.KLog;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by FANGYI on 2016/7/21.
 */
public class XRVSubjectAdapter extends RecyclerView.Adapter<XRVSubjectAdapter.NormalTextViewHolder> {

    private SubjectInfo datas;
    private Context context;
    private final LayoutInflater mLayoutInflater;

    public XRVSubjectAdapter(SubjectInfo datas, Context context) {
        this.context = context;
        this.datas = datas;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.recycler_subject_item, parent, false));
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
        SubjectInfo.ListBean subjectInfo = datas.getList().get(position);

        holder.itemDec.setText(subjectInfo.getDes());


//        app/com.kugou.android/icon.jpg
        KLog.e();
        Glide.with(context)
                .load(GlobalContants.SERVER_URL + subjectInfo.getUrl())
                .centerCrop()
                .placeholder(R.mipmap.ic_default)
                .crossFade()
                .into(holder.itemPhoto);
    }

    @Override
    public int getItemCount() {
        return datas.getList().size();
    }

    public class NormalTextViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_photo)
        ImageView itemPhoto;
        @BindView(R.id.item_dec)
        TextView itemDec;

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
