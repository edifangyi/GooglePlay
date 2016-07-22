package com.example.fangyi.googleplay.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.Formatter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fangyi.googleplay.R;
import com.example.fangyi.googleplay.domain.AppInfo;
import com.example.fangyi.googleplay.global.GlobalContants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by FANGYI on 2016/7/21.
 */
public class XRVSubjectAdapter extends RecyclerView.Adapter<XRVSubjectAdapter.NormalTextViewHolder> {


    private AppInfo datas;
    private Context context;
    private final LayoutInflater mLayoutInflater;

    public XRVSubjectAdapter(AppInfo datas, Context context) {
        this.context = context;
        this.datas = datas;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.recycler_home_item, parent, false));
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
        AppInfo.Inner appInfo = datas.getList().get(position);

        holder.itemTitle.setText(appInfo.getName());
        String size = Formatter.formatFileSize(context, (long) appInfo.getSize());
        holder.itemSize.setText(size);
        float stars = appInfo.getStars();
        holder.itemRating.setRating(stars);//设置ratingBar的值
        holder.itemBottom.setText(appInfo.getDes());

//        app/com.kugou.android/icon.jpg

        Glide.with(context)
                .load(GlobalContants.SERVER_URL + appInfo.getIconUrl())
                .centerCrop()
                .placeholder(R.mipmap.ic_default)
                .crossFade()
                .into(holder.itemIcon);
    }

    @Override
    public int getItemCount() {
        return datas.getList().size();
    }

    public class NormalTextViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_icon)
        ImageView itemIcon;
        @BindView(R.id.item_title)
        TextView itemTitle;
        @BindView(R.id.item_rating)
        RatingBar itemRating;
        @BindView(R.id.item_size)
        TextView itemSize;
        @BindView(R.id.item_divider)
        View itemDivider;
        @BindView(R.id.item_bottom)
        TextView itemBottom;

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
