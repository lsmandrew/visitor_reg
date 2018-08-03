package com.ja.visitor_reg.common.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.ja.visitor_reg.greendao.DaoMaster;
import com.ja.visitor_reg.greendao.DaoMaster.DevOpenHelper;
import com.ja.visitor_reg.greendao.DaoSession;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import org.greenrobot.greendao.database.Database;

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

    private static Context mContent;//save content
    private static List<Activity> activityList;
    private static ApplicationUtil mInstance = null;
    private boolean ENCRYPTED = true;//是否使用加密数据库
    private DaoSession mDaoSession = null;

    public ApplicationUtil() {
        mInstance = this;
        activityList = new ArrayList<>();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mContent = getApplicationContext();
        //init greendao
        DevOpenHelper helper = new DevOpenHelper(this, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
        ////use Loger init////
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return true;
            }
        });
        Logger.d("onCreate");
    }

    /**
     * 获取session
     * @return DaoSession
     */
    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public static Context getContext(){
        return mContent;
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
        if (null == mInstance) {
            mInstance = new ApplicationUtil();
        }
        return mInstance;
    }

}
