package com.ja.visitor_reg.common.util;

import android.graphics.Bitmap;
/**
 * 二維碼工具类
 */
public class QRUtil {

    /**
     * 生成二维码图像
     * @param data 二维码内容
     * @return Bitmap图像
     */
    public static Bitmap create_QRImg(String data){
        Bitmap bitmap = null;
//        BitMatrix result = null;
//        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
//        try {
//            result = multiFormatWriter.encode(data, BarcodeFormat.QR_CODE, 400, 400);
//            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
//            bitmap = barcodeEncoder.createBitmap(result);
//        } catch (WriterException e){
//            e.printStackTrace();
//            return null;
//        } catch (IllegalArgumentException iae){ // ?
//            return null;
//        }
        return bitmap;
    }


}
