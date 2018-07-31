package com.ja.visitor_reg.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ja.visitor_reg.R;
import com.ja.visitor_reg.adapter.VdInfoAdapter;
import com.ja.visitor_reg.model.VdInfoItem;
import com.orhanobut.logger.Logger;

import java.util.List;

public class VdInfoDialog implements View.OnClickListener, AdapterView.OnItemClickListener {
    private Context mContext; // 声明一个上下文对象
    private Dialog  mDialog; // 声明一个对话框对象
    private View    mView; // 声明一个视图对象
    private ListView mListView;
    private VdInfoAdapter mAdapter;
    private List<VdInfoItem> mVdInfoList;
    private OnGetVdInfoListener mGetVdInfListener;
    private int mCurPos = -1;

    public VdInfoDialog(Context context, List<VdInfoItem> list) {
        this.mContext = context;
        mView = View.inflate(mContext, R.layout.dialog_vdinfo, null);
        // 创建一个指定风格的对话框对象
        mDialog= new Dialog(context, R.style.dialog_layout_bottom);
        //find
        mListView = mView.findViewById(R.id.lv_vd_info);
        //list
        mVdInfoList = list;
        mAdapter = new VdInfoAdapter(mContext, mVdInfoList);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
        mView.findViewById(R.id.btn_vdinfo_confirm).setOnClickListener(this);
    }

    // 显示对话框
    public void show() {
        // 设置对话框窗口的内容视图
        mDialog.getWindow().setContentView(mView);
        // 设置对话框窗口的布局参数
        mDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置对话框为靠下对齐
        mDialog.getWindow().setGravity(Gravity.BOTTOM);
        // 允许取消对话框
        mDialog.setCancelable(true);
        mDialog.show(); // 显示对话框
    }

    // 关闭对话框
    public void dismiss() {
        // 如果对话框显示出来了，就关闭它
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    // 判断对话框是否显示
    public boolean isShowing() {
        if (mDialog != null) {
            return mDialog.isShowing();
        } else {
            return false;
        }
    }

    @Override
    public void onClick(View v) {
        Logger.i("Dialog Click---------");
        if (v.getId() == R.id.btn_vdinfo_confirm) { // 点击了确定按钮
            mDialog.dismiss(); // 关闭对话框
            if (mGetVdInfListener != null) { // 如果存在添加完成监听器
                // 回调监听器的addFriend方法
                if (mCurPos >= 0) {
                    mGetVdInfListener.getVdInfo(mVdInfoList.get(mCurPos));
                }
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Logger.i("listview Click---------");
        mListView.setSelector(R.color.vdinfo_focus);
        mCurPos = position;//save

    }

    public interface OnGetVdInfoListener {
        void getVdInfo(VdInfoItem vdInfoItem);
    }

    public void setOnGetVdInfoCallBack(OnGetVdInfoListener listener){
        mGetVdInfListener = listener;
    }
}
