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
import com.ja.visitor_reg.common.util.ApplicationUtil;
import com.ja.visitor_reg.entity.VisitEventEntity;
import com.ja.visitor_reg.greendao.DaoSession;
import com.ja.visitor_reg.greendao.VisitEventEntityDao;
import com.ja.visitor_reg.json.LOGIN_INFO;
import com.orhanobut.logger.Logger;
import com.telpo.tps550.api.TelpoException;
import com.telpo.tps550.api.idcard.IdCard;
import com.telpo.tps550.api.idcard.IdentityInfo;

import org.greenrobot.greendao.query.Query;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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

    public void onClick_TestGreenDao(View view) {
        new GreenDaoTask().execute();
    }

    class GreenDaoTask extends AsyncTask<Void, Integer, Boolean> {
        private VisitEventEntityDao mEventDao;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            DaoSession daoSession = ApplicationUtil.getInstance().getDaoSession();
            mEventDao = daoSession.getVisitEventEntityDao();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            //insert
            insert_EventEntity();
            //del
            //del_EventEntity();
            //update
            update_EventEntity();
            //query
            query_EventEntity();
            return  true;
        }

        @Override
        protected void onPostExecute(Boolean b) {
            super.onPostExecute(b);
        }

        //EventEntity Insert
        private void insert_EventEntity() {
            VisitEventEntity event = new VisitEventEntity();
            event.setCauseId((long) 1);//来访事由
            event.setIntervieweeId((long) 1);//受访者
            event.setShifitId((long) 1);//班次id(保安)
            event.setDeviceId((long) 1);
            //登记设备
            event.setVisitorCount(1);//来访人数
            event.setInsetTime(new Date());//事件时间
            event.setIs_upload(0);//是否已上传(0未,1已)
            mEventDao.insert(event);
            Logger.d("insert event entity");
        }

        //EventEntity Del
        private void del_EventEntity() {
            mEventDao.deleteByKey((long) 1);
            Logger.d("del event entity");
        }

        //EventEntity Query
        private void query_EventEntity() {
            Query<VisitEventEntity> eventQuery;
            eventQuery = mEventDao.queryBuilder().orderAsc(VisitEventEntityDao.Properties.InsetTime).build();
            //get query data
            Logger.d("query data");
            List<VisitEventEntity> events = eventQuery.list();
            for (VisitEventEntity eventItem : events){
                Logger.d(eventItem);
            }
        }
        //EventEntity Update
        private void update_EventEntity() {
            //query
            Query<VisitEventEntity> eventQuery;
            eventQuery = mEventDao.queryBuilder().where(VisitEventEntityDao.Properties.Id.eq(3)).build();
            VisitEventEntity event = eventQuery.unique();
            //update
            if (null != event) {
                event.setIs_upload(1);
                mEventDao.update(event);
            }
            Logger.d("update data");
        }

    }

    class IdcardTask extends AsyncTask<Void, Integer, TelpoException> {

        @Override
        protected TelpoException doInBackground(Void... voids) {
            TelpoException result = null;
            try {
                if (isUsb()) {
                    IdCard.open(IdCard.IDREADER_TYPE_USB, TestActivity.this);
                }
                mIdinfo = IdCard.checkIdCard(1000);
            } catch (TelpoException e) {
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
