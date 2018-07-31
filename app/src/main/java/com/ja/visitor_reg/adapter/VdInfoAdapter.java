package com.ja.visitor_reg.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ja.visitor_reg.R;
import com.ja.visitor_reg.model.VdInfoItem;

import java.util.List;

public class VdInfoAdapter extends BaseAdapter {
    private final Context mContext;
    private List<VdInfoItem> mVdInofList;

    public VdInfoAdapter(Context mContext, List<VdInfoItem> mVdInofList) {
        this.mContext = mContext;
        this.mVdInofList = mVdInofList;
    }

    @Override
    public int getCount() {
        return mVdInofList.size();
    }

    @Override
    public Object getItem(int position) {
        return mVdInofList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (null == convertView) {
            convertView = View.inflate(mContext, R.layout.item_vdinfo_list, null);
            holder = new ViewHolder();
            holder.tv_dep = convertView.findViewById(R.id.tv_vdinfo_dep);
            holder.tv_name = convertView.findViewById(R.id.tv_vdinfo_name);
            holder.tv_phone = convertView.findViewById(R.id.tv_vdinfo_phone);
            // 将视图持有者保存到转换视图当中
            convertView.setTag(holder);
        } else {
            // 获取已经保存的viewhold(不用再次写findview)
            holder = (ViewHolder) convertView.getTag();
        }

        //set
        VdInfoItem item = mVdInofList.get(position);
        holder.tv_dep.setText(item.getDepartment());
        holder.tv_name.setText(item.getName());
        holder.tv_phone.setText(item.getWorkPhone());

        return convertView;
    }

    // 定义一个视图持有者，以便重用列表项的视图资源
    public class ViewHolder {
        public TextView tv_dep;
        public TextView tv_name;
        public TextView tv_phone;
    }
}
