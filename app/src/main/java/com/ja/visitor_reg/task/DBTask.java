package com.ja.visitor_reg.task;

import android.os.AsyncTask;

import com.ja.visitor_reg.common.util.ApplicationUtil;
import com.ja.visitor_reg.entity.VisitInfoEntity;
import com.ja.visitor_reg.greendao.DaoSession;
import com.ja.visitor_reg.greendao.VisitEventEntityDao;
import com.ja.visitor_reg.greendao.VisitInfoEntityDao;
import com.orhanobut.logger.Logger;

/**
 * 操作数据库任务
 * author: lsm
 * date: 2018-8-4
 */
public class DBTask {
    private static DBTask mInstance = null;
    private DBTask.DoAsynTask mTask = null;
    private VisitInfoEntity mVisitInfoEntity = null;
    private onDBResultListener mListener = null;
    private DBTask() {}

    /**
     * 异步操作
     */
    class DoAsynTask extends AsyncTask<Void, Integer, Boolean> {
        private VisitEventEntityDao mEventDao;
        private VisitInfoEntityDao mVisitInfoDao;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            DaoSession daoSession = ApplicationUtil.getInstance().getDaoSession();
            mEventDao = daoSession.getVisitEventEntityDao();
            mVisitInfoDao = daoSession.getVisitInfoEntityDao();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            //添加来访信息
            add_VisitInfo();
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            if (null != mListener) {
                mListener.onResult(result);
            }
        }

        /**
         * 添加来访信息
         */
        private  void add_VisitInfo(){
            if (null != mVisitInfoEntity){
                mVisitInfoDao.insert(mVisitInfoEntity);
            }

            Logger.d("insert visit entity");
        }

    }

    public interface onDBResultListener{
        void onResult(boolean result);
    }

    /**
     * 获取实例
     *
     * @return 实例
     */
    public static DBTask getInstance() {
        if (null == mInstance) {
            mInstance = new DBTask();
        }
        return mInstance;
    }


    /**
     * 开始异步添加来访信息
     */
    public void start_AddVisitInfoAsync(VisitInfoEntity entity, onDBResultListener listener) {
        mVisitInfoEntity = entity;
        mListener = listener;

        mTask = new DoAsynTask();
        if (null != mTask) {
            mTask.execute();
        }
    }




}
