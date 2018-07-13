package com.ja.visitor_reg.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.ja.visitor_reg.R;
import com.ja.visitor_reg.api.HttpApi;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void onClick_ApiReg(View view) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        Log.d("TestActivity", "run: ");
                        HttpApi httpApi = new HttpApi();
                        httpApi.Register_Request(null);
                    }
                }
        ).start();

    }
}
