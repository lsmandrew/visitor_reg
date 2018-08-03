package com.ja.visitor_reg.common.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.AsyncTask;

import com.telpo.tps550.api.TelpoException;
import com.telpo.tps550.api.idcard.IdCard;
import com.telpo.tps550.api.idcard.IdentityInfo;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 身份证阅读器工具类
 * author: lsm
 * date: 2018-7-31
 */
public class IdCardReaderUtil {
    private static IdCardReaderUtil mInstance = null;
    private IdentityInfo mIdinfo = null;
    private Bitmap mBitmapHead = null;
    private IdcardTask mTask = null;
    private readIDCardListener mReadIDListener = null;
    private final int CHECK_TIMEOUT = 1000;//ms


    private IdCardReaderUtil() {
    }

    public boolean isUsbMount(Activity activity) {
        UsbManager usbManager = (UsbManager) activity.getSystemService(Context.USB_SERVICE);
        HashMap<String, UsbDevice> deviceHashMap = usbManager.getDeviceList();
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

    /**
     * 读身份证
     *
     * @return true/false
     */
    public boolean read_idcard(Context context) {

        try {
            IdCard.open(IdCard.IDREADER_TYPE_USB, context);
        } catch (TelpoException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * 异步读卡任务
     */
    class IdcardTask extends AsyncTask<Activity, Integer, TelpoException> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mIdinfo = null;
            mBitmapHead = null;
        }

        @Override
        protected TelpoException doInBackground(Activity... activities) {
            TelpoException result = null;
            if (isUsbMount(activities[0])) {
                try {
                    IdCard.close();
                    IdCard.open(IdCard.IDREADER_TYPE_USB, activities[0]);
                    mIdinfo = IdCard.checkIdCard(CHECK_TIMEOUT);
                    if(null != mIdinfo){
                        mBitmapHead = IdCard.decodeIdCardImage(mIdinfo.getHead_photo());
                    }
                } catch (TelpoException e) {
                    e.printStackTrace();
                    result = e;
                }
            }
            return result;
        }

        @Override
        protected void onPostExecute(TelpoException e) {
            super.onPostExecute(e);
            if (null == e && null != mIdinfo) {
                ;
            } else { //fail
                mIdinfo = null;
                mBitmapHead = null;
            }
            if (null != mReadIDListener) {
                mReadIDListener.onReadIDCardInfo(mIdinfo, mBitmapHead);
            }
        }
    }

    /**
     * 开启读身份证任务
     * @param activity 当前活动
     * @param listener 读取结果监听器注册
     */
    public void start_ReadCardAsync(Activity activity, readIDCardListener listener) {
        mReadIDListener = listener;

        if (null != mTask) {
            //之前task还在运行，不创建新任务
            if (mTask.getStatus() == AsyncTask.Status.RUNNING) {
                return;
            }
        }
        mTask = new IdcardTask();

        if (mTask.getStatus() != AsyncTask.Status.RUNNING) {
            mTask.execute(activity);
        }

    }


    public static IdCardReaderUtil getInstance() {
        if (null == mInstance) {
            mInstance = new IdCardReaderUtil();
        }
        return mInstance;
    }

    public interface readIDCardListener {
        void onReadIDCardInfo(IdentityInfo info, Bitmap bitmapHead);
    }

}
