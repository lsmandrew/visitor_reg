package com.ja.visitor_reg.serve;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;

import com.ja.visitor_reg.api.HttpApi;
import com.ja.visitor_reg.common.util.DBUtil;
import com.ja.visitor_reg.entity.VisitEventEntity;
import com.ja.visitor_reg.json.VISIT_EVENT_UPLOAD;

import java.util.List;

/**
 * 上传服务
 */
public class UploadService extends Service{


    private Thread mUploadThread = null;

    private static final int CMD_UPLOAD_START = 0x01;
    private static final int CMD_UPAD_END = 0x02;

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case CMD_UPLOAD_START:
                    Start_UploadThread();
                    break;
                case CMD_UPAD_END:
                    CloseForce_UploadThread();
                    break;
                default:
                    break;
            }
            return true;
        }
    });

    private void CloseForce_UploadThread() {
        if ((null != mUploadThread) && mUploadThread.isAlive()){
            mUploadThread.interrupt();
        }
        mUploadThread = null;
    }

    private void Start_UploadThread() {
        mUploadThread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    //while (true){
                    while (!Thread.currentThread().isInterrupted()) {
                        upload_VisitEvent();

                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        mUploadThread.start();
    }

    private void upload_VisitEvent() {
        //query visit event not upload
        DBUtil dbUtil = DBUtil.getInstance();
        List<VisitEventEntity> eventLists = dbUtil.query_NotUploadEvent(1);
        for (VisitEventEntity item : eventLists) {
            //http upload
            HttpApi client = new HttpApi();
            VISIT_EVENT_UPLOAD event_upload = new VISIT_EVENT_UPLOAD();
            event_upload.setCauseId(item.getCauseId());
            event_upload.setDeviceId(item.getDeviceId());
            event_upload.setId(item.getId());
            client.upload_VisitEvent(event_upload, 5000);
        }
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //开启上传服务线程
        sendMsg(handler, CMD_UPLOAD_START, 500);
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        sendMsg(handler, CMD_UPAD_END, 0);
        super.onDestroy();
    }


    private static void sendMsg(Handler handler, int number, long delayedTime) {
        Message msg = new Message();
        msg.what = number;
        handler.sendMessageDelayed(msg, delayedTime);
    }

}
