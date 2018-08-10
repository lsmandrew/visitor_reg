package com.ja.visitor_reg.task;

import android.os.AsyncTask;

import com.ja.visitor_reg.common.util.ApplicationUtil;
import com.ja.visitor_reg.entity.VisitEventEntity;
import com.ja.visitor_reg.entity.VisitInfoEntity;
import com.ja.visitor_reg.greendao.DaoSession;
import com.ja.visitor_reg.greendao.VisitEventEntityDao;
import com.ja.visitor_reg.greendao.VisitInfoEntityDao;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * 操作数据库任务
 * author: lsm
 * date: 2018-8-4
 */
public class DBTask {
    private static final int ADD_VISIT_EVENT = 0x01;
    private static final int ADD_VISIT_INFO = 0x02;
    private static final int QUERY_VISITIN_RECORD = 0x03;

    private static DBTask mInstance = null;
    private DBTask.DoAsynTask mTask = null;
    private VisitInfoEntity mVisitInfoEntity = null;
    private VisitEventEntity mVisitEventEntity = null;
    private onDBAddResultListener mAddListener = null;
    private onDBQueryResultListener mQueryListener = null;

    private DBTask() {}

    /**
     * 异步操作
     */
    class DoAsynTask extends AsyncTask<Integer, Integer, Boolean> {
        private VisitEventEntityDao mEventDao;
        private VisitInfoEntityDao mVisitInfoDao;
        private List<VisitInfoEntity> mVisitInfoList;
        private int mCmd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            DaoSession daoSession = ApplicationUtil.getInstance().getDaoSession();
            mEventDao = daoSession.getVisitEventEntityDao();
            mVisitInfoDao = daoSession.getVisitInfoEntityDao();
            mCmd = 0;

        }

        @Override
        protected Boolean doInBackground(Integer... args) {

            mCmd = args[0];
            switch (mCmd) {
                case ADD_VISIT_INFO:
                    //添加来访信息
                    add_VisitInfo();
                    break;
                case ADD_VISIT_EVENT:
                    add_VisitEvent();
                    break;
                case QUERY_VISITIN_RECORD:
                    query_VisitRecord();
                    break;
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            switch (mCmd) {
                case ADD_VISIT_INFO:
                case ADD_VISIT_EVENT:
                    if (null != mAddListener) {
                        mAddListener.onAddResult(result);
                    }
                    break;
                case QUERY_VISITIN_RECORD:
                    if (null != mQueryListener) {
                        mQueryListener.onQueryResult(mVisitInfoList);
                    }
                    break;
            }


        }

        /**
         * 添加来访信息
         */
        private void add_VisitInfo() {
            if (null != mVisitInfoEntity) {
                mVisitInfoDao.insert(mVisitInfoEntity);
            }

            Logger.d("insert visit entity");
        }

        /**
         * 添加來訪事件
         */
        private void add_VisitEvent() {
            if (null != mVisitEventEntity) {
                mEventDao.insert((mVisitEventEntity));
            }

            Logger.d("insert visit event");
        }

        /**
         * 查询来访记录
         */
        private void query_VisitRecord() {
                    mVisitInfoList = mVisitInfoDao.queryBuilder()
                    .where(VisitInfoEntityDao.Properties.Out_time.isNull())
                    .build().list();

            Logger.d("query visit reocrd");
        }

    }


    public interface onDBAddResultListener{
        void onAddResult(boolean result);
    }

    public interface onDBQueryResultListener {
        void onQueryResult(List<?> list);
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
    public void start_AddVisitInfoAsync(VisitInfoEntity entity, onDBAddResultListener listener) {
        mVisitInfoEntity = entity;
        mAddListener = listener;

        mTask = new DoAsynTask();
        if (null != mTask) {
            mTask.execute(ADD_VISIT_INFO);
        }
    }
    /**
     * 开始异步添加来访信息
     */
    public void start_AddVisitEventAsync(VisitEventEntity entity, onDBAddResultListener listener) {
        mVisitEventEntity = entity;
        mAddListener = listener;

        mTask = new DoAsynTask();
        if (null != mTask) {
            mTask.execute(ADD_VISIT_EVENT);
        }
    }

    /**
     * 查询来访登记记录
     * @param listener
     */
    public void start_QueryVisitRecord(onDBQueryResultListener listener){
        mQueryListener = listener;

        mTask = new DoAsynTask();
        if (null != mTask) {
            mTask.execute(QUERY_VISITIN_RECORD);
        }
    }


}
