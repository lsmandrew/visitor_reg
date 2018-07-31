package com.ja.visitor_reg.ui;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ja.visitor_reg.R;
import com.ja.visitor_reg.api.HttpApi;
import com.ja.visitor_reg.common.base.BaseActivity;
import com.ja.visitor_reg.json.LOGIN_INFO;
import com.telpo.tps550.api.TelpoException;
import com.telpo.tps550.api.idcard.IdCard;
import com.telpo.tps550.api.idcard.IdentityInfo;

import java.util.HashMap;
import java.util.Iterator;

public class TestActivity extends BaseActivity {
    private UsbManager   mUsbManager;
    private IdentityInfo mIdinfo;

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

    private boolean isUsb() {
        mUsbManager = (UsbManager) getSystemService(Context.USB_SERVICE);
        HashMap<String, UsbDevice> deviceHashMap = mUsbManager.getDeviceList();
        Iterator<UsbDevice> iterator = deviceHashMap.values().iterator();
        while (iterator.hasNext()) {
            UsbDevice usbDevice = iterator.next();
            int pid = usbDevice.getProductId();
            int vid = usbDevice.getVendorId();
            if (pid == IdCard.READER_PID && vid == IdCard.READER_VID) {
                return true;
            }
        }
        return false;
    }

    public void onClick_ReadIdCard(View view) {
        new IdcardTask().execute();
    }

    class IdcardTask extends AsyncTask<Void, Integer, TelpoException>{

        @Override
        protected TelpoException doInBackground(Void... voids) {
            TelpoException result = null;
            try {
                if (isUsb()){
                    IdCard.open(IdCard.IDREADER_TYPE_USB, TestActivity.this);
                }
                mIdinfo = IdCard.checkIdCard(1000);
            } catch (TelpoException e){
                result = e;
            }

            return result;
        }


        @Override
        protected void onPostExecute(TelpoException e) {
            super.onPostExecute(e);
            if (null == e && null != mIdinfo) {
                Toast.makeText(TestActivity.this, "born:" + mIdinfo.getBorn(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
