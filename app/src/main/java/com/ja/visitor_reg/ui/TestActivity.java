package com.ja.visitor_reg.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.ja.visitor_reg.R;
import com.ja.visitor_reg.api.HttpApi;
import com.ja.visitor_reg.json.LOGIN_INFO;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void onClick_ApiLogin(View view) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        Log.d("TestActivity", "run: ");
                        HttpApi httpApi = new HttpApi();
                        LOGIN_INFO login_info =  new LOGIN_INFO();
                        login_info.setDeviceName("ja-20180703-001");
                        login_info.setPassword("123456");
                        httpApi.Login_Request(login_info);
                    }
                }
        ).start();
    }

    public void onClick_ApiLogout(View view) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        Log.d("TestActivity", "run: ");
                        HttpApi httpApi = new HttpApi();
                        httpApi.Logout_Request();
                    }
                }
        ).start();
    }


    public void onClick_ApiGetDevID(View view) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        Log.d("TestActivity", "run: ");
                        HttpApi httpApi = new HttpApi();
                        httpApi.GetDevId_Request();
                    }
                }
        ).start();
    }

    public void onClick_ApiGetDevInfo(View view) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        Log.d("TestActivity", "run: ");
                        HttpApi httpApi = new HttpApi();
                        httpApi.GetDevInfo_Request();
                    }
                }
        ).start();
    }
}
