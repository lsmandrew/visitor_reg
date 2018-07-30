package com.ja.visitor_reg.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.ja.visitor_reg.R;

public class VdInfoDialog {
    private Context mContext; // 声明一个上下文对象
    private Dialog  mDialog; // 声明一个对话框对象
    private View    mView; // 声明一个视图对象

    public VdInfoDialog(Context context) {
        this.mContext = context;
        mView = View.inflate(mContext, R.layout.dialog_vdinfo, null);
        // 创建一个指定风格的对话框对象
        mDialog= new Dialog(context, R.style.dialog_layout_bottom);
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

}
