package com.ja.visitor_reg;

import android.os.Bundle;

import com.ja.visitor_reg.common.base.BaseActivity;
import com.ja.visitor_reg.common.util.CallerTool;
import com.ja.visitor_reg.serve.SecondService;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //开启副屏服务
        CallerTool.Start_Service(this, SecondService.class);
    }


}
