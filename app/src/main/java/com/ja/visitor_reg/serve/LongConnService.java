package com.ja.visitor_reg.serve;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

/**
 * 长连接服务
 */
public class LongConnService extends Service {
    private static  final int CMD_LONG_START = 0x10;
    private static  final int CMD_LONG_END = 0x11;
    private Thread longThread = null;

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case CMD_LONG_START:
                    Start_LongThread();
                    break;
                case CMD_LONG_END:
                    CloseForce_LongThread();
                    break;
                default:
                    break;
            }
            return true;
        }
    });

    private void CloseForce_LongThread() {
        if ((null != longThread) && longThread.isAlive()){
            longThread.interrupt();
        }
        longThread = null;
    }

    private void Start_LongThread() {
        longThread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    //while (true){
                    while (!Thread.currentThread().isInterrupted()){

                        ////do something....
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }

            }
        });
        longThread.start();
    }

    public LongConnService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //get some info
        sendMsg(handler, CMD_LONG_START, 500);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        sendMsg(handler, CMD_LONG_END, 500);
        super.onDestroy();
    }

    private static void sendMsg(Handler handler, int number, long delayedTime) {
        Message msg = new Message();
        msg.what = number;
        handler.sendMessageDelayed(msg, delayedTime);
    }
}
