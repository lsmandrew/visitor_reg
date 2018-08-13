package com.ja.visitor_reg.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ja.visitor_reg.model.SexTypeItem;

import java.util.List;

public class SexTypeAdapter extends BaseAdapter {

    private final Context mContext;
    private List<SexTypeItem> mSexTypeList;

    public SexTypeAdapter(Context mContext, List<SexTypeItem> mSexTypeList) {
        this.mContext = mContext;
        this.mSexTypeList = mSexTypeList;
    }

    @Override
    public int getCount() {
        return mSexTypeList.size();
    }

    @Override
    public Object getItem(int position) {
        return mSexTypeList.get(position);
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
        TextView textView = (TextView)view;
        textView.setTextSize(25);
        SexTypeItem item = mSexTypeList.get(position);
        textView.setText(item.getName());
        return view;
    }
}
