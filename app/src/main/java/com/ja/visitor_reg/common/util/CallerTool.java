package com.ja.visitor_reg.common.util;

import android.content.Context;
import android.content.Intent;

/**
 * 调用服务的工具类
 * 单例
 */
public class CallerTool {
    private CallerTool() { throw new Error("Can't not Create Instance by myself"); }

    public static boolean Start_Service(Context context, Class<?> cls){
        Intent startIntent = new Intent(context, cls);
        context.startService(startIntent);//开启服务
        return true;
    }

    public static boolean Stop_Service(Context context, Class<?> cls){
        Intent startIntent = new Intent(context, cls);
        context.stopService(startIntent);//关闭服务
        return true;
    }
}
