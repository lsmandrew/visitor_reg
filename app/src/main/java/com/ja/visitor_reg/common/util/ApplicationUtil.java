package com.ja.visitor_reg.common.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;


/**
 * 管理应用程序的全局状态
 * 1. Activity管理（多Activity间共享数据）全局单例
 * 2. debug状态,打印 log
 * 3. 崩溃日志收集器
 * author: lsm
 * data: 2018-7-12
 */
public class ApplicationUtil extends Application {

    private static Context m_Content;//save content
    private List<Activity> activityList = new ArrayList<>();
    private static ApplicationUtil instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        m_Content = getApplicationContext();
        ////use Loger init////
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return true;
            }
        });
        Logger.d("onCreate");
    }

    public static Context getContext(){
        return m_Content;
    }

    ///////////////////Activity 管理////////////////////
    public  void addActivity(Activity activity) {
            activityList.add(activity);
        }

    public  void removeActivity(Activity activity){
            activityList.remove(activity);
        }

    public  void removeAll(){
        for (Activity activity: activityList) {
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }

    /**
     * 单例模式中获取唯一的Application实例
     **/
    public static synchronized ApplicationUtil getInstance() {
        if (null == instance) {
            instance = new ApplicationUtil();
        }
        return instance;
    }

}
