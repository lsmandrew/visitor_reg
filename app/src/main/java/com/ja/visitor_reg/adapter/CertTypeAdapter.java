package com.ja.visitor_reg.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ja.visitor_reg.model.CertTypeItem;

import java.util.List;

/**
 * 证件类型适配器
 */
public class CertTypeAdapter extends BaseAdapter {

    private final Context mContext;
    private List<CertTypeItem> mTypeList;


    public CertTypeAdapter(Context context, List<CertTypeItem> certTypeItems) {
        mContext = context;
        mTypeList = certTypeItems;
    }

    @Override
    public int getCount() {
        return mTypeList.size();
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
            CertTypeItem item = mTypeList.get(position);
            textView.setText(item.getName());
            view = textView;
        } else {
            view = convertView;
        }
        return view;
    }
}
