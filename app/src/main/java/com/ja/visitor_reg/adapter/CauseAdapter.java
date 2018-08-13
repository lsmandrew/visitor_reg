package com.ja.visitor_reg.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ja.visitor_reg.model.CauseTypeItem;

import java.util.List;

public class CauseAdapter extends BaseAdapter {
    private final Context mContext;
    private List<CauseTypeItem> mCauseTypeList;

    public CauseAdapter(Context mContext, List<CauseTypeItem> mTypeList) {
        this.mContext = mContext;
        this.mCauseTypeList = mTypeList;
    }

    @Override
    public int getCount() {
        return mCauseTypeList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCauseTypeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (null == convertView) {
            view = new TextView(mContext);//new
        } else {
            view = convertView;
        }
        TextView textView = (TextView) view;
        textView.setTextSize(25);
        CauseTypeItem item = mCauseTypeList.get(position);
        textView.setText(item.getName());
        return view;
    }
}
