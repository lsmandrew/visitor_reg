package com.ja.visitor_reg.config;

import com.ja.visitor_reg.common.util.ApplicationUtil;

import java.util.HashMap;
import java.util.Map;

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
    private static final Map<ENUM_IMG_TYPE, String> MAP_IMG_TYPE = new HashMap<ENUM_IMG_TYPE, String>();
    public enum ENUM_BIT_TYPE{

    }
    public enum ENUM_IMG_TYPE{
        HEAD_IMG, ID_IMG, LIVE_IMG, SCAN_IMG, GOODS_IMG
    };
    static {
        /**
         * 类型：
         * A证件头像
         * B证件照
         * C现场人像
         * D证件扫描图像
         * E携带物品
         */
        MAP_IMG_TYPE.put(ENUM_IMG_TYPE.HEAD_IMG, "A_");
        MAP_IMG_TYPE.put(ENUM_IMG_TYPE.ID_IMG, "B_");
        MAP_IMG_TYPE.put(ENUM_IMG_TYPE.LIVE_IMG, "C_");
        MAP_IMG_TYPE.put(ENUM_IMG_TYPE.SCAN_IMG, "D_");
        MAP_IMG_TYPE.put(ENUM_IMG_TYPE.GOODS_IMG, "E_");
    }

    /**
     * 获取图片保存路径
     *
     * @return String 路径
     */
    public static String get_ImgPath(){
        return ApplicationUtil.getContext().getFilesDir().getPath();
    }

    /**
     * 获取图片类型标识
     *
     * @param type 图片类型
     * @return String 标识
     */
    public static String get_ImgTypeID(ENUM_IMG_TYPE type) {
        return MAP_IMG_TYPE.get(type);
    }

}
