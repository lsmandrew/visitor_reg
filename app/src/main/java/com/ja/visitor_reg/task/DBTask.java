package com.ja.visitor_reg.task;

import android.os.AsyncTask;

import com.ja.visitor_reg.common.util.ApplicationUtil;
import com.ja.visitor_reg.entity.VisitEventEntity;
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
    private static final int ADD_VISIT_EVENT = 0x01;
    private static final int ADD_VISIT_INFO = 0x02;

    private static DBTask mInstance = null;
    private DBTask.DoAsynTask mTask = null;
    private VisitInfoEntity mVisitInfoEntity = null;
    private VisitEventEntity mVisitEventEntity = null;
    private onDBResultListener mListener = null;
    private DBTask() {}

    /**
     * 异步操作
     */
    class DoAsynTask extends AsyncTask<Integer, Integer, Boolean> {
        private VisitEventEntityDao mEventDao;
        private VisitInfoEntityDao mVisitInfoDao;
        private long mId;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            DaoSession daoSession = ApplicationUtil.getInstance().getDaoSession();
            mEventDao = daoSession.getVisitEventEntityDao();
            mVisitInfoDao = daoSession.getVisitInfoEntityDao();
        }

        @Override
        protected Boolean doInBackground(Integer... args) {

            switch (args[0]) {
                case ADD_VISIT_INFO:
                    //添加来访信息
                    add_VisitInfo();
                    break;
                case ADD_VISIT_EVENT:
                    add_VisitEvent();
                    break;
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            if (null != mListener) {
                mListener.onAddResult(result, mId);
            }
        }

        /**
         * 添加来访信息
         */
        private void add_VisitInfo() {
            if (null != mVisitInfoEntity) {
                mId = mVisitInfoDao.insert(mVisitInfoEntity);
            }

            Logger.d("insert visit entity");
        }

        /**
         * 添加來訪事件
         */
        private void add_VisitEvent() {
            if (null != mVisitEventEntity) {
                mId = mEventDao.insert((mVisitEventEntity));
            }

            Logger.d("insert visit event");
        }

    }

    public interface onDBResultListener{
        void onAddResult(boolean result, long id);

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
            mTask.execute(ADD_VISIT_INFO);
        }
    }
    /**
     * 开始异步添加来访信息
     */
    public void start_AddVisitEventAsync(VisitEventEntity entity, onDBResultListener listener) {
        mVisitEventEntity = entity;
        mListener = listener;

        mTask = new DoAsynTask();
        if (null != mTask) {
            mTask.execute(ADD_VISIT_EVENT);
        }
    }



}
