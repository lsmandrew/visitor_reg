package com.ja.visitor_reg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ja.visitor_reg.common.base.BaseActivity;
import com.ja.visitor_reg.ui.TestActivity;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onCLick_Test(View view) {
        Intent intent= new Intent(this, TestActivity.class);
        startActivity(intent);

    }
}
