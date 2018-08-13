package com.ja.visitor_reg.task;

import android.os.AsyncTask;

import com.ja.visitor_reg.common.util.DBUtil;
import com.ja.visitor_reg.entity.VisitEventEntity;
import com.ja.visitor_reg.entity.VisitInfoEntity;

import java.util.Date;
import java.util.List;

/**
 * 操作数据库异步任务
 * author: lsm
 * date: 2018-8-4
 */
public class DBTask extends AsyncTask<Integer, Integer, Boolean> {

    private DBUtil mDBUtil;
    private VisitInfoEntity mVisitInfoEntity = null;
    private VisitEventEntity mVisitEventEntity = null;
    private onDBAddResultListener mAddListener = null;
    private onDBQueryResultListener mQueryListener = null;
    private onDBOutResultListener mOutListener = null;
    private List<VisitInfoEntity> mVisitInfoList;
    private int mCmd;
    private Long mVisitId;
    private Date mOutDate;

    private static final int ADD_VISIT_EVENT = 0x01;
    private static final int ADD_VISIT_INFO = 0x02;
    private static final int QUERY_VISITIN_RECORD = 0x03;
    private static final int SIGN_OUT =0x04;


    public DBTask() {
        mDBUtil = DBUtil.getInstance();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mCmd = 0;
    }

    @Override
    protected Boolean doInBackground(Integer... args) {

        mCmd = args[0];
        switch (mCmd) {
            case ADD_VISIT_INFO://添加来访信息
                mDBUtil.add_VisitInfo(mVisitInfoEntity);
                break;
            case ADD_VISIT_EVENT://添加来访事件
                mDBUtil.add_VisitEvent(mVisitEventEntity);
                break;
            case QUERY_VISITIN_RECORD://查询来访记录
                mVisitInfoList = mDBUtil.query_VisitRecord();
                break;
            case SIGN_OUT:
                mDBUtil.update_SignOut(mVisitId, mOutDate);
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
            case SIGN_OUT:
                if (null != mOutListener) {
                    mOutListener.onSignOutResult(result);
                }
                break;
        }
    }



    ///////////////////////////////回调接口/////////////////////////////////////////
    public interface onDBAddResultListener {
        void onAddResult(boolean result);
    }

    public interface onDBQueryResultListener {
        void onQueryResult(List<?> list);

    }

    public interface onDBOutResultListener {
        void onSignOutResult(boolean result);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 开始异步添加来访信息
     */
    public void start_AddVisitInfoAsync(VisitInfoEntity entity, onDBAddResultListener listener){
        mAddListener = listener;
        mVisitInfoEntity = entity;
        this.execute(ADD_VISIT_INFO);
    }

    /**
     * 开始异步添加来访事件
     */
    public void start_AddVisitEventAsync(VisitEventEntity entity, onDBAddResultListener listener) {
        mAddListener = listener;
        mVisitEventEntity = entity;
        this.execute(ADD_VISIT_EVENT);
    }

    /**
     * 查询来访登记记录
     *
     * @param listener
     */
    public void start_QueryVisitRecord(onDBQueryResultListener listener) {
        mQueryListener = listener;
        this.execute(QUERY_VISITIN_RECORD);
    }


    /**
     * 签退
     * @param id 来访信息的id
     */
    public void start_SignOut(Long id, Date outDate, onDBOutResultListener listener) {
        mOutListener = listener;
        mVisitId = id;
        mOutDate = outDate;
        this.execute(SIGN_OUT);
    }
}
