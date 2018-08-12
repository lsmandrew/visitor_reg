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
    private readIDCardListener mReadIDListener = null;
    private Activity mActivity;

    private final int CHECK_TIMEOUT = 1000;//timeout(ms)

    private IdCardReaderUtil() {
    }

    public void init_data(){
        mIdinfo = null;
        mBitmapHead = null;
    }
    public void setup_param(Activity activity, readIDCardListener listener){
        mActivity = activity;
        mReadIDListener = listener;
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

    public boolean read_Idcard(){
        //check usb
        if (!isUsbMount(mActivity)) {
            return false;
        }
        //read
        try {
            IdCard.open(IdCard.IDREADER_TYPE_USB, mActivity);
            mIdinfo = IdCard.checkIdCard(CHECK_TIMEOUT);
            if(null != mIdinfo){
                mBitmapHead = IdCard.decodeIdCardImage(mIdinfo.getHead_photo());
            }
            IdCard.close();
        } catch (TelpoException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static IdCardReaderUtil getInstance() {
        if (null == mInstance) {
            mInstance = new IdCardReaderUtil();
        }
        return mInstance;
    }

    public void post_result(Boolean result) {
        if (null != mReadIDListener){
            mReadIDListener.onReadIDCardInfo(mIdinfo, mBitmapHead);
        }
    }

    public interface readIDCardListener {
        void onReadIDCardInfo(IdentityInfo info, Bitmap bitmapHead);
    }

}
