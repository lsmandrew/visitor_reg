package com.ja.visitor_reg.adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ja.visitor_reg.R;
import com.ja.visitor_reg.model.VisitRecordItem;
import com.ja.visitor_reg.task.DBTask;
import com.orhanobut.logger.Logger;

import java.util.Date;
import java.util.List;


public class VisitRecordAdapter extends RecyclerView.Adapter<VisitRecordAdapter.ViewHolder> {
    private List<VisitRecordItem> mRecordList;
    private int mSelectPos = -1;

    public VisitRecordAdapter(List<VisitRecordItem> list) {
        this.mRecordList = list;
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
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_visit_out, parent, false);

        final ViewHolder holder = new ViewHolder(view);
        //bind linstener
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///Toast.makeText(v.getContext(), "click recycler", Toast.LENGTH_SHORT).show();
                mSelectPos = holder.getAdapterPosition();//获取位置

                //dialog
                AlertDialog.Builder dialog = new AlertDialog.Builder(v.getContext());
                dialog.setTitle("This is a Dialog");
                dialog.setMessage("是否签退?");
                dialog.setCancelable(true);
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Logger.d("Visit Out OK Pos= " + mSelectPos);
                        if (mSelectPos < 0 || mSelectPos >= mRecordList.size()){
                            Toast.makeText(view.getContext(), "选择超出范围", Toast.LENGTH_SHORT);
                            return;
                        }
                        VisitRecordItem item = mRecordList.get(mSelectPos);
                        new DBTask().start_SignOut(item.getVisitId(),
                                new Date(), new DBTask.onDBOutResultListener() {
                                    @Override
                                    public void onSignOutResult(boolean result) {
                                        mRecordList.remove(mSelectPos);
                                        notifyDataSetChanged();
                                    }
                                });

                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Logger.d("Visit Out Cancel");
                    }
                });
                dialog.show();
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
