package com.ja.visitor_reg.common.util;

import android.app.Activity;
import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;

import com.telpo.tps550.api.idcard.IdCard;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 身份证阅读器工具类
 * author: lsm
 * date: 2018-7-31
 */
public class IdCardReaderUtil {
    private Activity activity;

    public boolean isUsbMount() {
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
     * @return true/false
     */
    public boolean read_idcard(){
        if (isUsbMount()){

        }
        return false;
    }

}
