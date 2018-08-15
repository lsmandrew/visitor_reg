package com.ja.visitor_reg.serve;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;

import com.ja.visitor_reg.api.HttpApi;
import com.ja.visitor_reg.common.util.BitUtil;
import com.ja.visitor_reg.common.util.DBUtil;
import com.ja.visitor_reg.common.util.DateUtil;
import com.ja.visitor_reg.common.util.SharedPreferencesUtil;
import com.ja.visitor_reg.common.util.StringUtil;
import com.ja.visitor_reg.config.GlobalConfig;
import com.ja.visitor_reg.entity.VisitEventEntity;
import com.ja.visitor_reg.entity.VisitInfoEntity;
import com.ja.visitor_reg.json.LOGIN_INFO;
import com.ja.visitor_reg.json.VISITOR_INFO_UPLOAD;
import com.ja.visitor_reg.json.VISITOUT_UPLOAD;
import com.ja.visitor_reg.json.VISIT_EVENT_UPLOAD;

import java.util.List;

/**
 * 上传服务
 */
public class UploadService extends Service {

    private Thread mUploadThread = null;
    private int mStatus = 0x00;

    private static final int CMD_UPLOAD_START = 0x01;
    private static final int CMD_UPAD_END = 0x02;

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
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
        if ((null != mUploadThread) && mUploadThread.isAlive()) {
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
                        upload_Handle();
                        Thread.sleep(5000);
                    }
                } catch (InterruptedException e) {//利用异常退出
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        mUploadThread.start();
    }

    /**
     * 上传处理
     */
    private void upload_Handle() {
        switch (mStatus) {
            case 0x00://登陆
                login_DevHttp();
                mStatus = 0x01;
                break;
            case 0x01:
                upload_VisitEvent();
                mStatus = 0x02;
                break;
            case 0x02:
                upload_VisitInfo();
                mStatus = 0x03;
                break;
            case 0x03:
                upload_VisitOut();
                mStatus = 0x04;
                break;
            case 0x04:
                upload_Img();
                mStatus = 0x00;
                break;

        }
    }

    /**
     * 上传图片
     */
    private void upload_Img() {
        DBUtil dbUtil = DBUtil.getInstance();
        List<VisitInfoEntity> list = dbUtil.query_NotUploadImg(1);
        if (null == list) {return;}
        for (VisitInfoEntity item : list) {
            int isUploadMark = null == item.getIs_upload_img() ? 0 : item.getIs_upload_img();//防止null
            //判断哪一位为0代表未上传
            int nBit = BitUtil.query_BitIsZero(isUploadMark, 0, 5);
            if (nBit < 0) {//全为1
                return;
            }
            boolean result = false;
            GlobalConfig.ENUM_IMG_TYPE imgType = GlobalConfig.ENUM_IMG_TYPE.values()[nBit];
            switch (imgType) {
                case HEAD_IMG:
                    result = upload_Img(item.getImg_head());
                    break;
                case ID_IMG:
                    result = upload_Img(item.getImg_cert());
                    break;
                case LIVE_IMG:
                    result = upload_Img(item.getImg_portrait());
                    break;
                case SCAN_IMG:
                    result = upload_Img(item.getImg_scan());
                    break;
                case GOODS_IMG:
                    result = upload_Img(item.getImg_goods());
                    break;
            }
            //update
            if (result) {
                isUploadMark = BitUtil.set_BitValue(isUploadMark, imgType.ordinal());
                dbUtil.update_UploadImgSuccess(item, isUploadMark);
            }

        }
    }

    private boolean upload_Img(String imgName) {
        HttpApi client = new HttpApi();
        StringBuilder pathBuilder = new StringBuilder(GlobalConfig.get_ImgPath())
                .append("/")
                .append(imgName);
        return client.upload_ImgFile(pathBuilder.toString(), 10);
    }


    /**
     * 上传来访签退
     */
    private void upload_VisitOut() {
        DBUtil dbUtil = DBUtil.getInstance();
        List<VisitInfoEntity> list = dbUtil.query_NotUploadVisitOut(1);
        if (null == list) {return;}
        for (VisitInfoEntity item : list) {
            //http upload visitOut
            HttpApi client = new HttpApi();
            VISITOUT_UPLOAD visitout_upload = new VISITOUT_UPLOAD();
            visitout_upload.setId(item.getServer_id());
            visitout_upload.setLeaveTime(DateUtil.getDateTimeFormat(item.getOut_time()));
            if (client.upload_VisitOut(visitout_upload, 2)) {
                //update
                dbUtil.update_uploadVisitOutSuccess(item);
            }
        }
    }

    /**
     * 上传来访信息
     */
    private void upload_VisitInfo() {
        //query visit event not upload
        DBUtil dbUtil = DBUtil.getInstance();
        List<VisitInfoEntity> list = dbUtil.query_NotUploadVisitInfo(1);
        if (null == list) {return;}
        for (VisitInfoEntity item : list) {
            //http upload visitInfo
            HttpApi client = new HttpApi();
            VISITOR_INFO_UPLOAD visitor_upload = new VISITOR_INFO_UPLOAD();
            visitor_upload.setBirthday(DateUtil.getDateTimeFormat(item.getBirthday()));
            visitor_upload.setCarry(item.getGoods());
            visitor_upload.setCarryImage(item.getImg_goods());
            visitor_upload.setCensusAddr(item.getAdress());
            visitor_upload.setCertificateNum(item.getId_numer());
            visitor_upload.setCertificateType(item.getCert_type());
            visitor_upload.setEnterTime(DateUtil.getDateTimeFormat(item.getIn_time()));
            visitor_upload.setEventId(item.getVisit_event_id().toString());
            visitor_upload.setHeadImage(item.getImg_portrait());
            visitor_upload.setIcNumber(item.getIc_number());
            visitor_upload.setId(item.getId());
            visitor_upload.setIdHeadImage(item.getImg_head());
            visitor_upload.setIdScanImage(item.getImg_cert());
            visitor_upload.setIsMain((long) 0);//
            visitor_upload.setLeaveTime("");//
            visitor_upload.setNation(item.getNation());
            visitor_upload.setPhysicsNumber(item.getPhysics_number());
            visitor_upload.setSex(Long.parseLong(item.getSex_type()));
            visitor_upload.setVehicleNumber(item.getCar_number());
            visitor_upload.setVisitorPhone(item.getPhone());
            visitor_upload.setVisitorUnit(item.getCompany());
            visitor_upload.setVistorName(item.getVisitor_name());
            int visitId = client.upload_VisitInfo(visitor_upload, 2);
            if (visitId > 0) {
                //update
                item.setServer_id((long) visitId);
                dbUtil.update_UploadVisitorSuccess(item);
            }
        }
    }

    /**
     * 上传来访事件
     */
    private void upload_VisitEvent() {
        //query visit event not upload
        DBUtil dbUtil = DBUtil.getInstance();
        List<VisitEventEntity> list = dbUtil.query_NotUploadEvent(1);
        if (null == list) {return;}
        for (VisitEventEntity item : list) {
            //http upload
            HttpApi client = new HttpApi();
            VISIT_EVENT_UPLOAD event_upload = new VISIT_EVENT_UPLOAD();
            event_upload.setCauseId(item.getCauseId());
            event_upload.setDeviceId(item.getDeviceId());
            event_upload.setId(item.getId());
            event_upload.setShifitId(null);//?
            event_upload.setVisitorCount(Long.valueOf(item.getVisitorCount()));
            event_upload.setInsetTime(DateUtil.getDateTimeFormat(item.getInsetTime()));
            event_upload.setIsOrder((long) item.getIsOrder());
            event_upload.setOrderPhone(item.getOrderPhone());
            int eventId = client.upload_VisitEvent(event_upload, 5000);
            if (eventId > 0) {
                //update
                item.setServerId((long) eventId);
                dbUtil.update_UploadEventSuccess(item);
            }
        }
    }

    /**
     * 设备登录
     */
    private void login_DevHttp() {
        //check token is empty
        if (StringUtil.isEmptyTrimed(HttpApi.TOKEN)) {
            //login
            HttpApi client = new HttpApi();
            LOGIN_INFO login_info = new LOGIN_INFO();
            SharedPreferencesUtil spUtil = SharedPreferencesUtil.getInstance();
            login_info.setDeviceName((String) spUtil.get("devName", ""));
            login_info.setPassword((String) spUtil.get("devPwd", ""));
            client.login_Request(login_info, 2);
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
