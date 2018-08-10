package com.ja.visitor_reg.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ja.visitor_reg.R;
import com.ja.visitor_reg.model.VisitInInfoItem;

import java.util.List;

public class VisitorInInfoAdapter extends RecyclerView.Adapter<VisitorInInfoAdapter.ViewHolder> {

    private List<VisitInInfoItem> mVisitInList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View mView;
        ImageView mImgeHead;
        ImageView mImgePortrait;
        ImageView mImgeGoods;
        TextView mTvVisitName;
        TextView mTvVisitedName;
        TextView mTvBookPhone;
        TextView mTvVisitTime;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTvVisitName = view.findViewById(R.id.tv_visitin_name);
            mTvVisitedName = view.findViewById(R.id.tv_visitin_visited);
            mTvBookPhone = view.findViewById(R.id.tv_visitin_phone);
            mTvVisitTime = view.findViewById(R.id.tv_visitin_time);
//            mImgeHead = itemView.findViewById(R.id.img_visitin_head);
//            mImgePortrait = itemView.findViewById(R.id.img_visitin_portrait);
//            mVisitedName = itemView.findViewById(R.id.img_visitin_goods);
        }
    }

    public VisitorInInfoAdapter(List<VisitInInfoItem> list) {
        this.mVisitInList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_visitin_info, parent, false);
//        View view = View.inflate(parent.getContext(), R.layout.item_visitin_info, null);
        ViewHolder holder = new ViewHolder(view);
        //bind linstener
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "click recycler", Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VisitInInfoItem item = mVisitInList.get(position);

        holder.mTvVisitName.setTextSize(25);
        holder.mTvVisitedName.setTextSize(25);
        holder.mTvBookPhone.setTextSize(25);
        holder.mTvVisitTime.setTextSize(25);
        holder.mTvVisitName.setText(item.getVisitName());
        holder.mTvVisitedName.setText(item.getVisitedName());
        holder.mTvBookPhone.setText(item.getVisitPhone());
        holder.mTvVisitTime.setText(item.getVisitTime());
    }

    @Override
    public int getItemCount() {
        return mVisitInList.size();
    }
}
