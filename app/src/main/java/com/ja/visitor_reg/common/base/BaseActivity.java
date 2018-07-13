package com.ja.visitor_reg.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ja.visitor_reg.common.util.ApplicationUtil;

/**
 * BaseActivity
 * function: 自定义的Activity基类
 * author: lsm
 * date: 2018-7-12
 */
public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "base.BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationUtil.getInstance().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ApplicationUtil.getInstance().removeActivity(this);
    }

}
