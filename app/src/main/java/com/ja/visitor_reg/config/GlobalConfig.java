package com.ja.visitor_reg.config;

import com.ja.visitor_reg.common.util.ApplicationUtil;

/**
 * 存放全局配置
 */
public class GlobalConfig {
    //    public static final String IMG_PATH = "/data/data/package name/files";
    public static final String SOFT_VERSION = "V1.0";
    public static final String DB_NAME = "visitor_reg_secret.db";
    public static final String DB_PWD = "123456";//測試方便
    public static final int  PREVIEW_WIDTH = 640;
    public static final int  PREVIEW_HEIGHT = 480;
    public static final int  PIC_WIDTH = 640;
    public static final int  PIC_HEIGHT = 480;
    public static final String SP_SAVE_FILE = "config";
    public static final String DEFAULT_DEV_NAME = "ja-20180703-001";//方便测试
    public static final String DEFAULT_DEV_PWD = "123456";

    public static String get_ImgPath(){
        return ApplicationUtil.getContext().getFilesDir().getPath().toString();
    }
}
