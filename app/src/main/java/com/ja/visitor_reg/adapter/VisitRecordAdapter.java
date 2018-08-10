package com.ja.visitor_reg.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ja.visitor_reg.R;
import com.ja.visitor_reg.model.VisitRecordItem;

import java.util.List;


public class VisitRecordAdapter extends RecyclerView.Adapter<VisitRecordAdapter.ViewHolder> {
    private List<VisitRecordItem> mRecordList;

    public VisitRecordAdapter(List<VisitRecordItem> mRecordList) {
        this.mRecordList = mRecordList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView mTvVisitName;
        TextView mTvVisitedName;
        TextView mTvIdNum;
        TextView mTvVisitPhone;
        TextView mTvVisitTime;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTvVisitName = mView.findViewById(R.id.tv_visitout_visitor);
            mTvVisitedName = mView.findViewById(R.id.tv_visitout_visited);
            mTvIdNum = mView.findViewById(R.id.tv_visitout_idnum);
            mTvVisitPhone = mView.findViewById(R.id.tv_visitout_visitphone);
            mTvVisitTime = mView.findViewById(R.id.tv_visitout_intime);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_visit_out, parent, false);

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
        VisitRecordItem item = mRecordList.get(position);

        holder.mTvVisitName.setTextSize(25);
        holder.mTvVisitedName.setTextSize(25);
        holder.mTvIdNum.setTextSize(25);
        holder.mTvVisitPhone.setTextSize(25);
        holder.mTvVisitTime.setTextSize(25);
        ////////////////////////////////////////
        holder.mTvVisitName.setText(item.getVisitName());
        holder.mTvVisitedName.setText(item.getVisitedName());
        holder.mTvIdNum.setText(item.getIdNum());
        holder.mTvVisitPhone.setText(item.getVisitPhone());
        holder.mTvVisitTime.setText(item.getVisitTime());
    }

    @Override
    public int getItemCount() {
        return mRecordList.size();
    }

}
