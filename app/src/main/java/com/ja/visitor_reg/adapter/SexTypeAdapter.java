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
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (null == convertView) {
            TextView textView = new TextView(mContext);//new
            textView.setTextSize(25);
            SexTypeItem item = mSexTypeList.get(position);
            textView.setText(item.getName());
            view = textView;
        } else {
            view = convertView;
        }
        return view;
    }
}
