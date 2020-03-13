package com.example.wwh_test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wwh_test.Bean;
import com.example.wwh_test.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<Bean.DataBeanX.DataBean> list;
    private Context context;

    public HomeAdapter(List<Bean.DataBeanX.DataBean> list) {
        this.list = list;
    }

    public void initData(List<Bean.DataBeanX.DataBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.zhuanti_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bean.DataBeanX.DataBean dataBean = list.get(position);
        holder.title.setText(dataBean.getTitle());
        holder.name.setText(dataBean.getSubtitle());
        Glide.with(context).load(dataBean.getScene_pic_url()).into(holder.zhuantiImg);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView zhuantiImg;
        TextView title;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            zhuantiImg=itemView.findViewById(R.id.zhuantiImg);
            title=itemView.findViewById(R.id.aptitle);
            name=itemView.findViewById(R.id.apname);
        }
    }
}
